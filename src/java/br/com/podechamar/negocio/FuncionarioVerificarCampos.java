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
 * @author leofa
 */
public class FuncionarioVerificarCampos implements I_Strategy {

    @Override
    public String executar(EntidadeDominio entidade) {
        Funcionario fun = (Funcionario) entidade;
        if (fun.getFun_cpf().length() < 1
                || fun.getFun_email().length() < 1
                || fun.getFun_login().length() < 1
                || fun.getFun_nf().length() < 1
                || fun.getFun_nivel().length() < 1
                || fun.getFun_nome().length() < 1
                || fun.getFun_senha().length() < 1
                || fun.getFun_status().length() < 1
                || fun.getFun_telefone().length() < 1) {
            return "Dados de Funcionario incompletos!#";
        }
        return null;
    }

}
