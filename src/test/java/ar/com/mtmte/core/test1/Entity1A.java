package ar.com.mtmte.core.test1;

public class Entity1A {

	private String name;
	private String code;
	private Entity2B associate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Entity2B getAssociate() {
		return associate;
	}

	public void setAssociate(Entity2B associate) {
		this.associate = associate;
	}

}
