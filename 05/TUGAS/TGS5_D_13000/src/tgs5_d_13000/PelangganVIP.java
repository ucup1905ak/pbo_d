package tgs5_d_13000;
public class PelangganVIP extends Pelanggan {
    private String bonusLayanan;

    public PelangganVIP(String nama, String nik, int umur, String alamat, String bonusLayanan) {
        super(nama, nik, umur, alamat);
        this.bonusLayanan = bonusLayanan;
    }


    
    @Override
    public String toString(){
        return ("\n==== Pelanggan VIP =====" + 
            "\nNama          : " + nama + 
            "\nNIK           : " + nik +
            "\nUmur          : Rp " + umur + 
            "\nAlamat        : " + alamat + 
            "\nBonus Layanan : " + bonusLayanan +
            "\nPelanggan " + nama + " adalah pelanggan VIP rental mobil." );

    }

    @Override
    public void sewaMobil(Mobil m){
        if(m.tersedia == true){
            System.out.println("Mobil sedang disewa, silahkan pilih mobil lain.");
        }else {
            m.updateStatus();
            System.out.println("Mobil " + m.namaMobil + " berhasil disewa. ");
        }
    }
    
    
}


// NPM : 240713000 - FARELINO ALEXANDER KIM