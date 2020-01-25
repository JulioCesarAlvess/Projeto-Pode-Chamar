/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.controle.core;

import br.com.podechamar.controle.Resultado;
import br.com.podechamar.dominio.core.*;

/**
 *
 * @author Julio Cesar Alves
 */
public interface I_Fachada {
    Resultado salvar (EntidadeDominio entidade);
    Resultado alterar (EntidadeDominio entidade);
    Resultado excluir (EntidadeDominio entidade);
    Resultado consultar (EntidadeDominio entidade);
}
