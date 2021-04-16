import java.util.ArrayList;

public class Administrator extends Faculty {

	public static ArrayList<Course> arrCourses;
	
	public Administrator(String name, String username, String password) {
		
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
