/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;


public class Obra {
    private String titulo;
    private String autores;
    private int id;
    private String volume;
    private String editora;
    private String numeroPaginas;
    private int numeroExemplares;
    // Construtor
    public Obra(String titulo) {
        this.titulo = titulo;
    }
 
    public void setAutor(String autor) {
        this.autores = autor;
    }

    public void setNumeroExemplares(int num){
        this.numeroExemplares = num;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(String numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setId(int aInt) {
         this.id = aInt;
    }

    public int getId() {
       return id;
    }

    public String getAutor() {
        return autores;
    }

    public int getNumeroExemplares() {
        return numeroExemplares;
    }
}

