/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dominio.TipoChamado;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;

/**
 *
 * @author leofa
 */
public class TipoChamadoVerificarCampos implements I_Strategy {

    @Override
    public String executar(EntidadeDominio entidade) {
        
        TipoChamado t = (TipoChamado) entidade;
        
        if(t.getTch_nome().length() < 1 || t.getTch_descricao().length() < 1 ||
                t.getTch_status().length() < 1 || t.getTch_normal() < 0 ||
                t.getTch_urgente() < 0 || t.getTch_critico() < 0)
                return "Dados Incompletos! #";
        return null;
    }
    
}
