/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.dominio;

/**
 *
 * @author Julio Cesar Alves
 */
public class Item {
   private Produto p;
   private int quantidade;
   private boolean excluir;

    public Item() {
        this.excluir = false;
    }

   
    public boolean getExcluir() {
        return excluir;
    }

    public void setExcluir(boolean excluir) {
        this.excluir = excluir;
    }
   
    /**
     * @return the p
     */
    public Produto getP() {
        return p;
    }

    /**
     * @param p the p to set
     */
    public void setP(Produto p) {
        this.p = p;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
