/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.controle.Resultado;
import br.com.podechamar.dominio.Chamado;
import br.com.podechamar.dominio.Usuario;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.view.core.ViewHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Julio Cesar Alves
 */
public class ViewChamadoRelStatus extends ViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        Chamado cha = new Chamado();
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Usuario u = (Usuario) httpRequest.getSession().getAttribute("usuAutenticado");
        
        if(u.getUsu_papel().equals("Cliente"))
            cha.setCha_cli_id(u.getUsu_id_owner());
        else if(u.getUsu_papel().equals("Operacional"))
            cha.setCha_fun_id(u.getUsu_id_owner());
        else
            cha.setCha_dep_id(u.getUsu_dep());
        
        try{
            cha.setId(Integer.valueOf(request.getParameter("id")));
        }catch(Exception ex){
            cha.setId(0);
        }
        cha.setBusca(request.getParameter("busca"));
        
        return cha;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession sessao = request.getSession();
        sessao.setAttribute("chamados" , resultado.getListaResultado());
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
    
}
