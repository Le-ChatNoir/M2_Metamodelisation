package backEnd_simple;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import projet_package_simple.Attribute;
import projet_package_simple.Entity;
import projet_package_simple.Model;

class PrettyPrinterTest {

	@Test
	void test1() {
		String test1 = "model Flotte ;\n\tentity Satellite ;\n\t\tnom : String ;\n\t\tid : Integer ;\n\tend_entity ;\nend_model ;";
		System.out.println(test1 + "\n\n");
		
		//Creation of test model
		Model m = new Model("Flotte");
		Entity e = new Entity("Satellite");
		m.addEntity(e);
		Attribute a1 = new Attribute("nom", "String");
		Attribute a2 = new Attribute("id", "Integer");
		e.addAttribute(a1);
		e.addAttribute(a2);
		System.out.println("End of initialization\n\n");
		
		
		PrettyPrinter calc = new PrettyPrinter();
		m.accept(calc);
		
		System.out.println((calc.result()));
		assertTrue((calc.result()).equals(test1));
	}
	
	@Test
	void test2() {
		String test1 = "model Flotte ;\n\tentity Satellite ;\n\t\tnom : String ;\n\t\tid : Integer ;\n\t\tparent : Flotte ;\n\tend_entity ;\n\tentity Flotte ;\n\tend_entity ;\nend_model ;";
		System.out.println(test1 + "\n\n");
		
		//Creation of test model
		Model m = new Model("Flotte");
		Entity e = new Entity("Satellite");
		Entity e2 = new Entity("Flotte");
		m.addEntity(e);
		Attribute a1 = new Attribute("nom", "String");
		Attribute a2 = new Attribute("id", "Integer");
		Attribute a3 = new Attribute("parent", "Flotte");
		e.addAttribute(a1);
		e.addAttribute(a2);
		e.addAttribute(a3);
		m.addEntity(e2);
		//System.out.println("End of initialization\n\n");
		
		
		PrettyPrinter calc = new PrettyPrinter();
		m.accept(calc);
		
		System.out.println((calc.result()));
		assertTrue((calc.result()).equals(test1));
	}

}
