package ar.com.mtmte.utils;

import ar.com.mtmte.exceptions.BeanUtilsException;

/**
 * @author Alejandro Zalazar <alejandrozalazar@gmail.com>
 * 
 *         Implements some bean utils methods wrapping the exceptions with
 *         runtime mtmte exceptions
 */
public class BeanUtils {

	public static void copyProperties(Object dest, Object origin) {
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(dest, origin);
		} catch (Throwable e) {
			throw new BeanUtilsException(e);
		}
	}

	public static String getProperty(Object object, String originPropertyName) {
		try {
			return org.apache.commons.beanutils.BeanUtils.getProperty(object, originPropertyName);
		} catch (Throwable e) {
			throw new BeanUtilsException(e);
		}
	}

	public static void setProperty(Object object, String destinationPropertyName, Object propertyValue) {
		try {
			org.apache.commons.beanutils.BeanUtils.setProperty(object, destinationPropertyName, propertyValue);
		} catch (Throwable e) {
			throw new BeanUtilsException(e);
		}
	}

}
