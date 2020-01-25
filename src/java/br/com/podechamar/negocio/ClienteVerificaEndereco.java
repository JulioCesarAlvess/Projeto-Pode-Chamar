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
public class ClienteVerificaEndereco implements I_Strategy{
    @Override
    public String executar(EntidadeDominio entidade) {
        Cliente c = (Cliente) entidade;
        if(c.getCli_endereco().getEnd_cep().length() < 1 || 
                c.getCli_endereco().getEnd_rua().length() < 1 ||
                c.getCli_endereco().getEnd_numero().length() < 1 ||
                c.getCli_endereco().getEnd_bairro().length() < 1 ||
                c.getCli_endereco().getEnd_cidade().length() < 1 ||
                c.getCli_endereco().getEnd_estado().length() < 1 ||
                c.getCli_endereco().getEnd_pais().length() < 1
        )
            return "Dados de Endereço incorretos! #";
        return null;
        }
    
}
