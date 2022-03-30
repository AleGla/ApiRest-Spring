package com.AleGla.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="people")
public class People {

	@Id
	@Column(name="id_person")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="lastname", nullable=false)
	private String lastName;
	
	@Column(name="age", nullable=false)
	private Integer age;
	
	@Column(name="DNI", nullable=false)
	private String DNI;
	
	@Column(name="nationality", nullable=false)
	private String Nationality;
	
	@Column(name="gender", nullable=false)
	private char gender;
	
	public People() {}
	
	public People(String name, String lastName, Integer age, String DNI, String Nationality, char gender) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.DNI =DNI;
		this.Nationality = Nationality;
		this.gender = gender;
	}
		

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", lastName=" + lastName + ", age=" + age + ", DNI=" + DNI + ", Nacionality="
				+ Nationality + ", gender=" + gender + "]";
	}		
}
