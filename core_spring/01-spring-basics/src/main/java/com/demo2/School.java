package com.demo2;

import java.util.List;

public class School {

	private String schoolName;
	private List<Student> students;

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void printDetails() {
		System.out.println("school name : " + schoolName);
		System.out.println("student details: ");
		for (Student s : students) {
			System.out.println(s);
		}
	}
}
