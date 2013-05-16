
package model;

/**
 *
 * @author Prizz
 */
public class FacilityAvailability {
    private int id, location, amount;
    
    /**
     *
     */
    public FacilityAvailability(){
    }
    
    /**
     *
     * @param id
     * @param location
     * @param amount
     */
    public FacilityAvailability(int id, int location, int amount){
        
        this.id = id;
        this.amount = amount;
        this.location = location;
        
    }
    /**
     *
     * @return
     */
    public int getId(){
    return  id;
    }
    /**
     *
     * @return
     */
    public int getAmount(){
        return amount;
    }
    /**
     *
     * @return
     */
    public int getLocation(){
        return location;
    }
    
}