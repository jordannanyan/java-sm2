package com.belajar;
import java.util.Arrays;
import java.util.Scanner;

public class quicksort {
    public class QuickSort {
        public static void sort(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
        }
    
        private static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(arr, low, high);
                quickSort(arr, low, pivotIndex - 1);
                quickSort(arr, pivotIndex + 1, high);
            }
        }
    
        private static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;
    
            for (int j = low; j < high; j++) {
                if (arr[j] < pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
    
            swap(arr, i + 1, high);
            return i + 1;
        }
    
        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 8, 1, 3, 9, 2};
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
