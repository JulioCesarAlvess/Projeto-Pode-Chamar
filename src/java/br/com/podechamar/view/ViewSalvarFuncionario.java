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
import br.com.podechamar.view.core.DadosVisao;
import br.com.podechamar.view.core.ViewHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author leofa
 */
public class ViewSalvarFuncionario extends ViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        //instanciar objetos
        Funcionario fun = new Funcionario();
        Usuario usu = new Usuario();
        DadosVisao visao = new DadosVisao(request);

        fun = (Funcionario) preencher(visao, fun.getClass());
        
        usu.setUsu_login(fun.getFun_login());
        usu.setUsu_senha(fun.getFun_senha());
        usu.setUsu_papel(fun.getFun_nivel());
        usu.setUsu_dep(fun.getFun_dep());
        
        fun.setUsu(usu);
        
        return fun;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (resultado.getMensagemResultado() != null) {
            resultado.setMensagemResultado(resultado.getMensagemResultado().replace("#", "</br>"));
            request.setAttribute("mensagem", resultado.getMensagemResultado());
        }
        if (resultado.getListaResultado()!= null) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("funcionarios", resultado.getListaResultado());
        }
        request.getRequestDispatcher("/funcionario_gestao.jsp").forward(request, response);
    }

}
