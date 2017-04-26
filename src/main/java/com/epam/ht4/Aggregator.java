package com.epam.ht4;

import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Aggregator 
{
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		XMLReader reader = XMLReaderFactory.createXMLReader();
			TreasureSaxHandler handler = new TreasureSaxHandler();
		reader.setContentHandler(handler);
		reader.parse(new InputSource("src/ru/epam/homework/hw04/xml/Treasures_test.xml"));
		
		reader.setFeature("http://xml.org/sax/features/validation", true);	
		reader.setFeature("http://xml.org/sax/features/namespaces", true);
		reader.setFeature("http://xml.org/sax/features/string-interning", true);
		reader.setFeature("http://apache.org/xml/features/validation/schema", false);
		
		List<Treasure> treasures = handler.getTreasureList();
		treasures.stream().forEach(System.out :: println);
	}
}
