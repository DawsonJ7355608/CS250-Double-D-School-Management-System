
public class Professor extends Faculty {

	/**
	 * Constructor for professor
	 * @param name
	 * @param username
	 * @param password
	 * @param typeOfFaculty
	 */
	public Professor(String name, String username, String password, String typeOfFaculty) {
		
		super(name, username, password,typeOfFaculty);
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
