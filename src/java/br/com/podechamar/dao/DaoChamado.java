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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julio Cesar Alves
 */
public class DaoChamado extends Dao {

    @Override
    public String salvar(EntidadeDominio entidade) {
        Connection conexao;
        String mensagem;
        Chamado cha = (Chamado) entidade;
        try {
            conexao = BancoDadosPostgres.getConexao();
            mensagem = inserir(cha, conexao);
            conexao.close();
        } catch (Exception ex) {
            return ex.toString();
        }
        return mensagem;
    }//fim do salvar

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        Chamado cha = (Chamado) entidade;
        List lista = new ArrayList();
        List<Chamado> chamados = new ArrayList<>();

        //buscar por ID
        if (cha.getId() > 0) {
            Chamado chamado = (Chamado) consultarPorId(cha.getId(), cha);
            chamados.add(chamado);

            lista = chamados;
            //return lista;
            //bsucar pelo parâmetro digitado    
        } else if (cha.getBusca() != null) {
            if (cha.getBusca().length() > 0) {
                try {
                    Connection con = BancoDadosPostgres.getConexao();
                    String sql = " SELECT  * FROM chamado "
                            + "WHERE "
                            + " CAST(id as text) LIKE '%" + cha.getBusca() + "%' "
                            + " OR  CAST(cha_databertura as text) LIKE  '%" + cha.getBusca() + "%' "
                            + " OR  CAST(cha_datafechamento as text) LIKE  '%" + cha.getBusca() + "%' "
                            + " OR  CAST(cha_feedback_cli as text) LIKE  '%" + cha.getBusca() + "%' "
                            + " OR  CAST(cha_feedback_fun as text) LIKE  '%" + cha.getBusca() + "%' "
                            + " OR  CAST(cha_nota_fun as text) LIKE  '%" + cha.getBusca() + "%' "
                            + " OR  CAST(cha_nota_cli as text) LIKE  '%" + cha.getBusca() + "%' "
                            + " OR  CAST(cha_severidade as text) LIKE  '%" + cha.getBusca() + "%' "
                            + " OR  CAST(cha_solicitante as text) LIKE  '%" + cha.getBusca() + "%' "
                            + " OR  CAST(cha_sla as text) LIKE  '%" + cha.getBusca() + "%' "
                            + " OR  CAST(cha_status as text) LIKE  '%" + cha.getBusca() + "%' "
                            + " OR  CAST(cha_fun as text) LIKE  '%" + cha.getBusca() + "%' "
                            + " OR  CAST(cha_cli as text) LIKE  '%" + cha.getBusca() + "%' "
                            + " OR  CAST(cha_dep as text) LIKE  '%" + cha.getBusca() + "%' "
                            + " OR  CAST(cha_tipo as text) LIKE  '%" + cha.getBusca() + "%' "
                            + " OR  CAST(cha_justificativa as text) LIKE  '%" + cha.getBusca() + "%' ";
                    PreparedStatement pst;
                    pst = con.prepareStatement(sql);
                    ResultSet rs;
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        Chamado c = new Chamado();
                        c.setId(rs.getInt("id"));
                        c.setCha_databertura(rs.getString("cha_databertura"));
                        c.setCha_datafechamento(rs.getString("cha_datafechamento"));
                        c.setCha_feedback_cli(rs.getString("cha_feedback_cli"));
                        c.setCha_feedback_fun(rs.getString("cha_feedback_fun"));
                        c.setCha_nota_fun(rs.getInt("cha_nota_fun"));
                        c.setCha_nota_cli(rs.getInt("cha_nota_cli"));
                        c.setCha_cli_id(rs.getInt("cha_cli_id"));
                        c.setCha_fun_id(rs.getInt("cha_fun_id"));
                        c.setCha_severidade(rs.getString("cha_severidade"));
                        c.setCha_dep_id(rs.getInt("cha_dep_id"));
                        c.setCha_tipo_id(rs.getInt("cha_tipo_id"));
                        c.setCha_solicitante(rs.getString("cha_solicitante"));
                        c.setCha_sla(rs.getDouble("cha_sla"));
                        c.setCha_status(rs.getString("cha_status"));
                        c.setCha_fun(rs.getString("cha_fun"));
                        c.setCha_cli(rs.getString("cha_cli"));
                        c.setCha_dep(rs.getString("cha_dep"));
                        c.setCha_tipo(rs.getString("cha_tipo"));
                        c.setCha_descricao(rs.getString("cha_descricao"));
                        c.setCha_justificativa(rs.getString("cha_justificativa"));
                        chamados.add(c);
                    }//while
                    //fecha a conexao
                    con.close();

                    lista = chamados;
                    //return lista;
                } catch (ClassNotFoundException ex) {
                    return lista;
                } catch (SQLException ex) {
                    return lista;
                }
                //consultar pelo usuário e pela senha    

            }
        } //if da consulta específica
        //consultar Todos 
        else {
            chamados = (List) consultarTodos(cha);
            //lista = clientes;
            lista = chamados;
        }
        //selecionar os chamados
        List<Chamado> selecionados = new ArrayList();
        for (Chamado c : chamados) {
            if (cha.getCha_cli_id() > 0) {
                if (cha.getCha_cli_id() == c.getCha_cli_id()) {
                    selecionados.add(c);
                }
            }
            if (cha.getCha_fun_id() > 0) {
                if (cha.getCha_fun_id() == c.getCha_fun_id()) {
                    selecionados.add(c);
                }
            }
            if (cha.getCha_dep_id() > 0) {
                if (cha.getCha_dep_id() == c.getCha_dep_id()) {
                    selecionados.add(c);
                }
            }

        }

        //adicionar os produtos dos chamados
        for (int i = 0; i < selecionados.size(); i++) {
            selecionados.get(i).setItens(adicionarItens(selecionados.get(i).getId()));
            selecionados.get(i).setAtividades(adicionarAtividades(selecionados.get(i).getId()));
        }
        //retornar a lista 
        lista = selecionados;
        return lista;
    }//fim do consultar

    @Override
    public List<EntidadeDominio> excluir(EntidadeDominio entidade) {
        Chamado cha = (Chamado) entidade;
        //excluir Atividades de um chamado
        if (cha.getAtividades() != null) {
            if (cha.getAtividades().get(0).getExcluir()) {
                String sql = "DELETE FROM atividades WHERE id_chamado = ? AND id_atividade = ? ";
                Connection con;
                try {
                    con = BancoDadosPostgres.getConexao();
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, cha.getId());
                    ps.setInt(2, cha.getAtividades().get(0).getId());
                    ps.execute();
                    ps.close();
                    con.close();
                } catch (ClassNotFoundException ex) {
                    System.out.println("" + ex.toString());
                } catch (SQLException ex) {
                    System.out.println("" + ex.toString());
                }

                List lista = new ArrayList();
                List<Chamado> chamados = new ArrayList<>();
                Chamado chamado = (Chamado) consultarPorId(cha.getId(), cha);
                chamado.setItens(adicionarItens(chamado.getId()));
                chamado.setAtividades(adicionarAtividades(chamado.getId()));
                chamados.add(chamado);
                lista = chamados;

                return lista;
            }
        }//fim
        //fim do excluir atividade

        //excluir item do chamado
        if (cha.getItens() != null) {
            if (cha.getItens().get(0).getExcluir()) {
                String sql = "DELETE FROM item WHERE cha_id = ? AND pro_id = ?";
                Connection con;
                try {
                    con = BancoDadosPostgres.getConexao();
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, cha.getId());
                    ps.setInt(2, cha.getItens().get(0).getP().getId());
                    ps.execute();
                    ps.close();
                    con.close();
                } catch (ClassNotFoundException ex) {
                    System.out.println("" + ex.toString());
                } catch (SQLException ex) {
                    System.out.println("" + ex.toString());
                }

                List lista = new ArrayList();
                List<Chamado> chamados = new ArrayList<>();
                Chamado chamado = (Chamado) consultarPorId(cha.getId(), cha);
                chamado.setItens(adicionarItens(chamado.getId()));
                chamado.setAtividades(adicionarAtividades(chamado.getId()));
                chamados.add(chamado);
                lista = chamados;

                return lista;
            }
        }//fim
        //fim do excluir item

        //inserir produtos no chamado
        if (cha.getItens() != null) {
            String sql = "INSERT INTO item (cha_id, pro_id, ite_quantidade) VALUES (?, ?, ?)";
            Connection con;
            try {
                con = BancoDadosPostgres.getConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, cha.getId());
                ps.setInt(2, cha.getItens().get(0).getP().getId());
                ps.setInt(3, cha.getItens().get(0).getQuantidade());
                ps.execute();
                ps.close();
                con.close();
            } catch (ClassNotFoundException ex) {
                System.out.println("" + ex.toString());
            } catch (SQLException ex) {
                System.out.println("" + ex.toString());
            }

            List lista = new ArrayList();
            List<Chamado> chamados = new ArrayList<>();
            Chamado chamado = (Chamado) consultarPorId(cha.getId(), cha);
            chamado.setItens(adicionarItens(chamado.getId()));
            chamado.setAtividades(adicionarAtividades(chamado.getId()));
            chamados.add(chamado);
            lista = chamados;

            return lista;
        }//if

        //adicionar atividades para os chamados
        if (cha.getAtividades() != null) {
            String sql = "INSERT INTO atividades (id_chamado, id_atividade) VALUES (?, ?) ";
            Connection con;
            try {
                con = BancoDadosPostgres.getConexao();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, cha.getId());
                ps.setInt(2, cha.getAtividades().get(0).getId());
                ps.execute();
                ps.close();
                con.close();
            } catch (ClassNotFoundException ex) {
                System.out.println("" + ex.toString());
            } catch (SQLException ex) {
                System.out.println("" + ex.toString());
            }

            List lista = new ArrayList();
            List<Chamado> chamados = new ArrayList<>();
            Chamado chamado = (Chamado) consultarPorId(cha.getId(), cha);
            chamado.setItens(adicionarItens(chamado.getId()));
            chamado.setAtividades(adicionarAtividades(chamado.getId()));
            chamados.add(chamado);
            lista = chamados;

            return lista;
        }//fim
        //atribuir chamado a um funcionario
        if (cha.getCha_fun() != null) {
            if (cha.getCha_fun().length() > 0) {
                String editar = "UPDATE chamado SET cha_fun_id = ?,  cha_fun = ?, cha_status = 'Pendente' WHERE id = ?";
                Connection con;
                try {
                    con = BancoDadosPostgres.getConexao();
                    PreparedStatement ps = con.prepareStatement(editar);
                    ps.setInt(1, cha.getCha_fun_id());
                    ps.setString(2, cha.getCha_fun());
                    ps.setInt(3, cha.getId());
                    ps.executeUpdate();
                    ps.close();
                    con.close();
                } catch (ClassNotFoundException ex) {
                    return null;
                } catch (SQLException ex) {
                    return null;
                }
                cha.setBusca(null);
                cha.setId(0);
                cha.setCha_fun_id(0);
                return consultar(cha);
            }
        }//fim
        //concluir chamado ou cancelar chamado
        if (cha.getCha_status() != null) {
            //concluir
            if (cha.getCha_status().equals("Concluido")) {
                String editar = "UPDATE chamado SET cha_datafechamento = ?, cha_status = 'Concluido' WHERE id = ?";
                Connection con;
                try {
                    con = BancoDadosPostgres.getConexao();
                    PreparedStatement ps = con.prepareStatement(editar);
                    ps.setString(1, cha.getCha_datafechamento());
                    ps.setInt(2, cha.getId());
                    ps.executeUpdate();
                    ps.close();
                    con.close();
                } catch (ClassNotFoundException ex) {
                    return null;
                } catch (SQLException ex) {
                    return null;
                }
                cha.setBusca(null);
                cha.setId(0);
                return consultar(cha);
            }

            //cancelar
            if (cha.getCha_status().equals("Cancelado")) {
                String editar = "UPDATE chamado SET cha_datafechamento = ?, cha_status = 'Cancelado' WHERE id = ?";
                Connection con;
                try {
                    con = BancoDadosPostgres.getConexao();
                    PreparedStatement ps = con.prepareStatement(editar);
                    ps.setString(1, cha.getCha_datafechamento());
                    ps.setInt(2, cha.getId());
                    ps.executeUpdate();
                    ps.close();
                    con.close();
                } catch (ClassNotFoundException ex) {
                    return null;
                } catch (SQLException ex) {
                    return null;
                }
                cha.setBusca(null);
                cha.setId(0);
                return consultar(cha);
            }

        }//fim do concluir
        //salvar o feedback para o funcionario
        if(cha.getCha_feedback_fun() != null){
            if (!cha.getCha_feedback_fun().equals("Sem feedback")) {
                String editar = "UPDATE chamado SET cha_nota_fun = ?, cha_feedback_fun = ? WHERE id = ?";
                Connection con;
                try {
                    con = BancoDadosPostgres.getConexao();
                    PreparedStatement ps = con.prepareStatement(editar);
                    ps.setInt(1, cha.getCha_nota_fun());
                    ps.setString(2, cha.getCha_feedback_fun());
                    ps.setInt(3, cha.getId());
                    ps.executeUpdate();
                    ps.close();
                    con.close();
                } catch (ClassNotFoundException ex) {
                    return null;
                } catch (SQLException ex) {
                    return null;
                }
                List lista;
                List<Chamado> chamados = new ArrayList<>();
                Chamado chamado = (Chamado) consultarPorId(cha.getId(), cha);
                chamado.setItens(adicionarItens(chamado.getId()));
                chamado.setAtividades(adicionarAtividades(chamado.getId()));
                chamados.add(chamado);
                lista = chamados;

                return lista;
            }
        }
        //fim do feedback para o funcionario

        //salvar o feedback para o cliente
        if(cha.getCha_feedback_cli() != null){
            if (!cha.getCha_feedback_cli().equals("Sem feedback")) {
                String editar = "UPDATE chamado SET cha_nota_cli = ?, cha_feedback_cli = ? WHERE id = ?";
                Connection con;
                try {
                    con = BancoDadosPostgres.getConexao();
                    PreparedStatement ps = con.prepareStatement(editar);
                    ps.setInt(1, cha.getCha_nota_cli());
                    ps.setString(2, cha.getCha_feedback_cli());
                    ps.setInt(3, cha.getId());
                    ps.executeUpdate();
                    ps.close();
                    con.close();
                } catch (ClassNotFoundException ex) {
                    return null;
                } catch (SQLException ex) {
                    return null;
                }
                List lista;
                List<Chamado> chamados = new ArrayList<>();
                Chamado chamado = (Chamado) consultarPorId(cha.getId(), cha);
                chamado.setItens(adicionarItens(chamado.getId()));
                chamado.setAtividades(adicionarAtividades(chamado.getId()));
                chamados.add(chamado);
                lista = chamados;

                return lista;
            }
        }//fim do feedback para o cliente

        //registrar a justificativa da retenção
        if (!cha.getCha_justificativa().contains("Sem Justificativa")) {
            String editar = "UPDATE chamado SET cha_justificativa = ? WHERE id = ?";
            Connection con;
            try {
                con = BancoDadosPostgres.getConexao();
                PreparedStatement ps = con.prepareStatement(editar);
                ps.setString(1, cha.getCha_justificativa());
                ps.setInt(2, cha.getId());
                ps.executeUpdate();
                ps.close();
                con.close();
            } catch (ClassNotFoundException ex) {
                return null;
            } catch (SQLException ex) {
                return null;
            }
            List lista;
            List<Chamado> chamados = new ArrayList<>();
            Chamado chamado = (Chamado) consultarPorId(cha.getId(), cha);
            chamado.setItens(adicionarItens(chamado.getId()));
            chamado.setAtividades(adicionarAtividades(chamado.getId()));
            chamados.add(chamado);
            lista = chamados;

            return lista;
        }
        else{
            String editar = "UPDATE chamado SET cha_justificativa = 'Sem Justificativa' WHERE id = ?";
            Connection con;
            try {
                con = BancoDadosPostgres.getConexao();
                PreparedStatement ps = con.prepareStatement(editar);
                ps.setInt(1, cha.getId());
                ps.executeUpdate();
                ps.close();
                con.close();
            } catch (ClassNotFoundException ex) {
                return null;
            } catch (SQLException ex) {
                return null;
            }
            List lista;
            List<Chamado> chamados = new ArrayList<>();
            Chamado chamado = (Chamado) consultarPorId(cha.getId(), cha);
            chamado.setItens(adicionarItens(chamado.getId()));
            chamado.setAtividades(adicionarAtividades(chamado.getId()));
            chamados.add(chamado);
            lista = chamados;

            return lista;
        }
    }

    @Override
    public String alterar(EntidadeDominio entidade) {

        String mensagem = "";
        Chamado cha = (Chamado) entidade;
        mensagem = alterarGeral(cha);
        return mensagem;
        //}//else
    }

//método para incluir os itens dos chamados
    private List<Item> adicionarItens(int id_chamado) {
        List<Item> itens = new ArrayList<>();
        try {
            Connection con = BancoDadosPostgres.getConexao();
            String sql = "SELECT p.id as pro_id, i.ite_quantidade as quantidade, p.pro_nome , p.pro_preco_venda"
                    + " FROM item i join chamado cha on i.cha_id = cha.id "
                    + "join produto p on i.pro_id = p.id "
                    + "WHERE cha.id = " + id_chamado;
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            ResultSet rs;
            rs = pst.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                Produto p = new Produto();
                p.setId(rs.getInt("pro_id"));
                p.setPro_nome(rs.getString("pro_nome"));
                p.setPro_preco_venda(rs.getDouble("pro_preco_venda"));
                item.setP(p);
                item.setQuantidade(rs.getInt("quantidade"));
                itens.add(item);
            }
            con.close();
            return itens;
        } catch (Exception ex) {
            return null;
        }
    }//fim do adicionar itens
    //método para incluir as atividades do chamado

    private List<Atividade> adicionarAtividades(int id_chamado) {
        List<Atividade> atividades = new ArrayList<>();
        try {
            Connection con = BancoDadosPostgres.getConexao();
            String sql = " SELECT a.id as atividade_id, a.ati_nome, a.ati_descricao"
                    + " FROM atividades ats join chamado cha on ats.id_chamado = cha.id "
                    + " join atividade a on ats.id_atividade = a.id "
                    + " WHERE cha.id = " + id_chamado;
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            ResultSet rs;
            rs = pst.executeQuery();
            while (rs.next()) {
                Atividade a = new Atividade();
                a.setId(rs.getInt("atividade_id"));
                a.setAti_nome(rs.getString("ati_nome"));
                a.setAti_descricao(rs.getString("ati_descricao"));
                atividades.add(a);
            }
            con.close();
            return atividades;
        } catch (Exception ex) {
            return null;
        }
    }//fim do adicionar itens

    //método que retona o id do ultimo chamado
    public int idUltimoChamado() {
        int id = 0;
        try {
            Connection con = BancoDadosPostgres.getConexao();
            String sql = "SELECT MAX(id) from chamado";
            PreparedStatement pst;
            pst = con.prepareStatement(sql);
            ResultSet rs;
            rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getInt("max");
            }
            con.close();
            return id;
        } catch (Exception ex) {
            return 0;
        }
    }

}
//códigos comentados por serem desnecessários
//tornar o chamado retido

/*if (cha.getCha_status().equals("Retido")) {
            String editar = "UPDATE chamado SET cha_status = 'Retido' WHERE id = ?";
                Connection con;
                try {
                    con = BancoDadosPostgres.getConexao();
                    PreparedStatement ps = con.prepareStatement(editar);
                    ps.setInt(1, cha.getId());
                    ps.executeUpdate();
                    ps.close();
                    con.close();
                } catch (ClassNotFoundException ex) {
                     return mensagem;
                } catch (SQLException ex) {
                     return mensagem;
                }
            return "Alterado com Sucesso!";
        } else {*/
        //*/
