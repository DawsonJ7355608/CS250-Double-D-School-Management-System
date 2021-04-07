import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/*	
 * TODO: fix the way the program exits to implement a way to save newly created users back to UsernamePassword.txt
 * 		 add bar to top and let user only exit through than -> disable [X] in top right
 * 		 actionListener -> if user exits -> save IO file
 */

public class LoginForm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JButton btnRegister;
	private JButton btnLogin;
	public static ArrayList<String> arrUsername;
	public static ArrayList<String> arrPassword;
	private JPasswordField txtPassword;
	private JComboBox<String> cbbUserType;
	private JLabel lblUserType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				loadUsernamePasswordFile();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setTitle("Login\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 2, 5, 5));
		
		JLabel lblStarID = new JLabel("StarID:");
		lblStarID.setForeground(Color.WHITE);
		lblStarID.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblStarID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblStarID);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		contentPane.add(txtPassword);
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnRegister);
		btnRegister.addActionListener(this); //attach listener to register button
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btnLogin);
		
		lblUserType = new JLabel("User Type:");
		lblUserType.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblUserType.setForeground(Color.WHITE);
		contentPane.add(lblUserType);
		
		cbbUserType = new JComboBox<String>();
		cbbUserType.setModel(new DefaultComboBoxModel<String>(new String[] {"<Select User Type>", "Student", "Professor", "Administrator"}));
		contentPane.add(cbbUserType);
		btnLogin.addActionListener(this); //attach listener to login button
		
		arrUsername = new ArrayList<>();
		arrPassword = new ArrayList<>();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRegister) {
			RegisterForm frame = new RegisterForm(this, false);
			this.setEnabled(false);
			frame.setVisible(true);
		} else if(e.getSource() == btnLogin) {
			String username = txtUsername.getText();
			int index = arrUsername.indexOf(username);
			if(index < 0) {
				JOptionPane.showMessageDialog(this, "The user is not exist!");
			} else {
				String password = txtPassword.getText();
				if(arrPassword.get(index).equals(password)) {
					/*MainForm main = new MainForm(this, false);
					this.setEnabled(false);
					txtUsername.setText("");
					txtPassword.setText("");
					main.setVisible(true);*/
					
				} else 
					JOptionPane.showMessageDialog(this, "The username and password do not match!");
			}
		}
	}
	
	public static void loadUsernamePasswordFile() {
		File input = new File("src/UsernamePassword/");
		try {
			BufferedReader file = new BufferedReader(new FileReader(input));
			String line = file.readLine();
			while(line != null) {
				String[] temp = line.split(", ");
				arrUsername.add(temp[0]);
				arrPassword.add(temp[1]);
				line = file.readLine();
			}
			file.close();
			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
				System.err.println("ERROR: file not found.");
			} catch (IOException ioe) {
				ioe.printStackTrace();
				System.err.println("ERROR: IO exception.");
			}
		} 
	
	public static void saveUsernamePasswordFile() {
		File output = new File("src/UsernamePassword/");
		try {
			BufferedWriter write = new BufferedWriter(new FileWriter(output));
			//write.write(str);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			System.err.println("ERROR: file not found.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.err.println("ERROR: IO exception.");
		}
		}
	}


