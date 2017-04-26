package com.epam.ht4.temp;

import java.math.BigDecimal;

import com.epam.ht4.bean.Weapon;

public class Sword extends Weapon{
	private String material;
	private BigDecimal weight;
	private BigDecimal length;
	private BigDecimal thickness;
	private int damage;
	public Sword(String id, BigDecimal price, String title, String type, String material, BigDecimal weight,
			BigDecimal length, BigDecimal thickness, int damage) {
		super(id, price, title, type);
		this.material = material;
		this.weight = weight;
		this.length = length;
		this.thickness = thickness;
		this.damage = damage;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	public BigDecimal getLength() {
		return length;
	}
	public void setLength(BigDecimal length) {
		this.length = length;
	}
	public BigDecimal getThickness() {
		return thickness;
	}
	public void setThickness(BigDecimal thickness) {
		this.thickness = thickness;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	@Override
	public String toString() {
		return "Sword [id=" + getId() + "title=" + getTitle() + ", type=" + getType() + "material=" + material + ", weight=" + weight + ", length=" + length + ", thickness=" + thickness
				+ ", damage=" + damage + "]";
	}
	
}
