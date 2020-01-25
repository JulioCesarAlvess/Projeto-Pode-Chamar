/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.podechamar.dao.core;

import br.com.podechamar.dominio.core.EntidadeDominio;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Julio Cesar Alves
 */
public abstract class Dao implements I_DAO{
     public String inserir(Object objeto, Connection conexao ) {

        try {
            
            //Connection conexao = BancoDadosPostgres.getConexao();

            //montar a string sql
            String sql = "INSERT INTO ";
            
            
            // getClass().getName() retorna o nome completo com o pacote.
            // getClass().getSimpleName() retorna apenas o nome da classe.
            
            sql += objeto.getClass().getSimpleName().toLowerCase();

            // getClass().getFields() retorna atributos da classe e herdados.
            // getClass().getDeclaredFields() retorna atributos da classe.
            Field[] atributos = objeto.getClass().getDeclaredFields();
            sql += "(";
            String valores = "";
            int cont = 1;
            for (Field atributo : atributos){
                if(!atributo.getName().toLowerCase().equals("busca")){
                if(atributo.getType() == Integer.class || atributo.getType().getName().equals("int")
                        ||atributo.getType() == Double.class || atributo.getType().getName().equals("double")
                        ||atributo.getType() == String.class || atributo.getType().getName().equals("String")
                        ||atributo.getType() == Date.class || atributo.getType().getName().equals("Date")){
  
                if (!atributo.getName().toLowerCase().equals("id")) {
                    cont++;
                    sql += atributo.getName().toLowerCase() + ", ";
                    valores += "?, ";
                }
                }
            }
            }
            sql = sql.substring(0, sql.length() - 2);
            valores = valores.substring(0, valores.length() - 2);
            sql += ") VALUES (" + valores + ")";
            
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            
            int numeroInterrogacao = 1;
            for (Field atributo : atributos) {
                if (!atributo.getName().toLowerCase().equals("id") && !atributo.getName().toLowerCase().equals("busca")) {
                    // Recuperar o valor do atributo.
                    atributo.setAccessible(true);
                    declaracao.setObject(numeroInterrogacao++, atributo.get(objeto));
                    if(cont == numeroInterrogacao)
                        break;
                }
            }
            
            declaracao.execute();
            return "Salvo com Sucesso!#";

        } catch (Exception e) {
            return e.toString();
        }
    }

    public String alterarGeral(Object objeto) {

        try {
            Connection conexao = br.com.podechamar.dao.core.BancoDadosPostgres.getConexao();
            String id = "";
            String sql = "UPDATE ";
            sql += objeto.getClass().getSimpleName().toLowerCase() + " SET ";
            Field[] atributos = objeto.getClass().getDeclaredFields();
                    //"update pessoa set 
            for(Field atributo : atributos ){
                if(!atributo.getName().toLowerCase().equals("busca")){
                if(atributo.getType() == Integer.class || atributo.getType().getName().equals("int")
                        ||atributo.getType() == Double.class || atributo.getType().getName().equals("double")
                        ||atributo.getType() == String.class || atributo.getType().getName().equals("String")
                        ||atributo.getType() == Date.class || atributo.getType().getName().equals("Date")){
                if(atributo.getName().toLowerCase().equals("id")){
                    atributo.setAccessible(true); 
                    id =  atributo.get(objeto).toString();
                }
                else{
                    sql += atributo.getName().toLowerCase() + "=? ,";
                } 
                }
                }
            }//end for
            sql = sql.substring(0, sql.length() - 1);
            
            sql += " WHERE id = " + id;
                    //nome=?, cpf=?, massa=?, altura=? where id=?";
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            
            int numeroInterrogacao = 1;
            for (Field atributo : atributos) {
                if (!atributo.getName().toLowerCase().equals("id") && !atributo.getName().toLowerCase().equals("busca")) {
                if(atributo.getType() == Integer.class || atributo.getType().getName().equals("int")
                    ||atributo.getType() == Double.class || atributo.getType().getName().equals("double")
                    ||atributo.getType() == String.class || atributo.getType().getName().equals("String")
                    ||atributo.getType() == Date.class || atributo.getType().getName().equals("Date")){
                    // Recuperar o valor do atributo.
                    atributo.setAccessible(true);
                    declaracao.setObject(numeroInterrogacao++, atributo.get(objeto));
                }
            }
            }
            declaracao.executeUpdate();
            conexao.close();
            return "Alteração feita com Sucesso!";
            

        } catch (Exception ex) {
                return ex.toString();
        }
    }
     public String excluir(int id, Object objeto) {
        try {
            Connection conexao = br.com.podechamar.dao.core.BancoDadosPostgres.getConexao();

            String sql = "DELETE FROM ";
            sql += objeto.getClass().getSimpleName().toLowerCase();
            sql += " WHERE id = ?";
            //String instrucaoSQL = "delete from pessoa where id=?";
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, id);
            declaracao.execute();

            conexao.close();
            return "Exclusão feita com Sucesso";

        } catch (Exception ex) {
                return ex.toString();
        }
    }

    public List<Object> consultarTodos(Object objeto) {
        List<Object> objetos = null;
        try {
            Connection conexao = br.com.podechamar.dao.core.BancoDadosPostgres.getConexao();

            String sql = "SELECT ";
            //String instrucaoSQL = "Select id, nome, cpf, massa, altura from pessoa";
            Field[] atributos = objeto.getClass().getDeclaredFields();
            for (Field atributo : atributos) {
                if(!atributo.getName().toLowerCase().equals("busca")){
                    if(atributo.getType() == Integer.class || atributo.getType().getName().equals("int")
                        ||atributo.getType() == Double.class || atributo.getType().getName().equals("double")
                        ||atributo.getType() == String.class || atributo.getType().getName().equals("String")
                        ||atributo.getType() == Date.class || atributo.getType().getName().equals("Date"))
                        sql += atributo.getName().toLowerCase() + ", ";
            }
            }
            
            sql = sql.substring(0, sql.length() - 2);
            sql += " FROM ";
            
            sql += objeto.getClass().getSimpleName().toLowerCase();
            
            sql += " ORDER BY 2 DESC";
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            ResultSet resultado = declaracao.executeQuery();
            objetos = new ArrayList<>();
            while (resultado.next()) {
                Object objetoDoBanco = objeto.getClass().newInstance();

                for (Field atributo : atributos) {
                    if(!atributo.getName().toLowerCase().equals("busca")){
                    atributo.setAccessible(true);
                    if (atributo.getType() == Integer.class || atributo.getType().getName().equals("int")) {
                        atributo.set(objetoDoBanco, resultado.getInt(atributo.getName().toLowerCase()));
                    } else if (atributo.getType() == String.class) {
                        atributo.set(objetoDoBanco, resultado.getString(atributo.getName().toLowerCase()));
                    } else if (atributo.getType() == Double.class || atributo.getType().getName().equals("double")){
                        atributo.set(objetoDoBanco, resultado.getDouble(atributo.getName().toLowerCase()));
                    } else if (atributo.getType() == Date.class || atributo.getType().getName().equals("Date"))
                        atributo.set(objetoDoBanco, resultado.getDate(atributo.getName().toLowerCase()));
                }
                }

                objetos.add(objetoDoBanco);
            }//while
            conexao.close();
        } catch (Exception ex) {
            System.out.println(" erro " + ex);
        }
        return objetos;
    }

    public Object consultarPorId(int id, Object objeto) {
        Object objetoDoBanco = null;
        try {

            Connection conexao = br.com.podechamar.dao.core.BancoDadosPostgres.getConexao();

            String sql = "SELECT ";
            Field[] atributos = objeto.getClass().getDeclaredFields();
            for (Field atributo : atributos) {
                if(!atributo.getName().toLowerCase().equals("busca")){
                    if(atributo.getType() == Integer.class || atributo.getType().getName().equals("int")
                    ||atributo.getType() == Double.class || atributo.getType().getName().equals("double")
                    ||(atributo.getType() == String.class || atributo.getType().getName().equals("String"))
                    ||atributo.getType() == Date.class || atributo.getType().getName().equals("Date")
                    )
                    sql += atributo.getName().toLowerCase() + ", ";
            }
            }
            sql = sql.substring(0, sql.length() - 2);
            sql += " FROM ";
            
            sql += objeto.getClass().getSimpleName().toLowerCase();
            sql += " WHERE id = ? ";
            //String instrucaoSQL = "select id, nome, cpf, massa, altura from pessoa where id=" + id;
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            declaracao.setInt(1, id);
            ResultSet resultado = declaracao.executeQuery();
            
            if (resultado.next()) {
                objetoDoBanco = objeto.getClass().newInstance();

                for (Field atributo : atributos) {
                    if(!atributo.getName().toLowerCase().equals("busca")){
                    atributo.setAccessible(true);
                    if (atributo.getType() == Integer.class || atributo.getType().getName().equals("int")) {
                        atributo.set(objetoDoBanco, resultado.getInt(atributo.getName().toLowerCase()));
                    } else if (atributo.getType() == String.class) {
                        atributo.set(objetoDoBanco, resultado.getString(atributo.getName().toLowerCase()));
                    } else if (atributo.getType() == Double.class || atributo.getType().getName().equals("double")){
                        atributo.set(objetoDoBanco, resultado.getDouble(atributo.getName().toLowerCase()));
                    } else if (atributo.getType() == Date.class || atributo.getType().getName().equals("Date"))
                        atributo.set(objetoDoBanco, resultado.getDate(atributo.getName().toLowerCase()));
                }
                }
                
            }
            conexao.close();

        } catch (Exception ex) {

        }
        return objetoDoBanco;
    }
    
    public List<Object> consultarPorParametro(Object objeto){
         List<Object> objetos = null;
         return objetos;
    }

}
