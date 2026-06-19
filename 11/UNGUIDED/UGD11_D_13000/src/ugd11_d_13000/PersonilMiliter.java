/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd11_d_13000;

/**
 *
 * @author Farelino Alexander Kim 240713000
 */

//dibuat abstract sebagai 'perjanjian' untuk konsep komposit
public abstract class PersonilMiliter {
    protected static String indent = ""; //ini untuk indentasi
    
    protected String nama;
    protected double gaji;
    protected MarkasBesar mb;

    public PersonilMiliter(String nama, double gaji, MarkasBesar mb) {
        this.nama = nama;
        this.gaji = gaji;
        this.mb = mb;
    }
    
    //ini adalah bagian composite, bagian ini memastikan semua object dalam struktur memiliki method pasti yang dapat dipanggil.
    public abstract void showData();
    
    //Observer : Nantinya diimplimentasikan di subclass
    //adanya update(), memungkinkan object lain untuk merubah data dalam Personil Militer.
    public abstract void update(double bonus);
    
    public double getGaji(){
        return gaji;
    }
    public String getNama(){
        return nama;
    }
    
}
