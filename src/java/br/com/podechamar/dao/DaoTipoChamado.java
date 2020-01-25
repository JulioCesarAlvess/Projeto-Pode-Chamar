/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.dao;

import br.com.podechamar.dao.core.BancoDadosPostgres;
import br.com.podechamar.dao.core.Dao;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leofa
 */
public class DaoTipoChamado extends Dao {
    
    
    @Override
    public String salvar(EntidadeDominio entidade) {
        Connection conexao;
        String mensagemTipo;
        String mensagem = "";
        try {
            conexao = BancoDadosPostgres.getConexao();
           TipoChamado tipo = (TipoChamado) entidade;
            mensagemTipo = inserir(tipo, conexao);
            conexao.close();

            mensagem = mensagemTipo;
        } catch (ClassNotFoundException ex) {
            mensagem = ex.toString();
        } catch (SQLException ex) {
            mensagem = ex.toString();
        }
        return mensagem;
    }//fim do iserir

    //consultar
    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {

        TipoChamado t = (TipoChamado) entidade;
        List lista = new ArrayList();
        List<TipoChamado> tipos = new ArrayList<>();

        //buscar por ID
        if (t.getId() > 0) {
            TipoChamado tipo = (TipoChamado) consultarPorId(t.getId(), t);
            tipos.add(tipo);

            lista = tipos;
            return lista;
            //bsucar pelo parâmetro digitado    
        } else if (t.getBusca() != null) {
            try {
                /*
                  id integer NOT NULL,
                  tch_nome character varying(255),
                  tch_descricao character varying(255),
                  tch_status character varying(255),
                  tch_normal double precision,
                  tch_urgente double precision,
                  tch_critico double precision
                 */
                //abre a conexão
                Connection con = BancoDadosPostgres.getConexao();
                String sql = " SELECT  * FROM TIPOCHAMADO "
                        + "WHERE "
                        + " tch_nome LIKE  '%" + t.getBusca() + "%' "
                        + " OR  tch_descricao LIKE  '%" + t.getBusca() + "%' "
                        + " OR  tch_status LIKE '%" + t.getBusca() + "%' "
                        + " OR  CAST(tch_normal as text) LIKE  '%" + t.getBusca() + "%' "
                        + " OR  CAST(tch_urgente as text) LIKE  '%" + t.getBusca() + "%' "
                        + " OR  CAST(tch_critico as text) LIKE  '%" + t.getBusca() + "%' ";
                
                PreparedStatement pst;
                pst = con.prepareStatement(sql);
                ResultSet rs;
                rs = pst.executeQuery();
                while (rs.next()) {
                   TipoChamado ti = new TipoChamado();
                    ti.setId(rs.getInt("id"));
                    ti.setTch_nome(rs.getString("tch_nome"));
                    ti.setTch_descricao(rs.getString("tch_descricao"));
                    ti.setTch_status(rs.getString("tch_status"));
                    ti.setTch_normal(rs.getDouble("tch_normal"));
                    ti.setTch_urgente(rs.getDouble("tch_urgente"));
                    ti.setTch_critico(rs.getDouble("tch_critico"));
                    tipos.add(ti);
                }//while
                //fecha a conexao
                con.close();

                lista = tipos;
                return lista;
            } catch (ClassNotFoundException ex) {
                return lista;
            } catch (SQLException ex) {
                return lista;
            }
            //consultar Todos 
        } else {
            tipos = (List) consultarTodos(t);

            List<TipoChamado> ativos = new ArrayList();
            //separar oque estiver inativo
            for (TipoChamado ch : tipos) {
                if (ch.getTch_status()!= null) {
                    if (!ch.getTch_status().equals("Inativo")) {
                        ativos.add(ch);
                    }
                }
            }
            lista = ativos;
            //lista = clientes;
            return lista;
        }
    }//fim  do consultar

    @Override
    public String alterar(EntidadeDominio entidade
    ) {
        String mensagemTipo;

        String mensagem = "";
        //conexao = BancoDadosPostgres.getConexao();
        TipoChamado tipo = (TipoChamado) entidade;
        mensagemTipo = alterarGeral(tipo);
        //mensagemCon = alterarGeral(cli.getCli_contrato());
        //conexao.close();

        mensagem = mensagemTipo;
        return mensagem;
    }

    @Override
    public List<EntidadeDominio> excluir(EntidadeDominio entidade
    ) {
        TipoChamado tipo = (TipoChamado) entidade;
        String editar = "UPDATE tipochamado SET tch_status = ? WHERE id = ?";
        Connection con;
        try {
            con = BancoDadosPostgres.getConexao();
            PreparedStatement ps = con.prepareStatement(editar);
            ps.setString(1, "Inativo");
            ps.setInt(2, tipo.getId());
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        tipo.setBusca(null);
        tipo.setId(0);
        return consultar(tipo);
    }

}
