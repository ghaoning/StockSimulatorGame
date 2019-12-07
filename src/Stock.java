import java.util.Random;

public class Stock {
	
	private String stockName; /* Name of the stock */
	private double riskFreeRate; /* Rate of return of the government bond, usually ranging from 1% to 3.5% */
	private double beta; /* An indicator of the market risk of a firm, usually ranging from 0 to 3 */
	private double marketPremium; /* Extra return from the risk-free asset in the market, usually ranging from 3% to 10% */
	private double idiosyncraticPremium; /* Firm-specific risk associated with return, usually ranging from -30% to 30% */
	private double countryPremium; /* Country-specific risk associated with return, usually ranging from 0% to 5% */
	private double returnValue; /* return = beta * marketPremium + riskFreeRate + idiosyncraticPremium + countryPremium */
	private double stockValue; /* stockValue = stockValue * (1 + return) */
	
	
	
	public Stock(String name) {
		stockName = name;
	}
	
	
	
	public String getStockName() {
		return stockName;
	}
	public double getRiskFreeRate() {
		return riskFreeRate;
	}
	public double getBeta() {
		return beta;
	}
	public double getMarketPremium() {
		return marketPremium;
	}
	public double getIdiosyncraticPremium() {
		return idiosyncraticPremium;
	}
	public double getCountryPremium() {
		return countryPremium;
	}
	public double getReturnValue() {
		return returnValue;
	}
	public double getStockValue() {
		return stockValue;
	}
	
	
	
	public void stockInitiation() {
		Random rd = new Random();
		riskFreeRate = 2.25 + rd.nextGaussian() * 0.625; /* Distribution of riskFreeRate conforms to G(2.25, 0.625) */
		beta = 1.5 + rd.nextGaussian() * 0.75; /* Distribution of beta conforms to G(1.5, 0.75) */
		marketPremium = 0.065 + rd.nextGaussian() * 0.035; /* Distribution of marketPremium conforms to G(0.065, 0.035) */
		idiosyncraticPremium = rd.nextGaussian() * 0.075; /* Distribution of idiosyncraticPremium conforms to G(0, 0.075) */
		countryPremium = 0.025 + rd.nextGaussian() * 0.0125; /* Distribution of countryPremium conforms to G(0.025, 0.0125) */
		returnValue = 0.0;
		stockValue = Math.max(10.0, rd.nextDouble() * 1000); /* Generate initial stock value */
	}
	
	
	
	public void turnSimulation() {
		Random rd = new Random();
		returnValue = (beta * marketPremium + riskFreeRate + idiosyncraticPremium + countryPremium) * (1 + rd.nextGaussian() * 0.05);
		stockValue = stockValue * (1 + returnValue);
		riskFreeRate = riskFreeRate * (1 + rd.nextGaussian() * 0.05);
		beta = beta * (1 + rd.nextGaussian() * 0.05);
		marketPremium = marketPremium * (1 + rd.nextGaussian() * 0.05);
		idiosyncraticPremium = idiosyncraticPremium * (1 + rd.nextGaussian() * 0.05);
		countryPremium = countryPremium * (1 + rd.nextGaussian() * 0.05);
	}
	
}
