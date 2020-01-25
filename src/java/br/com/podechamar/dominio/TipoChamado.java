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
 *
 */
public class TipoChamado extends EntidadeDominio {

    private String tch_nome;
    private int id;
    private String tch_descricao;
    private String tch_status;
    private double tch_critico;
    private double tch_urgente;
    private double tch_normal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTch_descricao() {
        return tch_descricao;
    }

    public void setTch_descricao(String tch_descricao) {
        this.tch_descricao = tch_descricao;
    }

    public String getTch_status() {
        return tch_status;
    }

    public void setTch_status(String tch_status) {
        this.tch_status = tch_status;
    }

    public String getTch_nome() {
        return tch_nome;
    }

    public void setTch_nome(String tch_nome) {
        this.tch_nome = tch_nome;
    }

    public double getTch_critico() {
        return tch_critico;
    }

    public void setTch_critico(double tch_critico) {
        this.tch_critico = tch_critico;
    }

    public double getTch_urgente() {
        return tch_urgente;
    }

    public void setTch_urgente(double tch_urgente) {
        this.tch_urgente = tch_urgente;
    }

    public double getTch_normal() {
        return tch_normal;
    }

    public void setTch_normal(double tch_normal) {
        this.tch_normal = tch_normal;
    }

    @Override
    public String toString() {
        return "TipoChamado{" + "id=" + id + ", tch_nome=" + tch_nome + ", tch_descricao=" + tch_descricao + ", tch_status=" + tch_status + ", tch_critico=" + tch_critico + ", tch_urgente=" + tch_urgente + ", tch_normal=" + tch_normal + '}';
    }

    public TipoChamado(int id, String tch_nome, String tch_descricao, String tch_status, double tch_critico, double tch_urgente, double tch_normal) {
        this.id = id;
        this.tch_nome = tch_nome;
        this.tch_descricao = tch_descricao;
        this.tch_status = tch_status;
        this.tch_critico = tch_critico;
        this.tch_urgente = tch_urgente;
        this.tch_normal = tch_normal;
    }

    public TipoChamado() {
    }

}
