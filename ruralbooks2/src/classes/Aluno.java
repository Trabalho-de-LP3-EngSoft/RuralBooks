/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author lofts
 */
public class Aluno extends Usuario {
        private int numEmprestimos;
        private int numReservas;

    public Aluno(String nome, String email, boolean isAdmin) {
        super(nome, email, isAdmin);
    }
}
