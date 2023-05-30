package com.belajar;

import java.util.Scanner;

public class tugas1modul2 {

       
      public static void main(String args[]){
        try (Scanner inputan = new Scanner (System.in)) {
            //Membuat variabel dimensional array
            int A[][]=new int[2][3];
            int B[][]=new int[2][3];
            int penjumlahan[][]=new int[2][3];

            //Clear screen
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Program Perhitungan Matriks 2x3");
            System.out.println("===================================");
            System.out.println();

            System.out.println("Masukkan Nilai Matriks Pertama");
            System.out.println("=======================");

            //Pengulangan for untuk memasukan nilai matriks A
            for(int i=0;i<2;i++)
            {
                for(int j=0;j<3;j++)
                {
                    System.out.print("[" +(i+1)+ "][" +(j+1)+ "]:");
                    A[i][j]=inputan.nextInt();
                }
            }
            
            System.out.println("\nMasukkan Nilai Matriks Kedua");
            System.out.println("==========================");

            //Pengulangan for untuk nilai matriks B
            for(int i=0;i<2;i++)
            {
                for(int j=0;j<3;j++)
                {
                    System.out.print("[" +(i+1)+ "][" +(j+1)+ "]:");
                    B[i][j]=inputan.nextInt();
                }
            }
            
            //Pengulangan for untuk penjumlahan kedua matriks
            for(int i=0;i<2;i++)
            {
                for(int j=0;j<3;j++)
                {
                    penjumlahan[i][j]=A[i][j]+B[i][j];
                }
            }
     
            System.out.println("Hasil penjumlahan Matriks");
            System.out.println("===========================");
            
            //Pengulangan for untuk menunjukan nilai matriks 2x3
            for(int i=0;i<2;i++)
            {
                for(int j=0;j<3;j++)
                {
                    System.out.print(+(penjumlahan[i][j])+" ");
                }
                System.out.println("");
            }
        } 
    }
       
 }
    
    
