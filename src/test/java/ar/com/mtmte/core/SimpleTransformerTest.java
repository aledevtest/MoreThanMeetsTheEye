package ar.com.mtmte.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ar.com.mtmte.core.test0.Entity0A;
import ar.com.mtmte.core.test0.Entity0B;
import ar.com.mtmte.exceptions.BeanUtilsException;

public class SimpleTransformerTest {
	private static final String MOCK_NAME = "entityName";

	@Test
	public void testBasicTransformerTransform() {
		Entity0A entityA = new Entity0A();
		entityA.setName(MOCK_NAME);
		Entity0B entityB = (Entity0B) new SimpleTransformer().transform(entityA, Entity0B.class);

		assertEquals(MOCK_NAME, entityB.getName());
	}

	@Test(expected = BeanUtilsException.class)
	public void testBasicTransformerTransformWithNullOriginEntity() {
		Entity0A entityA = null;
		new SimpleTransformer().transform(entityA, Entity0B.class);
	}

	@Test
	public void testBasicTransformerTransformWithNullField() {
		Entity0A entityA = new Entity0A();
		entityA.setName(null);
		Entity0B entityB = (Entity0B) new SimpleTransformer().transform(entityA, Entity0B.class);

		assertNull(entityB.getName());
	}
}
