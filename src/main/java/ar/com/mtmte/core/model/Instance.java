package ar.com.mtmte.core.model;

import ar.com.mtmte.utils.BeanUtils;

public class Instance {

	private Object instance;

	public Instance(Object instance) {
		this.instance = instance;
	}

	public Object getInstance() {
		return instance;
	}

	public Value getValue(Property property) {
		return new Value(BeanUtils.getProperty(instance, property.getName()));
	}

	public void setValue(Property property, Value value) {
		BeanUtils.setProperty(instance, property.getName(), value.getEnclosingValue());
	}

}
