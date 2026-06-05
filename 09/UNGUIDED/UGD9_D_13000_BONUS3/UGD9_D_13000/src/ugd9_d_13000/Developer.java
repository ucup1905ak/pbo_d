/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd9_d_13000;

/**
 *
 * @author Farelino Alexander Kim - 240713000
 */
public abstract class Developer {

    protected String nama;
    protected double gaji;

    public Developer(String nama, double gaji) {
        this.nama = nama;
        this.gaji = gaji;
    }

    public abstract void tampilDeveloper();
}
