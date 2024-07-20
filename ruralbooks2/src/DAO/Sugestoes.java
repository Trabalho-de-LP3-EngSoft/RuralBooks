/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import classes.Sugestao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lofts
 */
public class Sugestoes {
    Connection conn = Conexao.getConnection();
    
    public static boolean sugestaoExiste(String titulo, String autor){
        try {
            Connection conn = Conexao.getConnection();
            ResultSet rsSugestao = null;
            PreparedStatement checkSugestaoStmt = null;
            String checkSugestaoSql = "SELECT id FROM sugestoes WHERE nome_livro LIKE ? AND autor LIKE ?";
            checkSugestaoStmt = conn.prepareStatement(checkSugestaoSql);
            checkSugestaoStmt.setString(1, "%" + titulo + "%");
            checkSugestaoStmt.setString(2, "%" + autor + "%");
            rsSugestao = checkSugestaoStmt.executeQuery();
            if (rsSugestao.next()){
            return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sugestoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
    }
    
    public static int adicionarSugestao(String titulo, String autor) {
        Connection conn = Conexao.getConnection();
        PreparedStatement insertSugestaoStmt = null;
        MetodosLivros met = new MetodosLivros();
        try {                       
            if (met.checarLivroExiste(titulo, autor)) {
                System.out.println("O livro já existe na tabela livros.");
                return 3;
            } else {            
                if (sugestaoExiste(titulo, autor)) {
                    TerminalHandler caio = new TerminalHandler();
                    caio.print_error("Sugestão já existe.");
                    return 1;
                } else {
                    // Inserir nova sugestão
                    String insertSugestaoSql = "INSERT INTO sugestoes (nome_livro, autor) VALUES (?, ?)";
                    insertSugestaoStmt = conn.prepareStatement(insertSugestaoSql);
                    insertSugestaoStmt.setString(1, titulo);
                    insertSugestaoStmt.setString(2, autor);
                    insertSugestaoStmt.executeUpdate();
                    System.out.println("Sugestão adicionada com sucesso.");
                    return 0;                   
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return 2;
    }
    
    public static void removerSugestao(String titulo, String autor){
        String removeSugestaoSql = "DELETE FROM sugestoes WHERE nome_livro LIKE ? AND autor LIKE ?";
        PreparedStatement removeSugestao = null;   
        try {
            Connection conn = Conexao.getConnection();               
            removeSugestao = conn.prepareStatement(removeSugestaoSql);
            removeSugestao.setString(1, titulo);
            removeSugestao.setString(2, autor);
            removeSugestao.executeUpdate();
            System.out.println("Sugestão Removida com sucesso.");
        } catch (SQLException ex) {
            Logger.getLogger(Sugestoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public List<Sugestao> BuscaSugestao() {
            System.out.println("Buscando sugestoes");
            String sql = "SELECT * FROM sugestoes";

            List<Sugestao> listaSugestoes = new ArrayList<>();
        
        try {
            //System.out.println("Dentro do try das solicitacoes");
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Sugestao suges = new Sugestao();                         
                suges.setNome_livro(rs.getString("nome_livro"));
                suges.setAutor(rs.getString("autor"));
                listaSugestoes.add(suges);
            }
        } catch (SQLException e) {
        }

        return listaSugestoes;
    }
    }

