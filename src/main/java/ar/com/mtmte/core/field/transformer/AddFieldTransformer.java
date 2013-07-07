package ar.com.mtmte.core.field.transformer;

import ar.com.mtmte.core.FieldTransformer;
import ar.com.mtmte.utils.BeanUtils;

public class AddFieldTransformer implements FieldTransformer {

	private String newFieldName;
	private final Object defaultValue;

	public AddFieldTransformer(String newFieldName, Object defaultValue) {
		this.newFieldName = newFieldName;
		this.defaultValue = defaultValue;
	}

	@Override
	public String getOriginPropertyName() {
		return null;
	}

	@Override
	public String getDestinationPropertyName() {
		return newFieldName;
	}

	@Override
	public void applyTransformation(Object object, Object destination) {
		BeanUtils.setProperty(destination, getDestinationPropertyName(), defaultValue);
	}

}
