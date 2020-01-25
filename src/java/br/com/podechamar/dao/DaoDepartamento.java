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
public class DaoDepartamento extends Dao{
    
    @Override
    public String salvar(EntidadeDominio entidade) {
        Connection conexao;
        String mensagemDep;
        String mensagem = "";
        try {
            conexao = BancoDadosPostgres.getConexao();
            Departamento dep = (Departamento) entidade;
            mensagemDep = inserir(dep, conexao);
            conexao.close();

            mensagem = mensagemDep;
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

        Departamento dep = (Departamento) entidade;
        List lista = new ArrayList();
        List<Departamento> departamentos = new ArrayList<>();

        //buscar por ID
        if (dep.getId() > 0) {
           Departamento departamento = (Departamento) consultarPorId(dep.getId(), dep);
            departamentos.add(departamento);

            lista = departamentos;
            return lista;
            //bsucar pelo parâmetro digitado    
        } else if (dep.getBusca() != null) {
            try {
                /*
                id integer NOT NULL,
                ati_nome character varying(255),
                ati_descricao character varying(255),
                ati_status character varying(255),
                 */
                //abre a conexão
                Connection con = BancoDadosPostgres.getConexao();
                String sql = " SELECT  * FROM DEPARTAMENTO "
                        + "WHERE "
                        + " dep_nome LIKE  '%" + dep.getBusca() + "%' "
                        + " OR  dep_descricao LIKE  '%" + dep.getBusca() + "%' "
                        + " OR  dep_status LIKE '%" + dep.getBusca() + "%' ";
                PreparedStatement pst;
                pst = con.prepareStatement(sql);
                ResultSet rs;
                rs = pst.executeQuery();
                while (rs.next()) {
                    Departamento d = new Departamento();
                    d.setId(rs.getInt("id"));
                    d.setDep_nome(rs.getString("dep_nome"));
                    d.setDep_descricao(rs.getString("dep_descricao"));
                    d.setDep_status(rs.getString("dep_status"));
                    departamentos.add(d);
                }//while
                //fecha a conexao
                con.close();

                lista = departamentos;
                return lista;
            } catch (ClassNotFoundException ex) {
                return lista;
            } catch (SQLException ex) {
                return lista;
            }
            //consultar Todos 
        } else {
            departamentos = (List) consultarTodos(dep);

            List<Departamento> ativos = new ArrayList();
            //separar oque estiver inativo
            for (Departamento d : departamentos) {
                if (d.getDep_status() != null) {
                    if (!d.getDep_status().equals("Inativo")) {
                        ativos.add(d);
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
        String mensagemDep;

        String mensagem = "";
        //conexao = BancoDadosPostgres.getConexao();
        Departamento dep = (Departamento) entidade;
        mensagemDep = alterarGeral(dep);
        //mensagemCon = alterarGeral(cli.getCli_contrato());
        //conexao.close();

        mensagem = mensagemDep;
        return mensagem;
    }

    @Override
    public List<EntidadeDominio> excluir(EntidadeDominio entidade
    ) {
       Departamento dep = (Departamento) entidade;
        String editar = "UPDATE departamento SET dep_status = ? WHERE id = ?";
        Connection con;
        try {
            con = BancoDadosPostgres.getConexao();
            PreparedStatement ps = con.prepareStatement(editar);
            ps.setString(1, "Inativo");
            ps.setInt(2, dep.getId());
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        dep.setBusca(null);
        dep.setId(0);
        return consultar(dep);
    }
}
