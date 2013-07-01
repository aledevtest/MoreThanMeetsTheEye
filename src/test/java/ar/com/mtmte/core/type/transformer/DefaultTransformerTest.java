package ar.com.mtmte.core.type.transformer;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import ar.com.mtmte.core.test1.Entity1A;

public class DefaultTransformerTest {
	private static final String ENTITY_NAME_FIELD = "name";
	private static final String ENTITY_NAME_VALUE = "entityName";

	private static final String ENTITY_CODE_FIELD = "code";
	private static final String ENTITY_CODE_VALUE = "codeName";

	@SuppressWarnings("unchecked")
	@Test
	public void testDefaultTransformerWithDefinedSimpleFieldShouldCopyTheValueToSameNameProperty() {
		Entity1A entity1A = new Entity1A();
		entity1A.setName(ENTITY_NAME_VALUE);
		entity1A.setCode(ENTITY_CODE_VALUE);

		DefaultTransformer entity1ATransformer = new DefaultTransformer();

		Object transformed = entity1ATransformer.transform(entity1A);

		Map<String, Object> transformedEntity = (Map<String, Object>) transformed;
		assertEquals(ENTITY_NAME_VALUE, transformedEntity.get(ENTITY_NAME_FIELD));// copy
																					// value
		assertEquals(ENTITY_CODE_VALUE, transformedEntity.get(ENTITY_CODE_FIELD));// copy
	}
}
