import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class RegisterForm extends JDialog implements ActionListener, WindowListener {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtName;
	private JButton btnRegister;
	private JButton btnCancel;
	private JComboBox cbbTypeOfUser;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm(null, false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterForm(JFrame owner, boolean modal) {
		super(owner, modal);
		
		setTitle("Registration Form");
		setBackground(new Color(204, 153, 102));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Type of User:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		cbbTypeOfUser = new JComboBox<String>();
		cbbTypeOfUser.setModel(new DefaultComboBoxModel(new String[] {"Student", "Professor", "Admin"}));
		cbbTypeOfUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_cbbTypeOfUser = new GridBagConstraints();
		gbc_cbbTypeOfUser.insets = new Insets(0, 0, 5, 0);
		gbc_cbbTypeOfUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbTypeOfUser.gridx = 1;
		gbc_cbbTypeOfUser.gridy = 1;
		contentPane.add(cbbTypeOfUser, gbc_cbbTypeOfUser);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 2;
		contentPane.add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.gridx = 1;
		gbc_txtUsername.gridy = 3;
		contentPane.add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(0, 0, 5, 0);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 1;
		gbc_txtPassword.gridy = 4;
		contentPane.add(txtPassword, gbc_txtPassword);
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegister.gridx = 0;
		gbc_btnRegister.gridy = 6;
		contentPane.add(btnRegister, gbc_btnRegister);
		
		btnRegister.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 6;
		contentPane.add(btnCancel, gbc_btnCancel);
		btnCancel.addActionListener(this);
		setSize(new Dimension(400, 225));
		
		//action listener
		this.addWindowListener(this);
	}
	
	public String addUnderscore(String input) {
		String[] arrName = input.split("\\s+");
		String name = arrName[0];
		for(int i = 1; i < arrName.length; i++)
				name += "_" + arrName[i];
		return name;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnRegister) { //if user selects register
			String name = addUnderscore(txtName.getText());
			String username = txtUsername.getText();
			char[] chPassword = txtPassword.getPassword();
			String password = "";
			for (char ch : chPassword) password += ch;
			
			if(username.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(this, "You need to input username and password to create an account", 
										      "Error", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
			    if (cbbTypeOfUser.getSelectedIndex() == 2) {
			    	Administrator a = new Administrator(name, username, password);
			    	
			    	//Prevent registration of duplicates
			    	if (!LoginForm.arrUsers.contains(a)) {
			    		LoginForm.arrUsers.add(a);
			    		System.out.println("Inserted new account to the system");
			    	}
			    	else JOptionPane.showMessageDialog(this, "User already exists in database, please log in instead.");
			    	
			    } else if (cbbTypeOfUser.getSelectedIndex() == 1) {
			    	Professor p = new Professor(name, username, password);
			    	
			    	//Prevent registration of duplicates
			    	if (!LoginForm.arrUsers.contains(p)) {
			    		LoginForm.arrUsers.add(p);
			    		System.out.println("Inserted new account to the system");
			    	}
			    	else JOptionPane.showMessageDialog(this, "User already exists in database, please log in instead.");
			    	
			    } else if (cbbTypeOfUser.getSelectedIndex() == 0) {
			    	
			    	Student s = new Student(name, username, password);
			    	
			    	//Prevent registration of duplicates
			    	if (!LoginForm.arrUsers.contains(s)) {
			    		LoginForm.arrUsers.add(s);
			    		System.out.println("Inserted new account to the system");
			    	}
			    	else JOptionPane.showMessageDialog(this, "User already exists in database, please log in instead.");
			    }
			    setModal(true);
			    getOwner().setEnabled(true);
			    this.dispose();
			}
		} else if (e.getSource() == btnCancel) { //if user selects cancel
			this.dispose();
			getOwner().setEnabled(true);
			setModal(true);
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Window closed");
		this.getOwner().setEnabled(true);
		this.dispose();
		setModal(true);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
