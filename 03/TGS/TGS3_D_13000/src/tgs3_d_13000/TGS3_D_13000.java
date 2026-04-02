
package tgs3_d_13000;
public class TGS3_D_13000 {

 public static void main(String[] args) {
	KebunSawit kebun;

        kebun = new BlokSawitMuda("Blok A1", "A1", 12.5, 2022, 3000000.0, "Tinggi");
        kebun = new BlokSawitMuda("Blok A2", "A2", 10.0, 2021, 3000000.0, "Aktif", "Sedang");
        kebun = new BlokSawitProduktif("Blok B1", "B1", 20.0, 2015, 4500000.0, "Aktif", 32.5);
        kebun = new BlokSawitProduktif("Blok B2", "B2", 18.0, 2016, 4500000.0, 18.0);

        if (KebunSawit.daftarKebun.isEmpty()) {
            System.out.println("List kebun masih kosong!");
        } else {
            KebunSawit.tampilSemuaKebun();
            System.out.println();
	    System.out.println("=== Biaya Perawatan ===");
            KebunSawit.tampilSemuaBiayaPerawatan();
        }

        BlokStandar bs1 = new BlokStandar("Blok B3-S", "B3S", 18.0, 2015,
                4500000.0, 22.0, "Tetes", 4);
        BlokStandar bs2 = new BlokStandar("Blok B4-S", "B4S", 20.0, 2014,
                4500000.0, "Produktif", 25.0, "Sprinkler", 2);
        BlokEkstensif be1 = new BlokEkstensif("Blok B5-E", "B5E", 25.0, 2013,
                4500000.0, 30.0, 550.0);
        BlokEkstensif be2 = new BlokEkstensif("Blok B6-E", "B6E", 22.0, 2014,
                4500000.0, "Produktif", 20.0, 400.0);

        if (BlokSawitProduktif.daftarBlokProduktif.isEmpty()) {
            System.out.println("List blok produktif masih kosong!");
        } else {
            System.out.println();
	    System.out.println("========== TUGAS POLIMORFISME ==========");
            System.out.println("===== DATA SEMUA BLOK PRODUKTIF =====");
            System.out.println("Jumlah blok produktif: " +
            BlokSawitProduktif.daftarBlokProduktif.size());
            BlokSawitProduktif.tampilDaftarBlokProduktif();
        }
    }   
}
