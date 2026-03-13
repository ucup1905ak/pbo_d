
public class AlatDiagnostik extends AlatMedis
{

    protected String tipeScanner;
    public AlatDiagnostik(String nama, String merek, int tahunProduksi, double daya, String tipeScanner)
    {
        super(nama, merek, tahunProduksi, daya);
        this.tipeScanner = tipeScanner;
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
