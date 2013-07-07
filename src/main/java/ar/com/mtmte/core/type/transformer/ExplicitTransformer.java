package ar.com.mtmte.core.type.transformer;

import ar.com.mtmte.core.AbstractTransformer;
import ar.com.mtmte.core.DefinedTransformer;
import ar.com.mtmte.core.model.Type;

public class ExplicitTransformer extends AbstractTransformer implements DefinedTransformer {
	private final Type destinationType;
	private final Type originType;
	
	public ExplicitTransformer(Class originType, Class destinationType) {
		this.originType = new Type(originType);
		this.destinationType = new Type(destinationType);
	}
	
	@Override
	protected Type getOriginType() {
		return originType;
	}

	@Override
	protected Type getDestinationType() {
		return destinationType;
	}

//	@Override
//	protected List<PropertyTransformation> getPropertyTransformations(Instance originInstance, Instance destinationInstance) {
//		List<PropertyTransformation> propertyTransformations = new ArrayList<PropertyTransformation>();
//		for (PropertyTransformation propertyTransformation : alternativeDestinationPropertyTransformations.values()) {
//			propertyTransformations.add(propertyTransformation);
//		}
//		
//		return propertyTransformations;
//	}
}