import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Professor extends Faculty {

	public static ArrayList<Course> arrCourses;
	
	/**
	 * Constructor for professor
	 * @param name
	 * @param username
	 * @param password
	 * @param typeOfFaculty
	 */
	public Professor(String name, String username, String password) {
		
		super(name, username, password);
		arrCourses = new ArrayList<>();
	}
	
	public static void writeToTable() {
		Point point = new Point();
		if(!arrCourses.isEmpty()) {
			for(int i = 0; i<arrCourses.size(); i++) {
				
				String[] arr = new String[4];
				for(int m = 0; m<4; m++) {
					switch (m) {
					case (0):
						arr[m] = "" + arrCourses.get(i).getClassNumber();
					case (1):
						arr[m] = arrCourses.get(i).getTimeAndDays();
					case (2):
						System.out.println("This feature was removed!");
					case (3):
						arr[m] = "" + arrCourses.get(i).getCreditValue();
					}
				}
				
				
				for(int j = 0; j<6;j++) {
					point.x = i; point.y = j;
					Homepage.tblClasses.setValueAt(arr[j], point.x, point.y);
				}
			}
		}
	}
	
	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		
		writeToTable();
		
		return isLoggedOn=true;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return isLoggedOn=false;
	}

}
