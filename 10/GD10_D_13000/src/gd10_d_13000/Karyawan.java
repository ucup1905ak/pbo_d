/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gd10_d_13000;

/**
 *
 * @author 240713000_Farelino Alexander Kim
 */
public class Karyawan implements IComposite{
    private String namaKaryawan;
    private String jabatan;

    public Karyawan(String namaKaryawan, String jabatan) {
        this.namaKaryawan = namaKaryawan;
        this.jabatan = jabatan;
    }

    @Override
    public void showData() {
        System.out.println(namaKaryawan + " (" + jabatan+")");
    }
    
    
}
