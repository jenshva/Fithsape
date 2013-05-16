package view;

import connectivity.QueryManager;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import main.Fitshape;
import model.Product;
import model.ProductCategory;

/**
 *
 * @author Jens van der Sman
 */
public class ProductList extends JPanel implements MouseListener, ActionListener{
    private final int verticalPosition = 90;
    private final int offset = 40;	
	private JLabel lblDot, lblProduct, lblPrice;
	private JComboBox cbFilter;
	private ProductCategory productCategory;
	
	/**
	 * Loads the default product list
	 */
    public ProductList() {
        super();
        setLayout(null);
        initComponents();
    }	
	
	/**
	 * Loads the product list with a ProductCategory filter applied.
	 * @param category 
	 */
	public ProductList(ProductCategory productCategory){
		super();
		setLayout(null);
		this.productCategory = productCategory;
        initComponents();
	}
	
	/**
	 * Function to initialize all components
	 */
	private void initComponents() {
        addTitle();
		addFilter();
		addProductItems();
		addNewProductButton();
    }
	
	/**
	 * Sets the screen title.
	 */
    private void addTitle() {
        JLabel lblTitle = new JLabel();
        lblTitle.setText("Product overzicht");
        lblTitle.setBounds(20, 20, 300, 20);
        lblTitle.setFont(Fitshape.FONT_16_BOLD);
        add(lblTitle);
    }
	
	/**
	 * Adds a filter label with a drop down list.
	 */
	private void addFilter(){
		JLabel lblTitle = new JLabel();
        lblTitle.setText("Filter:");
        lblTitle.setBounds(20, 60, 300, 30);
        lblTitle.setFont(Fitshape.FONT_12_BOLD);
        add(lblTitle);
		
		cbFilter = new JComboBox();
		cbFilter.addItem("Alle producten");
		QueryManager queryManager = Fitshape.getQueryManager();
		List<ProductCategory> categories = new ArrayList();
		categories = queryManager.getProductCategories();
		for(int i=0;i<categories.size();i++){
			cbFilter.addItem(categories.get(i));
			if(productCategory != null && categories.get(i).getId() == productCategory.getId()){
				cbFilter.setSelectedItem(categories.get(i));
			}
		}
        cbFilter.setBounds(120, 60, 200, 30);
        cbFilter.setFont(Fitshape.FONT_10_PLAIN);
		cbFilter.addActionListener(this);
		
        add(cbFilter);
	}
	
	/**
	 * Loads the product list
	 */
	private void addProductItems(){
		QueryManager queryManager = Fitshape.getQueryManager();
		List<Product> products;
		if(productCategory == null){
			products = queryManager.getProducts();			
		} else {
			products = queryManager.getProductsByCategoryId(productCategory.getId());
		}
		
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            lblDot = new JLabel("\u2022");
            lblDot.setFont(Fitshape.FONT_12_BOLD);
            lblDot.setBounds(20, verticalPosition + i * offset, 10, 20);
            add(lblDot);

            lblProduct = new JLabel();
            lblProduct.setName(String.valueOf(product.getId()));
            lblProduct.setText(product.getName());
            lblProduct.setBounds(35, verticalPosition + i * offset, 200, 20);
            lblProduct.setFont(Fitshape.FONT_12_BOLD);
            lblProduct.addMouseListener(this);
            lblProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            add(lblProduct);

            lblPrice = new JLabel();
            lblPrice.setText(String.valueOf(product.getPrice()));
            lblPrice.setBounds(35, verticalPosition  + i * offset + 15, 200, 20);
            lblPrice.setFont(Fitshape.FONT_10_PLAIN);
            add(lblPrice);
        }
	}
	
	/**
	 * Add the add new product button.
	 */
	public void addNewProductButton(){
		JButton btnAddProduct = new JButton("Nieuw product toevoegen");
        btnAddProduct.setBounds(180, 250, 150, 20);
        btnAddProduct.setFont(Fitshape.FONT_10_BOLD);
		btnAddProduct.addActionListener(this);
        this.add(btnAddProduct);
	}
	
	/**
	 * The mouseClicked event on a product will direct the user toward the
	 * ManageProduct view where a product can be modified or deleted.
	 * @param event 
	 */
	@Override
    public void mouseClicked(MouseEvent event) {
        JLabel label = (JLabel) event.getSource();
        int productId = Integer.parseInt(label.getName());
        ManageProduct manageProduct = new ManageProduct(productId);
        Fitshape.getInstance().showPanel(manageProduct);
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        // Intentionally left blank.
    }

    @Override
    public void mousePressed(MouseEvent event) {
        // Intentionally left blank.
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        // Intentionally left blank.
    }

    @Override
    public void mouseExited(MouseEvent event) {
        // Intentionally left blank.
    }

	/**
	 * Draws a line
	 */
	
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawLine(20, 45, 540, 45);
    }

	/**
	 * The actionPerformed event can perform two separate actions.
	 * Option 1 - e.getActionCommand = "Nieuw product toevoegen":
	 * Occurs if the "Nieuw product toevoegen" button is pressed.
	 * Loads the ManageProduct view without parameter to create a new product.
	 * 
	 * Option 2 - e.getActionCommand = "comboBoxChanged":
	 * Occurs if the drop down list value is changed.
	 * Load the ProductList view with a ProductCategory as parameter.
	 * The product list will be filtered.
	 * @param e 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
			case "Nieuw product toevoegen":
				ManageProduct manageProduct = new ManageProduct();
				Fitshape.getInstance().showPanel(manageProduct);					
				break;
			case "comboBoxChanged":
				QueryManager queryManager = Fitshape.getQueryManager();
				productCategory = queryManager.getProductCategoryByName(String.valueOf(cbFilter.getSelectedItem()));
				ProductList productList;
				if(productCategory == null || productCategory.getName() == null){
					productList = new ProductList();	
				} else {
					productList = new ProductList(productCategory);			
				}
				Fitshape.getInstance().showPanel(productList);
				break;
		}
	}
}
