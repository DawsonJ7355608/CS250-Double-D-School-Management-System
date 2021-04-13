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
	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

}
