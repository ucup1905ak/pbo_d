/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.PaketLengkapDAO;
import dao.PaketRinganDAO;
import java.util.List;
import model.PaketLengkap;
import model.PaketServis;

/*
* @author Farelino Alexander Kim - 240713000
*/

public class PaketLengkapControl extends PaketServisControl {

    public PaketLengkapControl() {
        psDAO = new PaketLengkapDAO();
    }

    public void insert(PaketLengkap pr) {
        pr.setId("PS-" + psDAO.generateId());
        psDAO.insert(pr);
    }

    public String showString() {
        List<PaketServis> listPS = psDAO.showData("lengkap");
        String str = "";
        for (PaketServis ps : listPS) {
            str += ps.toString() + "\n";
        }

        return str;
    }
    //MEKANISME UPDATENYA BERBEDA DENGAN GUIDED ATAU UGD.
    // ini aku implementasikan kayak gini, lebih makesense di otak aku.
    //udah aku test hasilnya sesuai. 
    //perbedaannya ada di mekanisme delete rolenya yang aku abstraksikan untuk terjadi di Control layer
    public void update(PaketLengkap ps) {
        PaketRinganDAO prD = new PaketRinganDAO();
        prD.deleteOldRole(ps.getId());
        psDAO.update(ps, ps.getId());
    }

}
