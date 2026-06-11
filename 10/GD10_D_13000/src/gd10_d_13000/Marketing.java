package gd10_d_13000;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 240713000_Farelino Alexander Kim
 */
public class Marketing extends Observer{
    private  float komisiPenjualan;

    public Marketing(float komisiPenjualan, Perusahaan model, String namaPegawai, float gaji) {
        super(model, namaPegawai, gaji);
        this.komisiPenjualan = komisiPenjualan;
    }

    @Override
    public void update(float bonus) {
        float tempGaji = gaji;
        gaji += bonus + (komisiPenjualan * 1);
        System.out.println(namaPegawai + " -> Gaji Sebelum : " + tempGaji + " -> Gaji Sesudah : " +gaji);
    }
}
