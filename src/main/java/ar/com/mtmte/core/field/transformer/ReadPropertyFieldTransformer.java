package ar.com.mtmte.core.field.transformer;

import ar.com.mtmte.core.FieldTransformer;
import ar.com.mtmte.utils.BeanUtils;

public class ReadPropertyFieldTransformer implements FieldTransformer {
	private final String propertyName;

	public ReadPropertyFieldTransformer(String propertyName) {
		this.propertyName = propertyName;
	}

	@Override
	public String getOriginPropertyName() {
		return propertyName;
	}

	@Override
	public String getDestinationPropertyName() {
		return propertyName;
	}

	@Override
	public void applyTransformation(Object origin, Object destination) {
		String propertyValue = BeanUtils.getProperty(origin, getOriginPropertyName());
		BeanUtils.setProperty(destination, getDestinationPropertyName(), propertyValue);
	}

}