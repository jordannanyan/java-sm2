package com.modul4;


import java.util.Scanner;

public class myInput {
         static Scanner input = new Scanner(System.in);
        public static String bacaString() {
            String string = " ";
            try {
                string = input.next();
            }
            catch (Exception eox) {
                System.out.println(eox);
            }
            return string;
        }
        public static int bacaInt() {
            return Integer.parseInt(bacaString());
         }
   }