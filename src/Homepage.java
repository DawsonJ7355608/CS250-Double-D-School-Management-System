import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Homepage extends JFrame {

	private JPanel contentPane;
	private JTable tblClasses;
	private JTextField txtSearch;
	private JLabel lblWelcomeUser;
	private JButton btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User admin = new Administrator("Jeff", "jeff", "jeff", "Math");
					Homepage frame = new Homepage(admin);
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
	public Homepage(User u) {
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
			
			lblWelcomeUser = new JLabel("Welcome, ");
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
			
			JLabel lblNewLabel_2 = new JLabel("Logged in as a Student");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.gridwidth = 3;
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 2;
			contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
			
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
			
			JLabel lblWelcomeUser = new JLabel("Welcome, ");
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
					{"Class Number", "Time/Days", "Length", "Credit Value", "Students"},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
					{null, null, null, null, null},
				},
				new String[] {
					"New column", "New column", "New column", "New column", "New column"
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
			
			JLabel lblWelcomeUser = new JLabel("Welcome, " + u.getName());
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
					{"Name", "Professor", "Class No.", "Days/Times", "Length", "Credit Value", "Students"},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
				},
				new String[] {
					"New column", "New column", "New column", "New column", "New column", "New column", "New column"
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
		}
	}

}
