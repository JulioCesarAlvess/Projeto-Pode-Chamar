/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.controle.Resultado;
import br.com.podechamar.dominio.Chamado;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.Produto;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.view.core.ViewHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio Cesar Alves
 */
public class ViewChamadoAdicionarAtividade extends ViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        //variaveis
        String id_atividade = request.getParameter("id_atividade");
        String id_chamado = request.getParameter("id");
        Chamado cha = new Chamado();
        Atividade a = new Atividade();
        List<Atividade> atividades = new ArrayList<>();
        //montar o objeto
        a.setId(Integer.valueOf(id_atividade));
        cha.setId(Integer.valueOf(id_chamado));
        atividades.add(a);
        cha.setAtividades(atividades);
        
        return cha;  
        }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("chamado", resultado.getListaResultado().get(0));
        request.setAttribute("mensagem", resultado.getMensagemResultado());
        request.getRequestDispatcher("/chamados_atualizar.jsp").forward(request, response);
    }
    
}
