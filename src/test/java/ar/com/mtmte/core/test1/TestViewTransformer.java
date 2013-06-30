package ar.com.mtmte.core.test1;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import ar.com.mtmte.core.Transformer;
import ar.com.mtmte.core.TransformerLocator;
import ar.com.mtmte.core.type.transformer.SimpleTransformer;

public class TestViewTransformer {

	private static final String SELECTION_FIELD_VALUE = "true";
	private static final String SELECTION_FIELD_NAME = "SELECTION";

	private static final String ENTITY_NAME_FIELD = "name";
	private static final String ENTITY_NAME_VALUE = "entityName";
	private static final String ENTITY_CODE_FIELD = "code";
	private static final String ENTITY_CODE_VALUE = "codeName";
	private static final String ENTITY_CODE_FIELD_TRANSFORMED = "entity1ACode";
	private static final String ENTITY_ASSOCIATE_TYPE_FIELD = "associate.type";
	private static final String ENTITY_ASSOCIATE_TYPE_VALUE = "2bType";
	private static final String ENTITY_ASSOCIATE_TYPE_FIELD_TRANSFORMED = "associateType";

	@Test
	public void testViewTransformer(){
		Entity1A entity1A = new Entity1A();
		entity1A.setName(ENTITY_NAME_VALUE);
		entity1A.setCode(ENTITY_CODE_VALUE);
		Entity2B associate = new Entity2B();
		associate.setType(ENTITY_ASSOCIATE_TYPE_VALUE);
		entity1A.setAssociate(associate);
		
		TransformerLocator transformerLocator = new TransformerLocator();
		Transformer entity1ATransformer = new SimpleTransformer();
		entity1ATransformer.define(ENTITY_NAME_FIELD);
		entity1ATransformer.define(ENTITY_CODE_FIELD, ENTITY_CODE_FIELD_TRANSFORMED);
		entity1ATransformer.define(ENTITY_ASSOCIATE_TYPE_FIELD, ENTITY_ASSOCIATE_TYPE_FIELD_TRANSFORMED);
		entity1ATransformer.defineCreation(SELECTION_FIELD_NAME, SELECTION_FIELD_VALUE);
		
		
		transformerLocator.registerTransformer("entity1ATransformer", entity1ATransformer);
		
		Map<String, Object> transformedEntity = (Map<String, Object>) transformerLocator.locate("entity1ATransformer").transform(entity1A);
		assertEquals(ENTITY_NAME_VALUE, transformedEntity.get(ENTITY_NAME_FIELD));//copy value
		assertEquals(ENTITY_CODE_VALUE, transformedEntity.get(ENTITY_CODE_FIELD_TRANSFORMED));//copy value with name change
		assertEquals(ENTITY_ASSOCIATE_TYPE_VALUE, transformedEntity.get(ENTITY_ASSOCIATE_TYPE_FIELD_TRANSFORMED));//copy value on association
		assertEquals(SELECTION_FIELD_VALUE, transformedEntity.get(SELECTION_FIELD_NAME));//add new field with default value
	}
}
