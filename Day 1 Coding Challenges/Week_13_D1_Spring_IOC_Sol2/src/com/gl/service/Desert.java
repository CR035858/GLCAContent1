package com.gl.service;

import java.util.Scanner;
import java.util.TreeMap;

public class Desert implements CustomFoods {

	Scanner sc = new Scanner(System.in);
	TreeMap<Integer, String> desert = new TreeMap<Integer, String>();
	
	{
		desert.put(301, "vennila Milkshake");
		desert.put(302, "Mango Milkshake");
		desert.put(303, "ButterScotoch");
		desert.put(304, "Death by Choclate");
		desert.put(305, "choclate Fudge");
	}
	
	@Override
	public String getFood() {

		System.out.println("Pick one desert\n"+desert);
		int choice = sc.nextInt();

		if(choice>=desert.firstKey() && choice<=desert.lastKey()) {
			return desert.get(choice);
		}
		return "invlaid data";
	}	
}
