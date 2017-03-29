package auction;

import auction.Item;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AuctionSystem {
	
	private boolean userAuthenticate;
	private String username;
	
	private final int SETUP_ACCOUNT = 1;
	private final int BROWSE_AUCTION = 2;
	private final int PLACE_BID = 3;
	private final int START_AUCTION = 4;
	private final int EXIT = 5;
	
	ArrayList<User> arrayUsers = new ArrayList<User>();
	ArrayList<Auction> auctionList = new ArrayList<Auction>();
	
	public static Scanner Sc = new Scanner(System.in);
	
	//what it do? 
	public AuctionSystem() {
		
		userAuthenticate = false;
		username = "";
		
		arrayUsers.add(new User("jbutler", "butlerj")); //sample hard coded users
		arrayUsers.add(new User("kwhite", "whitek"));
		
		Item aItem = new Item ("books", 10.00, 5.00);
		auctionList.add(new Auction (123, 10.00, aItem, 1000));
	}
		//private method
				private User getUser(String username) {
					for(User currentUser: arrayUsers) {
						if(currentUser.getUsername() == username) {
							return currentUser;
						}
					}
					return null;
				}
		
		public boolean authenticateUser (String userUsername, String userPassword){
			User userAccount = getUser (userUsername);
			
			if(userAccount != null) {
				return userAccount.checkPassword(userPassword);
			}
			else {
				return false;
			}
		}
		
		public void run() {		
			/*while (true) {
	            while (!userAuthenticate) {
	            	System.out.println("");
	            	System.out.println("Welcome!");
	                authenticateUser();
	            }*/
	            
	            runMenu();
	           /* userAuthenticate = false;
	            username = "";*/
	            
	            System.out.println("");
	            System.out.println("Thankyou!");
	            
			}
	//}
		
		private void runMenu() {
			boolean userExit = false;
			
			while (!userExit) {
				int menuSelection = displayMainMenu();
				
				switch(menuSelection) {
				case SETUP_ACCOUNT: {
					setupAccount();
					break;
				}
				case BROWSE_AUCTION: {
					browseAuctions();
					break;
				}
				case PLACE_BID: {
				placeBid();
				break;
				}
				case START_AUCTION: {
					startAuctions();
					break;
				}
				default: {
					System.out.println("");
					System.out.println("You did not enter a valid selection, please try again. ");
					break;
				}
			
			}
		}
	}
		
	
	
	private int displayMainMenu() {
		System.out.println("");
		System.out.println("Main Menu");
		System.out.println("1 - Setip Account");
		System.out.println("2 - Browse Auction");
		System.out.println("3 - Place Bid");
		System.out.println("4 - Start Auction");
		System.out.println("5 - Exit");
		System.out.println("");
		System.out.println("Enter Choice : ");
		//test array of users
		for(int i = 0; i < arrayUsers.size(); 
				i++) {
			System.out.println(arrayUsers.get(i));
		}
		return Sc.nextInt();
	}
	
	public void setupAccount() {
		System.out.println("Please choose a username");
		String newUsername = Sc.next();
		System.out.println("Please choose a password");
		String newPassword = Sc.next();
		
		arrayUsers.add(new User(newUsername, newPassword));
	}
	
	public void browseAuctions() {
		for (int i = 0; i < auctionList.size(); i++) {
					if(auctionList.get(i).isIsActive())
						
						System.out.println("List of auctions: " + "\n");
					System.out.println(auctionList.get(i));
				}
	}
	
	public void startAuctions() {
		System.out.println("Please add a description: ");
		String newDescription = Sc.next();
		System.out.println("Please add a starting price: ");
		double newStartPrice = Sc.nextDouble();
		System.out.println("Please add a reserve price: ");
		double newReservePrice = Sc.nextDouble();
		
		Item newItem = new Item (newDescription, newStartPrice, newReservePrice);
	}
	
	public void placeBid() {
		double bidAmount;
		System.out.println("the start price is " + Item.startPrice);
		System.out.println("Please enter bid amount");
		bidAmount = Sc.nextDouble();
		if (bidAmount <=0)// disallow negative or bids of 0
		{
			System.out.println("Please make a valid bid");
			placeBid();
		}
		else {
			Auction.IsBidAcceptable(bidAmount);
			Auction.placeBid(bidAmount); //call placebid method and pass bidamount
			System.out.println("your bid of £: " + bidAmount + "has been placed");
		}
	}

}
