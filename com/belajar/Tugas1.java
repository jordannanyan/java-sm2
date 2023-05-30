package com.belajar;

import java.util.Scanner;

public class Tugas1 {
        
    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("									====== RESPONSI ALPRO II =======");
        System.out.println("									====== 	    TUGAS 1    	========");
        System.out.println("									================================");
        System.out.println("									PROGRAM INPUT DATA HARGA PRODUK");
        System.out.println("									================================");
        System.out.println();
        System.out.print("Masukkan jumlah produk yang ingin ditambahkan: ");
        int n = input.nextInt();

        String[] namaProduk = new String[n];
        int[] tahunRilis = new int[n];
        String[] warna = new String[n];
        int[] harga = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nProduk #" + (i+1));
            System.out.print("Nama produk: ");
            namaProduk[i] = input.next();
            System.out.print("Tahun rilis: ");
            tahunRilis[i] = input.nextInt();
            System.out.print("Warna: ");
            warna[i] = input.next();
            System.out.print("Harga: ");
            harga[i] = input.nextInt();
        }
        
        System.out.println("\nData produk sebelum diurutkan:");
        for (int i = 0; i < n; i++) {
            System.out.println(namaProduk[i] + " | " + tahunRilis[i] + " | " + warna[i] + " | " + harga[i]);
        }
	        
		    int pilihan = 0;
		    char f;
		  
		    do {
		    	char w;
		    	System.out.println("=== TUGAS 1 ===");
		        System.out.println("1. Quick Sort (Ascending)");
		        System.out.println("2. Quick Sort (Descending)");
		        System.out.println("3. Merge Sort (Ascending)");
		        System.out.println("4. Merge Sort (Descending)");
		        System.out.println("5. Sequential Search");
		        System.out.println("6. Binary Search");
		        System.out.println("7. Jump Search");
		        System.out.println("8. Keluar");
		        System.out.print("Masukkan pilihan Anda: ");
		        
		        pilihan = input.nextInt();
		        
		        switch (pilihan) {
		            case 1:
		            	quickSort(namaProduk, tahunRilis, warna, harga, 0, n-1);
		            	System.out.println("\n====== Quick Sort (Ascending) ======");
		            	for (int i = 0; i < n; i++) {
		            		System.out.println("\nProduk #" + (i+1));
		            		System.out.println("Nama Produk : "+namaProduk[i]);
		            		System.out.println("Tahun Rilis : "+tahunRilis[i]);
		            		System.out.println("Warna : "+warna[i]);
		            		System.out.println("Harga :"+harga[i]);
		            		System.out.println();
		            	}
		            	break;
		            	
		            case 2:
		            	quickSortd(namaProduk, tahunRilis, warna, harga, 0, n-1);
		            	System.out.println("\n====== Quick Sort (Descending) ======");
		            	for (int i = 0; i < n; i++) {
		            		System.out.println("\nProduk #" + (i+1));
		            		System.out.println("Nama Produk : "+namaProduk[i]);
		            		System.out.println("Tahun Rilis : "+tahunRilis[i]);
		            		System.out.println("Warna : "+warna[i]);
		            		System.out.println("Harga :"+harga[i]);
		            		System.out.println();
		            	}
		            	break;
		            	
		            case 3:
		            	mergeSort(namaProduk, tahunRilis, warna, harga, 0, harga.length - 1);
		            	System.out.println("\n====== Merge Sort (Ascending) ======");
		            	for (int i = 0; i < n; i++) {
		            		System.out.println("\nProduk #" + (i+1));
		            		System.out.println("Nama Produk : "+namaProduk[i]);
		            		System.out.println("Tahun Rilis : "+tahunRilis[i]);
		            		System.out.println("Warna : "+warna[i]);
		            		System.out.println("Harga :"+harga[i]);
		            		System.out.println();
		            	}
		                break;
		             
		            case 4:
		            	mergeSortD(namaProduk, tahunRilis, warna, harga, 0, harga.length - 1);
		            	System.out.println("\n====== Merge Sort (Descending) ======");
		            	for (int i = 0; i < n; i++) {
		            		System.out.println("\nProduk #" + (i+1));
		            		System.out.println("Nama Produk : "+namaProduk[i]);
		            		System.out.println("Tahun Rilis : "+tahunRilis[i]);
		            		System.out.println("Warna : "+warna[i]);
		            		System.out.println("Harga :"+harga[i]);
		            		System.out.println();
		            	}
		                break;
		                
		            case 5:		       
		                System.out.println("=== Sequential Search ===");
		                System.out.print("Masukkan nama produk yang ingin dicari: ");
		                String cariNama1 = input.next();
		                sequentialSearch(namaProduk, tahunRilis, warna, harga, cariNama1);
		                break;
		                
		            case 6:
		            	System.out.println("=== Binary Search ===");
		                System.out.print("Masukkan nama produk yang ingin dicari: ");
		                String cariNama2 = input.next();		           
		                binarySearch(namaProduk, tahunRilis, warna, harga, cariNama2);		           
		                break;
		                
		            case 7:
		            	System.out.println("=== Jump Search ===");
		                System.out.print("Masukkan nama produk yang ingin dicari: ");
		                String cariNama3 = input.next();		           
		                jumpSearch(namaProduk, tahunRilis, warna, harga, cariNama3);		           
		                break;
		                
		            case 8:
		                return;
		            default:
		                System.out.println("Pilihan tidak valid!");
		    	                    break;
		    	            }
		    	            
				        System.out.print("Ingin kembali ke menu utama? (y/n): ");
			            f = input.next().charAt(0);
			    	} while (f == 'y');
		    		return;
			    }
    
    public static void quickSort(String[] namaProduk, int[] tahunRilis, String[] warna, int[] harga, int low, int high) {
        
        if (low < high) {
            int pi = partition(namaProduk, tahunRilis, warna, harga, low, high);
            quickSort(namaProduk, tahunRilis, warna, harga, low, pi-1);
            quickSort(namaProduk, tahunRilis, warna, harga, pi+1, high);
        }
        
        
    }
    
    public static int partition(String[] namaProduk, int[] tahunRilis, String[] warna, int[] harga, int low, int high) {
        
        int pivot = harga[high];
        int i = (low - 1);
        
        for (int j = low; j <= high - 1; j++) {
            if (harga[j] < pivot) {
                i++;
                swap(namaProduk, i, j);
                swap(tahunRilis, i, j);
                swap(warna, i, j);
                swap(harga, i, j);
            } 
        }
        
        swap(namaProduk, i+1, high);
        swap(tahunRilis, i+1, high);
        swap(warna, i+1, high);
        swap(harga, i+1, high);
        
        return i+1;
        
    }
    	
    
    public static void swap(String[] arr, int i, int j) {
        String temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
   
    public static void quickSortd(String[] namaProduk, int[] tahunRilis, String[] warna, int[] harga, int low, int high) {
        if (low < high) {
            int pi = partitiond(namaProduk, tahunRilis, warna, harga, low, high);
            quickSortd(namaProduk, tahunRilis, warna, harga, low, pi-1);
            quickSortd(namaProduk, tahunRilis, warna, harga, pi+1, high);
        }
    }

    public static int partitiond(String[] namaProduk, int[] tahunRilis, String[] warna, int[] harga, int low, int high) {
        int pivot = harga[high];
        int i = low - 1;
        
        for (int j = low; j <= high - 1; j++) {
            if (harga[j] > pivot) { // modifikasi perbandingan
                i++;
                swap(namaProduk, i, j);
                swap(tahunRilis, i, j);
                swap(warna, i, j);
                swap(harga, i, j);
            }
        }
        
        swap(namaProduk, i+1, high);
        swap(tahunRilis, i+1, high);
        swap(warna, i+1, high);
        swap(harga, i+1, high);
        
        return i+1;
    }

    public static void swap2(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap2(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    
    
    public static void mergeSort(String[] namaProduk, int[] tahunRilis, String[] warna, int[] harga, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(namaProduk, tahunRilis, warna, harga, l, m);
            mergeSort(namaProduk, tahunRilis, warna, harga, m + 1, r);

            merge(namaProduk, tahunRilis, warna, harga, l, m, r);
        }
    }

    public static void merge(String[] namaProduk, int[] tahunRilis, String[] warna, int[] harga, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] Lharga = new int[n1];
        int[] Rharga = new int[n2];
        String[] LnamaProduk = new String[n1];
        String[] RnamaProduk = new String[n2];
        String[] Lwarna = new String[n1];
        String[] Rwarna = new String[n2];
        int[] LtahunRilis = new int[n1];
        int[] RtahunRilis = new int[n2];

        for (int i = 0; i < n1; ++i) {
            Lharga[i] = harga[l + i];
            LnamaProduk[i] = namaProduk[l + i];
            Lwarna[i] = warna[l + i];
            LtahunRilis[i] = tahunRilis[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            Rharga[j] = harga[m + 1 + j];
            RnamaProduk[j] = namaProduk[m + 1 + j];
            Rwarna[j] = warna[m + 1 + j];
            RtahunRilis[j] = tahunRilis[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
        	if (Lharga[i] <= Rharga[j]) {
        	    harga[k] = Lharga[i];
        	    namaProduk[k] = LnamaProduk[i];
        	    tahunRilis[k] = LtahunRilis[i];
        	    warna[k] = Lwarna[i];
        	    i++;
        	}
        	else {
        	    harga[k] = Rharga[j];
        	    namaProduk[k] = RnamaProduk[j];
        	    tahunRilis[k] = RtahunRilis[j];
        	    warna[k] = Rwarna[j];
        	    j++;
        	}
        	k++;
        }
        
        while (i < n1) {
            harga[k] = Lharga[i];
            namaProduk[k] = LnamaProduk[i];
            warna[k] = Lwarna[i];
            tahunRilis[k] = LtahunRilis[i];
            i++;
            k++;
        }

        while (j < n2) {
            harga[k] = Rharga[j];
            namaProduk[k] = RnamaProduk[j];
            warna[k] = Rwarna[j];
            tahunRilis[k] = RtahunRilis[j];
            j++;
            k++;
        }
	  }
    
    public static void mergeSortD(String[] namaProduk, int[] tahunRilis, String[] warna, int[] harga, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(namaProduk, tahunRilis, warna, harga, l, m);
            mergeSort(namaProduk, tahunRilis, warna, harga, m + 1, r);

            merge(namaProduk, tahunRilis, warna, harga, l, m, r);
        }
    }

    public static void mergeD(String[] namaProduk, int[] tahunRilis, String[] warna, int[] harga, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] Lharga = new int[n1];
        int[] Rharga = new int[n2];
        String[] LnamaProduk = new String[n1];
        String[] RnamaProduk = new String[n2];
        String[] Lwarna = new String[n1];
        String[] Rwarna = new String[n2];
        int[] LtahunRilis = new int[n1];
        int[] RtahunRilis = new int[n2];

        for (int i = 0; i < n1; ++i) {
            Lharga[i] = harga[l + i];
            LnamaProduk[i] = namaProduk[l + i];
            Lwarna[i] = warna[l + i];
            LtahunRilis[i] = tahunRilis[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            Rharga[j] = harga[m + 1 + j];
            RnamaProduk[j] = namaProduk[m + 1 + j];
            Rwarna[j] = warna[m + 1 + j];
            RtahunRilis[j] = tahunRilis[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (Lharga[i] <= Rharga[j]) { 
                harga[k] = Lharga[i];
                namaProduk[k] = LnamaProduk[i];
                tahunRilis[k] = LtahunRilis[i];
                warna[k] = Lwarna[i];
                i++;
            }
            else {
                harga[k] = Rharga[j];
                namaProduk[k] = RnamaProduk[j];
                tahunRilis[k] = RtahunRilis[j];
                warna[k] = Rwarna[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            harga[k] = Lharga[i];
            namaProduk[k] = LnamaProduk[i];
            warna[k] = Lwarna[i];
            tahunRilis[k] = LtahunRilis[i];
            i++;
            k++;
        }

        while (j < n2) {
            harga[k] = Rharga[j];
            namaProduk[k] = RnamaProduk[j];
            warna[k] = Rwarna[j];
            tahunRilis[k] = RtahunRilis[j];
            j++;
            k++;
        }
	  }

    
    public static void sequentialSearch(String[] namaProduk, int[] tahunRilis, String[] warna, int[] harga, String cariNama) {
        boolean ditemukan = false;
        for (int i = 0; i < namaProduk.length; i++) {
            if (namaProduk[i].equalsIgnoreCase(cariNama)) {
                ditemukan = true;
                System.out.println("Data ditemukan pada indeks ke-" + i);
                System.out.println("Nama Produk : " + namaProduk[i]);
                System.out.println("Tahun Rilis : " + tahunRilis[i]);
                System.out.println("Warna : " + warna[i]);
                System.out.println("Harga : " + harga[i]);
                System.out.println();
            }
        }
        if (!ditemukan) {
            System.out.println("Data tidak ditemukan.");
        }
    }
    
    public static void binarySearch(String[] namaProduk, int[] tahunRilis, String[] warna, int[] harga, String cariNama) {
        int awal = 0;
        int akhir = namaProduk.length - 1;
        boolean ditemukan = false;
        
        while (awal <= akhir) {
            int tengah = (awal + akhir) / 2;
            if (namaProduk[tengah].equalsIgnoreCase(cariNama)) {
                ditemukan = true;
                System.out.println("Data ditemukan pada indeks ke-" + tengah);
                System.out.println("Nama Produk : " + namaProduk[tengah]);
                System.out.println("Tahun Rilis : " + tahunRilis[tengah]);
                System.out.println("Warna : " + warna[tengah]);
                System.out.println("Harga : " + harga[tengah]);
                System.out.println();
                break;
            } else if (cariNama.compareToIgnoreCase(namaProduk[tengah]) < 0) {
                akhir = tengah - 1;
            } else {
                awal = tengah + 1;
            }
        }
        
        if (!ditemukan) {
            System.out.println("Data tidak ditemukan.");
        }
    }
    
    public static void jumpSearch(String[] namaProduk, int[] tahunRilis, String[] warna, int[] harga, String cariNama) {
        int n = namaProduk.length;
        int step = (int) Math.sqrt(n);
        int prev = 0;

        while (namaProduk[Math.min(step, n)-1].compareToIgnoreCase(cariNama) < 0) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) {
                System.out.println("Data tidak ditemukan.");
                return;
            }
        }

        while (namaProduk[prev].compareToIgnoreCase(cariNama) < 0) {
            prev++;

            if (prev == Math.min(step, n)) {
                System.out.println("Data tidak ditemukan.");
                return;
            }
        }

        if (namaProduk[prev].equalsIgnoreCase(cariNama)) {
            System.out.println("Data ditemukan pada indeks ke-" + prev);
            System.out.println("Nama Produk : " + namaProduk[prev]);
            System.out.println("Tahun Rilis : " + tahunRilis[prev]);
            System.out.println("Warna : " + warna[prev]);
            System.out.println("Harga : " + harga[prev]);
            System.out.println();
            return;
        }

        System.out.println("Data tidak ditemukan.");
    }
}