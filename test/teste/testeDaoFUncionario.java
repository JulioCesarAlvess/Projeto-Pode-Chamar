/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.com.podechamar.dao.DaoFuncionarios;
import br.com.podechamar.dominio.Funcionario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio Cesar Alves
 */
public class testeDaoFUncionario {

    public static void main(String[] args) {
        DaoFuncionarios dao = new DaoFuncionarios();
        Funcionario f = new Funcionario();
        
        f.setFun_login("ALBERTO");
        f.setFun_senha("70KIzzAzWzz45zzz6zz9Nz32zLzzzI");
        
       /*DaoClientes d = new DaoClientes();
        Cliente c = new Cliente();
        c.setBusca("erdau");*/
        List lista =  dao.consultar(f);
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
        funcionarios = lista;
        
        f = funcionarios.get(0);
        
        System.out.println(f.getFun_nome());
    }
}
