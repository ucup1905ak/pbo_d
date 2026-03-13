

public class AlatMedis
{
    protected String nama;
    protected String merek;
    protected int tahunProduksi;
    protected double daya;
    
    public AlatMedis(String nama, String merek, int tahunProduksi, double daya)
    {
        this.nama = nama;
        this.merek = merek;
        this.tahunProduksi = tahunProduksi;
        this.daya = daya;
    }
    
    public void hitungBiayaOperasional(double jamPakaiHarian, double tarifListrik)
    {
            double biayaOperasional = (daya * jamPakaiHarian / 1000 ) * tarifListrik;
            System.out.println("Biaya operasional harian " +nama+" adalah Rp"+biayaOperasional);
    }
    
}
