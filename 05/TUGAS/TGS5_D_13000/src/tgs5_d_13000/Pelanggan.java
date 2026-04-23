/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tgs5_d_13000;

public abstract class Pelanggan {
    protected String nama,nik, alamat;
    protected int umur;
    
    protected static Integer count;
    protected int id;

    public Pelanggan(String nama, String nik, int umur, String alamat) {
        this.nama = nama;
        this.nik = nik;
        this.alamat = alamat;
        this.umur = umur;
        if(count == null) count = new Integer(1);
        else count++;
        
        id = count;
    }
    
    
    
    
    public String status(){
        
        if(id %2 == 0)
        return "\n" + nama + " sering menyewa Mobil.";
        else
        return "\n" + nama + " jarang menyewa Mobil.";
    
    }


    
    public abstract void sewaMobil(Mobil m);
}


// NPM : 240713000 - FARELINO ALEXANDER KIM