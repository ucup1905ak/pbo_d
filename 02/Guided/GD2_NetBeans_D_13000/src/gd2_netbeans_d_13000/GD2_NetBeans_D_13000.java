
package gd2_netbeans_d_13000;


public class GD2_NetBeans_D_13000 {

    public static void main(String[] args) {

        Mobil mobil = new Mobil("Suzuki Ignis", 100,4,4);
        Kapal kapal = new Kapal("Sabuk Nusantara", 350, 500, 800);
        Pesawat pesawat = new Pesawat("Boeing 737", 275, 200, 45);
    
        System.out.println("=== Method Parent [ beroperasi() ] ===\n");
        mobil.beroperasi();
        kapal.beroperasi();
        pesawat.beroperasi();
        
        
        System.out.println("=== Hitung Operasional Transportasi ===");
        mobil.cekMobil(23);
        System.out.println("");
        kapal.cekKapal(45);
        System.out.println("");
        pesawat.cekPesawat(30);
        System.out.println("");
        
        System.out.println("=== Tampil Data Transportasi ===");
        mobil.tampilDataMobil();
        System.out.println("");
        kapal.tampilDataKapal();
        System.out.println("");
        pesawat.tampilDataPesawat();
    }
    
}
