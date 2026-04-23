package tgs5_d_13000;
public class MobilKeluarga extends Mobil{
    private int kapasitas;

    public MobilKeluarga( String namaMobil, String platNomor, double hargaSewa, boolean tersedia, int kapasitas) {
        super(namaMobil, platNomor, hargaSewa, tersedia);
        this.kapasitas = kapasitas;
    }





    @Override
    public String infoMobil(){
        if(!tersedia) 
        return "\nMobil keluarga dengan nama " + namaMobil + " sedang tidak disewa.";
        else
        return "\nMobil keluarga dengan nama " + namaMobil + " sedang disewa.";   
    }


    
    @Override
    public String toString(){
        return ("\n==== MOBIL KELUARGA =====" + 
                "\nNama Mobil      : " + namaMobil + 
                "\nMerek           : " + merek +
                "\nHarga Sewa      : Rp " + hargaSewa + 
                "\nStatus          : " + tersedia + 
                "\nKapasitas       : " + kapasitas + " orang"
                + infoMobil());
        
    }
}


// NPM : 240713000 - FARELINO ALEXANDER KIM