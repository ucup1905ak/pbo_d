/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Exception.InputKosongException;

/*
* @author Farelino Alexander Kim - 240713000
 */
public abstract class PaketServis {

    private String id, nama, jenis;
    private int durasi;

    public PaketServis(String id, String nama, String jenis, int durasi) throws InputKosongException {
        if(id.isEmpty() || nama.isEmpty() || jenis.isEmpty() || durasi <= 0) throw new InputKosongException();
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.durasi = durasi;
    }

    public PaketServis(String nama, String jenis, int durasi) throws InputKosongException {
        this.nama = nama;
        this.jenis = jenis;
        this.durasi = durasi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    @Override
    public String toString() {
        return this.id + " | "
                + this.nama + " | "
                + this.jenis + " | "
                + this.durasi;
    }

    public abstract String getSpecial();
}
