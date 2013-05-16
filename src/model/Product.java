package model;

/**
 *
 * Skeleton subclass for representing a row from the 'product' table.
 * @author Jens van der Sman
 */

public class Product {
	private int id,productCategoryId, tax;
	private String name;
	private double price;
	private boolean isDeleted;

	/**
	 * 
	 * Default constructor
	 */
	public Product() {
	}
	
	/**
	 * 
	 * @param id 
	 * @param name
	 * @param productCategoryId
	 * @param price
	 * @param tax 
	 * @param isDeleted 
	 */
	public Product(int id, String name, int productCategoryId, double price, 
			int tax, boolean isDeleted) {
		this.id					= id;
		this.productCategoryId	= productCategoryId;
		this.tax				= tax;
		this.name				= name;
		this.price				= price;
		this.isDeleted			= isDeleted;
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
	 * @return productCategoryId
	 */
	public int getProductCategoryId() {
		return productCategoryId;
	}

	/**
	 * 
	 * @param productCategoryId 
	 */
	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	/**
	 * 
	 * @return tax
	 */
	public int getTax() {
		return tax;
	}

	/**
	 * 
	 * @param tax 
	 */
	public void setTax(int tax) {
		this.tax = tax;
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
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price 
	 */
	public void setPrice(double price) {
		this.price = price;
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