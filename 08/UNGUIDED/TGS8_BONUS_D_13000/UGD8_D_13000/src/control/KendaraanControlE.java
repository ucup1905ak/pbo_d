/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import dao.KendaraanDAOE;
import java.util.List;
import model.KendaraanE;

/**
 *
 * @author Farelino Alexander Kim - 240713000
 */
public class KendaraanControlE extends KendaraanControl{
    KendaraanDAOE kDao = new KendaraanDAOE();
    
    public List<KendaraanE> showlistKendaraan() {
        List<KendaraanE> dataKendaraan = kDao.IShowForDropdown();
        return dataKendaraan;
    }
}
