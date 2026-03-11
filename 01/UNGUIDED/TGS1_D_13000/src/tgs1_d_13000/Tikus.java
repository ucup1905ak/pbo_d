

package tgs1_d_13000;

public class Tikus
{

    // Atribut (4)
    private String nama;
    private String jenis;
    private int tahunLahir;
    private double berat;
 
    private static int lapar;
    
    public Tikus(){
        this.nama = "Jerry";
        this.jenis = "Got";
        this.tahunLahir = 2023;
        this.berat = 0.5;
        
        lapar = 0;
    }
    public Tikus(String nama, String jenis, int tahunLahir, double berat){
        this.nama = nama;
        this.jenis = jenis;
        this.tahunLahir = tahunLahir;
        this.berat = berat;
        
        lapar = 0;
    }
    
    public String getNama(){return nama;}
    public String getJenis(){return jenis;}
    public int getTahunLahir(){return tahunLahir;}
    public double getBerat(){return berat;}
    
    public int getLapar(){return lapar;}
    
    public void setNama(String nama){this.nama = nama;}
    public void setJenis(String jenis){this.jenis = jenis;}
    public void setTahunLahir(int tahunLahir){this.tahunLahir = tahunLahir;}
    public void setBerat(double berat){this.berat = berat;}
    
    public void setLapar(int lapar){this.lapar = lapar;}
    
    public void lari(){
        lapar += 4;
    }
    
    public void curiKeju(int jumlahKenyang) {
        lari();
        lapar -= jumlahKenyang;
        
    }
    
}
