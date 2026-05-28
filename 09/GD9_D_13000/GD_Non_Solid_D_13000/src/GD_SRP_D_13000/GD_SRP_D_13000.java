package GD_SRP_D_13000;

public class GD_SRP_D_13000 {

    public static void main(String[] args) {

        TeamEsport team1 = new TeamEsport("Eggvos", 2010);
        Manager manager1 = new Manager("Pak AP", "Mobile Legends", 9000000);
        Player player1 = new Player("Eric", 3, 4300000);

        TeamEsport team2 = new TeamEsport("Ar Ar Kiu", 2008);
        Manager manager2 = new Manager("Windah", "Valorant", 15000000);
        Player player2 = new Player("LanaDeLrey", 5, 7500000);

        team1.setManager(manager1);
        team1.setPlayer(player1);

        team2.setManager(manager2);
        team2.setPlayer(player2);

        team1.tampilTeamEsport();
        team2.tampilTeamEsport();

    }

}
