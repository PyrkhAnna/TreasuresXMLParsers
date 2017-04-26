package com.epam.ht4.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.epam.ht4.bean.Treasure;
import com.epam.ht4.dao.TreasureFactory;

public class TreasureDOMParser {
	private List<Treasure> treasures;
	private String value;
	private Map<String, String> parametres;
	private TreasureFactory treasureFactory = new TreasureFactory();
	private Document document;
	
	public TreasureDOMParser(Document document) {
		this.document = document;
		parametres = new HashMap<String, String>();
	}

	public void readData() {
		//Element treasuresRoot;
		
		Element treasuresRoot = document.getDocumentElement();
		NodeList treasuresNode= treasuresRoot.getChildNodes();// all treasures
		for (int i = 0; i < treasuresNode.getLength(); i++) {
			Node treasureNode = treasuresNode.item(i); // one treasure
			Element treasureElement;
			if (treasureNode.getNodeType()==1){ 
				treasureElement = (Element) treasureNode;
				parametres.put("TREASURETYPE", treasureNode.getNodeName().toUpperCase());
				parametres.put("ID", treasureElement.getAttribute("id"));
				
				treasures.add(treasureFactory.createTreasure(parametres));
				//Event eventEntity = buildEvent(treasureElement, treasureNode.getNodeName());
			//	System.out.println(eventEntity);
			}
		}
		
	}
	private static String getSingleElementContent(Element element, String tagName){
		NodeList list = element.getElementsByTagName(tagName);
		Element el = (Element) list.item(0);
		String content = el.getTextContent().trim();
		return content;
	}
	public List<Treasure> getTreasures() {
		return treasures;
	}
}
