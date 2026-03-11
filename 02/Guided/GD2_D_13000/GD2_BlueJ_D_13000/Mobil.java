public class Mobil extends Transportasi
{
  private int jumlahPintu;
	Mobil(String nama,double berat,int kapasitas, int jumlahPintu){
    super(nama,berat,kapasitas);
    this.jumlahPintu = jumlahPintu;
	}
  public void tampilDataMobil()
  {
    System.out.println("Nama        :" + nama);
    System.out.println("Berat       : " + berat + " kg");
    System.out.println("Kapasistas  :" + kapasitas + " orang");
    System.out.println("Jumlah Pintu:" + jumlahPintu + " pintu");
  }
  public void cekMobil(double jarakKm)
  {
    double bobot = hitungOperasional(jarakKm) / 1000;
    System.out.println(this.nama + " memiliki bobot mobil: " + bobot);

    if(bobot < 5000)
      System.out.println("Kategori : Mobil Ringan");
    else
      System.out.println("Kategori : Mobil Berat");
  }
}

