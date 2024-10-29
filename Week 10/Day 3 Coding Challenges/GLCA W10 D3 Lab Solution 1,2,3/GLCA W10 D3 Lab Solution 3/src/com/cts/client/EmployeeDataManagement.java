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
		ArrayList <String> employeeIds = new ArrayList<String>();
		employeeIds = empService.getAllEmployeeIds();
		Iterator idIter = employeeIds.iterator();
		System.out.println("The Employee Ids Are...");
		while(idIter.hasNext())
		{
			String idStr = (String)idIter.next();
			System.out.println(idStr);
			
		}
		
	}
	public boolean checkIfIdExists(String eId)
	{
		boolean flag = false;
		ArrayList <String> employeeIds = new ArrayList<String>();
		employeeIds = empService.getAllEmployeeIds();
		Iterator idIter = employeeIds.iterator();
		String existingId;
		while(idIter.hasNext())
		{
			existingId = (String)idIter.next();
			if(existingId.equals(eId))
			{
				flag = true;
				break;
			}
			else
			{
				flag = false;
			}
		}
		return flag;
	}
	public String generateEmployeeId()
	{
		String newEmpId="";
		String maxId="";
		maxId= empService.fetchMaxEmployeeId();
		String preId="",postId="";
		//Finding PreFix Part of E001 as E
		// and Finding PostFix part of E001 as 001
		preId = maxId.substring(0, 1);
		postId = maxId.substring(1, 4);
		//E001 to E999
		//Converting PostFix part to Integer
		int postNum = Integer.parseInt(postId);
		//Incrementing the PostFix part
		postNum+=1;
		//ASSUMPTION IS 999 employees
		if((postNum >= 0) &&(postNum <= 9))
		{
			newEmpId = "E00"+postNum;
		}
		else if((postNum > 9) &&(postNum <= 99))
		{
			newEmpId = "E0"+postNum;
		}
		else if((postNum > 99) &&(postNum <= 999))
		{
			newEmpId = "E"+postNum;
		}
		else
		{
			newEmpId ="Invalid";
		}
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
					String emplId;
					displayExistingEmployeeIds();
					System.out.println("Please Enter the Employee Id whose record you wish to see...");
					emplId = scan1.next();
					if(checkIfIdExists(emplId))
					{
						emp = empService.searchEmployeeById(emplId);
						System.out.println("The Employee is "+emp);
					}
					else
					{
						System.out.println("Sorry Employee ID Does not Exist....");
					}
					break;
				}
				case 3:
				{
					System.out.println("Next Employee Id: "+generateEmployeeId());
					System.out.println("Inserting Employee Record...");
					
					emp = new Employee();
					
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
