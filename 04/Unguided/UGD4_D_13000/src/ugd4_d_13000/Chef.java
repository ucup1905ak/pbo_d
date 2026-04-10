
package ugd4_d_13000;


public class Chef {
    private String nama, spesialis;
    private int pengalaman;

    public Chef(String nama, String spesialis, int pengalaman) {
        this.nama = nama;
        this.spesialis = spesialis;
        this.pengalaman = pengalaman;
    }
    
    public String getNama(){return nama;}
    public String getSpesialisasi(){return spesialis;}
    public int getPengalaman(){return pengalaman;}
}
