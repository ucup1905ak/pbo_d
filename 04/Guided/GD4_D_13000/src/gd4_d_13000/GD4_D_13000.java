/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gd4_d_13000;

/**
 *
 * FARELINO ALEXANDER KIM - D - 240713000
 */
public class GD4_D_13000 {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        System.out.println("===== GUIDED MODUL 4 RELASI PBO 25/26 =======");
        System.out.println("[1]. Relasi Agregasi dan Asosiasi");
        Order order1 = new Order("Kika", 4);
        Order order2 = new Order("Nevil", 13);
        Order order3 = new Order("Lucas", 8);
        Order order4 = new Order("Mukti", 15);
        
        
        Chef chef1 = new Chef("Sinay", "Sauce");
        Chef chef2 = new Chef("Mikel", "Pastry");
        Chef chef3 = new Chef("Alex", "Grill");
        Manager manager1 = new Manager("Eric", 12323);
        
        
        
        manager1.addChef(chef1);
        manager1.addChef(chef2);
        manager1.addChef(chef3);
        
        chef1.addOrder(order1);
        chef2.addOrder(order2);
        chef3.addOrder(order3);
        chef3.addOrder(order4);
        
        manager1.showManager();
        
        System.out.println("\n\n[2]. Relasi Komposisi");
        Restoran r1 = new Restoran("Mie Gacoan", "Jl. Barbasari no 44");
        r1.addMenu("Mie Suit", 9000);
        r1.addMenu("Mie Hompimpa", 9000);
        r1.addMenu("Udang Keju", 10000);
        r1.showRestoran();
        
        System.out.println("\n\nFARELINO ALEXANDER KIM - D - 240713000");
    }
    
}
