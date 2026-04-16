/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ugd5_a_12422;


public class Mapel {
    
    private String namaMapel;
    private String guruPengampu;
    private int jamPelajaran;
    private boolean tersedia;

    public Mapel(String namaMapel, String guruPengampu, int jamPelajaran, boolean tersedia){
        this.namaMapel = namaMapel;
        this.guruPengampu = guruPengampu;
        this.jamPelajaran = jamPelajaran;
        this.tersedia = tersedia;
    }
    
    public String infoMapel(){
        if (tersedia == false){
            return "\nMapel dengan nama "+namaMapel+" sedang diambil Siswa lain";
        }
            return "\nMapel dengan "+namaMapel+" berhasil diambil";
    }
    
    @Override
    public String toString(){
        return 	"\n       === Mapel ===\n" +
                            "Nama mapel		:"+namaMapel+"\n" +
                            "Guru pengampu  	:"+guruPengampu+"\n" +
                            "Jam pelajaran	:"+jamPelajaran+"\n" +
                            "Tersedia		: "+tersedia+
                            infoMapel();
                
    }
}
