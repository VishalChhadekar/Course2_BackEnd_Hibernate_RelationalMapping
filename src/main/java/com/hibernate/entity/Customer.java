package com.hibernate.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerDetails")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name = "Cust_Id")
	private int id;
	@Column(name = "Cust_Name")
	private String name;
	@Column(name = "Cust_Enail")
	private String email;
	@Column(name = "Cust_Phone")
	private long phone;

	// Address type attribute with mapping: Embedded Annotation

	@Embedded
	private Address address;

	// List of customer's phone numbers with mapping OneToMany
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PhoneNumber> phones;
	
	
	// Course: Assignment, Mapping: ManyToMany

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "cust_course_link", joinColumns = @JoinColumn(name = "Cust_Id"), inverseJoinColumns = @JoinColumn(name = "c_id"))
	private List<Course> course;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		if (address == null)
			return "";

		return address.getStreet() + "," + address.getCity() + "," + address.getState();

	}

	public void setAddress(Address address) {
		this.address = address;
	}

	// getter setter for phones

	public String getPhones() {
		StringBuilder sb = new StringBuilder();
		if (phones != null && phones.size() > 0) {
			for (PhoneNumber cp : phones) {
				sb.append(cp.getPhoneNumber() + " , ");
			}
		}
		return sb.toString();
	}

	public void setPhones(List<PhoneNumber> phones) {
		this.phones = phones;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
	//getter and setter for course

	public String getCourse() {
		StringBuilder sb = new StringBuilder();
		if (course != null) {
			for (Course c : course) {
				sb.append(c.getCourseName() + ", ");
			}
		}
		return sb.toString();
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}
	
	

}
