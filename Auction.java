package auction;

import auction.Item;
import java.util.Date;

public class Auction {
	
	private int auctionID;
	private static double highestBid;
	//private Bid [] arrayBids;
	private Item item;
	private int timer;
	private boolean isActive;
	private String description;
	private static double startPrice;
	private double reservePrice;
	//private Date closeDate;
	
	public Auction(String description, double startPrice, double reservePrice) {
		this.description = description;
		this.startPrice = startPrice;
		this.reservePrice = reservePrice;
	}
	
	//allows creation of auction with variables below
	public Auction(int auctionID, double highestBid, Item item, int timer) {
		this.auctionID = auctionID;
		this.highestBid = highestBid;
		this.item = item;
		this.timer = timer;
		isActive = true;
	}
	
	public String toString() {
		return this.auctionID + "\n" + this.highestBid + "\n" + this.item + "\n" 
				+ isActive;
	}
	
	public boolean isIsActive() {
		return isActive;
	}
	
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public int getTimer() {
		return timer;
	}
	
	public void SetTimer(int timer) {
		this.timer = timer;
	}
	
	public Auction() 
	{ } //all auction members values set to 0
		
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public int getAuctionID() {
		return auctionID;
	}
	
	public void setAuctionID(double highestBid) {
		this.highestBid = highestBid;
	}
	
	public double getHighestBid() {
		return highestBid;
	}
	
	public void setHighestBid(double highestBid) {
		this.highestBid = highestBid;
	}
	
	public static void placeBid(double bidAmount) {
		highestBid += bidAmount; //incrementes bid amount to highest bid
	}
	
	public static void IsBidAcceptable(double bidAmount)
	{
		final double bidIncrement;
		bidIncrement = highestBid *0.10;
		if (bidAmount <=0)//disallow negative or bids at 0
		{
			System.out.println("Please make a valid bid");
		}
		else if(bidAmount <= bidIncrement) {
			System.out.println("Please increment bid by 10% of the starting price");
		}
		else 
			{
				System.out.println("Bid is acceptable");
			}
			
		}
		
		/*if (bidAmount > startPrice) {
			bidAcceptable = true;		
			System.out.println("bid successfully made");
		}
			else {
				bidAcceptable = false;
				System.out.println("bid didnt meeting increment requirements");		
		}*/

}
