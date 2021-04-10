import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class RegisterForm extends JDialog implements ActionListener{

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtTypeOfFaculty;
	private JTextField txtName;
	private JButton btnRegister;
	private JButton btnCancel;
	private JComboBox cbbTypeOfUser;

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
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Type of User:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		cbbTypeOfUser = new JComboBox();
		cbbTypeOfUser.setModel(new DefaultComboBoxModel(new String[] {"<Select User Type>", "Administrator", "Professor", "Student"}));
		cbbTypeOfUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_cbbTypeOfUser = new GridBagConstraints();
		gbc_cbbTypeOfUser.insets = new Insets(0, 0, 5, 0);
		gbc_cbbTypeOfUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbbTypeOfUser.gridx = 1;
		gbc_cbbTypeOfUser.gridy = 3;
		contentPane.add(cbbTypeOfUser, gbc_cbbTypeOfUser);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 4;
		contentPane.add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.gridx = 1;
		gbc_txtUsername.gridy = 5;
		contentPane.add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 6;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(0, 0, 5, 0);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 1;
		gbc_txtPassword.gridy = 6;
		contentPane.add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Type of Faculty (if student, leave blank): ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 7;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtTypeOfFaculty = new JTextField();
		txtTypeOfFaculty.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtTypeOfFaculty = new GridBagConstraints();
		gbc_txtTypeOfFaculty.insets = new Insets(0, 0, 5, 0);
		gbc_txtTypeOfFaculty.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTypeOfFaculty.gridx = 1;
		gbc_txtTypeOfFaculty.gridy = 7;
		contentPane.add(txtTypeOfFaculty, gbc_txtTypeOfFaculty);
		txtTypeOfFaculty.setColumns(10);
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegister.gridx = 0;
		gbc_btnRegister.gridy = 10;
		contentPane.add(btnRegister, gbc_btnRegister);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 10;
		contentPane.add(btnCancel, gbc_btnCancel);
		
		btnRegister.addActionListener(this);
		btnCancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnRegister) {
			if(txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "You need to input username and password to create an account", 
										      "Error", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				//LoginForm.arrUsername.add(txtUsername.getText());
			    //LoginForm.arrPassword.add(txtPassword.getText());
			    if (cbbTypeOfUser.getSelectedItem().equals("Administrator")) {
			    	LoginForm.arrUsers.add(new Administrator(txtName.getText(), txtUsername.getText(), txtPassword.getText(), txtTypeOfFaculty.getText()));
			    } else if (cbbTypeOfUser.getSelectedItem().equals("Professor")) {
			    	LoginForm.arrUsers.add(new Professor(txtName.getText(), txtUsername.getText(), txtPassword.getText(), txtTypeOfFaculty.getText()));
			    } else if (cbbTypeOfUser.getSelectedItem().equals("Student")) {
			    	LoginForm.arrUsers.add(new Student(txtName.getText(), txtUsername.getText(), txtUsername.getText()));
			    } else {
			    	
			    }
			    System.out.println("Inserted new account to the system");
			    setModal(true);
			    getOwner().setEnabled(true);
			    this.dispose();
			}
		} else if (e.getSource() == btnCancel) {
			this.dispose();
			getOwner().setEnabled(true);
			setModal(true);
		}
	}

}
