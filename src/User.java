
public abstract class User extends Object{
	
	/* protected variables */
	protected String name;
	protected String username;
	protected String password;
	protected boolean isLoggedOn;

	/* protected permissions */
	protected boolean ableToEditAnyCourse;
	protected boolean ableToEditMyCourse;
	protected boolean ableToEnrollStudents;
	protected boolean ableToEnrollInClasses;
	
	/* Getters and Setters */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAbleToEditAnyCourse() {
		return ableToEditAnyCourse;
	}
	public void setAbleToEditAnyCourse(boolean ableToEditAnyCourse) {
		this.ableToEditAnyCourse = ableToEditAnyCourse;
	}
	public boolean isAbleToEditMyCourse() {
		return ableToEditMyCourse;
	}
	public void setAbleToEditMyCourse(boolean ableToEditMyCourse) {
		this.ableToEditMyCourse = ableToEditMyCourse;
	}
	public boolean isAbleToEnrollStudents() {
		return ableToEnrollStudents;
	}
	public void setAbleToEnrollStudents(boolean ableToEnrollStudents) {
		this.ableToEnrollStudents = ableToEnrollStudents;
	}
	public boolean isAbleToEnrollInClasses() {
		return ableToEnrollInClasses;
	}
	public void setAbleToEnrollInClasses(boolean ableToEnrollInClasses) {
		this.ableToEnrollInClasses = ableToEnrollInClasses;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public boolean isLoggedOn() {
		return isLoggedOn;
	}
	public void setLoggedOn(boolean isLoggedOn) {
		this.isLoggedOn = isLoggedOn;
	}
	
	/* constructors */
	public User() {}
	public User(String name, String username, String password, boolean 
			ableToEditAnyCourse, boolean ableToEditMyCourse, boolean ableToEnrollStudents, 
			boolean ableToEnrollInClasses) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.ableToEditAnyCourse = ableToEditAnyCourse;
		this.ableToEditMyCourse = ableToEditMyCourse;
		this.ableToEnrollStudents = ableToEnrollStudents;
		this.ableToEnrollInClasses = ableToEnrollInClasses;
	}
	
	/* login and logout */
	public abstract boolean login();
	public abstract boolean logout();
	
	public String toString() {
		return "User " + name;
	}
}
