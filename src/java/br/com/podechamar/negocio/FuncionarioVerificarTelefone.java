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
public class FuncionarioVerificarTelefone implements I_Strategy {

    @Override
    public String executar(EntidadeDominio entidade) {
        Funcionario fun = (Funcionario) entidade;
        if (isTelefone(fun.getFun_telefone())) {
            return null;
        } else {
            return "Telefone invalido!#";
        }
    }

    //verificar telefone
    public boolean isTelefone(String numeroTelefone) {
        if (numeroTelefone.contains("^[a-Z]") || (numeroTelefone.isEmpty())) {
            return false;
        } else {
            if (numeroTelefone.length() > 12 || numeroTelefone.length() < 8) {
                return false;
            }
        }
        return true;
    }
}
