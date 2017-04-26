package com.epam.ht4.dao.factory;

import java.math.BigDecimal;
import java.util.Map;

import com.epam.ht4.bean.Bow;
import com.epam.ht4.bean.Jewel;
import com.epam.ht4.bean.Princess;
import com.epam.ht4.bean.Ring;
import com.epam.ht4.bean.Stick;
import com.epam.ht4.bean.Treasure;

public class TreasureFactory {
	public Treasure createTreasure(Map<String, String> fields) {
		Treasure treasure = null;
		String treasureType = fields.get("TREASURETYPE").toUpperCase();
		switch (treasureType) {
		case "JEWEL":
			treasure = new Jewel(fields.get("ID"), new BigDecimal(fields.get("PRICE")), fields.get("MATERIAL"),
					new BigDecimal(fields.get("WEIGHT")), fields.get("TYPE"), new BigDecimal(fields.get("DIAMETER")));
			break;
		case "PRINCESS":
			treasure = new Princess(fields.get("ID"), fields.get("NAME"), Integer.parseInt(fields.get("AGE")),
					new Boolean(fields.get("DAMNATION")), fields.get("BIRTHPLACE"));
			break;
		case "STICK":
			treasure = new Stick(fields.get("ID"), new BigDecimal(fields.get("PRICE")), fields.get("TITLE"),
					fields.get("TYPE"), fields.get("MATERIAL"), fields.get("TIP"));
			break;
		case "BOW": 
			treasure = new Bow(fields.get("ID"), new BigDecimal(fields.get("PRICE")), fields.get("TITLE"),
					fields.get("TYPE"), new BigDecimal(fields.get("SIZE")), fields.get("ARROWTYPE"),
					Integer.parseInt(fields.get("ARROWCOUNT")), Integer.parseInt(fields.get("DAMAGE")));
			break;
		case "RING": 
			treasure = new Ring(fields.get("ID"), new BigDecimal(fields.get("PRICE")), fields.get("MATERIAL"),
					new BigDecimal(fields.get("WEIGHT")), fields.get("STYLE"),
					new Boolean(fields.get("HASPRECIOUSSTONE")));
			break;
		}
		return treasure;
	}
}
