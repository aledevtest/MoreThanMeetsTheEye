package ar.com.mtmte.core;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import ar.com.mtmte.core.test1.Entity1A;
import ar.com.mtmte.core.test1.Entity2B;
import ar.com.mtmte.core.type.transformer.ExplicitTransformer;

public class ExplicitTransformerTest {

	private static final String ENTITY_NAME_FIELD = "name";
	private static final String ENTITY_NAME_VALUE = "entityName";

	private static final String ENTITY_CODE_FIELD = "code";
	private static final String ENTITY_CODE_VALUE = "codeName";
	private static final String ENTITY_CODE_FIELD_TRANSFORMED = "entity1ACode";

	private static final String ENTITY_ASSOCIATE_TYPE_FIELD = "associate.type";
	private static final String ENTITY_ASSOCIATE_TYPE_VALUE = "2bType";
	private static final String ENTITY_ASSOCIATE_TYPE_FIELD_TRANSFORMED = "associateType";

	private static final String SELECTION_FIELD_VALUE = "true";
	private static final String SELECTION_FIELD_NAME = "SELECTION";

	@SuppressWarnings("unchecked")
	@Test
	public void testExplicitTransformerWithDefinedSimpleFieldShouldCopyTheValueToSameNameProperty() {
		Entity1A entity1A = new Entity1A();
		entity1A.setName(ENTITY_NAME_VALUE);

		ExplicitTransformer entity1ATransformer = new ExplicitTransformer(Entity1A.class, HashMap.class);
		entity1ATransformer.defineSimpleField(ENTITY_NAME_FIELD);

		Object transformed = entity1ATransformer.transform(entity1A);

		Map<String, Object> transformedEntity = (Map<String, Object>) transformed;
		assertEquals(ENTITY_NAME_VALUE, transformedEntity.get(ENTITY_NAME_FIELD));// copy
																					// value
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testExplicitTransformerWithDefinedFieldShouldCopyTheValueToTheNewNameProperty() {
		Entity1A entity1A = new Entity1A();
		entity1A.setCode(ENTITY_CODE_VALUE);

		ExplicitTransformer entity1ATransformer = new ExplicitTransformer(Entity1A.class, HashMap.class);
		entity1ATransformer.defineField(ENTITY_CODE_FIELD, ENTITY_CODE_FIELD_TRANSFORMED);

		Object transformed = entity1ATransformer.transform(entity1A);

		Map<String, Object> transformedEntity = (Map<String, Object>) transformed;
		assertEquals(ENTITY_CODE_VALUE, transformedEntity.get(ENTITY_CODE_FIELD_TRANSFORMED));// copy
																								// value
																								// with
																								// name
																								// change
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testExplicitTransformerWithDefinedFieldForInnerPropertyShouldCopyTheValueToTheNewNameProperty() {
		Entity1A entity1A = new Entity1A();
		Entity2B associate = new Entity2B();
		associate.setType(ENTITY_ASSOCIATE_TYPE_VALUE);
		entity1A.setAssociate(associate);

		ExplicitTransformer entity1ATransformer = new ExplicitTransformer(Entity1A.class, HashMap.class);
		entity1ATransformer.defineField(ENTITY_ASSOCIATE_TYPE_FIELD, ENTITY_ASSOCIATE_TYPE_FIELD_TRANSFORMED);

		Object transformed = entity1ATransformer.transform(entity1A);

		Map<String, Object> transformedEntity = (Map<String, Object>) transformed;
		assertEquals(ENTITY_ASSOCIATE_TYPE_VALUE, transformedEntity.get(ENTITY_ASSOCIATE_TYPE_FIELD_TRANSFORMED));// copy
																													// value
																													// on
																													// association
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testExplicitTransformerWithDefinedNewFieldShouldCreateTheNewPropertyAndSetTheDefaultValue() {
		Entity1A entity1A = new Entity1A();

		ExplicitTransformer entity1ATransformer = new ExplicitTransformer(Entity1A.class, HashMap.class);
		entity1ATransformer.defineNewField(SELECTION_FIELD_NAME, SELECTION_FIELD_VALUE);

		Object transformed = entity1ATransformer.transform(entity1A);

		Map<String, Object> transformedEntity = (Map<String, Object>) transformed;
		assertEquals(SELECTION_FIELD_VALUE, transformedEntity.get(SELECTION_FIELD_NAME));// add
																							// new
																							// field
																							// with
																							// default
																							// value
	}
}
