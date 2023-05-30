package com.belajar;
import java.util.Arrays;

public class Tugas1Modul4 {
    
    //Prosedur utama prim untuk menentukan jarak terdekat antar verteks
    public void Prim(int G[][], int V) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        int edgepertama; 

        //Merepresentasikan sebuah set verteks
        boolean[] selected = new boolean[V];

        //untuk memberikan nilai boolean false ke setiap verteks setelah verteks pertama 
        Arrays.fill(selected, false);
        edgepertama = 0;
        selected[1] = true;

        //Pengulangan while untuk setiap vortex 
        while (edgepertama < V - 1) {

            //Menginisialisasikan nilai minimum sebagai INFINITE
            int min = Integer.MAX_VALUE;
            int x = 0;                    // verteks awal
            int y = 0;                    // verteks tujuan
            for (int i = 0; i < V; i++) {
                if (selected[i] == true) {
                    for (int j = 0; j < V; j++) {

                        //Pengulangan if untuk verteks yang belum dimasukan kedalam spanning tree
                        if (!selected[j] && G[i][j] > 0) {

                            //menggunakan nilai min yang baru untuk dibandingkan
                            if (min > G[i][j]) {
                            min = G[i][j];
                            x = i;
                            y = j;
                            }   
                        }   
                    }   
                }
            }
            //Menuliskan nilai minimum spanning tree di output
            System.out.println("Letak Edge Di Antara " + x + " - " + y + " Memiliki Bobot = " + G[x][y]);
            selected[y] = true;

            edgepertama++;
        }
    }
    //void main untuk program utama
    public static void main(String[] args) {
        //meninisialisasikan graf baru
        Tugas1Modul4 g = new Tugas1Modul4();

        //jumlah verteks
        int V = 18;

        //Menginputkan nilai edge di dalam graf
        int[][] G = {{0, 3, 5, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0 , 0, 7, 0 , 0, 0 }, 
                    { 3, 0, 2, 0, 2, 0, 0 , 0, 0, 0 , 0, 0, 0 , 0, 0, 0 , 0, 0,}, 
                    { 5, 2, 0, 3, 0, 0, 4 , 0, 0, 0 , 0, 0, 0 , 0, 0, 0 , 0, 0}, 
                    { 0, 0, 3, 0, 0, 0, 1 , 0, 0, 0 , 0, 0, 0 , 0, 0, 0 , 0, 0}, 
                    { 0, 2, 0, 0, 0, 4, 0 , 8, 0, 0 , 0, 0, 0 , 0, 0, 0 , 0, 0}, 
                    { 0, 0, 0, 0, 4, 0, 2 , 0, 0, 1 , 0, 0, 0 , 0, 0, 0 , 0, 0}, 
                    { 0, 0, 4, 1, 0, 2, 0 , 0, 0, 5 , 3, 0, 0 , 0, 0, 0 , 0, 0},
                    { 0, 0, 0, 0, 8, 0, 0 , 0, 9, 0 , 0, 0, 0 , 0, 4, 0 , 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0 , 9, 0, 1 , 0, 0, 9 , 0, 0, 0 , 0, 0},
                    { 0, 0, 0, 0, 0, 1, 5 , 0, 1, 0 , 8, 0, 0 , 7, 0, 0 , 0, 0},
                    { 0, 0, 0, 0, 4, 0, 3 , 0, 0, 8 , 0, 0, 0 , 0, 0, 0 , 0, 4},
                    { 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0 , 0, 0, 5 , 0, 8, 0 , 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0 , 0, 9, 0 , 0, 5, 0 , 1, 0, 0 , 2, 0},
                    { 0, 0, 0, 0, 0, 0, 0 , 0, 0, 7 , 0, 0, 1 , 0, 0, 0 , 5, 4},
                    { 7, 0, 0, 0, 0, 0, 0 , 4, 0, 0 , 0, 8, 0 , 0, 0, 6 , 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0 , 0, 0, 0 , 0, 6, 0 , 3, 3},
                    { 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0 , 0, 0, 2 , 5, 0, 3 , 0, 0},
                    { 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0 , 4, 0, 0 , 4, 0, 3 , 0, 0}};
                    
        g.Prim(G, V);
    }
}
