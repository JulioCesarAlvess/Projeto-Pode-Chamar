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
 * id integer NOT NULL, pro_nome character varying(255), pro_ean character
 * varying(255), pro_descricao character varying(255), pro_preco_compra
 * numeric(8,2), pro_quantidade integer, pro_margem_lucro integer, pro_tipo
 * character varying(255), pro_status character varying(255), pro_disponivel
 * integer, pro_fisico integer, pro_reservado integer, pro_preco_venda
 * numeric(8,2),
 */
public class Produto extends EntidadeDominio {
    private String pro_nome;
    private int id;
    private String pro_ean;
    private String pro_descricao;
    private double pro_preco_compra;
    private int pro_quantidade;
    private double pro_margem_lucro;
    private String pro_tipo;
    private String pro_status;
    private int pro_disponivel;
    private int pro_fisico;
    private int pro_reservado;
    private double pro_preco_venda;
    private MovimentacaoEstoque est;

    public MovimentacaoEstoque getEst() {
        return est;
    }

    public void setEst(MovimentacaoEstoque est) {
        this.est = est;
    }

    public Produto() {
    }

    public Produto(int id, String pro_nome, String pro_ean, String pro_descricao, double pro_preco_compra, int pro_quantidade, double pro_margem_lucro, String pro_tipo, String pro_status, int pro_disponivel, int pro_fisico, int pro_reservado, double pro_preco_venda) {
        this.id = id;
        this.pro_nome = pro_nome;
        this.pro_ean = pro_ean;
        this.pro_descricao = pro_descricao;
        this.pro_preco_compra = pro_preco_compra;
        this.pro_quantidade = pro_quantidade;
        this.pro_margem_lucro = pro_margem_lucro;
        this.pro_tipo = pro_tipo;
        this.pro_status = pro_status;
        this.pro_disponivel = pro_disponivel;
        this.pro_fisico = pro_fisico;
        this.pro_reservado = pro_reservado;
        this.pro_preco_venda = pro_preco_venda;
    }

    public double getPro_margem_lucro() {
        return pro_margem_lucro;
    }

    public void setPro_margem_lucro(double pro_margem_lucro) {
        this.pro_margem_lucro = pro_margem_lucro;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", pro_nome=" + pro_nome + ", pro_ean=" + pro_ean + ", pro_descricao=" + pro_descricao + ", pro_preco_compra=" + pro_preco_compra + ", pro_quantidade=" + pro_quantidade + ", pro_margem_lucro=" + pro_margem_lucro + ", pro_tipo=" + pro_tipo + ", pro_status=" + pro_status + ", pro_disponivel=" + pro_disponivel + ", pro_fisico=" + pro_fisico + ", pro_reservado=" + pro_reservado + ", pro_preco_venda=" + pro_preco_venda + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPro_nome() {
        return pro_nome;
    }

    public void setPro_nome(String pro_nome) {
        this.pro_nome = pro_nome;
    }

    public String getPro_ean() {
        return pro_ean;
    }

    public void setPro_ean(String pro_ean) {
        this.pro_ean = pro_ean;
    }

    public String getPro_descricao() {
        return pro_descricao;
    }

    public void setPro_descricao(String pro_descricao) {
        this.pro_descricao = pro_descricao;
    }

    public double getPro_preco_compra() {
        return pro_preco_compra;
    }

    public void setPro_preco_compra(double pro_preco_compra) {
        this.pro_preco_compra = pro_preco_compra;
    }

    public int getPro_quantidade() {
        return pro_quantidade;
    }

    public void setPro_quantidade(int pro_quantidade) {
        this.pro_quantidade = pro_quantidade;
    }

    public String getPro_tipo() {
        return pro_tipo;
    }

    public void setPro_tipo(String pro_tipo) {
        this.pro_tipo = pro_tipo;
    }

    public String getPro_status() {
        return pro_status;
    }

    public void setPro_status(String pro_status) {
        this.pro_status = pro_status;
    }

    public int getPro_disponivel() {
        return pro_disponivel;
    }

    public void setPro_disponivel(int pro_disponivel) {
        this.pro_disponivel = pro_disponivel;
    }

    public int getPro_fisico() {
        return pro_fisico;
    }

    public void setPro_fisico(int pro_fisico) {
        this.pro_fisico = pro_fisico;
    }

    public int getPro_reservado() {
        return pro_reservado;
    }

    public void setPro_reservado(int pro_reservado) {
        this.pro_reservado = pro_reservado;
    }

    public double getPro_preco_venda() {
        return pro_preco_venda;
    }

    public void setPro_preco_venda(double pro_preco_venda) {
        this.pro_preco_venda = pro_preco_venda;
    }
}
