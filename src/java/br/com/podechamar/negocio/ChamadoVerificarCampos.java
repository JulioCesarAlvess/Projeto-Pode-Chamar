/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dominio.Chamado;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;

/**
 *
 * @author Julio Cesar Alves
 */
public class ChamadoVerificarCampos implements I_Strategy{

    @Override
    public String executar(EntidadeDominio entidade) {
        Chamado cha = (Chamado) entidade;
        return null;
    }
    
}
