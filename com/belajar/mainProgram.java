package com.belajar;
import java.util.Scanner;
import com.belajar.Tugas1;
import com.belajar.Tugas2;
import com.belajar.Tugas3;

public class mainProgram {
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    int choice;
	    do {
	    	System.out.println("===== RESPONSI ALPRO II =====");
	        System.out.println("===== 	MENU UTAMA	=====");
	        System.out.println("1. Program Tugas 1");
	        System.out.println("2. Program Tugas 2");
	        System.out.println("3. Program Tugas 3");
	        System.out.println("4. Keluar");
	        System.out.print("Pilihan Anda: ");
	        choice = scanner.nextInt();
	        System.out.println();

	        switch (choice) {
	            case 1:
	                // Memanggil method di Class Tugas1
	            	Tugas1.main(args);
	                break;
	            case 2:
	                // Memanggil method di Class Tugas2
	            	Tugas2.main(args);
	                break;
	            case 3:
	                // Memanggil method di Class Tugas3
	            	Tugas3.main(args);
	                break;
	            case 4:
	                System.out.println("Terima kasih!");
	                break;
	            default:
	                System.out.println("Pilihan tidak valid!");
	        }
	    } while (choice != 4);

	    scanner.close();
	}

}
