/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.controle.core;

import br.com.podechamar.controle.*;
import br.com.podechamar.dominio.core.*;

/**
 *
 * @author Julio Cesar Alves
 */
public interface I_Comando {
     public Resultado executar(EntidadeDominio entidade);
}
