package com.epam.ht4.dao.impl;

import java.io.IOException;
import java.util.List;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import com.epam.ht4.bean.Treasure;
import com.epam.ht4.dao.TreasureDAO;
import com.epam.ht4.dao.exception.DAOExeption;
import com.epam.ht4.parser.TreasureSAXParser;

public class SAXTreasureDAO implements TreasureDAO {

	@Override
	public List<Treasure> readTreasure(String path) throws DAOExeption {
		XMLReader reader;
		TreasureSAXParser handler;
		try {
			reader = XMLReaderFactory.createXMLReader();
			InputSource  source = new InputSource(path);
			handler = new TreasureSAXParser();
			reader.setContentHandler(handler);
			reader.parse(source);
		} catch (SAXException | IOException e) {
			throw new DAOExeption(e);
		}
		return handler.getTreasures();
	}
}
