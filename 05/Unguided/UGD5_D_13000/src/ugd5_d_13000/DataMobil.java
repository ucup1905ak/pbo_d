/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd5_d_13000;

/**
 *Farelino Alexander Kim
 * @author komputasi9
 */

import java.util.*;
public class DataMobil <X> {
    private List<X> mobil = new ArrayList<>();
    
    public void addMobil(X m){
        mobil.add(m);
    }
    public void displayMobil(){
        for(X m : mobil){
            System.out.println(m);
        }
    }
}