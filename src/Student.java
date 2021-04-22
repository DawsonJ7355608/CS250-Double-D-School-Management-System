import java.awt.Point;
import java.util.ArrayList;

public class Student extends User {

	public static ArrayList<Course> arrCourses;
	
	public Student(String name, String username, String password) {
		super(name, username, password);
		arrCourses = new ArrayList<>();
	}
	
	public static void writeToTable() {
		Point point = new Point();
		if(!arrCourses.isEmpty()) {
			for(int i = 0; i<arrCourses.size(); i++) {
				
				String[] arr = new String[6];
				for(int m = 0; m<6; m++) {
					switch (m) {
					case (0):
						arr[m] = arrCourses.get(i).getProfessor();
						continue;
					case (1):
						arr[m] = "" + arrCourses.get(i).getClassNumber();
						continue;
					case (2):
						arr[m] = arrCourses.get(i).getTimeAndDays();
						continue;
					case (3):
						System.out.println("This feature was removed!");
						continue;
					case (4):
						arr[m] = "" + arrCourses.get(i).getCreditValue();
						continue;
					case (5):
						System.out.println("This is reserved for students list");
						continue;
					}
				}
				
				
				for(int j = 0; j<6;j++) {
					point.x = i+1; point.y = j;
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
