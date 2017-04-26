package com.epam.ht4.dao;

import java.util.List;
import com.epam.ht4.bean.Treasure;
import com.epam.ht4.dao.exception.DAOExeption;

public interface TreasureDAO {
	public List<Treasure> readTreasure(String path) throws DAOExeption;
}
