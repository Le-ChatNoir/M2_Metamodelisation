package projet_package_multiple;

public class Attribute extends NamedEntity {
	String type;
	String collecType;
	String typeTrack;
	Integer size;
	Integer min;
	Integer max;
	
	//Usage of several different constructors to separate the different types of attributes
	//panneaux : Panneau;
	public Attribute(String name, String type) {
		this.type = type;
		this.name = name;
		this.collecType = null;
		this.size = 1;
		this.min = 0;
		this.max = 1;
		this.typeTrack = "simple";
		//System.out.println("Created Attribute (" + this.name + " : " + this.type + ")");
	}
	
	//panneaux : Array[2] of Panneau;
	public Attribute(String name, String collecType, Integer size, String type) {
		this.type = type;
		this.collecType = collecType;
		this.name = name;
		this.size = size;
		this.min = 0;
		this.max = size-1;
		this.typeTrack = "array";
		//System.out.println("Created Attribute (" + this.name + " : " + this.type + ")");
	}
	
	//panneaux : List [1 :10] of Panneau;
	public Attribute(String name, String collecType, Integer min, Integer max, String type) {
		this.type = type;
		this.collecType = collecType;
		this.name = name;
		this.size = max - min;
		this.min = min;
		this.max = max;
		this.typeTrack = "cardinal";
		//System.out.println("Created Attribute (" + this.name + " : " + this.type + ")");
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getCollecType() {
		return this.collecType;
	}
	
	public String getTypeTrack() {
		return this.typeTrack;
	}
	
	public Integer getSize() {
		return this.size;
	}
	
	public Integer getMin() {
		return this.min;
	}
	
	public Integer getMax() {
		return this.max;
	}
	
	public void accept(Visitor v) {
		v.visitAttribute(this);
	}
}
