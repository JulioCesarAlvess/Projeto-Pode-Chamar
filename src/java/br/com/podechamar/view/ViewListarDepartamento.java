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
 * @author leofa
 */
public class ViewListarDepartamento extends ViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        
          Departamento dep = new Departamento();
        
        try{
           dep.setId(Integer.valueOf(request.getParameter("id")));
        }catch(Exception ex){
            dep.setId(0);
        }
        dep.setBusca(request.getParameter("busca"));
        
        return dep;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("departamentos", resultado.getListaResultado());
        request.getRequestDispatcher("/departamento_lista.jsp").forward(request, response);
    }
    
    
}
