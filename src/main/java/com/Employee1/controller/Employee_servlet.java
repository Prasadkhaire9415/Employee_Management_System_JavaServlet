package com.Employee1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Employee1.Dao.Employee_Insert;
import com.Employee1.bean.Employee;

/**
 * Servlet implementation class Student_servlet
 */
@WebServlet("/Employee_servlet")
public class Employee_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Employee_servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Employee ob=new Employee();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("contact");
		String address=request.getParameter("address");
		
		ob.setId(id);
		ob.setName(name);
		ob.setEmail(email);
		ob.setContact(phone);
		ob.setAddress(address);
		
		PrintWriter pw=response.getWriter();
		
		try {
			int status=Employee_Insert.insert(ob);
		 
			if(status!=0) {
				pw.println("<p>Data Insertion Successfully..</p>");
				request.getRequestDispatcher("index.html").include(request, response);
			}
			else {
				pw.println("<p>Data Insertion Failed..</p>");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
