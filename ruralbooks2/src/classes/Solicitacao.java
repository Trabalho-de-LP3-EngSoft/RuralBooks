/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import DAO.Solicitacoes;

public class Solicitacao {
    private Exemplar exemplar;
    private int aluno_id;
    private String titulo;
    
    public Solicitacao(){
        this.exemplar = new Exemplar();
    }
  
    public void setISBN(String isbn){
        exemplar.setISBN(isbn);
    }
    
    public void setID(int id){
        exemplar.setID(id);
        
    }
    
    public void setAluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }
    
    public String getISBN() {
        return exemplar.getISBN();
    }
    
    public String getNome(){
        Solicitacoes soli = new Solicitacoes();
        System.out.println("Solicitacao get nome" + soli.getTitleByID(exemplar.getID()));
        System.out.println("exemplar id"+ exemplar.getID());
        return soli.getTitleByID(exemplar.getID());
    }
  
    public int getAluno_id() {
        return aluno_id;
    }

    public void setTitulo(String title) {
        this.titulo = title;
    }

    
}
