/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tgs5_d_13000;

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
    
    public X getMobil(int idx){return mobil.get(idx);}
}


// NPM : 240713000 - FARELINO ALEXANDER KIM