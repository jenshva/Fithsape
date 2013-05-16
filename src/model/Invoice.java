/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Yama
 */
import java.util.Date;

public class Invoice {
    private int id,status;
    private Date date;
    
    public Invoice(){
        
    }
    /**
     * @param id
     * @param status
     * @param date 
     */
    public Invoice(int id, int status,Date date){
        this.id = id;
        this.status = status;
        this.date = date;
    }
    /**
     * id
     * @return 
     */
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    /**
     * staus
     * @return 
     */
    public int getStatus(){
        return status;
    }
    public void setStatus(int status){
        this.status= status;
    }
    /**
     * date
     * @return 
     */
    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }
}
