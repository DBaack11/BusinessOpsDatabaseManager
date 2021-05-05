/**
 * 
 */
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import model.Customer;
import model.Order;
import model.Product;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.JSeparator;

/**
 * @author Devin Baack - dfbaack
 * CIS175 - Spring 2021
 * Apr 27, 2021
 */
public class CustomerSalesOrderView {

	private JFrame frame;
	private JTextField firstNameInput;
	private JTextField lastNameInput;
	private JTextField phoneNumberInput;
	private JTextField emailInput;
	private JTable customersTable;
	private JTextField productInput;
	private JTextField productIDInput;
	private JTextField unitPriceInput;
	private JTable productsTable;
	
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private ArrayList<Product> productList = new ArrayList<Product>();
	private ArrayList<Order> orderList = new ArrayList<Order>();
	private JTextField orderNameInput;
	private JTextField salesmanInput;
	private ArrayList<Product> temp = new ArrayList<Product>();
	private JTable ordersTable;
	private JTextField orderProductsQuantityInput;
	private JTable orderProductsTable;
	DecimalFormat df = new DecimalFormat("##.##");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerSalesOrderView window = new CustomerSalesOrderView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerSalesOrderView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel home = new JPanel();
		home.setBackground(Color.GRAY);
		frame.getContentPane().add(home, "name_44420704456063");
		
		JButton ordersButton = new JButton("Manage Orders");
		ordersButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton customersButton = new JButton("Manage Customers");
		
		customersButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton productsButton = new JButton("Manage Products");
		productsButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GroupLayout gl_home = new GroupLayout(home);
		gl_home.setHorizontalGroup(
			gl_home.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_home.createSequentialGroup()
					.addGap(203)
					.addGroup(gl_home.createParallelGroup(Alignment.LEADING)
						.addComponent(ordersButton, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
						.addComponent(customersButton, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
						.addComponent(productsButton, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
					.addGap(211))
		);
		gl_home.setVerticalGroup(
			gl_home.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_home.createSequentialGroup()
					.addGap(47)
					.addComponent(ordersButton, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(customersButton, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(productsButton, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(29))
		);
		home.setLayout(gl_home);
		
		// ##################################################################################################################################################
		// ################################################################ CUSTOMERS PANEL #################################################################
		// ##################################################################################################################################################
		
		JPanel customers = new JPanel();
		customers.setBackground(Color.GRAY);
		frame.getContentPane().add(customers, "name_47836099236270");
		
		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		JLabel phoneNumberLabel = new JLabel("Phone #:");
		phoneNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		phoneNumberLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		emailLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		firstNameInput = new JTextField();
		firstNameInput.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		firstNameInput.setColumns(10);
		
		lastNameInput = new JTextField();
		lastNameInput.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lastNameInput.setColumns(10);
		
		phoneNumberInput = new JTextField();
		phoneNumberInput.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		phoneNumberInput.setColumns(10);
		
		emailInput = new JTextField();
		emailInput.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		emailInput.setColumns(10);
		
		JButton customerAddButton = new JButton("ADD");
		
		customerAddButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton customerUpdateButton = new JButton("UPDATE");
		
		customerUpdateButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton customerDeleteButton = new JButton("DELETE");
		
		customerDeleteButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton customerClearButton = new JButton("CLEAR");
		
		customerClearButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		JLabel sortByLabel = new JLabel("Sort By:");
		
		JComboBox customersSortByComboBox = new JComboBox();
		customersSortByComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "First Name", "Last Name", "Phone Number", "Email"}));
		
		JRadioButton customerAscendingButton = new JRadioButton("Ascending");
		
		
		JRadioButton customerDescendingButton = new JRadioButton("Descending");
		
		JButton customerSortByButton = new JButton("SORT");
		
		
		JButton customerReturnHomeButton = new JButton("RETURN HOME");
		
		customerReturnHomeButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		GroupLayout gl_customers = new GroupLayout(customers);
		gl_customers.setHorizontalGroup(
			gl_customers.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_customers.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_customers.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_customers.createSequentialGroup()
							.addComponent(sortByLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(customersSortByComboBox, 0, 144, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(customerAscendingButton)
							.addGap(2)
							.addComponent(customerDescendingButton, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(customerSortByButton, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
							.addGap(103))
						.addGroup(gl_customers.createSequentialGroup()
							.addGap(233)
							.addComponent(customerReturnHomeButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(271))
						.addGroup(gl_customers.createSequentialGroup()
							.addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(emailInput, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
							.addGap(340))
						.addGroup(gl_customers.createSequentialGroup()
							.addGroup(gl_customers.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_customers.createSequentialGroup()
									.addComponent(lastNameLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lastNameInput, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
								.addGroup(gl_customers.createSequentialGroup()
									.addComponent(firstNameLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(firstNameInput, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
								.addGroup(gl_customers.createSequentialGroup()
									.addComponent(phoneNumberLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(phoneNumberInput, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
							.addGap(45)
							.addGroup(gl_customers.createParallelGroup(Alignment.LEADING)
								.addComponent(customerAddButton, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
								.addComponent(customerDeleteButton, GroupLayout.PREFERRED_SIZE, 105, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_customers.createParallelGroup(Alignment.LEADING)
								.addComponent(customerClearButton, GroupLayout.PREFERRED_SIZE, 105, Short.MAX_VALUE)
								.addComponent(customerUpdateButton, GroupLayout.PREFERRED_SIZE, 105, Short.MAX_VALUE))
							.addGap(67))
						.addGroup(gl_customers.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
							.addGap(52)))
					.addGap(0))
		);
		gl_customers.setVerticalGroup(
			gl_customers.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_customers.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_customers.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_customers.createSequentialGroup()
							.addGroup(gl_customers.createParallelGroup(Alignment.BASELINE)
								.addComponent(firstNameLabel)
								.addComponent(firstNameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_customers.createParallelGroup(Alignment.BASELINE)
								.addComponent(lastNameLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lastNameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_customers.createParallelGroup(Alignment.BASELINE)
								.addComponent(phoneNumberLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(phoneNumberInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_customers.createParallelGroup(Alignment.BASELINE)
								.addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(emailInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_customers.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_customers.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_customers.createSequentialGroup()
									.addComponent(customerUpdateButton, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
									.addGap(32)
									.addComponent(customerClearButton, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
								.addGroup(gl_customers.createSequentialGroup()
									.addComponent(customerAddButton, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
									.addGap(32)
									.addComponent(customerDeleteButton, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)))
							.addGap(45)))
					.addGap(63)
					.addGroup(gl_customers.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_customers.createSequentialGroup()
							.addGap(2)
							.addComponent(customersSortByComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(sortByLabel)
						.addComponent(customerAscendingButton)
						.addComponent(customerDescendingButton)
						.addComponent(customerSortByButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(customerReturnHomeButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		customersTable = new JTable();
		customersTable.setGridColor(Color.BLACK);
		customersTable.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		scrollPane.setViewportView(customersTable);
		customers.setLayout(gl_customers);
		
		DefaultTableModel customersModel = new DefaultTableModel();
		String[] customerColumnHeaders = {"First Name", "Last Name", "Phone Number", "Email"};
		String[] customerRow = new String[4];
		customersModel.setColumnIdentifiers(customerColumnHeaders);
		customersTable.setModel(customersModel);
		
		
		// ##################################################################################################################################################
		// ################################################################# PRODUCTS PANEL #################################################################
		// ##################################################################################################################################################
		
		
		JPanel products = new JPanel();
		products.setBackground(Color.GRAY);
		frame.getContentPane().add(products, "name_101112397770335");
		
		JLabel sortByLabel_1 = new JLabel("Sort By:");
		
		JComboBox productSortByComboBox = new JComboBox();
		productSortByComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Product ID", "Product Name", "Unit Price"}));
		
		JRadioButton productAscendingButton = new JRadioButton("Ascending");
		
		JRadioButton productDescendingButton = new JRadioButton("Descending");
		
		JButton productSortByButton = new JButton("SORT");
		
		JButton productReturnHomeButton = new JButton("RETURN HOME");
		productReturnHomeButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		JLabel productLabel = new JLabel("Product:");
		productLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		productLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		productInput = new JTextField();
		productInput.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		productInput.setColumns(10);
		
		JLabel productIDLabel = new JLabel("Product ID:");
		productIDLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		productIDInput = new JTextField();
		productIDInput.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		productIDInput.setColumns(10);
		
		JLabel unitPriceLabel = new JLabel("Unit Price:");
		unitPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		unitPriceLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		unitPriceInput = new JTextField();
		unitPriceInput.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		unitPriceInput.setColumns(10);
		
		JButton productAddButton = new JButton("ADD");
		productAddButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton productDeleteButton = new JButton("DELETE");
		productDeleteButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton productClearButton = new JButton("CLEAR");
		productClearButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton productUpdateButton = new JButton("UPDATE");
		productUpdateButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JScrollPane productScrollPane = new JScrollPane();
		GroupLayout gl_products = new GroupLayout(products);
		gl_products.setHorizontalGroup(
			gl_products.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_products.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_products.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_products.createSequentialGroup()
							.addComponent(sortByLabel_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(productSortByComboBox, 0, 144, Short.MAX_VALUE)
							.addGap(6)
							.addComponent(productAscendingButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(productDescendingButton, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(productSortByButton, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
							.addGap(51))
						.addComponent(productScrollPane, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
						.addGroup(gl_products.createSequentialGroup()
							.addGroup(gl_products.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_products.createSequentialGroup()
									.addComponent(unitPriceLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(unitPriceInput, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
								.addGroup(gl_products.createSequentialGroup()
									.addGroup(gl_products.createParallelGroup(Alignment.LEADING)
										.addComponent(productIDLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addComponent(productLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
									.addGap(6)
									.addGroup(gl_products.createParallelGroup(Alignment.LEADING)
										.addComponent(productIDInput, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
										.addComponent(productInput, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))))
							.addGap(46)
							.addGroup(gl_products.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_products.createSequentialGroup()
									.addComponent(productAddButton, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(productUpdateButton, GroupLayout.PREFERRED_SIZE, 105, Short.MAX_VALUE))
								.addGroup(gl_products.createSequentialGroup()
									.addComponent(productDeleteButton, GroupLayout.PREFERRED_SIZE, 105, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(productClearButton, GroupLayout.PREFERRED_SIZE, 105, Short.MAX_VALUE)))
							.addGap(14)))
					.addGap(48))
				.addGroup(Alignment.TRAILING, gl_products.createSequentialGroup()
					.addGap(284)
					.addComponent(productReturnHomeButton, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
					.addGap(267))
		);
		gl_products.setVerticalGroup(
			gl_products.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_products.createSequentialGroup()
					.addGroup(gl_products.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_products.createSequentialGroup()
							.addGap(41)
							.addGroup(gl_products.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_products.createSequentialGroup()
									.addGap(5)
									.addComponent(productIDLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addComponent(productLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_products.createSequentialGroup()
									.addComponent(productIDInput, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(productInput, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
							.addGap(18)
							.addGroup(gl_products.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_products.createSequentialGroup()
									.addGap(9)
									.addComponent(unitPriceLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_products.createSequentialGroup()
									.addGap(4)
									.addComponent(unitPriceInput, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))))
						.addGroup(gl_products.createSequentialGroup()
							.addGap(53)
							.addGroup(gl_products.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_products.createSequentialGroup()
									.addComponent(productUpdateButton, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
									.addGap(69))
								.addGroup(gl_products.createSequentialGroup()
									.addComponent(productAddButton, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
									.addGap(28)
									.addGroup(gl_products.createParallelGroup(Alignment.LEADING)
										.addComponent(productDeleteButton, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
										.addComponent(productClearButton, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))))
							.addGap(14)))
					.addGap(74)
					.addGroup(gl_products.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_products.createSequentialGroup()
							.addGap(5)
							.addComponent(sortByLabel_1))
						.addGroup(gl_products.createSequentialGroup()
							.addGap(1)
							.addComponent(productSortByComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(1))
						.addGroup(gl_products.createSequentialGroup()
							.addGap(1)
							.addComponent(productAscendingButton))
						.addGroup(gl_products.createSequentialGroup()
							.addGap(1)
							.addComponent(productDescendingButton))
						.addGroup(gl_products.createSequentialGroup()
							.addComponent(productSortByButton, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
							.addGap(3)))
					.addGap(6)
					.addComponent(productScrollPane, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(productReturnHomeButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(11))
		);
		
		productsTable = new JTable();
		productsTable.setGridColor(Color.BLACK);
		productsTable.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		productScrollPane.setViewportView(productsTable);
		products.setLayout(gl_products);
		
		DefaultTableModel productsModel = new DefaultTableModel();
		String[] productColumnHeaders = {"Product ID", "Product", "Unit Price"};
		String[] productRow = new String[3];
		productsModel.setColumnIdentifiers(productColumnHeaders);
		productsTable.setModel(productsModel);
		
		
		// ##################################################################################################################################################
		// ################################################################# ORDERS PANEL ###################################################################
		// ##################################################################################################################################################
				
		JPanel orders = new JPanel();
		orders.setBackground(Color.GRAY);
		frame.getContentPane().add(orders, "name_1145650434335");
		
		JLabel orderNameLabel = new JLabel("Order Name:");
		orderNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		orderNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		orderNameInput = new JTextField();
		orderNameInput.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		orderNameInput.setColumns(10);
		
		JLabel orderCustomerLabel = new JLabel("Customer:");
		orderCustomerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		orderCustomerLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		JLabel orderProductsLabel = new JLabel("Products:");
		orderProductsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		orderProductsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		JLabel salesmanLabel = new JLabel("Salesman:");
		salesmanLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		salesmanLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		salesmanInput = new JTextField();
		salesmanInput.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		salesmanInput.setColumns(10);
		
		JLabel sortByLabel_2 = new JLabel("Sort By:");
		
		JComboBox ordersSortByComboBox = new JComboBox();
		ordersSortByComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Order Name", "Customer First Name", "Customer Last Name", "Number of Products", "Salesman", "Order Total Price"}));
		
		JRadioButton orderAscendingButton = new JRadioButton("Ascending");
		
		JRadioButton orderDescendingButton = new JRadioButton("Descending");
		
		JButton orderSortByButton = new JButton("SORT");
		
		JScrollPane orderScrollPane = new JScrollPane();
		
		JComboBox orderCustomerComboBox = new JComboBox();
		orderCustomerComboBox.addItem(null);
		
		
		JComboBox orderProductComboBox = new JComboBox();
		orderProductComboBox.addItem(null);
		
		JLabel orderProductsQuantityLabel = new JLabel("Quantity:");
		orderProductsQuantityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		orderProductsQuantityLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		orderProductsQuantityInput = new JTextField();
		orderProductsQuantityInput.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		orderProductsQuantityInput.setColumns(10);
		
		JButton orderProductAddButton = new JButton("ADD PRODUCT");
		
		JButton orderReturnHomeButton = new JButton("RETURN HOME");
		orderReturnHomeButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		JScrollPane orderProductsScrollPane = new JScrollPane();
		
		JButton orderAddButton = new JButton("ADD");
		orderAddButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton orderUpdateButton = new JButton("UPDATE");
		orderUpdateButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton orderDeleteButton = new JButton("DELETE");
		orderDeleteButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton orderClearButton = new JButton("CLEAR");
		orderClearButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel ordersTableLabel = new JLabel("Orders");
		
		JLabel orderProductsTableLabel = new JLabel("Order Products ");
		GroupLayout gl_orders = new GroupLayout(orders);
		gl_orders.setHorizontalGroup(
			gl_orders.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_orders.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_orders.createSequentialGroup()
							.addComponent(orderScrollPane, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(orderProductsScrollPane, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
						.addGroup(gl_orders.createSequentialGroup()
							.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_orders.createSequentialGroup()
										.addGroup(gl_orders.createParallelGroup(Alignment.TRAILING)
											.addComponent(orderProductsLabel)
											.addComponent(orderCustomerLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
											.addComponent(salesmanLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_orders.createParallelGroup(Alignment.TRAILING)
											.addComponent(salesmanInput, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
											.addComponent(orderCustomerComboBox, 0, 279, Short.MAX_VALUE)
											.addGroup(gl_orders.createSequentialGroup()
												.addComponent(orderProductComboBox, 0, 165, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(orderProductAddButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))))
									.addGroup(gl_orders.createSequentialGroup()
										.addComponent(orderNameLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(orderNameInput, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)))
								.addGroup(gl_orders.createSequentialGroup()
									.addGap(98)
									.addComponent(orderProductsQuantityLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(orderProductsQuantityInput, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
							.addGap(27)
							.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_orders.createSequentialGroup()
									.addComponent(orderAddButton, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(orderUpdateButton, GroupLayout.PREFERRED_SIZE, 105, Short.MAX_VALUE))
								.addGroup(gl_orders.createSequentialGroup()
									.addComponent(orderDeleteButton, GroupLayout.PREFERRED_SIZE, 105, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(orderClearButton, GroupLayout.PREFERRED_SIZE, 105, Short.MAX_VALUE)))
							.addGap(16)))
					.addGap(26))
				.addGroup(gl_orders.createSequentialGroup()
					.addGap(61)
					.addComponent(sortByLabel_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(ordersSortByComboBox, 0, 144, Short.MAX_VALUE)
					.addGap(6)
					.addComponent(orderAscendingButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(orderDescendingButton)
					.addGap(46)
					.addComponent(orderSortByButton, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
					.addGap(73))
				.addGroup(gl_orders.createSequentialGroup()
					.addGap(173)
					.addComponent(ordersTableLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
					.addComponent(orderProductsTableLabel)
					.addGap(94))
				.addGroup(gl_orders.createSequentialGroup()
					.addGap(292)
					.addComponent(orderReturnHomeButton, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
					.addGap(259))
		);
		gl_orders.setVerticalGroup(
			gl_orders.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_orders.createSequentialGroup()
					.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_orders.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_orders.createParallelGroup(Alignment.BASELINE)
								.addComponent(orderNameLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(orderNameInput, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_orders.createParallelGroup(Alignment.BASELINE)
								.addComponent(orderCustomerLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(orderCustomerComboBox, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
							.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_orders.createSequentialGroup()
									.addGap(13)
									.addGroup(gl_orders.createParallelGroup(Alignment.BASELINE)
										.addGroup(gl_orders.createSequentialGroup()
											.addGap(1)
											.addComponent(orderProductComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(orderProductsLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_orders.createParallelGroup(Alignment.BASELINE)
										.addComponent(orderProductsQuantityLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
										.addComponent(orderProductsQuantityInput, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
								.addGroup(gl_orders.createSequentialGroup()
									.addGap(18)
									.addComponent(orderProductAddButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_orders.createSequentialGroup()
							.addGap(67)
							.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
								.addComponent(orderUpdateButton, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
								.addComponent(orderAddButton, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
								.addComponent(orderClearButton, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
								.addComponent(orderDeleteButton, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
							.addGap(6)))
					.addGap(0)
					.addGroup(gl_orders.createParallelGroup(Alignment.BASELINE)
						.addComponent(salesmanInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(salesmanLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_orders.createSequentialGroup()
							.addGap(4)
							.addComponent(sortByLabel_2))
						.addGroup(gl_orders.createSequentialGroup()
							.addComponent(ordersSortByComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(2))
						.addGroup(gl_orders.createParallelGroup(Alignment.BASELINE)
							.addComponent(orderAscendingButton)
							.addComponent(orderDescendingButton)
							.addComponent(orderSortByButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(0)
					.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
						.addComponent(ordersTableLabel)
						.addComponent(orderProductsTableLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
						.addComponent(orderScrollPane, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
						.addComponent(orderProductsScrollPane, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(orderReturnHomeButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(13))
		);
		
		orderProductsTable = new JTable();
		orderProductsScrollPane.setViewportView(orderProductsTable);
		
		ordersTable = new JTable();
		orderScrollPane.setViewportView(ordersTable);
		orders.setLayout(gl_orders);
		
		DefaultTableModel ordersModel = new DefaultTableModel();
		String[] orderColumnHeaders = {"Order Name", "Customer", "Products Ordered", "Order Total Price", "Salesman",};
		String[] orderRow = new String[5];
		ordersModel.setColumnIdentifiers(orderColumnHeaders);
		ordersTable.setModel(ordersModel);
		
		DefaultTableModel orderProductsModel = new DefaultTableModel();
		String[] orderProductColumnHeaders = {"Product ID", "Product", "Unit Price", "Quantity", "Product Total Price"};
		String[] orderProductRow = new String[5];
		orderProductsModel.setColumnIdentifiers(orderProductColumnHeaders);
		orderProductsTable.setModel(orderProductsModel);
		
		DefaultCellEditor customerEditor = (DefaultCellEditor) customersTable.getDefaultEditor(Object.class);
		customerEditor.setClickCountToStart(50);
		DefaultCellEditor productEditor = (DefaultCellEditor) productsTable.getDefaultEditor(Object.class);
		productEditor.setClickCountToStart(50);
		
		
		// ################################################################################################################################################## 
		// ######################################################## BUTTON ACTION LISTENERS ################################################################# 
		// ################################################################################################################################################## 
		
		/**
		 * ActionListeners for navigating the different panels through the home page buttons and return home buttons.
		 * 
		 * These ActionListeners alter the visibility of the JPanels depending on which button is selected.
		 */
		customersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.setVisible(false);
				customers.setVisible(true);
			}
		});
		
		productsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.setVisible(false);
				products.setVisible(true);
			}
		});
		
		ordersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.setVisible(false);
				orders.setVisible(true);
			}
		});
		
		customerReturnHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customers.setVisible(false);
				home.setVisible(true);
			}
		});
		
		productReturnHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				products.setVisible(false);
				home.setVisible(true);
			}
		});
		
		orderReturnHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orders.setVisible(false);
				home.setVisible(true);
			}
		});
		
		/**
		 * ActionListeners for displaying data of selected row
		 * 
		 * These ActionListeners retrieve the int value of the selected row of the TableModel and
		 * place the specific values of that row into their corresponding input components.
		 */
		customersTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = customersTable.getSelectedRow();
				firstNameInput.setText(customersModel.getValueAt(row, 0).toString());
				lastNameInput.setText(customersModel.getValueAt(row, 1).toString());
				phoneNumberInput.setText(customersModel.getValueAt(row, 2).toString());
				emailInput.setText(customersModel.getValueAt(row, 3).toString());
			}
		});
		
		productsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = productsTable.getSelectedRow();
				productIDInput.setText(productsModel.getValueAt(row, 0).toString());
				productInput.setText(productsModel.getValueAt(row, 1).toString());
				unitPriceInput.setText(productsModel.getValueAt(row, 2).toString());
			}
		});
		
		ordersTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				orderProductsModel.setRowCount(0);
				int row = ordersTable.getSelectedRow();
				int orderIndex = 0;
				
				String id = ordersModel.getValueAt(row, 0).toString();
				int counter = 0;
				for(Order order : orderList) {
					if(order.getOrderName().equals(id)) {
						
						for(int i = 0; i < order.getProducts().size(); i++) {
							Product product = order.getProducts().get(i);
							orderProductRow[0] = product.getProductID();
							orderProductRow[1] = product.getProductName();
							orderProductRow[2] = product.getUnitPrice() + "";
							orderProductRow[3] = product.getQuantity() + "";
							orderProductRow[4] = "$" + product.getProductTotalPrice();
							
							orderProductsModel.addRow(orderProductRow);
						}
					}
					counter++;
				}
				
				orderNameInput.setText(ordersModel.getValueAt(row, 0).toString());
				orderCustomerComboBox.setSelectedIndex(counter);;;
				salesmanInput.setText(ordersModel.getValueAt(row, 4).toString());
				
			}
		});
		
		
		/**
		 * ActionListeners for ADD buttons
		 * 
		 * These ActionListeners retrieve the input for all of the input components on the JPanel,
		 * and if all criteria is filled out, a new row is created and displayed in the JTable with all
		 * of the provided values, otherwise a JOptionPane message appears, asking the user to complete the fields.
		 */
		customerAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = firstNameInput.getText().trim();
				String lastName = lastNameInput.getText().trim();
				String phoneNumber = phoneNumberInput.getText().trim();
				String email = emailInput.getText().trim();
				boolean numerical = true;
			
					for(int i = 0; i<phoneNumber.length(); i++) {
						if(!(Character.isDigit(phoneNumber.charAt(i)))) {
							numerical = false;
							break;
						}
					}
			
					
	
				
				if(firstName.equals("") || lastName.equals("") || phoneNumber.equals("") || email.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Complete All Fields");
					
				}else if(!numerical) {
					JOptionPane.showMessageDialog(null, "Please Enter All Digit Phone Number");
				}else {
					customerRow[0] = firstName;
					customerRow[1] = lastName;
					customerRow[2] = phoneNumber;
					customerRow[3] = email;
					
					customersModel.addRow(customerRow);
					
					JOptionPane.showMessageDialog(null, "Data Successfully Added");
					
					Customer customer = new Customer(firstName, lastName, phoneNumber, email);
					customerList.add(customer);
					
					orderCustomerComboBox.addItem(customer);
					
					clear();
				}
				
			}
		});
		
		productAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String productID = productIDInput.getText().trim();
				String productName = productInput.getText().trim();
				String unitPrice = unitPriceInput.getText().trim();
				boolean numericalInput = true;
				
				try {
					Double.parseDouble(unitPrice);
				} catch (NumberFormatException exception) {
					numericalInput = false;
				}
				
				if(productID.equals("") || productName.equals("") || unitPrice.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Complete All Fields");
					
				}else if(!numericalInput) {
					JOptionPane.showMessageDialog(null, "Please Enter All Digit Unit Price");
				}else {
					productRow[0] = productID;
					productRow[1] = productName;
					productRow[2] = unitPrice;
					
					productsModel.addRow(productRow);
					
					JOptionPane.showMessageDialog(null, "Data Successfully Added");
					
					Product product = new Product(productID, productName, Double.parseDouble(unitPrice));
					productList.add(product);
					
					orderProductComboBox.addItem(product);
					
					clear();
				}
				
			}
		});
		
		orderAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int orderComplete = 1;
				ArrayList<Product> orderProducts = new ArrayList<Product>();
				for(Product product : temp) {
					orderProducts.add(product);
				}
				String orderName = orderNameInput.getText().trim();
				Customer customer = ((Customer)orderCustomerComboBox.getSelectedItem());
				String customerString = customer.getFirstName() + " " + customer.getLastName();
				String numProducts = orderProducts.size() + " Products";
				double orderTotalPrice = Double.parseDouble(calculateTotalPrice());
				String salesman = salesmanInput.getText().trim();
					
				if(orderName.equals("") || orderCustomerComboBox.getSelectedIndex() == 0 || orderProductsTable.getRowCount() == 0 || salesman.equals("")) {
						JOptionPane.showMessageDialog(null, "Please Complete All Fields");
						
					}else {	
						
						orderComplete = JOptionPane.showConfirmDialog(null, "Have you selected all of the products you want to order?", "WARNING", orderComplete);
						if(orderComplete == JOptionPane.YES_OPTION) {	
					
							orderRow[0] = orderName;
							orderRow[1] = customerString;
							orderRow[2] = numProducts;
							orderRow[3] = "$" + orderTotalPrice;
							orderRow[4] = salesman;
							
							ordersModel.addRow(orderRow);
							
							JOptionPane.showMessageDialog(null, "Data Successfully Added");
							
							Order order = new Order(orderName, customer, orderProducts, orderTotalPrice, salesman);
							orderList.add(order);
							
							clear();
							temp.clear();
							orderProductsModel.setRowCount(0);
							orderCustomerComboBox.setSelectedIndex(-1);
							orderProductComboBox.setSelectedIndex(-1);
					}
				} 
				
			}
		});
		
		
		orderProductAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product product = ((Product)orderProductComboBox.getSelectedItem());
   				String quantity = orderProductsQuantityInput.getText().trim();
   				
				boolean numericalInput = true;
				
				try {
					Integer.parseInt(quantity);
				} catch (NumberFormatException exception) {
					numericalInput = false;
				}
				
				if(quantity.equals("") || orderProductComboBox.getSelectedIndex() < 0) {
					JOptionPane.showMessageDialog(null, "Please Complete All Fields");
					
				}else if(!numericalInput) {
					JOptionPane.showMessageDialog(null, "Please Enter Numerical Value For Quantity");
				}else {
					product.setQuantity(Integer.parseInt(quantity));
					orderProductRow[0] = product.getProductID();
					orderProductRow[1] = product.getProductName();
					orderProductRow[2] = product.getUnitPrice() + "";
					orderProductRow[3] = quantity;
					orderProductRow[4] = "$" + product.getProductTotalPrice();
					
					orderProductsModel.addRow(orderProductRow);
				
					temp.add(product);
					
					JOptionPane.showMessageDialog(null, "Data Successfully Added");
					
					
				}
				
			}
		});
		
		
		/**
		 * ActionListeners for UPDATE buttons
		 * 
		 * These Action Listeners retrieve all of the data from the panel, create a new POJO, 
		 * and set the value of the currently selected row to the values of the retrieved input. 
		 */
		customerUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = firstNameInput.getText().trim();
				String lastName = lastNameInput.getText().trim();
				String phoneNumber = phoneNumberInput.getText().trim();
				String email = emailInput.getText().trim();
				int row = customersTable.getSelectedRow();
				
				Customer updatedCustomer = new Customer(firstName, lastName, phoneNumber, email);
				customerList.set(row, updatedCustomer);
				
				if(row>=0) {
					customersModel.setValueAt(firstName, row, 0);
					customersModel.setValueAt(lastName, row, 1);
					customersModel.setValueAt(phoneNumber, row, 2);
					customersModel.setValueAt(email, row, 3);
				
				JOptionPane.showMessageDialog(null, "Data Successfully Updated");
				
				clear();
				}else {
					JOptionPane.showMessageDialog(null, "Please Select A Row");
				}
			}
		});
		
		productUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String productID = productIDInput.getText().trim();
				String productName = productInput.getText().trim();
				String unitPrice = unitPriceInput.getText().trim();
				int row = productsTable.getSelectedRow();
				
				Product updatedProduct = new Product(productID, productName, Double.parseDouble(unitPrice));
				productList.set(row, updatedProduct);
				
				if(row>=0) {
					productsModel.setValueAt(productID, row, 0);
					productsModel.setValueAt(productName, row, 1);
					productsModel.setValueAt(unitPrice, row, 2);
					
				
				JOptionPane.showMessageDialog(null, "Data Successfully Updated");
				
				clear();
				}else {
					JOptionPane.showMessageDialog(null, "Please Select A Row");
				}
			}
		});
		
		orderUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = ordersTable.getSelectedRow();
				String id = ordersModel.getValueAt(row, 0).toString();
				int productsSize = 0;
				ArrayList<Product> temp = new ArrayList<Product>();
				
				for(Order order : orderList) {
					if(order.getOrderName().equals(id)) {
						temp = order.getProducts();
						productsSize =	temp.size();
					}
				}
				
				String orderName = orderNameInput.getText().trim();
				Customer customer = ((Customer)orderCustomerComboBox.getSelectedItem());
				String customerString = customer.getFirstName() + " " + customer.getLastName();
				String numProducts =  productsSize + " Products";
				double orderTotalPrice = Double.parseDouble(calculateTotalPrice());
				String salesman = salesmanInput.getText().trim();
				
				
				Order updatedOrder = new Order(orderName, customer, temp, orderTotalPrice, salesman);
				orderList.set(row, updatedOrder);
				
				if(row>=0) {
					ordersModel.setValueAt(orderName, row, 0);
					ordersModel.setValueAt(customerString, row, 1);
					ordersModel.setValueAt(numProducts, row, 2);
					ordersModel.setValueAt("$" + orderTotalPrice, row, 3);
					ordersModel.setValueAt(salesman, row, 4);
					
				
					JOptionPane.showMessageDialog(null, "Data Successfully Updated");
				
					clear();
					orderCustomerComboBox.setSelectedIndex(0);
				}else {
					JOptionPane.showMessageDialog(null, "Please Select A Row");
				}
			}
		});
	
		/**
		 * ActionListeners for CLEAR buttons
		 * 
		 * These ActionListeners call upon the clear() method, which sets any text fields to a blank string.
		 */
		customerClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		
		productClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		
		orderClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderCustomerComboBox.setSelectedIndex(0);
				clear();
			}
		});
		
		/**
		 * ActionListeners for DELETE buttons
		 * 
		 * These ActionListeners store the selected row as an integer, and then call upon the removeRow method
		 * to the DefaultTableModel, using the row integer as a parameter.
		 */
		customerDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = customersTable.getSelectedRow();
				
				if(row>=0) {
					customersModel.removeRow(row);
					JOptionPane.showMessageDialog(null, "Data Successfully Deleted");
					clear();
				}else {
					JOptionPane.showMessageDialog(null, "Please Select A Row");
				}
			}
		});
		
		productDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = productsTable.getSelectedRow();
				
				if(row>=0) {
					productsModel.removeRow(row);
					JOptionPane.showMessageDialog(null, "Data Successfully Deleted");
					clear();
				}else {
					JOptionPane.showMessageDialog(null, "Please Select A Row");
				}
			}
		});
		
		orderDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = ordersTable.getSelectedRow();
				
				if(row>=0) {
					ordersModel.removeRow(row);
					JOptionPane.showMessageDialog(null, "Data Successfully Deleted");
					orderCustomerComboBox.setSelectedIndex(0);
					clear();
				}else {
					JOptionPane.showMessageDialog(null, "Please Select A Row");
				}
			}
		});
		
		
		/**
		 * ActionListeners for Ascending and Descending Buttons
		 * 
		 * These ActionListeners set the opposite radio button to false, if it were to be selected.
		 * The radio button selected determines which order the list is sorted in.
		 */
		customerAscendingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerDescendingButton.setSelected(false);
			}
		});
		
		productAscendingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productDescendingButton.setSelected(false);
			}
		});
		
		orderAscendingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderDescendingButton.setSelected(false);
			}
		});
		
		customerDescendingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerAscendingButton.setSelected(false);
			}
		});
		
		productDescendingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productAscendingButton.setSelected(false);
			}
		});
		
		orderDescendingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderAscendingButton.setSelected(false);
			}
		});
		
		
		/**
		 * ActionListeners for SORT button
		 * 
		 * These ActionListeners check for input for the ComboBox and ascending/descending radio buttons and then call upon the
		 * selection sort method with the given input. If the descending radio button was selected, the returned list is reversed, using the reverse method.
		 * The table is then input with the list elements in the proper order.
		 */
		customerSortByButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				if(customersSortByComboBox.getSelectedIndex()>0 && (customerAscendingButton.isSelected() || customerDescendingButton.isSelected())) {
	
						String sortBy = customersSortByComboBox.getSelectedItem() + "";
						boolean numerical = false;
						
						if(sortBy.equals("Phone Number")) {
							numerical = true;
						}
						
						customerSelectionSort(customerList, sortBy, numerical);
						
						if(customerDescendingButton.isSelected()) {
							reverse(customerList);
						}
						
						int rowCount = customersModel.getRowCount();
						
						for(int i = 0; i < rowCount; i++) {
							Customer customer = customerList.get(i);
							customersModel.setValueAt(customer.getFirstName(), i, 0);
							customersModel.setValueAt(customer.getLastName(), i, 1);
							customersModel.setValueAt(customer.getPhoneNum(), i, 2);
							customersModel.setValueAt(customer.getEmail(), i, 3);
						}
							
				
				} else {
					JOptionPane.showMessageDialog(null, "Please Select A Sorting Category and Order");
				}
			}
		});
		
		productSortByButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				if(productSortByComboBox.getSelectedIndex()>0 && (productAscendingButton.isSelected() || productDescendingButton.isSelected())) {
	
						String sortBy = productSortByComboBox.getSelectedItem() + "";
						boolean numerical = false;
						
						if(sortBy.equals("Unit Price")) {
							numerical = true;
						}
						
						productSelectionSort(productList, sortBy, numerical);
						
						if(productDescendingButton.isSelected()) {
							reverse(productList);
						}
						
						int rowCount = productsModel.getRowCount();
						
						for(int i = 0; i < rowCount; i++) {
							Product product = productList.get(i);
							productsModel.setValueAt(product.getProductID(), i, 0);
							productsModel.setValueAt(product.getProductName(), i, 1);
							productsModel.setValueAt(product.getUnitPrice(), i, 2);
							
						}
							
				
				} else {
					JOptionPane.showMessageDialog(null, "Please Select A Sorting Category and Order");
				}
			}
		});
		
		orderSortByButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				if(ordersSortByComboBox.getSelectedIndex()>0 && (orderAscendingButton.isSelected() || orderDescendingButton.isSelected())) {
	
						String sortBy = ordersSortByComboBox.getSelectedItem() + "";
						boolean numerical = false;
						
						if(sortBy.equals("Number of Products") || sortBy.equals("Order Total Price")) {
							numerical = true;
						}
						
						orderSelectionSort(orderList, sortBy, numerical);
						
						if(orderDescendingButton.isSelected()) {
							reverse(orderList);
						}
						
						int rowCount = ordersModel.getRowCount();
						
						for(int i = 0; i < rowCount; i++) {
							Order order = orderList.get(i);
							ordersModel.setValueAt(order.getOrderName(), i, 0);
							ordersModel.setValueAt(order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName(), i, 1);
							ordersModel.setValueAt(order.getProducts().size() + " Products", i, 2);
							ordersModel.setValueAt("$" + order.getOrderTotalPrice(), i, 3);
							ordersModel.setValueAt(order.getSalesman(), i, 4);
							
						}
							
				
				} else {
					JOptionPane.showMessageDialog(null, "Please Select A Sorting Category and Order");
				}
			}
		});
		
	}
	
		// ################################################################################################################################################## 
		// ######################################################## ADDITIONAL METHODS ###################################################################### 
		// ################################################################################################################################################## 
			
		 /**
		  * This method takes in an ArrayList<Customer>, String representing the sorting category, and a boolean 
		  * declaring whether the sort is numerical or not, and sorts the list in ascending order.
		  * @param list - ArrayList<Customer> that contains the elements to be sorted
		  * @param sortBy - String representing the sorting category
		  * @param numerical - Boolean representing whether the sort is numerical or not
		  */
		 public static void customerSelectionSort(ArrayList<Customer> list, String sortBy, boolean numerical) {
			
			 	String value = "";
			 	String minValue = "";
	
				int n = list.size();
				for(int i=0; i<n-1; i++) {
					int min = i;
					for(int j=i+1; j<n; j++) {
						
							switch(sortBy) {
							case "First Name": 
								value = list.get(j).getFirstName();
								minValue = list.get(min).getFirstName();
								break;
							case "Last Name":
								value = list.get(j).getLastName();
								minValue = list.get(min).getLastName();
								break;
							case "Email":
								value = list.get(j).getEmail();
								minValue = list.get(min).getEmail();
								break;
							case "Phone Number":
								value = list.get(j).getPhoneNum();
								minValue = list.get(min).getPhoneNum();
							}
						
						if(numerical) {
							if(Integer.parseInt(value) < (Integer.parseInt(minValue))) {
								min = j;
							}
							
						}else {
						
							if(value.compareToIgnoreCase(minValue) < 0) {
								min = j;
							}
						}
					}
					
					if(min != i) {
						Customer temp = list.get(min);
						list.set(min, list.get(i));
						list.set(i, temp);
						
						
					}
					
				}
				
			}
		 
		 /**
		  * This method takes in an ArrayList<Product>, String representing the sorting category, and a boolean 
		  * declaring whether the sort is numerical or not, and sorts the list in ascending order.
		  * @param list - ArrayList<Product> that contains the elements to be sorted
		  * @param sortBy - String representing the sorting category
		  * @param numerical - Boolean representing whether the sort is numerical or not
		  */
		 public static void productSelectionSort(ArrayList<Product> list, String sortBy, boolean numerical) {
			
			 	String value = "";
			 	String minValue = "";
	
				int n = list.size();
				for(int i=0; i<n-1; i++) {
					int min = i;
					for(int j=i+1; j<n; j++) {
						
							switch(sortBy) {
							case "Product ID": 
								value = list.get(j).getProductID();
								minValue = list.get(min).getProductID();
								break;
							case "Product Name":
								value = list.get(j).getProductName();
								minValue = list.get(min).getProductName();
								break;
							case "Unit Price":
								value = list.get(j).getUnitPrice() + "";
								minValue = list.get(min).getUnitPrice() + "";
								break;
							}
						
						if(numerical) {
							if(Double.parseDouble(value) < (Double.parseDouble(minValue))) {
								min = j;
							}
							
						}else {
						
							if(value.compareToIgnoreCase(minValue) < 0) {
								min = j;
							}
						}
					}
					
					if(min != i) {
						Product temp = list.get(min);
						list.set(min, list.get(i));
						list.set(i, temp);
						
						
					}
					
				}
				
			}
		 
		 /**
		  * This method takes in an ArrayList<Order>, String representing the sorting category, and a boolean 
		  * declaring whether the sort is numerical or not, and sorts the list in ascending order.
		  * @param list - ArrayList<Order> that contains the elements to be sorted
		  * @param sortBy - String representing the sorting category
		  * @param numerical - Boolean representing whether the sort is numerical or not
		  */
		 public static void orderSelectionSort(ArrayList<Order> list, String sortBy, boolean numerical) {
			
			 	String value = "";
			 	String minValue = "";
	
				int n = list.size();
				for(int i=0; i<n-1; i++) {
					int min = i;
					for(int j=i+1; j<n; j++) {
						
							switch(sortBy) {
							case "Order Name": 
								value = list.get(j).getOrderName();
								minValue = list.get(min).getOrderName();
								break;
							case "Customer First Name":
								value = list.get(j).getCustomer().getFirstName();
								minValue = list.get(min).getCustomer().getFirstName();
								break;
							case "Customer Last Name":
								value = list.get(j).getCustomer().getLastName();
								minValue = list.get(min).getCustomer().getLastName();
								break;
							case "Number of Products":
								value = list.get(j).getProducts().size() + "";
								minValue = list.get(min).getProducts().size() + "";
								break;
							case "Salesman":
								value = list.get(j).getSalesman();
								minValue = list.get(min).getSalesman();
								break;
							case "Order Total Price":
								value = list.get(j).getOrderTotalPrice() + "";
								minValue = list.get(min).getOrderTotalPrice() + "";
								break;
							}
						
						if(numerical) {
							if(Double.parseDouble(value) < (Double.parseDouble(minValue))) {
								min = j;
							}
							
						}else {
						
							if(value.compareToIgnoreCase(minValue) < 0) {
								min = j;
							}
						}
					}
					
					if(min != i) {
						Order temp = list.get(min);
						list.set(min, list.get(i));
						list.set(i, temp);
						
						
					}
					
				}
				
			}
		 
		  /**
		   * This method clears all text fields when called upon
		   */
		  public void clear() {
			 firstNameInput.setText("");
			 lastNameInput.setText("");
			 phoneNumberInput.setText("");
			 emailInput.setText("");
			 productIDInput.setText("");
			 productInput.setText("");
			 unitPriceInput.setText("");
			 orderNameInput.setText("");
			 salesmanInput.setText("");
			 orderProductsQuantityInput.setText("");
		 }
		  
		 /**
		  * This method takes in an ArrayList of objects and reverses the order by adding each element 
		  * to a stack and then popping each stack element back into the emptied list
		  * @param list - ArrayList parameter representing the collection of objects to be reversed
		  */
		 public void reverse(ArrayList list) {
			 Stack<Object> stack = new Stack<Object>();
			 while(!list.isEmpty()) {
				 stack.add(list.get(0));
				 list.remove(0);
			 }
			 while(!stack.isEmpty()) {
				 list.add(stack.peek());
				 stack.pop();
			 }
		 }
		 
		 /**
		  * This method iterates through the total prices for each product in the order and calculates
		  * the total order price
		  * @return - returns String representing total price of the order
		  */
		 public String calculateTotalPrice() {
			 double total = 0;
			 
				 for(int i = 0; i < orderProductsTable.getRowCount(); i++) {
					 String value = (String) orderProductsTable.getValueAt(i, 4);
					 String substring = value.substring(1);
					 total += Double.parseDouble(substring);
				 }
				 
			 return df.format(total);
		 }
}
