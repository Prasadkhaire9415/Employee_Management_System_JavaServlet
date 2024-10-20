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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		try {
			Employee ob=Employee_Insert.getbyid(id);
			pw.println("<body style='background-image: url(https://img.freepik.com/free-vector/blank-brown-notepaper-design-vector_53876-175008.jpg?w=996&t=st=1719641893~exp=1719642493~hmac=20651dde1d3addd80dde2fd7f64355afcda44a0e10232c5859a6ffcf88341d13)'>");
			pw.println("<h1>Edit record:</h1>");
			pw.println("<form action='EditServlet2' method='post' font-size='15px'>");
			pw.println("<input type='hidden' name='id' value='"+ob.getId()+"'></input>");
			pw.println("Name:<input type='text' name='name' value='"+ob.getName()+"'></input>");
			pw.println("<br></br>");
			pw.println("Email:<input type='email' name='email' value='"+ob.getEmail()+"'></input>");
			pw.println("<br></br>");
			pw.println("Phone:<input type='text' name='phone' value='"+ob.getContact()+"'></input>");
			pw.println("<br></br>");
			pw.println("Address:<input type='text' name='address' value='"+ob.getAddress()+"'></input>");
			pw.println("<br></br>");
			pw.println("<button type='submit'>update</button>");
			pw.println("</form>");
			pw.println("</body>");
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
