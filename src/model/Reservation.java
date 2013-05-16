package model;

import java.util.Date;

/**
 *
 * Skeleton subclass for representing a row from the 'reservation' table.
 * @author Jens van der Sman
 */
public class Reservation {
	private int id, employeeId, memberId, courseAvailabilityId, 
			activityAvailabilityId,facilityAvailabilityId, reservationStateId;
	private Date reservationDate, startDateTime, endDateTime;
	private boolean isDeleted;

	/**
	 * 
	 * Default constructor
	 */
	public Reservation() {
	}

	/**
	 * 
	 * @param employeeId
	 * @param memberId
	 * @param courseAvailabilityId
	 * @param activityAvailabilityId
	 * @param facilityAvailabilityId
	 * @param reservationStateId
	 * @param reservationDate
	 * @param startDateTime
	 * @param endDateTime
	 * @param isDeleted 
	 */
	public Reservation(int employeeId, int memberId, int courseAvailabilityId, 
			int activityAvailabilityId, int facilityAvailabilityId, 
			int reservationStateId, Date reservationDate, Date startDateTime, 
			Date endDateTime, boolean isDeleted) {
		this.employeeId				= employeeId;
		this.memberId				= memberId;
		this.courseAvailabilityId	= courseAvailabilityId;
		this.activityAvailabilityId	= activityAvailabilityId;
		this.facilityAvailabilityId	= facilityAvailabilityId;
		this.reservationStateId		= reservationStateId;
		this.reservationDate		= reservationDate;
		this.startDateTime			= startDateTime;
		this.endDateTime			= endDateTime;
		this.isDeleted				= isDeleted;
	}

	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * 
	 * @param employeeId 
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * 
	 * @return memberId
	 */
	public int getMemberId() {
		return memberId;
	}

	/**
	 * 
	 * @param memberId 
	 */
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	/**
	 * 
	 * @return courseAvailabilityId
	 */
	public int getCourseAvailabilityId() {
		return courseAvailabilityId;
	}

	/**
	 * 
	 * @param courseAvailabilityId 
	 */
	public void setCourseAvailabilityId(int courseAvailabilityId) {
		this.courseAvailabilityId = courseAvailabilityId;
	}

	/**
	 * 
	 * @return activityAvailabilityId
	 */
	public int getActivityAvailabilityId() {
		return activityAvailabilityId;
	}

	/**
	 * 
	 * @param activityAvailabilityId 
	 */
	public void setActivityAvailabilityId(int activityAvailabilityId) {
		this.activityAvailabilityId = activityAvailabilityId;
	}

	/**
	 * 
	 * @return facilityAvailabilityId
	 */
	public int getFacilityAvailabilityId() {
		return facilityAvailabilityId;
	}

	/**
	 * 
	 * @param facilityAvailabilityId 
	 */
	public void setFacilityAvailabilityId(int facilityAvailabilityId) {
		this.facilityAvailabilityId = facilityAvailabilityId;
	}

	/**
	 * 
	 * @return reservationStateId
	 */
	public int getReservationStateId() {
		return reservationStateId;
	}

	/**
	 * 
	 * @param reservationStateId 
	 */
	public void setReservationStateId(int reservationStateId) {
		this.reservationStateId = reservationStateId;
	}

	/**
	 * 
	 * @return reservationDate
	 */
	public Date getReservationDate() {
		return reservationDate;
	}

	/**
	 * 
	 * @param reservationDate 
	 */
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	/**
	 * 
	 * @return startDateTime
	 */
	public Date getStartDateTime() {
		return startDateTime;
	}

	/**
	 * 
	 * @param startDateTime 
	 */
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	/**
	 * 
	 * @return endDateTime
	 */
	public Date getEndDateTime() {
		return endDateTime;
	}

	/**
	 * 
	 * @param endDateTime 
	 */
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	/**
	 * 
	 * @return isDeleted
	 */
	public boolean getIsDeleted(){
		return isDeleted;
	}
	
	/**
	 * 
	 * @param isDeleted 
	 */
	public void setIsDeleted(boolean isDeleted){
		this.isDeleted = isDeleted;
	}
}