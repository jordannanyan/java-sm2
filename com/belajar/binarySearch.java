package com.belajar;


public class binarySearch {
    public static void main(String[] args) {
        
        //Angka-angka di dalam array
        int [] a = {1,2,3,4,6,8,9,12,14,16,21,23,25,27};

        //Clear screen untuk java
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Program Binary Search");
        System.out.println("============================================");
        
        //Memanggil program binarysearch nya
        System.out.println();
        System.out.println(binarySearch(a, 23));    
        System.out.println();
    }

    //Binarysearch
    static int binarySearch(int[] a, int dicari) {
        int idx = 0;
        int angkakhir = a.length-1;
        int tgh;
        
        //Pengulangan while untuk melakukan Conquer and Destroy
        while (idx <= angkakhir) {

            //Mencari median dari array
            tgh = (idx + angkakhir)/2;

            //Percabangan if untuk mencari angka di dalam array
            if(a[tgh] == dicari){ 
                return (tgh);
            }else if(dicari < a[tgh]){
                angkakhir = tgh-1;
            }else if(dicari > a[tgh]){
                idx = tgh+1;
            } 
            
        }
        //Output yang akan dikeluarkan jika angka tidak ditemukan
        return (10000);
    }
}
