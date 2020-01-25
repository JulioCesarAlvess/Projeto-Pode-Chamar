/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.dominio;;

import br.com.podechamar.dominio.core.*;
import java.util.Date;

/**
(
  end_id integer NOT NULL,
  end_cli_id integer NOT NULL,
  end_rua character varying(255),
  end_numero character varying(255),
  end_bairro character varying(255),
  end_cidade character varying(255),
  end_estado character varying(255),
  end_pais character varying(255),
  end_datcadastro timestamp without time zone,
  CONSTRAINT end_pk PRIMARY KEY (end_id),
  FOREIGN KEY (end_cli_id) REFERENCES cliente(cli_id)
)
 */
public class Endereco extends EntidadeDominio{
  private int id;
  private String end_rua;
  private String end_numero;
  private String end_bairro;
  private String end_cidade;
  private String end_estado;
  private String end_pais;
  private int end_cli_id;
  private String end_cep;
  //private Date end_datcadastro;

    public String getEnd_cep() {
        return end_cep;
    }

    public void setEnd_cep(String end_cep) {
        this.end_cep = end_cep;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnd_cli_id() {
        return end_cli_id;
    }

    public void setEnd_cli_id(int end_cli_id) {
        this.end_cli_id = end_cli_id;
    }

    @Override
    public String toString() {
        return "Endereco{" + "end_id=" + id + ", end_rua=" + end_rua + ", end_numero=" + end_numero + ", end_bairro=" + end_bairro + ", end_cidade=" + end_cidade + ", end_estado=" + end_estado + ", end_pais=" + end_pais + /*", end_datcadastro=" + end_datcadastro + */'}';
    }


    public String getEnd_rua() {
        return end_rua;
    }

    public void setEnd_rua(String end_rua) {
        this.end_rua = end_rua;
    }

    public String getEnd_numero() {
        return end_numero;
    }

    public void setEnd_numero(String end_numero) {
        this.end_numero = end_numero;
    }

    public String getEnd_bairro() {
        return end_bairro;
    }

    public void setEnd_bairro(String end_bairro) {
        this.end_bairro = end_bairro;
    }

    public String getEnd_cidade() {
        return end_cidade;
    }

    public void setEnd_cidade(String end_cidade) {
        this.end_cidade = end_cidade;
    }

    public String getEnd_estado() {
        return end_estado;
    }

    public void setEnd_estado(String end_estado) {
        this.end_estado = end_estado;
    }

    public String getEnd_pais() {
        return end_pais;
    }

    public void setEnd_pais(String end_pais) {
        this.end_pais = end_pais;
    }

    /*public Date getEnd_datcadastro() {
        return end_datcadastro;
    }*/

   /* public void setEnd_datcadastro(Date end_datcadastro) {
        this.end_datcadastro = end_datcadastro;
    }*/

    public Endereco() {
    }

}
