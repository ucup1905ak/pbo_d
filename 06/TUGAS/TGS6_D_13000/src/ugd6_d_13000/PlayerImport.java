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
 * @author farel
 */
public class PlayerImport extends Player {

    private String negaraAsal;
    private double hargaTransfer;
    private ArrayList<Piala> listPiala = null;

    public PlayerImport(String namaPlayer, String role, Double winRate, String negaraAsal, double hargaTransfer)
            throws InputSalahException, KosongException {
        super(namaPlayer, role, winRate);
        
        if(negaraAsal.isEmpty() || negaraAsal.isBlank()) throw new KosongException();
        if(hargaTransfer < 0) throw new InputSalahException("harga transfer tidak boleh negatif");
        this.negaraAsal = negaraAsal;
        this.hargaTransfer = hargaTransfer;
        listPiala = new ArrayList<>();
    }

    public void addPiala(Piala p) {
        listPiala.add(p);
    }

    @Override
    public void display() {
        System.out.println("Nama Player   : " + namaPlayer);
        System.out.println("Status Player : Akademi" );
        System.out.println("Role          : " + role);
        System.out.println("Win Rate      : " + winRate);
        System.out.println("Daftar Skill  : " + deskripsiSkill);
        System.out.println("Negara Asal   : " + negaraAsal);
        System.out.println("Harga Buyout  : " + hargaTransfer);
        System.out.println("--- Riwayat Juara ----");
        for(Piala p : listPiala){
            System.out.printf("- %s (%d)\n",p.getNamaTurnamen(), p.getTahunJuara() );
        }
    }

    @Override
    public double hitungHargaPasar() {
        if(negaraAsal.equalsIgnoreCase("filipina")){
            hargaTransfer *= 1.5;
        }
        return hargaTransfer + (listPiala.size() * 1000000);
    }

}
