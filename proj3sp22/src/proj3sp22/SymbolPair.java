package proj3sp22;

public class SymbolPair {
	private String tickerSym;
	private String companyName;

	/**
	 * Constructor name: Parameterized SymbolPair constructor
	 * Constructor description: initializes all instance variables to a specified value
	 */
	public SymbolPair(String tickerSym, String companyName) 
	{
		this.tickerSym = tickerSym;
		this.companyName = companyName;
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
	 * method name: getCompanyName
	 * method description: return the value stored in the instance variable companyName
	 * @return the value stored in companyName
	 */
	public String getCompanyName() 
	{
		return companyName;
	}

	/**
	 * method name: toString
	 * method description: return the current state of the SymbolPair object with 
	 * appropriate labels
	 * @return the current state of the SymbolPair object
	 */
	public String toString() {
		return tickerSym + " |" + companyName;
	}
}
