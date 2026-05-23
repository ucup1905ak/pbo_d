/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Farelino Alexander Kim - 240713000
 */
public class PembelianKendaraan {
    private int id_customer, jumlah, no_resi;
    private String id_kendaraan, tambahan, metode_pembayaran;
    private CustomerE customer;
    private KendaraanE kendaraan;

    public PembelianKendaraan(int id_customer, int jumlah, int no_resi, String id_kendaraan, String tambahan, String metode_pembayaran, CustomerE customer, KendaraanE kendaraan) {
        this.id_customer = id_customer;
        this.jumlah = jumlah;
        this.no_resi = no_resi;
        this.id_kendaraan = id_kendaraan;
        this.tambahan = tambahan;
        this.metode_pembayaran = metode_pembayaran;
        this.customer = customer;
        this.kendaraan = kendaraan;
    }

    public PembelianKendaraan(int id_customer, int jumlah, String id_kendaraan, String tambahan, String metode_pembayaran, CustomerE customer, KendaraanE kendaraan) {
        this.id_customer = id_customer;
        this.jumlah = jumlah;
        this.id_kendaraan = id_kendaraan;
        this.tambahan = tambahan;
        this.metode_pembayaran = metode_pembayaran;
        this.customer = customer;
        this.kendaraan = kendaraan;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getNo_resi() {
        return no_resi;
    }

    public void setNo_resi(int no_resi) {
        this.no_resi = no_resi;
    }

    public String getId_kendaraan() {
        return id_kendaraan;
    }

    public void setId_kendaraan(String id_kendaraan) {
        this.id_kendaraan = id_kendaraan;
    }

    public String getTambahan() {
        return tambahan;
    }

    public void setTambahan(String tambahan) {
        this.tambahan = tambahan;
    }

    public String getMetode_pembayaran() {
        return metode_pembayaran;
    }

    public void setMetode_pembayaran(String metode_pembayaran) {
        this.metode_pembayaran = metode_pembayaran;
    }

    public CustomerE getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerE customer) {
        this.customer = customer;
    }

    public KendaraanE getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(KendaraanE kendaraan) {
        this.kendaraan = kendaraan;
    }

 
    
}
