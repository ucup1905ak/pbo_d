/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gd3_d_13000_1;

/**
 * NPM : 240713000
 * NAMA : Farelino Alexander Kim
 * 
 */
public class Mode {
    String nama;

    public Mode(String nama) {
        this.nama = nama;
    }

    public void aktifkan(String namaMode) {
        System.out.println(nama + " mengaktifkan mode: " + namaMode);
    }

    public void aktifkan(String namaMode, int durasi) {
        System.out.println(nama + " mengaktifkan mode: " + namaMode + " selama " + durasi + " detik");
    }

    public void aktifkan(String namaMode, int durasi, String efek) {
        System.out.println(nama + " mengaktifkan mode: " + namaMode + " selama " + durasi + " detik [Efek: " + efek + "]");
    }
}