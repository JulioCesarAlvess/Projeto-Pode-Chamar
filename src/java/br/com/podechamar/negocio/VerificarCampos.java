/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dominio.Cliente;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;
import java.lang.reflect.Field;

/**
 *
 * @author Julio Cesar Alves
 */
public class VerificarCampos implements I_Strategy{

    @Override
    public String executar(EntidadeDominio entidade) {
        Cliente c = (Cliente) entidade;
        if(c.getCli_cnpj().length() < 1 || c.getCli_contato().length() < 1 ||
                c.getCli_email().length() < 1 || c.getCli_nomefantasia().length() < 1 ||
                c.getCli_ramoatividade().length() < 1 || c.getCli_rasaosocial().length() < 1 ||
                c.getCli_rasaosocial().length() < 1 || c.getCli_status().length() < 1 ||
                c.getCli_telefone().length() < 1)
            return "Dados de Cliente Incompletos! #";
        return null;     
    }
}
