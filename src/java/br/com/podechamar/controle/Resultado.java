/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.controle;

import br.com.podechamar.dominio.core.*;
import java.util.List;

/**
 *
 * @author Julio Cesar Alves
 */
public class Resultado {
    private List<EntidadeDominio> listaResultado;
    private String mensagemResultado;

    @Override
    public String toString() {
        return "Resultado{" + "listaResultado=" + listaResultado + ", mensagemResultado=" + mensagemResultado + '}';
    }

    public List<EntidadeDominio> getListaResultado() {
        return listaResultado;
    }

    public void setListaResultado(List<EntidadeDominio> listaResultado) {
        this.listaResultado = listaResultado;
    }

    public String getMensagemResultado() {
        return mensagemResultado;
    }

    public void setMensagemResultado(String mensagemResultado) {
        this.mensagemResultado = mensagemResultado;
    }
}
