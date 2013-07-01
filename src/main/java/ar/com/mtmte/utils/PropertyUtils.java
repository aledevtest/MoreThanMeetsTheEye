package ar.com.mtmte.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import ar.com.mtmte.core.model.Instance;
import ar.com.mtmte.core.model.Property;
import ar.com.mtmte.exceptions.PropertyUtilsException;

public class PropertyUtils {

	public static Collection<Property> getProperties(Instance originInstance) {
		try {
			Set propertyNames = BeanUtils.describe(originInstance.getInstance()).keySet();
			Collection<Property> properties = new ArrayList<Property>();
			for (Iterator iterator = propertyNames.iterator(); iterator.hasNext();) {
				String propertyName = (String) iterator.next();
				properties.add(new Property(propertyName));
			}
			return properties;
		} catch (Throwable e) {
			throw new PropertyUtilsException(e);
		}
	}

}
