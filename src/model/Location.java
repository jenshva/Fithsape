package model;

/**
 * 
 * Skeleton subclass for representing a row from the 'location' table.
 * @author Jens van der Sman
 */
public class Location {
	private String name,street, houseNumberAdd, postalCode, city;
	private int id, houseNumber;
	private boolean isDeleted;
	
	/**
	 * 
	 * Default constructor
	 */
	public Location(){	
	}
	
	/**
	 * 
	 * @param name
	 * @param street
	 * @param houseNumber
	 * @param houseNumberAdd
	 * @param postalCode
	 * @param city
	 * @param isDeleted 
	 */
	public Location(String name, String street, int houseNumber, 
			String houseNumberAdd, String postalCode, String city, 
			boolean isDeleted) {
		this.id				= 0; //TODO: Set proper id
		this.name			= name;
		this.street			= street;
		this.houseNumber	= houseNumber;
		this.houseNumberAdd	= houseNumberAdd;
		this.postalCode		= postalCode;
		this.city			= city;
		this.isDeleted		= isDeleted;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * 
	 * @param street 
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * 
	 * @return houseNumberAdd
	 */
	public String getHouseNumberAdd() {
		return houseNumberAdd;
	}

	/**
	 * 
	 * @param houseNumberAdd 
	 */
	public void setHouseNumberAdd(String houseNumberAdd) {
		this.houseNumberAdd = houseNumberAdd;
	}

	/**
	 * 
	 * @return postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * 
	 * @param postalCode 
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @param city 
	 */
	public void setCity(String city) {
		this.city = city;
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
	 * @return houseNumber
	 */
	public int getHouseNumber() {
		return houseNumber;
	}

	/**
	 * 
	 * @param houseNumber 
	 */
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
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