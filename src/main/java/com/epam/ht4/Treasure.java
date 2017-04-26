package com.epam.ht4;

import java.lang.reflect.Field;
import java.util.List;

public abstract class Treasure 
{
	private int id;
	
	public Treasure(int id){
		this.id = id;
	}
	
	public void initialize(List<String> parameters) {
		try {
			int i = 1;
			for (Field field : this.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				if (field.getType().equals(String.class))
				{
					field.set(this, parameters.get(i));
				} else
					if (field.getType().toString().equals("double"))
					{
					field.setDouble(this, Double.parseDouble(parameters.get(i)));
					} else
					if (field.getType().toString().equals("int"))
				{
					field.setInt(this, Integer.parseInt(parameters.get(i)));
				}
				i++;
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {			
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treasure other = (Treasure) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Treasure [id=" + id + "]";
	}

}
