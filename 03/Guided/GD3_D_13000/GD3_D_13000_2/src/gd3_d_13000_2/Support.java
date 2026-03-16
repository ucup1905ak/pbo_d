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
public class Support extends Karakter implements ICekMode, IKalkulasiHealing {
    private double restoreHealth;

    public Support(String nama, double level, int jumlahNyawa, double restoreHealth) {
        super(nama, level, jumlahNyawa);
        this.restoreHealth = restoreHealth;
    }

    @Override
    public void skill() {
        System.out.println(nama + " mengaktifkan skill Mass Heal!");
        System.out.println("Healing: " + hitungHealing());
    }

    @Override
    public double hitungHealing() {
        double baseHeal = restoreHealth * level;
        double totalHeal = baseHeal * 1.2;
        return totalHeal;
    }

    @Override
    public void tampilDataKarakter() {
        System.out.println("=== Data Support ===");
        System.out.println("Nama        : " + nama);
        System.out.println("RestoreHeal : " + restoreHealth);
    }

    @Override
    public void cekMode() {
        System.out.println(nama + " mengaktifkan Mode Guardian! " +
                "Seluruh tim mendapat efek shield.");
    }
}