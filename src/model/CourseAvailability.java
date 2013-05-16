
package model;

import java.util.Date;

/**
 *
 * @author Prizz
 */
public class CourseAvailability {
    private int instructorId, locationId, maxCapacity, minCapacity;
    private Date startDate;

    /**
     *
     */
    public CourseAvailability(){

}
    /**
     *
     
     * @param Id 
     * @param instructorId
     * @param locationId
     * @param maxCapacity
     * @param minCapacity
     * @param startDate  
     */
    public CourseAvailability(int Id, int instructorId, int locationId, int maxCapacity, int minCapacity
            ,Date startDate){
   
   this.instructorId = instructorId;
   this.locationId = locationId;
   this.maxCapacity = maxCapacity;
   this.minCapacity = minCapacity;
           
  
    }
    /**
     *
     * @return
     */
    public int getLocationId(){
    return  locationId;
    }
    /**
     *
     * @return
     */
    public int getInstructiorId(){
    return instructorId;
    }
    /**
     *
     * @return
     */
    public int getMaxCapacity(){
        return maxCapacity;
    }
    /**
     *
     * @return
     */
    public int getMinCapacity(){
        return minCapacity;
    }
    }

