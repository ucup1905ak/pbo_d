/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd5_d_13000;

/**
 * Farelino Alexander Kim
 * @author komputasi9
 */
public class Mobil {
    private String namaMobil, platNomor;
    private double hargaSewa;
    private boolean tersedia;

    public Mobil(String namaMobil, String platNomor, double hargaSewa, boolean tersedia) {
        this.namaMobil = namaMobil;
        this.platNomor = platNomor;
        this.hargaSewa = hargaSewa;
        this.tersedia = tersedia;
    }
    
    
    
    public String infoMobil(){
        if(tersedia)
        return "\n" + "Mobil dengan nama " + namaMobil
                + " sedang disewa";
        else
        return "\n" + "Mobil dengan nama " + namaMobil
                + " sedang tidak disewa";
        
    
    }
    @Override
    public String toString(){
        String out = new String();
        out += "\n=== Mobil ===";
        out += "\nNama          : " + namaMobil;
        out += "\nPlat Nomor    : " + platNomor;
        out += "\nHarga Sewa    : " + hargaSewa;
        out += "\nTersedia      : " + tersedia;
        out += infoMobil();
        return out;
    }
}
//new Mobil("Toyota Avanza", "BK 1234 AD", 350000, true)