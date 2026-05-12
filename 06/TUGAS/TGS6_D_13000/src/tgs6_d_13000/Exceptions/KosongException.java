package tgs6_d_13000.Exceptions;

public class KosongException extends Exception{
    public void printError(){
        System.err.println("Input tidak boleh kosong!");
    }
}
