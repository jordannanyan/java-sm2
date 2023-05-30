package com.belajar;

public class managingperson {
	public static void main(String[] args){
		Person1 p1 = new Person1("Arial", 37);
		Person1 p2 = new Person1("Joseph", 15);
		
		if(p1.getAge()==p2.getAge()) {
			System.out.println(p1.getName()+" is the same age as "+p2.getName());
		}
		else {
			System.out.println(p1.getName()+" is not the same age as "+p2.getName());
		}
	}
}
