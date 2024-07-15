/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author lofts
 */
public class Exemplar {
    private String isbn;
    private int id;
    
    public void setID(int id){
        this.id = id;
    }
    
    public void setISBN(String isbn){
        this.isbn = isbn;

    }
    public String getISBN(){
        return isbn;
    }
    public int getID(){
        return id;
    }
    
}
