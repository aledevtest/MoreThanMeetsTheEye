package ar.com.mtmte.core;


public interface Transformer {

	Object transform(Object object);

	void define(String propertyName);

	void define(String originPropertyName, String destinationPropertyName);

	void defineCreation(String newFieldName, Object defaultValue);

}
