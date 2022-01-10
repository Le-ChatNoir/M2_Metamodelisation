package projet_package_simple;

import java.util.ArrayList;
import java.util.List;

public class Model extends NamedEntity {
	
	List<Entity> entities;
	
	public Model(String name) {
		this.name = name;
		this.entities = new ArrayList<Entity>();
		//System.out.println("Created Model " + "(" + this.name + ")");
	}
	
	public List<Entity> getEntities(){
		return this.entities;
	}
	
	public void addEntity(Entity e) {
		this.entities.add(e);
		//System.out.println("Added Entity to Model " + this.name + " (" + e.name + ")");
	}
	
	public void removeEntity(Entity e) {
		this.entities.remove(e);
		//System.out.println("Removed Entity to Model " + this.name + " (" + e.name + ")");
	}

	public void accept(Visitor v) {
		v.visitModel(this);
	}
}
