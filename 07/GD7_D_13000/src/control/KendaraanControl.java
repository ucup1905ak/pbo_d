package control;

import dao.KendaraanDAO;
import model.Kendaraan;

/**
 *
 * @author Farelino Alexander Kim / 240713000
 */

public class KendaraanControl {
    KendaraanDAO kDao = new KendaraanDAO();
    
    public String generateId()
    {
        return "K" + kDao.generateId();
    }
    
    public Kendaraan searchDataKendaraan(String id)
    {
        return kDao.search(id);
    }
    
    public void deleteDataKendaraan(String id)
    {
        kDao.delete(id);
    }
}