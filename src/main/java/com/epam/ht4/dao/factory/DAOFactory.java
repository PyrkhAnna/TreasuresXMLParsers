package com.epam.ht4.dao.factory;

import com.epam.ht4.dao.TreasureDAO;
import com.epam.ht4.dao.impl.DOMTreasureDAO;
import com.epam.ht4.dao.impl.SAXTreasureDAO;
import com.epam.ht4.dao.impl.StAXTreasureDAO;

public final class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	private final TreasureDAO saxTreasureImpl = new SAXTreasureDAO();
	private final TreasureDAO staxTreasureImpl = new StAXTreasureDAO();
	private final TreasureDAO domTreasureImpl = new DOMTreasureDAO();
	
	private DAOFactory() {}
	public static DAOFactory getInstance() {
		return instance;
	}
	public TreasureDAO getSAXTreasureDAO() {
		return saxTreasureImpl;
	}
	public TreasureDAO getStAXTreasureDAO() {
		return staxTreasureImpl;
	}
	public TreasureDAO getDOMTreasureDAO() {
		return domTreasureImpl;
	}
}
