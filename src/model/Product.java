/**
 * 
 */
package model;

/**
 * @author Devin Baack - dfbaack
 * CIS 152 - Spring 2021
 * Apr 11, 2021
 */
public class Product {
	private String productID;
	private double unitPrice;
	private String productName;
	private int quantity;
	private double productTotalPrice;
	
	public Product() {
		super();
	}
	
	public Product(String productID, String productName, double unitPrice) {
		this.productID = productID;
		this.productName = productName;
		this.unitPrice = unitPrice;
	}
	
	public Product(String productID, double unitPrice, String productName, int quantity, double productTotalPrice) {
		super();
		this.productID = productID;
		this.unitPrice = unitPrice;
		this.productName = productName;
		this.quantity = quantity;
		this.productTotalPrice = productTotalPrice;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getProductTotalPrice() {
		return productTotalPrice;
	}

	public void setProductTotalPrice(double productTotalPrice) {
		this.productTotalPrice = productTotalPrice;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", unitPrice=" + unitPrice + ", productName=" + productName
				+ ", quantity=" + quantity + ", productTotalPrice=" + productTotalPrice + "]";
	}
	
	
	
}
