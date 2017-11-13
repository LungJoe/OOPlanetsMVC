package Exceptions;

public class InvalidMoonException extends RuntimeException {
	
	public InvalidMoonException() {
		super("Invalid Number of Moons");
	}
}