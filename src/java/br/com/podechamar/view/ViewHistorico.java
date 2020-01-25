/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.controle.Resultado;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.util.Converter;
import br.com.podechamar.view.core.ViewHelper;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio Cesar Alves
 *
 */
public class ViewHistorico extends ViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        String operacao = request.getParameter("btnOperacao");
        String id = request.getParameter("id");
        int intId = 0;
        String requisicao = request.getRequestURL().toString();

        if (id != null) {
            if (id.length() > 0) {
                intId = Integer.valueOf(id);
            }
        }

        Usuario u = (Usuario) request.getSession().getAttribute("usuAutenticado");

        Historico his = new Historico();
        //registra a operacao
        if (operacao.equals("SALVAR")) {
            his.setHis_operacao("INSERIR");
        } else {
            his.setHis_operacao("ALTERAR");
        }
        //a data da operacao
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        his.setHis_dataalteracao(df.format(today));
        //o usuario da operacao
        his.setHis_usuario(u.getUsu_login());
        //a entidade da alteracao
        //o valor anterior
        //o id da entidade
         //chamado
        if (requisicao.contains("Chamado")) {
            if (id == null) {
                id = request.getParameter("cha_id");
                if (id != null) {
                    if (id.length() > 0) {
                        intId = Integer.valueOf(id);
                    }
                }
            }
            his.setHis_entidade("Chamado");
            List<Chamado> chamados = (List<Chamado>) request.getSession().getAttribute("chamados");
            if (operacao.equals("SALVAR")) {
                his.setHis_id(Integer.toString(chamados.get(0).getId() + 1));
                his.setHis_valoranterior("INSERIR nao registra valor anterior");
            } else {
                for (Chamado ent : chamados) {
                    if (ent.getId() == intId) {
                        his.setHis_id(id);
                        his.setHis_valoranterior(Converter.criaValores(ent.toString()));
                    }
                }
            }
            if(his.getHis_id() == null){
                his.setHis_id(id);
                his.setHis_valoranterior("Insersao de Itens");
            }
            return his;
        }
        //produtos
        if (requisicao.contains("Produto")) {
            his.setHis_entidade("Produto");
            List<Produto> produtos = (List<Produto>) request.getSession().getAttribute("produtos");
            if (operacao.equals("SALVAR")) {
                his.setHis_id(Integer.toString(produtos.get(0).getId() + 1));
                his.setHis_valoranterior("INSERIR nao registra valor anterior");
            } else {
                for (Produto p : produtos) {
                    if (p.getId() == intId) {
                        his.setHis_id(id);
                        his.setHis_valoranterior(Converter.criaValores(p.toString()));
                    }
                }
            }
            return his;
        }
        //funcionarios
        if (requisicao.contains("Funcionario")) {
            his.setHis_entidade("Funcionario");
            List<Funcionario> funcionarios = (List<Funcionario>) request.getSession().getAttribute("funcionarios");
            if (operacao.equals("SALVAR")) {
                his.setHis_id(Integer.toString(funcionarios.get(0).getId() + 1));
                his.setHis_valoranterior("INSERIR nao registra valor anterior");
            } else {
                for (Funcionario ent : funcionarios) {
                    if (ent.getId() == intId) {
                        his.setHis_id(id);
                        his.setHis_valoranterior(Converter.criaValores(ent.toString()));
                    }
                }
            }
             if(his.getHis_id() == null){
                his.setHis_id(id);
                his.setHis_valoranterior("Atribuição de Funcionario para o chamado " + id);
            }
            
            return his;
        }
        //atividade
        if (requisicao.contains("Atividade")) {
            his.setHis_entidade("Atividade");
            List<Atividade> atividades = (List<Atividade>) request.getSession().getAttribute("atividades");
            if (operacao.equals("SALVAR")) {
                his.setHis_id(Integer.toString(atividades.get(0).getId() + 1));
                his.setHis_valoranterior("INSERIR nao registra valor anterior");
            } else {
                for (Atividade ent : atividades) {
                    if (ent.getId() == intId) {
                        his.setHis_id(id);
                        his.setHis_valoranterior(Converter.criaValores(ent.toString()));
                    }
                }
            }
            return his;
        }
        //cliente
        if (requisicao.contains("Cliente")) {
            his.setHis_entidade("Cliente");
            List<Cliente> clientes = (List<Cliente>) request.getSession().getAttribute("clientes");
            if (operacao.equals("SALVAR")) {
                his.setHis_id(Integer.toString(clientes.get(0).getId() + 1));
                his.setHis_valoranterior("INSERIR nao registra valor anterior");
            } else {
                for (Cliente ent : clientes) {
                    if (ent.getId() == intId) {
                        his.setHis_id(id);
                        his.setHis_valoranterior(Converter.criaValores(ent.toString()));
                    }
                }
            }
            
            if(his.getHis_id() == null){
                his.setHis_id(id);
                his.setHis_valoranterior("Atribuição de Feedback para o chamado " + id);
            }
            return his;
        }
        //departamento
        if (requisicao.contains("Departamento")) {
            his.setHis_entidade("Departamento");
            List<Departamento> departamentos = (List<Departamento>) request.getSession().getAttribute("departamentos");
            if (operacao.equals("SALVAR")) {
                his.setHis_id(Integer.toString(departamentos.get(0).getId() + 1));
                his.setHis_valoranterior("INSERIR nao registra valor anterior");
            } else {
                for (Departamento ent : departamentos) {
                    if (ent.getId() == intId) {
                        his.setHis_id(id);
                        his.setHis_valoranterior(Converter.criaValores(ent.toString()));
                    }
                }
            }
            return his;
        }
        //tipoChamado
        if (requisicao.contains("TipoChamado")) {
            his.setHis_entidade("Tipo de Chamado");
            List<TipoChamado> tiposchamado = (List<TipoChamado>) request.getSession().getAttribute("tiposchamado");
            if (operacao.equals("SALVAR")) {
                his.setHis_id(Integer.toString(tiposchamado.get(0).getId() + 1));
                his.setHis_valoranterior("INSERIR nao registra valor anterior");
            } else {
                for (TipoChamado ent : tiposchamado) {
                    if (ent.getId() == intId) {
                        his.setHis_id(id);
                        his.setHis_valoranterior(Converter.criaValores(ent.toString()));
                    }
                }
            }
            return his;
        }
        //
        return null;//para não dar erro durante os testes
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
