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
	private JPasswordField txtPassword;
	private JComboBox<String> cbbUserType;
	private JLabel lblUserType;

	//public static ArrayList<User> arrUsers;
	public static ArrayList<Administrator> arrAdministrators;
	public static ArrayList<Professor> arrProfessors;
	public static ArrayList<Student> arrStudents;
	
	
	public static ArrayList<Course> arrPossibleCourses;
	
	public Course course101;
	public Course course116;
	public Course course234;
	public Course course250;
	public Course course275;
	public Course course313;
	public Course course341;
	public Course course344;
	public Course course375;
	public Course course385;
	public Course course405;
	public Course course410;
	public Course course415;
	
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
		
		//arrUsers = new ArrayList<>();
		arrAdministrators = new ArrayList<>();
		arrProfessors = new ArrayList<>();
		arrStudents = new ArrayList<>();
		
		/* Instantiate list of possible courses
		 * While not the best solution, this will be a temporary way to allow the forms to handle courses. 
		 */
		arrPossibleCourses = new ArrayList<>();
		
		//instantiating all possible courses
		course101 = new Course(null, null, 101, "M/W 8:00am-9:20am", "08/23-12/03", 3.0, "CS", "Exploring Creative Computing");
		course116 = new Course(null, null, 116, "T/Th 4:00pm-5:20pm", "08/23-12/03", 3.0, "CS", "Web Technology I");
		course234 = new Course(null, null, 234, "T/Th 10:00am-11:50am", "08/23-12/03", 4.0, "CS", "Algorithms and Problem Solving I");
		course250 = new Course(null, null, 250, "M/W 10:00am-11:50am", "08/23-12/03", 4.0, "CS", "Algorithms and Problem Solving II");
		course275 = new Course(null, null, 275, "T/Th 8:00am-9:50am", "08/23-12/03", 4.0, "CS", "Mathematical Foundations of Algorithms");
		course313 = new Course(null, null, 313, "T/Th 11:00am-12:50am", "08/23-12/03", 4.0, "CS", "Networking and Telecommunications");
		course341 = new Course(null, null, 341, "M/W 8:00am-9:50am", "08/23-12/03", 4.0, "CS", "Data Structures");
		course344 = new Course(null, null, 344, "T/Th 1:00pm-2:20pm", "08/23-12/03", 3.0, "CS", "Introduction to Web Programming");
		course375 = new Course(null, null, 375, "T/Th 7:50pm-9:50pm", "08/23-12/03", 4.0, "CS", "Computer Systems");
		course385 = new Course(null, null, 385, "M/W 10:00am-11:20am", "08/23-12/03", 4.0, "CS", "Applied Database Management Systems");
		course405 = new Course(null, null, 405, "T/Th 10:00am-11:20am", "08/23-12/03", 3.0, "CS", "Operating Systems");
		course410 = new Course(null, null, 410, "T/Th 8:00am-9:50am", "08/23-12/03", 4.0, "CS", "Software Engineering");
		course415 = new Course(null, null, 415, "M/W 11:00am-12:20pm", "08/23-12/03", 3.0, "CS", "Principles of Programming Languages");
		
		//adding all possible courses for demonstration purposes
		arrPossibleCourses.add(course101);
		arrPossibleCourses.add(course116);
		arrPossibleCourses.add(course234);
		arrPossibleCourses.add(course250);
		arrPossibleCourses.add(course275);
		arrPossibleCourses.add(course313);
		arrPossibleCourses.add(course341);
		arrPossibleCourses.add(course344);
		arrPossibleCourses.add(course375);
		arrPossibleCourses.add(course385);
		arrPossibleCourses.add(course405);
		arrPossibleCourses.add(course410);
		arrPossibleCourses.add(course415);
		
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
			for (char ch : chPassword) strPassword = strPassword + ch;
			
			//test all users for login credentials
			boolean doesUserExist = false;
			for (Administrator a : arrAdministrators) {
				if(a.getUsername().equals(username) && a.getPassword().equals(strPassword)) { //if username and pass mach a user
					Homepage home = new Homepage(a); //call homepage constructor
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
	
	public static void loadUserFromFile() {
		File input = new File("src/UsernamePassword/");
		try {
			BufferedReader file = new BufferedReader(new FileReader(input));
			String line = file.readLine();
			while(line != null) {
				String[] temp = line.split(" ");
				if(temp[0].equals("")) {
					
				} else if (temp[0].equals("Administrator")) {
					Administrator a = new Administrator(temp[1], temp[2], temp[3]);
					LoginForm.arrAdministrators.add(a);
					if(temp.length>6) {
						for (int i = 4; i < temp.length; i++) {
							if(temp[i].equals("Course")) {
								for(Course c : arrPossibleCourses) {
									if (c.getName().equals(temp[i+1])) a.arrCourses.add(c);
								}
							}
							i+=1; //skip items that are obviously not the "Course" flag.
						}
					}
				} else if(temp[0].equals("Professor")) {
					Professor p = new Professor(temp[1], temp[2], temp[3]);
					LoginForm.arrProfessors.add(p);
					if(temp.length>6) {
						for (int i = 4; i < temp.length; i++) {
							if(temp[i].equals("Course")) {
								for(Course c : arrPossibleCourses) {
									if (c.getName().equals(temp[i+1])) p.arrCourses.add(c);
								}
							}
							i+=1; //skip items that are obviously not the "Course" flag.
						}
					}
				} else if(temp[0].equals("Student")) {
					Student s = new Student(temp[1], temp[2], temp[3]);
					LoginForm.arrStudents.add(s);
					if(temp.length>6) {
						for (int i = 4; i < temp.length; i++) {
							if(temp[i].equals("Course")) {
								for(Course c : arrPossibleCourses) {
									if (c.getName().equals(temp[i+1])) s.arrCourses.add(c);
								}
							}
							i+=1; //skip items that are obviously not the "Course" flag.
						}
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
	
	/*public static void saveUsernamePasswordFile() {
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
		}*/
	}


