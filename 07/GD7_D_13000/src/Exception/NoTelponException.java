package Exception;

/**
 *
 * @author Farelino Alexander Kim / 240713000
 */
public class NoTelponException extends Exception{
    public  String message(){
        return "No Telepon Hanya Boleh Terdiri dari Angka/diawali +";
    }
}
