package com.belajar;
import java.util.Scanner;
public class jjj {


    public static void main (String[]args) {
		Scanner masukan = new Scanner(System.in);
		float a, b, c;
		char x;
		
		System.out.print("Masukkan angka pertama : ");
		a = masukan.nextFloat();
		
		System.out.print("Masukkan angka kedua : ");
		b = masukan.nextFloat();
		
		System.out.print("Masukkan jenis operasi yang ingin dilakukan (x,+,-,/): ");
		x = masukan.next().charAt(0);
		
		if (x == '+') {
			c = a+b;
            System.out.println("Hasil penjumlahan adalah :"+c);
		}
        else if (x=='-') {
            c = a - b;
            System.out.println("Hasil pengurangan adalah :"+c);
        }
        else if (x=='x') {
            c = a*b;
            System.out.println("Hasil perkalian adalah :"+c);
        }
        else if (x=='/') {
            c = a/b;
            System.out.println("Hasil pembagian adalah :"+c);
        }
        else {
            System.out.println("Operasi yang dipilih tidak ada");
        }
		
		
		
		
		
		
	}

}
