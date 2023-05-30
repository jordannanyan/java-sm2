package com.belajar;
import java.util.Arrays;
import java.util.Scanner;

import javax.net.ssl.X509ExtendedTrustManager;

public class mergesort {
    public class MergeSort {
        public static void sort(int[] arr) {
            if (arr.length > 1) {
                int mid = arr.length / 2;
                int[] left = Arrays.copyOfRange(arr, 0, mid);
                int[] right = Arrays.copyOfRange(arr, mid, arr.length);
                sort(left);
                sort(right);
                merge(arr, left, right);
            }
        }
    
        private static void merge(int[] arr, int[] left, int[] right) {
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
            }
            while (i < left.length) {
                arr[k++] = left[i++];
            }
            while (j < right.length) {
                arr[k++] = right[j++];
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int j,x;
        x = input.nextInt();
        int[] p = new int [x];
        for (int i = 0; i < x; i++) {
            System.out.print("Masukan Nilai Array Ke-"+(i+1)+" ");
            j = input.nextInt();
            p[i]=j;
        }
        MergeSort.sort(p);
        System.out.println(Arrays.toString(p));
    }
}
