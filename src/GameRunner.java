import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
		Game game = new Game();
		Market market = new Market();
		User user = new User();
		game.gamePreparation(); //Print out necessary information.
		market.marketInitiation(); //Initiate the market.
		user.userInitiation(); //Initiate the user.
		Scanner sc = new Scanner(System.in);
		game.continueGame(sc);
		/* The game lasts for several rounds, which can be modified. */
		for (int i = 0; i < 3; i++) {
			market.marketPrint(); //Print out the necessary information about market.
			user.userPrint(market); // Print out the necessary information about user.
			game.turn(sc, user, market); //Simulates the transactions.
			market.marketTurnSimulation(); //Simulates the market changes.
		}
		sc.close();
	}
	
}
