/***************************************************************
 * Name : Product.java
 * Author: Devin Baack 
 * Created : 05/5/2021
 * Course: CIS 152 - Data Structures 
 * Version: 10.15.7 
 * OS: macOS Catalina 
 * IDE: Eclipse 2020-12
 * Copyright : This is my own original work based on specifications 
 * issued by our instructor 
 * Description : This program represents a Product POJO.
 * Academic Honesty: I attest that this is my original work. I have
 * not used unauthorized source code, either modified or unmodified. 
 * I have not given other fellow student(s) access to my program.
 ***************************************************************
 * 
 * 
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
	
	public Product(String productID, double unitPrice, String productName, int quantity) {
		super();
		this.productID = productID;
		this.unitPrice = unitPrice;
		this.productName = productName;
		this.quantity = quantity;
		this.productTotalPrice = unitPrice * quantity;
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
		this.setProductTotalPrice(quantity * this.getUnitPrice());
	}

	public double getProductTotalPrice() {
		return productTotalPrice;
	}

	public void setProductTotalPrice(double productTotalPrice) {
		this.productTotalPrice = productTotalPrice;
	}

	@Override
	public String toString() {
		return "Product " + this.getProductID() + " - " + this.getProductName() + " - $" + this.getUnitPrice();
	}
	
	
	
}
