/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gd4_d_13000;


/**
 *
 * FARELINO ALEXANDER KIM - D - 240713000
 */
import java.util.ArrayList;
public class Chef {
    private String namaChef;
    private String spesialis;
    private ArrayList<Order> order;

    public Chef(String namaChef, String spesialis) {
        this.namaChef = namaChef;
        this.spesialis = spesialis;
        this.order = order;
        order = new ArrayList<>();
    }
    
    public void addOrder(Order o){
        order.add(o);
    }
    public void showChef(){
        int i = 1;
        System.out.println("Nama Chef        : " + namaChef);
        System.out.println("Nama Spesialis   : " + spesialis);
        System.out.println("Jumlah Order     : " + order.size());
        for(Order order : order){
            System.out.println("\n====== Tampil Order ======");
            System.out.println("Order ke - : " + (i++));
            order.showOrder();
        }
    }
    
}
