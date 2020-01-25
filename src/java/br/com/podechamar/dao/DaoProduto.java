/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.dao;

import br.com.podechamar.dao.core.*;
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
 * @author Julio Cesar Alves
 */
public class DaoProduto extends Dao {

    @Override
    public String salvar(EntidadeDominio entidade) {
        Connection conexao;
        String mensagem;
        Produto pro = (Produto) entidade;
        try {
            conexao = BancoDadosPostgres.getConexao();
            mensagem = inserir(pro, conexao);
            conexao.close();
        } catch (Exception ex) {
            return ex.toString();
        }
        return mensagem;
    }//fim do salvar

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {

        Produto pro = (Produto) entidade;
        List lista = new ArrayList();
        List<Produto> produtos = new ArrayList<>();
        //buscar por ID
        if (pro.getId() > 0) {
            Produto produto = (Produto) consultarPorId(pro.getId(), pro);
            produtos.add(produto);
            lista = produtos;
            return lista;
        } //bsucar pelo parâmetro digitado  
        else if (pro.getBusca() != null) {
            try {
                //abre a conexão
                Connection con = BancoDadosPostgres.getConexao();
                String sql = " SELECT  * FROM PRODUTO "
                        + "WHERE "
                        + "pro_nome LIKE  '%" + pro.getBusca() + "%' "
                        + " OR  pro_ean LIKE  '%" + pro.getBusca() + "%' "
                        + " OR  pro_descricao LIKE  '%" + pro.getBusca() + "%' "
                        + " OR  CAST(pro_preco_compra as text) LIKE  '%" + pro.getBusca() + "%' "
                        + " OR  CAST(pro_quantidade as text) LIKE  '%" + pro.getBusca() + "%' "
                        + " OR  CAST(pro_tipo as text) LIKE  '%" + pro.getBusca() + "%' "
                        + " OR  CAST(pro_status as text) LIKE  '%" + pro.getBusca() + "%' "
                        + " OR  CAST(pro_disponivel as text) LIKE  '%" + pro.getBusca() + "%' "
                        + " OR  CAST(pro_fisico as text) LIKE  '%" + pro.getBusca() + "%' "
                        + " OR  CAST(pro_reservado as text) LIKE  '%" + pro.getBusca() + "%' "
                        + " OR  CAST(pro_preco_venda as text) LIKE  '%" + pro.getBusca() + "%' "
                        + " OR  CAST(pro_margem_lucro as text) LIKE  '%" + pro.getBusca() + "%' ";

                PreparedStatement pst;
                pst = con.prepareStatement(sql);
                ResultSet rs;
                rs = pst.executeQuery();
                while (rs.next()) {
                    Produto p = new Produto();
                    p.setId(rs.getInt("id"));
                    p.setPro_nome(rs.getString("pro_nome"));
                    p.setPro_ean(rs.getString("pro_ean"));
                    p.setPro_descricao(rs.getString("pro_descricao"));
                    p.setPro_preco_compra(rs.getDouble("pro_preco_compra"));

                    p.setPro_quantidade(rs.getInt("pro_quantidade"));
                    p.setPro_tipo(rs.getString("pro_tipo"));
                    p.setPro_status(rs.getString("pro_status"));
                    p.setPro_disponivel(rs.getInt("pro_disponivel"));
                    p.setPro_fisico(rs.getInt("pro_fisico"));
                    p.setPro_reservado(rs.getInt("pro_reservado"));
                    p.setPro_preco_venda(rs.getDouble("pro_preco_venda"));
                    p.setPro_margem_lucro(rs.getDouble("pro_margem_lucro"));
                    produtos.add(p);
                }//while
                //fecha a conexao
                con.close();
                lista = produtos;
                return lista;
            } catch (ClassNotFoundException ex) {
                return lista;
            } catch (SQLException ex) {
                return lista;
            }
        } //consultar Todos 
        else {
            produtos = (List) consultarTodos(pro);

            List<Produto> ativos = new ArrayList();
            //separar oque estiver inativo
            for (Produto p : produtos) {
                if (p.getPro_status() != null) {
                    if (!p.getPro_status().equals("Inativo")) {
                        ativos.add(p);
                    }
                }
            }
            lista = ativos;
            //lista = clientes;
            return lista;
        }
    }//fim consultar

    @Override
    public List<EntidadeDominio> excluir(EntidadeDominio entidade) {
        {
            Produto pro = (Produto) entidade;
            //verifica se há movimentação de estoque
            if (pro.getEst() != null) {
                if(pro.getEst().getMovimento().equals("Entrada")){
                    pro.setPro_fisico(pro.getPro_fisico() + pro.getEst().getQuantidade());
                }else{
                     pro.setPro_fisico(pro.getPro_fisico() - pro.getEst().getQuantidade());
                }
                pro.setPro_disponivel(pro.getPro_fisico() - pro.getPro_reservado());
                String editar = "UPDATE produto SET pro_fisico = ?,  pro_disponivel = ? WHERE id = ?";
                Connection con;
                try {
                    con = BancoDadosPostgres.getConexao();
                    PreparedStatement ps = con.prepareStatement(editar);
                    ps.setInt(1, pro.getPro_fisico());
                    ps.setInt(2, pro.getPro_disponivel());
                    ps.setInt(3, pro.getId());
                    ps.executeUpdate();
                    ps.close();
                } catch (ClassNotFoundException ex) {
                    return null;
                } catch (SQLException ex) {
                    return null;
                }
                pro.setBusca(null);
                pro.setId(0);
                return consultar(pro);
            }

            String editar = "UPDATE produto SET pro_status = ? WHERE id = ?";
            Connection con;
            try {
                con = BancoDadosPostgres.getConexao();
                PreparedStatement ps = con.prepareStatement(editar);
                ps.setString(1, "Inativo");
                ps.setInt(2, pro.getId());
                ps.executeUpdate();
                ps.close();
            } catch (ClassNotFoundException ex) {
                return null;
            } catch (SQLException ex) {
                return null;
            }
            pro.setBusca(null);
            pro.setId(0);
            return consultar(pro);
        }
    }

    @Override
    public String alterar(EntidadeDominio entidade) {

        String mensagem = "";
        Produto pro = (Produto) entidade;
        if (pro.getEst() == null) {
            mensagem = alterarGeral(pro);
        }
        return mensagem;
    }
}
