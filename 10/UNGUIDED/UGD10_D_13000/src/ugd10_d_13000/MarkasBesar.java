/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd10_d_13000;

import java.util.ArrayList;

/**
 *
 * @author komputasi9
 */
public class MarkasBesar {

    private String namaMarkas;
    private int tahunBerdiri;

    //Array untuk menyimpan semua observer
    private ArrayList<PersonilMiliter> personilMiliter = new ArrayList<>();

    public MarkasBesar(String namaMarkas, int tahunBerdiri, double kas) {
        this.namaMarkas = namaMarkas;
        this.tahunBerdiri = tahunBerdiri;
        this.kas = kas;
    }

    private Komandan komandan;
    private double kas;

    public void TampilStrukturKomando() {
        System.out.println("Nama Markas      : " + namaMarkas);
        System.out.println("Tahun Berdiri    : " + tahunBerdiri);
        System.out.printf("Total Kas Markas : %,.0f \n", kas);
        //disini show data tidak pakai perulangan, lebih mirip rekursif
        komandan.showData();
        showTotalGaji();
    }

    //menambahkan observer
    public void registerPersonil(PersonilMiliter pm) {
        personilMiliter.add(pm);
    }

    public void removePersonil(PersonilMiliter pm) {
        personilMiliter.remove(pm);
    }

    //implementasi method UpdateBonus untuk mengupdate semua personil terdaftar
    public void updateBonus(double bonus) {
        for (PersonilMiliter pm : personilMiliter) {
            pm.update(bonus);
        }
    }

    public void setKomandanUtama(Komandan k) throws PangkatException {
        if (k.getPangkat() <= 5) {
            throw new PangkatException("Komandan Utama Harus memiliki pangkat lebih dari 5!");
        }
        this.komandan = k;
        //Observer : register komandan sebagai salah satu subscriber
        registerPersonil(k);
    }

    public void terimaAnggaranOperasional(double bonus) {
        kas += bonus * 0.2;
        System.out.println("Kas Markas Bertambah : " + bonus * 0.2);
        //update semua terdaftar ketika menerima anggaran total
        updateBonus(bonus * 0.8);
    }

    public void showTotalGaji() {
        double totalGaji = 0;
        for (PersonilMiliter pm : personilMiliter) {
            totalGaji += pm.getGaji();
        }
        //ini untuk hitung total gaji aja dari list observer karena kebetulan 
        //strukturnya kompatible
        System.out.printf("Total Nilai gaji Keseluruhan : %,.0f\n\n", totalGaji);
    }
}
