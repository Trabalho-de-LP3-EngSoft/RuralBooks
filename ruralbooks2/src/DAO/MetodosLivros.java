/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import classes.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
/**
 *
 * @author lofts
 */
public class MetodosLivros {
    Connection conn = Conexao.getConnection();

    public List<Livro> buscaLivro(String titulo) {
        System.out.println("Buscando Livros");
        String sql = "SELECT * FROM livros WHERE titulo LIKE ?";

        List<Livro> listaLivros = new ArrayList<>();
        
        try {
            System.out.println("Dentro do try dos livros");
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, titulo + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro(rs.getString("titulo"));
                livro.setId(rs.getInt("id"));
                livro.setAutor(rs.getString("autores"));
                livro.setVolume(rs.getString("volume"));
                System.out.println(livro + "Livro adicionado");
                listaLivros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaLivros;
    }
}

