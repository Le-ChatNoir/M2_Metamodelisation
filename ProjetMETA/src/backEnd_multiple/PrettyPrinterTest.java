package backEnd_multiple;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import projet_package_multiple.Attribute;
import projet_package_multiple.Entity;
import projet_package_multiple.Model;

class PrettyPrinterTest {

	@Test
	void test1() {
		String test1 = "model Flotte ;\n\tentity Satellite ;\n\t\tnom : String ;\n\t\tid : Integer ;\n\tend_entity ;\nend_model ;";
		//System.out.println(test1 + "\n\n");
		
		//Creation of test model
		Model m = new Model("Flotte");
		Entity e = new Entity("Satellite");
		m.addEntity(e);
		Attribute a1 = new Attribute("nom", "String");
		Attribute a2 = new Attribute("id", "Integer");
		e.addAttribute(a1);
		e.addAttribute(a2);
		//System.out.println("End of initialization\n\n");
		
		
		PrettyPrinter calc = new PrettyPrinter();
		m.accept(calc);
		
		//System.out.println((calc.result()));
		FileWriter myWriter;
		try {
			myWriter = new FileWriter("simple.txt");
			myWriter.write(calc.result());
			myWriter.close();
			System.out.println("Successfully written to file.");
		} catch (IOException e1) {
			System.out.println("An error occurred while writting to file.");
		    e1.printStackTrace();
		}
		assertTrue((calc.result()).equals(test1));
	}
	
	@Test
	void test2() {
		String test1 = "model Flotte ;\n\tentity Satellite ;\n\t\tnom : String ;\n\t\tid : Integer ;\n\t\tparent : Flotte ;\n\tend_entity ;\n\tentity Flotte ;\n\tend_entity ;\nend_model ;";
		//System.out.println(test1 + "\n\n");
		
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
		
		//System.out.println((calc.result()));
		FileWriter myWriter;
		try {
			myWriter = new FileWriter("simple2.txt");
			myWriter.write(calc.result());
			myWriter.close();
			System.out.println("Successfully written to file.");
		} catch (IOException e1) {
			System.out.println("An error occurred while writting to file.");
		    e1.printStackTrace();
		}
		assertTrue((calc.result()).equals(test1));
	}
	
	@Test
	void test3() {
		String test1 = "model TestModel ;\n\tentity Flotte ;\n\t\tsatellites : List [1 :10] of Satellite ;\n\tend_entity ;\n\tentity Satellite ;\n\t\tpanneaux : Array [2] of PanneauSolaire ;\n\tend_entity ;\n\tentity PanneauSolaire ;\n\tend_entity ;\nend_model ;";
		//System.out.println(test1 + "\n\n");
		
		//Creation of test model
		Model m = new Model("TestModel");
		Entity e = new Entity("Flotte");
		Entity e2 = new Entity("Satellite");
		Entity e3 = new Entity("PanneauSolaire");
		Attribute a1 = new Attribute("satellites", "List", 1, 10, "Satellite");
		Attribute a2 = new Attribute("panneaux", "Array", 2, "PanneauSolaire");
		e.addAttribute(a1);
		e2.addAttribute(a2);
		m.addEntity(e);
		m.addEntity(e2);
		m.addEntity(e3);
		//System.out.println("End of initialization\n\n");
		
		PrettyPrinter calc = new PrettyPrinter();
		m.accept(calc);
		
		//System.out.println((calc.result()));
		FileWriter myWriter;
		try {
			myWriter = new FileWriter("cardinal.txt");
			myWriter.write(calc.result());
			myWriter.close();
			System.out.println("Successfully written to file.");
		} catch (IOException e1) {
			System.out.println("An error occurred while writting to file.");
		    e1.printStackTrace();
		}
		assertTrue((calc.result()).equals(test1));
	}
	
	@Test
	void test4() {
		String test1 = "model Constellation ;\n\tentity Satellite ;\n\t\tnom : String ;\n\t\tid : Integer ;\n\t\tpanneaux : Array [2] of PanneauSolaire ;\n\tend_entity ;\n\tentity Flotte ;\n\t\tsatellites : List [1 :10] of Satellite ;\n\tend_entity ;\n\tentity PanneauSolaire ;\n\tend_entity ;\nend_model ;";
		//System.out.println(test1 + "\n\n");
		
		ReadXMLFile xmlFile = new ReadXMLFile("C:\\Users\\Lukas\\Desktop\\Cours\\M2\\META\\VM_visitor\\ProjetMETA\\SimpleLanguageMetaModel\\ex1.xml");
		Model m1 = xmlFile.construct();
		
		//System.out.println("MODEL FROM XML:\n" + m1.toString());
		
		
		PrettyPrinter calc = new PrettyPrinter();
		m1.accept(calc);
		
		//System.out.println((calc.result()));
		FileWriter myWriter;
		try {
			myWriter = new FileWriter("cardinal.txt");
			myWriter.write(calc.result());
			myWriter.close();
			System.out.println("Successfully written to file.");
		} catch (IOException e1) {
			System.out.println("An error occurred while writting to file.");
		    e1.printStackTrace();
		}
		assertTrue((calc.result()).equals(test1));
	}
	
	@Test
	void test5() {
		
		String test1 = "model TestModel ;\n\tentity Flotte ;\n\t\tsatellites : List [1 :10] of Voiture ;\n\tend_entity ;\n\tentity Voiture ;\n\t\tpanneaux : Array [2] of PanneauSolaire ;\n\tend_entity ;\n\tentity PanneauSolaire ;\n\tend_entity ;\nend_model ;";
		//System.out.println(test1 + "\n\n");
		
		//Creation of test model
		Model m = new Model("TestModel");
		Entity e = new Entity("Flotte");
		Entity e2 = new Entity("Satellite");
		Entity e3 = new Entity("PanneauSolaire");
		Attribute a1 = new Attribute("satellites", "List", 1, 10, "Satellite");
		Attribute a2 = new Attribute("panneaux", "Array", 2, "PanneauSolaire");
		e.addAttribute(a1);
		e2.addAttribute(a2);
		m.addEntity(e);
		m.addEntity(e2);
		m.addEntity(e3);
		String baseName = "Satellite";
		String newName = "Voiture";
		//System.out.println("End of initialization\n\n");
		
		PrettyPrinter calc = new PrettyPrinter();
		m.accept(calc);
		
		//System.out.println("\nBase:\n" + (calc.result()) + "\n");
		
		Renamer r = new Renamer(baseName, newName);
		m.accept(r);
		
		//System.out.println("\nResult renamer:\n" + (r.result()));
		FileWriter myWriter;
		try {
			myWriter = new FileWriter("renamed.txt");
			myWriter.write(r.result());
			myWriter.close();
			System.out.println("Successfully written to file.");
		} catch (IOException e1) {
			System.out.println("An error occurred while writting to file.");
		    e1.printStackTrace();
		}
		
		assertTrue((r.result()).equals(test1));
		
	}

}
