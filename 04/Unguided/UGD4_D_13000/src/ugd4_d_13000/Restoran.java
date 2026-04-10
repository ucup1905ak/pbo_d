
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd4_d_13000;

import java.util.ArrayList;

/**
 *
 * @author komputasi9
 */
public class Restoran {
    String nama, lokasi;
    int tahunBerdiri;
    ArrayList<Kitchen> listKitchen = new ArrayList<>();

    public Restoran(String nama, String lokasi, int tahunBerdiri) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.tahunBerdiri = tahunBerdiri;
        
    }
    
    
    public void addKitchen (Kitchen k){
        if(k == null) return;
        listKitchen.add(k);
    }
    
    public void showRestoran(){
        System.out.println("Nama Restoran : " + nama);
        System.out.println("Lokasi        : " + lokasi);
        System.out.println("Tahun Berdiri : " + tahunBerdiri);
        System.out.println("===============================================");
        for(Kitchen k : listKitchen){
            System.out.println("\tNama Kitchen  : " + k.getNama());
            System.out.println("\tJenis Kitchen : " + k.getJenis());
            System.out.println("\tJumlah Staff  : " + k.getJumlahStaff());
        }
    }
}
