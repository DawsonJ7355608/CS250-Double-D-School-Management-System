import java.util.ArrayList;
import java.util.List;


public class Professor extends Faculty {

	List<Course> arrClasses = new ArrayList<>();
	
	/**
	 * Constructor for professor
	 * @param name
	 * @param username
	 * @param password
	 * @param typeOfFaculty
	 */
	public Professor(String name, String username, String password) {
		
		super(name, username, password);
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
