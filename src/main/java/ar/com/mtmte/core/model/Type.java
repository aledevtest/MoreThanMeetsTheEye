package ar.com.mtmte.core.model;

import ar.com.mtmte.utils.ClassUtils;

public class Type {

	private final Class<?> enclosingType;

	public Type(Class<?> enclosingType) {
		this.enclosingType = enclosingType;
	}

	public Instance createInstance() {
		return new Instance(ClassUtils.newInstance(getEnclosingType()));
	}

	public Instance createInstance(Object object) {
		return new Instance(object);
	}

	public Class<?> getEnclosingType() {
		return enclosingType;
	}
}
