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
/*
CREATE TABLE funcionario
(
  id integer NOT NULL,
  fun_nome character varying(255),
  fun_nf character varying(255),
  fun_nivel character varying(255),
  fun_email character varying(255),
  fun_telefone character varying(255),
  fun_cpf character varying(255),
  fun_login character varying(255),
  fun_senha character varying(255),
  fun_status character varying(255),
  CONSTRAINT fun_pk PRIMARY KEY (id)
)
 */
public class Funcionario extends EntidadeDominio {

    private String fun_nome;
    private int id;
    private String fun_nf;
    private String fun_nivel;
    private String fun_email;
    private String fun_telefone;
    private String fun_cpf;
    private String fun_login;
    private String fun_senha;
    private String fun_status;
    private int fun_responsavel;
    private int fun_dep;

    public int getFun_dep() {
        return fun_dep;
    }

    public void setFun_dep(int fun_dep) {
        this.fun_dep = fun_dep;
    }
    AlteracaoSenha alt;
    Usuario usu;

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public AlteracaoSenha getAlt() {
        return alt;
    }

    public void setAlt(AlteracaoSenha alt) {
        this.alt = alt;
    }

    public int getFun_responsavel() {
        return fun_responsavel;
    }

    public void setFun_responsavel(int fun_responsavel) {
        this.fun_responsavel = fun_responsavel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFun_nome() {
        return fun_nome;
    }

    public void setFun_nome(String fun_nome) {
        this.fun_nome = fun_nome;
    }

    public String getFun_nf() {
        return fun_nf;
    }

    public void setFun_nf(String fun_nf) {
        this.fun_nf = fun_nf;
    }

    public String getFun_nivel() {
        return fun_nivel;
    }

    public void setFun_nivel(String fun_nivel) {
        this.fun_nivel = fun_nivel;
    }

    public String getFun_email() {
        return fun_email;
    }

    public void setFun_email(String fun_email) {
        this.fun_email = fun_email;
    }

    public String getFun_telefone() {
        return fun_telefone;
    }

    public void setFun_telefone(String fun_telefone) {
        this.fun_telefone = fun_telefone;
    }

    public String getFun_cpf() {
        return fun_cpf;
    }

    public void setFun_cpf(String fun_cpf) {
        this.fun_cpf = fun_cpf;
    }

    public String getFun_login() {
        return fun_login;
    }

    public void setFun_login(String fun_login) {
        this.fun_login = fun_login;
    }

    public String getFun_senha() {
        return fun_senha;
    }

    public void setFun_senha(String fun_senha) {
        this.fun_senha = fun_senha;
    }

    public String getFun_status() {
        return fun_status;
    }

    public void setFun_status(String fun_status) {
        this.fun_status = fun_status;
    }

    public Funcionario() {

    }

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", fun_nome=" + fun_nome + ", fun_nf=" + fun_nf + ", fun_nivel=" + fun_nivel + ", fun_email=" + fun_email + ", fun_telefone=" + fun_telefone + ", fun_cpf=" + fun_cpf + ", fun_status=" + fun_status + ", fun_dep=" + fun_dep + ", alt=" + alt + ", usu=" + usu + '}';
    }

}
