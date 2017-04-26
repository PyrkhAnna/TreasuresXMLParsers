package com.epam.ht4.bean;

import java.math.BigDecimal;

public class Bow extends Weapon {
	private BigDecimal size;
	private String arrowType;
	private int arrowCount;
	private int damage;
	public Bow(String id, BigDecimal price, String title, String type, BigDecimal size, String arrowType,
			int arrowCount, int damage) {
		super(id, price, title, type);
		this.size = size;
		this.arrowType = arrowType;
		this.arrowCount = arrowCount;
		this.damage = damage;
	}
	public BigDecimal getSize() {
		return size;
	}
	public void setSize(BigDecimal size) {
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
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + arrowCount;
		result = prime * result + ((arrowType == null) ? 0 : arrowType.hashCode());
		result = prime * result + damage;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		if (damage != other.damage)
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bow [id=" + getId() + "title=" + getTitle() + ", type=" + getType() + "size=" + size + ", arrowType=" + arrowType + ", arrowCount=" + arrowCount + ", damage=" + damage
				+ "]";
	}
	
}
