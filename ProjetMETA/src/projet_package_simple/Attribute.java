package projet_package_simple;

public class Attribute extends NamedEntity {
	String type;
	
	public Attribute(String name, String type) {
		this.type = type;
		this.name = name;
		//System.out.println("Created Attribute (" + this.name + " : " + this.type + ")");
	}
	
	public String getType() {
		return this.type;
	}
	
	public void accept(Visitor v) {
		v.visitAttribute(this);
	}
}
