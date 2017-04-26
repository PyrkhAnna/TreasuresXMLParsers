package com.epam.ht4.service;

import java.math.BigDecimal;
import java.util.Map;

public interface TreasureService {
	void createTreasure(String treasureType, Map<String, String> fields);
	void findTreasure(String treasureType);
	void findTreasure(String feildType, String feildValue);
	void findTreasure(BigDecimal startPrice, BigDecimal endPrice);
	
}
