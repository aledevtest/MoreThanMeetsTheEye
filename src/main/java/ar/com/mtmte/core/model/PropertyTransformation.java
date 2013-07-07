package ar.com.mtmte.core.model;

public abstract class PropertyTransformation {

	protected final Property originProperty;
	
	public PropertyTransformation(Property originProperty) {
		this.originProperty = originProperty;
	}
	
	public void apply(Instance originInstance, Instance destinationInstance) {
		Value originValue = getOriginValue(originInstance);
		
		Value destinationValue = transform(originValue);
		
		Property destinationProperty = getDestinationProperty();
		
		setDestinationValue(destinationInstance, destinationValue, destinationProperty);
	}

	protected void setDestinationValue(Instance destinationInstance, Value destinationValue, Property destinationProperty) {
		destinationInstance.setValue(destinationProperty, destinationValue);
	}

	protected Value getOriginValue(Instance originInstance) {
		return originInstance.getValue(getOriginProperty());
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
