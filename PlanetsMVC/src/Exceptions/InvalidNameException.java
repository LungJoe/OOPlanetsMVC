package Exceptions;

public class InvalidNameException extends RuntimeException {
	
	
	public InvalidNameException() {
		super("Invalid Planet Name");
		
	}
	public String getMessages(){
		return "Invalid Planet Name";
	}
}