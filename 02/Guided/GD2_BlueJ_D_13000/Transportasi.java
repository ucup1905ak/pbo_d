public class Transportasi
{
    protected String nama;
    protected double berat;
    protected int kapasitas;

    public Transportasi(String nama, double berat, int kapasitas)
    {
        this.nama = nama;
        this.berat = berat;
        this.kapasitas = kapasitas;
    }
    public void beroperasi ()
    
    {
        System.out.println("Laporan [5 digit NPM praktikan], " + this.nama + " sedang beroperasi.");
    }

    public double hitungOperasional(double jarakKm)
    {
        return this.berat * jarakKm;
    }

}

