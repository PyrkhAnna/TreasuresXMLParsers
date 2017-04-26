package com.epam.ht4.dao.impl;

import java.io.IOException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.epam.ht4.bean.Treasure;
import com.epam.ht4.dao.TreasureDAO;
import com.epam.ht4.dao.exception.DAOExeption;
import com.epam.ht4.parser.TreasureDOMParser;

public class DOMTreasureDAO implements TreasureDAO {

	@Override
	public List<Treasure> readTreasure(String path) throws DAOExeption {
		TreasureDOMParser parser = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document document;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(new InputSource(path));
			parser = new TreasureDOMParser(document);
			parser.readData();
		} catch (SAXException | ParserConfigurationException | IOException e) {
			throw new DAOExeption(e);
		}
		return parser.getTreasures();
	}
}
