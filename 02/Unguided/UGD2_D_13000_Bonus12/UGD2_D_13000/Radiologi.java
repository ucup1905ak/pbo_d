

public class Radiologi extends AlatDiagnostik
{
    private String jenisStorage;
    public Radiologi(String nama, String merek, int tahunProduksi, double daya, String tipeScanner, String jenisStorage)
    {
        super(nama, merek, tahunProduksi, daya, tipeScanner);
        this.jenisStorage = jenisStorage;
    }
    
    public void tampilDataRadiologi(){
        System.out.println("Nama               : " + super.nama);
        System.out.println("Merek              : " + super.merek);
        System.out.println("Tahun              : " + super.tahunProduksi);
        System.out.println("Daya               : " + super.daya +  " watt");
        System.out.println("Scanner            : " + super.tipeScanner);
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
