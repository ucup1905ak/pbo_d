/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GD_SRP_D_13000;

/**
 *
 * @author farel
 */
public class AnggotaTeam implements IAnggotaTeam {

    private String nama;
    private String divisi;
    private int pengalaman;
    private double gaji;

    public AnggotaTeam(String nama, String divisi, double gaji) {
        this.nama = nama;
        this.divisi = divisi;
        this.gaji = gaji;
    }

    public AnggotaTeam(String nama, int pengalaman, double gaji) {
        this.nama = nama;
        this.pengalaman = pengalaman;
        this.gaji = gaji;
    }

    @Override
    public void negosiasiSponsor() {
        System.out.println("Manager " + nama + " dari divisi " + divisi + " bernegosiasi dengan Sponsor!");
    }

    @Override
    public void mainTournament() {
        System.out.println("Pemain bernama " + nama + " dengan pengalaman " + pengalaman + " tahun bermain dalam Tournament!");
    }

    public void tampilManager() {
        System.out.println("[" + nama + "]"
                + "\nDivisi: " + divisi
                + "\nGaji : Rp. " + gaji);
        negosiasiSponsor();
        System.out.println("\n");
    }

    public void tampilPlayer() {
        System.out.println("[" + nama + "]"
                + "\nPengalaman : " + pengalaman + " tahun"
                + "\nGaji : Rp. " + gaji);
        mainTournament();
        System.out.println("\n");
    }
}
