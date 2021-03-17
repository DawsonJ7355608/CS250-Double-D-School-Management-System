
public abstract class User extends Object{
	
	/* protected variables */
	protected String name;
	protected String username;
	protected String password;
	
	/* Getters and Setters */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	
	/* constructors */
	public User() {}
	public User(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public abstract boolean login();
	public abstract boolean logout();
	
	public String toString() {
		return "User " + name;
	}
}
