/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.controle.*;
import br.com.podechamar.controle.core.I_Comando;
import br.com.podechamar.dominio.*;
import br.com.podechamar.view.core.I_ViewHelper;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio Cesar Alves
 */
public class FiltroLog implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        //coletar os valores necessários 
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String contexto = httpRequest.getContextPath();
        String operacao = request.getParameter("btnOperacao");
        String id = request.getParameter("id");
        String requisicao = httpRequest.getRequestURL().toString();
        Resultado r = new Resultado();
        //se a operação for de alteracao ou inserção realizar o Log        
        //
        if (operacao != null) {
            if (operacao.equals("EXCLUIR") || operacao.equals("ALTERAR") || operacao.equals("SALVAR")) {
                //gerar a entidade
                I_ViewHelper vh = new ViewHistorico();
                I_Comando com = new ComandoSalvar();
                Historico his = (Historico) vh.getEntidade(httpRequest, httpResponse);
                if(his != null){
                    if(his.getHis_id() != null)
                    r = com.executar(his);
                }
            }
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
    }
}
