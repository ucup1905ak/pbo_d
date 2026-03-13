package tgs2_d_13000;


public class Radiologi extends AlatDiagnostik
{
    private String jenisStorage;
    public Radiologi(String nama, String merek, int tahunProduksi, double daya, String tipeScanner, String jenisStorage)
    {
        super(nama, merek, tahunProduksi, daya, tipeScanner);
        this.jenisStorage = jenisStorage;
    }
    
    public void tampilDataRadiologi(){
        super.tampilDataDiagnostik();
        System.out.println("Jenis Storage      : " + this.jenisStorage);       
    }
    public void cekKecepatanPenyimpanan(){
        String msg = "";
        if(null == jenisStorage)
            msg = "tipe storage tidak dikenali";
        else switch (jenisStorage) {
            case "SSD":
                msg = "menggunakan SSD - Kecepatan data lebih cepat";
                break;
            case "HDD":
                msg = "menggunakan HDD = Kecepatan sedang dengan kapasitas penyimpanan besar";
                break;
            default:
                msg = "tipe storage tidak dikenali";
                break;
        }
            
        System.out.println("Radiology " + super.nama + " " + msg);
    }
}
