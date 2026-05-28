package GD_OLD_D_13000;

public class GD_OLD_D_13000 {

    public static void main(String[] args) {
        TeamEsport team1 = new TeamEsport("Eggvos", 2010);
        Manager manager1 = new Manager("Mobile Legends", "Pak AP", 9000000);
        Player player1 = new Player(3, "Eric", 4300000);

        TeamEsport team2 = new TeamEsport("Ar Ar Kiu", 2008);
        Manager manager2 = new Manager("Valorant", "Windah", 15000000);
        Player player2 = new Player(5, "LanaDelRey", 7500000);

        team1.setAnggotaTeam(manager1);
        team1.setAnggotaTeam(player1);

        team2.setAnggotaTeam(manager2);
        team2.setAnggotaTeam(player2);

        team1.tampilTeamEsport();
        team2.tampilTeamEsport();
    }

}
