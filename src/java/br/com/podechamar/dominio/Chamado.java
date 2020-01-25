/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.dominio;

import br.com.podechamar.dominio.core.EntidadeDominio;
import java.util.List;

/**
 *
 * @author Julio Cesar Alves id serial NOT NULL, cha_databertura character
 * varying(255), cha_datafechamento character varying(255), cha_feedback_cli
 * character varying(255), cha_feedback_fun character varying(255), cha_nota_fun
 * integer, cha_nota_cli integer, cha_cli_id integer, cha_fun_id integer,
 * cha_severidade character varying(255), cha_dep_id integer, cha_tipo_id
 * integer, cha_solicitante character varying(255), cha_sla numeric(8,2),
 * cha_status character varying(255), cha_fun character varying(255), cha_cli
 * character varying(255), cha_dep character varying(255), cha_tipo character
 * varying(255),
 */
public class Chamado extends EntidadeDominio {
    private String cha_databertura;
    private int id;
    private String cha_datafechamento;
    private String cha_feedback_cli;
    private String cha_feedback_fun;
    private String cha_severidade;
    private String cha_solicitante;
    private String cha_descricao;
    private int cha_nota_fun;
    private int cha_nota_cli;
    private double cha_sla;
    private int cha_cli_id;
    private int cha_fun_id;
    private int cha_dep_id;
    private int cha_tipo_id;
    private String cha_status;
    private String cha_fun;
    private String cha_cli;
    private String cha_dep;
    private String cha_tipo;
    private String cha_justificativa;

    public String getCha_justificativa() {
        return cha_justificativa;
    }

    public void setCha_justificativa(String cha_justificativa) {
        this.cha_justificativa = cha_justificativa;
    }
    
    private List<Item> itens;
    private List<Atividade> atividades;

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    
    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
    

    public String getCha_descricao() {
        return cha_descricao;
    }

    public void setCha_descricao(String cha_descricao) {
        this.cha_descricao = cha_descricao;
    }

    public Chamado() {
    }

    public Chamado(int id, String cha_databertura, String cha_datafechamento, String cha_feedback_cli, String cha_feedback_fun, String cha_severidade, String cha_solicitante, int cha_nota_fun, int cha_nota_cli, double cha_sla, int cha_cli_id, int cha_fun_id, int cha_dep_id, int cha_tipo_id, String cha_status, String cha_fun, String cha_cli, String cha_dep, String cha_tipo) {
        this.id = id;
        this.cha_databertura = cha_databertura;
        this.cha_datafechamento = cha_datafechamento;
        this.cha_feedback_cli = cha_feedback_cli;
        this.cha_feedback_fun = cha_feedback_fun;
        this.cha_severidade = cha_severidade;
        this.cha_solicitante = cha_solicitante;
        this.cha_nota_fun = cha_nota_fun;
        this.cha_nota_cli = cha_nota_cli;
        this.cha_sla = cha_sla;
        this.cha_cli_id = cha_cli_id;
        this.cha_fun_id = cha_fun_id;
        this.cha_dep_id = cha_dep_id;
        this.cha_tipo_id = cha_tipo_id;
        this.cha_status = cha_status;
        this.cha_fun = cha_fun;
        this.cha_cli = cha_cli;
        this.cha_dep = cha_dep;
        this.cha_tipo = cha_tipo;
    }

    @Override
    public String toString() {
        return "Chamado{" + "id=" + id + ", cha_databertura=" + cha_databertura + ", cha_datafechamento=" + cha_datafechamento + ", cha_feedback_cli=" + cha_feedback_cli + ", cha_feedback_fun=" + cha_feedback_fun + ", cha_severidade=" + cha_severidade + ", cha_solicitante=" + cha_solicitante + ", cha_nota_fun=" + cha_nota_fun + ", cha_nota_cli=" + cha_nota_cli + ", cha_sla=" + cha_sla +  ", cha_status=" + cha_status + ", cha_fun=" + cha_fun + ", cha_cli=" + cha_cli + ", cha_dep=" + cha_dep + ", cha_tipo=" + cha_tipo + '}';
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
     * @return the cha_databertura
     */
    public String getCha_databertura() {
        return cha_databertura;
    }

    /**
     * @param cha_databertura the cha_databertura to set
     */
    public void setCha_databertura(String cha_databertura) {
        this.cha_databertura = cha_databertura;
    }

    /**
     * @return the cha_datafechamento
     */
    public String getCha_datafechamento() {
        return cha_datafechamento;
    }

    /**
     * @param cha_datafechamento the cha_datafechamento to set
     */
    public void setCha_datafechamento(String cha_datafechamento) {
        this.cha_datafechamento = cha_datafechamento;
    }

    /**
     * @return the cha_feedback_cli
     */
    public String getCha_feedback_cli() {
        return cha_feedback_cli;
    }

    /**
     * @param cha_feedback_cli the cha_feedback_cli to set
     */
    public void setCha_feedback_cli(String cha_feedback_cli) {
        this.cha_feedback_cli = cha_feedback_cli;
    }

    /**
     * @return the cha_feedback_fun
     */
    public String getCha_feedback_fun() {
        return cha_feedback_fun;
    }

    /**
     * @param cha_feedback_fun the cha_feedback_fun to set
     */
    public void setCha_feedback_fun(String cha_feedback_fun) {
        this.cha_feedback_fun = cha_feedback_fun;
    }

    /**
     * @return the cha_severidade
     */
    public String getCha_severidade() {
        return cha_severidade;
    }

    /**
     * @param cha_severidade the cha_severidade to set
     */
    public void setCha_severidade(String cha_severidade) {
        this.cha_severidade = cha_severidade;
    }

    /**
     * @return the cha_solicitante
     */
    public String getCha_solicitante() {
        return cha_solicitante;
    }

    /**
     * @param cha_solicitante the cha_solicitante to set
     */
    public void setCha_solicitante(String cha_solicitante) {
        this.cha_solicitante = cha_solicitante;
    }

    /**
     * @return the cha_nota_fun
     */
    public int getCha_nota_fun() {
        return cha_nota_fun;
    }

    /**
     * @param cha_nota_fun the cha_nota_fun to set
     */
    public void setCha_nota_fun(int cha_nota_fun) {
        this.cha_nota_fun = cha_nota_fun;
    }

    /**
     * @return the cha_nota_cli
     */
    public int getCha_nota_cli() {
        return cha_nota_cli;
    }

    /**
     * @param cha_nota_cli the cha_nota_cli to set
     */
    public void setCha_nota_cli(int cha_nota_cli) {
        this.cha_nota_cli = cha_nota_cli;
    }

    /**
     * @return the cha_sla
     */
    public double getCha_sla() {
        return cha_sla;
    }

    /**
     * @param cha_sla the cha_sla to set
     */
    public void setCha_sla(double cha_sla) {
        this.cha_sla = cha_sla;
    }

    /**
     * @return the cha_cli_id
     */
    public int getCha_cli_id() {
        return cha_cli_id;
    }

    /**
     * @param cha_cli_id the cha_cli_id to set
     */
    public void setCha_cli_id(int cha_cli_id) {
        this.cha_cli_id = cha_cli_id;
    }

    /**
     * @return the cha_fun_id
     */
    public int getCha_fun_id() {
        return cha_fun_id;
    }

    /**
     * @param cha_fun_id the cha_fun_id to set
     */
    public void setCha_fun_id(int cha_fun_id) {
        this.cha_fun_id = cha_fun_id;
    }

    /**
     * @return the cha_dep_id
     */
    public int getCha_dep_id() {
        return cha_dep_id;
    }

    /**
     * @param cha_dep_id the cha_dep_id to set
     */
    public void setCha_dep_id(int cha_dep_id) {
        this.cha_dep_id = cha_dep_id;
    }

    /**
     * @return the cha_tipo_id
     */
    public int getCha_tipo_id() {
        return cha_tipo_id;
    }

    /**
     * @param cha_tipo_id the cha_tipo_id to set
     */
    public void setCha_tipo_id(int cha_tipo_id) {
        this.cha_tipo_id = cha_tipo_id;
    }

    /**
     * @return the cha_status
     */
    public String getCha_status() {
        return cha_status;
    }

    /**
     * @param cha_status the cha_status to set
     */
    public void setCha_status(String cha_status) {
        this.cha_status = cha_status;
    }

    /**
     * @return the cha_fun
     */
    public String getCha_fun() {
        return cha_fun;
    }

    /**
     * @param cha_fun the cha_fun to set
     */
    public void setCha_fun(String cha_fun) {
        this.cha_fun = cha_fun;
    }

    /**
     * @return the cha_cli
     */
    public String getCha_cli() {
        return cha_cli;
    }

    /**
     * @param cha_cli the cha_cli to set
     */
    public void setCha_cli(String cha_cli) {
        this.cha_cli = cha_cli;
    }

    /**
     * @return the cha_dep
     */
    public String getCha_dep() {
        return cha_dep;
    }

    /**
     * @param cha_dep the cha_dep to set
     */
    public void setCha_dep(String cha_dep) {
        this.cha_dep = cha_dep;
    }

    /**
     * @return the cha_tipo
     */
    public String getCha_tipo() {
        return cha_tipo;
    }

    /**
     * @param cha_tipo the cha_tipo to set
     */
    public void setCha_tipo(String cha_tipo) {
        this.cha_tipo = cha_tipo;
    }

   
}
