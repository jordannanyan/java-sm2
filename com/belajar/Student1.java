package com.belajar;

import java.util.Scanner;

public class Student1 {
	public static void main(String[] args) {
		String fName, lName, stuId, stuStatus;
	    Scanner input = new Scanner(System.in);
	    fName = input.nextLine();
	    lName = input.nextLine();
	    stuId = input.nextLine();
	    stuStatus = input.nextLine();
	    System.out.println(fName);
	    System.out.print("Student Name: \t");
	    System.out.println(lName);
	    System.out.print("Student ID: \t");
	    System.out.println(stuId);
	    System.out.print("Student Status: \t");
	    System.out.println(stuStatus);
	}
}
