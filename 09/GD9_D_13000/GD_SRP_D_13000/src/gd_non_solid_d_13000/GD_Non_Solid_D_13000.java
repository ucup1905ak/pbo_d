package gd_non_solid_d_13000;

public class GD_Non_Solid_D_13000 {

    public static void main(String[] args) {

        TeamEsport team1 = new TeamEsport("Eggvos", 2010);
        AnggotaTeam manager1 = new AnggotaTeam("Pak AP", "Mobile Legends", 9000000);
        AnggotaTeam player1 = new AnggotaTeam("Eric", 3, 4300000);

        TeamEsport team2 = new TeamEsport("Ar Ar Kiu", 2008);
        AnggotaTeam manager2 = new AnggotaTeam("Windah", "Valorant", 15000000);
        AnggotaTeam player2 = new AnggotaTeam("LanaDeLrey", 5, 7500000);

        team1.setManager(manager1);
        team1.setPlayer(player1);

        team2.setManager(manager2);
        team2.setPlayer(player2);

        team1.tampilTeamEsport();
        team2.tampilTeamEsport();

    }

}
