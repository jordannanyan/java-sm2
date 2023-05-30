package com.belajar;
import java.util.Scanner;


public class stringmatching {

    //jumlah maksimal string
    public final static int d = 256;
    
    //fungsi bubble searcH untuk mencari kecocokan secara naive search
    public static void bubblesearch(String str, String pattern) { 
        int n = str.length(); 
        int m = pattern.length(); 
        
        for (int s = 0; s <= n - m; s++) { 
            int j; 
            for (j = 0; j < m; j++) 
                if (str.charAt(s + j) != pattern.charAt(j)) 
                    break; 
                if (j == m) 
                    System.out.println("Teks ditemukan pada indeks ke- " + s); 
        } 
    } 
    
    
    //fungsi searchkarp untuk mencari kecocokan secara rabin karp
    static void searchkarp(String pat, String txt, int q)
    {
        int M = pat.length();
        int N = txt.length();
        int i, j;   
        int p = 0; // nilai hash untuk patern
        int t = 0; // nilai hash untuk text
        int h = 1;
  
        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;
  
        // 
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }
  
        // geser patern satu persatu
        for (i = 0; i <= N - M; i++) {
  
            // Check nilai hash
            if (p == t) {
                // cek karakter satu persatu
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }
  
                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M)
                    System.out.println("Teks ditemukan pada indeks ke- " + i);
            }
  
            // hitung nilai hash untuk pola berikutnya
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
  
                // jika mendapatkan nilai negatif, maka diubah menjadi positif
                if (t < 0)
                    t = (t + q);
            }
        }
    }

    static int NO_OF_CHARS = 256;
    static int getNextState(char[] pat, int M, int state, int x)
    {
    //Jika karakter c sama dengan karakter berikutnya di dalam pattern maka increment state
        if(state < M && x == pat[state])
        return state + 1;
        
        // ns adalah variabel yang menyimpan hasil state berikutnya (next state)
        int ns, i;
        
        // berikutnya ns berisi awalan terpanjang
        // yang juga merupakan akhiran dalam "pat [0..state-1] c" 
        // Mulai dari kemungkinan nilai terbesar
        // dan berhenti ketika Anda menemukan awalan yang akhiran
        for (ns = state; ns > 0; ns--)
        {
            if (pat[ns-1] == x)
            {
                for (i = 0; i < ns-1; i++)
                    if (pat[i] != pat[state-ns+1+i])
                        break;
                    if (i == ns-1)
                        return ns;
            }
        } 
        return 0;
    }
    
    // membangun tabel untuk merepresentasikikan fungsi automata dari suatu pola 
    static void computeTF(char[] pat, int M, int TF[][])
    {
        int state, x;
        for (state = 0; state <= M; ++state)
            for (x = 0; x < NO_OF_CHARS; ++x)
                TF[state][x] = getNextState(pat, M, state, x);
    }
    
    //fungsi searchfsa untuk mencari kecocokan di dalam text
    static void searchfsa(char[] tx, char[] pt)
    {
        int M = pt.length;
        int N = tx.length;
        
        int[][] TF = new int[M+1][NO_OF_CHARS];
        
        computeTF(pt, M, TF);
        
        // process pencocokan teks ke pola.
        int i, state = 0;
        for (i = 0; i < N; i++)
        {
            state = TF[state][tx[i]];
            if (state == M)
                System.out.println("Teks ditemukan pada indeks ke- " + (i-M+1));
        }
    }
   
    //fungsi KMP search
    void KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
        // buat variabel lps[] untuk menangani 
        // nilai awalan dan akhiran terpanjang untuk pattern/pola
        int lps[] = new int[M];
        int j = 0;
        // pra pemrosesan pattern (kalkulasi array lps[])
        computeLPSArray(pat, M, lps);
        int i = 0; // index untuk txt[]
        //pengulangan while untuk mencari kecocokan
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;

            }
            //percabangan if untuk menuliskan kecocokan pada index ke berapa
            if (j == M) {
                System.out.println("Teks ditemukan pada indeks ke- " + (i - j));
                j = lps[j - 1];
            }
            // ketidakcocokan pada pencocokan indeks J pattern
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                j = lps[j - 1];
            else
                i = i + 1;
            }
        }
    }
    
    //fungsi computeLPSArray untuk mengkalkulasi array lps
    void computeLPSArray(String pat, int M, int lps[])
    {
        
        // panjang dari awalan(prefix) dan akhiran (suffix) 
        //terpanjang sebelumnya
        int len = 0;
        int i = 1;
        lps[0] = 0;
        
        // Looping untuk kalkulasi lps[i] = 1 sampai M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
            
                if (len != 0) {
                    len = lps[len - 1];
                }
                else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
 


    public static void main(String[] args) {
        try (Scanner input = new Scanner (System.in)) {
            //deklarasi beberapa variabel
            String txt; 
            String pat;
            int x;

            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Aplikasi Pencarian String");
            System.out.println("=============================================================================================");
            System.out.print("Masukan Teks : ");
            txt = input.nextLine();
            System.out.print("Masukan Teks Yang Dicari : ");
            pat = input.nextLine();
            //keterangan menu
            System.out.println("Pilih Metode Pencarian");
            System.out.println(" 1. Naive");
            System.out.println(" 2. Rabin Karp");
            System.out.println(" 3. Finite State Automata");
            System.out.println(" 4. Knuth Morris Pratt");
            System.out.print("Metode Yang Dipilih : ");
            x = input.nextInt();
            System.out.println("=============================================================================================");
            
            System.out.println();
            System.out.println("Hasil Pencarian");
            System.out.println();

            //percabangan if dengan integer x untuk memilih menu program
            if (x == 1) {
                bubblesearch(txt, pat); 

            }else if (x == 2) {
                int q = 101;
                searchkarp(pat, txt, q);

            }else if (x == 3) {
                //variabel string di ubah ke char untuk metode finite state automata
                char[] tx = txt.toCharArray();
                char[] pt = pat.toCharArray();
                searchfsa(tx, pt);

            }else if (x == 4) {
                new stringmatching().KMPSearch(pat, txt);

            }else 
                System.out.println("Metode Pilihan Tidak Di Dalam Menu");
        }
    } 
}


