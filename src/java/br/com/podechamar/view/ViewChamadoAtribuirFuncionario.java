/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.controle.Resultado;
import br.com.podechamar.dominio.Chamado;
import br.com.podechamar.dominio.Departamento;
import br.com.podechamar.dominio.Funcionario;
import br.com.podechamar.dominio.Usuario;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.view.core.ViewHelper;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio Cesar Alves
 */
public class ViewChamadoAtribuirFuncionario extends ViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        Chamado cha = new Chamado();

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Usuario u = (Usuario) httpRequest.getSession().getAttribute("usuAutenticado");
        
        List<Funcionario> funcionarios = (List<Funcionario>) httpRequest.getSession().getAttribute("funcionarios");

        if (u.getUsu_papel().equals("Cliente")) {
            cha.setCha_cli_id(u.getUsu_id_owner());
        } else if (u.getUsu_papel().equals("Operacional")) {
            cha.setCha_fun_id(u.getUsu_id_owner());
        } else {
            cha.setCha_dep_id(u.getUsu_dep());
        }
        
        String id = request.getParameter("id");
        cha.setId(Integer.valueOf(id));
        
        String id_funcionario = request.getParameter("funcionario_id");
        cha.setCha_fun_id(Integer.valueOf(id_funcionario));
        
        for (Funcionario f : funcionarios) {
            if (f.getId() == cha.getCha_fun_id()) {
                cha.setCha_fun(f.getFun_nome());
            }
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
