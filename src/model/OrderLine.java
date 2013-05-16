/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Yama
 */
public class OrderLine {
    private int id, productId,amount, orderId,reservationId,subscriptionId;
    private double price;
public OrderLine(){
    
}
/**
 * @param id
 * @param productId
 * @param amount
 * @param price
 * @param orderId
 * @param reservationId
 * @param subscriptionId 
 */
public OrderLine(int id,int productId, int amount,double price, int orderId, int reservationId, int subscriptionId){
    
    this.id= id;
    this.productId = productId;
    this.amount = amount;
    this.price = price;
    this.orderId = orderId;
    this.reservationId = reservationId;
    this.subscriptionId = subscriptionId; 
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
 * @return productId
 */
public int getProductId(){
    return productId;
}
public void setProductId(int productId){
    this.productId = productId;
}
/**
 * @return amount 
 */
public int getAmount(){
    return amount;
}
public void setAmount(int amount){
    this.amount = amount;
}
/**
 * @return price
 */
public double getPrice(){
    return price;
}
public void setPrice(double price){
    this.price = price;
}
/**
 * @return orderId
 */
public int getOrderId(){
    return orderId;
}
public void setOrderId(int orderId){
    this.orderId = orderId;
}
/**
 * @return reservationId
 */
public int getReservationId(){
    return reservationId;
}
public void setReservationId(int reservationId){
    this.reservationId = reservationId;
 
}
/**
 * @return subscriptionId
 */
public int getSubscriptionId(){
    return subscriptionId;
}
public void setSubscriptionId(int subscriptionId){
    this.subscriptionId = subscriptionId;
}
}
