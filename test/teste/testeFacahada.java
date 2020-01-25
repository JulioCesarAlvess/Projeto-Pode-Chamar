/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.com.podechamar.controle.Fachada;
import br.com.podechamar.dominio.Cliente;
import br.com.podechamar.dominio.core.EntidadeDominio;

/**
 *
 * @author Julio Cesar Alves
 */
public class testeFacahada {
    public static void main(String[] args) {
        Fachada f = new Fachada();
        EntidadeDominio ent = new Cliente();
        
        System.out.println(f.salvar(ent).toString());
    }
}
