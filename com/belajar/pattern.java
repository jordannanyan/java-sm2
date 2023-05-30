package com.belajar;
import java.util.ArrayList;
import java.util.HashMap;
public class pattern {

        public final static int d = 10;
    
        static void search(String[] patterns, String txt, int q) {
            int n = txt.length();
            int[] t = new int[patterns.length];
            int[] h = new int[patterns.length];
            ArrayList<HashMap<Integer, String>> patternMaps = new ArrayList<HashMap<Integer, String>>();
    
            for (int i = 0; i < patterns.length; i++) {
                int p = 0;
                h[i] = 1;
                for (int j = 0; j < patterns[i].length() - 1; j++) {
                    h[i] = (h[i] * d) % q;
                }
                for (int j = 0; j < patterns[i].length(); j++) {
                    p = (d * p + patterns[i].charAt(j)) % q;
                    t[i] = (d * t[i] + txt.charAt(j)) % q;
                }
                HashMap<Integer, String> patternMap = new HashMap<Integer, String>();
                patternMaps.add(patternMap);
                for (int j = 0; j <= txt.length() - patterns[i].length(); j++) {
                    if (j == 0) {
                        for (int k = 0; k < patterns.length; k++) {
                            patternMap.put((d * p + patterns[k].charAt(0)) % q, patterns[k]);
                        }
                    }
                    if (j > 0) {
                        int oldHash = (d * t[i] - txt.charAt(j - 1) * h[i] + txt.charAt(j + patterns[i].length() - 1)) % q;
                        if (oldHash < 0) {
                            oldHash += q;
                        }
                        t[i] = oldHash;
                        patternMaps.get(i).remove((d * p + txt.charAt(j - 1) * h[i]) % q);
                        patternMaps.get(i).put(oldHash, patterns[i]);
                    }
                    if (patternMaps.get(i).containsKey(t[i])) {
                        System.out.println("Pola ditemukan pada indeks " + j);
                    }
                }
            }
        }
    
    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String[] patterns = {"AB", "BA", "CA"};
        int q = 101;
        search(patterns, txt, q);
    }
}

