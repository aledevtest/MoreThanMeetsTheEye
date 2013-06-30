package ar.com.mtmte.core;

import java.util.HashMap;
import java.util.Map;


public class TransformerLocator {

	private Map<String, Transformer> namedTransformers = new HashMap<String, Transformer>();

	public Transformer locate(String transformerName) {
		return this.namedTransformers.get(transformerName);
	}

	public void registerTransformer(String transformerName, Transformer transformer) {
		this.namedTransformers.put(transformerName, transformer);
	}

}
