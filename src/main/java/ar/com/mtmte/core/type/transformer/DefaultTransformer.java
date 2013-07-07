package ar.com.mtmte.core.type.transformer;

import java.util.HashMap;

import ar.com.mtmte.core.AbstractTransformer;
import ar.com.mtmte.core.model.Type;

public class DefaultTransformer extends AbstractTransformer {

	@Override
	protected Type getDestinationType() {
		return new Type(HashMap.class);
	}

}
