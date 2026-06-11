package gd10_d_13000;


import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author 240713000_Farelino Alexander Kim
 */
public class Perusahaan {

    private String namaPerusahaan;
    private float bonus = 0;
    private ArrayList<Observer> pegawai = new ArrayList<>();

    public Perusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public void registerObserver(Observer observe) {
        pegawai.add(observe);
    }

    public void removeObserver(Observer observe) {
        pegawai.remove(observe);
    }

    public void notifyObserver(float bonus) {
        for (Observer observe : pegawai) {
            observe.update(bonus);
        }
    }

    public void tambahBonus(float bonus) {
        this.bonus = bonus;
        notifyObserver(bonus);
    }
}
