package com.epam.ht4.bean;

import java.math.BigDecimal;

public class Stick extends Weapon {
	private String material;
	private String tip;
	public Stick(String id, BigDecimal price, String title, String type, String material, String tip) {
		super(id, price, title, type);
		this.material = material;
		this.tip = tip;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((tip == null) ? 0 : tip.hashCode());
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
		Stick other = (Stick) obj;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (tip == null) {
			if (other.tip != null)
				return false;
		} else if (!tip.equals(other.tip))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Stick [id=" + getId() + "title=" + getTitle() + ", type=" + getType() + "material=" + material + ", tip=" + tip + "]";
	}
	
}
