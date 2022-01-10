package projet_package_simple;

import java.util.ArrayList;
import java.util.List;

public class Entity extends NamedEntity {
	
	List<Attribute> attributes;
	
	public Entity(String name) {
		this.name = name;
		this.attributes = new ArrayList<Attribute>();
		//System.out.println("Created Entity (" + this.name + ")");
	}
	
	public List<Attribute> getAttributes(){
		return this.attributes;
	}
	
	public void addAttribute(Attribute a) {
		this.attributes.add(a);
		//System.out.println("Added Attribute to Entity " + this.name + " (" + a.name + " : " + a.type + ")");
	}
	
	public void removeAttribute(Attribute a) {
		this.attributes.remove(a);
		//System.out.println("Removed Attribute to Entity " + this.name + " (" + a.name + " : " + a.type + ")");
	}
	
	public void accept(Visitor v) {
		v.visitEntity(this);
	}
}
