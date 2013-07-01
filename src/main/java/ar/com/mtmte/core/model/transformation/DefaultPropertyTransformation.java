package ar.com.mtmte.core.model.transformation;

import ar.com.mtmte.core.model.Property;
import ar.com.mtmte.core.model.PropertyTransformation;

/**
 * @author Alejandro Zalazar <alejandrozalazar@gmail.com>
 * 
 * Copies property value on the property of the receiving object which has the same name of the origin property
 * a.k.a. object2.propertyWithSomeName = object1.propertyWithSomeName
 */
public class DefaultPropertyTransformation extends PropertyTransformation {

	public DefaultPropertyTransformation(Property property) {
		super(property);
	}
}
