/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dao.*;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;
import java.util.List;

/**
 *
 * @author Julio Cesar Alves
 */
public class ProdutoVerificarExistencia implements I_Strategy {

    @Override
    public String executar(EntidadeDominio entidade) {
        Produto p = (Produto) entidade;
        if(p.getPro_ean()== null)
            return null;
        if(p.getPro_ean().length() < 1)
            return null;
        p.setBusca(p.getPro_ean());
        DaoProduto dao = new DaoProduto();
        List resultado = dao.consultar(p);
        if (resultado.size() > 0)
            return "EAN já cadastrado! #";
        return null;
    }
}
