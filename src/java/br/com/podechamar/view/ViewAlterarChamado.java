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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Julio Cesar Alves
 */
public class ViewAlterarChamado extends ViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        //variaveis
        String quantidade = request.getParameter("quantidade");
        String id_produto = request.getParameter("id_produto");
        String id_chamado = request.getParameter("id");
        //Status ABerto
        Chamado cha = new Chamado();
        cha.setCha_status("Aberto");
        Item i = new Item();
        Produto p = new Produto();
        List<Item> itens = new ArrayList<>();
        //montar o objeto
        p.setId(Integer.valueOf(id_produto));
        i.setQuantidade(Integer.valueOf(quantidade));
        cha.setId(Integer.valueOf(id_chamado));
        i.setP(p);
        itens.add(i);
        cha.setItens(itens);
        
        return cha;  
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession sessao = request.getSession();
        sessao.setAttribute("chamado", resultado.getListaResultado().get(0));
        request.getRequestDispatcher("/chamadosProdutoCliente.jsp").forward(request, response);
    }
    
}
