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
    return 9;
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
            return list.get(rowIndex).getKasir().getNama_kasir();
        case 4:
            return list.get(rowIndex).getPaket().getNama();
        case 5:
            return list.get(rowIndex).getJumlah();
        case 6:
            return list.get(rowIndex).getTambahan();
        case 7:
            return list.get(rowIndex).getMetode_pembayaran();
        case 8:
            return list.get(rowIndex).getTanggal_transaksi();
        default:
            return null;
    }
}

@Override
public String getColumnName(int column) {
    switch (column) {
        case 0: return "Nomor Resi";
        case 1: return "Nama Konsumen";
        case 2: return "Nama Kendaraan";
        case 3: return "Nama Kasir";
        case 4: return "Nama Paket Servis";
        case 5: return "Jumlah Pembelian";
        case 6: return "Tambahan";
        case 7: return "Metode Pembayaran";
        case 8: return "Tanggal Transaksi";
        default: return null;
    }
}
}
