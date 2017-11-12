package Exceptions;

public class InvalidMoonException extends RuntimeException {
	
	public InvalidMoonException() {
		super("Invalid Number of Moons");
	}
	
	public String getMessage(){
		return "Invalid Number of Moons";
	}
	
}
