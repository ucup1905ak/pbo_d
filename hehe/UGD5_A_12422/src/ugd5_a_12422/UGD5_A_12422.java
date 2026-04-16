/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ugd5_a_12422;

/**
 *
 * @author komputasi9
 */
public class UGD5_A_12422 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataMapel<Mapel> dataMapel = new DataMapel<>();
        dataMapel.addMapel(new Mapel("Matematika", "Pak Budi", 2, true));
        dataMapel.addMapel(new Mapel("Bahasa Indonesia", "Bu Rina", 3, false));
        dataMapel.addMapel(new Mapel("IPA", "Pak Andi", 4, false));
        dataMapel.addMapel(new Mapel("IPS", "Bu Sinta", 2, true));

        Sekolah<Mapel, Siswa> sekolahA = new Sekolah<>("SMA Filbert", dataMapel);
        sekolahA.addSiswa(new Siswa("Nadya", "23001", 16, "Jl. Godean"));
        sekolahA.addSiswa(new Siswa("Bagas", "23002", 17, "Jl. Malioboro"));
        sekolahA.addSiswa(new Siswa("Salsa", "23003", 16, "Jl. Magelang"));
        sekolahA.addSiswa(new Siswa("Dimas", "23004", 17, "Jl. Kaliurang"));
        sekolahA.displayAll();

        dataMapel.addMapel(new Mapel("PKN", "Pak Rudi", 2, true));
        dataMapel.addMapel(new Mapel("Seni Budaya", "Bu Lestari", 3, false));
        dataMapel.addMapel(new Mapel("Bahasa Inggris", "Mr. John", 4, false));
        dataMapel.addMapel(new Mapel("PJOK", "Pak Yoga", 2, true));

        Sekolah<Mapel, Siswa> sekolahB = new Sekolah<>("SMA Cendekia", dataMapel);
        sekolahB.addSiswa(new Siswa("Rani", "23005", 15, "Jl. Janti"));
        sekolahB.addSiswa(new Siswa("Fajar", "23006", 16, "Jl. Gejayan"));
        sekolahB.addSiswa(new Siswa("Tio", "23007", 17, "Jl. Solo"));
        sekolahB.addSiswa(new Siswa("Cindy", "23008", 16, "Jl. Seturan"));
        sekolahB.displayAll();
    }
    
}
