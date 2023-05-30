package com.belajar;
import java.util.Arrays;

class Edge implements Comparable<Edge> {
    char src, dest;
    int weight;
 
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
};

class Graph {
    int V, E;
    Edge edges[];
 
    Graph(int V, int E) {
        this.V = V;
        this.E = E;
        edges = new Edge[E];
        for (int i = 0; i < E; ++i)
            edges[i] = new Edge();
    }
 
    int find(int parent[], int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }
 
    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }
 
    void kruskalMST() {
        Edge[] result = new Edge[V];
        int[] parent = new int[V];
        for (int i = 0; i < V; ++i)
            parent[i] = i;
        Arrays.sort(edges);
        int e = 0;
        int i = 0;
        while (e < V - 1 && i < E) {
            Edge next_edge = edges[i++];
            int x = find(parent, next_edge.src - 'A');
            int y = find(parent, next_edge.dest - 'A');
            if (x != y) {
                result[e++] = next_edge;
                union(parent, x, y);
            }
        }
        System.out.println("Minimum Spanning Tree:");
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].weight);
        }
    }
}

public class Person1 {
    
    public static void main(String[] args) {
        int V = 20;
        int E = 21;
        Graph graph = new Graph(V, E);
 
        graph.edges[0].src = 'A';
        graph.edges[0].dest = 'B';
        graph.edges[0].weight = 9;
        
        graph.edges[1].src = 'A';
        graph.edges[1].dest = 'C';
        graph.edges[1].weight = 12;
 
        graph.edges[2].src = 'A';
        graph.edges[2].dest = 'D';
        graph.edges[2].weight = 11;
 
        graph.edges[3].src = 'A';
        graph.edges[3].dest = 'E';
        graph.edges[3].weight = 11;
 
        graph.edges[4].src = 'A';
        graph.edges[4].dest = 'F';
        graph.edges[4].weight = 18;
 
        graph.edges[5].src = 'A';
        graph.edges[5].dest = 'G';
        graph.edges[5].weight = 15;
        
        graph.edges[6].src = 'B';
        graph.edges[6].dest = 'C';
        graph.edges[6].weight = 4;
 
        graph.edges[7].src = 'B';
        graph.edges[7].dest = 'D';
        graph.edges[7].weight = 2;
 
        graph.edges[8].src = 'B';
        graph.edges[8].dest = 'E';
        graph.edges[8].weight = 3;
 
        graph.edges[9].src = 'B';
        graph.edges[9].dest = 'F';
        graph.edges[9].weight = 8;
 
        graph.edges[10].src = 'B';
        graph.edges[10].dest = 'G';
        graph.edges[10].weight = 14;
        
        graph.edges[11].src = 'C';
        graph.edges[11].dest = 'D';
        graph.edges[011].weight = 6;
        
        graph.edges[12].src = 'C';
        graph.edges[12].dest = 'E';
        graph.edges[12].weight = 5;
 
        graph.edges[13].src = 'C';
        graph.edges[13].dest = 'F';
        graph.edges[13].weight = 11;
 
        graph.edges[14].src = 'C';
        graph.edges[14].dest = 'G';
        graph.edges[14].weight = 10;
 
        graph.edges[15].src = 'D';
        graph.edges[15].dest = 'E';
        graph.edges[15].weight = 13;
 
        graph.edges[16].src = 'D';
        graph.edges[16].dest = 'F';
        graph.edges[16].weight = 7;
        
        graph.edges[17].src = 'D';
        graph.edges[17].dest = 'G';
        graph.edges[17].weight = 16;
        
        graph.edges[18].src = 'E';
        graph.edges[18].dest = 'F';
        graph.edges[18].weight = 6;
 
        graph.edges[19].src = 'E';
        graph.edges[19].dest = 'G';
        graph.edges[19].weight = 14;
        
        graph.edges[20].src = 'F';
        graph.edges[20].dest = 'G';
        graph.edges[20].weight = 20;
        graph.kruskalMST();
    }
}