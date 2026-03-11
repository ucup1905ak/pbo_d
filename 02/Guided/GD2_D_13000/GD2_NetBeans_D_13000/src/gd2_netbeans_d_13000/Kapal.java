
package gd2_netbeans_d_13000;
public class Kapal extends Transportasi
{
    private double kapasitasMuatan;
    public Kapal(String nama, double berat, int kapasitas,int kapasitasMuatan)
    {
	    super(nama, berat, kapasitas);
	    this.kapasitasMuatan = kapasitasMuatan;
    }
    public void tampilDataKapal()
    {

	    System.out.println("Nama : "+  nama);
	    System.out.println("Berat : " + berat + " Kg");
	    System.out.println("Kapasitas : " + kapasitas +" orang");
	    System.out.println("Kapasitas Muatan : "+  kapasitasMuatan + " kg");
    }

    public void cekKapal(double jarakKm)
    {
	    double operasional = 
		    hitungOperasional(jarakKm)
		    + (kapasitasMuatan * 500);
	    System.out.println(this.nama + 
			    " memiliki operasional kapal: " 
			    + operasional);
	    if(operasional < 500000)
		    System.out.println("Kategori: Stabil");
	    else
		    System.out.println("Kategori: Berat");
    }

}
