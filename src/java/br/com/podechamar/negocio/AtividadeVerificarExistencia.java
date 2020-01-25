/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dao.DaoAtividade;
import br.com.podechamar.dominio.Atividade;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;
import java.util.List;

/**
 *
 * @author leofa
 */
public class AtividadeVerificarExistencia implements I_Strategy {

    @Override
    public String executar(EntidadeDominio entidade) {
        
        Atividade a = (Atividade) entidade;
        if(a.getAti_nome()== null)
            return null;
        if(a.getAti_nome().length() < 1)
            return null;
        a.setBusca(a.getAti_nome());
        DaoAtividade dao = new DaoAtividade();
        List resultado = dao.consultar(a);
        if (resultado.size() > 0)
            return "Atividade já cadastrada! #";
        return null;
    }
    
}
