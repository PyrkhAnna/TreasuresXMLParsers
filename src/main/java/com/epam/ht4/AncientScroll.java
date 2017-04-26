package com.epam.ht4;

import java.util.List;

public class AncientScroll extends Treasure
{	
	private String title;
	private int age;
	private String content;
	private String schoolOfMagic;	
	private double price;	
	
	public AncientScroll(List<String> parameters) {
		super(Integer.parseInt(parameters.get(0)));		
		initialize(parameters);	
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSchoolOfMagic() {
		return schoolOfMagic;
	}

	public void setSchoolOfMagic(String schoolOfMagic) {
		this.schoolOfMagic = schoolOfMagic;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "AncientScroll [Id=" + getId() + ", title=" + title + ", age=" + age + ", content=" + content
				+ ", schoolOfMagic=" + schoolOfMagic + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + age;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((schoolOfMagic == null) ? 0 : schoolOfMagic.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		AncientScroll other = (AncientScroll) obj;
		if (age != other.age)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (schoolOfMagic == null) {
			if (other.schoolOfMagic != null)
				return false;
		} else if (!schoolOfMagic.equals(other.schoolOfMagic))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


}
