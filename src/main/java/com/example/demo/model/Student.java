package com.example.demo.model;

public class Student {

	public Student() {

	}

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Student(Integer id, String name, Integer rank, Integer age, String collegename) {
		super();
		this.id = id;
		this.name = name;
		this.rank = rank;
		this.age = age;
		this.collegename = collegename;
	}

	public Integer id;
	public String name;
	public Integer rank;
	public Integer age;
	public String collegename;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", rank=" + rank + ", age=" + age + ", collegename="
				+ collegename + "]";
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

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

}
