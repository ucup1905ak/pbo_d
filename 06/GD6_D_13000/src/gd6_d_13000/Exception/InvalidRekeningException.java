/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gd6_d_13000.Exception;

/**
 *
 * @author farel
 */
public class InvalidRekeningException extends Exception{
    public InvalidRekeningException(){
        super("Nomor rekening harus lebih dari 0");
    }
    
}
