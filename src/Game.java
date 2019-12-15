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
		System.out.println("Type \"0\" to continue to next round.");
		Scanner sc2 = new Scanner(System.in);
		String userInput = sc2.nextLine();


		while(true){

			if(userInput.equals("0")){
				System.out.println("Next turn");
				break;
			}else if (userInput.equals("1")) {
				System.out.println(" You type \"1\" to buy stocks,");
				userStockSelection(sc, user, market);
				userBuyOption(sc, user, market);

				break;
			}
			else if (userInput.equals("2")) {
				System.out.println(" You type \"2\" to sell stocks,");
				userStockSelection(sc, user, market);
				userSellOption(sc, user, market);
				break;
			} else {
				System.out.println("Invalid Sell or Buy, please type again!");
				userInput = sc2.nextLine();
			}

		}

		

	}
	
	
	
	/**
	 * This method defines the interactions when user decides to buy a stock.
	 * @param sc User input.
	 * @param user User object.
	 * @param market Market in which the transactions happen.
	 */
	public void userBuyOption(Scanner sc, User user, Market market) {
//		userStockSelection(sc,user,market);
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
	public void userStockSelection(Scanner sc, User user, Market market) {

		System.out.println("Input the name of company, or type \"BACK\" to go back.");
		String userInput = sc.nextLine();

		while(true){

			if(userInput.toUpperCase().equals("BACK")){
				System.out.println("We just go back!");
				turn(sc, user, market);
				continue;
			}else if (userInput.toUpperCase().equals("A") ||
					userInput.toUpperCase().equals("B") ||
					userInput.toUpperCase().equals("C") ||
					userInput.toUpperCase().equals("D") ||
					userInput.toUpperCase().equals("E")){
				company = userInput.toUpperCase();
				System.out.println("You select company  " + company);
				break;

			}else {
				System.out.println("Invalid Company, please type again!");
				userInput = sc.nextLine();
			}
		}

			


	}
	
	
	
	/**
	 * This method defines the number of share to buy.
	 * @param sc
	 */
	public void userShareInput(Scanner sc) {
		try {
			System.out.println("Please input share number");
			share = sc.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid Share, please type again!");
//			sc.nextLine();
			userShareInput(sc);
		}
	}
	
	
	
	/**
	 * This method defines the interactions when user decides to sell a stock.
	 * @param sc User input.
	 * @param user User object.
	 * @param market Market in which the transactions happen.
	 */
	public void userSellOption(Scanner sc, User user, Market market) {
//		userStockSelection(sc, user, market);
		userShareInput(sc);
		if (user.ifEnoughShare(company, share)) {
			user.sell(company, share, market);
		}
		else {
			System.out.println("Not enough share, please wait for 5 seconds!");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
