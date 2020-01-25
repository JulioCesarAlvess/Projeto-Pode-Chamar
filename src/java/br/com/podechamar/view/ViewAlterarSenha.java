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

/**
 *
 * @author leofa
 */
public class ViewAlterarSenha extends ViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        
        Usuario u = new Usuario();
        AlteracaoSenha alt = new AlteracaoSenha();

        //preencher o objeto
        
        
        String id = request.getParameter("id");
        String senha = request.getParameter("usu_senha");
        String novaSenha = request.getParameter("usu_novasenha");
        String confirmação = request.getParameter("usu_confirmacao");
        u.setId(Integer.valueOf(id));
        u.setUsu_senha(senha);
        alt.setConfirmacao(confirmação);
        alt.setNovaSenha(novaSenha);
        u.setAlt(alt);
        return u;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        resultado.setMensagemResultado(resultado.getMensagemResultado().replace("#", "</br>"));
        request.setAttribute("mensagem", resultado.getMensagemResultado());
        request.getRequestDispatcher("/funcionario_alterarSenha.jsp").forward(request, response);
    }
    
}
