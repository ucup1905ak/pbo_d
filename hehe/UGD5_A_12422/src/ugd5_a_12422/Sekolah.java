/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd5_a_12422;
    
import java.util.ArrayList;
import java.util.List;

    public class Sekolah <X, Y> {
        private DataMapel<X> dataMapel;
        private String namaSekolah;
        private List<Y> siswa;

    public Sekolah(String namaSekolah, DataMapel<X> dataMapel) {
        this.dataMapel = dataMapel;
        this.namaSekolah = namaSekolah;
        this.siswa = new ArrayList<>();
    }
        
        
        
    public void addSiswa(Y data){
        siswa.add(data);
    }
    
    public void displayDataMapel(){
        dataMapel.displayMapel();
    }
    
    public void displaySiswa(){
        for (Y data : siswa){
            System.out.print(data);
        }
        
     System.out.println();
    }
    
    public void displayAll(){
        System.out.println("=======================");
        System.out.println("Sekolah: "+namaSekolah);
        displayDataMapel();
        displaySiswa();
    }
     
    }
    

