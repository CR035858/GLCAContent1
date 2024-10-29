package com.cts.service;

import java.util.ArrayList;

import com.cts.dao.EmployeeDAO;
import com.cts.model.Employee;

public class EmployeeService {
	
	EmployeeDAO edao;
	
	public EmployeeService()
	{
		edao = new EmployeeDAO();
	}
	
	public ArrayList <Employee> getEmployeeRecords()
	{
		ArrayList <Employee> employees = new ArrayList<Employee>();
		employees = edao.getAllEmployees();
		return employees;
	}
	
	public Employee searchEmployeeById(String empId)
	{
		return new Employee();
	}
	
	public boolean insertEmployeeRecord(Employee emplI)
	{
		return false;
	}
	
	public boolean updateEmployeeRecord(Employee emplU)
	{
		boolean flag = false;
		return flag;
	}
	public boolean deleteEmployeeRecord(String empId)
	{
		boolean flag = false;
		
				
		return flag;
	}
	public ArrayList <String> getAllEmployeeIds()
	{
		ArrayList <String> ids = new ArrayList<String>();
		
		return ids;
	}
	public String fetchMaxEmployeeId()
	{
		String maxEmpId="";
		maxEmpId = edao.getMaxEmployeeId();
		return maxEmpId;
	}

}
