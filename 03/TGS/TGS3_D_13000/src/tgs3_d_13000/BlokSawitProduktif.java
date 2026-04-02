
package tgs3_d_13000;

import java.util.ArrayList;

public class BlokSawitProduktif  extends KebunSawit implements ISubsidiPemeliharaan, IServisTanam {
    protected double hasilTBSPerHa;
    public static ArrayList<BlokSawitProduktif> daftarBlokProduktif;

    public BlokSawitProduktif(String namaBlok, String kodeBlok, double luasHektar, int tahunTanam, double biayaPerHa, double hasilTBSPerHa) {
        super(namaBlok, kodeBlok, luasHektar, tahunTanam, biayaPerHa);
        this.hasilTBSPerHa = hasilTBSPerHa;
        jenisBlok = "Sawit Produktif";
        this.addKebun(this);
        if(daftarBlokProduktif == null){
            daftarBlokProduktif = new ArrayList<>();
        }
        addBlokProduktif(this);
    }

    public BlokSawitProduktif(String namaBlok, String kodeBlok, double luasHektar, int tahunTanam, double biayaPerHa, String statusLahan, double hasilTBSPerHa) {
        super(namaBlok, kodeBlok, luasHektar, tahunTanam, biayaPerHa, statusLahan);
        this.hasilTBSPerHa = hasilTBSPerHa;
        jenisBlok = "Sawit Produktif";
        this.addKebun(this);
        if(daftarBlokProduktif == null){
            daftarBlokProduktif = new ArrayList<>();
        }
        addBlokProduktif(this);
    }


    
    private double hargaNormal(){
        return biayaPerHa * luasHektar;
    }
    @Override
    public double hitungBiayaPerawatan() {
        return hargaNormal() - hitungSubsidi();
    }
    
    @Override
    public double hitungSubsidi() {
        if(hasilTBSPerHa > 30){
            return hargaNormal() * 0.15;
        }else{
            return hargaNormal() * 0.1;
        }
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
    }

    @Override
    public double hitungBiayaServisTanam() {
        return 0;
    }
    
    
    public void addBlokProduktif(BlokSawitProduktif blokSawit){
        daftarBlokProduktif.add(blokSawit);
    }
    private static void tampilMethodBlok(BlokSawitProduktif i){
        System.out.println("---- Tampil Method Blok Produktif");
        System.out.printf("Subsidi Pemeliharaan\t: Rp%,.0f\n",i.hitungSubsidi());
        System.out.printf("Biaya Perawatan\t\t: Rp%,.0f\n",i.hitungBiayaPerawatan());
        System.out.printf("Biaya Servis Tanam \t: Rp%,.0f\n",i.hitungBiayaServisTanam());
    }
    public static void tampilDaftarBlokProduktif(){
        for(BlokSawitProduktif i : daftarBlokProduktif){
            i.tampilData();
            tampilMethodBlok(i);
        }       
    }

}
