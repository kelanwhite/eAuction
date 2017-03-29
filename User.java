package auction;

public class User {
	
	protected String username;
	protected String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String toString() {
		return this.username + this.password;
	}
	
	public boolean checkPassword(String password) {
		if(password == userPassword) {
			return true;
		}
		else{
				return false;
			
			}
	}
	
	public String getUsername() {
		return username;
	}

}
