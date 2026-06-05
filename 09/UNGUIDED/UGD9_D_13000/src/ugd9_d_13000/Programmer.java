/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd9_d_13000;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Farelino Alexander Kim - 240713000
 */
public class Programmer extends Developer implements IProgrammer{
    private String bahasaPemrograman;
    private String gamePopuler;

    public Programmer(String bahasaPemrograman, String gamePopuler, String nama, double gaji) {
        super(nama, gaji);
        this.bahasaPemrograman = bahasaPemrograman;
        this.gamePopuler = gamePopuler;
    }
    
    @Override
    public void tampilDeveloper() {
        System.out.println("============== [Data Programmer] ================");
        System.out.println("Nama                 :" + this.nama);
        System.out.println("Gaji                 :" + NumberFormat.getCurrencyInstance(Locale.UK).getCurrency().getSymbol(Locale.UK)+this.gaji);
        System.out.println("Bahasa Pemrograman   :" + this.bahasaPemrograman);
        System.out.println("Game Populer         :" + this.gamePopuler);
        System.out.println("==================================================");
    }

    @Override
    public void coding() {
        System.out.println(this.nama + " sedang mengkode game dengan bahasa pemrograman " + this.bahasaPemrograman);
    }

}
