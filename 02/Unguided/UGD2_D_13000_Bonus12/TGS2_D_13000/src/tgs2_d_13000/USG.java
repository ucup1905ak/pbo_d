/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */                     
package tgs2_d_13000;

/**
 *
 * @author komputasi9
 */
public class USG extends  AlatDiagnostik{
    private double ukuranLayar;
    public USG(String nama, String merek, int tahunProduksi, double daya, String tipeScanner,double ukuranLayar)
    {
        super(nama, merek, tahunProduksi, daya, tipeScanner);
        this.ukuranLayar = ukuranLayar;
    }
    public void tampilDataUSG(){

        super.tampilDataDiagnostik();
        System.out.println("Ukuran Layar       : " + this.ukuranLayar + " inci"); 
    }
    public void cekDisplay(){
        
        String msg = "";
        if(ukuranLayar < 13)
            msg = "memiliki ukuran layar compact, cocok untuk mobilitas";
        else if(ukuranLayar <= 16)
            msg = "memiliki ukuran layar ideal untuk penggunaan harian";
        else 
            msg = "memiliki layar besar, cocok untuk analisis";
        System.out.println( super.nama + " "+msg);
    }
    
}
