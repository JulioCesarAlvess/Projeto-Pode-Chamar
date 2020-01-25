/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.controle.Resultado;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.view.core.DadosVisao;
import br.com.podechamar.view.core.ViewHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author leofa
 */
public class ViewAlterarTipoChamado extends ViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        
        TipoChamado tipo = new TipoChamado();

        //preencher o objeto
        DadosVisao visao = new DadosVisao(request);
        tipo = (TipoChamado)preencher(visao,tipo.getClass());
        
        String id = request.getParameter("id");
        tipo.setId(Integer.valueOf(id));
        
        return tipo;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("tipos", resultado.getListaResultado().get(0));
        request.setAttribute("mensagem", resultado.getMensagemResultado());
        request.getRequestDispatcher("/tipochamado_atualizar.jsp").forward(request, response);
    }
    
}
