/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.controle.Resultado;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.view.core.ViewHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio Cesar Alves
 */
public class ViewListarHistorico extends ViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        Historico his = new Historico();

        try {
            his.setId(Integer.valueOf(request.getParameter("id")));
        } catch (Exception ex) {
            his.setId(0);
        }
        his.setBusca(request.getParameter("busca"));

        return his;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("historicos", resultado.getListaResultado());
        if (request.getRequestURL().toString().contains("Dados")) {
            request.getRequestDispatcher("/historico_valores.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/historico_lista.jsp").forward(request, response);
        }
    }
}
