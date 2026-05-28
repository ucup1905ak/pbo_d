/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GD_OLD_D_13000;

/**
 *
 * @author farel
 */
public class Manager extends AnggotaTeam implements IManager {

    private String divisi;

    public Manager(String divisi, String nama, double gaji) {
        super(nama, gaji);
        this.divisi = divisi;
    }

    @Override
    public void negosiasiSponsor() {
        System.out.println("Manager " + nama + " dari divisi " + divisi + " bernegosiasi dengan Sponsor!");
    }

    @Override
    public void tampilAnggotaTeam() {
        System.out.println("[" + nama + "]"
                + "\nDivisi: " + divisi
                + "\nGaji   : Rp. " + gaji);
        negosiasiSponsor();
        System.out.println("\n");
    }
}
