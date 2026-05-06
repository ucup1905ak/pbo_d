/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gd6_d_13000;

import gd6_d_13000.Exception.*;

/**
 *
 * @author farel
 */
public class Rekening {
    protected double saldo;
    protected int nomorRekening;
    
    public Rekening(double saldo, int nomorRekening) throws InvalidRekeningException, InvalidSaldoException
    {
        if(saldo < 0) throw new InvalidSaldoException("Saldo awal tidak boleh negatif");
        if(nomorRekening <= 0) throw new InvalidRekeningException();
        this.saldo = saldo;
        this.nomorRekening = nomorRekening;
    }
    
    public void display(){
        System.out.println("Nomor Rekening  : " + nomorRekening);
        System.out.printf("Saldo            : Rp%10.2f\n", saldo);
    
    }
    public double getSaldo(){return saldo;}
       
}
