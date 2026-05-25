/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.KasirDAOE;
import java.util.List;
import model.KasirE;

/**
 *
 * @author farel
 */
public class KasirControlE extends KasirControl {
    private KasirDAOE kaoe = new KasirDAOE();
    public List<KasirE> showListKasir() {
        return kaoe.IShowForDropdown();
    }
}
