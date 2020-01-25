/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.dao;

import br.com.podechamar.dao.core.BancoDadosPostgres;
import br.com.podechamar.dao.core.Dao;
import br.com.podechamar.dominio.Departamento;
import br.com.podechamar.dominio.Historico;
import br.com.podechamar.dominio.core.EntidadeDominio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio Cesar Alves
 */
public class DaoLog extends Dao {

    @Override
    public String salvar(EntidadeDominio entidade) {
        Connection conexao;
        String mensagemLog;
        String mensagem = "";
        try {
            conexao = BancoDadosPostgres.getConexao();
            Historico his = (Historico) entidade;
            mensagemLog = inserir(his, conexao);
            conexao.close();

            mensagem = mensagemLog;
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

        Historico his = (Historico) entidade;
        List lista = new ArrayList();
        List<Historico> historicos = new ArrayList<>();

        //buscar por ID
        if (his.getId() > 0) {
            Historico historico = (Historico) consultarPorId(his.getId(), his);
            historicos.add(historico);

            lista = historicos;
            return lista;
            //bsucar pelo parâmetro digitado    
        } else if (his.getBusca() != null) {
            try {
                /*
                    id serial NOT NULL,
                    his_usuario character varying(255),
                    his_valoranterior character varying(255),
                    his_operacao character varying(255),
                    his_dataalteracao character varying(255),
                 */
                //abre a conexão
                Connection con = BancoDadosPostgres.getConexao();
                String sql = " SELECT  * FROM historico "
                        + "WHERE "
                        + " his_usuario LIKE  '%" + his.getBusca() + "%' "
                        + " OR  his_valoranterior LIKE  '%" + his.getBusca() + "%' "
                        + " OR  his_operacao LIKE  '%" + his.getBusca() + "%' "
                        + " OR  his_entidade LIKE  '%" + his.getBusca() + "%' "
                        + " OR  his_id LIKE  '%" + his.getBusca() + "%' "
                        + " OR  his_dataalteracao LIKE '%" + his.getBusca() + "%' ";
                PreparedStatement pst;
                pst = con.prepareStatement(sql);
                ResultSet rs;
                rs = pst.executeQuery();
                while (rs.next()) {
                    Historico h = new Historico();
                    h.setId(rs.getInt("id"));
                    h.setHis_usuario(rs.getString("his_usuario"));
                    h.setHis_valoranterior(rs.getString("his_valoranterior"));
                    h.setHis_operacao(rs.getString("his_operacao"));
                    h.setHis_entidade(rs.getString("his_entidade"));
                    h.setHis_id(rs.getString("his_id"));
                    h.setHis_dataalteracao(rs.getString("his_dataalteracao"));
                    historicos.add(h);
                }//while
                //fecha a conexao
                con.close();

                lista = historicos;
                return lista;
            } catch (ClassNotFoundException ex) {
                return lista;
            } catch (SQLException ex) {
                return lista;
            }
            //consultar Todos 
        } else {
            historicos = (List) consultarTodos(his);
            lista = historicos;
            return lista;
        }
    }//fim  do consultar

    @Override
    public String alterar(EntidadeDominio entidade) {
        String mensagemHis;

        String mensagem = "";
        Historico his = (Historico) entidade;
        mensagemHis = alterarGeral(his);

        mensagem = mensagemHis;
        return mensagem;
    }

    @Override
    public List<EntidadeDominio> excluir(EntidadeDominio entidade) {
       return null;
    }
}
