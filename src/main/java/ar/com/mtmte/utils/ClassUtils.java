package ar.com.mtmte.utils;

import ar.com.mtmte.exceptions.ClassUtilsException;

/**
 * @author Alejandro Zalazar <alejandrozalazar@gmail.com>
 * 
 *         Implements some class + reflection methods wrapping the exceptions
 *         with runtime mtmte exceptions
 */
public class ClassUtils {

	public static Object newInstance(Class<?> class1) {
		try {
			return class1.newInstance();
		} catch (Throwable e) {
			throw new ClassUtilsException(e);
		}
	}

}
