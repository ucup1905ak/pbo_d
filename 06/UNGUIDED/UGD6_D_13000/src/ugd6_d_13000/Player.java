package ugd6_d_13000;

import java.util.ArrayList;
import java.util.List;
import ugd6_d_13000.Exceptions.*;

public abstract class Player {

    protected String namaPlayer, statusPlayer, role;
    protected Double winRate;
    protected static ArrayList<String> deskripsiSkill = null;

    public Player(String namaPlayer, String role, Double winRate) {
        this.namaPlayer = namaPlayer;
        this.statusPlayer = statusPlayer;
        this.role = role;
        this.winRate = winRate;
        this.deskripsiSkill = new ArrayList<>();
    }

    public void addDeskripsiSkill(String skill) {
        deskripsiSkill.add(skill);

    }

    public abstract void display();

    public abstract double hitungHargaPasar();

    public static void cekNama(String nama) throws KosongException {
        if (nama.isBlank() || nama.isEmpty()) {
            throw new KosongException();
        }

    }

    public static void cekRole(String role) throws RoleException {
        ArrayList<String> roles = new ArrayList<>();
        roles.add("JUNG");
        roles.add("ROAM");
        roles.add("MID");
        roles.add("EXP");
        roles.add("GOLD");
        int count = 0;
        for (String role1 : roles) {
            if (role.equalsIgnoreCase(role1)) {
                count++;
            }
        }
        if (count == 0) {
            throw new RoleException();
        }
    }

    public static void cekSkill(String skill, ArrayList<String> list) throws DeskripsiException, InputSalahException {
        if (skill.length() < 4) {
            throw new InputSalahException("Skill teralalu pendek!");
        }
        ArrayList<String> words = new ArrayList<>();
        words.add("malas");
        words.add("toxic");
        words.add("troll");
        words.add("feed");
        for (String word : words) {
            if (skill.contains(word)) {
                throw new DeskripsiException("Skill mengandung kata " + skill + " yang dibenci Coach Xepher!");
            }
        }

        if (deskripsiSkill.contains(skill)) {
            throw new DeskripsiException("Skill sudah ada di dalam List");
        }
    }
}
