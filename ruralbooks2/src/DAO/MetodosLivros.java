/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import classes.Obra;
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
       TerminalHandler ter = new TerminalHandler();
       
    public String addLivro(String titulo, String autor, String volume, String editora){
         String addLivroSql = "INSERT INTO livros (titulo, autores, volume,editora) VALUES (?,?,?,?)";  
        if (checarLivroExiste(titulo, autor)){
            ter.print_warning("Livro já existe");
            return "1";
        }else{
             try {
                 PreparedStatement addLivroStmt = conn.prepareStatement(addLivroSql);
                 addLivroStmt.setString(1, titulo);
                 addLivroStmt.setString(2, autor);
                 addLivroStmt.setString(3, volume);
                 addLivroStmt.setString(4, editora);
                 addLivroStmt.executeUpdate();
                 ter.print_success("Livro Adicionado com sucesso!");
                    if (Sugestoes.sugestaoExiste(titulo, autor)){
                        Sugestoes.removerSugestao(titulo, autor);
                    }
                 return "0";
             } catch (SQLException e) {
                 return "2";
             }
            
        }
    }
            
    public boolean checarLivroExiste(String titulo, String autor){
        try{           
            String checkLivroSql = "SELECT id FROM livros WHERE titulo LIKE ? AND autores LIKE ?";
            PreparedStatement checkLivroStmt = conn.prepareStatement(checkLivroSql);
            checkLivroStmt.setString(1, "%" + titulo + "%");
            checkLivroStmt.setString(2, "%" + autor + "%");
            ResultSet rsLivro = checkLivroStmt.executeQuery();

            if (rsLivro.next()) {
                System.out.println("O livro já existe na tabela livros.");
                return true;
            }
        }catch (SQLException e) {
        }
            return false;
      
        }
    
    public List<Obra> buscaLivro(String titulo) {
        System.out.println("Buscando Livros");
        String sql = "SELECT * FROM livros WHERE titulo LIKE ?";

        List<Obra> listaLivros = new ArrayList<>();
        
        try {
            System.out.println("Dentro do try dos livros");
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, titulo + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Obra livro = new Obra(rs.getString("titulo"));
                livro.setId(rs.getInt("id"));
                livro.setAutor(rs.getString("autores"));
                livro.setVolume(rs.getString("volume"));
                System.out.println(livro + "Livro adicionado");
                listaLivros.add(livro);
            }
        } catch (SQLException e) {
        }

        return listaLivros;
    }
    
    public String addExemplar( int livroId){
         String addExemplarSql = "INSERT INTO exemplar (isbn, livro_id) VALUES (?,?)";  
    String checkLivroExisteSql = "SELECT COUNT(*) FROM livros WHERE id = ?";
    String countExemplarSql = "SELECT COUNT(*) FROM exemplar WHERE livro_id = ?";
    
    try (
        PreparedStatement checkLivroExisteStmt = conn.prepareStatement(checkLivroExisteSql);
        PreparedStatement countExemplarStmt = conn.prepareStatement(countExemplarSql);
        PreparedStatement addExemplarStmt = conn.prepareStatement(addExemplarSql);
    ) {
        checkLivroExisteStmt.setInt(1, livroId);
        ResultSet existe = checkLivroExisteStmt.executeQuery();
        
        if (existe.next() && existe.getInt(1) > 0) {
            countExemplarStmt.setInt(1, livroId);                   
            ResultSet rs = countExemplarStmt.executeQuery();
            
            if (rs.next()) {
                int count = rs.getInt(1);               
                String isbn = "ISBN" + livroId + "-" + (count + 1);               
                addExemplarStmt.setString(1, isbn);
                addExemplarStmt.setInt(2, livroId);
                addExemplarStmt.executeUpdate();
                return isbn;
            } else {
                return "0";
            }
        } else {
            return "";
        }
    } catch (SQLException e) {
        return "1";
    }
   
   }
}


