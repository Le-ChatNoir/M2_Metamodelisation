package backEnd_multiple;

import projet_package_multiple.*;

public class PrettyPrinter extends Visitor {
	String res;

	public PrettyPrinter () {
		this.res = new String();
	}
	
	@Override
	public void visitAttribute(Attribute e) {
		if(e.getTypeTrack().equals("simple"))
			res += "\t\t" + e.getName() + " : " + e.getType() + " ;\n";
		if(e.getTypeTrack().equals("array"))
			res += "\t\t" + e.getName() + " : " + e.getCollecType() + " [" + e.getSize() + "] of " + e.getType() + " ;\n";
		if(e.getTypeTrack().equals("cardinal"))
			res += "\t\t" + e.getName() + " : " + e.getCollecType() + " [" + e.getMin() + " :" + e.getMax() + "] of " + e.getType() + " ;\n";
	}
	@Override
	public void visitEntity(Entity e) {
		res += "\tentity " + e.getName() + " ;\n";
		for(Attribute a : e.getAttributes()) {
			a.accept(this);
		}
		res += "\tend_entity ;\n";
	}
	@Override
	public void visitModel(Model e) {
		res += "model " + e.getName() + " ;\n";
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
