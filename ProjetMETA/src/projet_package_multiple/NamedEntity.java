package projet_package_multiple;

public abstract class NamedEntity {

	String name;
	
	public String getName() {
		return this.name;
	}
	
	public void accept(Visitor v) {
		v.visitNamedEntity(this);
	}
}
