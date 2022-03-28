package proj3sp22;

public class Stock {
	private String tickerSym;
	private int sharesOwned;
	private double purchasePrice;
	
	/**
	 * Constructor name: Parameterized Stock constructor
	 * Constructor description: initializes all instance variables to a specified value
	 */
	public Stock(int sharesOwned, double purchasePrice, String tickerSym) {
		this.sharesOwned = sharesOwned;
		this.purchasePrice = purchasePrice;
		this.tickerSym = tickerSym;
	}
	
	/**
	 * method name: getTickerSymbol
	 * method description: return the value stored in the instance variable tickerSym
	 * @return the value stored in tickerSym
	 */
	public String getTickerSymbol() 
	{
		return tickerSym;
	}
	
	/**
	 * method name: getSharesOwned
	 * method description: return the value stored in the instance variable sharesOwned
	 * @return the value stored in sharesOwned
	 */
	public int getSharesOwned() 
	{
		return sharesOwned;
	}
	
	/**
	 * method name: getPurchasePrice
	 * method description: return the value stored in the instance variable purchasePrice
	 * @return the value stored in purchasePrice
	 */
	public double getPurchasePrice() 
	{
		return purchasePrice;
	}
	
	/**
	 * method name: setSharesOwned
	 * method description: set the value stored in the instance variable sharesOwned
	 * @param the value that will be stored in sharesOwned
	 */
	public void setSharesOwned(int val) 
	{
		sharesOwned = val;
	}
	
	/**
	 * method name: toString
	 * method description: return the current state of the Stock object with 
	 * appropriate labels
	 * @return the current state of the Stock object
	 */
	public String toString() {
		return "Ticker Symbol: " + tickerSym + " Shares Owned: " + sharesOwned + " Purchase price: " + purchasePrice;
	}
}
