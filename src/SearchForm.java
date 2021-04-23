import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Point;
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
	private JButton btnOk;
	private Student s;
	private Professor p;
	private Administrator a;
	private Course c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchForm dialog = new SearchForm(null, null, null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SearchForm(Course c, Student s, Professor p, Administrator a) {
		
		this.c = c;
		
		setTitle("Search results");
		setBounds(100, 100, 700, 118);
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
					{"Subject", "Course No.", "Name", "Dates", "Days/Time", "Cr/Hr", "Instructors"},
					{null, null, null, null, null, null, null},
				},
				new String[] {
					"New column", "New column", "New column", "New column", "New column", "New column", "New column"
				}
			));
			tblSearchResults.getColumnModel().getColumn(0).setPreferredWidth(43);
			tblSearchResults.getColumnModel().getColumn(1).setPreferredWidth(58);
			tblSearchResults.getColumnModel().getColumn(2).setPreferredWidth(125);
			tblSearchResults.getColumnModel().getColumn(5).setPreferredWidth(35);
			tblSearchResults.getColumnModel().getColumn(6).setPreferredWidth(100);
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
			{
				btnOk = new JButton("OK");
				btnOk.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
		}
		
		//write data to table
		Point point = new Point();
		
		String[] arr = new String[6];
		for(int m = 0; m<6; m++) {
			switch (m) {
			case (0):
				arr[m] = c.getSubject();
				continue;
			case (1):
				arr[m] = "" + c.getClassNumber();
				continue;
			case (2):
				System.out.println("Removed");
				continue;
			case (3):
				arr[m] = c.getTimeAndDays();
				continue;
			case (4):
				arr[m] = "" + c.getCreditValue();
				continue;
			case (5):
				arr[m] = "" + c.getProfessor();
				continue;
			}
		}
		
		if(!s.equals(null)) {
			this.s = s;
		} else if(!p.equals(null)) {
			this.p = p;
		} else if(!a.equals(null)) {
			this.a = a;
		}
		
		for(int j = 0; j<6;j++) {
			point.x = 2; point.y = j;
			this.tblSearchResults.setValueAt(arr[j], point.x, point.y);
		}
		
		//add actionlisteners
		btnOk.addActionListener(this);
		btnAddCourse.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnOk) {
			dispose();
		} else if(e.getSource() == btnAddCourse) {
			
			if(!this.s.equals(null)) {
				Student.arrCourses.add(this.c);
				Student.writeToTable();
			} else if(!this.p.equals(null)) {
				Professor.arrCourses.add(this.c);
				Professor.writeToTable();
			} else {
				Administrator.arrCourses.add(this.c);
				Administrator.writeToTable();
			}
		}
	}

}
