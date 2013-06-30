package ar.com.mtmte.core.type.transformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.mtmte.core.DefinedTransformer;
import ar.com.mtmte.core.FieldTransformer;
import ar.com.mtmte.core.field.transformer.AddFieldTransformer;
import ar.com.mtmte.core.field.transformer.EditFieldTransformer;
import ar.com.mtmte.core.field.transformer.ReadPropertyFieldTransformer;

public class ExplicitTransformer implements DefinedTransformer {
	private List<FieldTransformer> fieldTransformations = new ArrayList<FieldTransformer>();

	@Override
	public Object transform(Object object) {
		Map<String, Object> transformedValue = new HashMap<String, Object>();

		for (FieldTransformer fieldTransformation : fieldTransformations) {
			fieldTransformation.applyTransformation(object, transformedValue);
		}

		return transformedValue;
	}

	@Override
	public void defineSimpleField(final String propertyName) {
		fieldTransformations.add(new ReadPropertyFieldTransformer(propertyName));
	}

	@Override
	public void defineField(final String originPropertyName, final String destinationPropertyName) {
		fieldTransformations.add(new EditFieldTransformer(originPropertyName, destinationPropertyName));
	}

	@Override
	public void defineNewField(String newFieldName, Object defaultValue) {
		fieldTransformations.add(new AddFieldTransformer(newFieldName, defaultValue));
	}
}