/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Yama
 */
public class Invoicestatus {
    private int id;
    private String name;
    
    public Invoicestatus(){

    }
    /**
     * @param id
     * @param name 
     */
    public Invoicestatus(int id, String name){
        this.id = id;
        this.name = name;     
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    /**
     * name
     * @return 
     */
    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }
}
