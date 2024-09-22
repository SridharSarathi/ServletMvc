package com.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.dao.EmployeeDAO;
import com.model.Employee;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Employee e;
       EmployeeDAO dao;
       int count;
       RequestDispatcher dispatcher;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
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
		PrintWriter out=response.getWriter();
		response.setContentType("text/html"); 
		int eid=Integer.parseInt(request.getParameter("txtId"));
		String ename=request.getParameter("txtName");
		String epass=request.getParameter("txtPassword");
		String eemail=request.getParameter("txtEmail");
		String ecountry=request.getParameter("txtCountry");
		
		System.out.println(eid);
		System.out.println(ename);
		System.out.println(epass);
		System.out.println(eemail);
		System.out.println(ecountry);
		
		
		e=new Employee();//employee pojo class
		e.setId(eid);
		e.setCountry(ecountry);
		e.setEmail(eemail);
		e.setPassword(epass);
		e.setEname(ename);
		dao=new EmployeeDAO();
		
		count=dao.employeeupdate(e);
		System.out.println(count);
		out.println("<h1 style='color:red'>"+eid+"Update Failed...!</h1>");
		System.out.println("update checking");
	
		if(count==1)
		{  
			
			out.println("<h1 style='color:green'>"+eid+"Update Successfull</h1>");
			dispatcher=request.getRequestDispatcher("ViewAllEmployees.jsp");
			dispatcher.forward(request,response);
			System.out.println("finish");
			
		}	
		else
		{
			out.println("<h1 style='color:red'>"+eid+"Update Failed...!</h1>");
			dispatcher=request.getRequestDispatcher("UpdateEmployee.jsp");
			dispatcher.forward(request,response);
		}	
	}

}
