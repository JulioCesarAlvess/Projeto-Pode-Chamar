/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.controle.core;

import br.com.podechamar.controle.*;

/**
 *
 * @author Julio Cesar Alves
 */
public abstract class AbstractComando implements I_Comando{
    protected I_Fachada fachada;
    public AbstractComando(){
        fachada = new Fachada();
    }
}
