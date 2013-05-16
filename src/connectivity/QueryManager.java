package connectivity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 * The Query Manager is responsible for all the interaction with the database.
 * It uses the DataBaseManager @see(DbManager.class) to get to the database.
 */
public class QueryManager {

    private final DbManager dbmanager;

    public QueryManager(DbManager dbmanager) {
        this.dbmanager = dbmanager;
    }

    public Product getProduct(int productId) {
        Product product = new Product();
        try {
            String sql = "SELECT * FROM product WHERE product_id='" + productId + "'";
            ResultSet result = dbmanager.doQuery(sql);
            if (result.next()) {
                product = (new Product(result.getInt("product_id"),
						result.getString("name"),
                        result.getInt("productcategory_id"),
                        result.getDouble("price"),
						result.getInt("tax"),
						result.getBoolean("isdeleted")));
            }
        } catch (SQLException e) {
            System.err.println(DbManager.SQL_EXCEPTION + e.getMessage());
            e.printStackTrace(System.err);
        }
        return product;
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<Product>();
        try {
            String sql = "SELECT * FROM product ORDER BY name ASC";
            ResultSet result = dbmanager.doQuery(sql);
            while (result.next()) {
                products.add(new Product(result.getInt("product_id"),
						result.getString("name"),
                        result.getInt("productcategory_id"),
                        result.getDouble("price"),
						result.getInt("tax"),
						result.getBoolean("isdeleted")));
            }
        } catch (SQLException e) {
            System.err.println(DbManager.SQL_EXCEPTION + e.getMessage());
            e.printStackTrace(System.err);
        }
        return products;
    }
	public List<Product> getProductsByCategoryId(int categoryId) {
        List<Product> products = new ArrayList<Product>();
        try {
            String sql = "SELECT * FROM product WHERE productcategory_id="+
					categoryId+"ORDER BY name ASC";
            ResultSet result = dbmanager.doQuery(sql);
            while (result.next()) {
                products.add(new Product(result.getInt("product_id"),
						result.getString("name"),
                        result.getInt("productcategory_id"),
                        result.getDouble("price"),
						result.getInt("tax"),
						result.getBoolean("isdeleted")));
            }
        } catch (SQLException e) {
            System.err.println(DbManager.SQL_EXCEPTION + e.getMessage());
            e.printStackTrace(System.err);
        }
        return products;
    }	
	
	public void setProduct(Product product) {
		try{
			String sql = "INSERT INTO product (name, productcategory_id, price, tax) VALUES("+
					"'"+product.getName()+"',"+
					product.getProductCategoryId()+","+
					product.getPrice()+","+
					product.getTax()+")";
			dbmanager.executeQuery(sql);			
		} catch (Exception e) {
            System.err.println(DbManager.SQL_EXCEPTION + e.getMessage());
            e.printStackTrace(System.err);
        }
	}
	
	public void updateProduct(Product product) {
		try{
			String sql = "UPDATE product SET "+
					"name='"+product.getName()+"',"+
					"productcategory_id="+product.getProductCategoryId()+","+
					"price="+product.getPrice()+","+
					"tax="+product.getTax()+" "+
					"WHERE product_id="+product.getId();
					
			dbmanager.executeQuery(sql);			
		} catch (Exception e) {
            System.err.println(DbManager.SQL_EXCEPTION + e.getMessage());
            e.printStackTrace(System.err);
        }
	}
	public List<ProductCategory> getCategories(){
		List<ProductCategory> categories = new ArrayList();
		
		try {
            String sql = "SELECT * FROM productcategory ORDER BY name ASC";
            ResultSet result = dbmanager.doQuery(sql);
            while (result.next()) {
                ProductCategory category = new ProductCategory(
						result.getInt("productcategory_id"),
                        result.getString("name"),
						result.getBoolean("isdeleted"));
                categories.add(category);
            }
        } catch (SQLException e) {
            System.err.println(DbManager.SQL_EXCEPTION + e.getMessage());
            e.printStackTrace(System.err);
        }
		
		return categories;
	}
	public ProductCategory getCategoryByName(String name){
		ProductCategory category = new ProductCategory();
		try{
			String sql = "SELECT * FROM productcategory WHERE name='"+name+"'";
            ResultSet result = dbmanager.doQuery(sql);
			while (result.next()) {
				category = new ProductCategory(
					result.getInt("productcategory_id"),
					result.getString("name"),
					result.getBoolean("isdeleted"));
			}
           		
		}catch (SQLException e) {
            System.err.println(DbManager.SQL_EXCEPTION + e.getMessage());
            e.printStackTrace(System.err);
        }
		return category;
	}
}
