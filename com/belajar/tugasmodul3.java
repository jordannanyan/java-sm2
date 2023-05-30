package com.belajar;

public class tugasmodul3 {

    //void binarysearchnamamobil untuk melakukan binary search untuk nama mobil di dalam array
    public static void binarynamamobil(String[] data, String nama) {

        //beberapa variabel untuk melakukan binary search
        int min = 0, max = data.length-1, mid = 0;
        boolean status = false;

        //pengulangan while
            while (min <= max) {
                mid = (min + max) / 2;
                if (nama.equalsIgnoreCase(data[mid])) {
                    System.out.println("Mobil " + nama + " terdapat di posisi ke " + (mid+1));
                    status = true;
                    break;
                }else{

                    //percabangan if untuk membagi array lagi hingga data ditemukan
                    if (data[mid].compareTo(nama) < 0) { 
                        min = mid + 1; 
                    } else {
                        max = mid - 1;
                    }
                }
            }
        //percabangan if jika data tidak ditemukan
        if (status == false) {
            System.out.println("Data tidak dapat ditemukan");
        }
        
    
    }

    //void sequentialhargamobil untuk mencari harga mobil dengan cara sequential search
    public static void sequentialhargamobil(String[] data, String harga ) {
        
        boolean status = false;
        //pengulangan for untuk mencari data dari yang pertama hingga yang terakhir
        for (int i = 0; i<data.length ; i++) {
            if (harga.equalsIgnoreCase(data[i])) {
                System.out.println("Dengan harga mobil " + harga );
                status = true;
                break;
            }

        }
        //percabangan if jika data tidak ditemukan
        if (status == false) {
            System.out.println("Data tidak ditemukan");
        }
    }

    //void main
    public static void main(String[] args) {

        //kedua array yang diminta soal
        String[] hargamobil = {"122900000", "169000000", "245000000", "278100000", "350000000", "500000000", "789000000", "1340000000", "2000000000", "34500000000" };
        String[] namamobil = {"Hyundai", "Daihatsu", "Suzuki", "Mitsubishi", "Honda", "Mazda", "Ford", "Jaguar", "Audi", "Lamborgini" };


        //menampilkan produk mobil bernama audi
        System.out.println("Menampilkan Produk Mobil Audi");
        System.out.println();
        binarynamamobil(namamobil, "audi");
        sequentialhargamobil(hargamobil, "2000000000");
        System.out.println();

        System.out.println("======================================================");
        //menampilkan data termurah hingga termahal
        System.out.println("Menampilkan Data Mobil Termurah Hingga Termahal");
        System.out.println();
        for ( int i = 0; i<10; i++) {
            System.out.println(namamobil[i] + " " + hargamobil[i] + ". ");
        }
        System.out.println();
        System.out.println("=======================================================");
        System.out.println("Menampilkan Harga Produk Mobil Termurah Kedua");
        System.out.println();
        binarynamamobil(namamobil, "Daihatsu");
        sequentialhargamobil(hargamobil, "169000000");
        System.out.println();
    }
    
}