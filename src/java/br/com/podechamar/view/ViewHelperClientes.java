/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.controle.Resultado;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.util.Criptografa;
import br.com.podechamar.view.core.DadosVisao;
import br.com.podechamar.view.core.I_ViewHelper;
import br.com.podechamar.view.core.ViewHelper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio Cesar Alves
 */
public class ViewHelperClientes extends ViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        //instanciar objetos
        Cliente cli = new Cliente();
        Contrato con = new Contrato();
        Endereco end = new Endereco();
        Usuario usu = new Usuario();
        DadosVisao visao = new DadosVisao(request);

        cli = (Cliente) preencher(visao, cli.getClass());
        end = (Endereco) preencher(visao, end.getClass());
        //con = (Contrato)preencher(visao, con.getClass()); Deu errado essa parte, revisar depois

        String con_datainicio = request.getParameter("con_datainicio");
        String con_diavencimento = request.getParameter("con_diavencimento");
        String con_valormensalidade = request.getParameter("con_valormensalidade");
        String con_tempo = request.getParameter("con_tempo");

        try {
            con.setCon_datainicio(con_datainicio);
            con.setCon_diavencimento(Integer.valueOf(con_diavencimento));
            con.setCon_valormensalidade(Double.valueOf(con_valormensalidade));
            con.setCon_tempo(Integer.valueOf(con_tempo));
        } catch (Exception ex) {
            con.setCon_datainicio("");
            con.setCon_diavencimento(0);
            con.setCon_valormensalidade(0);
            con.setCon_tempo(0);
        }
        
        String senha = request.getParameter("cli_senha");
        try{
        usu.setUsu_login(request.getParameter("cli_login"));
        if(senha != null){
            if(senha.length() > 0){
                usu.setUsu_senha(Criptografa.criaHash(senha));
            }
            else
                usu.setUsu_senha("");
        }
        usu.setUsu_papel("Cliente");
        usu.setUsu_dep(14);
        }catch(Exception ex){
            usu = new Usuario(0, "", "", "", 0, 0, null);
        }

        cli.setCli_endereco(end);
        cli.setCli_contrato(con);
        cli.setUsu(usu);
        
        return cli;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (resultado.getMensagemResultado().equals("Salvo com Sucesso!#")) {
            request.setAttribute("mensagem", "Cliente Salvo com sucesso!");
            request.getRequestDispatcher("/cliente_gestao.jsp").forward(request, response);
        } else {
            resultado.setMensagemResultado(resultado.getMensagemResultado().replace("#", "</br>"));
            request.setAttribute("mensagem", resultado.getMensagemResultado());
            request.getRequestDispatcher("/cliente_gestao.jsp").forward(request, response);
        }
    }

}
