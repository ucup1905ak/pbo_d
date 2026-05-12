/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd6_d_13000;

import java.util.ArrayList;
import tgs6_d_13000.Exceptions.InputSalahException;
import tgs6_d_13000.Exceptions.KosongException;

public class PlayerAkademi extends Player{
    private String tierRank; 

    public PlayerAkademi(String namaPlayer, String role, Double winRate, String tierRank) throws InputSalahException, KosongException {
        super(namaPlayer, role, winRate);
        if(tierRank.isBlank() || tierRank.isEmpty()) throw new KosongException();
        if(!tierRank.equalsIgnoreCase("Mythic")
           &&!tierRank.equalsIgnoreCase("Glory")
           &&!tierRank.equalsIgnoreCase("Immortal")
           ){
            throw new InputSalahException("Tier hanya boleh Mythic, Glory, atau Immortal!");
        }
        this.tierRank = tierRank;
    }

    
    @Override
    public void display(){
        System.out.println("Nama Player   : " + namaPlayer);
        System.out.println("Status Player : Akademi" );
        System.out.println("Role          : " + role);
        System.out.println("Win Rate      : " + winRate);
        System.out.println("Daftar Skill  : " + deskripsiSkill);
        System.out.println("Tier Rank     : " + tierRank);
    }
    @Override
    public double hitungHargaPasar(){
        if(tierRank.equalsIgnoreCase("Immortal")) return winRate * 100000 * 1.2;
        return winRate * 100000;
    }
}
