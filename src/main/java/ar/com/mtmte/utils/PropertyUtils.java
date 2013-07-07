package ar.com.mtmte.utils;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.mtmte.core.model.Property;
import ar.com.mtmte.exceptions.PropertyUtilsException;

public class PropertyUtils {

	@SuppressWarnings("rawtypes")
	public static Collection<Property> getProperties(Class type) {
		try {
			PropertyDescriptor[] propertyDescriptors = org.apache.commons.beanutils.PropertyUtils.getPropertyDescriptors(type);
			Collection<Property> properties = new ArrayList<Property>();
			for (PropertyDescriptor propertyDescriptor: propertyDescriptors) {
				properties.add(new Property(propertyDescriptor.getName()));
			}
			return properties;
		} catch (Throwable e) {
			throw new PropertyUtilsException(e);
		}
	}

	public static Collection<String> getPropertyNames(Class type) {
		try {
			PropertyDescriptor[] propertyDescriptors = org.apache.commons.beanutils.PropertyUtils.getPropertyDescriptors(type);
			Collection<String> propertyNames = new ArrayList<String>();
			for (PropertyDescriptor propertyDescriptor: propertyDescriptors) {
				propertyNames.add(propertyDescriptor.getName());
			}
			return propertyNames;
		} catch (Throwable e) {
			throw new PropertyUtilsException(e);
		}
	}

}
