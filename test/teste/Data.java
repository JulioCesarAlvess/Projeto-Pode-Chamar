/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julio Cesar Alves
 */
public class Data {
    public static void main(String[] args) {
        Date data = new Date();
        //System.out.println(data.toString());
        String texto;
        texto = "2018-08-25";
        System.out.println("antes" + texto +"\n");
        //texto = texto.replace("-", "/");
        System.out.println("depois" + texto +"\n");
        DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String[] palavras = texto.split("-");
        
        texto = palavras[2] + "/" + palavras[1] + "/" + palavras[0];
        System.out.println("\n" + texto);
        try {
            data = formatador.parse(texto);
            System.out.println(data.toString());
        } catch (ParseException ex) {
            System.out.println("Erro");
        }


    }  
}
