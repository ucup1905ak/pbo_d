/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gd4_d_13000;

/**
 *
 * FARELINO ALEXANDER KIM - D - 240713000
 */
public class Order {

    private String nama;
    private int nomorMeja;

    public Order(String nama, int nomorMeja) {
        this.nama = nama;
        this.nomorMeja = nomorMeja;
    }
    
    public void showOrder(){
        System.out.println("Nama yang pesan  : " + nama);
        System.out.println("Nomor Meja       : " + nomorMeja);
    }
}
