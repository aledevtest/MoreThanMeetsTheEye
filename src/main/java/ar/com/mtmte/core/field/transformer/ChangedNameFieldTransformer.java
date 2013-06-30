package ar.com.mtmte.core.field.transformer;

import ar.com.mtmte.core.FieldTransformer;
import ar.com.mtmte.utils.BeanUtils;

public class ChangedNameFieldTransformer implements
		FieldTransformer {
	private final String originPropertyName;
	private final String destinationPropertyName;

	public ChangedNameFieldTransformer(String originPropertyName,
			String destinationPropertyName) {
		this.originPropertyName = originPropertyName;
		this.destinationPropertyName = destinationPropertyName;
	}

	@Override
	public String getOriginPropertyName() {
		return originPropertyName;
	}

	@Override
	public String getDestinationPropertyName() {
		return destinationPropertyName;
	}
	
	@Override
	public void applyTransformation(Object origin,
			Object destination) {
		String propertyValue = BeanUtils.getProperty(origin, getOriginPropertyName());
		BeanUtils.setProperty(destination, getDestinationPropertyName(), propertyValue);
	}
}