package Exception;

/**
 *
 * @author farel
 */
public class InputSpecialAtributeException extends Exception {

    public String message(String jenis) {
        return "Atribut tidak sesuai untuk jenis " + jenis;
    }

}
