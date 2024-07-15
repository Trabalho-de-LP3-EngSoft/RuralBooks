/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author lofts
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class AdicionarUsuario {
     
       public static void addUser(String nome, String senha, String email, boolean isAdmin) {
            String userSql = "INSERT INTO users (nome, senha, email) VALUES (?, ?, ?)";
            String alunoSql = "INSERT INTO alunos (id, num_emprestimos, num_reservas) VALUES (?, ?, ?)";
            String adminSql = "INSERT INTO admins (id) VALUES (?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement userStmt = conn.prepareStatement(userSql, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement alunoStmt = conn.prepareStatement(alunoSql);
             PreparedStatement adminStmt = conn.prepareStatement(adminSql)) {
            
            // Inserir usuário na tabela users
            userStmt.setString(1, nome);
            userStmt.setString(2, senha);
            userStmt.setString(3, email);
            userStmt.executeUpdate();

            // Obter o ID gerado automaticamente para o usuário
            ResultSet generatedKeys = userStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int userId = generatedKeys.getInt(1);
                System.out.println("chegou");
                // Inserir o mesmo ID na tabela aluno ou admins
                if (isAdmin) {
                    adminStmt.setInt(1, userId);
                    adminStmt.executeUpdate();
                } else {
                    alunoStmt.setInt(1, userId);
                    alunoStmt.setInt(2, 0);
                    alunoStmt.setInt(3, 0);
                    alunoStmt.executeUpdate();
                }

                System.out.println("Usuário adicionado com sucesso! ID: " + userId);
            } else {
                throw new SQLException("Falha ao obter o ID do usuário.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
    }
       }
       
       public static boolean usuarioExiste(String nome, String email) {
        String sql = "SELECT COUNT(*) FROM users WHERE nome = ? OR email = ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nome);
            stmt.setString(2, email);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // true se ja existe
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false; // false se nao existe
    }
       
       public static int getIdUsuario(String nome) {
            String sql = "SELECT id FROM users WHERE nome = ?";
        
        try (Connection conn = Conexao.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
            
                stmt.setString(1, nome);
            
                 try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                        return rs.getInt("id");
                 }
                  }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return -1;
    }
      
       public static boolean getAdminUsuario(String nome) {
            String sql = "SELECT id FROM users WHERE nome = ?";
        
        try (Connection conn = Conexao.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
            
                stmt.setString(1, nome);
            
                 try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                                int idSearch = rs.getInt("id");
                                System.out.println("id autenticar = "+ idSearch);
                                String sql2 = "SELECT * FROM admins WHERE id = ?";
                                PreparedStatement stmt2 = conn.prepareStatement(sql2);
                                stmt2.setInt(1, idSearch);
                                try (ResultSet rs2 = stmt2.executeQuery()) {
                        if (rs2.next()) {
                                    return true;
                                }
                            }
            
                            }} catch (SQLException e) {
                                    e.printStackTrace();
                            }
                 
                  }catch (SQLException e) {
                    e.printStackTrace();
        }
        
        return false;
    }
       
       public static String getEmailUsuario(String nome) {
            String sql = "SELECT email FROM users WHERE nome = ?";
        
        try (Connection conn = Conexao.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql))
        {
            
                stmt.setString(1, nome);
            
                 try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                        return rs.getString("email");
                 }
                  }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return "";
    }
       
      public static boolean autenticar(String nome, String senha) {
        String sql = "SELECT * FROM users WHERE nome = ? AND senha = ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // true se encontrar igual
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // returns false if no match is found or if an exception occurs
    }
       
}

