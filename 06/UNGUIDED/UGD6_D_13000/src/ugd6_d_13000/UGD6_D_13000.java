package ugd6_d_13000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import ugd6_d_13000.Exceptions.*;

public class UGD6_D_13000 {

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
