package ar.com.mtmte.exceptions;

/**
 * @author Alejandro Zalazar <alejandrozalazar@gmail.com> Master class utils
 *         exception
 */
public class ClassUtilsException extends MTMTEException {

	/** serialVersionUID */
	private static final long serialVersionUID = -2083145942098186887L;

	/**
	 * @see MTMTEException#MTMTEException()
	 */
	public ClassUtilsException() {
		super();
	}

	/**
	 * @see MTMTEException#MTMTEException(String, Throwable)
	 */
	public ClassUtilsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @see MTMTEException#MTMTEException(String)
	 */
	public ClassUtilsException(String message) {
		super(message);
	}

	/**
	 * @see MTMTEException#MTMTEException(Throwable)
	 */
	public ClassUtilsException(Throwable cause) {
		super(cause);
	}
}
