/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.com.podechamar.dao.DaoUsuario;
import br.com.podechamar.dominio.Usuario;
import br.com.podechamar.util.Criptografa;
import java.util.List;

/**
 *
 * @author Julio Cesar Alves
 */
public class testeDaoUsu {
    public static void main(String[] args) {
        Usuario u = new Usuario();
        DaoUsuario dao = new  DaoUsuario();
        
        u.setUsu_login("GUSTAVO");
        u.setUsu_papel("Operacional");
        u.setUsu_senha("Gustavo1234");
        u.setUsu_senha(Criptografa.criaHash(u.getUsu_senha()));
        
        //insert
        //System.out.println("" + dao.salvar(u));
        
        //update
        //System.out.println("" + dao.alterar(u));
        
        //select
        u = (Usuario) dao.consultar(u).get(0);
        System.out.println("" + u.getUsu_login());
       
    }
}
