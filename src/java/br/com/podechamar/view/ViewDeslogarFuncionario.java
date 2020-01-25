/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.dominio.Funcionario;
import br.com.podechamar.controle.Resultado;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.util.Criptografa;
import br.com.podechamar.view.core.DadosVisao;
import br.com.podechamar.view.core.ViewHelper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author leofa
 */
public class ViewDeslogarFuncionario extends ViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {

        Funcionario fun = new Funcionario();
        String login = request.getParameter("fun_login");
        String senha = request.getParameter("fun_senha");

        //preencher o objeto
        fun.setFun_login(login);
        if (login != null) {
            if (senha.length() > 1) {
                fun.setFun_senha(Criptografa.criaHash(senha));
            } else {
                fun.setFun_senha(senha);
            }
        }
        //dados do endereco
        return fun;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if (!resultado.getListaResultado().isEmpty()) {
            HttpSession sessao = request.getSession();
            sessao.invalidate();
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
