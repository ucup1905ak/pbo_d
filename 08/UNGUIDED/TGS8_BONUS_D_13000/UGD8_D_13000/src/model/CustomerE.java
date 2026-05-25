package model;

/**
 *
 * @author Farelino Alexander Kim - 240713000
 */
public class CustomerE extends model.Customer {

    public CustomerE(String nama, String alamat, String no_telepon) {
        super(nama, alamat, no_telepon);
    }

    public CustomerE(int id_customer, String nama, String alamat, String no_telepon) {
        super(id_customer, nama, alamat, no_telepon);
    }

    @Override
    public String toString() {
        return getNama();
    }
}
