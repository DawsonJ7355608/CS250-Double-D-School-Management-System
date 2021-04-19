import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

public class SearchForm extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTable tblSearchResults;
	private JButton btnAddCourse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchForm dialog = new SearchForm(null, null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SearchForm(Administrator a, Professor p, Student s) {
		setTitle("Add a Course");
		setBounds(100, 100, 1220, 309);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			tblSearchResults = new JTable();
			tblSearchResults.setModel(new DefaultTableModel(
				new Object[][] {
					{"Subject", "Course No.", "Name", "Dates", "Days/Time", "Cr/Hr", "Instructors", "Administrator", "Students"},
					{"CS", "101", "Exploring Creative Computing", "08/23-12/03", "MW 8:00am - 9:20am", "3.0", "Double click to view", "Double click to view", "Double click to view"},
					{"CS", "116", "Web Technology I", null, null, "3.0", "Double click to view", "Double click to view", "Double click to view"},
					{"CS", "234", "Algorithms and Problem Solving I", null, null, "4.0", "Double click to view", "Double click to view", "Double click to view"},
					{"CS", "250", "Algorithms and Problem Solving II", null, null, "4.0", "Double click to view", "Double click to view", "Double click to view"},
					{"CS", "275", "Mathematical Foundations of Algorithms", null, null, "4.0", "Double click to view", "Double click to view", "Double click to view"},
					{"CS", "313", "Networking and Telecommunications", null, null, "4.0", "Double click to view", "Double click to view", "Double click to view"},
					{"CS", "341", "Data Structures", null, null, "4.0", "Double click to view", "Double click to view", "Double click to view"},
					{"CS", "344", "Introduction to Web Programming", null, null, "3.0", "Double click to view", "Double click to view", "Double click to view"},
					{"CS", "375", "Computer Systems", null, null, "4.0", "Double click to view", "Double click to view", "Double click to view"},
					{"CS", "385", "Applied Database Management Systems", null, null, "4.0", "Double click to view", "Double click to view", "Double click to view"},
					{"CS", "405", "Operating Systems", null, null, "3.0", "Double click to view", "Double click to view", "Double click to view"},
					{"CS", "410", "Software Engineering", null, null, "4.0", "Double click to view", "Double click to view", "Double click to view"},
					{"CS", "415", "Principles of Programming Languages", null, null, "3.0", "Double click to view", "Double click to view", "Double click to view"},
				},
				new String[] {
					"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
				}
			));
			tblSearchResults.getColumnModel().getColumn(0).setPreferredWidth(15);
			tblSearchResults.getColumnModel().getColumn(0).setMinWidth(1);
			tblSearchResults.getColumnModel().getColumn(1).setPreferredWidth(15);
			tblSearchResults.getColumnModel().getColumn(1).setMinWidth(5);
			tblSearchResults.getColumnModel().getColumn(2).setPreferredWidth(180);
			tblSearchResults.getColumnModel().getColumn(3).setPreferredWidth(50);
			tblSearchResults.getColumnModel().getColumn(5).setPreferredWidth(15);
			tblSearchResults.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_tblSearchResults = new GridBagConstraints();
			gbc_tblSearchResults.fill = GridBagConstraints.BOTH;
			gbc_tblSearchResults.gridx = 0;
			gbc_tblSearchResults.gridy = 0;
			contentPanel.add(tblSearchResults, gbc_tblSearchResults);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAddCourse = new JButton("Add Course");
				btnAddCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
				buttonPane.add(btnAddCourse);
			}
		}
		btnAddCourse.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
