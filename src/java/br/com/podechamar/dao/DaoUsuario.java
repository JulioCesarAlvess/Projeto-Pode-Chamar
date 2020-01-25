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
import br.com.podechamar.util.Criptografa;
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
public class DaoUsuario extends Dao {

    @Override
    public String salvar(EntidadeDominio entidade) {
        Usuario usu = (Usuario) entidade;
        Connection conexao;
        String mensagem;
        try {
            conexao = BancoDadosPostgres.getConexao();
            mensagem = inserir(usu, conexao);
            conexao.close();
        } catch (Exception ex) {
            return ex.toString();
        }
        return mensagem;
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        Usuario usu = (Usuario) entidade;
        List lista = new ArrayList();
         List<Usuario> usuarios = new ArrayList<>();
        try {
            Connection con = BancoDadosPostgres.getConexao();
                String sql = " SELECT * FROM usuario WHERE usu_login = ? AND usu_senha = ?; ";

                PreparedStatement pst;

                pst = con.prepareStatement(sql);
                pst.setString(1, usu.getUsu_login());
                pst.setString(2, usu.getUsu_senha());

                ResultSet rs;
                rs = pst.executeQuery();
                while (rs.next()) {
                    Usuario u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setUsu_papel(rs.getString("usu_papel"));
                    u.setUsu_senha(rs.getString("usu_senha"));
                    u.setUsu_login(rs.getString("usu_login"));
                    u.setUsu_id_owner(rs.getInt("usu_id_owner"));
                    u.setUsu_dep(rs.getInt("usu_dep"));
                    usuarios.add(u);
                }//while
                //fecha a conexao
                con.close();
                lista = usuarios;
                return lista;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<EntidadeDominio> excluir(EntidadeDominio entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String alterar(EntidadeDominio entidade) {
        String mensagem = "";
        Usuario u = (Usuario) entidade;
        
        if (u.getAlt() == null) {
            mensagem = alterarGeral(u);

            mensagem = alterarGeral(u);
        } else {
            String editar = "UPDATE usuario SET usu_senha = ? WHERE id = ?";
            Connection con;
            try {
                con = BancoDadosPostgres.getConexao();
                PreparedStatement ps = con.prepareStatement(editar);
                ps.setString(1, u.getAlt().getNovaSenha());
                ps.setInt(2, u.getId());
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

}
