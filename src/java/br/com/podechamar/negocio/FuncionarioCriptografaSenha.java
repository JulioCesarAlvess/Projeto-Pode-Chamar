/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dominio.Funcionario;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;
import br.com.podechamar.util.Criptografa;
import java.util.Random;

/**
 *
 * @author Julio Cesar Alves
 */
public class FuncionarioCriptografaSenha implements I_Strategy {

    @Override
    public String executar(EntidadeDominio entidade) {
        Funcionario fun = (Funcionario) entidade;
        if(fun.getFun_senha().length() < 1)
            return null;
         if(fun.getFun_senha() == null)
             return null;
        String senha = Criptografa.criaHash(fun.getFun_senha());
        fun.setFun_senha(senha);
        fun.getUsu().setUsu_senha(senha);

        entidade = fun;
        return null;
    }
}
