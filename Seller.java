package auction;

public class Seller extends User {
	
	private boolean isBlocked;
	
	public Seller(String username, String password, boolean isBlocked) {
		super(username, password);
		
		this.isBlocked = isBlocked;
	}
	
	public boolean isBlocked() {
		return isBlocked;
	}
	
	public void setIsBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

}
