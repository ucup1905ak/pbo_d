package ugd6_d_13000;

import tgs6_d_13000.Exceptions.KosongException;
import tgs6_d_13000.Exceptions.RoleException;
import tgs6_d_13000.Exceptions.DeskripsiException;
import tgs6_d_13000.Exceptions.InputSalahException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class old_main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int menu = 0, jumlahSkill = 0;
        double winRate = 0;
        String namaPlayer = "", role = "";
        boolean selesai = false;
        Player player = null;

        do {
            try {
                System.out.println("\n=== DATABASE ALTER EGO ESPORTS ===");
                System.out.println("1. Player Akademi");
                System.out.println("2. Player Veteran");
                System.out.print("Pilih Kategori Player > ");
                menu = Integer.parseInt(br.readLine());
                  
                if (menu <= 0 || menu >= 3) {
                    throw new InputSalahException("Menu hanya 1 atau 2!");
                }

                while (true) {
                    try {
                        System.out.print("Nama Player\t: ");
                        namaPlayer = br.readLine();
                        Player.cekNama(namaPlayer);

                        System.out.print("Role (JUNG/ROAM/MID/GOLD/EXP): ");
                        role = br.readLine();
                        Player.cekRole(role);

                        System.out.print("Win Rate (0-100)\t: ");
                        winRate = Double.parseDouble(br.readLine());
                        if (winRate > 100 || winRate < 0) {
                            throw new InputSalahException("Win Rate harus 0 - 100");
                        }

                        System.out.print("Jumlah Skill\t: ");
                        jumlahSkill = Integer.parseInt(br.readLine());

                        break;
                    } catch (KosongException e) {
                        e.printError();
                    } catch (RoleException e) {
                        e.printError();
                    } catch (InputSalahException e) {
                        System.err.println(e.getMessage());
                    } catch (IOException e) {
                        System.err.println(e);
                    }
                }

                switch (menu) {
                    case 1:
                        while (true) {
                            try {
                                System.out.print("Tier Rank (Mythic/Glory/Immortal): ");
                                String tier = br.readLine();
                                player = new PlayerAkademi(namaPlayer, role, winRate, tier);
                                break;
                            } catch (InputSalahException e) {
                                System.err.println(e.getMessage());
                            } catch (KosongException e) {
                                e.printError();
                            }
                        }
                        break;

                    case 2:
                        while (true) {
                            try {
                                System.out.print("Tim Sebelumnya\t: ");
                                String tim = br.readLine();
                                System.out.print("Tahun Debut\t: ");
                                int thn = Integer.parseInt(br.readLine());
                                player = new PlayerVeteran(namaPlayer, role, winRate, tim, thn);
                                break;
                            } catch (KosongException e) {
                                e.printError();
                            } catch (InputSalahException e) {
                                System.err.println(e.getMessage());
                            } catch (IOException e) {
                                System.err.println(e.getMessage());
                            }
                        }
                        break;
                }

                int c = 1;
                while (c <= jumlahSkill) {
                    try {
                        System.out.print("Skill ke-" + c + "\t: ");
                        String skill = br.readLine();
                        Player.cekSkill(skill, player.deskripsiSkill);
                        player.addDeskripsiSkill(skill);
                        c++;
                    } catch (InputSalahException | DeskripsiException e) {
                        System.err.println(e.getMessage());
                    }
                }

                System.out.println("\n---------------- DATA PLAYER ----------------");
                player.display();
                System.out.println("---------------------------------------------");
                System.out.println("Harga Pasar\t: Rp " + String.format("%.0f", player.hitungHargaPasar()));
                System.out.println("---------------------------------------------");
                selesai = true;

            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            } catch (InputSalahException e) {
                System.err.println(e.getMessage());
            } catch (IOException e) {
                System.err.println(e);
            } 
        } while (!selesai);
    }

}


/*
package tgs6_b_12111;

import exception.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TGS6_B_12111 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int menu = 0, jumlahSkill = 0;
        double winRate = 0;
        String namaPlayer = "", role = "";
        boolean selesai = false;
        Player player = null;

        do {
            try {
                System.out.println("\n=== DATABASE ALTER EGO ESPORTS ===");
                System.out.println("1. Player Akademi");
                System.out.println("2. Player Veteran");
                System.out.println("3. Player Rookie");
                System.out.println("4. Player Pinjaman");
                System.out.println("5. Player Import");
                System.out.print("Pilih Kategori Player > ");
                menu = Integer.parseInt(br.readLine());

                if (//jika menu){
                    //lempar baru exception user defined
                }

                while (true) {
                    try {
                        System.out.print("Nama Player\t: ");
                        namaPlayer = br.readLine();
                        Player.cekNama(namaPlayer);

                        System.out.print("Role (JUNG/ROAM/MID/GOLD/EXP): ");
                        role = br.readLine();
                        Player.cekRole(role);

                        System.out.print("Win Rate (0-100)\t: ");
                        winRate = Double.parseDouble(br.readLine());
                        if (//jika winrate){
                            //lempar baru exception user defined
                        }


                        System.out.print("Jumlah Skill\t: ");
                        jumlahSkill = Integer.parseInt(br.readLine());

                        break; 
                    } catch (//salah satu exception user-defined ) {
                	//lempar exception user-defined
                    } catch (//salah satu exception user-defined ) {
                	//lempar exception user-defined
                    } catch (//salah satu exception user-defined ) {
                	//lempar exception user-defined
                    }  catch (//exception format angka ada di guided ) {
                	//lempar exception format angka, contoh ada di guided
                    } 
                }

                switch (menu) {
                case 1:
                    while(true){
                        try {
                            System.out.print("Tier Rank (Mythic/Glory/Immortal): ");
                            String tier = br.readLine();
                            player = new PlayerAkademi(namaPlayer, role, winRate, tier);
                            break;
                        } catch (//salah satu exception user-defined ) {
                	    //lempar exception user-defined
                        } catch (//salah satu exception user-defined ) {
                	    //lempar exception user-defined
                        }
                    }
                    break;

                case 2:
                    while(true){
                        try {
                            System.out.print("Tim Sebelumnya\t: ");
                            String tim = br.readLine();
                            System.out.print("Tahun Debut\t: ");
                            int thn = Integer.parseInt(br.readLine());
                            player = new PlayerVeteran(namaPlayer, role, winRate, tim, thn);
                            break;
                        } catch (//salah satu exception user-defined ) {
                	    //lempar exception user-defined
                        } catch (//salah satu exception user-defined ) {
                	    //lempar exception user-defined
                        } catch (//exception format angka ada di guided) {
               		    //lempar exception format angka, contoh ada di guided
            		} 
                    }
                    break;

                case 3:
                    while(true){
                        try {
                            System.out.print("Umur Player\t: ");
                            int umur = Integer.parseInt(br.readLine());
                            player = new PlayerRookie(namaPlayer, role, winRate, umur);
                            break;
                        } catch (//salah satu exception user-defined ) {
                	    //lempar exception user-defined
                        } catch (//exception format angka ada di guided) {
               		    //lempar exception format angka, contoh ada di guided
            		} 
                    }
                    break;

                case 4:
                    while(true){
                        try {
                            System.out.print("Tim Asal\t: ");
                            String timAsal = br.readLine();

                            System.out.print("Durasi Pinjaman (Bulan): ");
                            int durasi = Integer.parseInt(br.readLine());

                            player = new PlayerPinjaman(namaPlayer, role, winRate, timAsal, durasi);
                            break;
                        } catch (//salah satu exception user-defined ) {
                	    //lempar exception user-defined
                        } catch (//salah satu exception user-defined ) {
                	    //lempar exception user-defined
                        } catch (//exception format angka ada di guided) {
               		    //lempar exception format angka, contoh ada di guided
            		} 
                    }
                    break;

                case 5:
                    while(true){
                        try {
                            System.out.print("Negara Asal\t: ");
                            String ngr = br.readLine();

                            System.out.print("Harga Transfer\t: Rp ");
                            double hrg = Double.parseDouble(br.readLine());

                            player = new PlayerImport(namaPlayer, role, winRate, ngr, hrg);

                            System.out.print("Input Jumlah Piala: ");
                            int jmlPiala = Integer.parseInt(br.readLine());

                            for (int i = 1; i <= jmlPiala; i++) {
                                while(true){
                                    try {
                                        System.out.print(" Nama Turnamen ke-"+i+": ");
                                        String nmPiala = br.readLine();

                                        System.out.print(" Tahun Juara\t    : ");
                                        int thnPiala = Integer.parseInt(br.readLine());

                                        Piala p = new Piala(nmPiala, thnPiala);
                                        ((PlayerImport)player).addPiala(p);
                                        break;
                                    } catch (//salah satu exception user-defined) {
                        		//lempar exception user-defined
                     		    } catch (//exception format angka ada di guided) {
               		    		//lempar exception format angka, contoh ada di guided
            			    } 
                                }
                            }

                            break;
                        } catch (//salah satu exception user-defined ) {
                	    //lempar exception user-defined
                        } catch (//salah satu exception user-defined ) {
                	    //lempar exception user-defined
                        } catch (//exception format angka ada di guided) {
               		    //lempar exception format angka, contoh ada di guided
            		} 
                    }
                    break;
            }


                int c = 1;
                while (c <= jumlahSkill) {
                    try {
                        System.out.print("Skill ke-" + c + "\t: ");
                        String skill = br.readLine();
                        Player.cekSkill(skill, player.deskripsiSkill);
                        player.addDeskripsiSkill(skill);
                        c++;
                    } catch (//ada dua exception user-defined disini, lihat contoh penerapan di guided) {
                        //lempar exception user-defined
                    }
                }

                System.out.println("\n---------------- DATA PLAYER ----------------");
                player.display();
                System.out.println("---------------------------------------------");
                System.out.println("Harga Pasar\t: Rp " + String.format("%.0f", player.hitungHargaPasar()));
                System.out.println("---------------------------------------------");
                selesai = true;

            } catch (//salah satu exception user-defined ) {
                //lempar exception user-defined
            } catch (//exception format angka ada di guided) {
                //lempar exception format angka, contoh ada di guided
            } catch (//exception general ada di guided) {
                //lempar exception general ada di guided
            }
        } while (!selesai);
    }
}

*/
