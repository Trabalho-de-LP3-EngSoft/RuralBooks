/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import classes.Solicitacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author lofts
 */
public class Solicitacoes {
    
        Connection conn = Conexao.getConnection();
        //adiciona solicitaçoes no banco de dados
        public static String addSolicitacao(int alunoId, int livroId) { 
        String contarSolicitacoesSql = "SELECT COUNT(*) AS solicitacao_count FROM solicitacoes WHERE aluno_id = ?";
        String buscarIsbnSql = "SELECT isbn FROM exemplar WHERE livro_id = ? AND isbn NOT IN (SELECT isbn FROM solicitacoes) LIMIT 1";
        String solicitacaoSql = "INSERT INTO solicitacoes (isbn, aluno_id) VALUES (?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement contarSolicitacoesStmt = conn.prepareStatement(contarSolicitacoesSql);
             PreparedStatement buscarIsbnStmt = conn.prepareStatement(buscarIsbnSql);
             PreparedStatement solicitacaoStmt = conn.prepareStatement(solicitacaoSql)) {

          
            contarSolicitacoesStmt.setInt(1, alunoId);
            ResultSet rsContagem = contarSolicitacoesStmt.executeQuery();
            if (rsContagem.next()) {
                int solicitacaoCount = rsContagem.getInt("solicitacao_count");
                if (solicitacaoCount >= 3) {
                    System.out.println("O aluno já possui 3 ou mais solicitações.");
                    return "";
                }
            }           
            buscarIsbnStmt.setInt(1, livroId);
           
            ResultSet rs = buscarIsbnStmt.executeQuery();
            if (rs.next()) {
                String isbn = rs.getString("isbn");           
                solicitacaoStmt.setString(1, isbn);
                solicitacaoStmt.setInt(2, alunoId);
                solicitacaoStmt.executeUpdate();

                System.out.println("Solicitação adicionada com sucesso! ISBN: " + isbn + ", Aluno ID: " + alunoId);
                return isbn;
            } else {
                System.out.println("Não há ISBNs disponíveis para solicitação.");
                return "1";
            }
        } catch (SQLException e) {
            return "2";
        }
    }
        
        public static String remSolicitacao( String isbn){
            
        String removerSolicitacaoSql = "DELETE FROM solicitacoes WHERE isbn = ?";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement removerSolicitacaoStmt = conn.prepareStatement(removerSolicitacaoSql)) 
        {
            removerSolicitacaoStmt.setString(1, isbn);
            
            int checarRemove = removerSolicitacaoStmt.executeUpdate();

            if (checarRemove > 0) {
                System.out.println("Solicitação removida com sucesso! ISBN: " + isbn );
                return "0";
            } else {
                System.out.println("Nenhuma solicitação encontrada para remover.");
                return "1";
                }
        } 
        catch (SQLException e) {
            return "2";
    }
        
        }
        //retorna o titulo do livro por meio do id
        public static String getTitleByID(int id){
            String sql = "SELECT titulo FROM livros WHERE id = ?";
            Connection conn = Conexao.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
               
                stmt.setInt(1, id);           
                 try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                        //System.out.println("dentro do get title" + rs.getString("titulo"));
                        return rs.getString("titulo");
                 }
                  }           
        } catch (SQLException e) {
        }       
            return null;
        }
        
        //retorna o ID do livro por meio do ISBN do exemplar
        public static int getLivroIdByISBN(String isbn) {
            Connection conn = Conexao.getConnection();
            String sql = "SELECT livro_id FROM exemplar WHERE isbn = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        
                stmt.setString(1, isbn);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                         return rs.getInt("livro_id");
                    }
                    }
                     } catch (SQLException e) {
            }
                                return -1; 
            }

      
        //cria a lista de solicitações para ser mostrada na tabela de solicitações
        public List<Solicitacao> BuscaSolicitacoes(int aluno_id) {
            System.out.println("Buscando solicitacoes");
            String sql = "SELECT * FROM solicitacoes WHERE aluno_id = ?";

            List<Solicitacao> listaSolicitacao = new ArrayList<>();
        
        try {
            //System.out.println("Dentro do try das solicitacoes");
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, aluno_id + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Solicitacao soli = new Solicitacao();                         
                soli.setAluno_id(rs.getInt("aluno_id"));
                String isbn = rs.getString("isbn");
                soli.setISBN(isbn); 
                int livro_id = getLivroIdByISBN(isbn);
                soli.setID(livro_id);   
                String titulo = getTitleByID(livro_id);
                soli.setTitulo(titulo);
                System.out.println(soli.getNome() + " Solicitação adicionada");
                listaSolicitacao.add(soli);
            }
        } catch (SQLException e) {
        }

        return listaSolicitacao;
    }
        
        public List<Solicitacao> BuscaSolicitacoes() {
            System.out.println("Buscando solicitacoes");
            String sql = "SELECT * FROM solicitacoes";

            List<Solicitacao> listaSolicitacao = new ArrayList<>();
        
        try {
            //System.out.println("Dentro do try das solicitacoes");
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Solicitacao soli = new Solicitacao();                         
                soli.setAluno_id(rs.getInt("aluno_id"));
                String isbn = rs.getString("isbn");
                soli.setISBN(isbn); 
                int livro_id = getLivroIdByISBN(isbn);
                soli.setID(livro_id);   
                String titulo = getTitleByID(livro_id);
                soli.setTitulo(titulo);
                System.out.println(soli.getNome() + " Solicitação adicionada");
                listaSolicitacao.add(soli);
            }
        } catch (SQLException e) {
        }

        return listaSolicitacao;
    }
}
