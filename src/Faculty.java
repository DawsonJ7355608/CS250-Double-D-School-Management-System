
public abstract class Faculty extends User {

	/* constructors */
	public Faculty() {}
	public Faculty(String name, String username, String password) {
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
	
	public String toString() {
		return "User " + name;
	}

}
