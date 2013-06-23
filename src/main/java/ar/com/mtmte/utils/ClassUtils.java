package ar.com.mtmte.utils;

import ar.com.mtmte.exceptions.ClassUtilsException;

public class ClassUtils {

	public static Object newInstance(Class<?> class1) {
		try {
			return class1.newInstance();
		} catch (Throwable e) {
			throw new ClassUtilsException(e);
		}
	}

}
