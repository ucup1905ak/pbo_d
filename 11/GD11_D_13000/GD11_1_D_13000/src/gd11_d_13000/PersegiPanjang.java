package gd11_d_13000;

/**
 *
 * @author Farelino Alexander Kim
 * 240713000
 * D
 */
public class PersegiPanjang implements IBangunDatar {
    private double panjang;
    private double lebar;

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public double hitungLuas() {
        return panjang * lebar;
    }

    @Override
    public void tampilLuas() {
        System.out.println("Luas Persegi Panjang = " + hitungLuas() + " cm^2");
    }
}
