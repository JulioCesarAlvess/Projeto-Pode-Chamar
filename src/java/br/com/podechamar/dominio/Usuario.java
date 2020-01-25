/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.dominio;

import br.com.podechamar.dominio.core.EntidadeDominio;

/**
 *
 * @author Julio Cesar Alves
 * id serial NOT NULL,
  usu_login character varying(255),
  usu_senha character varying(255),
  usu_papel character varying(255),
 */
public class Usuario extends EntidadeDominio{
    private int id;
    private String usu_login;
    private String usu_senha;
    private String usu_papel;
    private int usu_id_owner;
    private int usu_dep;

    public int getUsu_id_owner() {
        return usu_id_owner;
    }

    public void setUsu_id_owner(int usu_id_owner) {
        this.usu_id_owner = usu_id_owner;
    }
   
    

    public int getUsu_dep() {
        return usu_dep;
    }

    public void setUsu_dep(int usu_dep) {
        this.usu_dep = usu_dep;
    }
    private AlteracaoSenha alt;

    public AlteracaoSenha getAlt() {
        return alt;
    }

    public void setAlt(AlteracaoSenha alt) {
        this.alt = alt;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the usu_login
     */
    public String getUsu_login() {
        return usu_login;
    }

    /**
     * @param usu_login the usu_login to set
     */
    public void setUsu_login(String usu_login) {
        this.usu_login = usu_login;
    }

    /**
     * @return the usu_senha
     */
    public String getUsu_senha() {
        return usu_senha;
    }

    /**
     * @param usu_senha the usu_senha to set
     */
    public void setUsu_senha(String usu_senha) {
        this.usu_senha = usu_senha;
    }

    /**
     * @return the usu_papel
     */
    public String getUsu_papel() {
        return usu_papel;
    }

    /**
     * @param usu_papel the usu_papel to set
     */
    public void setUsu_papel(String usu_papel) {
        this.usu_papel = usu_papel;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", usu_login=" + usu_login + ", usu_senha=" + usu_senha + ", usu_papel=" + usu_papel + '}';
    }

    public Usuario() {
    }

    public Usuario(int id, String usu_login, String usu_senha, String usu_papel, int usu_id_owner, int usu_dep, AlteracaoSenha alt) {
        this.id = id;
        this.usu_login = usu_login;
        this.usu_senha = usu_senha;
        this.usu_papel = usu_papel;
        this.usu_id_owner = usu_id_owner;
        this.usu_dep = usu_dep;
        this.alt = alt;
    }
    
    
    
}
