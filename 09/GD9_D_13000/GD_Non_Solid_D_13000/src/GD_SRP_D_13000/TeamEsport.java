/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GD_SRP_D_13000;

/**
 *
 * @author farel
 */
public class TeamEsport {

    private String namaTeamEsport;
    private int tahunBerdiri;
    private Manager manager;
    private Player player;

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

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
