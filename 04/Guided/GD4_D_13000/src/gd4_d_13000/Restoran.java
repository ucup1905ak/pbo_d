package gd4_d_13000;

/**
 *
 * FARELINO ALEXANDER KIM - D - 240713000
 */
public class Restoran {
    
    private String nama, alamat;
    private Menu[] menu = new Menu[3];
    private int count = 0;

    public Restoran(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }
    
    
    public void addMenu(String namaMenu, double harga){
        if(count >= 3) return;
        menu[count++] = new Menu(namaMenu, harga);
    }
    
    public void showRestoran(){
        System.out.println("\n====== TAMPIL RESTORAN ======");
        System.out.println("Nama Restoran   : "+ nama);
        System.out.println("Alamat Restoran : " + alamat);
        System.out.println("Jumlah Menu     : " + count);
        System.out.println("\n======= Tampil Menu ========");
        int i = 1;
        for(Menu now : menu){
            System.out.println("\nData Menu ke - " + (i++));
            if(now!=null) now.showMenu();
        }
    }
}
