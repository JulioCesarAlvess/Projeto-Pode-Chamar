/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.view.core;

import br.com.podechamar.controle.*;
import br.com.podechamar.dominio.core.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio Cesar Alves
 */
public interface I_ViewHelper {
    public EntidadeDominio getEntidade (HttpServletRequest request, HttpServletResponse response);
    public void setView(Resultado resultado, 
			HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException;
}
