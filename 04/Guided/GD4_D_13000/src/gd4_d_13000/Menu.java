package gd4_d_13000;

/**
 *
 * FARELINO ALEXANDER KIM - D - 240713000
 */
public class Menu {
    
    private String namaMenu;
    private double harga;

    public Menu(String namaMenu, double harga) {
        this.namaMenu = namaMenu;
        this.harga = harga;
    }
    
    public void showMenu(){
        System.out.println("Nama Menu  : "+ namaMenu);
        System.out.println("Harga Menu : "+ harga);
    }
}
