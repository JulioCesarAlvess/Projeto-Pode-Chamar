/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dao.DaoDepartamento;
import br.com.podechamar.dominio.Departamento;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;
import java.util.List;

/**
 *
 * @author leofa
 */
public class DepartamentoVerificarExistencia implements I_Strategy {

    @Override
    public String executar(EntidadeDominio entidade) {
       
        Departamento d = (Departamento) entidade;
        if(d.getDep_nome()== null)
            return null;
        if(d.getDep_nome().length() < 1)
            return null;
        d.setBusca(d.getDep_nome());
        DaoDepartamento dao = new DaoDepartamento();
        List resultado = dao.consultar(d);
        if (resultado.size() > 0)
            return "Departamento já cadastrado! #";
        return null;
    }
    
}
