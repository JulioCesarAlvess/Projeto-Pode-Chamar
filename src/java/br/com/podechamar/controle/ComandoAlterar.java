/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.controle;

import br.com.podechamar.controle.core.AbstractComando;
import br.com.podechamar.dominio.core.EntidadeDominio;

/**
 *
 * @author Julio Cesar Alves
 */
public class ComandoAlterar extends AbstractComando{

    @Override
    public Resultado executar(EntidadeDominio entidade) {
        return fachada.alterar(entidade);
    }
    
}
