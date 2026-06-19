package ugd11_d_13000;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Farelino Alexander Kim 240713000
 */
public class PersonilMiliterFactory<X> {

    //bonus
    private static PersonilMiliterFactory personilMiliterFactory = null;

    public static PersonilMiliterFactory getPersonilFactory() {
        if (personilMiliterFactory == null) {
            personilMiliterFactory = new PersonilMiliterFactory();
        }
        return personilMiliterFactory;
    }

    //ugd
    public PersonilMiliter createPersonil(X atribut, String nama, double gaji, MarkasBesar mb, String jabatan) throws JabatanException {
        PersonilMiliter p = null;
        if (jabatan.equalsIgnoreCase("Komandan")) {
            p = new Komandan((int) atribut, nama, gaji, mb);
        } else if (jabatan.equalsIgnoreCase("Prajurit")) {
            p = new Prajurit((String) atribut, nama, gaji, mb);
        } else {
            throw new JabatanException("[!] Role yang valid hanya 'Komandan' atau 'Prajurit' [!]");
        }
        return p;
    }
}
