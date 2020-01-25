/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;
import br.com.podechamar.util.Criptografa;

/**
 *
 * @author Julio Cesar Alves
 */
public class FuncionarioAlteracaoSenha implements I_Strategy{

    @Override
    public String executar(EntidadeDominio entidade) {
        Usuario f = (Usuario) entidade;
        if(f.getAlt() == null)
            return null;
        if(f.getAlt().getConfirmacao().length() < 1 && 
               f.getAlt().getNovaSenha().length() < 1)
            return null;
        if(!f.getAlt().getConfirmacao().equals(f.getAlt().getNovaSenha()))
            return "Confirmação deve ser igual a nova senha! #";
        if(f.getUsu_senha().equals(f.getAlt().getNovaSenha()))
            return "Nova senha deve ser diferente da senha anterior! #";
        f.getAlt().setNovaSenha(Criptografa.criaHash(f.getAlt().getNovaSenha()));
        return null;       
    }
}
