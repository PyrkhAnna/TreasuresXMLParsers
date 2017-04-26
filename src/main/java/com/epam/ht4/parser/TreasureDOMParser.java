package com.epam.ht4.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.epam.ht4.bean.Treasure;
import com.epam.ht4.dao.factory.TreasureFactory;

public class TreasureDOMParser {
	private List<Treasure> treasures;
	private Map<String, String> parametres;
	private TreasureFactory treasureFactory = new TreasureFactory();
	private Document document;

	public TreasureDOMParser(Document document) {
		this.document = document;
		parametres = new HashMap<String, String>();
		treasures = new ArrayList<Treasure>();
	}

	public void readData() {
		Element treasuresRoot = document.getDocumentElement();
		NodeList treasuresNode = treasuresRoot.getChildNodes();// all treasures
		for (int i = 0; i < treasuresNode.getLength(); i++) {
			Node treasureNode = treasuresNode.item(i); // one treasure
			if (treasureNode.getNodeType() == 1) {
				Element treasureElement = (Element) treasureNode;
				parametres.put("TREASURETYPE", treasureNode.getNodeName());
				parametres.put("ID", treasureElement.getAttribute("id"));
				NodeList treasuresFields = treasureElement.getChildNodes();
				for (int j = 0; j < treasuresFields.getLength(); j++) {
					if (treasureNode.getNodeType() == 1) {
						Element treasureField = (Element) treasuresFields.item(j);
						parametres.put(treasureField.getNodeName().toUpperCase(), treasureField.getTextContent().trim());
					}
				}
				treasures.add(treasureFactory.createTreasure(parametres));
			}
		}
	}

	public List<Treasure> getTreasures() {
		return treasures;
	}
}
