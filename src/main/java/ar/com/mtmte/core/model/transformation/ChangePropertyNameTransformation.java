package ar.com.mtmte.core.model.transformation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ar.com.mtmte.core.model.Instance;
import ar.com.mtmte.core.model.Property;
import ar.com.mtmte.core.model.PropertyTransformation;
import ar.com.mtmte.utils.PropertyUtils;

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
