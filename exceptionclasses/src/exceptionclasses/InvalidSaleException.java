package exceptionclasses;

public class InvalidSaleException extends RuntimeException {
	public InvalidSaleException(String message) {
		super(message);
	}
}
