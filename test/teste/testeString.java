/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.com.podechamar.analise.Grafico;
import br.com.podechamar.analise.Linha;
import br.com.podechamar.dao.DaoChamado;
import br.com.podechamar.dominio.Chamado;
import java.util.List;

/**
 *
 * @author Julio Cesar Alves
 */
public class testeString {
    public static void main(String[] args) {
        String data = "07/10/2018 02:12:24";
        String mes = data.substring(6, 10);
        System.out.println(mes);
        
        //Chamado c = new Chamado();
        
        //DaoChamado dao = new DaoChamado();
    }
    
}
