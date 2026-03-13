package tgs2_d_13000;

public class AlatMonitoring extends AlatMedis
{
    protected int kapasitasBaterai;
    
    public AlatMonitoring(String nama, String merek, int tahunProduksi, double daya, int kapasitasBaterai)
    {
        super(nama, merek, tahunProduksi, daya);
        this.kapasitasBaterai = kapasitasBaterai;
    }

    public void tampilDataMonitoring(){
        System.out.println("Nama               : " + super.nama);
        System.out.println("Merek              : " + super.merek);
        System.out.println("Tahun              : " + super.tahunProduksi);
        System.out.println("Daya               : " + super.daya +  " watt");
        System.out.println("Kapasitas Baterai  : " + this.kapasitasBaterai + " mAh");
    }
    public void cekStatusBaterai(double persentaseBaterai){
        String status = "";
        if (persentaseBaterai > 80)
            status = "penuh";
        else if(persentaseBaterai >= 20)
            status = "cukup";
        else 
            status = "lemah";
        System.out.println("Baterai " + super.nama + " " + status + "("+persentaseBaterai+"%)");
    }
}
