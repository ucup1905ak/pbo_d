package gd11_d_13000;

/**
 *
 * @author Farelino Alexander Kim
 * 240713000
 * D
 */
public class Segitiga implements IBangunDatar {
    private double alas;
    private double tinggi;

    public Segitiga(double alas, double tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungLuas() {
        return alas * tinggi / 2;
    }

    @Override
    public void tampilLuas() {
        System.out.println("Luas Segitiga = " + hitungLuas() + " cm^2");
    }
}
