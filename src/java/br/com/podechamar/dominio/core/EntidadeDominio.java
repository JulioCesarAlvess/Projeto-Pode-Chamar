/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.dominio.core;

/**
 *
 * @author Julio Cesar Alves
 */
public class EntidadeDominio implements I_EntidadeDominio{
    private String busca;

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public EntidadeDominio() {
    }

    @Override
    public String toString() {
        return "EntidadeDominio{" + "busca=" + busca + '}';
    } 
}
