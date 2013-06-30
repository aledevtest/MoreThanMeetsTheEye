package ar.com.mtmte.exceptions;

/**
 * @author Alejandro Zalazar <alejandrozalazar@gmail.com> Master exception
 */
public class MTMTEException extends RuntimeException {

	/**
	 * @see RuntimeException#RuntimeException()
	 */
	public MTMTEException() {
		super();
	}

	/**
	 * @see RuntimeException#RuntimeException(String, Throwable)
	 */
	public MTMTEException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @see RuntimeException#RuntimeException(String)
	 */
	public MTMTEException(String message) {
		super(message);
	}

	/**
	 * @see RuntimeException#RuntimeException(Throwable)
	 */
	public MTMTEException(Throwable cause) {
		super(cause);
	}

	/** serialVersionUID */
	private static final long serialVersionUID = -8440242382003543298L;

}
