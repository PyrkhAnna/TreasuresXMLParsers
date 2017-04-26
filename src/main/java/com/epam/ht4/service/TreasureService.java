package com.epam.ht4.service;

import java.math.BigDecimal;
import java.util.List;

import com.epam.ht4.bean.Treasure;
import com.epam.ht4.service.exception.ServiceExeption;

public interface TreasureService {
	void createTreasures(String path);
	List<Treasure> findTreasure(String treasureType);
	List<Treasure> findTreasure(String feildType, String feildValue) throws ServiceExeption;
	List<Treasure> findTreasure(BigDecimal startPrice, BigDecimal endPrice);
	Treasure findMostExpensiveTreasure();
}
