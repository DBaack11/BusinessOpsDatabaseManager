/**
 * 
 */
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author Devin Baack - dfbaack
 * CIS 152 - Spring 2021
 * Apr 11, 2021
 */
public class Order {
	private String date;
	private Customer customer;
	private ArrayList<Product> products;
	private double orderTotalPrice;
	private String salesman;
	LocalDateTime now = LocalDateTime.now();
	
	public Order() {
		super();
		this.setDate(now.getMonth() + "/" + now.getDayOfMonth() + "/" + now.getYear());
	}
	
	public Order(Customer customer, ArrayList<Product> products, double orderTotalPrice, String salesman) {
		super();
		this.setDate(now.getMonth() + "/" + now.getDayOfMonth() + "/" + now.getYear());
		this.setCustomer(customer);
		this.setProducts(products);
		this.setOrderTotalPrice(orderTotalPrice);
		this.setSalesman(salesman);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public double getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public String getSalesman() {
		return salesman;
	}

	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}

	@Override
	public String toString() {
		return "Order [date=" + date + ", customer=" + customer + ", products=" + products + ", orderTotalPrice="
				+ orderTotalPrice + ", salesman=" + salesman + "]";
	}
	
	
	
}
