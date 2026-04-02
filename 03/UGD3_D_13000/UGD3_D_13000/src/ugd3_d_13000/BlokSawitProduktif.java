
package ugd3_d_13000;

public class BlokSawitProduktif  extends KebunSawit implements ISubsidiPemeliharaan{
    private double hasilTBSPerHa;

    public BlokSawitProduktif(String namaBlok, String kodeBlok, double luasHektar, int tahunTanam, double biayaPerHa, double hasilTBSPerHa) {
        super(namaBlok, kodeBlok, luasHektar, tahunTanam, biayaPerHa);
        this.hasilTBSPerHa = hasilTBSPerHa;
        jenisBlok = "Sawit Produktif";
        this.addKebun(this);
    }

    public BlokSawitProduktif(String namaBlok, String kodeBlok, double luasHektar, int tahunTanam, double biayaPerHa, String statusLahan, double hasilTBSPerHa) {
        super(namaBlok, kodeBlok, luasHektar, tahunTanam, biayaPerHa, statusLahan);
        this.hasilTBSPerHa = hasilTBSPerHa;
        jenisBlok = "Sawit Produktif";
        this.addKebun(this);
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
    
}
