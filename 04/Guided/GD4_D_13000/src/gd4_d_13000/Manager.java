/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gd4_d_13000;
import java.util.ArrayList;

/**
 *
 * FARELINO ALEXANDER KIM - D - 240713000
 */
public class Manager {
    private String nama;
    private int idManager;
    private ArrayList<Chef> chef = new ArrayList<>();

    public Manager(String nama, int idManager) {
        this.nama = nama;
        this.idManager = idManager;
    }
    
    public void addChef(Chef c){
        if(c!= null) chef.add(c);
    }
    
    public void showManager(){
        System.out.println("\n==== TAMPIL MANAGER ======");
        System.out.println("Nama        : " + nama);
        System.out.println("Id Manager  : " + idManager);
        System.out.println("Jumlah Chef : " + chef.size());
        
        int i = 1;
        for(Chef now : chef){
            System.out.println("\n====== TAMPIL CHEF =======");
            System.out.println("Chef ke - " + (i++));
            now.showChef();
        }
    }
}
