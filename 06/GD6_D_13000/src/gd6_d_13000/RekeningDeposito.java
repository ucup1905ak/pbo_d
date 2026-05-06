/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gd6_d_13000;

import com.sun.source.doctree.DocTree;
import gd6_d_13000.Exception.InvalidRekeningException;
import gd6_d_13000.Exception.InvalidSaldoException;

/**
 *
 * @author farel
 */
public class RekeningDeposito extends Rekening {
    
    private int jangkaWaktu;

    public RekeningDeposito(int jangkaWaktu, double saldo, int nomorRekening) throws InvalidRekeningException, InvalidSaldoException {
        super(saldo, nomorRekening);
        this.jangkaWaktu = jangkaWaktu;
    }
    
    @Override
    public void display(){
    
        super.display();
        System.out.println("Jangka Waktu: " + jangkaWaktu + " Bulan");
    }
    
}
