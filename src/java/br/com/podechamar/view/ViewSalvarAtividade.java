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
public class ViewSalvarAtividade extends ViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
       
          Atividade ati = new Atividade();
        DadosVisao visao = new DadosVisao(request);

        ati = (Atividade) preencher(visao, ati.getClass());

        return ati;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        resultado.setMensagemResultado(resultado.getMensagemResultado().replace("#", "</br>"));
        request.setAttribute("mensagem", resultado.getMensagemResultado());
        request.getRequestDispatcher("/atividade_gestao.jsp").forward(request, response);
    }
    
}
