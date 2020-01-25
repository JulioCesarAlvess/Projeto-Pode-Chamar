/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.dominio.Funcionario;
import br.com.podechamar.dominio.Usuario;
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
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Julio Cesar Alves
 */
@WebFilter(filterName = "FiltroLogar", urlPatterns = {"/*"})
public class FiltroLogar implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        Usuario u = (Usuario) httpRequest.getSession().getAttribute("usuAutenticado");
        //comentado para não travar
        if (null != u || httpRequest.getRequestURL().toString().endsWith("/Logar")) {
            chain.doFilter(request, response);
        } else {
            request.setAttribute("mensagem", "Efetue seu login");
            request.getRequestDispatcher("/index.jsp").forward(request, response);  
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

}

