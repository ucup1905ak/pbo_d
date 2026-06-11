package gd10_d_13000;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 240713000_Farelino Alexander Kim
 */
public abstract class Observer {
    protected Perusahaan model;
    protected String namaPegawai;
    protected float gaji;

    public Observer(Perusahaan model, String namaPegawai, float gaji) {
        this.model = model;
        this.namaPegawai = namaPegawai;
        this.gaji = gaji;
    }
    
    public abstract void update(float bonus);
}
