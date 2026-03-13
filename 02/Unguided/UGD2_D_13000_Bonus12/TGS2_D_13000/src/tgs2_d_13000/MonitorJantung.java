package tgs2_d_13000;

public class MonitorJantung extends AlatMonitoring
{
    private double akurasi;
    public MonitorJantung(String nama, String merek, int tahunProduksi, double daya, int kapasitasBaterai, double akurasi)
    {
        super(nama, merek, tahunProduksi, daya, kapasitasBaterai);
        this.akurasi = akurasi;
    }
    
    public void tampilDataMonitorJantung(){
        super.tampilDataMonitoring();
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
