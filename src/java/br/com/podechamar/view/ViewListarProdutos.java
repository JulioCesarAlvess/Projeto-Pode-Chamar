/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view;

import br.com.podechamar.controle.Resultado;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.view.core.I_ViewHelper;
import br.com.podechamar.view.core.ViewHelper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio Cesar Alves
 */
public class ViewListarProdutos extends ViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
        Produto pro = new Produto();
        String fisico = request.getParameter("pro_fisico");
        String reservado = request.getParameter("pro_reservado");
        String movimentacao = request.getParameter("movimentacao");
        String quantidade = request.getParameter("quantidade");

        try {
            pro.setId(Integer.valueOf(request.getParameter("id")));
        } catch (Exception ex) {
            pro.setId(0);
        }
        pro.setBusca(request.getParameter("busca"));

        try {
            MovimentacaoEstoque mov = new MovimentacaoEstoque();
            mov.setMovimento(movimentacao);
            mov.setQuantidade(Integer.valueOf(quantidade));
            pro.setPro_fisico(Integer.valueOf(fisico));
            pro.setPro_reservado(Integer.valueOf(reservado));
            pro.setEst(mov);
        } catch (Exception ex) {
             pro.setEst(null);       
        }
        return pro;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("produtos", resultado.getListaResultado());
        request.getRequestDispatcher("/produto_lista.jsp").forward(request, response);
    }

}
