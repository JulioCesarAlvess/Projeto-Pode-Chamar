/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dao.DaoChamado;
import br.com.podechamar.dao.*;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;

/**
 *
 * @author Julio Cesar Alves
 */
public class ChamadoMovimentaEstoque implements I_Strategy {

    @Override
    public String executar(EntidadeDominio entidade) {
        Chamado cha = (Chamado) entidade;
        DaoProduto daop = new DaoProduto();
        DaoChamado daoc = new DaoChamado();
        
        if (cha.getCha_status() != null) {

            if (cha.getCha_status().equals("Aberto")) {
                for (Item i : cha.getItens()) {
                    Produto p = new Produto();
                    p = (Produto) daop.consultar(i.getP()).get(0);
                    p.setPro_reservado(p.getPro_reservado() + i.getQuantidade());
                    p.setPro_disponivel(p.getPro_disponivel() - i.getQuantidade());
                    daop.alterar(p);
                }
            } else if (cha.getCha_status().equals("Pendente")) {
                for (Item i : cha.getItens()) {
                    Produto p = new Produto();
                    p = (Produto) daop.consultar(i.getP()).get(0);
                    p.setPro_reservado(p.getPro_reservado() + i.getQuantidade());
                    p.setPro_disponivel(p.getPro_disponivel() - i.getQuantidade());
                    daop.alterar(p);
                }
            } else if (cha.getCha_status().equals("Retido") || cha.getCha_status().equals("Cancelado")) {
                Chamado c = (Chamado) daoc.consultar(cha).get(0);
                for (Item i : c.getItens()) {
                    Produto p = new Produto();
                    p = (Produto) daop.consultar(i.getP()).get(0);
                    p.setPro_reservado(p.getPro_reservado() - i.getQuantidade());
                    p.setPro_disponivel(p.getPro_disponivel() + i.getQuantidade());
                    daop.alterar(p);
                }
            } else if (cha.getCha_status().equals("Concluido")) {
                Chamado c = (Chamado) daoc.consultar(cha).get(0);
                for (Item i : c.getItens()) {
                    Produto p = new Produto();
                    p = (Produto) daop.consultar(i.getP()).get(0);
                    p.setPro_reservado(p.getPro_reservado() - i.getQuantidade());
                    p.setPro_fisico(p.getPro_fisico() - i.getQuantidade());
                    daop.alterar(p);
                }
            }
        }
        return "";
    }

}
