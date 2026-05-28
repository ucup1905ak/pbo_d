/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GD_OLD_D_13000;

import java.util.ArrayList;

/**
 *
 * @author farel
 */
public class TeamEsport {

    private String namaTeamEsport;
    private int tahunBerdiri;
    ArrayList<AnggotaTeam> listAnggotaTeam = new ArrayList<>();

    public TeamEsport(String namaTeamEsport, int tahunBerdiri) {
        this.namaTeamEsport = namaTeamEsport;
        this.tahunBerdiri = tahunBerdiri;
    }

    public void tampilTeamEsport() {
        System.out.println("[TEAM E-SPORT " + namaTeamEsport + "]");
        System.out.println("Berdiri pada tahun: " + tahunBerdiri);
        System.out.println("\t----> Anggota Team <----");
        System.out.println("==============================================");
        for (AnggotaTeam at : listAnggotaTeam) {
            at.tampilAnggotaTeam();
            System.out.println("==============================================");
        }
    }

    public void setAnggotaTeam(AnggotaTeam anggotaTeam) {
        listAnggotaTeam.add(anggotaTeam);
    }
}
