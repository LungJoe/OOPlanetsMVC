package Exceptions;

public class InvalidDiameterException extends RuntimeException {
	
	public InvalidDiameterException() {
		super("Invalid Planet Diameter in KM");
	}
	
	public String getMessage(){
		return "Invalid Planet Diameter in KM";
	}
}
