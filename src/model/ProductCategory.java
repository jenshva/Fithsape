package model;

/**
 *
 * Skeleton subclass for representing a row from the 'productcategory' table.
 * @author Jens van der Sman
 */
public class ProductCategory {
	private int id;
	private String name;
	private boolean isDeleted;

	/**
	 * 
	 * Default constructor
	 */
	public ProductCategory() {
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param isDeleted 
	 */
	public ProductCategory(int id, String name, boolean isDeleted) {
		this.id			= id;
		this.name		= name;
		this.isDeleted	= isDeleted;
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
	 * @return isDeleted
	 */
	public boolean isIsDeleted() {
		return isDeleted;
	}

	/**
	 * 
	 * @param isDeleted 
	 */
	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	/**
	 * 
	 * @return name
	 */
    @Override
	public String toString(){
		return this.name;
	}	
}