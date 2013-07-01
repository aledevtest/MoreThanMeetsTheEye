package ar.com.mtmte.core.model;

public class Value {

	private final Object enclosingValue;

	public Value(Object enclosingValue) {
		this.enclosingValue = enclosingValue;
	}

	public Object getEnclosingValue() {
		return enclosingValue;
	}

}
