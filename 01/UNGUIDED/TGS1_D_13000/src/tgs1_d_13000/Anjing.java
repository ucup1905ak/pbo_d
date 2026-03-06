

package tgs1_d_13000;

public class Anjing
{

    // Atribut (4)
    private String nama;
    private String jenis;
    private int tahunLahir;
    private double berat;
 
    private static int amarah;
    
    public Anjing(){
        this.nama = "Spike";
        this.jenis = "Bull-Dawg";
        this.tahunLahir = 2019;
        this.berat = 5.5;
    
        this.amarah = 0;
    }
    public Anjing(String nama, String jenis, int tahunLahir, double berat){
        this.nama = nama;
        this.jenis = jenis;
        this.tahunLahir = tahunLahir;
        this.berat = berat;
        
        this.amarah = 0;
    }
    
    public String getNama(){return nama;}
    public String getJenis(){return jenis;}
    public int getTahunLahir(){return tahunLahir;}
    public double getBerat(){return berat;}
    
    public int getAmarah(){return amarah;}
    
    public void setNama(String nama){this.nama = nama;}
    public void setJenis(String jenis){this.jenis = jenis;}
    public void setTahunLahir(int tahunLahir){this.tahunLahir = tahunLahir;}
    public void setBerat(double berat){this.berat = berat;}
    
    public void setAmarah(int amarah){this.amarah = amarah;}
    

    public void marah(){
        amarah += 100;
    }
    
    public void kejar() {
        amarah -= 15;
    }
}
