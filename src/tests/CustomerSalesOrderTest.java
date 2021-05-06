/***************************************************************
 * Name : CustomerSalesOrderTest.java
 * Author: Devin Baack 
 * Created : 05/5/2021
 * Course: CIS 152 - Data Structures 
 * Version: 10.15.7 
 * OS: macOS Catalina 
 * IDE: Eclipse 2020-12
 * Copyright : This is my own original work based on specifications 
 * issued by our instructor 
 * Description : This program is responsible for testing the functionalities
 * 				 of the methods within the CustomerSalesOrderView. java file.
 * Academic Honesty: I attest that this is my original work. I have
 * not used unauthorized source code, either modified or unmodified. 
 * I have not given other fellow student(s) access to my program.
 ***************************************************************
 * 
 * 
 * 
 */

package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import view.CustomerSalesOrderView;
import org.junit.jupiter.api.Test;

import model.Customer;
import model.Order;
import model.Product;

/**
 * @author Devin Baack - dfbaack
 * CIS 152 - Spring 2021
 * May 5, 2021
 */
class CustomerSalesOrderTest {

	/**
	 * This method tests the reverse method which is used to reverse the order of the sorted list into descending order
	 */
	@Test
	void testReverse() {
		String result = "";
		ArrayList<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		ints.add(3);
		
		CustomerSalesOrderView.reverse(ints);
		for(Integer elem : ints) {
			result += elem;
		}
		
		assertEquals("321", result);
	}
	
	/**
	 * This method tests the selection sort for the customers ArrayList
	 */
	@Test
	void testCustomerSelectionSort() {
		String result = "";
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		Customer customer1 = new Customer("Devin", "Baack", "7122105392","dfbaack@gmail.com");
		Customer customer2 = new Customer("Bob", "Sanders", "7122105391","bsanders@gmail.com");
		Customer customer3 = new Customer("John", "Doe", "7122105393","jdoe@gmail.com");
		
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		
		CustomerSalesOrderView.customerSelectionSort(customers, "First Name", false);
		
		for(Customer customer : customers) {
			result += customer.getFirstName();
		}
		
		assertEquals("BobDevinJohn", result);
	}
	
	/**
	 * This method tests the selection sort for the products ArrayList
	 */
	@Test
	void testProductSelectionSort() {
		String result = "";
		ArrayList<Product> products = new ArrayList<Product>();
		
		Product product1 = new Product("A100", "Pencil", 2.34);
		Product product2 = new Product("A200", "Marker", 4.44);
		Product product3 = new Product("A300", "Eraser", 1.19);
		
		products.add(product1);
		products.add(product2);
		products.add(product3);
		
		CustomerSalesOrderView.productSelectionSort(products, "Unit Price", true);
		
		for(Product product : products) {
			result += product.getUnitPrice() + " ";
		}
		
		assertEquals("1.19 2.34 4.44 ", result);
	}
	
	/**
	 * This method tests the selection sort for the orders ArrayList
	 */
	@Test
	void testOrderSelectionSort() {
		String result = "";
		ArrayList<Order> orders = new ArrayList<Order>();
		
		Customer devin = new Customer("Devin", "Baack", "7122105392","dfbaack@gmail.com");
		ArrayList<Product> products = new ArrayList<Product>();
		Product product1 = new Product("A100", "Pencil", 2.34);
		Product product2 = new Product("A200", "Marker", 4.44);
		Product product3 = new Product("A300", "Eraser", 1.19);
		products.add(product1);
		products.add(product2);
		products.add(product3);
		
		Order order1 = new Order("School Order", devin, products, 0, "Joe");
		Order order2 = new Order("Bank Order", devin, products, 0, "Phil");
		Order order3 = new Order("Library Order", devin, products, 0, "Frank");
		
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		
		CustomerSalesOrderView.orderSelectionSort(orders, "Order Name", false);
		
		for(Order order : orders) {
			result += "# " + order.getOrderName() + " #";
		}
		
		assertEquals("# Bank Order ## Library Order ## School Order #", result);
	}

}
