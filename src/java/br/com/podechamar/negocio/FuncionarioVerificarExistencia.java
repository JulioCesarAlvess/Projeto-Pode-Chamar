/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dao.DaoClientes;
import br.com.podechamar.dao.DaoFuncionarios;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;
import java.util.List;

/**
 *
 * @author Julio Cesar Alves
 */
public class FuncionarioVerificarExistencia implements I_Strategy {

    @Override
    public String executar(EntidadeDominio entidade) {
        Funcionario f = (Funcionario) entidade;
        if(f.getFun_cpf() == null)
            return null;
        if(f.getFun_cpf().length() < 1)
            return null;
        f.setBusca(f.getFun_cpf());
        DaoFuncionarios dao = new DaoFuncionarios();
        List resultado = dao.consultar(f);
        if (resultado.size() > 0)
            return "CPF já cadastrado! #";
        return null;
    }

}
