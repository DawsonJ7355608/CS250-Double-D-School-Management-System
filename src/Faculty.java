
public abstract class Faculty extends User {

	protected String typeOfFaculty; //typeOfFaculty refers to specifically what department the faculty member belongs to.
	
	/* Getters and Setters */
	public String getTypeOfFaculty() {
		return typeOfFaculty;
	}

	public void setTypeOfFaculty(String typeOfFaculty) {
		this.typeOfFaculty = typeOfFaculty;
	}

	/* constructors */
	public Faculty() {}
	public Faculty(String name, String username, String password, boolean 
			ableToEditAnyCourse, boolean ableToEditMyCourse, boolean ableToEnrollStudents, 
			boolean ableToEnrollInClasses, String typeOfFaculty) {
		super(name, username, password, ableToEditAnyCourse, ableToEditMyCourse, ableToEnrollStudents, ableToEnrollInClasses);
		this.typeOfFaculty = typeOfFaculty;
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
	
	public String toString() {
		return "User " + name + ", Department of Faculty Member: " + typeOfFaculty;
	}

}
