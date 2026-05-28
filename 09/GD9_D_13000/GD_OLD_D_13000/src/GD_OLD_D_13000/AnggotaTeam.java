/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GD_OLD_D_13000;

/**
 *
 * @author farel
 */
public abstract class AnggotaTeam {

    protected String nama;
    protected double gaji;

    public AnggotaTeam(String nama, double gaji) {
        this.nama = nama;
        this.gaji = gaji;
    }

    public abstract void tampilAnggotaTeam();
}
