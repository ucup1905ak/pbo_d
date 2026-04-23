/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tgs5_d_13000;

/**
 *
 * @author farel
 */
public class MobilSport extends Mobil{
    private int topSpeed;

    public MobilSport(String namaMobil, String merek, double hargaSewa, boolean tersedia, int topSpeed) {
        super(namaMobil, merek, hargaSewa, tersedia);
        this.topSpeed = topSpeed;
    }

    
    @Override
    public String infoMobil(){
        if(!tersedia) 
        return "\nMobil sport dengan nama " + namaMobil + " sedang tidak disewa.";
        else
        return "\nMobil sport dengan nama " + namaMobil + " sedang disewa.";
    }

    
    @Override
    public String toString(){
        return ("\n==== MOBIL SPORT =====" + 
        "\nNama Mobil      : " + namaMobil + 
        "\nMerek           : " + merek +
        "\nHarga Sewa      : Rp " + hargaSewa + 
        "\nStatus          : " + tersedia + 
        "\nTop Speed       : " + topSpeed + " km/h" +
         infoMobil());
        
    }
    
}
// NPM : 240713000 - FARELINO ALEXANDER KIM