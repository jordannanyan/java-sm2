package com.belajar;

import java.util.Scanner;

public class ProgramResponsi {
    // A class to represent a boboted edge in ProgramResponsi
    class Edge {
        int src, dest, bobot;
        Edge()
        {
            src = dest = bobot = 0;
        }
    };
 
    int V, E;
    Edge edge[];
 
    // Creates a ProgramResponsi with V vertices and E edges
    ProgramResponsi(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }
 
    // The main function that finds shortest distances from src
    // to all other vertices using Bellman-Ford algorithm. The
    // function also detects negative bobot cycle
    void BellmanFord(ProgramResponsi ProgramResponsi, int src)
    {
        int V = ProgramResponsi.V, E = ProgramResponsi.E;
        int dist[] = new int[V];
 
        // Step 1: Initialize distances from src to all other
        // vertices as INFINITE
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
 
        // Step 2: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = ProgramResponsi.edge[j].src;
                int v = ProgramResponsi.edge[j].dest;
                int bobot = ProgramResponsi.edge[j].bobot;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + bobot < dist[v])
                    dist[v] = dist[u] + bobot;
            }
        }
 
        // Step 3: check for negative-bobot cycles. The above
        // step guarantees shortest distances if ProgramResponsi doesn't
        // contain negative bobot cycle. If we get a shorter
        // path, then there is a cycle.
        for (int j = 0; j < E; ++j) {
            int u = ProgramResponsi.edge[j].src;
            int v = ProgramResponsi.edge[j].dest;
            int bobot = ProgramResponsi.edge[j].bobot;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + bobot < dist[v]) {
                System.out.println("Graf Memiliki Siklus Negatif");
                return;
            }
        }
        System.out.println("Jarak verteks Dari Source");
        for (int i = 0; i < V; ++i){
            System.out.println("Untuk verteks " + i + " Jarak Terdekat Dari Verteks Pilihan Adalah = " + dist[i] + " ");
        }
    }
     
    //Prosedur print untuk menuliskan nilai di output
    void print(int dist[], int V)
    {
        System.out.println("Jarak verteks Dari Source");
        for (int i = 0; i < V; ++i){
            System.out.println("Untuk verteks " + i + " Jarak Terdekat Dari Verteks Pilihan Adalah = " + dist[i] + " " );
        }
    }


    int total(ProgramResponsi ProgramResponsi, int src){
        int x, n;
        n=0;
        int V = ProgramResponsi.V, E = ProgramResponsi.E;
        int dist[] = new int[V];
 
        // Step 1: Initialize distances from src to all other
        // vertices as INFINITE
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
 
        // Step 2: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = ProgramResponsi.edge[j].src;
                int v = ProgramResponsi.edge[j].dest;
                int bobot = ProgramResponsi.edge[j].bobot;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + bobot < dist[v])
                    dist[v] = dist[u] + bobot;
            }
        }
 
        // Step 3: check for negative-bobot cycles. The above
        // step guarantees shortest distances if ProgramResponsi doesn't
        // contain negative bobot cycle. If we get a shorter
        // path, then there is a cycle.
        for (int j = 0; j < E; ++j) {
            int u = ProgramResponsi.edge[j].src;
            int v = ProgramResponsi.edge[j].dest;
            int bobot = ProgramResponsi.edge[j].bobot;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + bobot < dist[v]) {
                System.out.println("Graf Memiliki Siklus Negatif");
            }
        }
        for (int i = 0; i < V; i++){ 
            x = dist[i];
            n = n + x;
        }
        return(n);
    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /* This function takes last element as pivot, places
    the pivot element at its correct position in sorted
    array, and places all smaller (smaller than pivot)
    to left of pivot and all greater elements to right
    of pivot */
    static int partition(int[] arr, int low, int high)
    {
        
        // pivot
        int pivot = arr[high];
        
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);
    
        for(int j = low; j <= high - 1; j++)
        {
            
            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot)
            {
                
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
 
    /* The main function that implements QuickSort
            arr[] --> Array to be sorted,
            low --> Starting index,
            high --> Ending index
    */
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
    
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    public static void main(String[] args)
    {
        try (Scanner input = new Scanner(System.in)) {
            int V = 5; // jumlah verteks di dalam graf
            int E = 10; // jumlah edge di dalam graf
            int j, d, x, l;
            int[] arr = new int[V];
            String p;

            ProgramResponsi graf = new ProgramResponsi(V, E);
   
            // A-B
            graf.edge[0].src = 0;
            graf.edge[0].dest = 1;
            graf.edge[0].bobot = 6;
   
            // A-E
            graf.edge[1].src = 0;
            graf.edge[1].dest = 4;
            graf.edge[1].bobot = 7;
   
            // B-C
            graf.edge[2].src = 1;
            graf.edge[2].dest = 2;
            graf.edge[2].bobot = 5;
   
            // B-D
            graf.edge[3].src = 1;
            graf.edge[3].dest = 3;
            graf.edge[3].bobot = -4;
   
            // B-E
            graf.edge[4].src = 1;
            graf.edge[4].dest = 4;
            graf.edge[4].bobot = 8;
   
            // C-B
            graf.edge[5].src = 2;
            graf.edge[5].dest = 1;
            graf.edge[5].bobot = -2;

            // D-C
            graf.edge[6].src = 3;
            graf.edge[6].dest = 2;
            graf.edge[6].bobot = 7;
   
   
            // E-C
            graf.edge[7].src = 4;
            graf.edge[7].dest = 2;
            graf.edge[7].bobot = -3;

            // E-D
            graf.edge[8].src = 4;
            graf.edge[8].dest = 3;
            graf.edge[8].bobot = 9;

            graf.edge[9].src = 1;
            graf.edge[9].dest = 0;
            graf.edge[9].bobot = 3;

            do {
                    

                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Program Bellman Ford Dengan Quick Sort");
                System.out.println("Graf Dengan 5 Verteks");
                System.out.println("====================================================");
                System.out.println("Pilihan Menu");
                System.out.println("1. Menunjukan Jarak Edge Dari Single Source Verteks");
                System.out.println("2. Menunjukan Total Jarak Edge Dari Setiap Source Verteks");
                System.out.println("3. Mensorting Total Jarak Dari Semua Source Verteks");
                System.out.print("Menu Yang Dipilih : ");
                l = input.nextInt();
                if (l == 1) {
                    System.out.print("Masukan Pilihan Graf Awal :");
                    j = input.nextInt();
                    System.out.println("");
                    graf.BellmanFord(graf, j);
                }
                if (l == 2) {
                    System.out.print("Masukan Verteks Source Yang Diininkan : ");
                    d = input.nextInt();
                    System.out.println(graf.total(graf, d));
                }
                if (l == 3) {
                    System.out.println("Sebelum Disorting");
                    for (int i = 0; i < V; i++) {
                        x= graf.total(graf, i);
                        arr[i]=x;
                        System.out.println("Untuk Source Ke " + i + " Total Jarak Edgenya Adalah "+arr[i]);
                    }
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("Sesudah Disorting");
                    quickSort(arr, 0, V - 1);
                    for (int i = 0; i < V; i++) {
                        System.out.println("Total Jarak Edge Adalah : " + arr[i]);
                    }
                }
                if (l > 4) {
                    System.out.println("Input Menu Salah");
                }
                System.out.print("Kembali Ke Menu Awal (y/n) : ");
                p = input.next();
                
            } while (p.equalsIgnoreCase("y"));
        }          
    }
}
