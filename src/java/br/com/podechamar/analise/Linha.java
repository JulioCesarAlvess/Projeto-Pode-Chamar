/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.analise;

/**
 *
 * @author Julio Cesar Alves
 */
public class Linha {
    public String legenda;
    public int valores [] = new int [12]; 

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public int[] getValores() {
        return valores;
    }

    public void setValores(int[] valores) {
        this.valores = valores;
    }

    public Linha() {
        for (int i = 0; i < 12; i++){
            valores[i] = 0;
        }
    }
}
