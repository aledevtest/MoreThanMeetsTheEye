package ar.com.mtmte.core;

public interface DefinedTransformer extends Transformer {

	void defineSimpleField(String propertyName);

	void defineField(String originPropertyName, String destinationPropertyName);

	void defineNewField(String newFieldName, Object defaultValue);
}
