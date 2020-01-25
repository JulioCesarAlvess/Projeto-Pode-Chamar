/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dominio.Funcionario;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;
import java.util.InputMismatchException;

/**
 *
 * @author Julio Cesar Alves
 */
public class FuncionarioVerificarSenha implements I_Strategy {

    @Override
    public String executar(EntidadeDominio entidade) {
        Funcionario fun = (Funcionario) entidade;
        if (isSenhaForte(fun.getFun_senha())) {
            return null;
        } else {
            return "A senha deve ter pelo menos 8 dígitos, letra maiúscula, minúscula, número e caracter especial!#";
        }
    }

    //verificar telefone
    public boolean isSenhaForte(String senha) {
        if (senha.length() < 8) {
            return false;
        }

        boolean achouNumero = false;
        boolean achouMaiuscula = false;
        boolean achouMinuscula = false;
        boolean achouSimbolo = false;
        for (char c : senha.toCharArray()) {
            if (c >= '0' && c <= '9') {
                achouNumero = true;
            } else if (c >= 'A' && c <= 'Z') {
                achouMaiuscula = true;
            } else if (c >= 'a' && c <= 'z') {
                achouMinuscula = true;
            } else {
                achouSimbolo = true;
            }
        }
        return achouNumero && achouMaiuscula && achouMinuscula && achouSimbolo;
    }
}
