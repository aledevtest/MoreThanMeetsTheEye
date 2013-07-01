package ar.com.mtmte.core.model;

public abstract class PropertyTransformation {

	private final Property originProperty;
	
	public PropertyTransformation(Property originProperty) {
		this.originProperty = originProperty;
	}
	
	public void apply(Instance originInstance, Instance destinationInstance) {
		Value originValue = originInstance.getValue(getOriginProperty());
		
		Value destinationValue = transform(originValue);
		
		Property destinationProperty = getDestinationProperty();
		
		destinationInstance.setValue(destinationProperty, destinationValue);
	}

	protected Property getDestinationProperty() {
		return getOriginProperty();
	}

	protected Value transform(Value originValue) {
		return originValue;
	}

	public Property getOriginProperty() {
		return originProperty;
	}

}
