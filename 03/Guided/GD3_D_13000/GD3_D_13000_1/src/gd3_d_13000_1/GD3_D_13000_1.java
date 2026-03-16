/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gd3_d_13000_1;

/**
 * NPM : 240713000
 * NAMA : Farelino Alexander Kim
 * 
 */
public class GD3_D_13000_1 {
    public static void main(String[] args) {
        System.out.println("=== Constructor Overloading ===");
        Karakter k1 = new Karakter("Hero");
        Karakter k2 = new Karakter("Arthur", "Warrior");
        Karakter k3 = new Karakter("Merlin", "Mage", 10, 250);

        k1.info();
        k2.info();
        k3.info();

        System.out.println("\n=== Method Overloading ===");
        Mode m = new Mode("Legolas");

        m.aktifkan("Rage Mode");
        m.aktifkan("Rage Mode", 30);
        m.aktifkan("Rage Mode", 30, "ATK +50%");
    }
    
}
