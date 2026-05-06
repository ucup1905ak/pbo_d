/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gd6_d_13000.Exception;

/**
 *
 * @author farel
 */
public class InvalidPinException extends Exception {
    
    public void printError(){
        System.err.println("PIN harus terdiri dari 6 digit angka valid!");
    }
    
}
