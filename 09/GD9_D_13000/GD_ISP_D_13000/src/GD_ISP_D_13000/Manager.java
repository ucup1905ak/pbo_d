/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GD_ISP_D_13000;

/**
 *
 * @author farel
 */
public class Manager implements IManager {

    private String nama;
    private String divisi;
    private double gaji;

    public Manager(String nama, String divisi, double gaji) {
        this.nama = nama;
        this.divisi = divisi;
        this.gaji = gaji;
    }

    @Override
    public void negosiasiSponsor() {
        System.out.println("Manager " + nama + " dari divisi " + divisi + " bernegosiasi dengan Sponsor!");
    }



    public void tampilManager() {
        System.out.println("[" + nama + "]"
                + "\nDivisi: " + divisi
                + "\nGaji : Rp. " + gaji);

        negosiasiSponsor();
        System.out.println("\n");
    }
}
