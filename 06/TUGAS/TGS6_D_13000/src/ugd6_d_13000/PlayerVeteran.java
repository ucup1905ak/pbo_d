/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd6_d_13000;

import java.util.ArrayList;
import tgs6_d_13000.Exceptions.InputSalahException;
import tgs6_d_13000.Exceptions.KosongException;

/**
 *
 * @author komputasi9
 */
public class PlayerVeteran extends Player {

    private String timSebelumnya;
    private int tahunDebut;
//PlayerVeteran(namaPlayer, role, winRate, tim, thn);

    public PlayerVeteran(String namaPlayer, String role, Double winRate, String timSebelumnya, int tahunDebut) throws KosongException, InputSalahException{
        super(namaPlayer, role, winRate);
        
        if(timSebelumnya.isBlank() || timSebelumnya.isEmpty()) throw new KosongException();
        ArrayList<String> teams = new ArrayList<>();
        teams.add("Onic");
        teams.add("Evos");
        teams.add("Btr");
        if(!teams.contains(timSebelumnya)) throw new InputSalahException("coach Hanya Mau Tim Besar! (Onic/Evos/Btr)");
        if(tahunDebut < 2017) throw new InputSalahException("Tahun debut tidak valid (Min 2017)");
        this.timSebelumnya = timSebelumnya;
        this.tahunDebut = tahunDebut;
    }
    @Override
    public void display() {
        
        System.out.println("Nama Player   : " + namaPlayer);
        System.out.println("Status Player : Veteran");
        System.out.println("Role          : " + role);
        System.out.println("Win Rate      : " + winRate);
        System.out.println("Daftar Skill  : " + deskripsiSkill);
        System.out.println("Tim Sebelumnya: " + timSebelumnya);
        System.out.println("Tahun Debut   : " + tahunDebut);
    }
    @Override
    public double hitungHargaPasar(){
        if(timSebelumnya.equalsIgnoreCase("Onic")) return winRate * 500000 + 10000000;
        return winRate * 500000;
    }
}
