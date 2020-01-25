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
public class DaoAtividade extends Dao {
    
    @Override
    public String salvar(EntidadeDominio entidade) {
        Connection conexao;
        String mensagemAti;
        String mensagem = "";
        try {
            conexao = BancoDadosPostgres.getConexao();
            Atividade ati = (Atividade) entidade;
            mensagemAti = inserir(ati, conexao);
            conexao.close();

            mensagem = mensagemAti;
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

        Atividade ati = (Atividade) entidade;
        List lista = new ArrayList();
        List<Atividade> atividades = new ArrayList<>();

        //buscar por ID
        if (ati.getId() > 0) {
            Atividade atividade = (Atividade) consultarPorId(ati.getId(), ati);
            atividades.add(atividade);

            lista = atividades;
            return lista;
            //bsucar pelo parâmetro digitado    
        } else if (ati.getBusca() != null) {
            try {
                /*
                id integer NOT NULL,
                ati_nome character varying(255),
                ati_descricao character varying(255),
                ati_status character varying(255),
                 */
                //abre a conexão
                Connection con = BancoDadosPostgres.getConexao();
                String sql = " SELECT  * FROM ATIVIDADE "
                        + "WHERE "
                        + " ati_nome LIKE  '%" + ati.getBusca() + "%' "
                        + " OR  ati_descricao LIKE  '%" + ati.getBusca() + "%' "
                        + " OR  ati_status LIKE '%" + ati.getBusca() + "%' ";
                PreparedStatement pst;
                pst = con.prepareStatement(sql);
                ResultSet rs;
                rs = pst.executeQuery();
                while (rs.next()) {
                    Atividade a = new Atividade();
                    a.setId(rs.getInt("id"));
                    a.setAti_nome(rs.getString("ati_nome"));
                    a.setAti_descricao(rs.getString("ati_descricao"));
                    a.setAti_status(rs.getString("ati_status"));
                    atividades.add(a);
                }//while
                //fecha a conexao
                con.close();

                lista = atividades;
                return lista;
            } catch (ClassNotFoundException ex) {
                return lista;
            } catch (SQLException ex) {
                return lista;
            }
            //consultar Todos 
        } else {
            atividades = (List) consultarTodos(ati);

            List<Atividade> ativos = new ArrayList();
            //separar oque estiver inativo
            for (Atividade a : atividades) {
                if (a.getAti_status() != null) {
                    if (!a.getAti_status().equals("Inativo")) {
                        ativos.add(a);
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
        String mensagemAti;

        String mensagem = "";
        //conexao = BancoDadosPostgres.getConexao();
        Atividade ati = (Atividade) entidade;
        mensagemAti = alterarGeral(ati);
        //mensagemCon = alterarGeral(cli.getCli_contrato());
        //conexao.close();

        mensagem = mensagemAti;
        return mensagem;
    }

    @Override
    public List<EntidadeDominio> excluir(EntidadeDominio entidade
    ) {
        Atividade ati = (Atividade) entidade;
        String editar = "UPDATE atividade SET ati_status = ? WHERE id = ?";
        Connection con;
        try {
            con = BancoDadosPostgres.getConexao();
            PreparedStatement ps = con.prepareStatement(editar);
            ps.setString(1, "Inativo");
            ps.setInt(2, ati.getId());
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        ati.setBusca(null);
        ati.setId(0);
        return consultar(ati);
    }

}
