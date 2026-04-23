/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tgs5_d_13000;

public abstract class Mobil {
    protected String namaMobil, merek;
    protected double hargaSewa;
    protected boolean tersedia;

    public Mobil(String namaMobil, String merek, double hargaSewa, boolean tersedia) {
        this.namaMobil = namaMobil;
        this.merek = merek;
        this.hargaSewa = hargaSewa;
        this.tersedia = tersedia;
    }
    public abstract String infoMobil();
    public void updateStatus(){
        System.out.println("\n===========================================");
        System.out.println("\t [!] Status diupdate untuk Mobil Sport " + namaMobil);
        this.tersedia = !this.tersedia;
        System.out.println(this);
        System.out.println("===========================================\n");
    }
}

// NPM : 240713000 - FARELINO ALEXANDER KIM