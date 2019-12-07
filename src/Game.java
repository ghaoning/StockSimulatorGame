import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
	
	String company;
	int share;
	
	
	/**
	 * This method prints out the necessary information about the game.
	 */
	public void gamePreparation() {
		System.out.println("Hello there! Welcome to the Stock Simulator Game!");
		System.out.println();
		System.out.println("You will be given 1,000,000 dollars to make investment on 5 company in terms of stock purchase and selling.");
		System.out.println();
		System.out.println("At beginning of each round, information of each company will be released including:");
		System.out.println();
		System.out.println("1. Risk-free Rate -- Rate of return of the government bond.");
		System.out.println("2. Beta -- An indicator of the market risk of a firm.");
		System.out.println("3. Market Premium -- Extra return from the risk-free asset in the market.");
		System.out.println("4. Idiosyncratic Premium -- Firm-specific risk associated with return.");
		System.out.println("5. Country Premium -- Country-specific risk associated with return.");
		System.out.println();
	}

	
	
	/**
	 * This method defines the connection between each game section.
	 */
	public void continueGame(Scanner sc) {
		System.out.println("Please type \"C\" to continue.");
		String input = sc.nextLine();
		while (!input.toUpperCase().equals("C")) {
			System.out.println("Invalid input, please type again!");
			input = sc.nextLine();			
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	
	
	
	public void turn(Scanner sc, User user, Market market) {
		System.out.println("Type \"1\" to buy stocks,");
		System.out.println("Type \"2\" to sell stocks,");
		System.out.println("Type \"0\" to continue without any actions.");
		String userInput = sc.nextLine();
		while (!userInput.equals("0")) {
			if (userInput.equals("1")) {
				userBuyOption(sc, user, market);
			}
			else if (userInput.equals("2")) {
				
			}
			else {
				System.out.println("Invalid input, please type again!");
				userInput = sc.nextLine();
			}
		}
		
		System.out.println();
	}
	
	
	
	/**
	 * This method defines the interactions when user decides to buy a stock.
	 * @param sc User input.
	 * @param user User object.
	 * @param market Market in which the transactions happen.
	 */
	public void userBuyOption(Scanner sc, User user, Market market) {
		userStockSelection(sc);
		userShareInput(sc);
		if (user.ifEnoughDeposit(company, share, market)) {
			user.buy(company, share, market);
		}
		else {
			System.out.println("Insufficient fund!");
		}
	}
	
	
	
	/**
	 * This method defines the stock to buy.
	 * @param sc
	 */
	public void userStockSelection(Scanner sc) {
		System.out.println("Input the name of company, or type \"BUY\" to go back.");
		String userInput = sc.nextLine();
		while (!userInput.toUpperCase().equals("A") &&
		       !userInput.toUpperCase().equals("B") &&
			   !userInput.toUpperCase().equals("C") &&
			   !userInput.toUpperCase().equals("D") &&
			   !userInput.toUpperCase().equals("E") &&
			   !userInput.toUpperCase().equals("BUY")) {
			System.out.println("Invalid input, please type again!");
			userInput = sc.nextLine();
		}
		if (userInput.toUpperCase().equals("BUY")) {
			System.out.println("We just go back!");
		}
		else {
			company = userInput.toUpperCase();
		}
	}
	
	
	
	/**
	 * This method defines the number of share to buy.
	 * @param sc
	 */
	public void userShareInput(Scanner sc) {
		try {
			share = sc.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid input, please type again!");
			sc.nextLine();
		}
	}
	
	
	
}
