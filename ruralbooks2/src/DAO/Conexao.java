/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lofts
 */

    public class Conexao {
        public static Connection getConnection() {
        Connection conn = null;
        try {
            // Carrega o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Configuração da conexão
            String url = "jdbc:mysql://localhost:3306/biblioteca";
            String user = "root";
            String password = "root";

            // Estabelece a conexão
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
        }
        return conn;
    }
        
    }
    
    
