import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Homepage extends JFrame implements WindowListener, ActionListener{

	private JPanel contentPane;
	public JTable tblClasses;
	private JTextField txtSearch;
	private JLabel lblWelcomeUser;
	private JButton btnSearch;
	private JButton btnAdd;
	private User u;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPane.showMessageDialog(null, "Warning: trying to save when window closes will cause unexpected "
							+ "termination of the program. Use this runnable for testing the GUI only, and choose cancel in"
							+ " the onWindowClosing() dialog.");
					User user = LoginForm.arrUsers.get(1);
					Homepage frame = new Homepage(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Homepage(User u) {
		setTitle("Homepage");
		this.u = u;
		if(u instanceof Student) {
			setTitle("Student Homepage");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 600, 400);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			GridBagLayout gbl_contentPane = new GridBagLayout();
			gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
			gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			contentPane.setLayout(gbl_contentPane);
			
			lblWelcomeUser = new JLabel("Welcome, " + u.name.replace('_', ' '));
			lblWelcomeUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblWelcomeUser = new GridBagConstraints();
			gbc_lblWelcomeUser.anchor = GridBagConstraints.WEST;
			gbc_lblWelcomeUser.insets = new Insets(0, 0, 5, 5);
			gbc_lblWelcomeUser.gridx = 0;
			gbc_lblWelcomeUser.gridy = 0;
			contentPane.add(lblWelcomeUser, gbc_lblWelcomeUser);
			
			JLabel lblNewLabel_1 = new JLabel("Enter search criteria: ");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 0;
			contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
			
			txtSearch = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 0;
			contentPane.add(txtSearch, gbc_textField);
			txtSearch.setColumns(10);
			
			btnSearch = new JButton("Search");
			btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_btnSearch = new GridBagConstraints();
			gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
			gbc_btnSearch.gridx = 3;
			gbc_btnSearch.gridy = 0;
			contentPane.add(btnSearch, gbc_btnSearch);
			
			tblClasses = new JTable();
			tblClasses.setModel(new DefaultTableModel(
				new Object[][] {
					{"Professor", "Course No.", "Time/Days", "Length", "Credit Value", "Students"},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				},
				new String[] {
					"New column", "New column", "New column", "New column", "New column", "New column"
				}
			));
			tblClasses.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_tblStudent = new GridBagConstraints();
			gbc_tblStudent.insets = new Insets(0, 0, 5, 0);
			gbc_tblStudent.gridwidth = 4;
			gbc_tblStudent.fill = GridBagConstraints.BOTH;
			gbc_tblStudent.gridx = 0;
			gbc_tblStudent.gridy = 1;
			contentPane.add(tblClasses, gbc_tblStudent);
			
			btnAdd = new JButton("Add Course");
			GridBagConstraints gbc_btnAdd = new GridBagConstraints();
			gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
			gbc_btnAdd.gridx = 0;
			gbc_btnAdd.gridy = 2;
			contentPane.add(btnAdd, gbc_btnAdd);
			
			JLabel lblNewLabel_2 = new JLabel("Logged in as a Student");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.gridwidth = 3;
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 2;
			contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
			
			//actionlisteners
			btnSearch.addActionListener(this);
			btnAdd.addActionListener(this);
			this.addWindowListener(this);
			
			//actionlisteners
			
		} else if (u instanceof Professor) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 600, 400);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			GridBagLayout gbl_contentPane = new GridBagLayout();
			gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
			gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			contentPane.setLayout(gbl_contentPane);
			
			JLabel lblWelcomeUser = new JLabel("Welcome, " + u.name.replace('_', ' '));
			lblWelcomeUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblWelcomeUser = new GridBagConstraints();
			gbc_lblWelcomeUser.anchor = GridBagConstraints.WEST;
			gbc_lblWelcomeUser.insets = new Insets(0, 0, 5, 5);
			gbc_lblWelcomeUser.gridx = 0;
			gbc_lblWelcomeUser.gridy = 0;
			contentPane.add(lblWelcomeUser, gbc_lblWelcomeUser);
			
			JLabel lblNewLabel_1 = new JLabel("Enter search criteria: ");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 0;
			contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
			
			txtSearch = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 0;
			contentPane.add(txtSearch, gbc_textField);
			txtSearch.setColumns(10);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_btnSearch = new GridBagConstraints();
			gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
			gbc_btnSearch.gridx = 3;
			gbc_btnSearch.gridy = 0;
			contentPane.add(btnSearch, gbc_btnSearch);
			
			tblClasses = new JTable();
			tblClasses.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tblClasses.setModel(new DefaultTableModel(
				new Object[][] {
					{"Class Number", "Time/Days", "Length", "Credit Value"},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"New column", "New column", "New column", "New column"
				}
			));
			GridBagConstraints gbc_tblProfessor = new GridBagConstraints();
			gbc_tblProfessor.insets = new Insets(0, 0, 5, 0);
			gbc_tblProfessor.gridwidth = 4;
			gbc_tblProfessor.fill = GridBagConstraints.BOTH;
			gbc_tblProfessor.gridx = 0;
			gbc_tblProfessor.gridy = 1;
			contentPane.add(tblClasses, gbc_tblProfessor);
			
			JLabel lblNewLabel_2 = new JLabel("Logged in as a Professor");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.gridwidth = 3;
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 2;
			contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
			this.addWindowListener(this);
		} else if (u instanceof Administrator) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 600, 400);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			GridBagLayout gbl_contentPane = new GridBagLayout();
			gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
			gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			contentPane.setLayout(gbl_contentPane);
			
			JLabel lblWelcomeUser = new JLabel("Welcome, " + u.getName().replace('_', ' '));
			lblWelcomeUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblWelcomeUser = new GridBagConstraints();
			gbc_lblWelcomeUser.anchor = GridBagConstraints.WEST;
			gbc_lblWelcomeUser.insets = new Insets(0, 0, 5, 5);
			gbc_lblWelcomeUser.gridx = 0;
			gbc_lblWelcomeUser.gridy = 0;
			contentPane.add(lblWelcomeUser, gbc_lblWelcomeUser);
			
			JLabel lblNewLabel_1 = new JLabel("Enter search criteria: ");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 0;
			contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
			
			txtSearch = new JTextField();
			txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_txtSearch = new GridBagConstraints();
			gbc_txtSearch.insets = new Insets(0, 0, 5, 5);
			gbc_txtSearch.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtSearch.gridx = 2;
			gbc_txtSearch.gridy = 0;
			contentPane.add(txtSearch, gbc_txtSearch);
			txtSearch.setColumns(10);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_btnSearch = new GridBagConstraints();
			gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
			gbc_btnSearch.gridx = 3;
			gbc_btnSearch.gridy = 0;
			contentPane.add(btnSearch, gbc_btnSearch);
			
			tblClasses = new JTable();
			tblClasses.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tblClasses.setModel(new DefaultTableModel(
				new Object[][] {
					{"Name", "Professor", "Class No.", "Days/Times", "Length", "Credit Value"},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				},
				new String[] {
					"New column", "New column", "New column", "New column", "New column", "New column"
				}
			));
			GridBagConstraints gbc_tblAdministrator = new GridBagConstraints();
			gbc_tblAdministrator.insets = new Insets(0, 0, 5, 0);
			gbc_tblAdministrator.gridwidth = 4;
			gbc_tblAdministrator.fill = GridBagConstraints.BOTH;
			gbc_tblAdministrator.gridx = 0;
			gbc_tblAdministrator.gridy = 1;
			contentPane.add(tblClasses, gbc_tblAdministrator);
			
			JLabel lblNewLabel_2 = new JLabel("Logged in as an Administrator");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.gridwidth = 3;
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 2;
			contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
			
			pack();
			this.addWindowListener(this);
		}
	}
	
	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public static void saveUserToFile() {
		File output = new File("src/UsernamePassword/");
		try {
			BufferedWriter write = new BufferedWriter(new FileWriter(output));
			//write.write(str);
			for (User u : LoginForm.arrUsers) {
				if(u instanceof Administrator) {
					write.write("Administrator " + u.getName() + " " + u.getUsername() + " " + u.getPassword() + " ");
					for (Course c : Administrator.arrCourses) {
						write.write(" Course" + " " + c.getProfessor() + " " + c.getAdministrator() + " " + c.getClassNumber() + " " + 
								c.getTimeAndDays() + " " + c.getCreditValue() + " " + c.getSubject() + " " +
								c.getName());
					}
					write.newLine();
				} else if(u instanceof Professor) {
					write.write("Professor " + u.getName() + " " + u.getUsername() + " " + u.getPassword());
					for (Course c : Professor.arrCourses) {
						write.write(" Course" + " " + c.getProfessor() + " " + c.getAdministrator() + " " + c.getClassNumber() + " " + 
								c.getTimeAndDays() + " " + c.getCreditValue() + " " + c.getSubject() + " " +
								c.getName());
					}
					write.newLine();
				} else if(u instanceof Student) {
					write.write("Student " + u.getName() + " " + u.getUsername() + " " + u.getPassword());
					for (Course c : Student.arrCourses) {
						write.write(" Course" + " " + c.getProfessor() + " " + c.getAdministrator() + " " + c.getClassNumber() + " " + 
								c.getTimeAndDays() + " " + c.getCreditValue() + " " + c.getSubject() + " " +
								c.getName());
					}
					write.newLine();
				}
			}
			write.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			System.err.println("ERROR: file not found.");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.err.println("ERROR: IO exception.");
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		int n = JOptionPane.showConfirmDialog(this, "You have changes that have not been saved. Save now?", "Unsaved Changes", 
																							JOptionPane.YES_NO_CANCEL_OPTION);
		if (n==1) {//User chooses No
			this.setEnabled(false);
			this.dispose();
			
		} else if (n==2) { //User cancels
			System.out.println("Nothing happens");
		} else if (n==0) { //User chooses Yes
			saveUserToFile();
			System.out.println("User saved to file.");
			this.dispose();
		}
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSearch) {
			
		} else if(e.getSource() == btnAdd) {
			CourseForm frame = new CourseForm(this, false, (Student)u);
			this.setEnabled(false);
			frame.setVisible(true);
		}

	}
	
}
