/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tgs3_d_13000;

/**
 *
 * @author farel
 */
public class BlokStandar extends BlokSawitProduktif{
    private String jenisIrigasi;
    private int jumlahModifikasi;

    public BlokStandar(String namaBlok, String kodeBlok, double luasHektar, int tahunTanam, double biayaPerHa, double hasilTBSPerHa, String jenisIrigasi, int jumlahModifikasi) {
        super(namaBlok, kodeBlok, luasHektar, tahunTanam, biayaPerHa, hasilTBSPerHa);
        this.jenisIrigasi = jenisIrigasi;
        this.jumlahModifikasi = jumlahModifikasi;
    }

    public BlokStandar(String namaBlok, String kodeBlok, double luasHektar, int tahunTanam, double biayaPerHa, String statusLahan, double hasilTBSPerHa, String jenisIrigasi, int jumlahModifikasi) {
        super(namaBlok, kodeBlok, luasHektar, tahunTanam, biayaPerHa, statusLahan, hasilTBSPerHa);
        this.jenisIrigasi = jenisIrigasi;
        this.jumlahModifikasi = jumlahModifikasi;
    }

    @Override
    public double hitungBiayaServisTanam() {
        double biayaDasar = 200000;
        double biayaIrigasi = 150000; //default tetes
        if(jenisIrigasi.equals("Tetes")){
            biayaIrigasi = 150000;
        }else if(jenisIrigasi.equals("Sprinkler")){
            biayaIrigasi = 100000;
        }else biayaIrigasi = 50000;
        
        double biayaModifikasi = 40000 * jumlahModifikasi;
        
        return biayaDasar + biayaIrigasi + biayaModifikasi;
    }
    

    @Override
    public void tampilData() {
        System.out.println("\n----- Tampil Data Kebun Sawit -----");
        System.out.println("Nama Blok\t: " + namaBlok);
        System.out.println("Kode Blok\t: " + kodeBlok);
        System.out.println("Luas     \t: " + luasHektar);
        System.out.println("Tahun Tanam\t: " + tahunTanam);
        System.out.println("Umur Tanaman\t: " + (2026 - tahunTanam));
        System.out.println("Jenis Block\t: " + jenisBlok);
        System.out.println("Hasil TBS/Ha\t: " + hasilTBSPerHa);
        System.out.println("Jenis Irigasi\t: " + jenisIrigasi);
        System.out.println("Jumlah Modifikasi: " + jumlahModifikasi);
    }

    @Override
    public double hitungBiayaPerawatan() {
        double dasar = super.hitungBiayaPerawatan();
        if(jumlahModifikasi > 2){
            return dasar * 1.03;
        }else return dasar;
    }
    
    
    
    
}
