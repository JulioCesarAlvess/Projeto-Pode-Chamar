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
 *   
 * id serial NOT NULL,
  his_usuario character varying(255),
  his_valoranterior character varying(255),
  his_operacao character varying(255),
  his_dataalteracao character varying(255),
  his_entidade character varying(255),
  his_id character varying(255),
 */
public class Historico extends EntidadeDominio{
  private String his_usuario ;
  private int id;
  private String his_valoranterior ;
  private String his_operacao ;
  private String his_dataalteracao ;
  private String his_entidade ;
  private String his_id ;

    public String getHis_entidade() {
        return his_entidade;
    }

    public void setHis_entidade(String his_entidade) {
        this.his_entidade = his_entidade;
    }

    public String getHis_id() {
        return his_id;
    }

    public void setHis_id(String his_id) {
        this.his_id = his_id;
    }

    public Historico() {
    }

    public Historico(int id, String his_usuario, String his_valoranterior, String his_operacao, String his_dataalteracao, String his_entidade, String his_id) {
        this.id = id;
        this.his_usuario = his_usuario;
        this.his_valoranterior = his_valoranterior;
        this.his_operacao = his_operacao;
        this.his_dataalteracao = his_dataalteracao;
        this.his_entidade = his_entidade;
        this.his_id = his_id;
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
     * @return the his_usuario
     */
    public String getHis_usuario() {
        return his_usuario;
    }

    /**
     * @param his_usuario the his_usuario to set
     */
    public void setHis_usuario(String his_usuario) {
        this.his_usuario = his_usuario;
    }

    /**
     * @return the his_valoranterior
     */
    public String getHis_valoranterior() {
        return his_valoranterior;
    }

    /**
     * @param his_valoranterior the his_valoranterior to set
     */
    public void setHis_valoranterior(String his_valoranterior) {
        this.his_valoranterior = his_valoranterior;
    }

    /**
     * @return the his_operacao
     */
    public String getHis_operacao() {
        return his_operacao;
    }

    /**
     * @param his_operacao the his_operacao to set
     */
    public void setHis_operacao(String his_operacao) {
        this.his_operacao = his_operacao;
    }

    /**
     * @return the his_dataalteracao
     */
    public String getHis_dataalteracao() {
        return his_dataalteracao;
    }

    /**
     * @param his_dataalteracao the his_dataalteracao to set
     */
    public void setHis_dataalteracao(String his_dataalteracao) {
        this.his_dataalteracao = his_dataalteracao;
    }
  
  
}
