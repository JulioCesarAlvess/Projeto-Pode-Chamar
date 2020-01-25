package br.com.podechamar.dao.core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author leofa
 */
public class BancoDadosPostgres {
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        // Define um driver de conexao com o banco.
        Class.forName("org.postgresql.Driver");
        // Abre uma conexao com o banco.
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/LES", "postgres", "admin");
    
    }
}
