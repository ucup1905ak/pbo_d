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
public class Karakter {
    String nama;
    String kelas;
    int level;
    int hp;

    // Default Constructor
    public Karakter(String nama) {
        this.nama = nama;
        this.kelas = "Tanpa Kelas";
        this.level = 1;
        this.hp = 100;
    }

    // Constructor 1
    public Karakter(String nama, String kelas) {
        this.nama = nama;
        this.kelas = kelas;
        this.level = 1;
        this.hp = 100;
    }

    // Constructor 2
    public Karakter(String nama, String kelas, int level, int hp) {
        this.nama = nama;
        this.kelas = kelas;
        this.level = level;
        this.hp = hp;
    }

    public void info() {
        System.out.println("Nama: " + nama + " | Kelas: " + kelas + " | Level: " + level + " | HP: " + hp);
    }
}