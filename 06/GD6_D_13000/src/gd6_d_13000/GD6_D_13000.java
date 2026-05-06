package gd6_d_13000;

import gd6_d_13000.Exception.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class GD6_D_13000 {

//    public static BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner In = new Scanner(System.in);
    public static void main(String[] args) {
        int nomorRekening, pin, jangkaWaktu;
        
        double saldo;
        
        try {
        
            Random Random = new Random();
            int randomNumber = Random.nextInt(300);
            
            
            System.out.println("TRANSAKSI KE-" + randomNumber);
            System.out.println("\n\n--- BUKA REKENING DEPOSITO ----");
            System.out.print("Masukan saldo Awal           : "); saldo = In.nextDouble();
            System.out.print("Masukan Nomor Rekening       : "); nomorRekening = In.nextInt();
            System.out.print("Masukan Jangka Waktu (Bulan) : "); jangkaWaktu  = In.nextInt();
            
            
            
            RekeningDeposito RekDep = new RekeningDeposito(jangkaWaktu, saldo, nomorRekening);
            
            System.out.println("\n\n--- BUKA REKENING DEPOSITO ----");
            System.out.print("Masukan saldo Awal           : "); saldo = In.nextDouble();
            System.out.print("Masukan Nomor Rekening       : "); nomorRekening = In.nextInt();
            System.out.print("Masukan Jangka Waktu (Bulan) : "); pin  = In.nextInt();
            
            
            
            RekeningTabungan RekTab = new RekeningTabungan(pin, saldo, nomorRekening);
            System.out.println("\n==== [DATA REKENING DEPOSITO] ====");
            RekDep.display();
            System.out.println("\n==== [DATA REKENING TABUNGAN] ====");
            RekTab.display();
            System.out.println("\n==================================");
            System.out.println("Total Aset : Rp" + (RekDep.getSaldo() + RekTab.getSaldo()));
            
        }
        catch(InputMismatchException e){System.out.println(e);}
        catch(InvalidPinException e){e.printError();}
        catch(InvalidSaldoException e){System.err.println(e.getMessage());}
        catch(InvalidRekeningException e){System.err.print(e.getMessage());}
    
    
    }
    
    
}
