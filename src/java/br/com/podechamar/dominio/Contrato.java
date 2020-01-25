/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.dominio;;

import br.com.podechamar.dominio.core.*;
import java.util.Date;

/**
 CREATE TABLE contrato
(
  con_id integer NOT NULL,
  con_cli_id integer NOT NULL,
  con_datainicio timestamp without time zone,
  con_diavencimento integer,
  con_valormensalidade numeric(10,2),
  con_valortotal numeric(10,2),
  con_tempo integer, -- tempo de validade do comntrato em meses
  con_datcadastro timestamp without time zone,
  CONSTRAINT con_pk PRIMARY KEY (con_id),
  FOREIGN KEY (con_cli_id) REFERENCES cliente(cli_id)
)
 */

public class Contrato extends EntidadeDominio{
    
  private int id;
  private String con_datainicio;
  private int con_diavencimento;
  private double con_valormensalidade;
  private double con_valortotal;
  private int con_tempo;
  private int con_cli_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCon_cli_id() {
        return con_cli_id;
    }

    public void setCon_cli_id(int con_cli_id) {
        this.con_cli_id = con_cli_id;
    }

    @Override
    public String toString() {
        return "Contrato{" + "con_id=" + id + ", con_datainicio=" + con_datainicio + ", con_diavencimento=" + con_diavencimento + ", con_valormensalidade=" + con_valormensalidade + ", con_valortotal=" + con_valortotal + ", con_tempo=" + con_tempo + '}';
    }

    public int getCon_id() {
        return id;
    }

    public void setCon_id(int con_id) {
        this.id = con_id;
    }

    public String getCon_datainicio() {
        return con_datainicio;
    }

    public void setCon_datainicio(String con_datainicio) {
        this.con_datainicio = con_datainicio;
    }

    public int getCon_diavencimento() {
        return con_diavencimento;
    }

    public void setCon_diavencimento(int con_diavencimento) {
        this.con_diavencimento = con_diavencimento;
    }

    public double getCon_valormensalidade() {
        return con_valormensalidade;
    }

    public void setCon_valormensalidade(double con_valormensalidade) {
        this.con_valormensalidade = con_valormensalidade;
    }

    public double getCon_valortotal() {
        return con_valortotal;
    }

    public void setCon_valortotal(double con_valortotal) {
        this.con_valortotal = con_valortotal;
    }

    public int getCon_tempo() {
        return con_tempo;
    }

    public void setCon_tempo(int con_tempo) {
        this.con_tempo = con_tempo;
    }

    

    public Contrato() {
    }
}
