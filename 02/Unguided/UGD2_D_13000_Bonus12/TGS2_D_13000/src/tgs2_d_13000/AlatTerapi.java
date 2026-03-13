/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tgs2_d_13000;

/**
 *
 * @author komputasi9
 */
public class AlatTerapi extends AlatMedis{
    protected String areaPenggunaan;
    public AlatTerapi(String nama, String merek, int tahunProduksi, double daya,String areaPenggunaan ){
        super(nama, merek,tahunProduksi,daya);
        this.areaPenggunaan = areaPenggunaan;
    }
    
    public void tampilDataTerapi(){
        System.out.println("Nama               : " + super.nama);
        System.out.println("Merek              : " + super.merek);
        System.out.println("Tahun              : " + super.tahunProduksi);
        System.out.println("Daya               : " + super.daya +  " watt");
        System.out.println("Area Penggunaan    : " + this.areaPenggunaan);
    }
    
    public void hitungEfisiensiEnergiRuangan(double luasRuangan){
        String msg = "";
        double eff = super.daya / luasRuangan;
        if (eff < 10)
            msg = "sangat efisien untuk ruangan ";
        else if(eff <= 20)
            msg = "cukup efisien untuk ruangan ";
        else msg = "kurang efisien untuk ruangan ";
        System.out.println(super.nama + " " + msg + areaPenggunaan);
    }
}
