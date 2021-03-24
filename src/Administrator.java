
public class Administrator extends Faculty {

	public Administrator(String name, String username, String password, boolean 
			ableToEditAnyCourse, boolean ableToEditMyCourse, boolean ableToEnrollStudents, 
			boolean ableToEnrollInClasses, String typeOfFaculty) {
		
		super(name, username, password, ableToEditAnyCourse, ableToEditMyCourse, 
				ableToEnrollStudents, ableToEnrollInClasses, typeOfFaculty);
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
