package ar.com.mtmte.core.model.transformation;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import ar.com.mtmte.core.model.Instance;
import ar.com.mtmte.core.model.Property;
import ar.com.mtmte.core.test1.Entity1A;

public class DefaultPropertyTransformationTest {

	private static final String SOME_NAME = "someName";

	@Test
	public void testDefaultPropertyTransformation() {
		Property nameProperty = new Property("name");

		DefaultPropertyTransformation defaultPropertyTransformation = new DefaultPropertyTransformation(nameProperty);
		
		Entity1A entity1a = new Entity1A();
		entity1a.setName(SOME_NAME);
		
		Instance originInstance = new Instance(entity1a);
		Instance destinationInstance = new Instance(new HashMap<String, Object>());
		defaultPropertyTransformation.apply(originInstance, destinationInstance);
		
		assertEquals(SOME_NAME, destinationInstance.getValue(nameProperty).getEnclosingValue());
	}
}
