/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author farel
 */
public class Kasir {
    private int id_kasir;
    private String nama_kasir;
    private String shift;
    private int nomor_loket;

    public Kasir(int id_kasir, String nama_kasir, String shift, int nomor_loket) {
        this.id_kasir = id_kasir;
        this.nama_kasir = nama_kasir;
        this.shift = shift;
        this.nomor_loket = nomor_loket;
    }

    public Kasir(String nama_kasir, String shift, int nomor_loket) {
        this.nama_kasir = nama_kasir;
        this.shift = shift;
        this.nomor_loket = nomor_loket;
    }

    public int getId_kasir() {
        return id_kasir;
    }

    public void setId_kasir(int id_kasir) {
        this.id_kasir = id_kasir;
    }

    public String getNama_kasir() {
        return nama_kasir;
    }

    public void setNama_kasir(String nama_kasir) {
        this.nama_kasir = nama_kasir;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public int getNomor_loket() {
        return nomor_loket;
    }

    public void setNomor_loket(int nomor_loket) {
        this.nomor_loket = nomor_loket;
    }
    
    @Override
    public String toString(){
        return id_kasir + ",   "+ nama_kasir + " | " + shift + " | " + nomor_loket;
    }
}
    