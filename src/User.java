import java.util.HashMap;

public class User {

	private double deposit;
	private HashMap<String, Integer> stockShare = new HashMap<String, Integer>();
	
	
	
	public double getDeposit() {
		return deposit;
	}



	public HashMap<String, Integer> getStockShare() {
		return stockShare;
	}



	/**
	 * This method define the process of buying stocks with given stock name and share.
	 * @param stockName Name of stock to be bought.
	 * @param share Number of share to be bought.
	 * @param market Market in which the transaction happens.
	 */
	public void buy(String stockName, int share, Market market) {
		stockShare.put(stockName, stockShare.get(stockName) + share);
		deposit = deposit - market.getStockSet().get(stockName).getStockValue() * share;
	}
	
	
	
	/**
	 * This method define the process of selling stocks with given stock name and share.
	 * @param stockName Name of stock to be sold.
	 * @param share Number of share to be sold.
	 * @param market Market in which the transaction happens.
	 */
	public void sell(String stockName, int share, Market market) {
		stockShare.put(stockName, stockShare.get(stockName) - share);
		deposit = deposit + market.getStockSet().get(stockName).getStockValue() * share;
	}
	
	
	
	/**
	 * This method checks if there is enough deposit to proceed the transaction.
	 * @param stockName Name of stock.
	 * @param shareBuy Number of share to be bought.
	 * @param market Market in which the transaction happens.
	 * @return
	 */
	public boolean ifEnoughDeposit(String stockName, int shareBuy, Market market) {
		if ((deposit - market.getStockSet().get(stockName).getStockValue() * shareBuy) < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	
	/**
	 * This method checks if there is enough share to proceed the transaction.
	 * @param stockName Name of stock.
	 * @param shareSell Number of share to be sold.
	 * @return
	 */
	public boolean ifEnoughShare(String stockName, int shareSell) {
		if ((stockShare.get(stockName) < shareSell)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	
	/**
	 * This method initiate the user's deposit and share owned for each company.
	 */
	public void userInitiation() {
		deposit = 1000000;
		stockShare.put("A", 0);
		stockShare.put("B", 0);
		stockShare.put("C", 0);
		stockShare.put("D", 0);
		stockShare.put("E", 0);
	}
	
	
	
	/**
	 * This method prints the current status of user's deposit, share, and stock value.
	 * @param market The market in which the transactions happen.
	 */
	public void userPrint(Market market) {
		System.out.println("Current status of user is:");
		System.out.println();
		System.out.println("Deposit: " + deposit);
		System.out.println();
		System.out.println("Share of all companies:");
		System.out.println();
		System.out.println("Company Name" + "\t" + "Share");
		System.out.println();
		double totalValue = 0.0;
		for (String key : stockShare.keySet()) {
			System.out.println(key + "\t" + "\t" + stockShare.get(key));
			totalValue += stockShare.get(key) * market.getStockSet().get(key).getStockValue();
		}
		System.out.println();
		//The number of total value has been rounded to 3 digits.
		System.out.println("Total value: " + Math.round(totalValue * 1000.0) / 1000.0);
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	
	
	/**
	 * This method calculates the total points of user, consisting of user's deposit and current market value.
	 * @param market
	 * @return
	 */
	public double userPointCalculation(Market market) {
		double totalValue = 0.0;
		for (String key : stockShare.keySet()) {
			totalValue += stockShare.get(key) * market.getStockSet().get(key).getStockValue();
		}
		return totalValue;
	}
}
