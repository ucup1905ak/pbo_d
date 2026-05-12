/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd6_d_13000;

import tgs6_d_13000.Exceptions.InputSalahException;

/**
 *
 * @author farel
 */
public class Piala {
    private String namaTurnamen;
    private int tahunJuara;

    public Piala(String namaTurnamen, int tahunJuara) throws InputSalahException{
        if(namaTurnamen.contains("warkop")) throw  new InputSalahException("Piala tidak boleh dari turnamen warkop/amatir!");
        if(tahunJuara < 2017 || tahunJuara > 2026) throw  new InputSalahException("Tahun Juara tidak valid!");
        this.namaTurnamen = namaTurnamen;
        this.tahunJuara = tahunJuara;
    }

    public String getNamaTurnamen() {
        return namaTurnamen;
    }

    public int getTahunJuara() {
        return tahunJuara;
    }
    
    
}
