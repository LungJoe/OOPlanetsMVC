package Exceptions;

public class InvalidTemperatureException extends RuntimeException {
	
	public InvalidTemperatureException() {
		super("Invalid Planet Temperature in C");
	}
	
	public String getMessage(){
		return "Invalid Planet Temperature in C";
	}
}