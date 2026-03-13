
public class MonitorJantung extends AlatMonitoring
{
    private double akurasi;
    public MonitorJantung(String nama, String merek, int tahunProduksi, double daya, int kapasitasBaterai, double akurasi)
    {
        super(nama, merek, tahunProduksi, daya, kapasitasBaterai);
        this.akurasi = akurasi;
    }
    
    public void tampilDataMonitorJantung(){
        System.out.println("Nama               : " + super.nama);
        System.out.println("Merek              : " + super.merek);
        System.out.println("Tahun              : " + super.tahunProduksi);
        System.out.println("Daya               : " + super.daya +  " watt");
        System.out.println("Kapasitas Baterai  : " + super.kapasitasBaterai + " mAh");
        System.out.println("Akurasi Sensor     : " + this.akurasi + "%");        
    }
    public void cekAkurasiSensor(){
        String msg = "";
        if (akurasi > 95)
            msg = "memenuhi standar pemantauan kritis (ICU)";
        else if (akurasi >= 86)
            msg = "digunakan untuk pemantauan klinis umum";
        else
            msg = "memerlukan kalibrasi sebelum digunakan";
            
        System.out.println("Sensor "+super.nama + " " + msg);
        
    }


}
