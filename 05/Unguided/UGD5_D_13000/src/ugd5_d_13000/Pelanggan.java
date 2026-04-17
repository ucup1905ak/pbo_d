/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd5_d_13000;

/**
 *Farelino Alexander Kim
 * @author komputasi9
 */
public class Pelanggan {
    private String nama,nik, alamat;
    private int umur;
    
    private static Integer count;
    private int id;

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
    @Override
    public String toString(){
        String out = new String();
        out += "\n=== Pelanggan ===";
        out += "\nNama         : " + nama.toString();
        out += "\nNIK          : " + nik.toString();
        out += "\nUmur         : " + umur;
        out += "\nAlamat       : " + alamat.toString();
        out += status();
        return out;
        
    }
}