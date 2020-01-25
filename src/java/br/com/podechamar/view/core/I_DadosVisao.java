/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view.core;

import java.util.Date;

/**
 *
 * @author Julio Cesar Alves
 */
public interface I_DadosVisao {
    
    public String get(String nome);

    public int getInt(String nome);

    public double getDouble(String nome);

    public boolean getBoolean(String nome);

    public Date getDate(String nome);

    public Date getDate(String nome, String formato);

    public boolean existe(String nome);
}
