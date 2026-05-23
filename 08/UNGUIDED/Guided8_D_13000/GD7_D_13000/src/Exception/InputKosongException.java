package Exception;

/**
 *
 * @author farel
 */
public class InputKosongException extends  Exception {
   
    public String message(){
        return "FIELD INPUT TIDAK BOLEH KOSONG!";
    }
    
}
