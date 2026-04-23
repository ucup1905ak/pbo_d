package tgs5_d_13000;

import java.util.*;
// Farelino Alexander Kim
public class RentalMobil <X, Y>{
    private String namaRentalMobil;
    private DataMobil<? extends X> dataMobil;
    private List<Y> pelanggan = new ArrayList<>();
    
    public RentalMobil(String namaRentalMobil, DataMobil<? extends X> dataMobil) {
        this.namaRentalMobil = namaRentalMobil;
        this.dataMobil = dataMobil;
    }
    public Y getPelanggan(int idx){return pelanggan.get(idx);}
    public void addPelanggan(Y p){
//        addPelanggan(new Pelanggan("Andi", "1275010101010001", 21, "Jl. Setia Budi"));
        if (p == null) return;
        pelanggan.add(p);
        
    }
    public void displayDataMobil(){
        if (dataMobil == null) return;
        dataMobil.displayMobil();
    }
    
    public void displayPelanggan(){
        if (pelanggan == null) return;
        for(Y e : pelanggan){
            System.out.println(e);
        }
    
    }
    public void displayAll(){
        System.out.println("===========================");
        System.out.println("Rental Mobil    : " + namaRentalMobil);
        this.displayDataMobil();
        this.displayPelanggan();
    
    }
}



// NPM : 240713000 - FARELINO ALEXANDER KIM
