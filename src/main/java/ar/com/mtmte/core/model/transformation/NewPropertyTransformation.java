package ar.com.mtmte.core.model.transformation;

import ar.com.mtmte.core.model.Instance;
import ar.com.mtmte.core.model.Property;
import ar.com.mtmte.core.model.PropertyTransformation;
import ar.com.mtmte.core.model.Value;

public class NewPropertyTransformation extends PropertyTransformation {

	private final Value defaultValue;
	
	public NewPropertyTransformation(String propertyName, Object defaultValue) {
		super(new Property(propertyName));
		this.defaultValue = new Value(defaultValue);
	}

	@Override
	public void apply(Instance originInstance, Instance destinationInstance) {
		
		Property destinationProperty = getDestinationProperty();
		
		setDestinationValue(destinationInstance, defaultValue, destinationProperty);
	}
	
	@Override
	public String toString() {
		return "Transform from: " + "<Nothing>" + " to: " + getDestinationProperty().getName();
	}
}
