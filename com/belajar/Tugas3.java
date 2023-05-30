package com.belajar;
import java.util.*;

public class Tugas3 {
	
    private final static int d = 10;
    public static void search(String[] patterns, String text) {
        for (String pattern : patterns) {
            ArrayList<Integer> indices = rabinKarp(pattern, text);
            for (int index : indices) {
                System.out.println("Mencari pattern '" + pattern + "' Pada Index: " + index);
                System.out.println();
            }
            if (indices.size() > 0) {
                System.out.print("Jadi, Pattern '" + pattern + "' Ditemukan Pada Index Berikut: ");
                for (int index : indices) {
                    System.out.print(index + " , ");
                }
                System.out.println();
            } else {
                System.out.println("Pattern '" + pattern + "' Tidak Ditemukan.");
            }
        }
    }


    private static ArrayList<Integer> rabinKarp(String pattern, String text) {
        ArrayList<Integer> indices = new ArrayList<>();
        int pLength = pattern.length();
        int tLength = text.length();
        int pHash = hash(pattern, pLength);
        int tHash = hash(text, pLength);
        int maxPow = (int) Math.pow(d, pLength - 1);

        for (int i = 0; i <= tLength - pLength; i++) {
            if (pHash == tHash) {
                int j = 0;
                while (j < pLength && pattern.charAt(j) == text.charAt(i + j)) {
                    j++;
                }
                if (j == pLength) {
                    indices.add(i);
                }
            }
            if (i < tLength - pLength) {
                tHash = d * (tHash - text.charAt(i) * maxPow) + text.charAt(i + pLength);
            }
        }
        return indices;
    }

    private static int hash(String str, int length) {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash = d * hash + str.charAt(i);
        }
        return hash;
    }


	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("===== RESPONSI ALPRO II =====");
		System.out.println("=== TUGAS 3 ===");
	    System.out.print("Masukkan teks: ");
	    String txt = scanner.nextLine();
	    System.out.print("Masukkan jumlah pattern: ");
	    int n = scanner.nextInt();
	    System.out.println();
	    String[] patterns = new String[n];
	    scanner.nextLine();
	    for (int i = 0; i < n; i++) {
	        System.out.print("Masukkan pattern ke-" + (i + 1) + ": ");
	        patterns[i] = scanner.nextLine();
	    }
	    int q = 101;
	    System.out.println();
	    long startTime = System.currentTimeMillis();
	    search(patterns, txt);
	    
	    long endTime = System.currentTimeMillis();
	    System.out.println("Waktu eksekusi program: " + (endTime - startTime) + " ms");
	}
}
