/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.dominio;

import br.com.podechamar.dominio.core.EntidadeDominio;

/**
 *
 * @author leofa
 */
public class Atividade extends EntidadeDominio {

    private String ati_nome;
    private int id;
    private String ati_descricao;
    private String ati_status;
    private boolean excluir;

    public boolean getExcluir() {
        return excluir;
    }

    public void setExcluir(boolean excluir) {
        this.excluir = excluir;
    }

    public Atividade() {
        this.excluir = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAti_nome() {
        return ati_nome;
    }

    public void setAti_nome(String ati_nome) {
        this.ati_nome = ati_nome;
    }

    public String getAti_descricao() {
        return ati_descricao;
    }

    public void setAti_descricao(String ati_descricao) {
        this.ati_descricao = ati_descricao;
    }

    public String getAti_status() {
        return ati_status;
    }

    public void setAti_status(String ati_status) {
        this.ati_status = ati_status;
    }

    @Override
    public String toString() {
        return "Atividade{" + "id=" + id + ", ati_nome=" + ati_nome + ", ati_descricao=" + ati_descricao + ", ati_status=" + ati_status + '}';
    }

}
