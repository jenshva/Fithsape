/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connectivity.QueryManager;
import java.awt.Color;
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
import javax.swing.JTextField;
import main.Fitshape;
import model.ProductCategory;
import model.Product;

/**
 *
 * @author Jens van der Sman
 */
public class ManageProduct  extends JPanel implements MouseListener, ActionListener{
	private Product product;
	private JTextField tfProductName, tfPrice, tfTax;
	private JComboBox cbProductCategoryName;
	private boolean newProduct = false;

	public ManageProduct() {
		newProduct		= true;
		this.product	= new Product();
		setLayout(null);
		initComponents();
	}
	
	public ManageProduct(int id) {
		super();
		QueryManager queryManager = Fitshape.getQueryManager();
		this.product = queryManager.getProduct(id);
        setLayout(null);
        initComponents();
	}

	private void initComponents() {
        this.setBackground(Color.white);
        addTitle();
		addForm();
    }
	
    private void addTitle() {
        JLabel lblTitle = new JLabel();
        lblTitle.setText("Product aanpassen");
        lblTitle.setBounds(20, 20, 300, 20);
        lblTitle.setFont(Fitshape.FONT_16_BOLD);
        add(lblTitle);
    }
	
	private void addForm(){
		
		JLabel lblProductName = new JLabel();
        lblProductName.setText("Naam");
        lblProductName.setBounds(30, 90, 100, 40);
        lblProductName.setFont(Fitshape.FONT_10_BOLD);
        add(lblProductName);		
		
		tfProductName = new JTextField(20);
		tfProductName.setText(product.getName());
        tfProductName.setBounds(120, 90, 200, 40);
        tfProductName.setFont(Fitshape.FONT_10_PLAIN);
        add(tfProductName);
		
		JLabel lblProductCategoryName = new JLabel();
        lblProductCategoryName.setText("Categorie");
        lblProductCategoryName.setBounds(30, 130, 100, 40);
        lblProductCategoryName.setFont(Fitshape.FONT_10_BOLD);
        add(lblProductCategoryName);		
		
		cbProductCategoryName = new JComboBox();
		if(newProduct){
			cbProductCategoryName.addItem("Kies een categorie");
		}
		QueryManager queryManager = Fitshape.getQueryManager();
		List<ProductCategory> categories = new ArrayList();
		categories = queryManager.getCategories();
		for(int i=0;i<categories.size();i++){
			cbProductCategoryName.addItem(categories.get(i));
			if(categories.get(i).getId() == product.getProductCategoryId()){
				cbProductCategoryName.setSelectedItem(categories.get(i));
			}
		}
        cbProductCategoryName.setBounds(120, 130, 200, 40);
        cbProductCategoryName.setFont(Fitshape.FONT_10_PLAIN);

        add(cbProductCategoryName);
		
		JLabel lblPrice = new JLabel();
        lblPrice.setText("Prijs");
        lblPrice.setBounds(30, 170, 100, 40);
        lblPrice.setFont(Fitshape.FONT_10_BOLD);
        add(lblPrice);		
		
		tfPrice = new JTextField(20);
		tfPrice.setText(String.valueOf(product.getPrice()));
        tfPrice.setBounds(120, 170, 200, 40);
        tfPrice.setFont(Fitshape.FONT_10_PLAIN);
        add(tfPrice);
		
		JLabel lblTax = new JLabel();
        lblTax.setText("Belasting");
        lblTax.setBounds(30, 210, 100, 40);
        lblTax.setFont(Fitshape.FONT_10_BOLD);
        add(lblTax);		
		
		tfTax = new JTextField(20);
		tfTax.setText(String.valueOf(product.getTax()));
        tfTax.setBounds(120, 210, 200, 40);
        tfTax.setFont(Fitshape.FONT_10_PLAIN);
        add(tfTax);		
		
		
		JButton btnCancel = new JButton("Annuleer");
        btnCancel.setBounds(30, 250, 150, 20);
        btnCancel.setFont(Fitshape.FONT_10_BOLD);
		btnCancel.addActionListener(this);
        this.add(btnCancel);
		
		JButton btnSubmit = new JButton("Bevestig");
        btnSubmit.setBounds(180, 250, 150, 20);
        btnSubmit.setFont(Fitshape.FONT_10_BOLD);
		btnSubmit.addActionListener(this);
        this.add(btnSubmit);
	}
	
	
	@Override
    public void mouseClicked(MouseEvent event) {
        JLabel label = (JLabel) event.getSource();
		System.out.println(label);
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

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawLine(20, 45, 540, 45);
    }	

	@Override
	public void actionPerformed(ActionEvent e) {
		if("Bevestig".equals(e.getActionCommand())){
			QueryManager queryManager = Fitshape.getQueryManager();
			this.product.setName(tfProductName.getText());
			this.product.setPrice(Double.parseDouble(tfPrice.getText()));
			this.product.setTax(Integer.parseInt(tfTax.getText()));
			ProductCategory category = queryManager.getCategoryByName(String.valueOf(cbProductCategoryName.getSelectedItem()));
			this.product.setProductCategoryId(category.getId());
			
			if(newProduct){
				queryManager.setProduct(this.product);
			} else {
				queryManager.updateProduct(this.product);
			}
		}
		ProductList productList = new ProductList();
		Fitshape.getInstance().showPanel(productList);	
	}
}
