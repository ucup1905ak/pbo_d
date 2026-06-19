/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd11_d_13000;

/**
 *
 * @author Farelino Alexander Kim 240713000
 */
public class Prajurit extends PersonilMiliter {

    private String divisi;

    public Prajurit(String divisi, String nama, double gaji, MarkasBesar mb) {
        super(nama, gaji, mb);
        this.divisi = divisi;
    }
    //implementasi show data untuk komposit
    @Override
    public void showData() {
        System.out.printf("[Prajurit] " + nama + " >> Total gaji Prajurit : %,.0f\n", gaji);

    }
   /*
    *   Disinilan baigan observer : update(). 
    Method ini adalah implementasi dari abstract method di super class.
    Konsep observer terletak pada perjanjian method update yang dapat dipanggil oleh object lain.
    */
    @Override
    public void update(double bonus) {
        double temp;
        if (divisi.equalsIgnoreCase("infanteri")) {
            temp = (bonus * 0.2) + 350000;
        } else {
            temp = (bonus * 0.2) + 300000;
        }
        gaji += temp;
        System.out.printf("   ===>   Nominal gaji %s bertambah : %,.0f\n", nama, temp );
    }

}
