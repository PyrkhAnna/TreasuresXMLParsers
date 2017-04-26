package com.epam.ht4.temp;

import java.math.BigDecimal;

import com.epam.ht4.bean.Weapon;

public class Axe extends Weapon {
	private String handle;
	private String blade;
	private int damage;
	public Axe(String id, BigDecimal price, String title, String type, String handle, String blade, int damage) {
		super(id, price, title, type);
		this.handle = handle;
		this.blade = blade;
		this.damage = damage;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public String getBlade() {
		return blade;
	}
	public void setBlade(String blade) {
		this.blade = blade;
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
		result = prime * result + ((blade == null) ? 0 : blade.hashCode());
		result = prime * result + damage;
		result = prime * result + ((handle == null) ? 0 : handle.hashCode());
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
		if (blade == null) {
			if (other.blade != null)
				return false;
		} else if (!blade.equals(other.blade))
			return false;
		if (damage != other.damage)
			return false;
		if (handle == null) {
			if (other.handle != null)
				return false;
		} else if (!handle.equals(other.handle))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Axe [id=" + getId() + "title=" + getTitle() + ", type=" + getType() + "handle=" + handle + ", blade=" + blade + ", damage=" + damage + "]";
	}
	
}
