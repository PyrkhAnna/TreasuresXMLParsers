package com.epam.ht4.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import com.epam.ht4.bean.Treasure;
import com.epam.ht4.dao.TreasureDAO;
import com.epam.ht4.dao.exception.DAOExeption;
import com.epam.ht4.parser.TreasureStAXParser;

public class StAXTreasureDAO implements TreasureDAO {

	@Override
	public List<Treasure> readTreasure(String path) throws DAOExeption {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		List<Treasure> treasures;
		try {
			InputStream input = new FileInputStream(path);
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			TreasureStAXParser parser = new TreasureStAXParser();
			treasures = parser.process(reader);
		} catch (XMLStreamException | FileNotFoundException e) {
			throw new DAOExeption(e);
		}
		return treasures;
	}
}
