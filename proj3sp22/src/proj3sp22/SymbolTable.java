package proj3sp22;
import java.util.*;
import java.io.*;

public class SymbolTable {
	private SymbolPair[] symbolPairs;
	private int numSymbols;
	
	/**
	 * Constructor name: Parameterized SymbolTable constructor
	 * Constructor description: reads input from a file and stores the info into a SymbolPair array
	 */
	public SymbolTable(File file) throws FileNotFoundException {
		Scanner fileScan = new Scanner(file);
		symbolPairs = new SymbolPair[15];
		for(int i = 0; i < symbolPairs.length; i++) 
		{
			symbolPairs[i] = new SymbolPair(fileScan.next(), fileScan.nextLine());
			numSymbols++;
		}
		fileScan.close();
	}
	
	/**
	 * method name: findCompany
	 * method description: accepts a ticker symbol and returns the 
	 * corresponding company name
	 * @param ticker symbol that is being searched
	 * @return the company name with the corresponding ticker symbol
	 */
	public String findCompany(String ticker)
	{
		for(int i = 0; i < numSymbols; i++) 
		{
			if(ticker.equals(symbolPairs[i].getTickerSymbol()))
				return symbolPairs[i].getCompanyName();
		}
		return "Company not found.";
	}
	
	/**
	 * method name: getNumSymbols
	 * method description: return the value stored in the instance variable numSymbols
	 * @return the value stored in numSymbols
	 */
	public int getNumSymbols() 
	{
		return numSymbols;
	}
	
	/**
	 * method name: toString
	 * method description: return the current state of the SymbolTable object with 
	 * appropriate labels
	 * @return the current state of the SymbolTable object
	 */
	public String toString() 
	{
		String str = "";
		for(int i = 0; i < numSymbols; i++) 
		{
			str += symbolPairs[i].toString() + "\n";
		}
		return str;
	}
}


