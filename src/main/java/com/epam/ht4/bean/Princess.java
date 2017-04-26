package com.epam.ht4.bean;

public class Princess extends Treasure {
	private String name;
	private int age;
	private boolean damnation;
	private String birthplace;

	public Princess(String id, String name, int age, boolean damnation, String birthplace) {
		super(id);
		this.name = name;
		this.age = age;
		this.damnation = damnation;
		this.birthplace = birthplace;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isDamnation() {
		return damnation;
	}

	public void setDamnation(boolean damnation) {
		this.damnation = damnation;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((birthplace == null) ? 0 : birthplace.hashCode());
		result = prime * result + (damnation ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Princess other = (Princess) obj;
		if (age != other.age)
			return false;
		if (birthplace == null) {
			if (other.birthplace != null)
				return false;
		} else if (!birthplace.equals(other.birthplace))
			return false;
		if (damnation != other.damnation)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Personage [id=" + getId() + "name=" + name + ", age=" + age + ", damnation=" + damnation + ", birthplace=" + birthplace
				+ "]";
	}

}
