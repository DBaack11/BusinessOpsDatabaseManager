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
	private JTextField orderNameInput;
	private JTextField salesmanInput;
	private JTable ordersTable;
	private JTextField orderProductsQuantityInput;
	private JTable orderProductsTable;

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
						.addComponent(ordersButton, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
						.addComponent(customersButton, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
						.addComponent(productsButton, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(211, Short.MAX_VALUE))
		);
		gl_home.setVerticalGroup(
			gl_home.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_home.createSequentialGroup()
					.addContainerGap(30, Short.MAX_VALUE)
					.addComponent(ordersButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(customersButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(productsButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
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
							.addComponent(customersSortByComboBox, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(customerAscendingButton)
							.addGap(2)
							.addComponent(customerDescendingButton, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(customerSortByButton, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addGap(103))
						.addGroup(gl_customers.createSequentialGroup()
							.addGap(233)
							.addComponent(customerReturnHomeButton)
							.addPreferredGap(ComponentPlacement.RELATED, 219, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customers.createSequentialGroup()
							.addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(emailInput, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_customers.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, gl_customers.createSequentialGroup()
								.addGroup(gl_customers.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_customers.createSequentialGroup()
										.addComponent(lastNameLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lastNameInput, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_customers.createSequentialGroup()
										.addComponent(firstNameLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(firstNameInput, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_customers.createSequentialGroup()
										.addComponent(phoneNumberLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(phoneNumberInput, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)))
								.addGap(45)
								.addGroup(gl_customers.createParallelGroup(Alignment.LEADING)
									.addComponent(customerAddButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addComponent(customerDeleteButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_customers.createParallelGroup(Alignment.LEADING)
									.addComponent(customerClearButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addComponent(customerUpdateButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 601, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_customers.setVerticalGroup(
			gl_customers.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_customers.createSequentialGroup()
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
									.addComponent(customerUpdateButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(customerClearButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_customers.createSequentialGroup()
									.addComponent(customerAddButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(customerDeleteButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(gl_customers.createParallelGroup(Alignment.BASELINE)
						.addComponent(customersSortByComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(sortByLabel)
						.addComponent(customerAscendingButton)
						.addComponent(customerDescendingButton)
						.addComponent(customerSortByButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(customerReturnHomeButton)
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
							.addComponent(productSortByComboBox, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(productAscendingButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(productDescendingButton, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(productSortByButton, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_products.createSequentialGroup()
							.addGap(233)
							.addComponent(productReturnHomeButton, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
						.addComponent(productScrollPane, GroupLayout.PREFERRED_SIZE, 601, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_products.createSequentialGroup()
							.addGroup(gl_products.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_products.createSequentialGroup()
									.addComponent(unitPriceLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(unitPriceInput, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_products.createSequentialGroup()
									.addGroup(gl_products.createParallelGroup(Alignment.LEADING)
										.addComponent(productIDLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addComponent(productLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
									.addGap(6)
									.addGroup(gl_products.createParallelGroup(Alignment.LEADING)
										.addComponent(productIDInput, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
										.addComponent(productInput, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))))
							.addGap(46)
							.addGroup(gl_products.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_products.createSequentialGroup()
									.addComponent(productAddButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(productUpdateButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_products.createSequentialGroup()
									.addComponent(productDeleteButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(productClearButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(48, Short.MAX_VALUE))
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
									.addComponent(productIDInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(productInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_products.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_products.createSequentialGroup()
									.addGap(9)
									.addComponent(unitPriceLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_products.createSequentialGroup()
									.addGap(4)
									.addComponent(unitPriceInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_products.createSequentialGroup()
							.addGap(53)
							.addGroup(gl_products.createParallelGroup(Alignment.LEADING)
								.addComponent(productUpdateButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_products.createSequentialGroup()
									.addComponent(productAddButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addGroup(gl_products.createParallelGroup(Alignment.LEADING)
										.addComponent(productDeleteButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(productClearButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))))))
					.addGap(74)
					.addGroup(gl_products.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_products.createSequentialGroup()
							.addGap(5)
							.addComponent(sortByLabel_1))
						.addGroup(gl_products.createSequentialGroup()
							.addGap(1)
							.addComponent(productSortByComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_products.createSequentialGroup()
							.addGap(1)
							.addComponent(productAscendingButton))
						.addGroup(gl_products.createSequentialGroup()
							.addGap(1)
							.addComponent(productDescendingButton))
						.addComponent(productSortByButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(productScrollPane, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(productReturnHomeButton)
					.addContainerGap(17, Short.MAX_VALUE))
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
		
		JRadioButton orderAscendingButton = new JRadioButton("Ascending");
		
		JRadioButton orderDescendingButton = new JRadioButton("Descending");
		
		JButton orderSortByButton = new JButton("SORT");
		
		JScrollPane orderScrollPane = new JScrollPane();
		
		JComboBox orderCustomerComboBox = new JComboBox();
		
		JComboBox comboBox = new JComboBox();
		
		JLabel orderProductsQuantityLabel = new JLabel("Quantity:");
		orderProductsQuantityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		orderProductsQuantityLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		orderProductsQuantityInput = new JTextField();
		orderProductsQuantityInput.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		orderProductsQuantityInput.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD PRODUCT");
		
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
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		GroupLayout gl_orders = new GroupLayout(orders);
		gl_orders.setHorizontalGroup(
			gl_orders.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_orders.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_orders.createSequentialGroup()
							.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_orders.createSequentialGroup()
									.addGap(229)
									.addComponent(orderReturnHomeButton, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_orders.createSequentialGroup()
									.addComponent(orderScrollPane, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(orderProductsScrollPane, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
							.addGap(26))
						.addGroup(gl_orders.createSequentialGroup()
							.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_orders.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_orders.createSequentialGroup()
										.addGap(13)
										.addGroup(gl_orders.createParallelGroup(Alignment.TRAILING)
											.addComponent(orderCustomerLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
											.addComponent(salesmanLabel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
											.addComponent(orderProductsLabel))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
											.addComponent(salesmanInput)
											.addComponent(orderCustomerComboBox, 0, 193, Short.MAX_VALUE)
											.addGroup(gl_orders.createSequentialGroup()
												.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))))
									.addGroup(gl_orders.createSequentialGroup()
										.addComponent(orderNameLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(orderNameInput)))
								.addGroup(gl_orders.createSequentialGroup()
									.addGap(98)
									.addComponent(orderProductsQuantityLabel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(orderProductsQuantityInput, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
							.addGap(27)
							.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_orders.createSequentialGroup()
									.addComponent(orderAddButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(orderUpdateButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_orders.createSequentialGroup()
									.addComponent(orderDeleteButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(orderClearButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))))))
				.addGroup(gl_orders.createSequentialGroup()
					.addGap(61)
					.addComponent(sortByLabel_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(ordersSortByComboBox, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(orderAscendingButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(orderDescendingButton)
					.addGap(46)
					.addComponent(orderSortByButton, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_orders.createSequentialGroup()
					.addGap(173)
					.addComponent(ordersTableLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
					.addComponent(orderProductsTableLabel)
					.addGap(94))
				.addComponent(separator, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
		);
		gl_orders.setVerticalGroup(
			gl_orders.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_orders.createSequentialGroup()
					.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_orders.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_orders.createParallelGroup(Alignment.BASELINE)
								.addComponent(orderNameLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(orderNameInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_orders.createParallelGroup(Alignment.BASELINE)
								.addComponent(orderCustomerLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(orderCustomerComboBox, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_orders.createSequentialGroup()
									.addGap(13)
									.addGroup(gl_orders.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(orderProductsLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_orders.createParallelGroup(Alignment.BASELINE)
										.addComponent(orderProductsQuantityLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
										.addComponent(orderProductsQuantityInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_orders.createSequentialGroup()
									.addGap(18)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
							.addGap(22)
							.addGroup(gl_orders.createParallelGroup(Alignment.BASELINE)
								.addComponent(salesmanLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(salesmanInput, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_orders.createSequentialGroup()
							.addGap(67)
							.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
								.addComponent(orderUpdateButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(orderAddButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
								.addComponent(orderClearButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(orderDeleteButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))))
					.addGap(12)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_orders.createSequentialGroup()
							.addGap(4)
							.addComponent(sortByLabel_2))
						.addComponent(ordersSortByComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_orders.createParallelGroup(Alignment.BASELINE)
							.addComponent(orderAscendingButton)
							.addComponent(orderDescendingButton)
							.addComponent(orderSortByButton)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
						.addComponent(ordersTableLabel)
						.addComponent(orderProductsTableLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_orders.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_orders.createSequentialGroup()
							.addComponent(orderScrollPane, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(orderReturnHomeButton))
						.addComponent(orderProductsScrollPane, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		
		orderProductsTable = new JTable();
		orderProductsScrollPane.setViewportView(orderProductsTable);
		
		ordersTable = new JTable();
		orderScrollPane.setViewportView(ordersTable);
		orders.setLayout(gl_orders);
		
		DefaultCellEditor customerEditor = (DefaultCellEditor) customersTable.getDefaultEditor(Object.class);
		customerEditor.setClickCountToStart(50);
		DefaultCellEditor productEditor = (DefaultCellEditor) productsTable.getDefaultEditor(Object.class);
		productEditor.setClickCountToStart(50);
		
		
		// ################################################################################################################################################## 
		// ######################################################## BUTTON ACTION LISTENERS ################################################################# 
		// ################################################################################################################################################## 
		
		/**
		 * ActionListeners for navigating the different panels through the home page buttons and return home buttons
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
		
		
		/**
		 * ActionListeners for ADD buttons
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
					
					clear();
				}
				
			}
		});
		
		
		/**
		 * ActionListeners for UPDATE buttons
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
	
		/**
		 * ActionListeners for CLEAR buttons
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
		
		/**
		 * ActionListeners for DELETE buttons
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
		
		
		/**
		 * ActionListeners for Ascending and Descending Buttons
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
		
		
		/**
		 * ActionListeners for SORT button
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
		
	}
	
		// ################################################################################################################################################## 
		// ######################################################## ADDITIONAL METHODS ###################################################################### 
		// ################################################################################################################################################## 
			
		 
		 public static void customerSelectionSort(ArrayList<Customer> list, String sortBy, boolean numerical) {
				//long startTime = System.currentTimeMillis();
			
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
				
				//long endTime = System.currentTimeMillis();
				//executionTime = endTime-startTime;
			}
		 
		 	
		 public static void productSelectionSort(ArrayList<Product> list, String sortBy, boolean numerical) {
				//long startTime = System.currentTimeMillis();
			
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
				
				//long endTime = System.currentTimeMillis();
				//executionTime = endTime-startTime;
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
}
