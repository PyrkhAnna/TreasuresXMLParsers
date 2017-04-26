package com.epam.ht4;

import java.util.List;

public class Bow extends Treasure
{	
	private String title;
    private String type;
    private double size;
    private String arrowType;
    private int arrowCount;
    private double damage;
    private double price;
    
    public Bow(List<String> parameters) {
		super(Integer.parseInt(parameters.get(0)));		
		initialize(parameters);	
	}

	@Override
	public String toString() {
		return "Bow [Id=" + getId() + ", title=" + title + ", type=" + type + ", size=" + size + ", arrow_type="
				+ arrowType + ", arrow_count=" + arrowCount + ", damage=" + damage + ", price=" + price + "]";
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

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getArrowType() {
		return arrowType;
	}

	public void setArrowType(String arrowType) {
		this.arrowType = arrowType;
	}

	public int getArrowCount() {
		return arrowCount;
	}

	public void setArrowCount(int arrowCount) {
		this.arrowCount = arrowCount;
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
		result = prime * result + arrowCount;
		result = prime * result + ((arrowType == null) ? 0 : arrowType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(damage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(size);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Bow other = (Bow) obj;
		if (arrowCount != other.arrowCount)
			return false;
		if (arrowType == null) {
			if (other.arrowType != null)
				return false;
		} else if (!arrowType.equals(other.arrowType))
			return false;
		if (Double.doubleToLongBits(damage) != Double.doubleToLongBits(other.damage))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(size) != Double.doubleToLongBits(other.size))
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
		return true;
	}


    
}
