/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.PaketLengkapDAO;
import dao.PaketServisDAO;
import model.PaketServis;

/*
* @author Farelino Alexander Kim - 240713000
*/

public class PaketServisControl {

    protected PaketServisDAO psDAO = new PaketLengkapDAO();

    public String generateId() {
        return "PS-" + psDAO.generateId();
    }

    public PaketServis search(String id) {
        return psDAO.search(id);
    }

    public void delete(String id) {
        psDAO.delete(id);
    }
}
