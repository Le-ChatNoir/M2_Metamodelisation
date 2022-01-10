package backEnd_multiple;

import projet_package_multiple.*;

public class Renamer extends Visitor {
	String res;
	String baseName;
	String newName;

	public Renamer (String baseName, String newName) {
		this.res = new String();
		this.baseName = baseName;
		this.newName = newName;
		System.out.println("Base name: " + this.baseName + " to be replaced with: " + this.newName);
	}
	
	@Override
	public void visitAttribute(Attribute e) {
		String attributeName = e.getName();
		String typeName = e.getType();
		if(attributeName.equals(this.baseName)){
			attributeName = newName;
			System.out.println("Attribute name replaced from " + e.getName() + " to " + attributeName);
		}
		if(typeName.equals(this.baseName)){
			typeName = newName;
			System.out.println("Attribute type replaced from " + e.getType() + " to " + typeName);
		}
		if(e.getTypeTrack().equals("simple"))
			res += "\t\t" + attributeName + " : " + typeName + " ;\n";
		if(e.getTypeTrack().equals("array"))
			res += "\t\t" + attributeName + " : " + e.getCollecType() + " [" + e.getSize() + "] of " + typeName + " ;\n";
		if(e.getTypeTrack().equals("cardinal"))
			res += "\t\t" + attributeName + " : " + e.getCollecType() + " [" + e.getMin() + " :" + e.getMax() + "] of " + typeName + " ;\n";
	}
	@Override
	public void visitEntity(Entity e) {
		String entityName = e.getName();
		if(entityName.equals(this.baseName)) {
			entityName = newName;
			System.out.println("Entity name replaced from " + e.getName() + " to " + entityName);
		}
		
		res += "\tentity " + entityName + " ;\n";
		for(Attribute a : e.getAttributes()) {
			a.accept(this);
		}
		res += "\tend_entity ;\n";
	}
	@Override
	public void visitModel(Model e) {
		String modelName = e.getName();
		if(modelName.equals(this.baseName)) {
			modelName = newName;
			System.out.println("Model name replaced from " + e.getName() + " to " + modelName);
		}
		
		res += "model " + modelName + " ;\n";
		for(Entity ent : e.getEntities()) {
			//System.out.println("ENTITY " + ent.getName());
			ent.accept(this);
		}
		res += "end_model ;";
	}
	
	public String result() {
		return this.res;
	}
	
}
