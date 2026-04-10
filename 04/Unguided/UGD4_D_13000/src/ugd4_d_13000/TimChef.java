
package ugd4_d_13000;


public class TimChef {
    private String namaTim, shift;
    private int jumlahMenu;
    private int jumlahPesanan;
    private int count;
    private Chef listChef[] = new Chef[6];
    
    //BONUS
    private boolean training = false;

    public TimChef(String namaTim, String shift, int jumlahMenu, int jumlahPesanan) {
        this.namaTim = namaTim;
        this.shift = shift;
        this.jumlahMenu = jumlahMenu;
        this.jumlahPesanan = jumlahPesanan;
    }
    
    public void addChef(String nama, String spesialisasi, int pengalaman){
        if(count >= 6)return;
        Chef temp = new Chef(nama, spesialisasi, pengalaman);
        if(temp == null) return;
        listChef[count] = temp;
        count++;
    }
    public void showTimChef(){
        System.out.println("===============================================");
        System.out.println("Nama Tim     :" + namaTim);
        System.out.println("Shift        :" + shift);
        System.out.println("Jumlah Menu  :" + jumlahMenu);
        if(jumlahPesanan > 40) 
            System.out.println("Pesanan Sangat banyak");
        else if(jumlahPesanan > 20) 
            System.out.println("Pesanan Lumayan banyak");
        else 
            System.out.println("Pesanan sedikit");
        
        System.out.println("\n\t\tDaftar Chef");
        for(int i = 0; i < count ; i ++){
            Chef temp = listChef[i];
            System.out.println("\tChef ke - " + (i+1));
            System.out.println("\tNama        : " + temp.getNama()  );
            System.out.println("\tSpesialis   : " + temp.getSpesialisasi());
            System.out.println("\tPengalaman  : " + temp.getPengalaman());
        }
        System.out.println("");
        
    }

    public String getNamaTim() {
        return namaTim;
    }

    public String getShift() {
        return shift;
    }

    public int getJumlahMenu() {
        return jumlahMenu;
    }

    public int getJumlahPesanan() {
        return jumlahPesanan;
    }
    //bonus
    public int getCount(){ return count;}
    public boolean isTraining() {return training;}
    public void setTraining(boolean training) {this.training = training;}
    
}
