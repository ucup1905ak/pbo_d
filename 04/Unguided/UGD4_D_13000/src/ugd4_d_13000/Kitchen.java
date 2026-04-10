/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd4_d_13000;

import java.util.ArrayList;

/**
 *
 * @author komputasi9
 */
public class Kitchen {

    private String nama, jenis;
    private int jumlahStaff;
    private ArrayList<TimChef> listTimChef = new ArrayList<>();

    public Kitchen(String nama, String jenis, int jumlahStaff) {
        this.nama = nama;
        this.jenis = jenis;
        this.jumlahStaff = jumlahStaff;
    }
    
    public void addTimChef(TimChef t){
        if(t == null) return;
        listTimChef.add(t);
    }
    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }

    public int getJumlahStaff() {
        return jumlahStaff;
    }
    
    
    
}
