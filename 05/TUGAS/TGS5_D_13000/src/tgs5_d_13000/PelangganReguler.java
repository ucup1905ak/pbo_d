/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tgs5_d_13000;

/**
 *
 * @author farel
 */
public class PelangganReguler extends Pelanggan{
    private String durasiSewa;

    public PelangganReguler(String nama, String nik, int umur,String alamat, String durasiSewa) {
        super(nama, nik, umur, alamat);
        this.durasiSewa = durasiSewa;
    }

    @Override
    public String toString(){
            return ("\n==== Pelanggan Reguler =====" + 
                    "\nNama          : " + nama + 
                    "\nNIK           : " + nik +
                    "\nUmur          : Rp " + umur + 
                    "\nAlamat        : " + alamat + 
                    "\nDurasi Sewa   : " + durasiSewa + 
                    "\nPelanggan " + nama + " adalah pelanggan reguler rental mobil." );
    }
    @Override
    public void sewaMobil(Mobil m){
        if(m.hargaSewa > 10000000){
            System.out.println("Mobil terlalu mahal, silahkan menjadi pelanggan VIP.");
        } else {
            if(m.tersedia == true){
                System.out.println("Mobil sedang disewa, silahkan pilih mobil lain.");
            }else {
                m.updateStatus();
                System.out.println("Mobil " + m.namaMobil + " berhasil disewa. ");
            }       
        }
    
    }
    
}


// NPM : 240713000 - FARELINO ALEXANDER KIM