package backEnd_multiple;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import projet_package_multiple.*;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXMLFile {
	String fileName;
	
	public ReadXMLFile(String fileName) {
		this.fileName = fileName;
	}

	public Model construct() {

	    try {

	    File fXmlFile = new File(this.fileName);
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(fXmlFile);

	   //optional, but recommended
	   //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	    doc.getDocumentElement().normalize();

	    //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	    NodeList nList = doc.getElementsByTagName("model");
	    Node nNode = nList.item(0);
	    Element eElement = (Element) nNode;
        //System.out.println("Nom :" + eElement.getAttribute("name"));
	    Model m = new Model(eElement.getAttribute("name"));

	    nList = doc.getElementsByTagName("entity");

	    //System.out.println("----------------------------");

	    for (int temp = 0; temp < nList.getLength(); temp++) {

	        nNode = nList.item(temp);
	        //System.out.println("\nCurrent Element :" + nNode.getNodeName());
	        

	        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            eElement = (Element) nNode;
	            //System.out.println("Nom :" + eElement.getAttribute("name"));
	            
	            Entity e = new Entity(eElement.getAttribute("name"));
		        m.addEntity(e);
	            
	            NodeList nList2 = eElement.getChildNodes();           
	            for (int temp2 = 0; temp2 < nList2.getLength(); temp2++) {
	            	Node nNode2 = nList2.item(temp2);
	    	        //System.out.println("\nCurrent Element :" + nNode2.getNodeName());
	    	        
	    	        if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
	    	            Element eElement2 = (Element) nNode2;
	    	            /*System.out.println("Nom :" + eElement2.getAttribute("name"));
	    	            System.out.println("Type :" + eElement2.getAttribute("type"));
	    	            System.out.println("Typetrack :" + eElement2.getAttribute("typetrack"));
	    	            System.out.println("Min :" + eElement2.getAttribute("min"));
	    	            System.out.println("Max :" + eElement2.getAttribute("max"));*/
	    	            
	    	            if(eElement2.getAttribute("typetrack").equals("simple")) {
	    	            	Attribute a = new Attribute(eElement2.getAttribute("name"), eElement2.getAttribute("type"));
	    	            	e.addAttribute(a);
	    	            }
	    	    		if(eElement2.getAttribute("typetrack").equals("array")) {
	    	    			Integer size = Integer.parseInt(eElement2.getAttribute("max")) - Integer.parseInt(eElement2.getAttribute("min"));
	    	    			Attribute a = new Attribute(eElement2.getAttribute("name"), eElement2.getAttribute("typecollec"), size, eElement2.getAttribute("type"));
	    	    			e.addAttribute(a);
	    	    		}
	    	    		if(eElement2.getAttribute("typetrack").equals("cardinal")) {
	    	    			Attribute a = new Attribute(eElement2.getAttribute("name"), eElement2.getAttribute("typecollec"), Integer.parseInt(eElement2.getAttribute("min")), Integer.parseInt(eElement2.getAttribute("max")),  eElement2.getAttribute("type"));
	    	    			e.addAttribute(a);
	    	    		}
	    	        }
	            }
	        }
	    }
	    return m;
	    } catch (Exception e) {
	    e.printStackTrace();
	    }
		return null;
	  }
	
}
