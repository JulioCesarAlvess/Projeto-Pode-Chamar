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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Julio Cesar Alves
 */
public class FuncionarioVerificarEmail implements I_Strategy {

    @Override
    public String executar(EntidadeDominio entidade) {
        Funcionario fun = (Funcionario) entidade;
        if (isEmail(fun.getFun_email())) {
            return null;
        } else {
            return "E-mail invalido!#";
        }
    }

    //verificar telefone
    private boolean isEmail(String email) {
        {
            boolean isEmailIdValid = false;
            if (email != null && email.length() > 0) {
                String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
                Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(email);
                if (matcher.matches()) {
                    isEmailIdValid = true;
                }
            }
            return isEmailIdValid;
        }
    }
}
