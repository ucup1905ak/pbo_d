package gd10_d_13000;

/**
 *
 * @author 240713000_Farelino Alexander Kim
 */
public class GD10_D_13000 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Observer
        Perusahaan perusahaan = new Perusahaan("Perusahaan Atma");
        
        Observer pegawai1 = new Marketing(30000, perusahaan, "Padmayoga", 10000);
        Observer pegawai2 = new IT(25000, perusahaan, "Riztianda", 8000);
        
        perusahaan.registerObserver(pegawai1);
        perusahaan.registerObserver(pegawai2);
        
        System.out.println("\n===[BAGIAN COMPOSITE]===");
        perusahaan.tambahBonus(2000);
        perusahaan.removeObserver(pegawai2);
        System.out.println("Setelah Remove Pegawai IT");
        perusahaan.tambahBonus(6000);
        perusahaan.removeObserver(pegawai1);
        
        
        //Composite
        Kepala direktur = new Kepala("Direktur Farelino Alexander Kim");
        Kepala manager = new Kepala("Manager Farelino Alexander Kim");
        Kepala asisten = new Kepala("Asisten Leo");
        
        Karyawan cs = new Karyawan("Kevin", "Customer Service");
        Karyawan sekretaris = new Karyawan("Fabian", "Sekretaris");
        Karyawan pembantu = new Karyawan("Frendy", "Pembantu Asisten");
        
        direktur.rekrutBawahan(manager);
        direktur.rekrutBawahan(asisten);
        
        manager.rekrutBawahan(cs);
        manager.rekrutBawahan(sekretaris);
        
        asisten.rekrutBawahan(pembantu);
        
        System.out.println("\n===[BAGIAN COMPOSITE]===");
        direktur.showData();
                

    }
    
}
