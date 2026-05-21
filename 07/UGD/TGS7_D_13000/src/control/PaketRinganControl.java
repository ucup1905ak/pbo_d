/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.PaketLengkapDAO;
import dao.PaketRinganDAO;
import java.util.List;
import model.*;

/*
* @author Farelino Alexander Kim - 240713000
*/

public class PaketRinganControl extends PaketServisControl {

    public PaketRinganControl() {
        psDAO = new PaketRinganDAO();
    }

    public void insert(PaketRingan pr) {
        pr.setId("PS-" + psDAO.generateId());
        psDAO.insert(pr);
    }

    public String showString() {
        List<PaketServis> listPS = psDAO.showData("ringan");
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
    public void update(PaketRingan ps) {
        PaketLengkapDAO plD = new PaketLengkapDAO();
        plD.deleteOldRole(ps.getId());
        psDAO.update(ps, ps.getId());

    }

}
