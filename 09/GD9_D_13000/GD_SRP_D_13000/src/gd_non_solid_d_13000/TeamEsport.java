/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gd_non_solid_d_13000;

/**
 *
 * @author farel
 */
public class TeamEsport {

    private String namaTeamEsport;
    private int tahunBerdiri;
    private AnggotaTeam manager;
    private AnggotaTeam player;

    public TeamEsport(String namaTeamEsport, int tahunBerdiri) {
        this.namaTeamEsport = namaTeamEsport;
        this.tahunBerdiri = tahunBerdiri;
    }

    public void tampilTeamEsport() {
        System.out.println("[TEAM E-SPORT " + namaTeamEsport + "]");
        System.out.println("Berdiri pada tahun: " + tahunBerdiri);
        System.out.println("\t----> Anggota Team <----");
        System.out.println("============================================");
        manager.tampilManager();
        System.out.println("============================================");
        player.tampilPlayer();
    }

    public void setManager(AnggotaTeam manager) {
        this.manager = manager;
    }

    public void setPlayer(AnggotaTeam player) {
        this.player = player;
    }
}
