package ar.com.mtmte.exceptions;

/**
 * @author Alejandro Zalazar <alejandrozalazar@gmail.com> Master bean utils
 *         exception
 */
public class BeanUtilsException extends MTMTEException {

	/** serialVersionUID */
	private static final long serialVersionUID = 7007026398557357674L;

	/**
	 * @see MTMTEException#MTMTEException()
	 */
	public BeanUtilsException() {
		super();
	}

	/**
	 * @see MTMTEException#MTMTEException(String, Throwable)
	 */
	public BeanUtilsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @see MTMTEException#MTMTEException(String)
	 */
	public BeanUtilsException(String message) {
		super(message);
	}

	/**
	 * @see MTMTEException#MTMTEException(Throwable)
	 */
	public BeanUtilsException(Throwable cause) {
		super(cause);
	}
}
