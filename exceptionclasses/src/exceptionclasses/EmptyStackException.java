package exceptionclasses;

/**
 * <p>Title: EmptyStackException Class</p>
 * @author <Mike Olewnicki + Lillian Celleri>
 */

public class EmptyStackException extends RuntimeException 
{
	public EmptyStackException() 
	{
		super("ArrayStack collection is empty.\n");
	}
}