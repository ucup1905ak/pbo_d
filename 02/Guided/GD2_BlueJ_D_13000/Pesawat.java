public class Pesawat extends Transportasi
{
	private double panjangSayap;
    public Pesawat(String nama, double berat, int kapasitas, double panjangSayap)
    {
	    super(nama, berat, kapasitas);
	    this.panjangSayap = panjangSayap;
    }
    public void tampilDataPesawat()
    {
	    System.out.println("Nama          : " + nama);
	    System.out.println("Berat         : " + " kg");
	    System.out.println("Kapasitas     : " + kapasitas + " orang");
	    System.out.println("Panjang Sayap : " + panjangSayap + " m");
    }	    
    public void cekPesawat(double jarakKm)
    {
	    double operasional = hitungOperasional(jarakKm) + (kapasitas * 500) + (panjangSayap * 200);
	    
	    System.out.println(this.nama + " memiliki operasional pesawat" + operasional);
	    
	    
	    
	    if(operasional <= 1500000)
		    System.out.println("ategori: Standar");
	    else
		    System.out.println("Katefori: Tinggi");
    }
}
