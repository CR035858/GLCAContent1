package com.cts.client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.cts.model.Employee;
import com.cts.service.EmployeeService;

public class EmployeeDataManagement {
	
	Connection con;
	ResultSet rs;
	String ans;
	int option;
	Scanner scan1;
	EmployeeService empService;
	ArrayList <Employee> employees;
	Employee emp;
	
	public EmployeeDataManagement()
	{
		ans="yes";
		scan1 = new Scanner(System.in);
		empService = new EmployeeService();
	}
	public void displayEmployeesRecords()
	{
		employees = empService.getEmployeeRecords();
		Iterator empIter = employees.iterator();
		while(empIter.hasNext())
		{
			Employee e =(Employee)empIter.next();
			System.out.println(e);
		}
	}
	public void displayExistingEmployeeIds()
	{
		
		
	}
	public boolean checkIfIdExists(String eId)
	{
		boolean flag = false;
		
		return flag;
	}
	public String generateEmployeeId()
	{
		String newEmpId="";
		
		return newEmpId;
	}
	public void showMenu()
	{
		while(ans.equals("yes") || ans.equals("YES"))
		{
			System.out.println("............. Employee Details Management Menu.........");
			System.out.println("1.View All Employees");
			System.out.println("2.Search Employee By ID");
			System.out.println("3.Insert Employee Record");
			System.out.println("4.Delete Employee ID");
			System.out.println("5.Update Employee");
			System.out.println("6.Exit");
			
			System.out.println("Please enter Your Option...");
			option = scan1.nextInt();
			switch(option)
			{
				case 1:
				{
					System.out.println("Viewing All Employees...");
					displayEmployeesRecords();
					break;
				}
				case 2:
				{
					System.out.println("Searching Employee By Id...");
					
					break;
				}
				case 3:
				{
					System.out.println("Inserting Employee Record...");
					
					
					break;
				}
				case 4:
				{
					String eId;
					
					break;
				}
				case 5:
				{
					emp = new Employee();
					
					break;
				}
				case 6:
				{
					System.out.println("Exiting Application...");
					//System.exit(0);
					break;
				}
				default:
				{
					break;
				}
					
			
			}
			
			System.out.println("Do You Wish to Continue yes/no?");
			ans = scan1.next();
		}
		System.out.println("We are out of Menu...");
	}
	

}
