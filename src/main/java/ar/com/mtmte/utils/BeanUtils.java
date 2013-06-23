package ar.com.mtmte.utils;

import ar.com.mtmte.exceptions.BeanUtilsException;

public class BeanUtils {

	public static void copyProperties(Object dest, Object origin) {
		try {
			org.apache.commons.beanutils.BeanUtils.copyProperties(dest, origin);
		} catch (Throwable e) {
			throw new BeanUtilsException(e);
		}
	}

}
