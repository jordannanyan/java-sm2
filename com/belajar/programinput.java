package com.belajar;
import java.io.*;

public class programinput {
    public String bacaNama () {
        BufferedReader bfr = new BufferedReader (new InputStreamReader (System.in));
        String string = ""; 
        try {
            string = bfr.readLine();    
        }
        catch (IOException ex){
            System.out.println(ex);
        }
        return string;
    }
    public int bacaHarga() {
        return Integer.parseInt(bacaNama());
    }
}
