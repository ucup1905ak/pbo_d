/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd5_a_12422;

public class Siswa {
    private String nama;
    private String nis;
    private int umur;
    private String alamat;
    private int i = 0;
    
    public Siswa(String nama, String nis, int umur,String alamat){
        this.nama = nama;
        this.nis = nis;
        this.umur = umur;
        this.alamat = alamat;
    }
    
    public String status(){
        i++;
        
        if(i%2 == 0){
            return "\n"+nama+"memiliki nilai akademik bagus";
        }
            return  "\n"+nama+"memiliki niali non akademtik yang bagus";
    }
    
    @Override
    public String toString(){
        return "\n=== Siswa ===\n" +
                "Nama			:"+nama+"\n" +
                "Nis			:"+nis+"\n" +
                "Umur			: "+umur+"\n" +
                "Alamat                 : "+alamat+
                status();
                
    }
}

