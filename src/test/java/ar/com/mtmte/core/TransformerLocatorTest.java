package ar.com.mtmte.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ar.com.mtmte.core.Transformer;
import ar.com.mtmte.core.TransformerLocator;
import ar.com.mtmte.core.type.transformer.ExplicitTransformer;

public class TransformerLocatorTest {
	@Test
	public void testTransformerLocator() {
		TransformerLocator transformerLocator = new TransformerLocator();
		Transformer entity1ATransformer = new ExplicitTransformer();
		transformerLocator.registerTransformer("entity1ATransformer", entity1ATransformer);

		Transformer located = transformerLocator.locate("entity1ATransformer");

		assertEquals(entity1ATransformer, located);
	}
}
