package com.belajar;
import java.util.Scanner;
import java.io.IOException; 
public class Mobil {
	static boolean isRunning = true; 
    
    static void DaftarProduk() 
    { 
        String[] produk;
        produk = new String[16];
        produk[0] = "Red Velvet";
        produk[1] = "Oreo ";
        produk[2] = "Taro ";
        produk[3] = "Bubble Gum ";
        produk[4] = "Tiramisu  ";
        produk[5] = "Caramalo  ";
        produk[6] = "Cappucino ";
        produk[7] = "Avacado ";
        produk[8] = "Banana ";
        produk[9] = "Avaltine ";
        produk[9] = "Pisang Krispi ";
        produk[10]= "Sistagor ";
        produk[11]= "Kentang Goreng  ";
        produk[12]= "Risoles ";
        produk[13]= "Bacigor ";
        produk[14]= "Indomie ";
      
        String[] harga;
        harga = new String[10];
        harga[0] = "15.000";
        harga[1] = "12.000";
        harga[2] = "10.000";
        harga[3] = "";
        harga[4] = "245.000.000";
        harga[5] = "500.000.000";
        harga[6] = "169.000.000";
        harga[7] = "789.000.000";
        harga[8] = "122.900.000";
        harga[9] = "278.100.000";

        System.out.println("+====================================================+");
        System.out.println("|               Daftar Harga Mobil                   |");
        System.out.println("|====================================================|");
        System.out.println("|No \t  Tabel Produk \t\t Harga               |");
        System.out.println("+====================================================+");


        for (int i = 0; i < 10; i++) {  
      
            System.out.println((i + 1) + " \t " + produk[i] + " \t \t "+ "Rp." + harga[i]);    
    }
    }
    

    static void CariData() 
    {
        Scanner scan = new Scanner(System.in); 
        boolean ada = false;
        int i;           
        
        System.out.print("Masukkan Nama Brand Mobil : ");
        String value = scan.nextLine();
        
        String[] produk = {"Jaguar", "Lamborgini", "Honda", "Audi", "Suzuki", "Mazda", "Daihatsu", "Ford", "Hyundai", "Mitsubishi"};
        String[] harga = {"1.340.000.000", "34.500.000.000", "350.000.000", "2.000.000.000", "245.000.000", "500.000.000", "169.000.000", "789.000.000", "122.900.000", "278.100.000"};        
        
        
        for ( i = 0; i < produk.length; i++) {
            if (produk[i].equalsIgnoreCase(value)) {
            ada = true; 
            break;
            }
       
        } if (ada) {
            System.out.println("");
            System.out.println("Brand mobil " + value + " terdapat pada index array ke-" + i);
            System.out.println("");
            System.out.println("Harga dari brand mobil tersebut adalah : "+ "Rp." + harga[i]);

        } else {
            System.out.println("");
            System.err.println("Data yang anda masukkan tidak ditemukan.");
        }
    }

    static void MengurutkanHarga() 
    {
        Scanner input=new Scanner(System.in);   
        String[] produk = {"Jaguar", "Lamborgini", "Honda", "Audi", "Suzuki", "Mazda", "Daihatsu", "Ford", "Hyundai", "Mitsubishi"};
        long[] harga = {1340000000, 34500000000L, 350000000, 2000000000, 245000000, 500000000, 169000000, 789000000, 122900000, 278100000};        
        System.out.println("");
        
        long tmp;
        String brand; 

        for(int c=1; c<10; c++){        
            for(int d=0; d<10-c; d++){  
                if(harga[d] > harga[d+1])
                   
                {
                    brand= produk[d];      
                    produk[d]=produk[d+1];  
                    produk[d+1]=brand;      

                    tmp = harga[d];         
                    harga[d] = harga[d+1];  
                    harga[d+1]=tmp;         
                }
            }
        }
        System.out.println("Urutan Harga Mobil Terendah sampai Tertinggi : ");        
        
        for(int i=0;i<10;i++){ 
            System.out.println("Produk mobil "+produk[i]+ " dengan harga " + "Rp. "+ harga[i]);
        }
    }
     
    static void MenunjukData() 
    {
        String[] produk = {"Jaguar", "Lamborgini", "Honda", "Audi", "Suzuki", "Mazda", "Daihatsu", "Ford", "Hyundai", "Mitsubishi"};
        long[] harga = {1340000000, 34500000000L, 350000000, 2000000000, 245000000, 500000000, 169000000, 789000000, 122900000, 278100000};        
        int cari = 169000000;       
        int i;                      
        boolean ditemukan = false;  
        
        for(i=0; i < harga.length; i++){  
            if (harga[i] == cari){ 
                ditemukan=true;  
                break; 
            } 
        }
        if (ditemukan) { 
            System.out.println("");
            System.out.println("Harga mobil termurah ke-2");
            System.out.println("Brand mobil " +produk[i]+ " dengan harga Rp " +cari);
        } 
        else{ 
            System.out.println("Data Tidak di temukan"); 
        }
    }
    
    static void showMenu() 
    {
    	System.out.println("\n+======================================+");
        System.out.println("|\t\tMenu Utama             |");
        System.out.println("+======================================+");
        System.out.println("\n[1] Daftar Produk");       
        System.out.println("[2] Mencari Harga Produk");
        System.out.println("[3] Mengurutkan Harga");
        System.out.println("[4] Mencari Harga Terendah");
        System.out.println("[5] Exit");
        Scanner scan = new Scanner(System.in);
        int selectedMenu;
        System.out.println("");
        System.out.print("Masukkan Menu : ");
        selectedMenu = scan.nextInt();
        switch(selectedMenu){
            case 1:             
                DaftarProduk();     
                break;                       
            case 2:
                CariData();        
                break;              
            case 3:
                MengurutkanHarga(); 
                break;              
            case 4:
                MenunjukData();    
                break;              
            case 5:
                System.exit(0);     
                break;              
            default:
                System.out.println("+++Menu Itdak Ada+++");

        }
    }

    public static void main(String[] args) throws IOException {
        do {
            showMenu();
        }while (isRunning);    
    }  
    {
}

}
		