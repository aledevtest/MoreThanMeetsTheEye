package ar.com.mtmte.core.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ar.com.mtmte.core.test1.Entity1A;

public class InstanceTest {

	private static final String SOME_NAME = "someName";
	private static final Object someObject = "object";

	@Test
	public void testInstanceCreationShouldHoldAndReturnAPassedObject() {
		Instance instance = new Instance(someObject);
		Object returnedInstance = instance.getInstance();
		assertEquals(returnedInstance, someObject);
	}
	
	@Test
	public void testInstanceSetPropertyValueShouldSetPropertyValueOnEnclosingInstance() {
		Entity1A entity1a = new Entity1A();
		
		Instance instance = new Instance(entity1a);
		
		assertNull(entity1a.getName());
		
		Property property = new Property("name");
		instance.setValue(property, new Value(SOME_NAME));
		
		assertEquals(SOME_NAME, entity1a.getName());
		
	}
	
	@Test
	public void testInstanceGetPropertyValueShouldReturnPropertyValueOfTheEnclosingInstance() {
		Entity1A entity1a = new Entity1A();
		
		Instance instance = new Instance(entity1a);
		
		entity1a.setName(SOME_NAME);
		
		Property property = new Property("name");
		Value value = instance.getValue(property);
		
		assertNotNull(value);
		assertEquals(SOME_NAME, value.getEnclosingValue());
		
	}
}
