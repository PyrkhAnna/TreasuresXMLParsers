package com.epam.ht4;

import java.util.List;

public class Helmet extends Treasure 
{	
	private String title;
    private String type;
    private String material;
    private double headProtection;   
    private double headCircumference;
    private double price;
    
    public Helmet(List<String> parameters) {
		super(Integer.parseInt(parameters.get(0)));		
		initialize(parameters);	
	}

	@Override
	public String toString() {
		return "Helmet [Id=" + getId() + ", title=" + title + ", type=" + type + ", material=" + material
				+ ", headProtection=" + headProtection + ", headCircumference=" + headCircumference + ", price=" + price
				+ "]";
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

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getHeadProtection() {
		return headProtection;
	}

	public void setHeadProtection(double headProtection) {
		this.headProtection = headProtection;
	}

	public double getHeadCircumference() {
		return headCircumference;
	}

	public void setHeadCircumference(double headCircumference) {
		this.headCircumference = headCircumference;
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
		temp = Double.doubleToLongBits(headCircumference);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(headProtection);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		temp = Double.doubleToLongBits(price);
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
		Helmet other = (Helmet) obj;
		if (Double.doubleToLongBits(headCircumference) != Double.doubleToLongBits(other.headCircumference))
			return false;
		if (Double.doubleToLongBits(headProtection) != Double.doubleToLongBits(other.headProtection))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
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
		return true;
	}
    
    
}
