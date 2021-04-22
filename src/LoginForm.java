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
 * TODO: allow users to view courses they're enrolled in via the homepage.
 * 		- each 
 * 
 */

public class LoginForm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JButton btnRegister;
	private JButton btnLogin;
	public static ArrayList<User> arrUsers;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					loadUserFromFile();
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
	public LoginForm() {
		setTitle("Login\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2, 5, 5));
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblUsername);
		
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
		btnLogin.addActionListener(this); //attach listener to login button
		
		arrUsers = new ArrayList<>();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRegister) {
			RegisterForm frame = new RegisterForm(this, false);
			this.setEnabled(false);
			frame.setVisible(true);
		} else if(e.getSource() == btnLogin) {
			
			//Safely get login details from form
			String username = txtUsername.getText();
			char[] chPassword = txtPassword.getPassword();
			String strPassword ="";
			for (char ch : chPassword) strPassword = strPassword + ch; //convert from ch[] to string
			
			//test all users for login credentials
			boolean doesUserExist = false;
			for (User u : arrUsers) {
				if(u.getUsername().equals(username) && u.getPassword().equals(strPassword)) { //if username and pass mach a user
					User logged_in = u;
					Homepage home = new Homepage(logged_in); //call homepage constructor
					txtUsername.setText(""); //clear text
					txtPassword.setText("");
					doesUserExist = true;
					this.setEnabled(false);
					this.setVisible(false);
					home.setEnabled(true); //enable homepage visible
					home.setVisible(true); //make homepage visible
					break;
				}
			} if (!doesUserExist) {
				JOptionPane.showMessageDialog(this, "No user with this username/password combo exists. " //tell user doens't exist
						+ "Try again or click register!");
			}
		} 
	}
	
	//load all users into arrUsers array
	public static void loadUserFromFile() {
		File input = new File("src/UsernamePassword/");
		try {
			BufferedReader file = new BufferedReader(new FileReader(input));
			String line = file.readLine();
			while(line != null) {
				String[] temp = line.split(" ");
				if(temp[0].equals("")) { //no user type
					
				} else if (temp[0].equals("Administrator")) {
					Administrator a = new Administrator(temp[1], temp[2], temp[3]);
					arrUsers.add(a);
					for (int i = 4; i < temp.length; i++) {
						if(temp[i].equals("Course")) {
							Administrator.arrCourses.add(new Course(temp[i+1], temp[i+2], Integer.parseInt(temp[i+3]), temp[i+4], 
									Double.parseDouble(temp[i+5]), temp[i+6], temp[i+7]));
						}
						i+=7; //skip items that are obviously not the "Course" flag.
					}
				} else if(temp[0].equals("Professor")) {
					Professor p = new Professor(temp[1], temp[2], temp[3]);
					arrUsers.add(p);
					for (int i = 4; i < temp.length; i++) {
						if(temp[i].equals("Course")) {
							Professor.arrCourses.add(new Course(temp[i+1], temp[i+2], Integer.parseInt(temp[i+3]), temp[i+4], 
									Double.parseDouble(temp[i+5]), temp[i+6], temp[i+7]));
						}
						i+=7; //skip items that are obviously not the "Course" flag.
					}
				} else if(temp[0].equals("Student")) {
					Student s = new Student(temp[1], temp[2], temp[3]);
					arrUsers.add(s);
					for (int i = 4; i < temp.length; i++) {
						if(temp[i].equals("Course")) {
							Student.arrCourses.add(new Course(temp[i+1], temp[i+2], Integer.parseInt(temp[i+3]), temp[i+4], 
									Double.parseDouble(temp[i+5]), temp[i+6], temp[i+7]));
						}
						i+=7; //skip items that are obviously not the "Course" flag.
					}
				} else {
					throw new IOException("Error: a line saved to the file contains an unrecognized flag and "
							+ "prevented proper loading. Check file for bad flags to resolve the loading error");
				}
				line = file.readLine();
			}
			file.close();
			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
				System.err.println("ERROR: file not found.");
			} catch (IOException ioe) {
				ioe.printStackTrace();
				System.err.print("ERROR: IO exception: ");
				System.err.print(ioe.getMessage() + "\n");
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
				System.err.print("ERROR: NumberFormat exception: ");
				System.err.print(nfe.getMessage() + "\n");
			}
		} 
	}


