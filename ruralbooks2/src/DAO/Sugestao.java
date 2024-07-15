/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author lofts
 */
public class Sugestao {
    
    public static int adicionarSugestao(String nomeLivro, String autor) {
        Connection conn = Conexao.getConnection();
        PreparedStatement checkLivroStmt = null;
        PreparedStatement checkSugestaoStmt = null;
        PreparedStatement insertSugestaoStmt = null;
        ResultSet rsLivro = null;
        ResultSet rsSugestao = null;

        try {
            

            // Verificar se o livro já existe na tabela livros
            String checkLivroSql = "SELECT id FROM livros WHERE titulo LIKE ? AND autores LIKE ?";
            checkLivroStmt = conn.prepareStatement(checkLivroSql);
            checkLivroStmt.setString(1, "%" + nomeLivro + "%");
            checkLivroStmt.setString(2, "%" + autor + "%");
            rsLivro = checkLivroStmt.executeQuery();

            if (rsLivro.next()) {
                System.out.println("O livro já existe na tabela livros.");
                return 3;
            } else {
                // Verificar se já existe uma sugestão similar
                String checkSugestaoSql = "SELECT id FROM sugestoes WHERE nome_livro LIKE ? AND autor LIKE ?";
                checkSugestaoStmt = conn.prepareStatement(checkSugestaoSql);
                checkSugestaoStmt.setString(1, "%" + nomeLivro + "%");
                checkSugestaoStmt.setString(2, "%" + autor + "%");
                rsSugestao = checkSugestaoStmt.executeQuery();

                if (rsSugestao.next()) {
                    System.out.println("Já existe uma sugestão com nome e autor similares.");
                    return 1;
                } else {
                    // Inserir nova sugestão
                    String insertSugestaoSql = "INSERT INTO sugestoes (nome_livro, autor) VALUES (?, ?)";
                    insertSugestaoStmt = conn.prepareStatement(insertSugestaoSql);
                    insertSugestaoStmt.setString(1, nomeLivro);
                    insertSugestaoStmt.setString(2, autor);
                    insertSugestaoStmt.executeUpdate();
                    System.out.println("Sugestão adicionada com sucesso.");
                    return 0;                   
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rsLivro != null) rsLivro.close();
                if (rsSugestao != null) rsSugestao.close();
                if (checkLivroStmt != null) checkLivroStmt.close();
                if (checkSugestaoStmt != null) checkSugestaoStmt.close();
                if (insertSugestaoStmt != null) insertSugestaoStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 2;
    }
    }

