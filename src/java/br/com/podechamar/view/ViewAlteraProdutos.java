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
 * @author Julio Cesar Alves
 */
public class ViewAlteraProdutos extends ViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        Produto pro = new Produto();
        DadosVisao visao = new DadosVisao(request);
        
        try{
        pro = (Produto) preencher(visao, pro.getClass());
        pro.setPro_disponivel(pro.getPro_fisico() - pro.getPro_reservado());
        pro.setPro_preco_venda(pro.getPro_preco_compra() + (pro.getPro_preco_compra() * (pro.getPro_margem_lucro() / 100)));
        }catch(Exception ex){
            pro = new Produto(0, "", "", "", 0, 0, 0, "", "", 0, 0, 0, 0);
        }
        return pro;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("produto", resultado.getListaResultado().get(0));
        request.setAttribute("mensagem", resultado.getMensagemResultado());
        request.getRequestDispatcher("/produto_atualizar.jsp").forward(request, response);
    }
}
