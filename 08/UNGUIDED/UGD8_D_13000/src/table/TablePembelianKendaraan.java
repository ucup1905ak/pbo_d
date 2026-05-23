package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.PembelianKendaraan;

/**
 *
 * @author Farelino Alexander Kim - 240713000
 */
public class TablePembelianKendaraan extends AbstractTableModel {

    private List<PembelianKendaraan> list;

    public TablePembelianKendaraan(List<PembelianKendaraan> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getNo_resi();
            case 1:
                return list.get(rowIndex).getCustomer().getNama();
            case 2:
                return list.get(rowIndex).getKendaraan().getNama();
            case 3:
                return list.get(rowIndex).getJumlah();
            case 4:
                return list.get(rowIndex).getTambahan();
            case 5:
                return list.get(rowIndex).getMetode_pembayaran();
            case 6:
                return list.get(rowIndex).getId_customer();
            case 7:
                return list.get(rowIndex).getId_kendaraan();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nomor Resi";
            case 1:
                return "Nama Konsumen";
            case 2:
                return "Nama Kendaraan";
            case 3:
                return "Jumlah Pembelian";
            case 4:
                return "Tambahan";
            case 5:
                return "Metode Pembayaran";
            default:
                return null;
        }
    }
}
