/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view.core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Julio Cesar Alves
 */
public class DadosVisao implements I_DadosVisao{
    private HttpServletRequest request;

    public DadosVisao(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String get(String nome) {
        return request.getParameter(nome).trim();
    }

    @Override
    public int getInt(String nome) {
        return Integer.valueOf(get(nome));
    }

    @Override
    public double getDouble(String nome) {
        return Double.valueOf(get(nome));
    }

    @Override
    public boolean getBoolean(String nome) {
        return Boolean.valueOf(get(nome));
    }

    @Override
    public Date getDate(String nome) {
        DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        //String texto = get(nome);
        //String[] palavras = texto.split("-");
        //texto = palavras[2] + "/" + palavras[1] + "/" + palavras[0];
        try {
            return formatador.parse(get(nome));
        } catch (ParseException ex) {
        }
        return null;
    }

    @Override
    public Date getDate(String nome, String formato) {
        DateFormat formatador = new SimpleDateFormat(formato);
        try {
            return formatador.parse(get(nome));
        } catch (ParseException ex) {
        }
        return null;
    }

    @Override
    public boolean existe(String nome) {
        if (null == request.getParameter(nome)) {
            Enumeration<String> nomesParametros = request.getParameterNames();
            while(nomesParametros.hasMoreElements()) {
                String nomeParametro = nomesParametros.nextElement();
                if(nomeParametro.startsWith(nome + ".")) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }
}
