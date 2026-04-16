/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gd5_d_13000;
public class Mahasigma {
    private String nama;
    private String npm;
    private double ipk;

    public Mahasigma(String nama, String npm, double ipk) {
        this.nama = nama;
        this.npm = npm;
        this.ipk = ipk;
    }

    @Override
    public String toString(){
        return "Nama : " + this.nama + "\n"
             + "NPM  : " + this.npm + "\n"
             + "IPK  : " + this.ipk + "\n";
    }
}