package com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.cts.connection.MyConnection;
import com.cts.model.Employee;

public class EmployeeDAO {
	
	Connection con;
	ResultSet rs;
	Statement stmt;
	PreparedStatement pstmt;
	Employee employee;
	ArrayList <Employee> employees;
	MyConnection mycon;

	public EmployeeDAO()
	{
		employee = new Employee();
		employees = new ArrayList<Employee>();
		mycon = new MyConnection();
		
	}

	
	public ArrayList <Employee> getAllEmployees()
	{
		con = mycon.getMyConnections();
		employees = new ArrayList<Employee>();
		try
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from Employee");
			while(rs.next())
			{
				Employee e = new Employee();
				/*String empId = rs.getString(1);
				e.setEmployeeId(empId);*/
				
				e.setEmployeeId(rs.getString(1));
				e.setEmployeeName(rs.getString(2));
				e.setEmployeeAddress(rs.getString(3));
				e.setEmployeePhone(rs.getString(4));
				e.setEmployeeSalary(rs.getInt(5));
				e.setEmployeeTax(rs.getFloat(6));
				
				employees.add(e);
			}
			
		}
		catch(SQLException sqe)
		{
			sqe.printStackTrace();
		}
		return employees;
	}
	
	public Employee getEmployeeById(String empId)
	{
		con = mycon.getMyConnections();
		employee = new Employee();
		try 
		{
			pstmt = con.prepareStatement("select * from Employee where EmployeeId = ?");
			pstmt.setString(1, empId);
			rs = pstmt.executeQuery();
			rs.next();
			employee.setEmployeeId(rs.getString(1));
			employee.setEmployeeName(rs.getString(2));
			employee.setEmployeeAddress(rs.getString(3));
			employee.setEmployeePhone(rs.getString(4));
			employee.setEmployeeSalary(rs.getInt(5));
			employee.setEmployeeTax(rs.getFloat(6));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employee;
	}
	
	public boolean deleteEmployeeById(String empId)
	{
		boolean flag = false;
		
		return flag;
	}
	public boolean updateEmployee(Employee empU)
	{
		boolean flag = false;
	
		
		return flag;
	}
	public boolean insertEmployee(Employee empI)
	{
		boolean flag = false;
		
		
		return flag;
	}
	public ArrayList <String> getEmployeeIds()
	{
		ArrayList <String> empids = new ArrayList<String>();
		con = mycon.getMyConnections();
		try 
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery("select employeeId from Employee");
			while(rs.next())
			{
				String eid = rs.getString(1);
				empids.add(eid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empids;
	}
	public String getMaxEmployeeId()
	{
		String maxId="";
	
		return maxId;
	}
}
