package Exception;

/**
 *
 * @author farel
 */
public class InputSpecialAttributeException extends Exception {

    public String message(String jenis) {
        return "Atribut tidak sesuai untuk jenis " + jenis;
    }

}
