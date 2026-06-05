package ugd9_d_13000;

/**
 *
 * @author Farelino Alexander Kim - 240713000
 */
import java.util.Locale;
import java.text.NumberFormat;

public class GameDesigner extends Developer implements IGameDesigner {

    private String toolsDesign;
    private double ratingKarakter;

    public GameDesigner(String toolsDesign, double ratingKarakter, String nama, double gaji) {
        super(nama, gaji);
        this.toolsDesign = toolsDesign;
        this.ratingKarakter = ratingKarakter;
    }

    @Override
    public void tampilDeveloper() {
        System.out.println("============== [Game Designer] ================");
        System.out.println("Nama                 :" + this.nama);
        System.out.println("Gaji                 :" + NumberFormat.getCurrencyInstance(Locale.UK).getCurrency().getSymbol(Locale.UK) + this.gaji);
        System.out.println("Tools Design         :" + this.toolsDesign);
        System.out.println("Rating Karakter      :" + this.ratingKarakter);
        System.out.println("==================================================");

    }

    @Override
    public void menciptakanKarakter() {
        System.out.println(this.nama + " menciptakan karakter dengan menggunakan tools " + toolsDesign);
    }

    @Override
    public void pengecekanRating() {
        char rating;
        double insentif;
        if (ratingKarakter >= 90) {
            rating = 'S';
            insentif = 259;
        } else if (ratingKarakter >= 80) {
            rating = 'A';
            insentif = 203;
        } else if (ratingKarakter >= 70) {
            rating = 'B';
            insentif = 148;
        } else if (ratingKarakter >= 60) {
            rating = 'C';
            insentif = 123;
        } else if (ratingKarakter >= 50) {
            rating = 'D';
            insentif = 78;
        } else {
            rating = 'E';
            insentif = 0;
        }
        gaji += insentif;
        System.out.println(this.nama + " mendapatkan insentif sebesar " + NumberFormat.getCurrencyInstance(Locale.UK).getCurrency().getSymbol(Locale.UK)
                + +insentif + " karena memilii rating " + rating + " (" + ratingKarakter + "/100)");
    }
}
