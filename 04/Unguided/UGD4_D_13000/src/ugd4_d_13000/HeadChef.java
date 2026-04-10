package ugd4_d_13000;
public class HeadChef {
    private String nama, jabatan;

    public HeadChef(String nama, String jabatan) {
        this.nama = nama;
        this.jabatan = jabatan;
    }
    
    public void latihTimChef(TimChef t){
        if(t == null) return;
        if(cekKualitasTimChef(t)){
            System.out.println(t.getNamaTim() + " sudah baik, tidak perlu pelatihan");
            return;
        }
        if(t.isTraining()){
            System.out.println(t.getNamaTim() + " sudah pernah mendapatkan pelatihan");
            return;
        }
        t.setTraining(true);
            System.out.println(t.getNamaTim() + " sedang diberikan pelatihan");
    }
    public boolean cekKualitasTimChef(TimChef t){
        return t.getJumlahPesanan() >= 20;
    
    }
    public void showHeadChef(){
        System.out.println("============= DATA HEAD CHEF ============");
        System.out.println("Nama    : " + nama);
        System.out.println("Jabatan : " + jabatan);
        System.out.println("");
    }
}
