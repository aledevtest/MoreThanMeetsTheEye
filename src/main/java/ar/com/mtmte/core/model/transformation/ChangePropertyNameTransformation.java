package ar.com.mtmte.core.model.transformation;

import ar.com.mtmte.core.model.Property;
import ar.com.mtmte.core.model.PropertyTransformation;

public class ChangePropertyNameTransformation extends PropertyTransformation {

	protected final String destinationPropertyName;

	public ChangePropertyNameTransformation(String originPropertyName, String destinationPropertyName) {
		super(new Property(originPropertyName));
		this.destinationPropertyName = destinationPropertyName;
	}

	@Override
	protected Property getDestinationProperty() {
		return new Property(destinationPropertyName);
	}
	
	@Override
	public String toString() {
		return "Transform from: " + originProperty.getName() + " to: " + getDestinationProperty().getName();
	}
}
