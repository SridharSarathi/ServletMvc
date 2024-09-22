package com.dao;
import java.sql.Statement;

import com.daoutil.DBConnection;
import com.model.Employee;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import com.model.*;
import java.util.ArrayList;


public class EmployeeDAO {
	
	
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	Connection dbcon;
	int count;
	public EmployeeDAO() {
		System.out.println("DAO Class Object Created");
		dbcon=DBConnection.getconnection();
	}
	
	//Insert Operation
	public int addEmployee(Employee e)//get the value in servlet and using employee class methods
	{
		try {	
			ps=dbcon.prepareStatement("INSERT INTO EMPLOYEE(EMPID,EMPNAME,EMPPASS,EMPMAIL,EMPCOUNTRY)"+"VALUES(?,?,?,?,?)");
			ps.setInt(1,e.getId());
			ps.setString(2, e.getEname());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getCountry());
			count=ps.executeUpdate();
		} catch (SQLException exe) {
			
			exe.printStackTrace();
		}
		return count;
	}
	
	public ArrayList ShowEmployee()//get data from database
	{
		ArrayList<Employee> al=new ArrayList();
		try {
			
			stmt=dbcon.createStatement();
			rs=stmt.executeQuery("SELECT * FROM EMPLOYEE");
			while(rs.next())
			{
				Employee E=new Employee();
				E.setId(rs.getInt("EMPID"));
				E.setEname(rs.getString("EMPNAME"));
				E.setPassword(rs.getString("EMPPASS"));
				E.setEmail(rs.getString("EMPMAIL"));
				E.setCountry(rs.getString("EMPCOUNTRY"));
				al.add(E);
			}	
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	  return al;
	}
	public ArrayList<Employee> updateEmployee(int id)
	{
		ArrayList<Employee> updateList=new ArrayList();
		try {
			
			stmt=dbcon.createStatement();
			rs=stmt.executeQuery("SELECT * FROM EMPLOYEE WHERE EMPID="+id);
			while(rs.next())
			{
				Employee E=new Employee();
				E.setId(rs.getInt("EMPID"));
				E.setEname(rs.getString("EMPNAME"));
				E.setPassword(rs.getString("EMPPASS"));
				E.setEmail(rs.getString("EMPMAIL"));
				E.setCountry(rs.getString("EMPCOUNTRY"));
				updateList.add(E);
			}	
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	  return updateList;		
		
		
	}
	public int employeeupdate(Employee e) 
	{
		try 
		{
			
			System.out.println(" Employee Details updating");
			ps=dbcon.prepareStatement("UPDATE  EMPLOYEE SET EMPNAME=?,EMPPASS=?,EMPMAIL=?,EMPCOUNTRY=? WHERE EMPID=?");

			ps.setString(1,e.getEname());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getCountry());
			ps.setInt(5,e.getId());
			count=ps.executeUpdate();
			System.out.println("Employee to update: " + e.getId() + ", " + e.getEname() + ", " + e.getPassword() + ", " + e.getEmail() + ", " + e.getCountry());

		}
		catch(Exception exc)
		{
			exc.printStackTrace();
	      
	        
	        
		}
		return count;
	}
	
	
	public int employeeDelete(int id)
	{	try 
		{
		ps=dbcon.prepareStatement("DELETE FROM EMPLOYEE WHERE EMPID=?");
		ps.setInt(1,id);
		count=ps.executeUpdate();
		}
		catch(Exception e)
			{
				e.printStackTrace();
			}
	return count;
	}
	
}


