package ar.com.mtmte.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ar.com.mtmte.core.type.transformer.DefaultTransformer;

public class TransformerLocatorTest {
	@Test
	public void testTransformerLocator() {
		TransformerLocator transformerLocator = new TransformerLocator();
		Transformer entity1ATransformer = new DefaultTransformer();
		transformerLocator.registerTransformer("entity1ATransformer", entity1ATransformer);

		Transformer located = transformerLocator.locate("entity1ATransformer");

		assertEquals(entity1ATransformer, located);
	}
}
