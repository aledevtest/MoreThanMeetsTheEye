package ar.com.mtmte.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ar.com.mtmte.core.test0.Entity0A;
import ar.com.mtmte.core.test0.Entity0B;
import ar.com.mtmte.core.type.transformer.DefaultTransformer;

public class SimpleTransformerTest {
	private static final String MOCK_NAME = "entityName";

	@Test
	public void testBasicTransformerTransform() {
		Entity0A entityA = new Entity0A();
		entityA.setName(MOCK_NAME);
		Entity0B entityB = (Entity0B) new DefaultTransformer().transform(entityA, Entity0B.class);

		assertEquals(MOCK_NAME, entityB.getName());
	}

	@Test
	public void testBasicTransformerTransformWithNullField() {
		Entity0A entityA = new Entity0A();
		entityA.setName(null);
		Entity0B entityB = (Entity0B) new DefaultTransformer().transform(entityA, Entity0B.class);

		assertNull(entityB.getName());
	}
}
