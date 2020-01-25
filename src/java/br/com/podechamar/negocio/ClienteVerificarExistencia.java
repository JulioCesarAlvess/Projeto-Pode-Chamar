/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dao.DaoClientes;
import br.com.podechamar.dominio.Cliente;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;
import java.util.List;

/**
 *
 * @author Julio Cesar Alves
 */
public class ClienteVerificarExistencia implements I_Strategy {

    @Override
    public String executar(EntidadeDominio entidade) {
        Cliente c = (Cliente) entidade;
        if(c.getCli_cnpj() == null)
            return null;
        if(c.getCli_cnpj().length() < 1)
            return null;
        c.setBusca(c.getCli_cnpj());
        DaoClientes dao = new DaoClientes();
        List resultado = dao.consultar(c);
        if (resultado.size() > 0)
            return "CNPJ já cadastrado! #";
        return null;
    }

}
