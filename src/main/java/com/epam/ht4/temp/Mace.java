package com.epam.ht4.temp;

import java.math.BigDecimal;

import com.epam.ht4.bean.Weapon;

public class Mace extends Weapon {
	private BigDecimal size;
	private int damage;
	public Mace(String id, BigDecimal price, String title, String type, BigDecimal size, int damage) {
		super(id, price, title, type);
		this.size = size;
		this.damage = damage;
	}
	
	public BigDecimal getSize() {
		return size;
	}

	public void setSize(BigDecimal size) {
		this.size = size;
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
		Mace other = (Mace) obj;
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
		return "Mace [id=" + getId() + "title=" + getTitle() + ", type=" + getType() + "size=" + size + ", damage=" + damage + "]";
	}
	
}
