package com.epam.ht4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public final class TreasureFactory {
	private TreasureFactory() {
	}

	@SuppressWarnings({"rawtypes", "unchecked"})	
	public static Treasure getTreasure(String treasureType, List<String> parameters) {
		Treasure treasure = null;	
		StringBuilder sb = new StringBuilder(treasureType);
		
		sb
		.insert(0, Character.toUpperCase(sb.charAt(0)))
		.deleteCharAt(1);

		while(sb.toString().contains("_"))
		{
			int index = sb.indexOf("_");
			sb
			.deleteCharAt(index)
			.insert(index, Character.toUpperCase(sb.charAt(index)))
			.deleteCharAt(index + 1);
		}
		
		try {
			Class clazz = Class.forName("ru.epam.homework.hw04.bean." + sb.toString());
			Constructor constructor = clazz.getConstructor(List.class);
			treasure = (Treasure) constructor.newInstance(parameters);
			clazz.cast(treasure);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return treasure;
	}
}
