/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author farel
 */
public class KasirE extends Kasir{

    public KasirE(int id_kasir, String nama_kasir, String shift, int nomor_loket) {
        super(id_kasir, nama_kasir, shift, nomor_loket);
    }

    public KasirE(String nama_kasir, String shift, int nomor_loket) {
        super(nama_kasir, shift, nomor_loket);
    }

    @Override
    public String toString() {
        return getNama_kasir();
    }
    
    
}
