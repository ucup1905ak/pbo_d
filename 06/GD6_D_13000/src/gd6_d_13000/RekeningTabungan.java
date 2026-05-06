/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gd6_d_13000;

import gd6_d_13000.Exception.InvalidPinException;
import gd6_d_13000.Exception.InvalidRekeningException;
import gd6_d_13000.Exception.InvalidSaldoException;

/**
 *
 * @author farel
 */
public class RekeningTabungan extends Rekening{
    
    private int pin;

    public RekeningTabungan(int pin, double saldo, int nomorRekening) throws InvalidRekeningException, InvalidSaldoException, InvalidPinException {
        super(saldo, nomorRekening);
        if(pin < 100000 || pin > 999999) throw new InvalidPinException();
        this.pin = pin;
    }

    @Override
    public void display(){
        super.display();
        System.out.println("PIN (ENCRYPT) : ***" + (pin % 1000));
    }
    
}
