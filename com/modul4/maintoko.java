package com.modul4;

import java.util.Scanner;

public class maintoko {
    public static void main(String[] args){
        char pilihan;
        do {
            int i;
            Scanner input = new Scanner(System.in);
            datapenjualan datkar = new datapenjualan();
            System.out.print("Berapa Hari Penjualan: ");
            datkar.setJmlKaryawan(myInput.bacaInt());
            for (i = 0; i < datkar.n; i++) {
                System.out.println();
                System.out.println("Hari ke- " + (i + 1));
                System.out.print("Masukan Nama Kasir         : ");
                datkar.setNamakasir(i, myInput.bacaString());
                System.out.print("Masukan Tanggal Penjualan : ");
                datkar.setTanggal(i, myInput.bacaString());
                System.out.print("Masukan Keuntungan Toko   : ");
                datkar.setKeuntungan(i, myInput.bacaInt());
            }
            datkar.tampilData();

            System.out.print("APAKAH ANDA INGIN MENGULANG (Y/T) : "); pilihan = input.next().charAt(0);
        } while (pilihan == 'y');
    }
}
