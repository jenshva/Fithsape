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

public class Order {
    private int id,memberId,locationId,invoiceId,employeeId;
    private Date date; 
    
    public Order(){
        
    }
    /**
     * 
     * @param id
     * @param memberId
     * @param locationId
     * @param invoiceId
     * @param employeeId
     * @param date 
     */
    public Order(int id, int memberId,int locationId, int invoiceId, int employeeId, Date date){
        this.id= id;
        this.memberId = memberId;
        this.locationId = locationId;
        this.invoiceId = invoiceId;
        this.employeeId = employeeId;
        this.date= date;
     }
    /**
     * @return id
     */
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    /**
     * @return memeberid
     */
    public int getMemeberId(){
        return memberId;
    }
    public void setMemberId(int memeberId){
        this.memberId = memeberId;
    }
    /**
     * @return locationId
     */
    public int getLocationId(){
        return locationId;
    }
    public void setLocationId(int locationeId){
        this.locationId = locationId;
    }
    /**
     * @return invoiceId
     */
    public int getInvoiceId(){
        return invoiceId;
    }
    public void setInvoiceId(int invoiceId){
        this.invoiceId = invoiceId;
    }
    /**
     * @return employeeId
     */
    public int getEmployeeId(){
        return employeeId;
    }
    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }
    /**
     * @return date
     */
    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }
}
