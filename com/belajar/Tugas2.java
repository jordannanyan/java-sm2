package com.belajar;
import java.util.Scanner;

public class Tugas2 {
    class Edge {
        int src, dest, weight;

        Edge() {
            src = dest = weight = 0;
        }
    }
    
    int V, E;
    Edge edge[];

    Tugas2 (int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }
    
    public void sortShortestPathBySource(int src) {
        int[] arr1 = new int[V];
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edge[j].src;
                int v = edge[j].dest;
                int weight = edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println("Jarak dari " + src + " ke " + i + " adalah: " + dist[i]);
            arr1[i]=i;
        }

        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < V - i - 1; j++) {
                if (dist[j] > dist[j + 1]) {
                    int tempDist = dist[j];
                    dist[j] = dist[j + 1];
                    dist[j + 1] = tempDist;

                    int temp = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp;
                }
            }
        }

        System.out.println("Setelah diurutkan:");
        for (int j = 0; j < V; j++) {
            System.out.println("Jarak dari " + src + " ke " + arr1[j] + " adalah: " + dist[j]);
        }
    }
    
    void BellmanFord(int src, int dest) {
        int dist[] = new int[V];

        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
            dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edge[j].src;
                int v = edge[j].dest;
                int weight = edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        for (int j = 0; j < E; ++j) {
            int u = edge[j].src;
            int v = edge[j].dest;
            int weight = edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        System.out.println("Jarak dari " + src + " ke " + dest + " adalah: " + dist[dest]);
    }
    
    public void printGraph() {
        for (int i = 0; i < E; i++) {
            System.out.print("\nEdge " + i + ":");
            System.out.println();
            System.out.print("Source: " + edge[i].src  + "\nDestination : " + edge[i].dest + "\nWeight : " + edge[i].weight);
            System.out.println();
        }
    }
    
    public void showpaths(int src) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edge[j].src;
                int v = edge[j].dest;
                int weight = edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println("Jarak dari " + src + " ke " + i + " adalah: " + dist[i]);
        }
    }
    
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        int V = 7;
        int E = 13;

        Tugas2 graph = new Tugas2 (V, E);

        graph.edge[0].src = 0;
		graph.edge[0].dest = 3;
		graph.edge[0].weight = -6;
		
		graph.edge[1].src = 0;
		graph.edge[1].dest = 5;
		graph.edge[1].weight = -8;
		
		graph.edge[2].src = 0;
		graph.edge[2].dest = 6;
		graph.edge[2].weight = 1;
		
		graph.edge[3].src = 1;
		graph.edge[3].dest = 0;
		graph.edge[3].weight = 11;
		
		graph.edge[4].src = 1;
		graph.edge[4].dest = 4;
		graph.edge[4].weight = 2;
		
		graph.edge[5].src = 2;
		graph.edge[5].dest = 1;
		graph.edge[5].weight = -3;
		
		graph.edge[6].src = 3;
		graph.edge[6].dest = 1;
		graph.edge[6].weight = 4;
		
		graph.edge[7].src = 3;
		graph.edge[7].dest = 4;
		graph.edge[7].weight = 6;
		
		graph.edge[8].src = 4;
		graph.edge[8].dest = 1;
		graph.edge[8].weight = 4;
		
		graph.edge[9].src = 4;
		graph.edge[9].dest = 2;
		graph.edge[9].weight = 7;
		
		graph.edge[10].src = 5;
		graph.edge[10].dest = 2;
		graph.edge[10].weight = 5;
		
		graph.edge[11].src = 5;
		graph.edge[11].dest = 6;
		graph.edge[11].weight = 9;
		
		graph.edge[12].src = 6;
		graph.edge[12].dest = 3;
		graph.edge[12].weight = -5;
		
        do {
        	 System.out.println("===== RESPONSI ALPRO II =====");
             System.out.println("=====     TUGAS 2       =====");
             System.out.println("\n1. Mencari suatu shortest path");
             System.out.println("2. Sorting shortest path untuk suatu asal");
             System.out.println("3. Menampilkan isi dari seluruh graph");
             System.out.println("4. Menampilkan jarak suatu simpul ke simpul lain");
             System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nilai src: ");
                    int src = input.nextInt();
                    System.out.print("Masukkan nilai dest: ");
                    int dest = input.nextInt();
                    graph.BellmanFord(src, dest);
                    break;
                    
                case 2:
                    // Implementasi sorting shortest path
                	System.out.print("Masukkan nilai src: ");
                    int src2 = input.nextInt();
                    graph.sortShortestPathBySource(src2);
                    break;
                    
                case 3:
                	System.out.print("Isi Dari Seluruh Graph");
                	graph.printGraph();
                	break;
                 
                case 4:
                	System.out.print("Masukkan nilai src: ");
                    int src3 = input.nextInt();
                    graph.showpaths(src3);
                    break;
                    
                case 5:
                    System.out.println("Terima kasih");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
            System.out.println();
        } while (choice != 5);
    }
}