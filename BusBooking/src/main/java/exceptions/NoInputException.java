package exceptions;

public class NoInputException extends Exception{
	public NoInputException() {
		super("Input should not be empty");
	}
}
