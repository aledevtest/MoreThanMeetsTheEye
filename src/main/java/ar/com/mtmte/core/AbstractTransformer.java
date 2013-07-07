package ar.com.mtmte.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.mtmte.core.model.Instance;
import ar.com.mtmte.core.model.PropertyTransformation;
import ar.com.mtmte.core.model.Type;
import ar.com.mtmte.core.model.transformation.ChangePropertyNameTransformation;
import ar.com.mtmte.core.model.transformation.DefaultPropertyTransformation;
import ar.com.mtmte.core.model.transformation.NewPropertyTransformation;
import ar.com.mtmte.utils.PropertyUtils;
import ar.com.mtmte.utils.TransformerUtils;

public abstract class AbstractTransformer implements Transformer {

	protected Map<String, PropertyTransformation> alternativePropertyTransformations = new HashMap<String, PropertyTransformation>();
	protected Map<String, PropertyTransformation> alternativeDestinationPropertyTransformations = new HashMap<String, PropertyTransformation>();
	

	public Object transform(Object object, Class transformedType) {

		if (object == null) {
			return null;
		}

		Type objectOriginType = getOriginType() != null ? getOriginType() : new Type(object.getClass());
		Instance originInstance = objectOriginType.createInstance(object);

		Type destinationType = transformedType != null ? new Type(transformedType) : getDestinationType();
		Instance destinationInstance = destinationType.createInstance();

		transformType(originInstance, destinationInstance);

		return destinationInstance.getInstance();
	}

	@Override
	public Object transform(Object object) {
		Type destinationType = getDefaultDestinationType();
		return transform(object, destinationType.getEnclosingType());
	}

	private Type getDefaultDestinationType() {
		return new Type(TransformerUtils.getDefaultInstanceType());
	}

	protected void transformType(Instance originInstance, Instance destinationInstance) {
		List<PropertyTransformation> propertyTransformations = getPropertyTransformations(originInstance, destinationInstance);
		for (PropertyTransformation propertyTransformation : propertyTransformations) {
			propertyTransformation.apply(originInstance, destinationInstance);
		}
	}

	protected List<PropertyTransformation> getPropertyTransformations(Instance originInstance, Instance destinationInstance) {
		Collection<String> propertyNames = PropertyUtils.getPropertyNames(originInstance.getType().getEnclosingType());
		List<PropertyTransformation> propertyTransformations = new ArrayList<PropertyTransformation>();
		for (String propertyName : propertyNames) {
			PropertyTransformation transformation = alternativePropertyTransformations.get(propertyName);
			if(transformation!=null) {
				propertyTransformations.add(transformation);				
			} else {
				propertyTransformations.add(new DefaultPropertyTransformation(propertyName));
			}
		}
		
		for (PropertyTransformation propertyTransformation : alternativePropertyTransformations.values()) {
			propertyTransformations.add(propertyTransformation);
		}
		
		for (PropertyTransformation propertyTransformation : alternativeDestinationPropertyTransformations.values()) {
			propertyTransformations.add(propertyTransformation);
		}
		
		return propertyTransformations;
	}

	protected Type getOriginType() {
		return null;
	}

	protected Type getDestinationType() {
		return null;
	}

	public void defineSimpleField(final String propertyName) {
		alternativePropertyTransformations.put(propertyName, new DefaultPropertyTransformation(propertyName));
	}

	public void defineField(final String originPropertyName, final String destinationPropertyName) {
		alternativePropertyTransformations.put(originPropertyName, new ChangePropertyNameTransformation(originPropertyName, destinationPropertyName));
	}

	public void defineNewField(String newFieldName, Object defaultValue) {
		alternativeDestinationPropertyTransformations.put(newFieldName, new NewPropertyTransformation(newFieldName, defaultValue));
	}
}
