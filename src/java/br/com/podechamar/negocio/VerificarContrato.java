/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dominio.Cliente;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;

/**
 *
 * @author Julio Cesar Alves
 */
public class VerificarContrato implements I_Strategy{

    @Override
    public String executar(EntidadeDominio entidade) {
        Cliente c = (Cliente) entidade;
        if(c.getCli_contrato().getCon_datainicio().length() < 1 ||
                c.getCli_contrato().getCon_diavencimento() == 0 ||
                c.getCli_contrato().getCon_valormensalidade() == 0 ||
                c.getCli_contrato().getCon_tempo() == 0 
        )
            return "Dados do Contrato Incompletos! #";
        return null;
    }
    
}
