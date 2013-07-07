package ar.com.mtmte.core;

public interface Transformer {

	Object transform(Object object);
	
	Object transform(Object object, Class transformedType);
}
