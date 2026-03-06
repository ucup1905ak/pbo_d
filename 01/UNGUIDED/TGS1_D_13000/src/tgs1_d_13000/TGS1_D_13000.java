
package tgs1_d_13000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TGS1_D_13000 {
    public static BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        
        Kucing KucingA = new Kucing();
        Tikus TikusA = new Tikus();
        Anjing AnjingA = new Anjing();
        LatarBelakang LatarA = new LatarBelakang();
        
        System.out.println("====== KUCHENG =========");
        System.out.println("NAMA         : " + KucingA.getNama());
        System.out.println("JENIS        : " + KucingA.getJenis());
        System.out.println("TAHUN LAHIR  : " + KucingA.getTahunLahir());
        System.out.println("BERAT        : " + KucingA.getBerat());
        System.out.println("====== TIKUS =========");
        System.out.println("NAMA         : " + TikusA.getNama());
        System.out.println("JENIS        : " + TikusA.getJenis());
        System.out.println("TAHUN LAHIR  : " + TikusA.getTahunLahir());
        System.out.println("BERAT        : " + TikusA.getBerat());    
        System.out.println("====== ANJING =========");
        System.out.println("NAMA         : " + AnjingA.getNama());
        System.out.println("JENIS        : " + AnjingA.getJenis());
        System.out.println("TAHUN LAHIR  : " + AnjingA.getTahunLahir());
        System.out.println("BERAT        : " + AnjingA.getBerat());
        System.out.println("====== ENVIRONMENT =========");
        System.out.println("CUACA        : " + LatarA.getCuaca());
        System.out.println("LOKASI       : " + LatarA.getLokasi());
        
        
        String nama;
        String jenis;
        int tahunLahir;
        double berat;
        
        int timeOfDay;
        String cuaca;
        String lokasi;
        double temperature;
        double humidity;

        
        System.out.println("\n\n[INPUT DATA KELOMPOK HEWAN 2]");
        System.out.println("\n\n====== KUCHENG B =========");
        System.out.print("    NAMA         : "); nama = Input.readLine();
        System.out.print("    JENIS        : "); jenis = Input.readLine();
        System.out.print("    TAHUN LAHIR  : "); tahunLahir = Integer.parseInt(Input.readLine());
        System.out.print("    BERAT        : "); berat = Double.parseDouble(Input.readLine());
        Kucing KucingB = new Kucing(nama,jenis, tahunLahir, berat);
        
        System.out.println("\n\n====== TIKUS B =========");
        System.out.print("    NAMA         : "); nama = Input.readLine();
        System.out.print("    JENIS        : "); jenis = Input.readLine();
        System.out.print("    TAHUN LAHIR  : "); tahunLahir = Integer.parseInt(Input.readLine());
        System.out.print("    BERAT        : "); berat = Double.parseDouble(Input.readLine()); 
        Tikus TikusB = new Tikus(nama,jenis, tahunLahir, berat);
        
        System.out.println("\n\n====== ANJING B =========");
        System.out.print("    NAMA         : "); nama = Input.readLine();
        System.out.print("    JENIS        : "); jenis = Input.readLine();
        System.out.print("    TAHUN LAHIR  : "); tahunLahir = Integer.parseInt(Input.readLine());
        System.out.print("    BERAT        : "); berat = Double.parseDouble(Input.readLine());
        Anjing AnjingB = new Anjing(nama,jenis, tahunLahir, berat);
        
        System.out.println("====== ENVIRONMENT =========");
        System.out.print("    TIMEOFDAY    : "); timeOfDay = Integer.parseInt( Input.readLine());
        System.out.print("    CUACA        : "); cuaca = Input.readLine();
        System.out.print("    LOKASI       : "); lokasi = Input.readLine();
        System.out.print("    TEMPERATURE  : "); temperature = Double.parseDouble( Input.readLine());
        System.out.print("    HUMIDITY     : "); humidity = Double.parseDouble( Input.readLine());
        LatarBelakang LatarB = new LatarBelakang(timeOfDay, lokasi, cuaca, temperature, humidity);
        
        System.out.println("====== KUCHENG =========");
        System.out.println("NAMA         : " + KucingB.getNama());
        System.out.println("JENIS        : " + KucingB.getJenis());
        System.out.println("TAHUN LAHIR  : " + KucingB.getTahunLahir());
        System.out.println("BERAT        : " + KucingB.getBerat());
        System.out.println("====== TIKUS =========");
        System.out.println("NAMA         : " + TikusB.getNama());
        System.out.println("JENIS        : " + TikusB.getJenis());
        System.out.println("TAHUN LAHIR  : " + TikusB.getTahunLahir());
        System.out.println("BERAT        : " + TikusB.getBerat());    
        System.out.println("====== ANJING =========");
        System.out.println("NAMA         : " + AnjingB.getNama());
        System.out.println("JENIS        : " + AnjingB.getJenis());
        System.out.println("TAHUN LAHIR  : " + AnjingB.getTahunLahir());
        System.out.println("BERAT        : " + AnjingB.getBerat());
        System.out.println("====== ENVIRONMENT =========");
        System.out.println("CUACA        : " + LatarB.getCuaca());
        System.out.println("LOKASI       : " + LatarB.getLokasi());
        System.out.println("TEMPERATURE  : " + LatarB.getTemperature());
        System.out.println("HUMIDITY     : " + LatarB.getHumidity());
                

        KucingB.makan(100);
        TikusB.setLapar(15);
        System.out.println("== Kucing Mengejar ==");
        System.out.println("== Tikus Berlari ==");
        System.out.println("== Anjing Marah ==");
        KucingB.kejar();
        AnjingB.marah();
        TikusB.curiKeju(80);
        
        System.out.println("====== KUCHENG =========");
        System.out.println("KENYANG         : " + KucingB.getKenyang());

        System.out.println("====== TIKUS =========");
        System.out.println("LAPAR         : " + TikusB.getLapar());
   
        System.out.println("====== ANJING =========");
        System.out.println("AMARAH         : " + AnjingB.getAmarah());

        System.out.println("====== ENVIRONMENT =========");
        System.out.println("TIMEOFDAY A     : " + LatarA.getTimeOfDay());

                
    }
}
