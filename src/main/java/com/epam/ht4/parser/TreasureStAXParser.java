package com.epam.ht4.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import com.epam.ht4.bean.Treasure;
import com.epam.ht4.dao.factory.TreasureFactory;

public class TreasureStAXParser {
	private List<Treasure> treasures;
	private String value;
	private Map<String, String> parametres;
	private TreasureFactory treasureFactory = new TreasureFactory();

	public List<Treasure> process(XMLStreamReader reader) throws XMLStreamException {
		String elementName = null;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = reader.getLocalName().toUpperCase();
				if (elementName.equals("STICK") || elementName.equals("JEWEL") || elementName.equals("PRINCESS")) {
					String id = reader.getAttributeValue(reader.getNamespaceURI(), reader.getLocalName());
					parametres = new HashMap<String, String>();
					if (id != null) {
						parametres.put("TREASURETYPE", elementName);
						parametres.put("ID", id);
					}
				}
				value = elementName;
				break;
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (text.isEmpty()) {
					break;
				}
				parametres.put(value.toUpperCase(), text);
				break;
			case XMLStreamConstants.END_ELEMENT:
				elementName = reader.getLocalName().toUpperCase();
				if (elementName.equals("STICK") || elementName.equals("JEWEL") || elementName.equals("PRINCESS")) {
					treasures.add(treasureFactory.createTreasure(parametres));
				}
				value = "";
				break;
			}
		}
		return treasures;
	}
}
