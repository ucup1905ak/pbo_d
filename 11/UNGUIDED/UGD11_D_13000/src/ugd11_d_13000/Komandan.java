/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd11_d_13000;

import java.util.ArrayList;

/**
 *
 * @author Farelino Alexander Kim 240713000
 */
public class Komandan extends PersonilMiliter {

    private int pangkat;
    private int jumlahPasukan;
    
    //Ini Komposit juga untuk merepresentasikan Struktur
    private ArrayList<PersonilMiliter> timKomando;

    public Komandan(int pangkat, String nama, double gaji, MarkasBesar mb) {
        super(nama, gaji, mb);
        this.pangkat = pangkat;
        jumlahPasukan = 0;
        timKomando = new ArrayList<>();
    }
    //implementasi show data untuk komposit
    @Override
    public void showData() {
        System.out.printf("[Komandan] " + nama + " >> Total gaji Komandan : %,.0f \n", gaji);
        String temp = indent;
            indent += "    ";
        for (PersonilMiliter pm : timKomando) {
            System.out.print(indent + "[Pasukan " + nama + "] ");
            pm.showData();
        }
        indent = temp;
    }

    /*
    *   Disinilan baigan observer : update(). 
    Method ini adalah implementasi dari abstract method di super class.
    Konsep observer terletak pada perjanjian method update yang dapat dipanggil oleh object lain.
    */
    @Override
    public void update(double bonus) {
        double temp;
        if (pangkat > 5) {
            temp = (bonus * jumlahPasukan / 10) + 1200000;
        } else {
            temp = (bonus * jumlahPasukan / 10) + 900000;
        }
        gaji += temp;
        System.out.printf("   ===>   Nominal gaji %s bertambah : %,.0f\n", nama, temp );
    }

    //disini menambahkan leaf/child
    public void rekrutPasukan(PersonilMiliter pm) {
        timKomando.add(pm);
        jumlahPasukan = timKomando.size();
        
        //INI PENTING UNTUK OBSERVER!!!
        mb.registerPersonil(pm);
        //dia nambahkan dirinya sendri sebagai 'penonton'
    }

    public int getPangkat() {
        return pangkat;
    }
}
