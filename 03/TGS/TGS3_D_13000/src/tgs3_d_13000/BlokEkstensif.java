/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tgs3_d_13000;

/**
 *
 * @author farel
 */
public class BlokEkstensif extends BlokSawitProduktif {
    private double kapasitasAlatPanen;
    private final double BATASKAPASITAS = 500.0;

    public BlokEkstensif(String namaBlok, String kodeBlok, double luasHektar, int tahunTanam, double biayaPerHa, double hasilTBSPerHa, double kapasitasAlatPanen ) {
        super(namaBlok, kodeBlok, luasHektar, tahunTanam, biayaPerHa, hasilTBSPerHa);
        this.kapasitasAlatPanen = kapasitasAlatPanen;
    }

    public BlokEkstensif(String namaBlok, String kodeBlok, double luasHektar, int tahunTanam, double biayaPerHa, String statusLahan, double hasilTBSPerHa, double kapasitasAlatPanen) {
        super(namaBlok, kodeBlok, luasHektar, tahunTanam, biayaPerHa, statusLahan, hasilTBSPerHa);
        this.kapasitasAlatPanen = kapasitasAlatPanen;
    }

    @Override
    public double hitungBiayaServisTanam() {
        double dasar = 250000;
        double alat = kapasitasAlatPanen * 500;
        if(kapasitasAlatPanen > BATASKAPASITAS)
            return dasar + alat + 300000;
        else return dasar + alat;
    }

    @Override
    public void tampilData() {
        super.tampilData(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        System.out.println("Kapasitas Alat Panen : " +kapasitasAlatPanen +" kg" );
    }

    @Override
    public double hitungBiayaPerawatan() {
        double dasar = super.hitungBiayaPerawatan();
        if(kapasitasAlatPanen > BATASKAPASITAS)
            return dasar * 1.02;
        else return dasar;
    }
    
    
    
}
