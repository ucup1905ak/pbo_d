/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gd10_d_13000;

import java.util.ArrayList;

/**
 *
 * @author 240713000_Farelino Alexander Kim
 */
public class Kepala implements IComposite{
    private String namaKepala;
    private ArrayList<IComposite> bawahan = new ArrayList<>();

    public Kepala(String namaKepala) {
        this.namaKepala = namaKepala;
    }
    
    public void rekrutBawahan(IComposite composite){
        bawahan.add(composite);
    }

    @Override
    public void showData() {
        System.out.println(IComposite.space + "Kepala : "+namaKepala);
        IComposite.space.append("  ");
        for(IComposite composite: bawahan){
            System.out.print(IComposite.space +"Bawahan dari " + namaKepala+ " ");
            composite.showData();
        }
        IComposite.space.setLength(2);
    }
    
    
    
}
