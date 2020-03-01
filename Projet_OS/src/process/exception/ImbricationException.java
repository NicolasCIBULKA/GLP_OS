package process.exception;

public class ImbricationException extends Exception{
	/*
	 * This class contains is the exception if we find an loop imbrication in the programms
	 * 
	 * @Author Nicolas CIBULKA
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	// --------------------------------------
	// Attributs
	// --------------------------------------
	
	// --------------------------------------
	// Methods
	// --------------------------------------
	
	
	public ImbricationException() {
		super("Imbrication of loops or tests in the programm\n");
	}
	
	
}
