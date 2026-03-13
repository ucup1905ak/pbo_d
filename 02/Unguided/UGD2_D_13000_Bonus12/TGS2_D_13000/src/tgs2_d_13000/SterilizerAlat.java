
package tgs2_d_13000;


public class SterilizerAlat extends AlatTerapi{
    private double kapasitasSterilizer;
    public SterilizerAlat(String nama, String merek, int tahunProduksi, double daya,String areaPenggunaan, double kapasitasSterilizer)
    {
        super(nama, merek, tahunProduksi, daya, areaPenggunaan);
        this.kapasitasSterilizer = kapasitasSterilizer;
    }
    
    public void tampilDataSterilizer(){
        super.tampilDataTerapi();
        System.out.println("Kapasitas Sterilizer    : " + this.kapasitasSterilizer + " kg"); 
    }
    public void hitungWaktuSterilisasi(double bebanAlat){
        double waktu = bebanAlat / kapasitasSterilizer * 60;
        System.out.println( super.nama
                            + " memiliki estimasi waktu sterilisasi: "
                            + waktu+" menit, beban alat: "
                            +bebanAlat+ " kg");
    }
}
