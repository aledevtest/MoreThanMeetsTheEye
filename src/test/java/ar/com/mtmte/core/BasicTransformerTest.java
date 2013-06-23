package ar.com.mtmte.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ar.com.mtmte.core.test0.EntityA;
import ar.com.mtmte.core.test0.EntityB;
import ar.com.mtmte.exceptions.BeanUtilsException;

public class BasicTransformerTest {
	private static final String MOCK_NAME = "entityName";

	@Test
	public void testBasicTransformerTransform() {
		EntityA entityA = new EntityA();
		entityA.setName(MOCK_NAME);
		EntityB entityB = (EntityB) new BasicTransformer().transform(entityA,
				EntityB.class);

		assertEquals(MOCK_NAME, entityB.getName());
	}

	@Test(expected = BeanUtilsException.class)
	public void testBasicTransformerTransformWithNullOriginEntity() {
		EntityA entityA = null;
		new BasicTransformer().transform(entityA, EntityB.class);
	}

	@Test
	public void testBasicTransformerTransformWithNullField() {
		EntityA entityA = new EntityA();
		entityA.setName(null);
		EntityB entityB = (EntityB) new BasicTransformer().transform(entityA,
				EntityB.class);

		assertNull(entityB.getName());
	}
}
