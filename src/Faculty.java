
public abstract class Faculty extends User {

	protected String typeOfFaculty; //typeOfFaculty refers to specifically what department the faculty member belongs to.
	
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
