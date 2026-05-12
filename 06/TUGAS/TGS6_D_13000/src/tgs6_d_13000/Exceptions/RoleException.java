package tgs6_d_13000.Exceptions;

public class RoleException extends  Exception{
    public void printError(){
        System.err.println("Role hanya boleh : JUNG, ROAM, MID, GOLD, atau EXP");
    }
}
