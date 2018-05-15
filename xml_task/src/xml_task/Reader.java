package xml_task;


import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Reader {

	public static void main(String[] args) {
		
	//Parsing xml file with DOM. 
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	   try {
		DocumentBuilder builderFile =  factory.newDocumentBuilder();
		
		//Inserting  xml in the program.
		Document myFile = builderFile.parse("task.xml");
		
		//Receiving every child tag from "Record".
		NodeList nList = myFile.getElementsByTagName("Record");
		//Using (for loop) to indicate how many elements are in the NodeList(record tags).
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
					
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;

			//with item(2), and item(13) I took the content of "RecordNo" and "Version number".
	    System.out.println("\nRecordNo:" + eElement.getElementsByTagName("Field").item(2).getTextContent());
		System.out.println("Version number:" + eElement.getElementsByTagName("Field").item(13).getTextContent());
			}
		}
		
		//In case it throw any of the following exceptions.
	} catch (ParserConfigurationException e) {
		e.printStackTrace();
	} catch (SAXException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	
	
}
}