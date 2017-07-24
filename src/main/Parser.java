package main;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import main.obj.Shortcut;

public class Parser {
	public static boolean validateXML () {
		return false;
	}
	
	public static List<Shortcut> parseShortcutsXML (String fileName) {
		List<Shortcut> shortcuts = new ArrayList<Shortcut>();
		Document xmlDoc;
		DocumentBuilderFactory dbFactory;
		DocumentBuilder dBuilder;
		NodeList shortcutNodes;
		try {
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			xmlDoc = dBuilder.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName));
			xmlDoc.getDocumentElement().normalize();
			shortcutNodes = xmlDoc.getElementsByTagName("shortcut");
			for (int i=0; i < shortcutNodes.getLength(); i++) {
				Node nNode = shortcutNodes.item(i);
				if (nNode instanceof Element) {
					Element nElement = (Element) nNode;
					shortcuts.add(new Shortcut(nElement.getElementsByTagName("name").item(0).getTextContent(), 
													Paths.get(nElement.getElementsByTagName("path").item(0).getTextContent()),
													nElement.getElementsByTagName("key").item(0).getTextContent().toCharArray()[0]));
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return shortcuts;
	}
}