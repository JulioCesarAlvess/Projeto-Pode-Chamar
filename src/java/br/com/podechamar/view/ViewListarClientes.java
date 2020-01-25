/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.controle.Resultado;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.view.core.I_ViewHelper;
import br.com.podechamar.view.core.ViewHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio Cesar Alves
 */
public class ViewListarClientes extends ViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        Cliente cli = new Cliente();
        Contrato con = new Contrato();
        Endereco end = new Endereco();
        
        cli.setCli_contrato(con);
        cli.setCli_endereco(end);
        
        try{
            cli.setId(Integer.valueOf(request.getParameter("id")));
        }catch(Exception ex){
            cli.setId(0);
        }
        cli.setBusca(request.getParameter("busca"));
        return cli;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("clientes", resultado.getListaResultado());
        request.getRequestDispatcher("/cliente_lista.jsp").forward(request, response);
    }
    
}
