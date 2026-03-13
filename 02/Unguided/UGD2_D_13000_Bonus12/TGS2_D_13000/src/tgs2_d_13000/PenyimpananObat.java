/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tgs2_d_13000;

/**
 *
 * @author komputasi9
 */
public class PenyimpananObat extends AlatTerapi{
    private int jumlahPintu;
    public PenyimpananObat(String nama, String merek, int tahunProduksi, double daya,String areaPenggunaan, int jumlahPintu )
    {
        super(nama, merek, tahunProduksi, daya, areaPenggunaan);
        this.jumlahPintu = jumlahPintu;
    }
    
    public void tampilDataSimpanObat(){
        super.tampilDataTerapi();
        System.out.println("Jumlah Pintu       : " + this.jumlahPintu); 
    }
    public void cekKapasitasSimpan(){
        String msg = "";
        if(jumlahPintu > 1)
            msg = "memiliki kapasitas penyimpanan besar dan cocok untuk stok farmasi.";
        else if(jumlahPintu == 1)
            msg = "cocok untuk obat harian";
        else 
            msg = "hah?? gada pintu??";
        System.out.println("Kulkas Obat" + super.areaPenggunaan + " " + msg);
    }

}   