package tgs2_d_13000;

public class AlatDiagnostik extends AlatMedis
{

    protected String tipeScanner;
    public AlatDiagnostik(String nama, String merek, int tahunProduksi, double daya, String tipeScanner)
    {
        super(nama, merek, tahunProduksi, daya);
        this.tipeScanner = tipeScanner;
    }

    public void tampilDataDiagnostik(){
        System.out.println("Nama               : " + super.nama);
        System.out.println("Merek              : " + super.merek);
        System.out.println("Tahun              : " + super.tahunProduksi);
        System.out.println("Daya               : " + super.daya +  " watt");
        System.out.println("Scanner            : " + this.tipeScanner);
    }
    public void hitungPerforma(){
        
        int tahunSaatIni = 2026;
        int usiaPerangkat = tahunSaatIni - super.tahunProduksi;
        String msg = "";
        if (usiaPerangkat < 2)
            msg = "optimal";
        else if (usiaPerangkat <= 7)
            msg = "menurun";
        else 
            msg = "sangat lambat";
            
        System.out.println("Performa "+ super.nama + " "
                            + msg + " (usia "+usiaPerangkat+" tahun)");
    } 
}
