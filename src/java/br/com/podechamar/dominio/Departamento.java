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
public class Departamento extends EntidadeDominio {

    private String dep_nome;
    private int id;
    private String dep_descricao;
    private String dep_status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDep_nome() {
        return dep_nome;
    }

    public void setDep_nome(String dep_nome) {
        this.dep_nome = dep_nome;
    }

    public String getDep_descricao() {
        return dep_descricao;
    }

    public void setDep_descricao(String dep_descricao) {
        this.dep_descricao = dep_descricao;
    }

    public String getDep_status() {
        return dep_status;
    }

    public void setDep_status(String dep_status) {
        this.dep_status = dep_status;
    }

    @Override
    public String toString() {
        return "Departamento{" + "id=" + id + ", dep_nome=" + dep_nome + ", dep_descricao=" + dep_descricao + ", dep_status=" + dep_status + '}';
    }
}
