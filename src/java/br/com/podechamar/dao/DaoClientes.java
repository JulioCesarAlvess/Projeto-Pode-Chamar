/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.dao;

import br.com.podechamar.dao.core.*;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julio Cesar Alves
 */
public class DaoClientes extends Dao {

    @Override
    public String salvar(EntidadeDominio entidade) {
        Connection conexao;
        String mensagemCli;
        String mensagemEnd;
        String mensagemCon;
        String mensagem = "";
        try {
            conexao = BancoDadosPostgres.getConexao();
            Cliente cli = (Cliente) entidade;
            mensagemCli = inserir(cli, conexao);
            mensagemEnd = inserir(cli.getCli_endereco(), conexao);
            mensagemCon = inserir(cli.getCli_contrato(), conexao);
            
            String sql = "INSERT INTO usuario (usu_login, usu_senha, usu_papel, usu_id_owner, usu_dep)" +
            "VALUES (? , ?, ?, currval('cliente_seq'), ? )";
            
            //salvar o usuario do funcionario
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, cli.getUsu().getUsu_login());
            ps.setString(2, cli.getUsu().getUsu_senha());
            ps.setString(3, cli.getUsu().getUsu_papel());
            ps.setInt(4, cli.getUsu().getUsu_dep());
            ps.executeUpdate();
            
            conexao.close();

            mensagem = mensagemCli;
            if (!mensagemEnd.equals(mensagem)) {
                mensagem += mensagemEnd;
            }
            if (!mensagemCon.equals(mensagem)) {
                mensagem += mensagemEnd;
            }

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

        Cliente cli = (Cliente) entidade;
        Contrato contrato = new Contrato();
        Endereco endereco = new Endereco();
        List lista = new ArrayList();
        List<Cliente> clientes = new ArrayList<>();
        //buscar por ID
        if (cli.getCli_id() > 0) {
            Cliente cliente = (Cliente) consultarPorId(cli.getCli_id(), cli);
            clientes.add(cliente);

            List<Endereco> ends = (List) consultarTodos(endereco);
            List<Contrato> conts = (List) consultarTodos(contrato);

            for (Cliente c : clientes) {
                for (Endereco e : ends) {
                    if (c.getCli_id() == e.getEnd_cli_id()) {
                        c.setCli_endereco(e);
                    }
                }
                for (Contrato con : conts) {
                    if (c.getCli_id() == con.getCon_cli_id()) {
                        c.setCli_contrato(con);
                    }
                }
            }
            lista = clientes;
            return lista;
            //bsucar pelo parâmetro digitado    
        } else if (cli.getBusca() != null) {
            try {
                //abre a conexão
                Connection con = BancoDadosPostgres.getConexao();
                String sql = " SELECT  * FROM CLIENTE c "
                        + "left join endereco ON c.id = end_cli_id "
                        + "left join contrato ON c.id = con_cli_id "
                        + "WHERE "
                        + "cli_rasaosocial LIKE  '%" + cli.getBusca() + "%' "
                        + " OR  cli_contato LIKE  '%" + cli.getBusca() + "%' "
                        + " OR  cli_cnpj LIKE  '%" + cli.getBusca() + "%' "
                        + " OR  cli_ramoatividade LIKE  '%" + cli.getBusca() + "%' "
                        + " OR  CAST(cli_email as text) LIKE  '%" + cli.getBusca() + "%' "
                        + " OR  CAST(cli_telefone as text) LIKE  '%" + cli.getBusca() + "%' "
                        + " OR  CAST(cli_status as text) LIKE  '%" + cli.getBusca() + "%' "
                        + " OR  CAST(end_rua as text) LIKE  '%" + cli.getBusca() + "%' "
                        + " OR  CAST(end_numero as text) LIKE  '%" + cli.getBusca() + "%' "
                        + " OR  CAST(end_bairro as text) LIKE  '%" + cli.getBusca() + "%' "
                        + " OR  CAST(end_cidade as text) LIKE  '%" + cli.getBusca() + "%' "
                        + " OR  CAST(end_estado as text) LIKE  '%" + cli.getBusca() + "%' "
                        + " OR  CAST(end_pais as text) LIKE  '%" + cli.getBusca() + "%' "
                        + " OR  CAST(con_tempo as text) LIKE  '%" + cli.getBusca() + "%' "
                        + " OR  CAST(con_datainicio as text) LIKE  '%" + cli.getBusca() + "%' "
                        + " OR  CAST(con_diavencimento as text) LIKE  '%" + cli.getBusca() + "%' "
                        + " OR  CAST(con_valormensalidade as text) LIKE  '%" + cli.getBusca() + "%' ";
                PreparedStatement pst;
                pst = con.prepareStatement(sql);
                ResultSet rs;
                rs = pst.executeQuery();
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setId(rs.getInt("id"));
                    c.setCli_rasaosocial(rs.getString("cli_rasaosocial"));
                    c.setCli_nomefantasia(rs.getString("cli_nomefantasia"));
                    c.setCli_contato(rs.getString("cli_contato"));
                    c.setCli_cnpj(rs.getString("cli_cnpj"));
                    c.setCli_ramoatividade(rs.getString("cli_ramoatividade"));
                    c.setCli_email(rs.getString("cli_email"));
                    c.setCli_telefone(rs.getString("cli_telefone"));
                    c.setCli_status(rs.getString("cli_status"));
                    clientes.add(c);
                }//while
                //fecha a conexao
                con.close();

                List<Endereco> ends = (List) consultarTodos(endereco);
                List<Contrato> conts = (List) consultarTodos(contrato);

                for (Cliente c : clientes) {
                    for (Endereco e : ends) {
                        if (c.getCli_id() == e.getEnd_cli_id()) {
                            c.setCli_endereco(e);
                        }
                    }
                    for (Contrato co : conts) {
                        if (c.getCli_id() == co.getCon_cli_id()) {
                            c.setCli_contrato(co);
                        }
                    }
                }
                lista = clientes;
                return lista;
            } catch (ClassNotFoundException ex) {
                return lista;
            } catch (SQLException ex) {
                return lista;
            }
            //consultar Todos 
        } else {
            clientes = (List) consultarTodos(cli);
            List<Endereco> ends = (List) consultarTodos(endereco);
            List<Contrato> conts = (List) consultarTodos(contrato);

            for (Cliente c : clientes) {
                for (Endereco e : ends) {
                    if (c.getCli_id() == e.getEnd_cli_id()) {
                        c.setCli_endereco(e);
                    }
                }
                for (Contrato con : conts) {
                    if (c.getCli_id() == con.getCon_cli_id()) {
                        c.setCli_contrato(con);
                    }
                }
                //listar
                //System.out.println("\n\nCliente: " + c.toString());
            }
            List<Cliente> ativos = new ArrayList();
            //separar oque estiver inativo
            for (Cliente c : clientes) {
                if (!c.getCli_status().equals("Inativo")) {
                    ativos.add(c);
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
        String mensagemCli;
        String mensagemEnd;
        String mensagem = "";
        //conexao = BancoDadosPostgres.getConexao();
        Cliente cli = (Cliente) entidade;
        mensagemCli = alterarGeral(cli);
        mensagemEnd = alterarGeral(cli.getCli_endereco());
        //conexao.close();

        mensagem = mensagemCli;
        if (!mensagemEnd.equals(mensagem)) {
            mensagem += mensagemEnd;
        }
        return mensagem;
    }

    @Override
    public List<EntidadeDominio> excluir(EntidadeDominio entidade
    ) {
        Cliente cli = (Cliente) entidade;
        String editar = "UPDATE cliente SET cli_status = ? WHERE id = ?";
        Connection con;
        try {
            con = BancoDadosPostgres.getConexao();
            PreparedStatement ps = con.prepareStatement(editar);
            ps.setString(1, "Inativo");
            ps.setInt(2, cli.getId());
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException ex) {
            return null;
        } catch (SQLException ex) {
            return null;
        }
        cli.setBusca(null);
        cli.setId(0);
        return consultar(cli);
    }

}
