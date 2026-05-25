/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.*;

/**
 *
 * @author Farelino Alexander Kim - 240713000
 */
public class PembelianKendaraan {

    private int id_customer, //FK
            id_kasir,
            jumlah,
            no_resi;            // PRIMARY
    private String id_kendaraan, //FK
            id_paket_servis,
            tambahan,
            metode_pembayaran;
    private CustomerE customer;
    private KendaraanE kendaraan;
    private Kasir kasir;
    private PaketServisE paketServis;
    private LocalDate tanggal_transaksi;

    public Kasir getKasir() {
        return kasir;
    }

    public void setKasir(Kasir kasir) {
        this.kasir = kasir;
    }

    public LocalDate getTanggal_transaksi() {
        return tanggal_transaksi;
    }

    public void setTanggal_transaksi(LocalDate tanggal_transaksi) {
        this.tanggal_transaksi = tanggal_transaksi;
    }

    public PembelianKendaraan(int id_customer, int jumlah, int no_resi, String id_kendaraan, String tambahan, String metode_pembayaran, CustomerE customer, KendaraanE kendaraan, LocalDate tanggal_transaksi) {
        this.id_customer = id_customer;
        this.jumlah = jumlah;
        this.no_resi = no_resi;
        this.id_kendaraan = id_kendaraan;
        this.tambahan = tambahan;
        this.metode_pembayaran = metode_pembayaran;
        this.customer = customer;
        this.kendaraan = kendaraan;
        this.tanggal_transaksi = tanggal_transaksi;
    }

    public PembelianKendaraan(int id_customer, int jumlah, String id_kendaraan, String tambahan, String metode_pembayaran, CustomerE customer, KendaraanE kendaraan, LocalDate tanggal_transaksi) {
        this.id_customer = id_customer;
        this.jumlah = jumlah;
        this.id_kendaraan = id_kendaraan;
        this.tambahan = tambahan;
        this.metode_pembayaran = metode_pembayaran;
        this.customer = customer;
        this.kendaraan = kendaraan;
        
    }

    //tugas
    public PembelianKendaraan(
            int jumlah,
            String tambahan,
            String metode_pembayaran,
            CustomerE customer,
            KendaraanE kendaraan,
            KasirE kasir,
            PaketServisE paketServis,
            LocalDate tanggal_transaksi
            
    ) {
        this.id_customer = customer.getId_customer();
        this.id_kasir = kasir.getId_kasir();
        this.id_kendaraan = kendaraan.getId_kendaraan();
        this.id_paket_servis = paketServis.getId();
        this.jumlah = jumlah;
        this.tambahan = tambahan;
        this.metode_pembayaran = metode_pembayaran;
        this.customer = customer;
        this.kendaraan = kendaraan;
        this.kasir = kasir;
        this.paketServis = paketServis;
        this.tanggal_transaksi = tanggal_transaksi;
    }

    public PembelianKendaraan(
            int no_resi,
            int jumlah,
            String tambahan,
            String metode_pembayaran,
            CustomerE customer,
            KendaraanE kendaraan,
            KasirE kasir,
            PaketServisE paketServis,
            LocalDate tanggal_transaksi
    ) {
        this.id_customer = customer.getId_customer();
        this.id_kasir = kasir.getId_kasir();
        this.id_kendaraan = kendaraan.getId_kendaraan();
        this.id_paket_servis = paketServis.getId();
        this.jumlah = jumlah;
        this.no_resi = no_resi;
        this.tambahan = tambahan;
        this.metode_pembayaran = metode_pembayaran;
        this.customer = customer;
        this.kendaraan = kendaraan;
        this.kasir = kasir;
        this.paketServis = paketServis;
        this.tanggal_transaksi = tanggal_transaksi;
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

    public int getId_kasir() {
        return id_kasir;
    }

    public void setId_kasir(int id_kasir) {
        this.id_kasir = id_kasir;
    }

    public String getId_paket_servis() {
        return id_paket_servis;
    }

    public void setId_paket_servis(String id_paket_servis) {
        this.id_paket_servis = id_paket_servis;
    }

    public PaketServisE getPaket() {
        return paketServis;
    }

    public void setPaket(PaketServisE paketServis) {
        this.paketServis = paketServis;
    }

}
