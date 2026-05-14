package Exception;

/**
 *
 * @author farel
 */
public class NoTelponException extends Exception{
    public  String message(){
        return "No Telepon Hanya Boleh Terdiri dari Angka/diawali +";
    }
}
