/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.com.podechamar.dao.DaoClientes;
import br.com.podechamar.dao.core.Dao;
import br.com.podechamar.dominio.*;
import br.com.podechamar.dominio.Endereco;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julio Cesar Alves
 */
public class testeDaoCLiente {
       /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        Endereco end = new Endereco();
        
        /*end.setEnd_id(10);
        end.setEnd_bairro("Bairrotal");
        end.setEnd_cidade("cidade tal");
        end.setEnd_estado("SP");
        end.setEnd_numero("65");
        
        Contrato con = new Contrato();
        con.setCon_datainicio("dataInicio");
        con.setCon_diavencimento(15);
        con.setCon_id(1);
        con.setCon_tempo(12);
        con.setCon_valormensalidade(500);
        
        Cliente c = new Cliente();
        c.setCli_rasaosocial("123");
        c.setCli_endereco(end);
        c.setCli_contrato(con);
        
       // c.setC
        DaoClientes d = new DaoClientes();
        
        
        System.out.println(d.salvar(c));/*
        
        //c.setCli_endereco(end);
        //dao.inserir(end);
        //System.out.println(dao.toString());
        
       // DaoClientes d = new DaoClientes();
        //try{
          //  d.salvar(c);
            //System.out.println(d.toString());
        //}catch(Exception ex ){
          //   System.out.println("erro ");
        //}
        
     
        /*Cliente c = new Cliente();
        DaoClientes dao = new DaoClientes();
        
        c.setCli_id(2);
        c = (Cliente)dao.consultarPorId(2, c);
        
        System.out.println(c.toString());*/
        
        /*DaoClientes d = new DaoClientes();
        Cliente c = new Cliente();
        c.setBusca("erdau");
        List lista =  d.consultar(c);
        
        List<Cliente> clientes = new ArrayList<>();
        
        clientes = lista;
        
        for(Cliente cli : clientes){
            System.out.println("\n"+ cli.toString());
        }*/
       /*Dao d = new Dao();
       Contrato con = new Contrato();
       List<Contrato> conts = (List) d.consultarTodos(con);
       
        for(Contrato c : conts){
            System.out.println("\n" + c.toString());
        }*/
       /*Cliente cli = new Cliente();
       Dao d = new Dao();
       cli.setCli_cnpj("146");
       cli.setId(1);
       System.out.println("" + d.alterarGeral(cli));*/
      
    }
}
