package com.test.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Teacher implements Serializable{

	private String id;
	private String name;
	private String sex;
	private String tCourse;
	
	private Set<Student> student = new HashSet<Student>();

	
	public Teacher() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String gettCourse() {
		return tCourse;
	}

	public void settCourse(String tCourse) {
		this.tCourse = tCourse;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", sex=" + sex + ", tCourse=" + tCourse + ", student=" + student
				+ "]";
	}
	
	
}
