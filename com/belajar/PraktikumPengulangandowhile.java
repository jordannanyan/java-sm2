package com.belajar;

public class PraktikumPengulangandowhile {
    
    public static void main(String[] args) {
        String[] produk = {"Jaguar", "Lamborghini", "Honda", "Audi", "Suzuki", "Mazda", "Daihatsu", "Ford", "Hyundai", "Mitsubishi"};
        long[] harga = {1340000000, 34500000000L, 350000000, 2000000000, 245000000, 500000000, 169000000, 789000000, 122900000, 278100000};

        // Tampilkan produk Audi beserta lokasinya dalam array
        int audiIndex = binarySearch(produk, "Audi");
        System.out.println("Indeks Audi: " + audiIndex);

        // Urutkan data harga dari nilai termurah hingga termahal
        sortHargaProduk(produk, harga);

        // Tampilkan harga produk termurah nomor ke-2
        long hargaTerendahNomorDua = harga[1];
        System.out.println("Harga produk termurah nomor 2 adalah: " + hargaTerendahNomorDua);
    }

    public static int binarySearch(String[] array, String target) {
        int low = 0;
        int high = array.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            
            int compare = target.compareTo(array[mid]);
            
            if (compare < 0) {
                high = mid - 1;
            } else if (compare > 0) {
                low = mid + 1;
            } else  {
                return mid;
            }
        }
    }

    public static void sortHargaProduk(String[] produk, long[] harga) {
        for (int i = 0; i < harga.length - 1; i++) {
            for (int j = i + 1; j < harga.length; j++) {
                if (harga[j] < harga[i]) {
                    // tukar posisi
                    long tempHarga = harga[i];
                    harga[i] = harga[j];
                    harga[j] = tempHarga;

                    // tukar posisi juga pada array produk
                    String tempProduk = produk[i];
                    produk[i] = produk[j];
                    produk[j] = tempProduk;
                }
            }
        }

        // Tampilkan urutan harga produk dari yang termurah ke termahal
        System.out.println("Urutan harga produk dari yang termurah ke termahal:");
        for (int i = 0; i < harga.length; i++) {
            System.out.println(produk[i] + ": " + harga[i]);
        }
    }
}
