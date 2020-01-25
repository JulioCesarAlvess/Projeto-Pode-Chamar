/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dao.DaoTipoChamado;
import br.com.podechamar.dominio.TipoChamado;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;
import java.util.List;

/**
 *
 * @author leofa
 */
public class TipoChamadoVerificarExistencia implements I_Strategy {
    
    @Override
    public String executar(EntidadeDominio entidade) {
        
        TipoChamado t = (TipoChamado) entidade;
        if(t.getTch_nome()== null)
            return null;
        if(t.getTch_nome().length() < 1)
            return null;
        t.setBusca(t.getTch_nome());
        DaoTipoChamado dao = new DaoTipoChamado();
        List resultado = dao.consultar(t);
        if (resultado.size() > 0)
            return "Tipo de Chamado já cadastrado! #";
        return null;
    }
}

    