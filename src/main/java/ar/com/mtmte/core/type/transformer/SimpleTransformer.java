package ar.com.mtmte.core.type.transformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.mtmte.core.FieldTransformer;
import ar.com.mtmte.core.Transformer;
import ar.com.mtmte.core.field.transformer.AddFieldTransformer;
import ar.com.mtmte.core.field.transformer.ChangedNameFieldTransformer;
import ar.com.mtmte.core.field.transformer.SinglePropertyFieldTransformer;

public class SimpleTransformer implements Transformer {
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
	public void define(final String propertyName) {
		fieldTransformations.add(new SinglePropertyFieldTransformer(propertyName));
	}

	@Override
	public void define(final String originPropertyName,
			final String destinationPropertyName) {
			fieldTransformations.add(new ChangedNameFieldTransformer(originPropertyName,
					destinationPropertyName));
	}

	@Override
	public void defineCreation(String newFieldName, Object defaultValue) {
		fieldTransformations.add(new AddFieldTransformer(newFieldName,
				defaultValue));
	}
}