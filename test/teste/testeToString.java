/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.com.podechamar.dao.*;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.Produto;
import br.com.podechamar.dominio.core.EntidadeDominio;

/**
 *
 * @author Julio Cesar Alves
 */
public class testeToString {

    public static String falaNome(Object ent) {
        String nome = ent.getClass().getSimpleName().toString();
        return nome;
    }

    public static void main(String[] args) {
        EntidadeDominio e = new Produto();
        Produto p = new Produto();

        //teste para falar o nome da classe 
        String nome = falaNome(e);
        //System.out.println(nome);

        e = new Chamado();
        String nome2 = falaNome(e);
        //System.out.println(nome2);

        DaoProduto dao = new DaoProduto();

        p.setId(9);

        p = (Produto) dao.consultar(p).get(0);

        String valorAnterior = retornaValores(p.toString());

        //System.out.println(p.toString());
        System.out.println(valorAnterior);

    }

    public static String retornaValores(String texto) {
        String retorno = "";

        String valorAntorior = texto.replace("{", ",");
        valorAntorior = valorAntorior.replace("}", " ");
        //System.out.println(valorAntorior);
        String[] vetor = valorAntorior.split(",", 999);

        for (int i = 0; i < vetor.length; i++) {
            if (i > 0) {
                if (vetor[i].startsWith("id=")) {
                    retorno += "," + vetor[i];
                    continue;
                }
                int j = vetor[i].length();
                String a = vetor[i].substring(5, j);
                vetor[i] = a;

            }
            if (i == 0) {
                retorno += vetor[i];
            } else {
                retorno += "," + vetor[i];
            }

        }
        return retorno;
    }

}
