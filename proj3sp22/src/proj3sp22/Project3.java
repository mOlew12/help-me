package proj3sp22;
import java.io.*;
import java.util.Scanner;
import exceptionclasses.EmptyQueueException;
import exceptionclasses.InvalidSaleException;

public class Project3 {
	public static void main (String [] args) throws Exception 
	{
		//creating a file object with symboldata.txt's contents and passing it to the SymbolTable constructor
		File myFile = new File("symboldata.txt");
		//declaring a SymbolTable object
		SymbolTable myTable = null;
		try 
		{
			//assigning the SymbolTable object with symboldata.txt's contents
			myTable = new SymbolTable(myFile);
			System.out.println(myTable.toString());
			System.out.println("Testing findCompany method on MSFT: " + myTable.findCompany("MSFT"));
			System.out.println("Testing findCompany method on ORCL: " + myTable.findCompany("ORCL"));
			System.out.println("Testing findCompany method on CSCO: " + myTable.findCompany("CSCO"));
		}
		catch(FileNotFoundException ex) 
		{
			System.out.println("FileNotFoundException: " + ex.getMessage());
		}
		//creating a Portfolio object and passing myTable as an argument to the constructor
		Portfolio myPort = new Portfolio(myTable);
		
		Scanner scnr = new Scanner(new File("stockdata.txt"));
		
		//creating an int variable that will keep track of the number of transactions being made
		int transactionNum = 1;
		//creating variables that will be used when reading from stockdata.txt
		char status;
		int stockAmt;
		double stockPrice;
		String tickerSymbol = new String();
		while(scnr.hasNextLine()) 
		{
			try {
				status = scnr.next().charAt(0);
				stockAmt = scnr.nextInt();
				stockPrice = scnr.nextDouble();
				tickerSymbol = scnr.nextLine();
				myPort.processTransaction(status, stockAmt, stockPrice, tickerSymbol);
				
				if(status == 'b') {
					System.out.println(transactionNum + " -- Bought: " + stockAmt + " " + stockPrice + " " + tickerSymbol);
				}
				else {
					System.out.println(transactionNum + " -- Sold: " + stockAmt + " " + stockPrice + " " + tickerSymbol);
				}
				transactionNum++;
			}
			catch(EmptyQueueException ex){
				System.out.println(transactionNum + "-- EmptyQueueException: " + ex.getMessage());
				transactionNum++;
			}
			catch(InvalidSaleException ex){
				System.out.println(transactionNum + "-- InvalidSaleException: " + ex.getMessage());
			}
		}
		System.out.println(myPort);
	}
}
