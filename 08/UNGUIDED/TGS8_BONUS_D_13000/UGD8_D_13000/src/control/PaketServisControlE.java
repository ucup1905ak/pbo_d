/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.PaketLengkapDAOE;
import dao.PaketRinganDAOE;
import java.util.List;
import model.KendaraanE;
import model.PaketServisE;

/**
 *
 * @author farel
 */
public class PaketServisControlE extends PaketServisControl {
    
    PaketLengkapDAOE paketLengkap = new PaketLengkapDAOE();
    PaketRinganDAOE paketRingan = new PaketRinganDAOE();
    
    
    public List<PaketServisE> showListPaketServis() {
        List<PaketServisE> allPaketServis = paketRingan.showListAllPaketServis();
        return allPaketServis;
    }
}
