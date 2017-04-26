package com.epam.ht4.service.impl;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.epam.ht4.bean.Things;
import com.epam.ht4.bean.Treasure;
import com.epam.ht4.dao.TreasureDAO;
import com.epam.ht4.dao.exception.DAOExeption;
import com.epam.ht4.dao.factory.DAOFactory;
import com.epam.ht4.service.TreasureService;
import com.epam.ht4.service.exception.ServiceExeption;

public class TreasureServiceImpl implements TreasureService {
	List<Treasure> treasure;

	@Override
	public void createTreasures(String path) {
		treasure = null;
		if (path != null && !path.isEmpty()) {
			DAOFactory daoFactory = DAOFactory.getInstance();
			TreasureDAO treasureDAO = daoFactory.getSAXTreasureDAO();
			try {
				treasure = treasureDAO.readTreasure(path);
			} catch (DAOExeption e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Treasure> findTreasure(String treasureType) {
		List<Treasure> foundTreasures = new ArrayList<Treasure>();
		if (treasureType != null && !treasureType.isEmpty()) {
			for (int i = 0; i < treasure.size(); i++) {
				String className = treasure.get(i).getClass().getSimpleName();
				if (treasureType.equalsIgnoreCase(className)) {
					foundTreasures.add(treasure.get(i));
				}
			}
		}
		return foundTreasures;
	}

	@Override
	public List<Treasure> findTreasure(String fieldType, String value) throws ServiceExeption {
		List<Treasure> foundTreasures = new ArrayList<Treasure>();
		String fieldValue = null;
		Field field = null;
		if (fieldType != null && !fieldType.isEmpty() && value != null && !value.isEmpty()) {
			try {
				for (int i = 0; i < treasure.size(); i++) {
					Class<? extends Treasure> c = treasure.get(i).getClass();
					field = c.getDeclaredField(fieldType.toLowerCase());
					if (field != null) {
						fieldValue = (String) field.get(treasure.get(i));
					}
					if (fieldValue != null && fieldValue.equalsIgnoreCase(value)) {
						foundTreasures.add(treasure.get(i));
					}
				}
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				throw new ServiceExeption(e);
			}
		}
		return foundTreasures;
	}

	@Override
	public List<Treasure> findTreasure(BigDecimal startPrice, BigDecimal endPrice) {
		List<Treasure> foundTreasures = new ArrayList<Treasure>();
		if (startPrice != null && endPrice != null) {
			for (int i = 0; i < treasure.size(); i++) {
				if (treasure.get(i) instanceof Things) {
					Things thing = (Things) treasure.get(i);
					if (thing.getPrice().compareTo(startPrice) == 1 && thing.getPrice().compareTo(endPrice) == -1) {
						foundTreasures.add(treasure.get(i));
					}
				}
			}
		}
		return foundTreasures;
	}

	@Override
	public Treasure findMostExpensiveTreasure() {
		List<Things> foundThings = getThings();
		return getMostExpensive(foundThings);
	}

	private List<Things> getThings() {
		List<Things> foundThings = new ArrayList<Things>();
		for (int i = 0; i < treasure.size(); i++) {
			if (treasure.get(i) instanceof Things) {
				foundThings.add((Things) treasure.get(i));
			}
		}
		return foundThings;
	}

	private Treasure getMostExpensive(List<Things> things) {
		Things mostExpensive = things.get(0);
		for (int i = 1; i < things.size(); i++) {
			if (things.get(i).getPrice().compareTo(mostExpensive.getPrice()) == 1) {
				mostExpensive = things.get(i);
			}
		}
		return mostExpensive;
	}
}
