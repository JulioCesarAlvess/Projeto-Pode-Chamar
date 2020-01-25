/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;

/**
 *
 * @author Julio Cesar Alves
 */
public class ProdutoVerificaCampos implements I_Strategy{

    @Override
    public String executar(EntidadeDominio entidade) {
        Produto p = (Produto) entidade;
        if(p.getPro_descricao().length() < 1 || p.getPro_ean().length() < 1 ||
                p.getPro_margem_lucro() < 0 || p.getPro_nome().length() < 1 ||
                p.getPro_preco_compra() < 0 || p.getPro_quantidade() < 1 ||
                p.getPro_tipo().length() < 1 )
            return "Dados Incompletos! #";
        return null;
    }
    
}
