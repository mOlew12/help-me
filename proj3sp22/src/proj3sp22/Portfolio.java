package proj3sp22;
import queues.*;
import exceptionclasses.*;

public class Portfolio {
	private LinkedQueue<Stock> [] companyQueues;
	private int numCompanies;
	private SymbolTable symbols;
	private double gainLoss;

	/**
	 * Constructor name: Parameterized Portfolio constructor
	 * Constructor description: utilizes a SymbolTable object to create a Portfolio object that allows
	 * the company name to be present in the object
	 */
	@SuppressWarnings("unchecked")
	public Portfolio(SymbolTable symbols) 
	{
		this.symbols = symbols;
		companyQueues = new LinkedQueue [15];
		numCompanies = 0;
	}
	
	/**
	 * method name: findCompany
	 * method description: accepts a ticker symbol and returns the 
	 * corresponding queue for the specified company in the companyQueues array
	 * @param ticker symbol that is being searched
	 * @return the corresponding queue for the specified company in the companyQueues array
	 */
	private int findCompany(String ticker) throws EmptyQueueException
	{
		for(int i = 0; i < numCompanies; i++) 
		{
			if(companyQueues[i].front().getTickerSymbol().equals(ticker))
			{
				return i;
			}
		}
		return -1;
	}

	/**
	 * method name: processTransaction
	 * method description: 
	 * @param char transaction - determines whether the stock is being bought or sold
	 * @param int numStocks - number of stocks being bought or sold
	 * @param double stockPrice - price of the stocks being bought or sold
	 * @param String tickerSymbol - the company's ticker symbol that is buying or selling the stock
	 */
	public void processTransaction(char transaction, int numStocks, double stockPrice, String tickerSymbol) throws EmptyQueueException
	{
		//theStock will be used to determine where in the companyQueues array theStock will be stored
		int theStock = findCompany(tickerSymbol);
		//tempStock is the stock that is currently being bought/sold
		Stock tempStock = new Stock(numStocks, stockPrice, tickerSymbol);
		//if buying a stock
		if (transaction == 'b') 
		{
			//if the stock is not registered yet
			if(theStock == -1) 
			{
				//store stock into companyQueues array
				System.out.println();
				companyQueues[numCompanies].enqueue(tempStock);
				numCompanies++;
			}
			//if the stock is already registered
			else 
			{
				companyQueues[theStock].enqueue(tempStock);
			}
		}
		//if selling a stock
		else 
		{
			//throw InvalidSaleException if there is no stock to be sold
			if(theStock == -1)
				throw new InvalidSaleException("ticker symbol not found");
			//used to add the total number of shares of a stock
			int totalShares = 0;
			for(int i =0; i < companyQueues[theStock].size(); i++) 
			{
				totalShares += companyQueues[theStock].front().getSharesOwned();
				companyQueues[theStock].enqueue(companyQueues[theStock].dequeue());
			}
			if(numStocks > totalShares) 
			{
				throw new InvalidSaleException("Not enought stocks to sell");
			}
			
			//will be used with the getSharesOwned method in the Stock class to store the current shares of a stock
			int tempSharesOwned = 0;
			//will be used with the getPurchasePrice method in the Stock class to store the current bought price of a stock
			double boughtPrice = 0.0;
			while(numStocks > 0) {
				tempSharesOwned = companyQueues[theStock].front().getSharesOwned();
				boughtPrice = companyQueues[theStock].front().getPurchasePrice();
				//if what is being sold is more than a single buy
				if(numStocks > tempSharesOwned) {
					gainLoss += tempSharesOwned * (stockPrice - boughtPrice);
					companyQueues[theStock].dequeue();
					numStocks -= tempSharesOwned;
				}
				else {
					companyQueues[theStock].front().setSharesOwned(tempSharesOwned - numStocks);
					gainLoss += (numStocks) * (stockPrice - boughtPrice);
					numStocks = 0;
				}
				//if the companyQueue is empty, reduce numCompanies
				if(companyQueues[theStock].isEmpty())
					numCompanies--;
			}
		}
		


	}

	/**
	 * method name: toString
	 * method description: return the current state of the Portfolio object with 
	 * appropriate labels
	 * @return the current state of the Portfolio object
	 */
	public String toString()
	{
		String str = "Profit: " + gainLoss + " | Number of Companies: " + numCompanies;
		for(int i = 0; i < numCompanies; i++) 
		{
			try 
			{
				str += "\nCompany Name: " + symbols.findCompany(companyQueues[i].front().getTickerSymbol()) +"\n"+ companyQueues[i].toString();
			} 
			catch (EmptyQueueException ex) 
			{

			}
		}
		return str + "\n";
	}
}
