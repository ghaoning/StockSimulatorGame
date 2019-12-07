import java.util.HashMap;

public class Market {

	private HashMap<String, Stock> stockSet = new HashMap<String, Stock>();
	

	
	public HashMap<String, Stock> getStockSet() {
		return stockSet;
	}

	
	
	/**
	 * This method initiate the market for game.
	 */
	public void marketInitiation() {
		//Generate first stock in the market
		Stock stkA = new Stock("A");
		stkA.stockInitiation();
		stockSet.put("A", stkA);
		//Generate second stock in the market
		Stock stkB = new Stock("B");
		stkB.stockInitiation();
		stockSet.put("B", stkB);
		//Generate third stock in the market
		Stock stkC = new Stock("C");
		stkC.stockInitiation();
		stockSet.put("C", stkC);
		//Generate fourth stock in the market
		Stock stkD = new Stock("D");
		stkD.stockInitiation();
		stockSet.put("D", stkD);
		//Generate fifth stock in the market
		Stock stkE = new Stock("E");
		stkE.stockInitiation();
		stockSet.put("E", stkE);
	}
	
	
	
	/**
	 * This method prints the current status of market.
	 */
	public void marketPrint() {
		System.out.println("Current status of market is:");
		System.out.println();
		System.out.print("Company Name");
		System.out.print("\t");
		System.out.print("\t");
		System.out.print("Risk-free Rate");
		System.out.print("\t");
		System.out.print("\t");
		System.out.print("Beta");
		System.out.print("\t");
		System.out.print("\t");
		System.out.print("\t");
		System.out.print("Market Premium");
		System.out.print("\t");
		System.out.print("\t");
		System.out.print("Idiosyncratic Premium");
		System.out.print("\t");
		System.out.print("Country Premium");
		System.out.print("\t");
		System.out.print("\t");
		System.out.print("Stock Value per Share");
		System.out.println();
		System.out.println();
		//The number of each attribute has been rounded to 3 digits.
		for (String key : stockSet.keySet()) {
			System.out.print(stockSet.get(key).getStockName());
			System.out.print("\t");
			System.out.print("\t");
			System.out.print("\t");
			System.out.print(Math.round(stockSet.get(key).getRiskFreeRate() * 1000.0) / 1000.0);
			System.out.print("\t");
			System.out.print("\t");
			System.out.print("\t");
			System.out.print(Math.round(stockSet.get(key).getBeta() * 1000.0) / 1000.0);
			System.out.print("\t");
			System.out.print("\t");
			System.out.print("\t");
			System.out.print(Math.round(stockSet.get(key).getMarketPremium() * 1000.0) / 1000.0);
			System.out.print("\t");
			System.out.print("\t");
			System.out.print("\t");
			System.out.print(Math.round(stockSet.get(key).getIdiosyncraticPremium() * 1000.0) / 1000.0);
			System.out.print("\t");
			System.out.print("\t");
			System.out.print("\t");
			System.out.print(Math.round(stockSet.get(key).getCountryPremium() * 1000.0) / 1000.0);
			System.out.print("\t");
			System.out.print("\t");
			System.out.print("\t");
			System.out.print(Math.round(stockSet.get(key).getStockValue() * 1000.0) / 1000.0);
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	
	
	/**
	 * This method randomizes the market.
	 */
	public void marketTurnSimulation() {
		for (String key : stockSet.keySet()) {
			stockSet.get(key).turnSimulation();
		}
	}
	
}
