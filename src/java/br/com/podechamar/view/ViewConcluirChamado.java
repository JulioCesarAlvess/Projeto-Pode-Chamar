/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.controle.Resultado;
import br.com.podechamar.dominio.Atividade;
import br.com.podechamar.dominio.Chamado;
import br.com.podechamar.dominio.Funcionario;
import br.com.podechamar.dominio.Usuario;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.view.core.ViewHelper;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio Cesar Alves
 */
public class ViewConcluirChamado extends ViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Usuario u = (Usuario) httpRequest.getSession().getAttribute("usuAutenticado");
        
        List<Funcionario> funcionarios = (List<Funcionario>) httpRequest.getSession().getAttribute("funcionarios");

        //variaveis
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        Chamado cha = new Chamado();
        cha.setId(Integer.valueOf(request.getParameter("id")));
        cha.setCha_status("Concluido");
        cha.setCha_datafechamento(reportDate);
        
        if (u.getUsu_papel().equals("Cliente")) {
            cha.setCha_cli_id(u.getUsu_id_owner());
        } else if (u.getUsu_papel().equals("Operacional")) {
            cha.setCha_fun_id(u.getUsu_id_owner());
        } else {
            cha.setCha_dep_id(u.getUsu_dep());
        }
        
        return cha;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("chamados", resultado.getListaResultado());
        request.setAttribute("mensagem", resultado.getMensagemResultado());
        request.getRequestDispatcher("/chamados_lista.jsp").forward(request, response);
    }

}
