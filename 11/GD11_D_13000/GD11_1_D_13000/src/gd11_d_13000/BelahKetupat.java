package gd11_d_13000;

/**
 *
 * @author Farelino Alexander Kim
 * 240713000
 * D
 */
public class BelahKetupat implements IBangunDatar {
    private double diagonal1;
    private double diagonal2;

    public BelahKetupat(double diagonal1, double diagonal2) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
    }

    @Override
    public double hitungLuas() {
        return diagonal1 * diagonal2 / 2;
    }

    @Override
    public void tampilLuas() {
        System.out.println("Luas Belah Ketupat = " + hitungLuas() + " cm^2");
    }
}
