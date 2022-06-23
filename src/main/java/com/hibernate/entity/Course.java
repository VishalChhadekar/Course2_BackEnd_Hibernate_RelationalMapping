package com.hibernate.entity;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course_cust")
public class Course {

	@Id
	@GeneratedValue
	@Column(name="c_id")
	private long courseId;
	
	@Column(name="c_name")
	private String courseName;
	
	@Column(name="c_type")
	private String courseType;

	@ManyToMany(cascade=CascadeType.ALL, mappedBy="course")
	private List<Customer> customer;

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public List<Customer> getStudents() {
		return customer;
	}

	public void setStudents(List<Customer> students) {
		this.customer = students;
	}
}
