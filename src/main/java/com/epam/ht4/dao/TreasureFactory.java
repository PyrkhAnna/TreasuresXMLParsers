package com.epam.ht4.dao;

import java.math.BigDecimal;
import java.util.Map;
import com.epam.ht4.bean.Jewel;
import com.epam.ht4.bean.Princess;
import com.epam.ht4.bean.Stick;
import com.epam.ht4.bean.Treasure;

public class TreasureFactory {
	public Treasure createTreasure(Map<String, String> fields) {
		Treasure treasure = null;
		if (fields.get("TREASURETYPE").equalsIgnoreCase("Jewel")) {
			treasure = new Jewel(fields.get("ID"), new BigDecimal(fields.get("PRICE")), fields.get("MATERIAL"),
					new BigDecimal(fields.get("WEIGHT")), fields.get("TYPE"), new BigDecimal(fields.get("DIAMETER")));
		} else if (fields.get("TREASURETYPE").equalsIgnoreCase("Princess")) {
			treasure = new Princess(fields.get("ID"), fields.get("NAME"), Integer.parseInt(fields.get("AGE")),
					new Boolean(fields.get("DAMNATION")), fields.get("BIRTHPLACE"));
		} else if (fields.get("TREASURETYPE").equalsIgnoreCase("Stick")) {
			treasure = new Stick(fields.get("ID"), new BigDecimal(fields.get("PRICE")), fields.get("TITLE"),
					fields.get("TYPE"), fields.get("MATERIAL"), fields.get("TIP"));
		} else
			System.out.println("Unknown treasure");
		return treasure;
	}
}
