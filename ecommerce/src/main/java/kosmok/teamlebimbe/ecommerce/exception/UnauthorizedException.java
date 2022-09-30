package kosmok.teamlebimbe.ecommerce.exception;

public class UnauthorizedException extends RuntimeException {

	private static final long serialVersionUID = -1895585950377091319L;

	public UnauthorizedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnauthorizedException(String message) {
		super(message);
	}

	
	
}
