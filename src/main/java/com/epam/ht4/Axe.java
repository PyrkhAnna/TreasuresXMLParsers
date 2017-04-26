package com.epam.ht4;

import java.util.List;

public class Axe extends Treasure {
	private String title;
	private String type;
	private String typeHandle;
	private String typeBlade;
	private double damage;
	private double price;
	
	public Axe(List<String> parameters) {
		super(Integer.parseInt(parameters.get(0)));		
		initialize(parameters);	
	}

	@Override
	public String toString() {
		return "Axe [Id=" + getId() + ", title=" + title + ", type=" + type + ", type_handle=" + typeHandle
				+ ", type_blade=" + typeBlade + ", damage=" + damage + ", price=" + price + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeHandle() {
		return typeHandle;
	}

	public void setTypeHandle(String typeHandle) {
		this.typeHandle = typeHandle;
	}

	public String getTypeBlade() {
		return typeBlade;
	}

	public void setTypeBlade(String typeBlade) {
		this.typeBlade = typeBlade;
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(damage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((typeBlade == null) ? 0 : typeBlade.hashCode());
		result = prime * result + ((typeHandle == null) ? 0 : typeHandle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Axe other = (Axe) obj;
		if (Double.doubleToLongBits(damage) != Double.doubleToLongBits(other.damage))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (typeBlade == null) {
			if (other.typeBlade != null)
				return false;
		} else if (!typeBlade.equals(other.typeBlade))
			return false;
		if (typeHandle == null) {
			if (other.typeHandle != null)
				return false;
		} else if (!typeHandle.equals(other.typeHandle))
			return false;
		return true;
	}


	
}
