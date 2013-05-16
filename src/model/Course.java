
package model;

/**
 *
 * @author Prizz
 */
public class Course {
    private int id, price;
    private String name, description;

    /**
     *
     */
    public Course(){
       
   }
   
    /**
     *
     * @param name
     * @param description
     * @param id
     * @param price
     */
    public Course(String name, String description, int id, int price){
   this.name = name;
   this.description = description;
   this.id = id;
   this.price = price;
           
    }
    /**
     *
     * @return
     */
    public String getName(){
    return name;

}
    /**
     *
     * @return
     */
    public String getDescription(){
    return description;
}

    /**
     *
     * @return
     */
    public int getId(){
    return id;
}
    /**
     *
     * @return
     */
    public int getPrice(){
    return price;
}
}
    

