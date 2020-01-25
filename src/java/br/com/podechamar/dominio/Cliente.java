/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.dominio;

import br.com.podechamar.dominio.core.*;
import java.util.Date;

/**
(
  cli_id integer NOT NULL,
  cli_rasaosocial character varying(255),
  cli_nomefantasia character varying(255),
  cli_contato character varying(255),
  cli_cnpj character varying(255),
  cli_ramoatividade character varying(255),
  cli_email character varying(255),
  cli_telefone character varying(255),
  cli_status character varying(255),
  cli_datcadastro timestamp without time zone,
  CONSTRAINT cli_pk PRIMARY KEY (cli_id)
)
 */
public class Cliente extends EntidadeDominio{
    
  private String cli_rasaosocial; 
  private int id;
  private String cli_nomefantasia; 
  private String cli_cnpj; 
  private String cli_contato;
  private String cli_ramoatividade; 
  private String cli_email;  
  private String cli_telefone; 
  private String cli_status; 
  private int cli_dep;
  private Endereco cli_endereco;
  private Contrato cli_contrato; 
  private Usuario usu;

    public int getCli_dep() {
        return cli_dep;
    }

    public void setCli_dep(int cli_dep) {
        this.cli_dep = cli_dep;
    }
 

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", cli_rasaosocial=" + cli_rasaosocial + ", cli_nomefantasia=" + cli_nomefantasia + ", cli_cnpj=" + cli_cnpj + ", cli_contato=" + cli_contato + ", cli_ramoatividade=" + cli_ramoatividade + ", cli_email=" + cli_email + ", cli_telefone=" + cli_telefone + ", cli_status=" + cli_status + '}';
    }

    

    public int getCli_id() {
        return id;
    }

    public void setCli_id(int cli_id) {
        this.id = cli_id;
    }

    public String getCli_rasaosocial() {
        return cli_rasaosocial;
    }

    public void setCli_rasaosocial(String cli_rasaosocial) {
        this.cli_rasaosocial = cli_rasaosocial;
    }

    public String getCli_nomefantasia() {
        return cli_nomefantasia;
    }

    public void setCli_nomefantasia(String cli_nomefantasia) {
        this.cli_nomefantasia = cli_nomefantasia;
    }

    public Contrato getCli_contrato() {
        return cli_contrato;
    }

    public void setCli_contrato(Contrato cli_contrato) {
        this.cli_contrato = cli_contrato;
    }

    public String getCli_cnpj() {
        return cli_cnpj;
    }

    public void setCli_cnpj(String cli_cnpj) {
        this.cli_cnpj = cli_cnpj;
    }

    public String getCli_ramoatividade() {
        return cli_ramoatividade;
    }

    public void setCli_ramoatividade(String cli_ramoatividade) {
        this.cli_ramoatividade = cli_ramoatividade;
    }

    public String getCli_email() {
        return cli_email;
    }

    public void setCli_email(String cli_email) {
        this.cli_email = cli_email;
    }

    public String getCli_telefone() {
        return cli_telefone;
    }

    public void setCli_telefone(String cli_telefone) {
        this.cli_telefone = cli_telefone;
    }

    public String getCli_status() {
        return cli_status;
    }

    public void setCli_status(String cli_status) {
        this.cli_status = cli_status;
    }

    /*public Date getCli_datcadastro() {
        return cli_datcadastro;
    }*/

    /*public void setCli_datcadastro(Date cli_datcadastro) {
        this.cli_datcadastro = cli_datcadastro;
    }*/

    public Endereco getCli_endereco() {
        return cli_endereco;
    }

    public void setCli_endereco(Endereco cli_endereco) {
        this.cli_endereco = cli_endereco;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCli_contato() {
        return cli_contato;
    }

    public void setCli_contato(String cli_contato) {
        this.cli_contato = cli_contato;
    }
    
    public Cliente() {
    }

    
}
