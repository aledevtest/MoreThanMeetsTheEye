package ar.com.mtmte.core;

import java.util.List;

import ar.com.mtmte.core.model.Instance;
import ar.com.mtmte.core.model.PropertyTransformation;
import ar.com.mtmte.core.model.Type;

public abstract class AbstractTransformer implements Transformer {

	@Override
	public Object transform(Object object) {
		Instance originInstance = getOriginType()!=null?getOriginType().createInstance(object):new Instance(object);
		Type destinationType = getDestinationType();
		Instance destinationInstance = destinationType.createInstance();
		
		transformType(originInstance, destinationInstance);
		
		return destinationInstance.getInstance();
	}

	protected void transformType(Instance originInstance, Instance destinationInstance) {
		List<PropertyTransformation> propertyTransformations = getPropertyTransformations(originInstance, destinationInstance);
		for (PropertyTransformation propertyTransformation : propertyTransformations) {
			propertyTransformation.apply(originInstance, destinationInstance);
		}
	}

	protected abstract List<PropertyTransformation> getPropertyTransformations(Instance originInstance, Instance destinationInstance);

	protected abstract Type getOriginType();

	protected abstract Type getDestinationType();

}
