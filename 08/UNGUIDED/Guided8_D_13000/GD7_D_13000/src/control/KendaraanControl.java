package control;

import dao.KendaraanDAO;
import model.Kendaraan;

/**
 *
 * @author farel
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