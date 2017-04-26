package com.epam.ht4.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.epam.ht4.bean.Treasure;
import com.epam.ht4.dao.TreasureFactory;

public class TreasureSAXParser extends DefaultHandler {
	private List<Treasure> treasures;
	private String value;
	private Map<String, String> parametres;
	private TreasureFactory treasureFactory = new TreasureFactory();

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("STICK") || qName.equals("JEWEL") || qName.equals("PRINCESS")) {
			String id = attributes.getValue("id");
			parametres = new HashMap<String, String>();
			if (id != null) {
				parametres.put("TREASURETYPE", qName);
				parametres.put("ID", id);
			}
		}
		value = qName;
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("STICK") || qName.equals("JEWEL") || qName.equals("PRINCESS")) {
			treasures.add(treasureFactory.createTreasure(parametres));
		}
		value = "";
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		parametres.put(value.toUpperCase(), new String(ch, start, length));
	}

	public List<Treasure> getTreasures() {
		return treasures;
	}
	
}
