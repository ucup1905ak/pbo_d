package control;

import dao.KasirDAO;
import java.util.List;
import model.Kasir;
/*
* @author Farelino Alexander Kim - 240713000
*/

public class KasirControl {
    protected KasirDAO kDAO = new KasirDAO();
    
    public void insertDataKasir(Kasir k){
        kDAO.insert(k);
    }
    public String showAllStringKasir(){
        List<Kasir> listKasir = kDAO.showData(0);
        String s = "";;
        for( Kasir k : listKasir){
            System.out.println(k.toString());
            s += k.toString() + "\n";
        }
        return s;
    }
    public Kasir searchKasirById(int id_kasir){
        return kDAO.search(id_kasir);
    }
    public void updateDataKasir(Kasir k, int id_kasir){
        kDAO.update(k, id_kasir);
    }
    public void deleteDataKasir(int id_kasir){
        kDAO.delete(id_kasir);
    }
}
