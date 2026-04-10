
package ugd4_d_13000;


public class Evaluasi {
    private TimChef timChef;

    public Evaluasi(TimChef timChef) {
        this.timChef = timChef;
    }
    
    
    public double hitungSkor(){
         return ((double)timChef.getJumlahPesanan() / 
                 (double)timChef.getCount())
                 * 10;
    }
    public void showEvaluasi(){
        System.out.println("========== HASIL EVALUASI ===========");
        System.out.println("Nama Tim        : " + timChef.getNamaTim());
        System.out.println("Jumlah Pesanan  : " + timChef.getJumlahPesanan());
        System.out.println("Jumlah Chef     : " + timChef.getCount());
        System.out.printf("Skor            : %.2f\n", hitungSkor());
        if(hitungSkor() >= 50)
            System.out.println("Kesimpulan      : Sangat Baik" );
        else if(hitungSkor() >= 30)
            System.out.println("Kesimpulan      : Cukup" );
        else
            System.out.println("Kesimpulan      : Kurang " );
    }
}
