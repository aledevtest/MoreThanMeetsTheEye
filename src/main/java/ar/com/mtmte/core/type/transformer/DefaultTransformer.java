package ar.com.mtmte.core.type.transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import ar.com.mtmte.core.AbstractTransformer;
import ar.com.mtmte.core.model.Instance;
import ar.com.mtmte.core.model.Property;
import ar.com.mtmte.core.model.PropertyTransformation;
import ar.com.mtmte.core.model.Type;
import ar.com.mtmte.core.model.transformation.DefaultPropertyTransformation;
import ar.com.mtmte.utils.PropertyUtils;

public class DefaultTransformer extends AbstractTransformer {

	@Override
	protected List<PropertyTransformation> getPropertyTransformations(Instance originInstance, Instance destinationInstance) {
		Collection<Property> properties = PropertyUtils.getProperties(originInstance);
		List<PropertyTransformation> propertyTransformations = new ArrayList<PropertyTransformation>();
		for (Property property : properties) {
			propertyTransformations.add(new DefaultPropertyTransformation(property));
		}
		return propertyTransformations;
	}

	@Override
	protected Type getOriginType() {
		return null;
	}

	@Override
	protected Type getDestinationType() {
		return new Type(HashMap.class);
	}

}
