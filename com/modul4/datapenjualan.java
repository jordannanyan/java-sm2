package com.modul4;

public class datapenjualan {
    private final String[] tanggal  = new String[100];
    private final String[] namakasir = new String[100];
    private final int[] keuntungan  = new int[100];
    public int n;
    public void setTanggal(int i, String tanggal) {
        this.tanggal[i] = tanggal;
    }
    public void setNamakasir(int i, String namakasir) {
        this.namakasir[i] = namakasir;
    }
    public void setKeuntungan(int i, int keuntungan) {
        this.keuntungan[i] = keuntungan;
    }
    public float reratakeuntungan() {
        int sum = 0;
        for (int i=0; i<this.n; i++) {
            sum += this.keuntungan[i];
        } return (float)sum/this.n;
    }
    public void setJmlKaryawan(int x) {
        this.n = x;
    }
    public void tampilData() {
        System.out.println("======================================================================");
        System.out.println("tanggal \t\t Nama kasir \t\t Keuntungan");
        System.out.println("======================================================================");
        for (int i=0; i<this.n; i++) {
            System.out.printf("%-25s %-22s Rp %5d%n", tanggal[i],  namakasir[i], + keuntungan[i]);
        }
        System.out.println("======================================================================");
        System.out.println("\nRata-rata Keuntungan dari Toko tersebut adalah Rp  " + this.reratakeuntungan());
        System.out.println("\n");
    }
}

