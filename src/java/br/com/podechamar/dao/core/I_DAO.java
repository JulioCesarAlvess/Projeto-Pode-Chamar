/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.dao.core;

import br.com.podechamar.dominio.core.EntidadeDominio;
import java.util.List;
/**
 *
 * @author Julio Cesar Alves
 */
public interface I_DAO {
    public String salvar(EntidadeDominio entidade);
    public List<EntidadeDominio> consultar(EntidadeDominio entidade);
    public List<EntidadeDominio> excluir(EntidadeDominio entidade);
    public String alterar(EntidadeDominio entidade);
}
