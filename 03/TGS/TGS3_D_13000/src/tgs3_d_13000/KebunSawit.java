

package tgs3_d_13000;
import java.util.ArrayList;

public abstract class KebunSawit {
    protected String statusLahan, namaBlok, kodeBlok, jenisBlok;
    protected double luasHektar, biayaPerHa;
    protected int tahunTanam;
    public static ArrayList<KebunSawit> daftarKebun;

    public KebunSawit(String namaBlok, String kodeBlok, double luasHektar, int tahunTanam, double biayaPerHa) {
        this.namaBlok = namaBlok;
        this.kodeBlok = kodeBlok;
        this.luasHektar = luasHektar;
        this.tahunTanam = tahunTanam;
        this.biayaPerHa = biayaPerHa;
        if(daftarKebun == null){
            daftarKebun = new ArrayList<>();
        }

    }

    public KebunSawit(String namaBlok, String kodeBlok, double luasHektar, int tahunTanam,double biayaPerHa, String statusLahan) {
        this.statusLahan = statusLahan;
        this.namaBlok = namaBlok;
        this.kodeBlok = kodeBlok;
        this.luasHektar = luasHektar;
        this.tahunTanam = tahunTanam;
        this.biayaPerHa = biayaPerHa;
        if(daftarKebun == null){
            daftarKebun = new ArrayList<>();
        }


    }
    
    public void addKebun(KebunSawit sawit){
        daftarKebun.add(sawit);
//        System.out.println("Berhasil menambahkan kebun");
    }
    public abstract double hitungBiayaPerawatan();
    
    public void tampilData(){
        System.out.println("\n----- Tampil Data Kebun Sawit -----");
        System.out.println("Nama Blok\t\t: " + namaBlok);
        System.out.println("Kode Blok\t\t: " + kodeBlok);
        System.out.println("Luas     \t\t: " + luasHektar);
        System.out.println("Tahun Tanam\t: " + tahunTanam);
        System.out.println("Umur Tanaman\t: " + (2026 - tahunTanam));
        System.out.println("Jenis Block\t: " + jenisBlok);
    }
    
    public static void tampilSemuaKebun(){
        for(KebunSawit i : daftarKebun){
            i.tampilData();
        }
    }
    public static void tampilSemuaBiayaPerawatan(){
        for(KebunSawit i : daftarKebun){
            System.out.printf("%s -> Biaya Perawatan: Rp%.2f\n", i.namaBlok, i.hitungBiayaPerawatan());
        }
    }
    
//
//    public static void selectionSort(){
//        if(daftarKebun.isEmpty()) return;
//        int size = daftarKebun.size();
//        
//        for(int i = 0 ; i < size; i++){
//            KebunSawit now = daftarKebun.get(i);
//            KebunSawit min = daftarKebun.get(i+1), temp = daftarKebun.get(i);
//            for(int j = i + 1  ; j < size; j++){
//                min = daftarKebun.get(j);
//                temp = daftarKebun.get(i);
//                if(min.jenisBlok.compareTo(temp.jenisBlok) < 0){
//                    temp = min;
//                }
//            }
//            daftarKebun.set(daftarKebun.indexOf(min), now);
//            daftarKebun.set(i, min);
//        }
//    
    }
