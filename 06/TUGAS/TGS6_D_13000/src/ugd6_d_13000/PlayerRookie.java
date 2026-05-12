/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd6_d_13000;

import tgs6_d_13000.Exceptions.InputSalahException;

/**
 *
 * @author farel
 */
public class PlayerRookie extends Player{
    private int umur;

    public PlayerRookie(String namaPlayer, String role, Double winRate, int umur) throws InputSalahException{
        super(namaPlayer, role, winRate);
        if(umur < 16) throw new InputSalahException("Umur belum cukup untuk masuk liga profesional!");
        this.umur = umur;
    }
    
    @Override
    public void display(){
        System.out.println("Nama Player   : " + namaPlayer);
        System.out.println("Status Player : Akademi" );
        System.out.println("Role          : " + role);
        System.out.println("Win Rate      : " + winRate);
        System.out.println("Daftar Skill  : " + deskripsiSkill);
        System.out.println("Umur Player   : " + umur);
    }

    @Override
    public double hitungHargaPasar() {
        return winRate * 150000;
    }
}
