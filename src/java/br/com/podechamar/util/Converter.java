/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.util;

/**
 *
 * @author Julio Cesar Alves
 */
public class Converter {
   public static String criaHora(double valor) {
        double horas;
        int horasInt = (int) valor;
        int minutosInt;
        horas = horasInt;
        double diferenca =  valor - horas;
        double minutos = diferenca * 60;
        
        minutosInt = (int) minutos;
        
        if(minutosInt == 0){
            return " " + horasInt + ":00";
        }
        return " " + horasInt + ":" + minutosInt +" ";
   }
   
   public static String criaDinheiro (double valor){
       return "R$ "+ valor + "0";
   }
   
   public static String criaValores(String texto) {
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
