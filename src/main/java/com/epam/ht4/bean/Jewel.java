package com.epam.ht4.bean;

import java.math.BigDecimal;

public class Jewel extends Jewerly{
	private String type;
	private BigDecimal diameter;
	public Jewel(String id, BigDecimal price, String material, BigDecimal weight, String type, BigDecimal diameter) {
		super(id, price, material, weight);
		this.type = type;
		this.diameter = diameter;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getDiameter() {
		return diameter;
	}
	public void setDiameter(BigDecimal diameter) {
		this.diameter = diameter;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((diameter == null) ? 0 : diameter.hashCode());
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
		Jewel other = (Jewel) obj;
		if (diameter == null) {
			if (other.diameter != null)
				return false;
		} else if (!diameter.equals(other.diameter))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Jewel [id=" + getId() + "material=" + getMaterial() + ", weight=" + getWeight() + "type=" + type + ", diameter=" + diameter + "]";
	}
	
}
