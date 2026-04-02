
package ugd3_d_13000;


public class BlokSawitMuda extends KebunSawit implements ISubsidiPemeliharaan{
    private String tingkatKesuburan;

    public BlokSawitMuda(String namaBlok, String kodeBlok, double luasHektar, int tahunTanam, double biayaPerHa, String tingkatKesuburan) {
        super(namaBlok, kodeBlok, luasHektar, tahunTanam, biayaPerHa);
        this.tingkatKesuburan = tingkatKesuburan;
        jenisBlok = "Sawit Muda";
        this.addKebun(this);
    }

    public BlokSawitMuda(String namaBlok, String kodeBlok, double luasHektar, int tahunTanam, double biayaPerHa, String statusLahan, String tingkatKesuburan) {
        super(namaBlok, kodeBlok, luasHektar, tahunTanam, biayaPerHa, statusLahan);
        this.tingkatKesuburan = tingkatKesuburan;
        jenisBlok = "Sawit Muda";
        this.addKebun(this);
    }
    private double hargaNormal(){
        return biayaPerHa * luasHektar;
    }
    @Override
    public double hitungSubsidi() {
        if(tingkatKesuburan.equals("Tinggi")){
            return 0.2 * hargaNormal();
        }else if(tingkatKesuburan.equals("Sedang")){
            return 0.1 * hargaNormal();
        }else return 0;
    }
    

    @Override
    public double hitungBiayaPerawatan() {
        return hargaNormal() - hitungSubsidi();
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
        System.out.println("Tingkat Kesuburan\t: "+ tingkatKesuburan);
    }


    
}
