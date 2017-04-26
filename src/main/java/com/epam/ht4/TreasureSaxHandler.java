package com.epam.ht4;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class TreasureSaxHandler extends DefaultHandler 
{
	private List<Treasure> TreasureList = new ArrayList<Treasure>();	
	private StringBuilder text;	
	private String tempElementName = "";	
	private List<String> parameters = new ArrayList<>();

	public List<Treasure> getTreasureList() {
		return TreasureList;
	}

	public void startDocument() throws SAXException {
		System.out.println("Parsing started.");
	}

	public void endDocument() throws SAXException {
		System.out.println("Parsing ended.");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException 
	{		
		text = new StringBuilder();
		
		if (!qName.equals("treasures") & tempElementName.isEmpty()) {			
			parameters.add(attributes.getValue("id"));
			tempElementName = qName;
		}
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException 
	{
		if (qName.equals(tempElementName)){			
			TreasureList.add(TreasureFactory.getTreasure(tempElementName, parameters));
			parameters.clear();
			tempElementName = "";			
		} 
		else
		{
			parameters.add(text.toString());
		}		
	}

	public void warning(SAXParseException exception) {
		System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	public void error(SAXParseException exception) {
		System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
		throw (exception);
	}
}
