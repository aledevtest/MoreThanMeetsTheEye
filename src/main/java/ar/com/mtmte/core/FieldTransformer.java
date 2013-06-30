package ar.com.mtmte.core;


public interface FieldTransformer {

	String getOriginPropertyName();

	String getDestinationPropertyName();

	void applyTransformation(Object object, Object destination);

}
