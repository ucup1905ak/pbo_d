/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd6_d_13000;

import tgs6_d_13000.Exceptions.InputSalahException;
import tgs6_d_13000.Exceptions.KosongException;

/**
 *
 * @author farel
 */
public class PlayerPinjaman extends Player{
    private String timAsal;
    private int durasiPinjaman;

    public PlayerPinjaman(String namaPlayer, String role, Double winRate , String timAsal, int durasiPinjaman) throws InputSalahException, KosongException{
        super(namaPlayer, role, winRate);
        if(timAsal.isBlank() || timAsal.isEmpty()) throw new KosongException();
        if(durasiPinjaman <= 0 ) throw new InputSalahException("durasi pinjaman harus lebih dari 0 bulan!");
        this.timAsal = timAsal;
        this.durasiPinjaman = durasiPinjaman;
    }


    
    @Override
    public void display(){
        System.out.println("Nama Player   : " + namaPlayer);
        System.out.println("Status Player : Akademi" );
        System.out.println("Role          : " + role);
        System.out.println("Win Rate      : " + winRate);
        System.out.println("Daftar Skill  : " + deskripsiSkill);
        System.out.println("Durasi Pinjam : " + durasiPinjaman);
    }

    @Override
    public double hitungHargaPasar() {
        double ofset = 0;
        if(timAsal.equalsIgnoreCase("rrq")) ofset = -500000;
        if(timAsal.equalsIgnoreCase("dewa") ||timAsal.equalsIgnoreCase("liquid")) ofset = 500000;
        return winRate * 200000 + ofset;
    }
    
    
    
}
