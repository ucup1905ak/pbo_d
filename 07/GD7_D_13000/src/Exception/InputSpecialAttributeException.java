package Exception;

/**
 *
 * @author Farelino Alexander Kim / 240713000
 */
public class InputSpecialAttributeException extends Exception {

    public String message(String jenis) {
        return "Atribut tidak sesuai untuk jenis " + jenis;
    }

}
