package com.Employee1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Employee1.Dao.Employee_Insert;
import com.Employee1.bean.Employee;

/**
 * Servlet implementation class EmployeeDataFetch
 */
@WebServlet("/EmployeeDataFetch")
public class EmployeeDataFetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDataFetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  List<Employee> al=new ArrayList();
	  PrintWriter pw=response.getWriter();
	  try {
		  System.out.println("Hii");
		al=Employee_Insert.fetch();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  pw.println("<body style='background-image: url(https://img.freepik.com/free-vector/blank-brown-notepaper-design-vector_53876-175008.jpg?w=996&t=st=1719641893~exp=1719642493~hmac=20651dde1d3addd80dde2fd7f64355afcda44a0e10232c5859a6ffcf88341d13)'>");
	  pw.println("<h1>All Employee details:</h1>");
	  pw.println("<table width='100%' border='1 solid' color='black'>");
	  pw.println("<tr><th>Id</th>");
	  pw.println("<th>Name</th>");	
	  pw.println("<th>Email</th>");	
	  pw.println("<th>Phone</th>");	
	  pw.println("<th>Address</th>");
	  pw.println("<th>Edit</th>");
	  pw.println("<th>Delete</th></tr>");
	  for(Employee s:al) {
	  pw.println("<tr><td>"+s.getId()+"</td><td>"+s.getName()+"</td><td>"+s.getEmail()+"</td><td>"+s.getContact()+"</td><td>"+s.getAddress()+"</td><td><a href='EditServlet?id="+s.getId()+"'>Edit</a></td><td><a href='deleteServlet?id="+s.getId()+"'>Delete</a></td></tr>");
	  }
	  pw.println("</table>");
	  
	  pw.println("<a href='" + request.getContextPath() + "/Employee_servlet'>Add New Employee</a>");

	  pw.println("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
