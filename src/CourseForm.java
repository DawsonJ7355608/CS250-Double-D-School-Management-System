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

public class CourseForm extends JDialog implements ActionListener, WindowListener {

	private JPanel contentPane;
	private JTextField txtCourseID;
	private JTextField txtName;
	private JButton btnAdd;
	private JButton btnCancel;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtAdmin;
	private JTextField txtTimeDay;
	private JTextField txtCredit;
	private JTextField txtSubject;
	private JTextField txtProfessor;
	private Student s;
	private Professor p;
	private Administrator a;

	/**
	 * Create the frame.
	 */
	public CourseForm(JFrame owner, boolean modal, User u) {
		super(owner, modal);
		
		if(u instanceof Student) this.s = (Student)u;
		else if(u instanceof Professor) this.p = (Professor)u;
		else this.a = (Administrator)u;
		
		setTitle("Add a course to your schedule");
		setBackground(new Color(204, 153, 102));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Professor:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txtProfessor = new JTextField();
		txtProfessor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtProfessor.setColumns(10);
		GridBagConstraints gbc_txtProfessor = new GridBagConstraints();
		gbc_txtProfessor.insets = new Insets(0, 0, 5, 0);
		gbc_txtProfessor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProfessor.gridx = 1;
		gbc_txtProfessor.gridy = 1;
		contentPane.add(txtProfessor, gbc_txtProfessor);
		
		JLabel lblNewLabel_1 = new JLabel("Admin (Department Head):");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtAdmin = new JTextField();
		txtAdmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAdmin.setColumns(10);
		GridBagConstraints gbc_txtAdmin = new GridBagConstraints();
		gbc_txtAdmin.insets = new Insets(0, 0, 5, 0);
		gbc_txtAdmin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAdmin.gridx = 1;
		gbc_txtAdmin.gridy = 2;
		contentPane.add(txtAdmin, gbc_txtAdmin);
		
		lblNewLabel_7 = new JLabel("Name:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 3;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.gridx = 1;
		gbc_txtName.gridy = 3;
		contentPane.add(txtName, gbc_txtName);
		txtName.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Subject:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 5;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		txtSubject = new JTextField();
		txtSubject.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSubject.setColumns(10);
		GridBagConstraints gbc_txtSubject = new GridBagConstraints();
		gbc_txtSubject.insets = new Insets(0, 0, 5, 0);
		gbc_txtSubject.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSubject.gridx = 1;
		gbc_txtSubject.gridy = 5;
		contentPane.add(txtSubject, gbc_txtSubject);
		
		JLabel lblNewLabel_2 = new JLabel("Course ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 6;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtCourseID = new JTextField();
		txtCourseID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_txtCourseID = new GridBagConstraints();
		gbc_txtCourseID.insets = new Insets(0, 0, 5, 0);
		gbc_txtCourseID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCourseID.gridx = 1;
		gbc_txtCourseID.gridy = 6;
		contentPane.add(txtCourseID, gbc_txtCourseID);
		txtCourseID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Time/Day:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 7;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtTimeDay = new JTextField();
		txtTimeDay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTimeDay.setColumns(10);
		GridBagConstraints gbc_txtTimeDay = new GridBagConstraints();
		gbc_txtTimeDay.insets = new Insets(0, 0, 5, 0);
		gbc_txtTimeDay.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTimeDay.gridx = 1;
		gbc_txtTimeDay.gridy = 7;
		contentPane.add(txtTimeDay, gbc_txtTimeDay);
		
		lblNewLabel_5 = new JLabel("Credit Value:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 8;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		txtCredit = new JTextField();
		txtCredit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCredit.setColumns(10);
		GridBagConstraints gbc_txtCredit = new GridBagConstraints();
		gbc_txtCredit.insets = new Insets(0, 0, 5, 0);
		gbc_txtCredit.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCredit.gridx = 1;
		gbc_txtCredit.gridy = 8;
		contentPane.add(txtCredit, gbc_txtCredit);
		
		btnAdd = new JButton("Add Course");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 10;
		contentPane.add(btnAdd, gbc_btnAdd);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 10;
		contentPane.add(btnCancel, gbc_btnCancel);
		
		setSize(new Dimension(400, 300));
		
		btnAdd.addActionListener(this);
		btnCancel.addActionListener(this);
		this.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd) {
			if(txtAdmin.getText().equals("") || txtCourseID.getText().equals("") || txtCredit.getText().equals("") ||
				txtName.getText().equals("") || txtProfessor.getText().equals("") || txtSubject.getText().equals("") ||
				txtTimeDay.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "One or more fields were left blank!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				try {
				Course course = new Course(txtProfessor.getText(), txtAdmin.getText(), Integer.parseInt(txtCourseID.getText()), txtTimeDay.getText(),
						Double.parseDouble(txtCredit.getText()), txtSubject.getText(), txtName.getText());
				if(this.s!=null) {
					Student.arrCourses.add(course);
					Student.writeToTable();
				}
				else if(this.p!=null) {
					Professor.arrCourses.add(course);
					Professor.writeToTable();
				}
				else {
					Administrator.arrCourses.add(course);
					Administrator.writeToTable();
				}
				} catch (NumberFormatException nfe) {
							JOptionPane.showMessageDialog(this, "Course ID must be a whole number and credit must be a decimal!", "Error", JOptionPane.ERROR_MESSAGE);
						}
			}
			this.dispose();
			getOwner().setEnabled(true);
			setModal(true);
				
			} else if (e.getSource() == btnCancel) { //if user selects cancel
			this.dispose();
			getOwner().setEnabled(true);
			setModal(true);
			return;
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
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
