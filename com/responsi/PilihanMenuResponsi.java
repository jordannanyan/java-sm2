package com.responsi;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Scanner;

public class PilihanMenuResponsi {
    static void matriks() {
        char pilihan;
        do {
            int i, j, m, n;
            int[][] matriks1 = new int[35][35];
            int[][] matriks2 = new int[35][35];
            int[][] hasil = new int[35][35];
            Scanner scan = new Scanner(System.in);
            System.out.print("MASUKAN JUMLAH BARIS MATRIKS: "); m = scan.nextInt();
            System.out.print("MASUKAN JUMLAH KOLOM MATRIKS: "); n = scan.nextInt();
            System.out.println("\n");
            System.out.println("MASUKAN ELEMEN MATRIKS PERTAMA : ");
            for (i = 0; i < m; i++) {
                for (j = 0; j < n; j++) {
                    matriks1[i][j] = scan.nextInt();
                }
            }
            System.out.println("\n");
            System.out.println("MASUKAN ELEMEN MATRIKS KEDUA : ");
            for (i = 0; i < m; i++) {
                for (j = 0; j < n; j++) {
                    matriks2[i][j] = scan.nextInt();
                }
            }
            System.out.println("Hasil penjumlahan matriks: ");
            for (i = 0; i < m; i++) {
                for (j = 0; j < n; j++) {
                    hasil[i][j] = matriks1[i][j] + matriks2[i][j];
                    System.out.print(hasil[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.print("APAKAH ANDA INGIN MENGULANG (Y/T) : "); pilihan = scan.next().charAt(0);
        }while(pilihan == 'y' );
    }

    static void Karyawan() {
        char pilihan;
        do {
            int i;
            Scanner input = new Scanner(System.in);
            datakaryawan datkar = new datakaryawan();
            System.out.print("Berapa jumlah karyawan: ");
            datkar.setJmlKaryawan(myInput.bacaInt());
            for (i = 0; i < datkar.n; i++) {
                System.out.println();
                System.out.println("Karyawan ke- " + (i + 1));
                System.out.print("Masukan NIK           : ");
                datkar.setNIK(i, myInput.bacaString());
                System.out.print("Masukan Nama          : ");
                datkar.setNama(i, myInput.bacaString());
                System.out.print("Masukan Gaji Pokok    : ");
                datkar.setGapok(i, myInput.bacaInt());
            }
            datkar.tampilData();

            System.out.print("APAKAH ANDA INGIN MENGULANG (Y/T) : "); pilihan = input.next().charAt(0);
        } while (pilihan == 'y');
    }

    static void Makanan(){
        char pilihan;
        do {
            String[] produk = {
                    "Nasi Padang ", "Burger", "Nasi Goreng",  "Roti Bakar",
                    "NasiKuning ", "Lumpia Basah", "Sate Ambal", "Nasi Campur", "Batagor", "Bubur Ayam" // isi array
            };
            int[] harga = {15000, 13000, 12000, 16000, 10000, 7000, 24000, 14000, 9000,11000}; // isi array
            Scanner Input = new Scanner(System.in);
            DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
            DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
            formatRp.setCurrencySymbol("Rp. ");
            formatRp.setGroupingSeparator('.');

            System.out.println("**************************************");
            System.out.println("        PILIHAN MENU MAKANAN");
            System.out.println("************************************\n");
            System.out.println("1.Nasi Padang   =\t Rp.15.000,00");
            System.out.println("2.Burger        =\t Rp.13.000,00");
            System.out.println("3.Nasi Goreng   =\t Rp.12.000,00");
            System.out.println("4.Roti Bakar    =\t Rp.16.000,00");
            System.out.println("5.Nasi Kuning   =\t Rp.10.000,00");
            System.out.println("6.Lumpia Basah  =\t Rp.7.000,00");
            System.out.println("7.Sate Ambal    =\t Rp.24.000,00");
            System.out.println("8.Nasi Campur   =\t Rp.14.000,00");
            System.out.println("9.Batagor       =\t Rp.9.000,00");
            System.out.println("10.Bubur Ayam   =\t Rp.11.000,00\n");
            System.out.print("Masukan nama minuman : "); String cari = Input.nextLine();
            kursIndonesia.setDecimalFormatSymbols(formatRp);
            int i;
            boolean ditemukan = false; // digunakan untuk menyatakan variabel yang dapat menyimpan nilai boolean yaitu disitu adalah false
            for (i = 0; i < produk.length; i++) {
                if (produk[i].equals(cari)) {
                    ditemukan = true;
                    break; // digunakan untuk stop perulangan
                }
            }
            // mencetak hasil dari pencarian
            if (ditemukan) {
                System.out.println("\nProduk     : " + produk[i]);
                System.out.println("Harga      : " + kursIndonesia.format(harga[i]));
                System.out.println();
            } else {
                System.out.println("Produk Tidak Ditemukan");
            }

            System.out.println("Urutan Harga Minuman Termurah"); Arrays.sort(harga);
            showAll(harga);
            System.out.println();
            Scanner input = new Scanner(System.in);
        System.out.print("APAKAH ANDA INGIN MENGULANG (Y/T) : "); pilihan = input.next().charAt(0);
        } while (pilihan == 'y');
    }


    public static void showAll(int[] a) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        for (int i = 0; i < a.length; i++) {
            System.out.println(i + 1 + "  : " + kursIndonesia.format(a[i]));
    }

}
    static void exit(){
        System.exit(0);
    }

    public static void main(String[] args) {
        int menu;
        do{
        Scanner input = new Scanner(System.in);
        System.out.println("****************************************************");
        System.out.println("            PILIHAN MENU PROGRAM RESPONSI");
        System.out.println("**************************************************\n");
        System.out.println("1.PENJUMLAHAN MATRIKS");
        System.out.println("2.DATA KARYAWAN");
        System.out.println("3.MENGURUTKAN HARGA MINUMAN");
        System.out.println("4.KELUAR\n");
        System.out.print("MASUKAN PILIHAN ANDA : ");  menu = input.nextInt();
        switch(menu){
            default :  System.out.println("\nPILIHAN ANDA TIDAK TERSEDIA");
                System.out.println("MASUKAN PILIHAN YANG TEPAT\n");
                        System.exit(0);
                        break;
            case 1 : matriks();
                    break;
            case 2 : Karyawan();
                    break;
            case 3 : Makanan();
                    break;
            case 4 : exit();
                System.out.println("\nTERIMA KASIH\n");
                break;
        }
    }while(menu != 3);
    }
}