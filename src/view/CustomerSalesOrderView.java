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

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private ArrayList<Customer> customerList = new ArrayList<Customer>();

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
		frame.setBounds(100, 100, 700, 526);
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
						.addComponent(customersButton, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
						.addComponent(productsButton, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
						.addComponent(ordersButton, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(211, Short.MAX_VALUE))
		);
		gl_home.setVerticalGroup(
			gl_home.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_home.createSequentialGroup()
					.addGap(24)
					.addComponent(ordersButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addComponent(customersButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(productsButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
		);
		home.setLayout(gl_home);
		
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
		
		JScrollPane customerScrollPane = new JScrollPane();
		
		
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
							.addComponent(customerScrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 601, GroupLayout.PREFERRED_SIZE)))
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
					.addComponent(customerScrollPane, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(customerReturnHomeButton)
					.addContainerGap())
		);
		
		customersTable = new JTable();
		customersTable.setGridColor(Color.BLACK);
		customersTable.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		customerScrollPane.setViewportView(customersTable);
		customers.setLayout(gl_customers);
		
		DefaultTableModel customersModel = new DefaultTableModel();
		String[] columnHeaders = {"First Name", "Last Name", "Phone Number", "Email"};
		String[] row = new String[4];
		customersModel.setColumnIdentifiers(columnHeaders);
		customersTable.setModel(customersModel);
		
		DefaultCellEditor editor = (DefaultCellEditor) customersTable.getDefaultEditor(Object.class);
		editor.setClickCountToStart(50);
	
		
		
		// Button Action Listeners
		
		customersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.setVisible(false);
				customers.setVisible(true);
			}
		});
		
		customerReturnHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customers.setVisible(false);
				home.setVisible(true);
			}
		});
		
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
		
		customerAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = firstNameInput.getText().trim();
				String lastName = lastNameInput.getText().trim();
				String phoneNumber = phoneNumberInput.getText().trim();
				String email = emailInput.getText().trim();
				
				if(firstName.equals("") || lastName.equals("") || phoneNumber.equals("") || email.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Complete All Fields");
				}else {
					row[0] = firstName;
					row[1] = lastName;
					row[2] = phoneNumber;
					row[3] = email;
					
					customersModel.addRow(row);
					
					JOptionPane.showMessageDialog(null, "Data Successfully Added");
					
					Customer customer = new Customer(firstName, lastName, phoneNumber, email);
					customerList.add(customer);
					
					clear();
				}
				
			}
		});
		
		customerUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = firstNameInput.getText().trim();
				String lastName = lastNameInput.getText().trim();
				String phoneNumber = phoneNumberInput.getText().trim();
				String email = emailInput.getText().trim();
				int row = customersTable.getSelectedRow();
				
				if(row>0) {
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
	
		customerClearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		
		customerDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = customersTable.getSelectedRow();
				
				if(row>0) {
					customersModel.removeRow(row);
					JOptionPane.showMessageDialog(null, "Data Successfully Deleted");
				}else {
					JOptionPane.showMessageDialog(null, "Please Select A Row");
				}
			}
		});
		
		customerAscendingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerDescendingButton.setSelected(false);
			}
		});
		
		customerDescendingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerAscendingButton.setSelected(false);
			}
		});
		
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
							customersModel.setValueAt(customer.getlastName(), i, 1);
							customersModel.setValueAt(customer.getPhoneNum(), i, 2);
							customersModel.setValueAt(customer.getEmail(), i, 3);
						}
							
				
				} else {
					JOptionPane.showMessageDialog(null, "Please Select A Sorting Category and Order");
				}
			}
		});
		
		//
		
	}
	
		 public void clear() {
			firstNameInput.setText("");
			lastNameInput.setText("");
			phoneNumberInput.setText("");
			emailInput.setText("");
		}
		 
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
								value = list.get(j).getlastName();
								minValue = list.get(min).getlastName();
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
						
							if(value.compareTo(minValue) < 0) {
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
