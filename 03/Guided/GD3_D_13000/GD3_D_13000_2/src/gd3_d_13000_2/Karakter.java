/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gd3_d_13000_2;

/**
 * NPM : 240713000
 * NAMA : Farelino Alexander Kim
 * 
 */
public abstract class Karakter {
    protected String nama;
    protected double level;
    protected int jumlahNyawa;

    public Karakter(String nama, double level, int jumlahNyawa) {
        this.nama = nama;
        this.level = level;
        this.jumlahNyawa = jumlahNyawa;
    }

    public void infoDetail() {
        System.out.println("=== Info Detail Karakter ===");
        System.out.println("Nama         : " + nama);
        System.out.println("Level        : " + level);
        System.out.println("Jumlah Nyawa : " + jumlahNyawa);
    }

    public abstract void tampilDataKarakter();
    public abstract void skill();
}