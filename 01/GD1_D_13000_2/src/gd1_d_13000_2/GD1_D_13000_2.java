
package gd1_d_13000_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Farelino Alexander Kim
//GD1 PBO_D
//27 Feb 2026

public class GD1_D_13000_2 {
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        //objeck default;
        Segitiga s1 = new Segitiga();
        Segitiga s2 = new Segitiga(3.5,4.2);
        
        double alas;
        double tinggi;
        
        System.out.println("========[Segitiga S1 Lama]========");
        System.out.println("Alas          :   " + s1.getAlas()    + " cm");
        System.out.println("Tingi         :   " + s1.getTinggi()  + " cm");
        System.out.println("Pythagoras    :   " + s1.pythagoras() + " cm");
        System.out.println("Luas          :   " + s1.luas()       + " cm²");

        System.out.println("========[Segitiga S2 Lama]========");
        System.out.println("Alas          :   " + s2.getAlas()    + " cm");
        System.out.println("Tingi         :   " + s2.getTinggi()  + " cm");
        System.out.println("Pythagoras    :   " + s2.pythagoras() + " cm");
        System.out.println("Luas          :   " + s2.luas()       + " cm²");
        
        System.out.println("--- Input Alas dan Tinggi baru ---");
        System.out.println("Masukan Nilai Alas : ");
        alas = Double.parseDouble(in.readLine( ));
        System.out.println("Masukan Nilai Tinggi : ");
        tinggi = Double.parseDouble(in.readLine( ));
        
        s2.setAlas(alas);
        s2.setTinggi(tinggi);
        
        System.out.println("========[Segitiga S1 Lama]========");
        System.out.println("Alas          :   " + s1.getAlas()    + " cm");
        System.out.println("Tingi         :   " + s1.getTinggi()  + " cm");
        System.out.println("Pythagoras    :   " + s1.pythagoras() + " cm");
        System.out.println("Luas          :   " + s1.luas()       + " cm²");

        System.out.println("========[Segitiga S2 Lama]========");
        System.out.println("Alas          :   " + s2.getAlas()    + " cm");
        System.out.println("Tingi         :   " + s2.getTinggi()  + " cm");
        System.out.println("Pythagoras    :   " + s2.pythagoras() + " cm");
        System.out.println("Luas          :   " + s2.luas()       + " cm²");      
    }
}
