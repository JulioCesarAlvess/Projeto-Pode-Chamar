/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.dominio.Funcionario;
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
 * @author leofa
 */
public class ViewListarFuncionario extends ViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        
       Funcionario fun = new Funcionario();
        
        try{
            fun.setId(Integer.valueOf(request.getParameter("id")));
        }catch(Exception ex){
            fun.setId(0);
        }
        fun.setBusca(request.getParameter("busca"));
        
        return fun;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("funcionarios", resultado.getListaResultado());
        request.getRequestDispatcher("/funcionario_lista.jsp").forward(request, response);
    }
    
}
