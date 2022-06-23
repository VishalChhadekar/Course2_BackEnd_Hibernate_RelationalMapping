package com.hibernate.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.Address;
import com.hibernate.entity.Course;
import com.hibernate.entity.Customer;
import com.hibernate.entity.PhoneNumber;
import com.hibernate.util.HibernateUtil;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/add_Customer")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("add_Customer.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1>Working</h1>");
		// customer details
		String cust_name = request.getParameter("Cust_name");
		String cust_email = request.getParameter("Cust_email");
		String cust_phone = request.getParameter("Cust_phone");

		// address inpput
		String cust_street = request.getParameter("Cust_street");
		String cust_city = request.getParameter("Cust_city");
		String cust_state = request.getParameter("Cust_state");

		// set input values to attributes of Customer class
		Customer customer = new Customer();
		customer.setName(cust_name);
		customer.setEmail(cust_email);
		customer.setPhone(Long.parseLong(cust_phone));

		// setting values to Address attributes
		Address address = new Address();
		address.setCity(cust_city);
		address.setStreet(cust_street);
		address.setState(cust_state);

		//
		customer.setAddress(address);

		// Phones input
		// PhoneNumber 1
		String phone1 = request.getParameter("phone_1");
		String phone1type = request.getParameter("phone_1_type");
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setPhoneNumber(phone1);
		ph1.setPhoneType(phone1type);

		// PhoneNumber 2
		String phone2 = request.getParameter("phone_2");
		String phone2type = request.getParameter("phone_2_type");
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setPhoneNumber(phone2);
		ph2.setPhoneType(phone2type);

		// PhoneNumber 3
		String phone3 = request.getParameter("phone_3");
		String phone3type = request.getParameter("phone_3_type");
		PhoneNumber ph3 = new PhoneNumber();
		ph3.setPhoneNumber(phone3);
		ph3.setPhoneType(phone3type);

		// add all the phone number into List of phones
		List<PhoneNumber> phones = new ArrayList<>();
		phones.add(ph1);
		phones.add(ph2);
		phones.add(ph3);

		// set the list to set to setPhones method of Customer class: which take list
		customer.setPhones(phones);

		// Read Course1
		String courseName1 = request.getParameter("course_1");
		String courseType1 = request.getParameter("course_type_1");

		Course course1 = new Course();
		course1.setCourseName(courseName1);
		course1.setCourseType(courseType1);
		

		// Read Course2
		String courseName2 = request.getParameter("course_2");
		String courseType2 = request.getParameter("course_type_2");

		Course course2 = new Course();
		course2.setCourseName(courseName2);
		course2.setCourseType(courseType2);
		

		// Read Course3
		String courseName3 = request.getParameter("course_3");
		String courseType3 = request.getParameter("course_type_3");

		Course course3 = new Course();
		course3.setCourseName(courseName3);
		course3.setCourseType(courseType3);
	

		List<Course> cus_course = new ArrayList<>();
		cus_course.add(course1);
		cus_course.add(course2);
		cus_course.add(course3);
		
		customer.setCourse(cus_course);

	

		// Data Base connectivity
		// 1: Load session factory
		SessionFactory sf = HibernateUtil.getSessionFactory();

		// 2: get Session obj
		Session session = sf.openSession();
		// open transaction
		Transaction tx = session.beginTransaction();

		session.save(customer);
		// commit operations
		tx.commit();
		// close session
		session.close();
		out.append("Customer added successfully!");

	}

}
