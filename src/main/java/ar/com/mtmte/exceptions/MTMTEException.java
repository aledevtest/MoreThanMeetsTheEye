package ar.com.mtmte.exceptions;

public class MTMTEException extends RuntimeException {

	public MTMTEException() {
		super();
	}

	public MTMTEException(String message, Throwable cause) {
		super(message, cause);
	}

	public MTMTEException(String message) {
		super(message);
	}

	public MTMTEException(Throwable cause) {
		super(cause);
	}

	/** serialVersionUID */
	private static final long serialVersionUID = -8440242382003543298L;

}
