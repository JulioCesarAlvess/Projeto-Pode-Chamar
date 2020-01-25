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
public class DaoFuncionarios extends Dao {

    @Override
    public String salvar(EntidadeDominio entidade) {
        Connection conexao;
        String mensagemFun;
        String mensagem = "";
        try {
            conexao = BancoDadosPostgres.getConexao();
            Funcionario fun = (Funcionario) entidade;
            mensagemFun = inserir(fun, conexao);
            
            String sql = "INSERT INTO usuario (usu_login, usu_senha, usu_papel, usu_id_owner, usu_dep)" +
            "VALUES (? , ?, ?, currval('funcionario_seq'), ? )";
            
            //salvar o usuario do funcionario
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, fun.getUsu().getUsu_login());
            ps.setString(2, fun.getUsu().getUsu_senha());
            ps.setString(3, fun.getUsu().getUsu_papel());
            ps.setInt(4, fun.getUsu().getUsu_dep());
            ps.executeUpdate();
            
            conexao.close();

            mensagem = mensagemFun;
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

        Funcionario fun = (Funcionario) entidade;
        List lista = new ArrayList();
        List<Funcionario> funcionarios = new ArrayList<>();

        //buscar por ID
        if (fun.getId() > 0) {
            Funcionario funcionario = (Funcionario) consultarPorId(fun.getId(), fun);
            funcionarios.add(funcionario);

            lista = funcionarios;
            return lista;
            //bsucar pelo parâmetro digitado    
        } else if (fun.getBusca() != null) {
            try {
                Connection con = BancoDadosPostgres.getConexao();
                String sql = " SELECT  * FROM FUNCIONARIO "
                        + "WHERE "
                        + " fun_nome LIKE  '%" + fun.getBusca() + "%' "
                        + " OR  fun_nf LIKE  '%" + fun.getBusca() + "%' "
                        + " OR  fun_nivel LIKE '%" + fun.getBusca() + "%' "
                        + " OR  fun_email LIKE  '%" + fun.getBusca() + "%' "
                        + " OR  fun_telefone LIKE  '%" + fun.getBusca() + "%' "
                        + " OR  fun_cpf LIKE  '%" + fun.getBusca() + "%' "
                        + " OR  fun_login LIKE  '%" + fun.getBusca() + "%' "
                        + " OR  fun_status LIKE  '%" + fun.getBusca() + "%' ";
                PreparedStatement pst;
                pst = con.prepareStatement(sql);
                ResultSet rs;
                rs = pst.executeQuery();
                while (rs.next()) {
                    Funcionario f = new Funcionario();
                    f.setId(rs.getInt("id"));
                    f.setFun_nome(rs.getString("fun_nome"));
                    f.setFun_nf(rs.getString("fun_nf"));
                    f.setFun_nivel(rs.getString("fun_nivel"));
                    f.setFun_email(rs.getString("fun_email"));
                    f.setFun_telefone(rs.getString("fun_telefone"));
                    f.setFun_cpf(rs.getString("fun_cpf"));
                    f.setFun_login(rs.getString("fun_login"));
                    f.setFun_senha(rs.getString("fun_senha"));
                    f.setFun_status(rs.getString("fun_status"));
                    funcionarios.add(f);
                }//while
                //fecha a conexao
                con.close();

                lista = funcionarios;
                return lista;
            } catch (ClassNotFoundException ex) {
                return lista;
            } catch (SQLException ex) {
                return lista;
            }
            //consultar pelo usuário e pela senha    
        } else if (fun.getFun_login() != null && fun.getFun_senha() != null) {
            try {
                Connection con = BancoDadosPostgres.getConexao();
                String sql = " SELECT * FROM funcionario WHERE fun_login = ? AND fun_senha = ?; ";

                PreparedStatement pst;

                pst = con.prepareStatement(sql);
                pst.setString(1, fun.getFun_login());
                pst.setString(2, fun.getFun_senha());

                ResultSet rs;
                rs = pst.executeQuery();
                while (rs.next()) {
                    Funcionario f = new Funcionario();
                    f.setId(rs.getInt("id"));
                    f.setFun_nome(rs.getString("fun_nome"));
                    f.setFun_nf(rs.getString("fun_nf"));
                    f.setFun_nivel(rs.getString("fun_nivel"));
                    f.setFun_email(rs.getString("fun_email"));
                    f.setFun_telefone(rs.getString("fun_telefone"));
                    f.setFun_cpf(rs.getString("fun_cpf"));
                    f.setFun_login(rs.getString("fun_login"));
                    f.setFun_senha(rs.getString("fun_senha"));
                    f.setFun_status(rs.getString("fun_status"));
                    funcionarios.add(f);
                }//while
                //fecha a conexao
                con.close();
                lista = funcionarios;
                return lista;
            } catch (Exception ex) {
                return null;
            }
        } //consultar Todos 
        else {
            funcionarios = (List) consultarTodos(fun);

            List<Funcionario> ativos = new ArrayList();
            //separar oque estiver inativo
            for (Funcionario f : funcionarios) {
                if (f.getFun_status() != null) {
                    if (!f.getFun_status().equals("Inativo")) {
                        ativos.add(f);
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
        String mensagemFun;

        String mensagem = "";
        //conexao = BancoDadosPostgres.getConexao();
        Funcionario fun = (Funcionario) entidade;
        
        if (fun.getAlt() == null) {
            mensagemFun = alterarGeral(fun);
            //alterar o departamento no usuario
            int id_usuario = 0;
            Usuario u = new Usuario();
            List entidades =  consultarTodos(u);
            for(Object o: entidades){
                u = (Usuario) o;
                if(u.getUsu_id_owner() == fun.getId()){
                    id_usuario = u.getId();
                }
            }
            String editar = "UPDATE usuario SET usu_dep = ? WHERE id = ?";
            Connection con;
            try {
                con = BancoDadosPostgres.getConexao();
                PreparedStatement ps = con.prepareStatement(editar);
                ps.setInt(1, fun.getFun_dep());
                ps.setInt(2, id_usuario);
                ps.executeUpdate();
                ps.close();
            } catch (ClassNotFoundException ex) {
                mensagem = ex.toString();
            } catch (SQLException ex) {
                mensagem = ex.toString();
            }
            mensagem = mensagemFun;
        } else {
            String editar = "UPDATE funcionario SET fun_senha = ? WHERE id = ?";
            Connection con;
            try {
                con = BancoDadosPostgres.getConexao();
                PreparedStatement ps = con.prepareStatement(editar);
                ps.setString(1, fun.getAlt().getNovaSenha());
                ps.setInt(2, fun.getId());
                ps.executeUpdate();
                ps.close();
                mensagem = "Senha Alterada com Sucesso!";
            } catch (ClassNotFoundException ex) {
                mensagem = ex.toString();
            } catch (SQLException ex) {
                mensagem = ex.toString();
            }
        }
        return mensagem;
    }

    @Override
    public List<EntidadeDominio> excluir(EntidadeDominio entidade
    ) {
        Funcionario fun = (Funcionario) entidade;
        String editar = "UPDATE funcionario SET fun_status = ? WHERE id = ?";
        Connection con;
        try {
            con = BancoDadosPostgres.getConexao();
            PreparedStatement ps = con.prepareStatement(editar);
            ps.setString(1, "Inativo");
            ps.setInt(2, fun.getId());
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        fun.setBusca(null);
        fun.setId(0);
        return consultar(fun);
    }

}
