/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio.core;

import br.com.podechamar.dominio.core.EntidadeDominio;

/**
 *
 * @author Julio Cesar Alves
 */
public interface I_Strategy {
    String executar(EntidadeDominio entidade);
}
