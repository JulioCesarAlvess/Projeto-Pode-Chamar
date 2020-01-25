/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.negocio;

import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.core.EntidadeDominio;
import br.com.podechamar.negocio.core.I_Strategy;

/**
 *
 * @author Julio Cesar Alves
 */
public class ProdutoVerificaEAN implements I_Strategy{

    @Override
    public String executar(EntidadeDominio entidade) {
        Produto p = (Produto)entidade;
       
       if (!p.getPro_ean().matches("^[0-9]{13}$")) {
            return " Código EAN inválido <br/>";
        }
        int[] numeros = p.getPro_ean().chars().map(Character::getNumericValue).toArray();
        int somaPares = numeros[1] + numeros[3] + numeros[5] + numeros[7] + numeros[9] + numeros[11];
        int somaImpares = numeros[0] + numeros[2] + numeros[4] + numeros[6] + numeros[8] + numeros[10];
        int resultado = somaImpares + somaPares * 3;
        int digitoVerificador = 10 - resultado % 10;
        if (digitoVerificador != numeros[12]) {
            return " Código EAN inválido <br/>";
        }
        return null;
    }
    
}
