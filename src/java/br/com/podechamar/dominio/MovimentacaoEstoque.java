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
public class MovimentacaoEstoque {
    int quantidade;
    String movimento;

    @Override
    public String toString() {
        return "MovimentacaoEstoque{" + "quantidade=" + quantidade + ", movimento=" + movimento + '}';
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMovimento() {
        return movimento;
    }

    public void setMovimento(String movimento) {
        this.movimento = movimento;
    }

    public MovimentacaoEstoque(int quantidade, String movimento) {
        this.quantidade = quantidade;
        this.movimento = movimento;
    }

    public MovimentacaoEstoque() {
    }
    
}
