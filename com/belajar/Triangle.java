package com.belajar;

import java.util.Scanner;

public class Triangle {
	public static void main (String [] args) {
		Double A, b, h;
		
		Scanner input = new Scanner(System.in);
		
		b = input.nextDouble();
		h = input.nextDouble();
		
		A=(b*h)/2;
		
		System.out.print("Luas Segitiga : ");
		System.out.println(A);
	}
}
