/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dominio.Departamento;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;

/**
 *
 * @author leofa
 */
public class DepartamentoVerificarCampos implements I_Strategy {

    @Override
    public String executar(EntidadeDominio entidade) {
        
        Departamento d = (Departamento) entidade;
        if(d.getDep_descricao().length() < 1 || d.getDep_nome().length() < 1 ||
                d.getDep_status().length() < 1)
            return "Dados Incompletos! #";
        return null;
    }
    
}
