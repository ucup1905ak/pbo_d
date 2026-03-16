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
public class Mage extends Karakter implements ICekMode {
    private double magicDamage;

    public Mage(String nama, double level, int jumlahNyawa, double magicDamage) {
        super(nama, level, jumlahNyawa);
        this.magicDamage = magicDamage;
    }

    @Override
    public void tampilDataKarakter() {
        System.out.println("=== Data Mage ===");
        System.out.println("Nama           : " + nama);
        System.out.println("Kekuatan Sihir : " + magicDamage);
    }

    @Override
    public void cekMode() {
        System.out.println(nama + " mengaktifkan Mode Mana Overload! SP x2");
    }

    @Override
    public void skill() {
        double totalDamage = magicDamage * level;
        System.out.println("Mage mengeluarkan serangan area 'Meteor Storm' yang " +
                "memberikan damage berdasarkan nilai " + totalDamage + ".");
    }
}