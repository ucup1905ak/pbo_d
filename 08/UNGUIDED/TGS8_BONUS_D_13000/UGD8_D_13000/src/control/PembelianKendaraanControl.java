/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import dao.PembelianDAO;
import java.util.List;
import model.PembelianKendaraan;
import table.TablePembelianKendaraan;

/**
 *
 * @author Farelino Alexander Kim - 240713000
 */
public class PembelianKendaraanControl {
    private PembelianDAO pkDao = new PembelianDAO();
    
    public void insertDataPembelianKendaraan(PembelianKendaraan pk) {
        
        pkDao.insert(pk);
    }
    
    public TablePembelianKendaraan showTable(String target) {
        List<PembelianKendaraan> dataPembelian = pkDao.showData(target);
        TablePembelianKendaraan tablePembelianKendaraan = new TablePembelianKendaraan(dataPembelian);
        
        for (PembelianKendaraan pembelian : dataPembelian) {
            System.out.println(pembelian.getKendaraan().getNama());
        }
        return tablePembelianKendaraan;
    }
    
    public void updatePembelianKendaraan(PembelianKendaraan pk, int no_resi) {
        pkDao.update(pk, Integer.toString(no_resi));
    }
    
    public void deletePembelianKendaraan(int no_resi) {
        pkDao.delete(Integer.toString(no_resi));
    }
}
