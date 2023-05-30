package com.responsi;
import java.util.Scanner;

class ProgramResponsi {
    // class edge digunakan untuk membuat nilai/bobot yang ada di edge graf
    class Edge {
        int src, dest, bobot;
        Edge()
        {
            src = dest = bobot = 0;
        }
    };
 
    int V, E;
    Edge edge[];
 
    // pembuatan graf dengan V sebagai verteks dan E sebagai edgenya
    ProgramResponsi(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }
 
    // fungsi bellmanford yang merupakan algoritma yang digunakan untuk mencari shortest path di dalam graf
    // dari satu source verteks
    void BellmanFord(ProgramResponsi ProgramResponsi, int src)
    {
        int V = ProgramResponsi.V, E = ProgramResponsi.E;
        int dist[] = new int[V];
 
        // Buat semua nilai bobot edge menjadi infinite
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
 
        // Semua verteks yang telah ditemukan bobot tekecilnya
        // akan di relax dan nilai infinite diganti dengan bobot sebenarnya
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = ProgramResponsi.edge[j].src;
                int v = ProgramResponsi.edge[j].dest;
                int bobot = ProgramResponsi.edge[j].bobot;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + bobot < dist[v])
                    dist[v] = dist[u] + bobot;
            }
        }
 
        // Setelah itu akan dicari siklus negatif yang ada di dalam graf
        // Jika siklus negatif ditemukan maka shortest path tidak akan ditemukan
        for (int j = 0; j < E; ++j) {
            int u = ProgramResponsi.edge[j].src;
            int v = ProgramResponsi.edge[j].dest;
            int bobot = ProgramResponsi.edge[j].bobot;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + bobot < dist[v]) {
                System.out.println("Graf Memiliki Siklus Negatif");
                return;
            }
        }

        // Memanggil fungsi print
        print(dist, V);
    }
     
    //Prosedur print untuk menuliskan nilai di output
    void print(int dist[], int V)
    {
        System.out.println("Jarak verteks Dari Source");
        for (int i = 0; i < V; ++i){
            System.out.println("Untuk verteks " + i + " Jarak Terdekat Dari Verteks Pilihan Adalah = " + dist[i] + " " );
        }
    }

    // Integer total untuk mendapatkan total nilai bobot dari satu source verteks
    int total(ProgramResponsi ProgramResponsi, int src){

        // Source code sama dengan fungsi bellmanford
        int x, n;
        n=0;
        int V = ProgramResponsi.V, E = ProgramResponsi.E;
        int dist[] = new int[V];
 
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
 
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = ProgramResponsi.edge[j].src;
                int v = ProgramResponsi.edge[j].dest;
                int bobot = ProgramResponsi.edge[j].bobot;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + bobot < dist[v])
                    dist[v] = dist[u] + bobot;
            }
        }
 
        for (int j = 0; j < E; ++j) {
            int u = ProgramResponsi.edge[j].src;
            int v = ProgramResponsi.edge[j].dest;
            int bobot = ProgramResponsi.edge[j].bobot;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + bobot < dist[v]) {
                System.out.println("Graf Memiliki Siklus Negatif");
            }
        }

        // Pengulangan for untuk menghitungkan total bobot
        for (int i = 0; i < V; i++){ 
            x = dist[i];
            n = n + x;
        }
        return(n);
    }

    // Fungsi swap untuk menukar data yang akan disort nanti di quicksort
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // integer partition mengambil satu nilai dari ujung array
    // dan menempatkan nilai array yang lebih kecil disebelah kiri
    // pivot dan nilai yang lebih besar disebalah kanan pivod
    static int partition(int[] arr, int low, int high)
    {
        
        // pivot
        int pivot = arr[high];
        
        // index i menunjukan nilai yang lebih kecil
        // dari pivot yang akan dipindahkan ke sebelah
        // kiri pivot
        int i = (low - 1);
    
        for(int j = low; j <= high - 1; j++)
        {
            
            // jika nilai yang sekarang lebih kecil
            // dari pivot
            if (arr[j] < pivot)
            {
                
                // Increment i untuk nilai yang lebih kecil
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
 
    // fungsi quickSort untuk melakukan sorting
    // dimana low index awal dan high index akhir
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            
            // pi adalah index yang sudah di partition
            int pi = partition(arr, low, high);
    
            // Sorting dilakukan secara terpisah, untuk element
            // sebelum pi dan sesudah pi
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // main program
    public static void main(String[] args)
    {
        try (Scanner input = new Scanner(System.in)) {
            int V = 5; // jumlah verteks di dalam graf
            int E = 11; // jumlah edge di dalam graf
            int j, d, x, l;
            int[] arr = new int[V];
            String p;

            //pembuatan graf
            ProgramResponsi graf = new ProgramResponsi(V, E);

            // Penulisan graf dan isinya

            // A-B
            graf.edge[0].src = 0;
            graf.edge[0].dest = 1;
            graf.edge[0].bobot = 4;
   
            // A-E
            graf.edge[1].src = 0;
            graf.edge[1].dest = 4;
            graf.edge[1].bobot = 6;
   
            // B-C
            graf.edge[2].src = 1;
            graf.edge[2].dest = 2;
            graf.edge[2].bobot = 8;
   
            // B-D
            graf.edge[3].src = 1;
            graf.edge[3].dest = 3;
            graf.edge[3].bobot = -3;
   
            // B-E
            graf.edge[4].src = 1;
            graf.edge[4].dest = 4;
            graf.edge[4].bobot = 4;
   
            // C-B
            graf.edge[5].src = 2;
            graf.edge[5].dest = 1;
            graf.edge[5].bobot = 5;

            // D-C
            graf.edge[6].src = 3;
            graf.edge[6].dest = 2;
            graf.edge[6].bobot = 5;
   
   
            // E-C
            graf.edge[7].src = 4;
            graf.edge[7].dest = 2;
            graf.edge[7].bobot = -2;

            // E-D
            graf.edge[8].src = 4;
            graf.edge[8].dest = 3;
            graf.edge[8].bobot = 9;

            // B-A
            graf.edge[9].src = 1;
            graf.edge[9].dest = 0;
            graf.edge[9].bobot = 3;

            // C-A
            graf.edge[10].src = 2;
            graf.edge[10].dest = 0;
            graf.edge[10].bobot = 6;

            // Pengulangan dowhile untuk tampilan menu
            do {

                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Program Bellman Ford Dengan Quick Sort");
                System.out.println("Graf Dengan 5 Verteks");
                System.out.println("====================================================");
                
                // Pilihan menu
                System.out.println("Pilihan Menu");
                System.out.println("1. Menunjukan Jarak Edge Dari Single Source Verteks");
                System.out.println("2. Menunjukan Total Jarak Edge Dari Setiap Source Verteks");
                System.out.println("3. Mensorting Total Jarak Dari Semua Source Verteks");

                // Pemilihan menu
                System.out.print("Menu Yang Dipilih : ");
                l = input.nextInt();

                // Percabangan if

                // Jika menu 1 yang dipilih
                if (l == 1) {
                    // Menunjukan shortest path dengan source yang kita pilih
                    System.out.print("Masukan Pilihan Graf Awal :");
                    j = input.nextInt();
                    System.out.println("");
                    graf.BellmanFord(graf, j);
                }

                // Jika menu 2 yang dipilih
                if (l == 2) {
                    // Menunjukan total bobot dari semua edge dengan source yang kita pilih
                    System.out.print("Masukan Verteks Source Yang Diininkan : ");
                    d = input.nextInt();
                    System.out.println(graf.total(graf, d));
                }

                // Jika menu 3 yang dipilih
                if (l == 3) {
                    // Menunjukan daftar total bobot dari semua source graf sebelum di sort
                    System.out.println("Sebelum Disorting");
                    for (int i = 0; i < V; i++) {
                        x= graf.total(graf, i);
                        arr[i]=x;
                        System.out.println("Untuk Source Ke " + i + " Total Jarak Edgenya Adalah "+arr[i]);
                    }
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("Sesudah Disorting");
                    // Mensorting daftar total bobot shortest path-nya
                    quickSort(arr, 0, V - 1);
                    for (int i = 0; i < V; i++) {
                        System.out.println("Total Jarak Edge Adalah : " + arr[i]);
                    }
                }

                // jika menekan menu lebih dari 3
                if (l > 3) {
                    System.out.println("Input Menu Salah");
                }

                // Permintaan jika ingin kembali ke menu awal
                System.out.print("Kembali Ke Menu Awal (y/n) : ");
                p = input.next();
                
            } while (p.equalsIgnoreCase("y"));
        }          
    }
}
