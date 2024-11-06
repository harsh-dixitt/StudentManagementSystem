package com.management.entities;


//StudentManagement POJO -- Entity class
public class StudentManagement {
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private int age;
	
	
	public StudentManagement() {
	}


	public StudentManagement(int id, String first_name, String last_name, String email, int age) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.age = age;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "StudentManagement [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", age=" + age + "]";
	}


	
	
	
	
	

}
