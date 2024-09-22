package com.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.model.Employee;
import com.dao.EmployeeDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class RegisterEmployee
 */
public class RegisterEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Employee e; //employee pojo class
       EmployeeDAO dao;//employee dao class
       public  int count=0;
       RequestDispatcher dispatcher;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		String command=request.getParameter("action");
		System.out.println(command);
		if(command.equals("view"))
		{
			dao=new EmployeeDAO();
			ArrayList<Employee> allemployee=dao.ShowEmployee();
			request.setAttribute("employeslist",allemployee);
			dispatcher=request.getRequestDispatcher("ViewAllEmployees.jsp");
			dispatcher.forward(request,response);
		}	
		if(command.equals("edit"))
		{
			int id=Integer.parseInt(request.getParameter("empid"));
			dao=new EmployeeDAO();
			ArrayList<Employee> employeeupdates=dao.updateEmployee(id);
			request.setAttribute("employeebyid",employeeupdates);
			dispatcher=request.getRequestDispatcher("UpdateEmployee.jsp");
			dispatcher.forward(request,response);
			
		}		
		if(command.equals("delete"))
		{
			int id=Integer.parseInt(request.getParameter("empid"));
			dao=new EmployeeDAO();
			count=dao.employeeDelete(id);
			ArrayList<Employee> allemployee=dao.ShowEmployee();
			request.setAttribute("employeslist",allemployee);
			dispatcher=request.getRequestDispatcher("ViewAllEmployees.jsp");
			dispatcher.forward(request,response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set effects in html content
		PrintWriter out=response.getWriter();
		response.setContentType("text/html"); 
		int eid=Integer.parseInt(request.getParameter("txtId"));
		String ename=request.getParameter("txtName");
		String epass=request.getParameter("txtPassword");
		String eemail=request.getParameter("txtEmail");
		String ecountry=request.getParameter("txtCountry");
		
		System.out.println(eid);
		System.out.println(ename);
		System.out.println(eemail);
		System.out.println(ecountry);
		System.out.println(epass);
		
		e=new Employee();//employee pojo class
		e.setId(eid);
		e.setCountry(ecountry);
		e.setEmail(eemail);
		e.setPassword(epass);
		e.setEname(ename);
		dao=new EmployeeDAO();
		
		count=dao.addEmployee(e);//passing DAOclass
		if(count!=0)
		{
			
			out.println("<h1 style='color:green;'>"+count+" Record Inserted Successfully.....</h1>");
			dispatcher=request.getRequestDispatcher("AddEmployee.jsp");
			dispatcher.include(request, response);
		}
		else
		{
			out.println("<h1 style='color:red;'> Record Insert failed!!...</h1>");
			dispatcher=request.getRequestDispatcher("AddEmployee.jsp");
			dispatcher.include(request, response);
		}
	}
	

}
