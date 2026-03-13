package tgs2_d_13000;
public class PulseOximeter extends AlatMonitoring{
    private boolean supportAlarm;
    public PulseOximeter(String nama, String merek, int tahunProduksi, double daya, int kapasitasBaterai, boolean supportAlarm){
        super(nama, merek, tahunProduksi, daya, kapasitasBaterai);
        this.supportAlarm = supportAlarm;
    }
    
    public void tampilDataPulseOximeter(){
        String alarm = (supportAlarm)?"Ya":"Tidak";
        super.tampilDataMonitoring();
        System.out.println("Support Alarm      : " + alarm);        
    }
    public void cekDukunganAlarm(){
        String msg = "";
        if(supportAlarm)
            msg = "mendukung alarm otomatis untuk peringatan kondisi abnormal";
        else
            msg = "tidak menukung alarm otomatis sehingga pemantauan perlu dilakukan secara manual";
        System.out.println(super.nama +" "+ msg);
    
    }
    
}
