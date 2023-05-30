package com.responsi;

public class datakaryawan {
    private final String[] nik  = new String[100];
    private final String[] nama = new String[100];
    private final int[] gapok   = new int[100];
    public int n;
    public void setNIK(int i, String nik) {
        this.nik[i] = nik;
    }
    public void setNama(int i, String nama) {
        this.nama[i] = nama;
    }
    public void setGapok(int i, int gapok) {
        this.gapok[i] = gapok;
    }
    public float rerataGapok() {
        int sum = 0;
        for (int i=0; i<this.n; i++) {
            sum += this.gapok[i];
        } return (float)sum/this.n;
    }
    public void setJmlKaryawan(int x) {
        this.n = x;
    }
    public void tampilData() {
        System.out.println("======================================================================");
        System.out.println("NIK \t\t NAMA \t\t GAJI");
        System.out.println("======================================================================");
        for (int i=0; i<this.n; i++) {
            System.out.printf("%-15s %-15s Rp %5d%n", nik[i],  nama[i], + gapok[i]);
        }
        System.out.println("======================================================================");
        System.out.println("\nRata-rata gaji pokok dari  "+ this.n +"  karyawan adalah Rp  " + this.rerataGapok());
        System.out.println("\n");
    }
}

