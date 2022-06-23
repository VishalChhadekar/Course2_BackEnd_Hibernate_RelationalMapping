package com.hibernate.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.hibernate.entity.Customer;
import com.hibernate.util.HibernateUtil;

/**
 * Servlet implementation class ReadCustomerServlet
 */
@WebServlet("/read_Customer")
public class ReadCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadCustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		List<Customer> customer = session.createQuery("from Customer").list();
		// no need to provide the table name, entity name is sufficient as HQL

		out.println("<h1>Customer List :-</h1>");
		out.println("<style> table,td,th { border:2px solid green; padding:10px; } </style>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th> Customer Id </th>");
		out.println("<th> Customer Name </th>");
		out.println("<th> Customer Eamil </th>");
		out.println("<th> Customer Phone Numbers </th>");
		out.println("<th> Customer Address </th>");
		out.println("<th> Customer Phones </th>");
		out.println("<th> Customer Course </th>");
		

		out.println("</tr>");

		for (Customer st : customer) {
			out.println("<tr>");
			out.println("<td>" + st.getId() + "</td>");
			out.println("<td>" + st.getName() + "</td>");
			out.println("<td>" + st.getEmail() + "</td>");
			out.println("<td>" + st.getPhone() + "</td>");
			out.println("<td>" + st.getAddress()+ "</td>");
			out.println("<td>" + st.getPhones()+ "</td>");
			out.println("<td>" + st.getCourse()+ "</td>");
			
			out.println("</tr>");
		}
		out.println("</table></body></html>");
		session.close();
		out.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
