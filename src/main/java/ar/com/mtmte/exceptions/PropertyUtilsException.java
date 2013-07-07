package ar.com.mtmte.exceptions;

/**
 * @author Alejandro Zalazar <alejandrozalazar@gmail.com> Master property utils
 *         exception
 */
public class PropertyUtilsException extends MTMTEException {

	/** serialVersionUID */
	private static final long serialVersionUID = -2083145942098186887L;

	/**
	 * @see MTMTEException#MTMTEException()
	 */
	public PropertyUtilsException() {
		super();
	}

	/**
	 * @see MTMTEException#MTMTEException(String, Throwable)
	 */
	public PropertyUtilsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @see MTMTEException#MTMTEException(String)
	 */
	public PropertyUtilsException(String message) {
		super(message);
	}

	/**
	 * @see MTMTEException#MTMTEException(Throwable)
	 */
	public PropertyUtilsException(Throwable cause) {
		super(cause);
	}
}
