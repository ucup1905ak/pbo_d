package gd11_d_13000;

/**
 *
 * @author Farelino Alexander Kim
 * 240713000
 * D
 */
public class BangunDatarFactory {
    public IBangunDatar createBangunDatar(double parameter1, double parameter2, String jenis) {
        if (jenis.equals("Persegi Panjang")) {
            return new PersegiPanjang(parameter1, parameter2);
        } else if (jenis.equals("Segitiga")) {
            return new Segitiga(parameter1, parameter2);
        } else {
            return new BelahKetupat(parameter1, parameter2);
        }
    }
}
