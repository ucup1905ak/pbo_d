

package tgs1_d_13000;

public class Kucing
{

    // Atribut (4)
    private String nama;
    private String jenis;
    private int tahunLahir;
    private double berat;
 
    private static int kenyang;
    
    public Kucing(){
        this.nama = "Tom";
        this.jenis = "Anggora";
        this.tahunLahir = 2020;
        this.berat = 1.5;
    
        this.kenyang = 0;
    }
    public Kucing(String nama, String jenis, int tahunLahir, double berat){
        this.nama = nama;
        this.jenis = jenis;
        this.tahunLahir = tahunLahir;
        this.berat = berat;
        
        this.kenyang = 0;
    }
    
    public String getNama(){return nama;}
    public String getJenis(){return jenis;}
    public int getTahunLahir(){return tahunLahir;}
    public double getBerat(){return berat;}
    
    public int getKenyang(){return kenyang;}
    
    public void setNama(String nama){this.nama = nama;}
    public void setJenis(String jenis){this.jenis = jenis;}
    public void setTahunLahir(int tahunLahir){this.tahunLahir = tahunLahir;}
    public void setBerat(double berat){this.berat = berat;}
    
    public void setKenyang(int kenyang){this.kenyang = kenyang;}
    
    public void makan(int jumlahKenyang){
        kenyang += jumlahKenyang;
    }
    
    public void kejar(){
        kenyang -= 3;
    }
    
}
