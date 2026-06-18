/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gd11_d_13000;

/**
 *
 * @author Farelino Alexander Kim
 * 240713000
 * D
 */
public class GD11_D_13000 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BangunDatarFactory b = new BangunDatarFactory();

        IBangunDatar b1 = b.createBangunDatar(10.0, 5.0, "Persegi Panjang");
        IBangunDatar b2 = b.createBangunDatar(5.0, 3.0, "Segitiga");
        IBangunDatar b3 = b.createBangunDatar(4.0, 7.0, "Belah Ketupat");

        b1.tampilLuas();
        b2.tampilLuas();
        b3.tampilLuas();
    }
    
}
