package com.gl.service;

import java.util.Scanner;
import java.util.TreeMap;

public class Starters implements CustomFoods {

	TreeMap<Integer, String> starters = new TreeMap<Integer, String>();
	Scanner sc = new Scanner(System.in);

	{
		starters.put(101, "Manchuriya");
		starters.put(102, "Tandoori chicken");
		starters.put(103, "chicken kebab");

	}
	@Override
	public String getFood() {
		System.out.println("Pick one starter\n"+starters);

		int choice = sc.nextInt();

		if(choice>=starters.firstKey() && choice<=starters.lastKey()) {
			return starters.get(choice);
		}

		return "invalid data";
	}
}
