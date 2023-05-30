package com.belajar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner; 

public class praktikum1 {

    public static void main(String[] args) { 
        Scanner input = new Scanner (System.in); 
        int a,b,tambah,kurang; 
        System.out.print(" Bilangan Pertama : "); 
        a = input.nextInt(); 
        System.out.print(" Bilangan Kedua : "); 
        b = input.nextInt(); 
        tambah = a+b; 
        kurang = a-b; 
        System.out.println(" Hasil Penjumlahan :"+tambah); 
        System.out.println(" Hasil Pengurangan :"+kurang); 
    }

	public static String bacaString() {
	    BufferedReader bfr
	    = new BufferedReader (new InputStreamReader (System.in), 1);
	    String string = (""); 
	    try {
	    string = bfr.readLine();    
	    }
	    catch (IOException ex){
	    System.out.println(ex);
	    }
	    return string;
	} 


}
