/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.analise;

import br.com.podechamar.dominio.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio Cesar Alves
 */
public class Grafico {

    //método para criar um gráfico de linhas dos chamados por status dentro do período de um ano
    public static List<Linha> ChamadosPorStatus(List<Chamado> chamados, int ano) {
        List<Linha> linhas = new ArrayList<>();
        int anoGrafico = 0;

        Linha aberto = new Linha();
        for (Chamado c : chamados) {
            anoGrafico = Integer.valueOf(c.getCha_databertura().substring(6, 10));
            if (c.getCha_status().equals("Aberto") &&  anoGrafico == ano) {
                int mes = Integer.valueOf(c.getCha_databertura().substring(3, 5));
                aberto.valores[mes - 1]++;
            }
        }
        aberto.setLegenda("Aberto");
        linhas.add(aberto);

        Linha pendente = new Linha();
        for (Chamado c : chamados) {
            anoGrafico = Integer.valueOf(c.getCha_databertura().substring(6, 10));
            if (c.getCha_status().equals("Pendente") &&  anoGrafico == ano) {
                int mes = Integer.valueOf(c.getCha_databertura().substring(3, 5));
                pendente.valores[mes - 1]++;
            }
        }
        aberto.setLegenda("Pendente");
        linhas.add(pendente);

        Linha concluido = new Linha();
        for (Chamado c : chamados) {
            anoGrafico = Integer.valueOf(c.getCha_databertura().substring(6, 10));
            if (c.getCha_status().equals("Concluido") &&  anoGrafico == ano ) {
                int mes = Integer.valueOf(c.getCha_databertura().substring(3, 5));
                concluido.valores[mes - 1]++;
            }
        }
        aberto.setLegenda("Concluido");
        linhas.add(concluido);

        Linha cancelado = new Linha();
        for (Chamado c : chamados) {
            anoGrafico = Integer.valueOf(c.getCha_databertura().substring(6, 10));
            if (c.getCha_status().equals("Cancelado") &&  anoGrafico == ano) {
                int mes = Integer.valueOf(c.getCha_databertura().substring(3, 5));
                cancelado.valores[mes - 1]++;
            }
        }
        aberto.setLegenda("Cancelado");
        linhas.add(cancelado);

        Linha retido = new Linha();
        for (Chamado c : chamados) {
            anoGrafico = Integer.valueOf(c.getCha_databertura().substring(6, 10));
            if (c.getCha_status().equals("Retido") &&  anoGrafico == ano) {
                int mes = Integer.valueOf(c.getCha_databertura().substring(3, 5));
                retido.valores[mes - 1]++;
            }
        }
        retido.setLegenda("Retido");
        linhas.add(retido);

        return linhas;
    }

    //método para criar um gráfico de linhas dos chamados por Tipos dentro do período de um ano
    public static List<Linha> ChamadosPorTipos(List<Chamado> chamados, List<TipoChamado> tipos, int ano) {
        List<Linha> linhas = new ArrayList<>();
        List<String> legendas = new ArrayList<>();
        int anoGrafico = 0;

        //encontrar os tipos
        for(TipoChamado t: tipos){
            legendas.add(t.getTch_nome());
        }
        //atribuir os valores por tipo
        for (String l : legendas) {
            Linha linha = new Linha();
            for (Chamado c : chamados) {
                 anoGrafico = Integer.valueOf(c.getCha_databertura().substring(6, 10));
                if (c.getCha_tipo().equals(l)  &&  anoGrafico == ano) {
                    int mes = Integer.valueOf(c.getCha_databertura().substring(3, 5));
                    linha.valores[mes - 1]++;
                }
            }
            linha.setLegenda(l);
            linhas.add(linha);
        }
        return linhas;
    }
}
