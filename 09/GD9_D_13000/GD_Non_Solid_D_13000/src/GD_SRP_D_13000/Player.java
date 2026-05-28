/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GD_SRP_D_13000;

public class Player implements IAnggotaTeam {

    private String nama;
    private int pengalaman;
    private double gaji;

    public Player(String nama, int pengalaman, double gaji) {
        this.nama = nama;
        this.pengalaman = pengalaman;
        this.gaji = gaji;
    }

    @Override
    public void negosiasiSponsor() {
        // Tidak sesuai dengan kelas Player karena method kelas Manager
    }

    @Override
    public void mainTournament() {
        System.out.println("Pemain bernama " + nama + " dengan pengalaman "
                + pengalaman + " tahun bermain dalam Tournament!");
    }

    public void tampilPlayer() {
        System.out.println("[" + nama + "]"
                + "\nPengalaman : " + pengalaman + " tahun"
                + "\nGaji : Rp. " + gaji);

        mainTournament();
        System.out.println("\n");
    }
}
