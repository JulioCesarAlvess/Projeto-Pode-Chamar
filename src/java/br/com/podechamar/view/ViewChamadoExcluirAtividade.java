/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.controle.Resultado;
import br.com.podechamar.dominio.Atividade;
import br.com.podechamar.dominio.Chamado;
import br.com.podechamar.dominio.Usuario;
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
public class ViewChamadoExcluirAtividade extends ViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        Chamado cha = new Chamado();
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Usuario u = (Usuario) httpRequest.getSession().getAttribute("usuAutenticado");

        if (u.getUsu_papel().equals("Cliente")) {
            cha.setCha_cli_id(u.getUsu_id_owner());
        } else if (u.getUsu_papel().equals("Operacional")) {
            cha.setCha_fun_id(u.getUsu_id_owner());
        } else {
            cha.setCha_dep_id(u.getUsu_dep());
        }
        //variaveis
        String id_chamado = request.getParameter("cha_id");
        String id_atividade = request.getParameter("ati_id");
        
        cha.setId(Integer.valueOf(id_chamado));
        Atividade a = new Atividade();
        a.setId(Integer.valueOf(id_atividade));
        a.setExcluir(true);
        List<Atividade> atividades = new ArrayList<>();
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
