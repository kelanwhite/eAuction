package auction;

import java.util.Date;

public class Item {
	
	private String description;
	static double startPrice;
	private double reservePrice;
	
	public Item(String description, double startPrice, double reservePrice) {
		this.description = description;
		this.startPrice = startPrice;
		this.reservePrice = reservePrice;
	}
	
	public Item() 
	{ } //set Item members to null
	
	public String toString() {
		return this.description + "\n" + this.startPrice + "\n"
				+ this.reservePrice;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public double getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(double startPrice) {
		this.startPrice = startPrice;
	}

	public double getReservePrice() {
		return reservePrice;
	}

	public void setReservePrice(double reservePrice) {
		this.reservePrice = reservePrice;
	}

}
