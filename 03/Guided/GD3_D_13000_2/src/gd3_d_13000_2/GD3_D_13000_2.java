package gd3_d_13000_2;

import java.util.ArrayList;

/**
 * NPM : 240713000
 * NAMA : Farelino Alexander Kim
 * 
 */
public class GD3_D_13000_2 {
    public static void main(String[] args) {
    
        ArrayList<Karakter> daftarKarakter = new ArrayList<>();

        Mage m1 = new Mage("Merlin", 10, 350, 200.0);
        Mage m2 = new Mage("Gandalf", 15, 400, 250.0);
        daftarKarakter.add(m1);
        daftarKarakter.add(m2);

        daftarKarakter.add(new Support("Angela", 8, 300, 25.0));
        daftarKarakter.add(new Support("Flora", 12, 320, 30.0));

        System.out.println("========= Data Karakter =========");
        for (Karakter karakter : daftarKarakter) {
            karakter.tampilDataKarakter();
            karakter.skill();
            
            System.out.println("");
        }

        System.out.println("Nama Praktikan : Farelino Alexander KIm");
        System.out.println("NPM            : 240713000");
    }
}
