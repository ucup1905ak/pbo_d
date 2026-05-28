/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GD_OLD_D_13000;

public class Player extends AnggotaTeam implements IPlayer {

    private int pengalaman;

    public Player(int pengalaman, String nama, double gaji) {
        super(nama, gaji);
        this.pengalaman = pengalaman;
    }

    @Override
    public void mainTournament() {
        System.out.println("Pemain bernama " + nama + " dengan pengalaman " + pengalaman + " tahun bermain dalam Tournament!");
    }

    @Override
    public void tampilAnggotaTeam() {
        System.out.println("[" + nama + "]"
                + "\nPengalaman : " + pengalaman + " tahun"
                + "\nGaji       : Rp. " + gaji);
        mainTournament();
        System.out.println("\n");
    }

}
