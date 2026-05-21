/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/*
* @author Farelino Alexander Kim - 240713000
 */
import control.*;
import Exception.*;
import javax.swing.JOptionPane;
import model.*;

public class mainPanel extends javax.swing.JFrame {

    private MotorControl mtrc = new MotorControl();
    private MobilControl mblc = new MobilControl();
    private CustomerControl cc = new CustomerControl();
    private KendaraanControl kc = new KendaraanControl();

    private Kendaraan k = null;
    private Mobil mbl = null;
    private Motor mtr = null;
    private Customer c = null;

    //UGD
    private KasirControl kasirC = new KasirControl();
    private Kasir activeKasir = null;

    private String actionKendaraan = null, action = null, actionCustomer = null, actionKasir = null;
    int idCustomer = 0;

    //TUGAS
    private PaketServisControl psC = new PaketServisControl();
    private PaketLengkapControl plC = new PaketLengkapControl();
    private PaketRinganControl prC = new PaketRinganControl();
    private PaketServis ps = null;
    private String actionPaketServis = "";

    /**
     * Creates new form MainView
     */
    public mainPanel() {
        initComponents();
        showKendaraan();
        showCustomer();
        showKasir();
        showPaketServis();

        setComponentsKendaraan(false);
        setComponentsCustomer(false);
        setComponentKasir(false);
        setComponentPaketServis(false);

        setKendaraanEditDeleteButton(false);
        setEditDeleteButtonCustomer(false);
        setKasirButton(true, false, false);
        setPaketServisButton(true, false, false);

        clearTextKendaraan();
        clearTextCustomer();
        clearTextPaketServis();

        txtIdPaketServis.setEnabled(false);
    }

    private void showPaketServisField(PaketServis ps) {
        txtDurasiPaketServis.setText(Integer.toString(ps.getDurasi()));
        txtIdPaketServis.setText(ps.getId());
        btnJenisPaketServis.setText(ps.getJenis());
        txtNamaPaketServis.setText(ps.getNama());
        txtSpecialPaketServis.setText(ps.getSpecial());
    }

    private void showPaketServis() {
        String strL = "PAKET LENGKAP \n =========== \n";
        txaLengkapPaketServis.setText(strL + plC.showString());
        String strR = "PAKET RIngan \n =========== \n";
        txaRinganPaketServis.setText(strR + prC.showString());

    }

    private void setComponentPaketServis(boolean status) {
        txtDurasiPaketServis.setEnabled(status);
//        txtIdPaketServis.setEnabled(status);
        btnJenisPaketServis.setEnabled(status);
        txtNamaPaketServis.setEnabled(status);
        txtSpecialPaketServis.setEnabled(status);
        btnSavePaketServis.setEnabled(status);
    }

    private void setPaketServisButton(boolean add, boolean edit, boolean delete) {
        btnAddPaketServis.setEnabled(add);
        btnEditPaketServis.setEnabled(edit);
        btnHapusPaketServis.setEnabled(delete);
    }

    private void clearTextPaketServis() {
//        btnJenisPaketServis.setText("Ringan");

        txtDurasiPaketServis.setText("");
        txtIdPaketServis.setText("");
        txtNamaPaketServis.setText("");
        txtSpecialPaketServis.setText("");

    }

    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void setComponentsKendaraan(boolean value) {
        idKendaraanInputField.setEnabled(value);
        namaKendaraanInputField.setEnabled(value);
        hargaKendaraanInputField.setEnabled(value);
        jenisKendaraanInputButton.setEnabled(value);
        specialAttributeInputField.setEnabled(value);
        jenisKendaraanInputButton.setEnabled(value);
    }

    private void setComponentKasir(boolean value) {
        kasirFormInputNamaField.setEnabled(value);
        kasirFormInputLoketScrollPanelTextArea.setEnabled(value);
        kasirFormInputShiftField.setEnabled(value);
    }

    private void setComponentsCustomer(boolean value) {
        namaCustomerField.setEnabled(value);
        nomorTeleponCustomerField.setEnabled(value);
        alamatCustomerTextArea.setEnabled(value);
    }

    private void setKendaraanEditDeleteButton(boolean value) {
        barukanKendaraanButton.setEnabled(value);
        hapusKendaraanButton.setEnabled(value);
    }

    private void setEditDeleteButtonCustomer(boolean value) {
        barukanCustomerButton.setEnabled(value);
        hapusCustomerButton.setEnabled(value);
    }

    private void setKasirButton(boolean add, boolean edit, boolean delete) {
        kasirFormButtonTambahButton.setEnabled(add);
        kasirFormButtonBarukanButton.setEnabled(edit);
        kasirFormButtonHapusButton.setEnabled(delete);
    }

    private void clearTextKendaraan() {
        idKendaraanInputField.setText("");
        namaKendaraanInputField.setText("");
        hargaKendaraanInputField.setText("");
        jenisKendaraanInputButton.setText("");
        searchKendaraanInputField.setText("");
        specialAttributeInputField.setText("");
        specialAttributeInputLabel.setText("");
    }

    private void clearTextCustomer() {
        namaCustomerField.setText("");
        nomorTeleponCustomerField.setText("");
        alamatCustomerTextArea.setText("");
        searchCustomerInputTextField.setText("");
    }

    private void clearTextKasir() {
        kasirSearchField.setText("");
        kasirFormInputNamaField.setText("");
        kasirFormInputShiftField.setText("");
        kasirFormInputLoketScrollPanelTextArea.setText("");
//        actionKasir = null;
    }

    private void setSpecialAttributeLabel() {
        if (jenisKendaraanInputButton.getText().equals("Mobil")) {
            specialAttributeInputLabel.setText("Jenis Mesin");
        } else {
            specialAttributeInputLabel.setText("Jumlah Tak");
        }
    }

    private void showKasir() {

        kasirFormScrollPanelTextArea.setEnabled(true);
        kasirFormScrollPanelTextArea.setText("List Kasir: \n===========\n" + kasirC.showAllStringKasir());
    }

    private void showKendaraan() {
        motorTextArea.setText("List Motor: \n ============= \n" + mtrc.showStringKendaraan());
        mobilTextArea.setText("List Mobil: \n ============= \n" + mblc.showStringKendaraan());
    }

    private void showCustomer() {
        customerTextArea.setText("List Customer: \n ============= \n" + cc.showAllStringCustomer());
    }

    private boolean mobilIsSelected() {
        return jenisKendaraanInputButton.getText().equals("Mobil");
    }

    private void doSearchKasir() {
        if (kasirSearchField.getText().isEmpty()) {
            return;
        }
        try {
            activeKasir = kasirC.searchKasirById(Integer.decode(kasirSearchField.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Masukan ID Kasir yang valid!");
            return;
        }
        if (activeKasir == null) {
            JOptionPane.showMessageDialog(rootPane, "Data Tidak Ditemukan");
            return;
        }
//        kasirFormScrollPanelTextArea.setText(activeKasir.toString());
        Integer i = activeKasir.getNomor_loket();
        kasirFormInputLoketScrollPanelTextArea.setText(i.toString());
        kasirFormInputNamaField.setText(activeKasir.getNama_kasir());
        kasirFormInputShiftField.setText(activeKasir.getShift());
        setComponentKasir(false);
        setKasirButton(true, true, true);
        showKasir();

    }

    private void doSearchKendaraan() {
        if (searchKendaraanInputField.getText().isEmpty()) {
            return;
        }

        k = kc.searchDataKendaraan(searchKendaraanInputField.getText());

        if (k != null) {
            setKendaraanEditDeleteButton(true);
            idKendaraanInputField.setText(k.getId_kendaraan());
            namaKendaraanInputField.setText(k.getNama());
            hargaKendaraanInputField.setText(Float.toString(k.getHarga()));
            jenisKendaraanInputButton.setText(k.getJenis());
            setSpecialAttributeLabel();
            specialAttributeInputField.setText(k.getSpecial());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Data Tidak Ditemukan!");
        }
    }

    private void doSearchCustomer() {
        if (searchCustomerInputTextField.getText().isEmpty()) {
            return;
        }
        Customer c
                = cc.searchCustomerById(Integer.parseInt(searchCustomerInputTextField.getText()));
        if (c == null) {
            JOptionPane.showMessageDialog(rootPane, "Data Tidak Ditemukan!");
            return;
        }
        setEditDeleteButtonCustomer(true);
        clearTextCustomer();
        namaCustomerField.setText(c.getNama());
        nomorTeleponCustomerField.setText(c.getAlamat());
        alamatCustomerTextArea.setText(c.getNo_telepon());

        idCustomer = c.getId_customer();
    }

    private void inputKosongKendaraanException() throws InputKosongException {
        if (namaKendaraanInputField.getText().isEmpty()
                || hargaKendaraanInputField.getText().isEmpty()) {
            throw new InputKosongException();
        }
    }

    private void inputKosongCustomerException() throws InputKosongException {
        if (namaCustomerField.getText().isEmpty()
                || alamatCustomerTextArea.getText().isEmpty() || nomorTeleponCustomerField.getText().isEmpty()) {
            throw new InputKosongException();
        }
    }

    private void InputSpecialAttributeKendaraanException() throws InputSpecialAttributeException {
        if (jenisKendaraanInputButton.getText().equals("Motor")
                && !isInteger(specialAttributeInputField.getText())) {
            throw new InputSpecialAttributeException();
        }
    }

    private void noTelponException() throws NoTelponException {
        if (!nomorTeleponCustomerField.getText().matches("^\\+?[1-5]+$")) {
            throw new NoTelponException();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTabbedPane1 = new javax.swing.JTabbedPane();
        kendaraan1 = new javax.swing.JPanel();
        searchKendaraanInputPanel1 = new javax.swing.JPanel();
        searchKendaraanInputField1 = new javax.swing.JTextField();
        searchKendaraanInputLabel1 = new javax.swing.JLabel();
        searchKendaraanInputButton1 = new javax.swing.JButton();
        KendaraanFormPanel1 = new javax.swing.JPanel();
        KendaraanButtonPanel1 = new javax.swing.JPanel();
        barukanKendaraanButton1 = new javax.swing.JButton();
        tambahKendaraanButton1 = new javax.swing.JButton();
        hapusKendaraanButton1 = new javax.swing.JButton();
        idKendaraanInputPanel1 = new javax.swing.JPanel();
        idKendaraanInputField1 = new javax.swing.JTextField();
        idKendaraanInputLabel1 = new javax.swing.JLabel();
        namaKendaraanInputPanel1 = new javax.swing.JPanel();
        namaKendaraanInputField1 = new javax.swing.JTextField();
        namaKendaraanInputLabel1 = new javax.swing.JLabel();
        hargaKendaraanInputPanel1 = new javax.swing.JPanel();
        hargaKendaraanInputField1 = new javax.swing.JTextField();
        hargaKendaraanInputLabel1 = new javax.swing.JLabel();
        jenisKendaraanInputPanel1 = new javax.swing.JPanel();
        jenisKendaraanInputLabel1 = new javax.swing.JLabel();
        jenisKendaraanInputButton1 = new javax.swing.JButton();
        KendaraanFormPanel3 = new javax.swing.JPanel();
        specialAttributeInputPanel1 = new javax.swing.JPanel();
        specialAttributeInputField1 = new javax.swing.JTextField();
        specialAttributeInputLabel1 = new javax.swing.JLabel();
        simpanKendaraanButton1 = new javax.swing.JButton();
        mobilScrollPanel1 = new javax.swing.JScrollPane();
        mobilTextArea1 = new javax.swing.JTextArea();
        motorScrollPanel1 = new javax.swing.JScrollPane();
        motorTextArea1 = new javax.swing.JTextArea();
        customer1 = new javax.swing.JPanel();
        searchCustomerInputPanel1 = new javax.swing.JPanel();
        searchCustomerInputTextField1 = new javax.swing.JTextField();
        searchCustomerInputLabel1 = new javax.swing.JLabel();
        searchCustomerInputButton1 = new javax.swing.JButton();
        customerFormPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        barukanCustomerButton1 = new javax.swing.JButton();
        tambahCustomerButton1 = new javax.swing.JButton();
        hapusCustomerButton1 = new javax.swing.JButton();
        namaCustomerPanel1 = new javax.swing.JPanel();
        namaCustomerField1 = new javax.swing.JTextField();
        namaCustomerLabel1 = new javax.swing.JLabel();
        nomorTeleponCustomerPanel1 = new javax.swing.JPanel();
        nomorTeleponCustomerField1 = new javax.swing.JTextField();
        nomorTeleponCustomerLabel1 = new javax.swing.JLabel();
        alamatCustomerPanel1 = new javax.swing.JPanel();
        alamatCustomerLabel1 = new javax.swing.JLabel();
        alamatCustomerPane1 = new javax.swing.JScrollPane();
        alamatCustomerTextArea1 = new javax.swing.JTextArea();
        customerScrollPane1 = new javax.swing.JScrollPane();
        customerTextArea1 = new javax.swing.JTextPane();
        simpanCustomerButton1 = new javax.swing.JButton();
        kasir1 = new javax.swing.JPanel();
        kasirSearchPanel1 = new javax.swing.JPanel();
        kasirSearchField1 = new javax.swing.JTextField();
        kasirSearchButton1 = new javax.swing.JLabel();
        kasirSearchLabel1 = new javax.swing.JButton();
        KasirFormPanel1 = new javax.swing.JPanel();
        kasirFormButtonPanel1 = new javax.swing.JPanel();
        kasirFormButtonBarukanButton1 = new javax.swing.JButton();
        kasirFormButtonTambahButton1 = new javax.swing.JButton();
        kasirFormButtonHapusButton1 = new javax.swing.JButton();
        kasirFormInputNamaPanel1 = new javax.swing.JPanel();
        kasirFormInputNamaField1 = new javax.swing.JTextField();
        kasirFormInputNamaLabel1 = new javax.swing.JLabel();
        kasirFormInputShiftPanel1 = new javax.swing.JPanel();
        kasirFormInputShiftField1 = new javax.swing.JTextField();
        kasirFormInputShiftLabel1 = new javax.swing.JLabel();
        kasirFormInputLoketPanel1 = new javax.swing.JPanel();
        kasirFormInputLoketLabel1 = new javax.swing.JLabel();
        kasirFormInputLoketScrollPanel1 = new javax.swing.JScrollPane();
        kasirFormInputLoketScrollPanelTextArea1 = new javax.swing.JTextArea();
        kasirFormScrollPanel1 = new javax.swing.JScrollPane();
        kasirFormScrollPanelTextArea1 = new javax.swing.JTextPane();
        kasirFormSimpanButton1 = new javax.swing.JButton();
        mainTabbedPane2 = new javax.swing.JTabbedPane();
        kendaraan2 = new javax.swing.JPanel();
        searchKendaraanInputPanel2 = new javax.swing.JPanel();
        searchKendaraanInputField2 = new javax.swing.JTextField();
        searchKendaraanInputLabel2 = new javax.swing.JLabel();
        searchKendaraanInputButton2 = new javax.swing.JButton();
        KendaraanFormPanel4 = new javax.swing.JPanel();
        KendaraanButtonPanel2 = new javax.swing.JPanel();
        barukanKendaraanButton2 = new javax.swing.JButton();
        tambahKendaraanButton2 = new javax.swing.JButton();
        hapusKendaraanButton2 = new javax.swing.JButton();
        idKendaraanInputPanel2 = new javax.swing.JPanel();
        idKendaraanInputField2 = new javax.swing.JTextField();
        idKendaraanInputLabel2 = new javax.swing.JLabel();
        namaKendaraanInputPanel2 = new javax.swing.JPanel();
        namaKendaraanInputField2 = new javax.swing.JTextField();
        namaKendaraanInputLabel2 = new javax.swing.JLabel();
        hargaKendaraanInputPanel2 = new javax.swing.JPanel();
        hargaKendaraanInputField2 = new javax.swing.JTextField();
        hargaKendaraanInputLabel2 = new javax.swing.JLabel();
        jenisKendaraanInputPanel2 = new javax.swing.JPanel();
        jenisKendaraanInputLabel2 = new javax.swing.JLabel();
        jenisKendaraanInputButton2 = new javax.swing.JButton();
        KendaraanFormPanel5 = new javax.swing.JPanel();
        specialAttributeInputPanel2 = new javax.swing.JPanel();
        specialAttributeInputField2 = new javax.swing.JTextField();
        specialAttributeInputLabel2 = new javax.swing.JLabel();
        simpanKendaraanButton2 = new javax.swing.JButton();
        mobilScrollPanel2 = new javax.swing.JScrollPane();
        mobilTextArea2 = new javax.swing.JTextArea();
        motorScrollPanel2 = new javax.swing.JScrollPane();
        motorTextArea2 = new javax.swing.JTextArea();
        customer2 = new javax.swing.JPanel();
        searchCustomerInputPanel2 = new javax.swing.JPanel();
        searchCustomerInputTextField2 = new javax.swing.JTextField();
        searchCustomerInputLabel2 = new javax.swing.JLabel();
        searchCustomerInputButton2 = new javax.swing.JButton();
        customerFormPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        barukanCustomerButton2 = new javax.swing.JButton();
        tambahCustomerButton2 = new javax.swing.JButton();
        hapusCustomerButton2 = new javax.swing.JButton();
        namaCustomerPanel2 = new javax.swing.JPanel();
        namaCustomerField2 = new javax.swing.JTextField();
        namaCustomerLabel2 = new javax.swing.JLabel();
        nomorTeleponCustomerPanel2 = new javax.swing.JPanel();
        nomorTeleponCustomerField2 = new javax.swing.JTextField();
        nomorTeleponCustomerLabel2 = new javax.swing.JLabel();
        alamatCustomerPanel2 = new javax.swing.JPanel();
        alamatCustomerLabel2 = new javax.swing.JLabel();
        alamatCustomerPane2 = new javax.swing.JScrollPane();
        alamatCustomerTextArea2 = new javax.swing.JTextArea();
        customerScrollPane2 = new javax.swing.JScrollPane();
        customerTextArea2 = new javax.swing.JTextPane();
        simpanCustomerButton2 = new javax.swing.JButton();
        kasir2 = new javax.swing.JPanel();
        kasirSearchPanel2 = new javax.swing.JPanel();
        kasirSearchField2 = new javax.swing.JTextField();
        kasirSearchButton2 = new javax.swing.JLabel();
        kasirSearchLabel2 = new javax.swing.JButton();
        KasirFormPanel2 = new javax.swing.JPanel();
        kasirFormButtonPanel2 = new javax.swing.JPanel();
        kasirFormButtonBarukanButton2 = new javax.swing.JButton();
        kasirFormButtonTambahButton2 = new javax.swing.JButton();
        kasirFormButtonHapusButton2 = new javax.swing.JButton();
        kasirFormInputNamaPanel2 = new javax.swing.JPanel();
        kasirFormInputNamaField2 = new javax.swing.JTextField();
        kasirFormInputNamaLabel2 = new javax.swing.JLabel();
        kasirFormInputShiftPanel2 = new javax.swing.JPanel();
        kasirFormInputShiftField2 = new javax.swing.JTextField();
        kasirFormInputShiftLabel2 = new javax.swing.JLabel();
        kasirFormInputLoketPanel2 = new javax.swing.JPanel();
        kasirFormInputLoketLabel2 = new javax.swing.JLabel();
        kasirFormInputLoketScrollPanel2 = new javax.swing.JScrollPane();
        kasirFormInputLoketScrollPanelTextArea2 = new javax.swing.JTextArea();
        kasirFormScrollPanel2 = new javax.swing.JScrollPane();
        kasirFormScrollPanelTextArea2 = new javax.swing.JTextPane();
        kasirFormSimpanButton2 = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        mainTabbedPane = new javax.swing.JTabbedPane();
        kendaraan = new javax.swing.JPanel();
        searchKendaraanInputPanel = new javax.swing.JPanel();
        searchKendaraanInputField = new javax.swing.JTextField();
        searchKendaraanInputLabel = new javax.swing.JLabel();
        searchKendaraanInputButton = new javax.swing.JButton();
        KendaraanFormPanel = new javax.swing.JPanel();
        KendaraanButtonPanel = new javax.swing.JPanel();
        barukanKendaraanButton = new javax.swing.JButton();
        tambahKendaraanButton = new javax.swing.JButton();
        hapusKendaraanButton = new javax.swing.JButton();
        idKendaraanInputPanel = new javax.swing.JPanel();
        idKendaraanInputField = new javax.swing.JTextField();
        idKendaraanInputLabel = new javax.swing.JLabel();
        namaKendaraanInputPanel = new javax.swing.JPanel();
        namaKendaraanInputField = new javax.swing.JTextField();
        namaKendaraanInputLabel = new javax.swing.JLabel();
        hargaKendaraanInputPanel = new javax.swing.JPanel();
        hargaKendaraanInputField = new javax.swing.JTextField();
        hargaKendaraanInputLabel = new javax.swing.JLabel();
        jenisKendaraanInputPanel = new javax.swing.JPanel();
        jenisKendaraanInputLabel = new javax.swing.JLabel();
        jenisKendaraanInputButton = new javax.swing.JButton();
        KendaraanFormPanel2 = new javax.swing.JPanel();
        specialAttributeInputPanel = new javax.swing.JPanel();
        specialAttributeInputField = new javax.swing.JTextField();
        specialAttributeInputLabel = new javax.swing.JLabel();
        simpanKendaraanButton = new javax.swing.JButton();
        mobilScrollPanel = new javax.swing.JScrollPane();
        mobilTextArea = new javax.swing.JTextArea();
        motorScrollPanel = new javax.swing.JScrollPane();
        motorTextArea = new javax.swing.JTextArea();
        customer = new javax.swing.JPanel();
        searchCustomerInputPanel = new javax.swing.JPanel();
        searchCustomerInputTextField = new javax.swing.JTextField();
        searchCustomerInputLabel = new javax.swing.JLabel();
        searchCustomerInputButton = new javax.swing.JButton();
        customerFormPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        barukanCustomerButton = new javax.swing.JButton();
        tambahCustomerButton = new javax.swing.JButton();
        hapusCustomerButton = new javax.swing.JButton();
        namaCustomerPanel = new javax.swing.JPanel();
        namaCustomerField = new javax.swing.JTextField();
        namaCustomerLabel = new javax.swing.JLabel();
        nomorTeleponCustomerPanel = new javax.swing.JPanel();
        nomorTeleponCustomerField = new javax.swing.JTextField();
        nomorTeleponCustomerLabel = new javax.swing.JLabel();
        alamatCustomerPanel = new javax.swing.JPanel();
        alamatCustomerLabel = new javax.swing.JLabel();
        alamatCustomerPane = new javax.swing.JScrollPane();
        alamatCustomerTextArea = new javax.swing.JTextArea();
        customerScrollPane = new javax.swing.JScrollPane();
        customerTextArea = new javax.swing.JTextPane();
        simpanCustomerButton = new javax.swing.JButton();
        kasir = new javax.swing.JPanel();
        kasirSearchPanel = new javax.swing.JPanel();
        kasirSearchField = new javax.swing.JTextField();
        kasirSearchButton = new javax.swing.JLabel();
        kasirSearchLabel = new javax.swing.JButton();
        KasirFormPanel = new javax.swing.JPanel();
        kasirFormButtonPanel = new javax.swing.JPanel();
        kasirFormButtonBarukanButton = new javax.swing.JButton();
        kasirFormButtonTambahButton = new javax.swing.JButton();
        kasirFormButtonHapusButton = new javax.swing.JButton();
        kasirFormInputNamaPanel = new javax.swing.JPanel();
        kasirFormInputNamaField = new javax.swing.JTextField();
        kasirFormInputNamaLabel = new javax.swing.JLabel();
        kasirFormInputShiftPanel = new javax.swing.JPanel();
        kasirFormInputShiftField = new javax.swing.JTextField();
        kasirFormInputShiftLabel = new javax.swing.JLabel();
        kasirFormInputLoketPanel = new javax.swing.JPanel();
        kasirFormInputLoketLabel = new javax.swing.JLabel();
        kasirFormInputLoketScrollPanel = new javax.swing.JScrollPane();
        kasirFormInputLoketScrollPanelTextArea = new javax.swing.JTextArea();
        kasirFormScrollPanel = new javax.swing.JScrollPane();
        kasirFormScrollPanelTextArea = new javax.swing.JTextPane();
        kasirFormSimpanButton = new javax.swing.JButton();
        PaketServis = new javax.swing.JPanel();
        SearchPaketServis = new javax.swing.JPanel();
        txtSearchPaketServis = new javax.swing.JTextField();
        lblSearchPaketServis = new javax.swing.JLabel();
        btnSearchPaketServis = new javax.swing.JButton();
        FormPaketServis1 = new javax.swing.JPanel();
        ButtonPaketServis = new javax.swing.JPanel();
        btnEditPaketServis = new javax.swing.JButton();
        btnAddPaketServis = new javax.swing.JButton();
        btnHapusPaketServis = new javax.swing.JButton();
        IdPaketServis = new javax.swing.JPanel();
        txtIdPaketServis = new javax.swing.JTextField();
        lblIdPaketServis = new javax.swing.JLabel();
        NamaPaketServis = new javax.swing.JPanel();
        txtNamaPaketServis = new javax.swing.JTextField();
        lblNamaPaketServis = new javax.swing.JLabel();
        DurasiPaketServis = new javax.swing.JPanel();
        txtDurasiPaketServis = new javax.swing.JTextField();
        lblDurasiPaketServis = new javax.swing.JLabel();
        JenisPaketServis = new javax.swing.JPanel();
        lblJenisPaketServis = new javax.swing.JLabel();
        btnJenisPaketServis = new javax.swing.JButton();
        FormPaketServis2 = new javax.swing.JPanel();
        SpecialPaketServis = new javax.swing.JPanel();
        txtSpecialPaketServis = new javax.swing.JTextField();
        lblSpecialPaketServis = new javax.swing.JLabel();
        btnSavePaketServis = new javax.swing.JButton();
        FormPaketServis3 = new javax.swing.JScrollPane();
        txaLengkapPaketServis = new javax.swing.JTextArea();
        FormPaketServis4 = new javax.swing.JScrollPane();
        txaRinganPaketServis = new javax.swing.JTextArea();

        kendaraan1.setBackground(new java.awt.Color(57, 54, 52));

        searchKendaraanInputField1.setText("Search");
        searchKendaraanInputField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchKendaraanInputField1ActionPerformed(evt);
            }
        });
        searchKendaraanInputField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKendaraanInputField1KeyPressed(evt);
            }
        });

        searchKendaraanInputLabel1.setText("Pencarian Customer");

        searchKendaraanInputButton1.setText("Cari");
        searchKendaraanInputButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchKendaraanInputButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchKendaraanInputPanel1Layout = new javax.swing.GroupLayout(searchKendaraanInputPanel1);
        searchKendaraanInputPanel1.setLayout(searchKendaraanInputPanel1Layout);
        searchKendaraanInputPanel1Layout.setHorizontalGroup(
            searchKendaraanInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchKendaraanInputPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchKendaraanInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchKendaraanInputPanel1Layout.createSequentialGroup()
                        .addComponent(searchKendaraanInputField1, javax.swing.GroupLayout.PREFERRED_SIZE, 1153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchKendaraanInputButton1))
                    .addComponent(searchKendaraanInputLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        searchKendaraanInputPanel1Layout.setVerticalGroup(
            searchKendaraanInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchKendaraanInputPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchKendaraanInputLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchKendaraanInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchKendaraanInputField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchKendaraanInputButton1))
                .addGap(30, 30, 30))
        );

        barukanKendaraanButton1.setText("Barukan");
        barukanKendaraanButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barukanKendaraanButton1ActionPerformed(evt);
            }
        });

        tambahKendaraanButton1.setText("Tambah");
        tambahKendaraanButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahKendaraanButton1ActionPerformed(evt);
            }
        });

        hapusKendaraanButton1.setText("Hapus");
        hapusKendaraanButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusKendaraanButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KendaraanButtonPanel1Layout = new javax.swing.GroupLayout(KendaraanButtonPanel1);
        KendaraanButtonPanel1.setLayout(KendaraanButtonPanel1Layout);
        KendaraanButtonPanel1Layout.setHorizontalGroup(
            KendaraanButtonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KendaraanButtonPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tambahKendaraanButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(barukanKendaraanButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hapusKendaraanButton1)
                .addContainerGap())
        );
        KendaraanButtonPanel1Layout.setVerticalGroup(
            KendaraanButtonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanButtonPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(KendaraanButtonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahKendaraanButton1)
                    .addComponent(barukanKendaraanButton1)
                    .addComponent(hapusKendaraanButton1))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        idKendaraanInputLabel1.setText("ID Kendaraan");

        javax.swing.GroupLayout idKendaraanInputPanel1Layout = new javax.swing.GroupLayout(idKendaraanInputPanel1);
        idKendaraanInputPanel1.setLayout(idKendaraanInputPanel1Layout);
        idKendaraanInputPanel1Layout.setHorizontalGroup(
            idKendaraanInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idKendaraanInputPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(idKendaraanInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idKendaraanInputField1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idKendaraanInputLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        idKendaraanInputPanel1Layout.setVerticalGroup(
            idKendaraanInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idKendaraanInputPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(idKendaraanInputLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idKendaraanInputField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        namaKendaraanInputLabel1.setText("Nama");

        javax.swing.GroupLayout namaKendaraanInputPanel1Layout = new javax.swing.GroupLayout(namaKendaraanInputPanel1);
        namaKendaraanInputPanel1.setLayout(namaKendaraanInputPanel1Layout);
        namaKendaraanInputPanel1Layout.setHorizontalGroup(
            namaKendaraanInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaKendaraanInputPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaKendaraanInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(namaKendaraanInputPanel1Layout.createSequentialGroup()
                        .addComponent(namaKendaraanInputLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(namaKendaraanInputField1)))
        );
        namaKendaraanInputPanel1Layout.setVerticalGroup(
            namaKendaraanInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaKendaraanInputPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(namaKendaraanInputLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaKendaraanInputField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        hargaKendaraanInputField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hargaKendaraanInputField1KeyTyped(evt);
            }
        });

        hargaKendaraanInputLabel1.setText("Harga");

        javax.swing.GroupLayout hargaKendaraanInputPanel1Layout = new javax.swing.GroupLayout(hargaKendaraanInputPanel1);
        hargaKendaraanInputPanel1.setLayout(hargaKendaraanInputPanel1Layout);
        hargaKendaraanInputPanel1Layout.setHorizontalGroup(
            hargaKendaraanInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hargaKendaraanInputPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hargaKendaraanInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hargaKendaraanInputField1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaKendaraanInputLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hargaKendaraanInputPanel1Layout.setVerticalGroup(
            hargaKendaraanInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hargaKendaraanInputPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(hargaKendaraanInputLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hargaKendaraanInputField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jenisKendaraanInputLabel1.setText("Jenis Kendaraan");

        jenisKendaraanInputButton1.setText("Mobil");
        jenisKendaraanInputButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisKendaraanInputButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jenisKendaraanInputPanel1Layout = new javax.swing.GroupLayout(jenisKendaraanInputPanel1);
        jenisKendaraanInputPanel1.setLayout(jenisKendaraanInputPanel1Layout);
        jenisKendaraanInputPanel1Layout.setHorizontalGroup(
            jenisKendaraanInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisKendaraanInputPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jenisKendaraanInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jenisKendaraanInputLabel1)
                    .addComponent(jenisKendaraanInputButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jenisKendaraanInputPanel1Layout.setVerticalGroup(
            jenisKendaraanInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisKendaraanInputPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jenisKendaraanInputLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jenisKendaraanInputButton1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout KendaraanFormPanel1Layout = new javax.swing.GroupLayout(KendaraanFormPanel1);
        KendaraanFormPanel1.setLayout(KendaraanFormPanel1Layout);
        KendaraanFormPanel1Layout.setHorizontalGroup(
            KendaraanFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanFormPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(KendaraanFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KendaraanButtonPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(KendaraanFormPanel1Layout.createSequentialGroup()
                        .addGroup(KendaraanFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(namaKendaraanInputPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idKendaraanInputPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addGroup(KendaraanFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hargaKendaraanInputPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(jenisKendaraanInputPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(49, 49, 49))
        );
        KendaraanFormPanel1Layout.setVerticalGroup(
            KendaraanFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanFormPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(KendaraanButtonPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(KendaraanFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idKendaraanInputPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaKendaraanInputPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(KendaraanFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaKendaraanInputPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jenisKendaraanInputPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        specialAttributeInputLabel1.setText("Jenis Mesin");

        javax.swing.GroupLayout specialAttributeInputPanel1Layout = new javax.swing.GroupLayout(specialAttributeInputPanel1);
        specialAttributeInputPanel1.setLayout(specialAttributeInputPanel1Layout);
        specialAttributeInputPanel1Layout.setHorizontalGroup(
            specialAttributeInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialAttributeInputPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(specialAttributeInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(specialAttributeInputField1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specialAttributeInputLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        specialAttributeInputPanel1Layout.setVerticalGroup(
            specialAttributeInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialAttributeInputPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(specialAttributeInputLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specialAttributeInputField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        simpanKendaraanButton1.setText("Simpan");
        simpanKendaraanButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanKendaraanButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KendaraanFormPanel3Layout = new javax.swing.GroupLayout(KendaraanFormPanel3);
        KendaraanFormPanel3.setLayout(KendaraanFormPanel3Layout);
        KendaraanFormPanel3Layout.setHorizontalGroup(
            KendaraanFormPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanFormPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(specialAttributeInputPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(359, 359, 359))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KendaraanFormPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(simpanKendaraanButton1)
                .addGap(36, 36, 36))
        );
        KendaraanFormPanel3Layout.setVerticalGroup(
            KendaraanFormPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanFormPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(specialAttributeInputPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(simpanKendaraanButton1)
                .addGap(37, 37, 37))
        );

        mobilTextArea1.setColumns(20);
        mobilTextArea1.setRows(5);
        mobilScrollPanel1.setViewportView(mobilTextArea1);

        motorTextArea1.setColumns(20);
        motorTextArea1.setRows(5);
        motorScrollPanel1.setViewportView(motorTextArea1);

        javax.swing.GroupLayout kendaraan1Layout = new javax.swing.GroupLayout(kendaraan1);
        kendaraan1.setLayout(kendaraan1Layout);
        kendaraan1Layout.setHorizontalGroup(
            kendaraan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kendaraan1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kendaraan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchKendaraanInputPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kendaraan1Layout.createSequentialGroup()
                        .addGroup(kendaraan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KendaraanFormPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobilScrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kendaraan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KendaraanFormPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(motorScrollPanel1))))
                .addContainerGap())
        );
        kendaraan1Layout.setVerticalGroup(
            kendaraan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kendaraan1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchKendaraanInputPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kendaraan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(KendaraanFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(KendaraanFormPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kendaraan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mobilScrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(motorScrollPanel1))
                .addContainerGap())
        );

        mainTabbedPane1.addTab("Kendaraan", kendaraan1);

        customer1.setBackground(new java.awt.Color(57, 54, 52));

        searchCustomerInputTextField1.setText("Search");
        searchCustomerInputTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCustomerInputTextField1ActionPerformed(evt);
            }
        });
        searchCustomerInputTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchCustomerInputTextField1KeyPressed(evt);
            }
        });

        searchCustomerInputLabel1.setText("Pencarian Customer");

        searchCustomerInputButton1.setText("Cari");
        searchCustomerInputButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCustomerInputButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchCustomerInputPanel1Layout = new javax.swing.GroupLayout(searchCustomerInputPanel1);
        searchCustomerInputPanel1.setLayout(searchCustomerInputPanel1Layout);
        searchCustomerInputPanel1Layout.setHorizontalGroup(
            searchCustomerInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchCustomerInputPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchCustomerInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchCustomerInputPanel1Layout.createSequentialGroup()
                        .addComponent(searchCustomerInputTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 1153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchCustomerInputButton1))
                    .addComponent(searchCustomerInputLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        searchCustomerInputPanel1Layout.setVerticalGroup(
            searchCustomerInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchCustomerInputPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchCustomerInputLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchCustomerInputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchCustomerInputTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchCustomerInputButton1))
                .addGap(30, 30, 30))
        );

        barukanCustomerButton1.setText("Barukan");
        barukanCustomerButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barukanCustomerButton1ActionPerformed(evt);
            }
        });

        tambahCustomerButton1.setText("Tambah");
        tambahCustomerButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahCustomerButton1ActionPerformed(evt);
            }
        });

        hapusCustomerButton1.setText("Hapus");
        hapusCustomerButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusCustomerButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tambahCustomerButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(barukanCustomerButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hapusCustomerButton1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahCustomerButton1)
                    .addComponent(barukanCustomerButton1)
                    .addComponent(hapusCustomerButton1))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        namaCustomerLabel1.setText("Nama Customer");

        javax.swing.GroupLayout namaCustomerPanel1Layout = new javax.swing.GroupLayout(namaCustomerPanel1);
        namaCustomerPanel1.setLayout(namaCustomerPanel1Layout);
        namaCustomerPanel1Layout.setHorizontalGroup(
            namaCustomerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaCustomerPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaCustomerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaCustomerField1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaCustomerLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        namaCustomerPanel1Layout.setVerticalGroup(
            namaCustomerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaCustomerPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(namaCustomerLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaCustomerField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        nomorTeleponCustomerLabel1.setText("Nomor Telepon");

        javax.swing.GroupLayout nomorTeleponCustomerPanel1Layout = new javax.swing.GroupLayout(nomorTeleponCustomerPanel1);
        nomorTeleponCustomerPanel1.setLayout(nomorTeleponCustomerPanel1Layout);
        nomorTeleponCustomerPanel1Layout.setHorizontalGroup(
            nomorTeleponCustomerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomorTeleponCustomerPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nomorTeleponCustomerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nomorTeleponCustomerPanel1Layout.createSequentialGroup()
                        .addComponent(nomorTeleponCustomerLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(nomorTeleponCustomerField1)))
        );
        nomorTeleponCustomerPanel1Layout.setVerticalGroup(
            nomorTeleponCustomerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomorTeleponCustomerPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(nomorTeleponCustomerLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomorTeleponCustomerField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        alamatCustomerLabel1.setText("Alamat");

        alamatCustomerTextArea1.setColumns(20);
        alamatCustomerTextArea1.setRows(5);
        alamatCustomerPane1.setViewportView(alamatCustomerTextArea1);

        javax.swing.GroupLayout alamatCustomerPanel1Layout = new javax.swing.GroupLayout(alamatCustomerPanel1);
        alamatCustomerPanel1.setLayout(alamatCustomerPanel1Layout);
        alamatCustomerPanel1Layout.setHorizontalGroup(
            alamatCustomerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alamatCustomerPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(alamatCustomerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alamatCustomerPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alamatCustomerLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        alamatCustomerPanel1Layout.setVerticalGroup(
            alamatCustomerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alamatCustomerPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(alamatCustomerLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alamatCustomerPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        customerScrollPane1.setViewportView(customerTextArea1);

        simpanCustomerButton1.setText("Simpan");
        simpanCustomerButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanCustomerButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customerFormPanel1Layout = new javax.swing.GroupLayout(customerFormPanel1);
        customerFormPanel1.setLayout(customerFormPanel1Layout);
        customerFormPanel1Layout.setHorizontalGroup(
            customerFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerFormPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerFormPanel1Layout.createSequentialGroup()
                        .addGroup(customerFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerScrollPane1)
                            .addGroup(customerFormPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(customerFormPanel1Layout.createSequentialGroup()
                        .addGroup(customerFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomorTeleponCustomerPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(namaCustomerPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addComponent(alamatCustomerPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simpanCustomerButton1)
                        .addGap(34, 34, 34))))
        );
        customerFormPanel1Layout.setVerticalGroup(
            customerFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerFormPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(customerFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerFormPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(customerFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(customerFormPanel1Layout.createSequentialGroup()
                                .addComponent(namaCustomerPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nomorTeleponCustomerPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(alamatCustomerPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(customerScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(customerFormPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(simpanCustomerButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout customer1Layout = new javax.swing.GroupLayout(customer1);
        customer1.setLayout(customer1Layout);
        customer1Layout.setHorizontalGroup(
            customer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customer1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchCustomerInputPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        customer1Layout.setVerticalGroup(
            customer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customer1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchCustomerInputPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabbedPane1.addTab("Customer", customer1);

        kasir1.setBackground(new java.awt.Color(57, 54, 52));

        kasirSearchField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirSearchField1ActionPerformed(evt);
            }
        });
        kasirSearchField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kasirSearchField1KeyPressed(evt);
            }
        });

        kasirSearchButton1.setText("Pencarian Kasir");

        kasirSearchLabel1.setText("Cari");
        kasirSearchLabel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirSearchLabel1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kasirSearchPanel1Layout = new javax.swing.GroupLayout(kasirSearchPanel1);
        kasirSearchPanel1.setLayout(kasirSearchPanel1Layout);
        kasirSearchPanel1Layout.setHorizontalGroup(
            kasirSearchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirSearchPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kasirSearchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kasirSearchPanel1Layout.createSequentialGroup()
                        .addComponent(kasirSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 1153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kasirSearchLabel1))
                    .addComponent(kasirSearchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        kasirSearchPanel1Layout.setVerticalGroup(
            kasirSearchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kasirSearchPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kasirSearchButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kasirSearchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kasirSearchField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kasirSearchLabel1))
                .addGap(30, 30, 30))
        );

        kasirFormButtonBarukanButton1.setText("Barukan");
        kasirFormButtonBarukanButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirFormButtonBarukanButton1ActionPerformed(evt);
            }
        });

        kasirFormButtonTambahButton1.setText("Tambah");
        kasirFormButtonTambahButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirFormButtonTambahButton1ActionPerformed(evt);
            }
        });

        kasirFormButtonHapusButton1.setText("Hapus");
        kasirFormButtonHapusButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirFormButtonHapusButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kasirFormButtonPanel1Layout = new javax.swing.GroupLayout(kasirFormButtonPanel1);
        kasirFormButtonPanel1.setLayout(kasirFormButtonPanel1Layout);
        kasirFormButtonPanel1Layout.setHorizontalGroup(
            kasirFormButtonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kasirFormButtonPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kasirFormButtonTambahButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kasirFormButtonBarukanButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kasirFormButtonHapusButton1)
                .addContainerGap())
        );
        kasirFormButtonPanel1Layout.setVerticalGroup(
            kasirFormButtonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormButtonPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(kasirFormButtonPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kasirFormButtonTambahButton1)
                    .addComponent(kasirFormButtonBarukanButton1)
                    .addComponent(kasirFormButtonHapusButton1))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        kasirFormInputNamaLabel1.setText("Nama Kasir");

        javax.swing.GroupLayout kasirFormInputNamaPanel1Layout = new javax.swing.GroupLayout(kasirFormInputNamaPanel1);
        kasirFormInputNamaPanel1.setLayout(kasirFormInputNamaPanel1Layout);
        kasirFormInputNamaPanel1Layout.setHorizontalGroup(
            kasirFormInputNamaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputNamaPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kasirFormInputNamaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kasirFormInputNamaField1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kasirFormInputNamaLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kasirFormInputNamaPanel1Layout.setVerticalGroup(
            kasirFormInputNamaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputNamaPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(kasirFormInputNamaLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kasirFormInputNamaField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        kasirFormInputShiftLabel1.setText("Shift");

        javax.swing.GroupLayout kasirFormInputShiftPanel1Layout = new javax.swing.GroupLayout(kasirFormInputShiftPanel1);
        kasirFormInputShiftPanel1.setLayout(kasirFormInputShiftPanel1Layout);
        kasirFormInputShiftPanel1Layout.setHorizontalGroup(
            kasirFormInputShiftPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputShiftPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kasirFormInputShiftPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kasirFormInputShiftPanel1Layout.createSequentialGroup()
                        .addComponent(kasirFormInputShiftLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(kasirFormInputShiftField1)))
        );
        kasirFormInputShiftPanel1Layout.setVerticalGroup(
            kasirFormInputShiftPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputShiftPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(kasirFormInputShiftLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kasirFormInputShiftField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        kasirFormInputLoketLabel1.setText("Nomor Loket");

        kasirFormInputLoketScrollPanelTextArea1.setColumns(20);
        kasirFormInputLoketScrollPanelTextArea1.setRows(5);
        kasirFormInputLoketScrollPanel1.setViewportView(kasirFormInputLoketScrollPanelTextArea1);

        javax.swing.GroupLayout kasirFormInputLoketPanel1Layout = new javax.swing.GroupLayout(kasirFormInputLoketPanel1);
        kasirFormInputLoketPanel1.setLayout(kasirFormInputLoketPanel1Layout);
        kasirFormInputLoketPanel1Layout.setHorizontalGroup(
            kasirFormInputLoketPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputLoketPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kasirFormInputLoketPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kasirFormInputLoketScrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kasirFormInputLoketLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kasirFormInputLoketPanel1Layout.setVerticalGroup(
            kasirFormInputLoketPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputLoketPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(kasirFormInputLoketLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kasirFormInputLoketScrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kasirFormScrollPanel1.setViewportView(kasirFormScrollPanelTextArea1);

        kasirFormSimpanButton1.setText("Simpan");
        kasirFormSimpanButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirFormSimpanButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KasirFormPanel1Layout = new javax.swing.GroupLayout(KasirFormPanel1);
        KasirFormPanel1.setLayout(KasirFormPanel1Layout);
        KasirFormPanel1Layout.setHorizontalGroup(
            KasirFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KasirFormPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(KasirFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KasirFormPanel1Layout.createSequentialGroup()
                        .addGroup(KasirFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kasirFormScrollPanel1)
                            .addGroup(KasirFormPanel1Layout.createSequentialGroup()
                                .addComponent(kasirFormButtonPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(KasirFormPanel1Layout.createSequentialGroup()
                        .addGroup(KasirFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kasirFormInputShiftPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kasirFormInputNamaPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addComponent(kasirFormInputLoketPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kasirFormSimpanButton1)
                        .addGap(34, 34, 34))))
        );
        KasirFormPanel1Layout.setVerticalGroup(
            KasirFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KasirFormPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(kasirFormButtonPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(KasirFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KasirFormPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(KasirFormPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(KasirFormPanel1Layout.createSequentialGroup()
                                .addComponent(kasirFormInputNamaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kasirFormInputShiftPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(kasirFormInputLoketPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kasirFormScrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(KasirFormPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(kasirFormSimpanButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout kasir1Layout = new javax.swing.GroupLayout(kasir1);
        kasir1.setLayout(kasir1Layout);
        kasir1Layout.setHorizontalGroup(
            kasir1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasir1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kasir1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kasirSearchPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(KasirFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        kasir1Layout.setVerticalGroup(
            kasir1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasir1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kasirSearchPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KasirFormPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabbedPane1.addTab("Kasir", kasir1);

        kendaraan2.setBackground(new java.awt.Color(57, 54, 52));

        searchKendaraanInputField2.setText("Search");
        searchKendaraanInputField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchKendaraanInputField2ActionPerformed(evt);
            }
        });
        searchKendaraanInputField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKendaraanInputField2KeyPressed(evt);
            }
        });

        searchKendaraanInputLabel2.setText("Pencarian Customer");

        searchKendaraanInputButton2.setText("Cari");
        searchKendaraanInputButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchKendaraanInputButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchKendaraanInputPanel2Layout = new javax.swing.GroupLayout(searchKendaraanInputPanel2);
        searchKendaraanInputPanel2.setLayout(searchKendaraanInputPanel2Layout);
        searchKendaraanInputPanel2Layout.setHorizontalGroup(
            searchKendaraanInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchKendaraanInputPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchKendaraanInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchKendaraanInputPanel2Layout.createSequentialGroup()
                        .addComponent(searchKendaraanInputField2, javax.swing.GroupLayout.PREFERRED_SIZE, 1153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchKendaraanInputButton2))
                    .addComponent(searchKendaraanInputLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        searchKendaraanInputPanel2Layout.setVerticalGroup(
            searchKendaraanInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchKendaraanInputPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchKendaraanInputLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchKendaraanInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchKendaraanInputField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchKendaraanInputButton2))
                .addGap(30, 30, 30))
        );

        barukanKendaraanButton2.setText("Barukan");
        barukanKendaraanButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barukanKendaraanButton2ActionPerformed(evt);
            }
        });

        tambahKendaraanButton2.setText("Tambah");
        tambahKendaraanButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahKendaraanButton2ActionPerformed(evt);
            }
        });

        hapusKendaraanButton2.setText("Hapus");
        hapusKendaraanButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusKendaraanButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KendaraanButtonPanel2Layout = new javax.swing.GroupLayout(KendaraanButtonPanel2);
        KendaraanButtonPanel2.setLayout(KendaraanButtonPanel2Layout);
        KendaraanButtonPanel2Layout.setHorizontalGroup(
            KendaraanButtonPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KendaraanButtonPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tambahKendaraanButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(barukanKendaraanButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hapusKendaraanButton2)
                .addContainerGap())
        );
        KendaraanButtonPanel2Layout.setVerticalGroup(
            KendaraanButtonPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanButtonPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(KendaraanButtonPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahKendaraanButton2)
                    .addComponent(barukanKendaraanButton2)
                    .addComponent(hapusKendaraanButton2))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        idKendaraanInputLabel2.setText("ID Kendaraan");

        javax.swing.GroupLayout idKendaraanInputPanel2Layout = new javax.swing.GroupLayout(idKendaraanInputPanel2);
        idKendaraanInputPanel2.setLayout(idKendaraanInputPanel2Layout);
        idKendaraanInputPanel2Layout.setHorizontalGroup(
            idKendaraanInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idKendaraanInputPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(idKendaraanInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idKendaraanInputField2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idKendaraanInputLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        idKendaraanInputPanel2Layout.setVerticalGroup(
            idKendaraanInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idKendaraanInputPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(idKendaraanInputLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idKendaraanInputField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        namaKendaraanInputLabel2.setText("Nama");

        javax.swing.GroupLayout namaKendaraanInputPanel2Layout = new javax.swing.GroupLayout(namaKendaraanInputPanel2);
        namaKendaraanInputPanel2.setLayout(namaKendaraanInputPanel2Layout);
        namaKendaraanInputPanel2Layout.setHorizontalGroup(
            namaKendaraanInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaKendaraanInputPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaKendaraanInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(namaKendaraanInputPanel2Layout.createSequentialGroup()
                        .addComponent(namaKendaraanInputLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(namaKendaraanInputField2)))
        );
        namaKendaraanInputPanel2Layout.setVerticalGroup(
            namaKendaraanInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaKendaraanInputPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(namaKendaraanInputLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaKendaraanInputField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        hargaKendaraanInputField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hargaKendaraanInputField2KeyTyped(evt);
            }
        });

        hargaKendaraanInputLabel2.setText("Harga");

        javax.swing.GroupLayout hargaKendaraanInputPanel2Layout = new javax.swing.GroupLayout(hargaKendaraanInputPanel2);
        hargaKendaraanInputPanel2.setLayout(hargaKendaraanInputPanel2Layout);
        hargaKendaraanInputPanel2Layout.setHorizontalGroup(
            hargaKendaraanInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hargaKendaraanInputPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hargaKendaraanInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hargaKendaraanInputField2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaKendaraanInputLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hargaKendaraanInputPanel2Layout.setVerticalGroup(
            hargaKendaraanInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hargaKendaraanInputPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(hargaKendaraanInputLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hargaKendaraanInputField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jenisKendaraanInputLabel2.setText("Jenis Kendaraan");

        jenisKendaraanInputButton2.setText("Mobil");
        jenisKendaraanInputButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisKendaraanInputButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jenisKendaraanInputPanel2Layout = new javax.swing.GroupLayout(jenisKendaraanInputPanel2);
        jenisKendaraanInputPanel2.setLayout(jenisKendaraanInputPanel2Layout);
        jenisKendaraanInputPanel2Layout.setHorizontalGroup(
            jenisKendaraanInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisKendaraanInputPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jenisKendaraanInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jenisKendaraanInputLabel2)
                    .addComponent(jenisKendaraanInputButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jenisKendaraanInputPanel2Layout.setVerticalGroup(
            jenisKendaraanInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisKendaraanInputPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jenisKendaraanInputLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jenisKendaraanInputButton2)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout KendaraanFormPanel4Layout = new javax.swing.GroupLayout(KendaraanFormPanel4);
        KendaraanFormPanel4.setLayout(KendaraanFormPanel4Layout);
        KendaraanFormPanel4Layout.setHorizontalGroup(
            KendaraanFormPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanFormPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(KendaraanFormPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KendaraanButtonPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(KendaraanFormPanel4Layout.createSequentialGroup()
                        .addGroup(KendaraanFormPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(namaKendaraanInputPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idKendaraanInputPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addGroup(KendaraanFormPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hargaKendaraanInputPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(jenisKendaraanInputPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(49, 49, 49))
        );
        KendaraanFormPanel4Layout.setVerticalGroup(
            KendaraanFormPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanFormPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(KendaraanButtonPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(KendaraanFormPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idKendaraanInputPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaKendaraanInputPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(KendaraanFormPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaKendaraanInputPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jenisKendaraanInputPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        specialAttributeInputLabel2.setText("Jenis Mesin");

        javax.swing.GroupLayout specialAttributeInputPanel2Layout = new javax.swing.GroupLayout(specialAttributeInputPanel2);
        specialAttributeInputPanel2.setLayout(specialAttributeInputPanel2Layout);
        specialAttributeInputPanel2Layout.setHorizontalGroup(
            specialAttributeInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialAttributeInputPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(specialAttributeInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(specialAttributeInputField2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specialAttributeInputLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        specialAttributeInputPanel2Layout.setVerticalGroup(
            specialAttributeInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialAttributeInputPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(specialAttributeInputLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specialAttributeInputField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        simpanKendaraanButton2.setText("Simpan");
        simpanKendaraanButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanKendaraanButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KendaraanFormPanel5Layout = new javax.swing.GroupLayout(KendaraanFormPanel5);
        KendaraanFormPanel5.setLayout(KendaraanFormPanel5Layout);
        KendaraanFormPanel5Layout.setHorizontalGroup(
            KendaraanFormPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanFormPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(specialAttributeInputPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(359, 359, 359))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KendaraanFormPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(simpanKendaraanButton2)
                .addGap(36, 36, 36))
        );
        KendaraanFormPanel5Layout.setVerticalGroup(
            KendaraanFormPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanFormPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(specialAttributeInputPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(simpanKendaraanButton2)
                .addGap(37, 37, 37))
        );

        mobilTextArea2.setColumns(20);
        mobilTextArea2.setRows(5);
        mobilScrollPanel2.setViewportView(mobilTextArea2);

        motorTextArea2.setColumns(20);
        motorTextArea2.setRows(5);
        motorScrollPanel2.setViewportView(motorTextArea2);

        javax.swing.GroupLayout kendaraan2Layout = new javax.swing.GroupLayout(kendaraan2);
        kendaraan2.setLayout(kendaraan2Layout);
        kendaraan2Layout.setHorizontalGroup(
            kendaraan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kendaraan2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kendaraan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchKendaraanInputPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kendaraan2Layout.createSequentialGroup()
                        .addGroup(kendaraan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KendaraanFormPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobilScrollPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kendaraan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KendaraanFormPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(motorScrollPanel2))))
                .addContainerGap())
        );
        kendaraan2Layout.setVerticalGroup(
            kendaraan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kendaraan2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchKendaraanInputPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kendaraan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(KendaraanFormPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(KendaraanFormPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kendaraan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mobilScrollPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(motorScrollPanel2))
                .addContainerGap())
        );

        mainTabbedPane2.addTab("Kendaraan", kendaraan2);

        customer2.setBackground(new java.awt.Color(57, 54, 52));

        searchCustomerInputTextField2.setText("Search");
        searchCustomerInputTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCustomerInputTextField2ActionPerformed(evt);
            }
        });
        searchCustomerInputTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchCustomerInputTextField2KeyPressed(evt);
            }
        });

        searchCustomerInputLabel2.setText("Pencarian Customer");

        searchCustomerInputButton2.setText("Cari");
        searchCustomerInputButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCustomerInputButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchCustomerInputPanel2Layout = new javax.swing.GroupLayout(searchCustomerInputPanel2);
        searchCustomerInputPanel2.setLayout(searchCustomerInputPanel2Layout);
        searchCustomerInputPanel2Layout.setHorizontalGroup(
            searchCustomerInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchCustomerInputPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchCustomerInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchCustomerInputPanel2Layout.createSequentialGroup()
                        .addComponent(searchCustomerInputTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 1153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchCustomerInputButton2))
                    .addComponent(searchCustomerInputLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        searchCustomerInputPanel2Layout.setVerticalGroup(
            searchCustomerInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchCustomerInputPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchCustomerInputLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchCustomerInputPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchCustomerInputTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchCustomerInputButton2))
                .addGap(30, 30, 30))
        );

        barukanCustomerButton2.setText("Barukan");
        barukanCustomerButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barukanCustomerButton2ActionPerformed(evt);
            }
        });

        tambahCustomerButton2.setText("Tambah");
        tambahCustomerButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahCustomerButton2ActionPerformed(evt);
            }
        });

        hapusCustomerButton2.setText("Hapus");
        hapusCustomerButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusCustomerButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tambahCustomerButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(barukanCustomerButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hapusCustomerButton2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahCustomerButton2)
                    .addComponent(barukanCustomerButton2)
                    .addComponent(hapusCustomerButton2))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        namaCustomerLabel2.setText("Nama Customer");

        javax.swing.GroupLayout namaCustomerPanel2Layout = new javax.swing.GroupLayout(namaCustomerPanel2);
        namaCustomerPanel2.setLayout(namaCustomerPanel2Layout);
        namaCustomerPanel2Layout.setHorizontalGroup(
            namaCustomerPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaCustomerPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaCustomerPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaCustomerField2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaCustomerLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        namaCustomerPanel2Layout.setVerticalGroup(
            namaCustomerPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaCustomerPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(namaCustomerLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaCustomerField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        nomorTeleponCustomerLabel2.setText("Nomor Telepon");

        javax.swing.GroupLayout nomorTeleponCustomerPanel2Layout = new javax.swing.GroupLayout(nomorTeleponCustomerPanel2);
        nomorTeleponCustomerPanel2.setLayout(nomorTeleponCustomerPanel2Layout);
        nomorTeleponCustomerPanel2Layout.setHorizontalGroup(
            nomorTeleponCustomerPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomorTeleponCustomerPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nomorTeleponCustomerPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nomorTeleponCustomerPanel2Layout.createSequentialGroup()
                        .addComponent(nomorTeleponCustomerLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(nomorTeleponCustomerField2)))
        );
        nomorTeleponCustomerPanel2Layout.setVerticalGroup(
            nomorTeleponCustomerPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomorTeleponCustomerPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(nomorTeleponCustomerLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomorTeleponCustomerField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        alamatCustomerLabel2.setText("Alamat");

        alamatCustomerTextArea2.setColumns(20);
        alamatCustomerTextArea2.setRows(5);
        alamatCustomerPane2.setViewportView(alamatCustomerTextArea2);

        javax.swing.GroupLayout alamatCustomerPanel2Layout = new javax.swing.GroupLayout(alamatCustomerPanel2);
        alamatCustomerPanel2.setLayout(alamatCustomerPanel2Layout);
        alamatCustomerPanel2Layout.setHorizontalGroup(
            alamatCustomerPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alamatCustomerPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(alamatCustomerPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alamatCustomerPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alamatCustomerLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        alamatCustomerPanel2Layout.setVerticalGroup(
            alamatCustomerPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alamatCustomerPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(alamatCustomerLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alamatCustomerPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        customerScrollPane2.setViewportView(customerTextArea2);

        simpanCustomerButton2.setText("Simpan");
        simpanCustomerButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanCustomerButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customerFormPanel2Layout = new javax.swing.GroupLayout(customerFormPanel2);
        customerFormPanel2.setLayout(customerFormPanel2Layout);
        customerFormPanel2Layout.setHorizontalGroup(
            customerFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerFormPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerFormPanel2Layout.createSequentialGroup()
                        .addGroup(customerFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerScrollPane2)
                            .addGroup(customerFormPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(customerFormPanel2Layout.createSequentialGroup()
                        .addGroup(customerFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomorTeleponCustomerPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(namaCustomerPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addComponent(alamatCustomerPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simpanCustomerButton2)
                        .addGap(34, 34, 34))))
        );
        customerFormPanel2Layout.setVerticalGroup(
            customerFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerFormPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(customerFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerFormPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(customerFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(customerFormPanel2Layout.createSequentialGroup()
                                .addComponent(namaCustomerPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nomorTeleponCustomerPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(alamatCustomerPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(customerScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(customerFormPanel2Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(simpanCustomerButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout customer2Layout = new javax.swing.GroupLayout(customer2);
        customer2.setLayout(customer2Layout);
        customer2Layout.setHorizontalGroup(
            customer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customer2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchCustomerInputPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        customer2Layout.setVerticalGroup(
            customer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customer2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchCustomerInputPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabbedPane2.addTab("Customer", customer2);

        kasir2.setBackground(new java.awt.Color(57, 54, 52));

        kasirSearchField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirSearchField2ActionPerformed(evt);
            }
        });
        kasirSearchField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kasirSearchField2KeyPressed(evt);
            }
        });

        kasirSearchButton2.setText("Pencarian Kasir");

        kasirSearchLabel2.setText("Cari");
        kasirSearchLabel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirSearchLabel2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kasirSearchPanel2Layout = new javax.swing.GroupLayout(kasirSearchPanel2);
        kasirSearchPanel2.setLayout(kasirSearchPanel2Layout);
        kasirSearchPanel2Layout.setHorizontalGroup(
            kasirSearchPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirSearchPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kasirSearchPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kasirSearchPanel2Layout.createSequentialGroup()
                        .addComponent(kasirSearchField2, javax.swing.GroupLayout.PREFERRED_SIZE, 1153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kasirSearchLabel2))
                    .addComponent(kasirSearchButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        kasirSearchPanel2Layout.setVerticalGroup(
            kasirSearchPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kasirSearchPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kasirSearchButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kasirSearchPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kasirSearchField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kasirSearchLabel2))
                .addGap(30, 30, 30))
        );

        kasirFormButtonBarukanButton2.setText("Barukan");
        kasirFormButtonBarukanButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirFormButtonBarukanButton2ActionPerformed(evt);
            }
        });

        kasirFormButtonTambahButton2.setText("Tambah");
        kasirFormButtonTambahButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirFormButtonTambahButton2ActionPerformed(evt);
            }
        });

        kasirFormButtonHapusButton2.setText("Hapus");
        kasirFormButtonHapusButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirFormButtonHapusButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kasirFormButtonPanel2Layout = new javax.swing.GroupLayout(kasirFormButtonPanel2);
        kasirFormButtonPanel2.setLayout(kasirFormButtonPanel2Layout);
        kasirFormButtonPanel2Layout.setHorizontalGroup(
            kasirFormButtonPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kasirFormButtonPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kasirFormButtonTambahButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kasirFormButtonBarukanButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kasirFormButtonHapusButton2)
                .addContainerGap())
        );
        kasirFormButtonPanel2Layout.setVerticalGroup(
            kasirFormButtonPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormButtonPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(kasirFormButtonPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kasirFormButtonTambahButton2)
                    .addComponent(kasirFormButtonBarukanButton2)
                    .addComponent(kasirFormButtonHapusButton2))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        kasirFormInputNamaLabel2.setText("Nama Kasir");

        javax.swing.GroupLayout kasirFormInputNamaPanel2Layout = new javax.swing.GroupLayout(kasirFormInputNamaPanel2);
        kasirFormInputNamaPanel2.setLayout(kasirFormInputNamaPanel2Layout);
        kasirFormInputNamaPanel2Layout.setHorizontalGroup(
            kasirFormInputNamaPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputNamaPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kasirFormInputNamaPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kasirFormInputNamaField2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kasirFormInputNamaLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kasirFormInputNamaPanel2Layout.setVerticalGroup(
            kasirFormInputNamaPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputNamaPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(kasirFormInputNamaLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kasirFormInputNamaField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        kasirFormInputShiftLabel2.setText("Shift");

        javax.swing.GroupLayout kasirFormInputShiftPanel2Layout = new javax.swing.GroupLayout(kasirFormInputShiftPanel2);
        kasirFormInputShiftPanel2.setLayout(kasirFormInputShiftPanel2Layout);
        kasirFormInputShiftPanel2Layout.setHorizontalGroup(
            kasirFormInputShiftPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputShiftPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kasirFormInputShiftPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kasirFormInputShiftPanel2Layout.createSequentialGroup()
                        .addComponent(kasirFormInputShiftLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(kasirFormInputShiftField2)))
        );
        kasirFormInputShiftPanel2Layout.setVerticalGroup(
            kasirFormInputShiftPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputShiftPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(kasirFormInputShiftLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kasirFormInputShiftField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        kasirFormInputLoketLabel2.setText("Nomor Loket");

        kasirFormInputLoketScrollPanelTextArea2.setColumns(20);
        kasirFormInputLoketScrollPanelTextArea2.setRows(5);
        kasirFormInputLoketScrollPanel2.setViewportView(kasirFormInputLoketScrollPanelTextArea2);

        javax.swing.GroupLayout kasirFormInputLoketPanel2Layout = new javax.swing.GroupLayout(kasirFormInputLoketPanel2);
        kasirFormInputLoketPanel2.setLayout(kasirFormInputLoketPanel2Layout);
        kasirFormInputLoketPanel2Layout.setHorizontalGroup(
            kasirFormInputLoketPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputLoketPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kasirFormInputLoketPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kasirFormInputLoketScrollPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kasirFormInputLoketLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kasirFormInputLoketPanel2Layout.setVerticalGroup(
            kasirFormInputLoketPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputLoketPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(kasirFormInputLoketLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kasirFormInputLoketScrollPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kasirFormScrollPanel2.setViewportView(kasirFormScrollPanelTextArea2);

        kasirFormSimpanButton2.setText("Simpan");
        kasirFormSimpanButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirFormSimpanButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KasirFormPanel2Layout = new javax.swing.GroupLayout(KasirFormPanel2);
        KasirFormPanel2.setLayout(KasirFormPanel2Layout);
        KasirFormPanel2Layout.setHorizontalGroup(
            KasirFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KasirFormPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(KasirFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KasirFormPanel2Layout.createSequentialGroup()
                        .addGroup(KasirFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kasirFormScrollPanel2)
                            .addGroup(KasirFormPanel2Layout.createSequentialGroup()
                                .addComponent(kasirFormButtonPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(KasirFormPanel2Layout.createSequentialGroup()
                        .addGroup(KasirFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kasirFormInputShiftPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kasirFormInputNamaPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addComponent(kasirFormInputLoketPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kasirFormSimpanButton2)
                        .addGap(34, 34, 34))))
        );
        KasirFormPanel2Layout.setVerticalGroup(
            KasirFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KasirFormPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(kasirFormButtonPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(KasirFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KasirFormPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(KasirFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(KasirFormPanel2Layout.createSequentialGroup()
                                .addComponent(kasirFormInputNamaPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kasirFormInputShiftPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(kasirFormInputLoketPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kasirFormScrollPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(KasirFormPanel2Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(kasirFormSimpanButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout kasir2Layout = new javax.swing.GroupLayout(kasir2);
        kasir2.setLayout(kasir2Layout);
        kasir2Layout.setHorizontalGroup(
            kasir2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasir2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kasir2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kasirSearchPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(KasirFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        kasir2Layout.setVerticalGroup(
            kasir2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasir2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kasirSearchPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KasirFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabbedPane2.addTab("Kasir", kasir2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(146, 127, 116));
        mainPanel.setPreferredSize(new java.awt.Dimension(1280, 720));

        mainTabbedPane.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mainTabbedPaneFocusGained(evt);
            }
        });

        kendaraan.setBackground(new java.awt.Color(57, 54, 52));

        searchKendaraanInputField.setText("Search");
        searchKendaraanInputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchKendaraanInputFieldActionPerformed(evt);
            }
        });
        searchKendaraanInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKendaraanInputFieldKeyPressed(evt);
            }
        });

        searchKendaraanInputLabel.setText("Pencarian Kendaraan");

        searchKendaraanInputButton.setText("Cari");
        searchKendaraanInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchKendaraanInputButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchKendaraanInputPanelLayout = new javax.swing.GroupLayout(searchKendaraanInputPanel);
        searchKendaraanInputPanel.setLayout(searchKendaraanInputPanelLayout);
        searchKendaraanInputPanelLayout.setHorizontalGroup(
            searchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchKendaraanInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchKendaraanInputPanelLayout.createSequentialGroup()
                        .addComponent(searchKendaraanInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 1153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchKendaraanInputButton))
                    .addComponent(searchKendaraanInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        searchKendaraanInputPanelLayout.setVerticalGroup(
            searchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchKendaraanInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchKendaraanInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchKendaraanInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchKendaraanInputButton))
                .addGap(30, 30, 30))
        );

        barukanKendaraanButton.setText("Barukan");
        barukanKendaraanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barukanKendaraanButtonActionPerformed(evt);
            }
        });

        tambahKendaraanButton.setText("Tambah");
        tambahKendaraanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahKendaraanButtonActionPerformed(evt);
            }
        });

        hapusKendaraanButton.setText("Hapus");
        hapusKendaraanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusKendaraanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KendaraanButtonPanelLayout = new javax.swing.GroupLayout(KendaraanButtonPanel);
        KendaraanButtonPanel.setLayout(KendaraanButtonPanelLayout);
        KendaraanButtonPanelLayout.setHorizontalGroup(
            KendaraanButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KendaraanButtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tambahKendaraanButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(barukanKendaraanButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hapusKendaraanButton)
                .addContainerGap())
        );
        KendaraanButtonPanelLayout.setVerticalGroup(
            KendaraanButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanButtonPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(KendaraanButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahKendaraanButton)
                    .addComponent(barukanKendaraanButton)
                    .addComponent(hapusKendaraanButton))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        idKendaraanInputLabel.setText("ID Kendaraan");

        javax.swing.GroupLayout idKendaraanInputPanelLayout = new javax.swing.GroupLayout(idKendaraanInputPanel);
        idKendaraanInputPanel.setLayout(idKendaraanInputPanelLayout);
        idKendaraanInputPanelLayout.setHorizontalGroup(
            idKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idKendaraanInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(idKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idKendaraanInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idKendaraanInputLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        idKendaraanInputPanelLayout.setVerticalGroup(
            idKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(idKendaraanInputPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(idKendaraanInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idKendaraanInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        namaKendaraanInputLabel.setText("Nama");

        javax.swing.GroupLayout namaKendaraanInputPanelLayout = new javax.swing.GroupLayout(namaKendaraanInputPanel);
        namaKendaraanInputPanel.setLayout(namaKendaraanInputPanelLayout);
        namaKendaraanInputPanelLayout.setHorizontalGroup(
            namaKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaKendaraanInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(namaKendaraanInputPanelLayout.createSequentialGroup()
                        .addComponent(namaKendaraanInputLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(namaKendaraanInputField)))
        );
        namaKendaraanInputPanelLayout.setVerticalGroup(
            namaKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaKendaraanInputPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(namaKendaraanInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaKendaraanInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        hargaKendaraanInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hargaKendaraanInputFieldKeyTyped(evt);
            }
        });

        hargaKendaraanInputLabel.setText("Harga");

        javax.swing.GroupLayout hargaKendaraanInputPanelLayout = new javax.swing.GroupLayout(hargaKendaraanInputPanel);
        hargaKendaraanInputPanel.setLayout(hargaKendaraanInputPanelLayout);
        hargaKendaraanInputPanelLayout.setHorizontalGroup(
            hargaKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hargaKendaraanInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hargaKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hargaKendaraanInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaKendaraanInputLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hargaKendaraanInputPanelLayout.setVerticalGroup(
            hargaKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hargaKendaraanInputPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(hargaKendaraanInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hargaKendaraanInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jenisKendaraanInputLabel.setText("Jenis Kendaraan");

        jenisKendaraanInputButton.setText("Mobil");
        jenisKendaraanInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisKendaraanInputButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jenisKendaraanInputPanelLayout = new javax.swing.GroupLayout(jenisKendaraanInputPanel);
        jenisKendaraanInputPanel.setLayout(jenisKendaraanInputPanelLayout);
        jenisKendaraanInputPanelLayout.setHorizontalGroup(
            jenisKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisKendaraanInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jenisKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jenisKendaraanInputLabel)
                    .addComponent(jenisKendaraanInputButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jenisKendaraanInputPanelLayout.setVerticalGroup(
            jenisKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jenisKendaraanInputPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jenisKendaraanInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jenisKendaraanInputButton)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout KendaraanFormPanelLayout = new javax.swing.GroupLayout(KendaraanFormPanel);
        KendaraanFormPanel.setLayout(KendaraanFormPanelLayout);
        KendaraanFormPanelLayout.setHorizontalGroup(
            KendaraanFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(KendaraanFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KendaraanButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(KendaraanFormPanelLayout.createSequentialGroup()
                        .addGroup(KendaraanFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(namaKendaraanInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idKendaraanInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 254, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addGroup(KendaraanFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hargaKendaraanInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(jenisKendaraanInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(49, 49, 49))
        );
        KendaraanFormPanelLayout.setVerticalGroup(
            KendaraanFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanFormPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(KendaraanButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(KendaraanFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idKendaraanInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hargaKendaraanInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(KendaraanFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaKendaraanInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jenisKendaraanInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        specialAttributeInputLabel.setText("Jenis Mesin");

        javax.swing.GroupLayout specialAttributeInputPanelLayout = new javax.swing.GroupLayout(specialAttributeInputPanel);
        specialAttributeInputPanel.setLayout(specialAttributeInputPanelLayout);
        specialAttributeInputPanelLayout.setHorizontalGroup(
            specialAttributeInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialAttributeInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(specialAttributeInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(specialAttributeInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specialAttributeInputLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        specialAttributeInputPanelLayout.setVerticalGroup(
            specialAttributeInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(specialAttributeInputPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(specialAttributeInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specialAttributeInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        simpanKendaraanButton.setText("Simpan");
        simpanKendaraanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanKendaraanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KendaraanFormPanel2Layout = new javax.swing.GroupLayout(KendaraanFormPanel2);
        KendaraanFormPanel2.setLayout(KendaraanFormPanel2Layout);
        KendaraanFormPanel2Layout.setHorizontalGroup(
            KendaraanFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanFormPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(specialAttributeInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(359, 359, 359))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KendaraanFormPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(simpanKendaraanButton)
                .addGap(36, 36, 36))
        );
        KendaraanFormPanel2Layout.setVerticalGroup(
            KendaraanFormPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanFormPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(specialAttributeInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(simpanKendaraanButton)
                .addGap(37, 37, 37))
        );

        mobilTextArea.setColumns(20);
        mobilTextArea.setRows(5);
        mobilScrollPanel.setViewportView(mobilTextArea);

        motorTextArea.setColumns(20);
        motorTextArea.setRows(5);
        motorScrollPanel.setViewportView(motorTextArea);

        javax.swing.GroupLayout kendaraanLayout = new javax.swing.GroupLayout(kendaraan);
        kendaraan.setLayout(kendaraanLayout);
        kendaraanLayout.setHorizontalGroup(
            kendaraanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kendaraanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kendaraanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchKendaraanInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kendaraanLayout.createSequentialGroup()
                        .addGroup(kendaraanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KendaraanFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobilScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kendaraanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KendaraanFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(motorScrollPanel))))
                .addContainerGap())
        );
        kendaraanLayout.setVerticalGroup(
            kendaraanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kendaraanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchKendaraanInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kendaraanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(KendaraanFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(KendaraanFormPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kendaraanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mobilScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(motorScrollPanel))
                .addContainerGap())
        );

        mainTabbedPane.addTab("Kendaraan", kendaraan);

        customer.setBackground(new java.awt.Color(57, 54, 52));

        searchCustomerInputTextField.setText("Search");
        searchCustomerInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCustomerInputTextFieldActionPerformed(evt);
            }
        });
        searchCustomerInputTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchCustomerInputTextFieldKeyPressed(evt);
            }
        });

        searchCustomerInputLabel.setText("Pencarian Customer");

        searchCustomerInputButton.setText("Cari");
        searchCustomerInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCustomerInputButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchCustomerInputPanelLayout = new javax.swing.GroupLayout(searchCustomerInputPanel);
        searchCustomerInputPanel.setLayout(searchCustomerInputPanelLayout);
        searchCustomerInputPanelLayout.setHorizontalGroup(
            searchCustomerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchCustomerInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchCustomerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchCustomerInputPanelLayout.createSequentialGroup()
                        .addComponent(searchCustomerInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 1153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchCustomerInputButton))
                    .addComponent(searchCustomerInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        searchCustomerInputPanelLayout.setVerticalGroup(
            searchCustomerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchCustomerInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchCustomerInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchCustomerInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchCustomerInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchCustomerInputButton))
                .addGap(30, 30, 30))
        );

        barukanCustomerButton.setText("Barukan");
        barukanCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barukanCustomerButtonActionPerformed(evt);
            }
        });

        tambahCustomerButton.setText("Tambah");
        tambahCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahCustomerButtonActionPerformed(evt);
            }
        });

        hapusCustomerButton.setText("Hapus");
        hapusCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusCustomerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tambahCustomerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(barukanCustomerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hapusCustomerButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahCustomerButton)
                    .addComponent(barukanCustomerButton)
                    .addComponent(hapusCustomerButton))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        namaCustomerLabel.setText("Nama Customer");

        javax.swing.GroupLayout namaCustomerPanelLayout = new javax.swing.GroupLayout(namaCustomerPanel);
        namaCustomerPanel.setLayout(namaCustomerPanelLayout);
        namaCustomerPanelLayout.setHorizontalGroup(
            namaCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaCustomerField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaCustomerLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        namaCustomerPanelLayout.setVerticalGroup(
            namaCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaCustomerPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(namaCustomerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaCustomerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        nomorTeleponCustomerLabel.setText("Nomor Telepon");

        javax.swing.GroupLayout nomorTeleponCustomerPanelLayout = new javax.swing.GroupLayout(nomorTeleponCustomerPanel);
        nomorTeleponCustomerPanel.setLayout(nomorTeleponCustomerPanelLayout);
        nomorTeleponCustomerPanelLayout.setHorizontalGroup(
            nomorTeleponCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomorTeleponCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nomorTeleponCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nomorTeleponCustomerPanelLayout.createSequentialGroup()
                        .addComponent(nomorTeleponCustomerLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(nomorTeleponCustomerField)))
        );
        nomorTeleponCustomerPanelLayout.setVerticalGroup(
            nomorTeleponCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nomorTeleponCustomerPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(nomorTeleponCustomerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomorTeleponCustomerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        alamatCustomerLabel.setText("Alamat");

        alamatCustomerTextArea.setColumns(20);
        alamatCustomerTextArea.setRows(5);
        alamatCustomerPane.setViewportView(alamatCustomerTextArea);

        javax.swing.GroupLayout alamatCustomerPanelLayout = new javax.swing.GroupLayout(alamatCustomerPanel);
        alamatCustomerPanel.setLayout(alamatCustomerPanelLayout);
        alamatCustomerPanelLayout.setHorizontalGroup(
            alamatCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alamatCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(alamatCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alamatCustomerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alamatCustomerLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        alamatCustomerPanelLayout.setVerticalGroup(
            alamatCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alamatCustomerPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(alamatCustomerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alamatCustomerPane, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        customerScrollPane.setViewportView(customerTextArea);

        simpanCustomerButton.setText("Simpan");
        simpanCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanCustomerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customerFormPanelLayout = new javax.swing.GroupLayout(customerFormPanel);
        customerFormPanel.setLayout(customerFormPanelLayout);
        customerFormPanelLayout.setHorizontalGroup(
            customerFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerFormPanelLayout.createSequentialGroup()
                        .addGroup(customerFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customerScrollPane)
                            .addGroup(customerFormPanelLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(customerFormPanelLayout.createSequentialGroup()
                        .addGroup(customerFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomorTeleponCustomerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(namaCustomerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 254, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addComponent(alamatCustomerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simpanCustomerButton)
                        .addGap(34, 34, 34))))
        );
        customerFormPanelLayout.setVerticalGroup(
            customerFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerFormPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(customerFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerFormPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(customerFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(customerFormPanelLayout.createSequentialGroup()
                                .addComponent(namaCustomerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nomorTeleponCustomerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(alamatCustomerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(customerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(customerFormPanelLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(simpanCustomerButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout customerLayout = new javax.swing.GroupLayout(customer);
        customer.setLayout(customerLayout);
        customerLayout.setHorizontalGroup(
            customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchCustomerInputPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        customerLayout.setVerticalGroup(
            customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchCustomerInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabbedPane.addTab("Customer", customer);

        kasir.setBackground(new java.awt.Color(57, 54, 52));

        kasirSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirSearchFieldActionPerformed(evt);
            }
        });
        kasirSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kasirSearchFieldKeyPressed(evt);
            }
        });

        kasirSearchButton.setText("Pencarian Kasir");

        kasirSearchLabel.setText("Cari");
        kasirSearchLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirSearchLabelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kasirSearchPanelLayout = new javax.swing.GroupLayout(kasirSearchPanel);
        kasirSearchPanel.setLayout(kasirSearchPanelLayout);
        kasirSearchPanelLayout.setHorizontalGroup(
            kasirSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kasirSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kasirSearchPanelLayout.createSequentialGroup()
                        .addComponent(kasirSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 1153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kasirSearchLabel))
                    .addComponent(kasirSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        kasirSearchPanelLayout.setVerticalGroup(
            kasirSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kasirSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kasirSearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kasirSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kasirSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kasirSearchLabel))
                .addGap(30, 30, 30))
        );

        kasirFormButtonBarukanButton.setText("Barukan");
        kasirFormButtonBarukanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirFormButtonBarukanButtonActionPerformed(evt);
            }
        });

        kasirFormButtonTambahButton.setText("Tambah");
        kasirFormButtonTambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirFormButtonTambahButtonActionPerformed(evt);
            }
        });

        kasirFormButtonHapusButton.setText("Hapus");
        kasirFormButtonHapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirFormButtonHapusButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kasirFormButtonPanelLayout = new javax.swing.GroupLayout(kasirFormButtonPanel);
        kasirFormButtonPanel.setLayout(kasirFormButtonPanelLayout);
        kasirFormButtonPanelLayout.setHorizontalGroup(
            kasirFormButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kasirFormButtonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kasirFormButtonTambahButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kasirFormButtonBarukanButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kasirFormButtonHapusButton)
                .addContainerGap())
        );
        kasirFormButtonPanelLayout.setVerticalGroup(
            kasirFormButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormButtonPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(kasirFormButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kasirFormButtonTambahButton)
                    .addComponent(kasirFormButtonBarukanButton)
                    .addComponent(kasirFormButtonHapusButton))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        kasirFormInputNamaLabel.setText("Nama Kasir");

        javax.swing.GroupLayout kasirFormInputNamaPanelLayout = new javax.swing.GroupLayout(kasirFormInputNamaPanel);
        kasirFormInputNamaPanel.setLayout(kasirFormInputNamaPanelLayout);
        kasirFormInputNamaPanelLayout.setHorizontalGroup(
            kasirFormInputNamaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputNamaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kasirFormInputNamaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kasirFormInputNamaField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kasirFormInputNamaLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kasirFormInputNamaPanelLayout.setVerticalGroup(
            kasirFormInputNamaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputNamaPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(kasirFormInputNamaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kasirFormInputNamaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        kasirFormInputShiftLabel.setText("Shift");

        javax.swing.GroupLayout kasirFormInputShiftPanelLayout = new javax.swing.GroupLayout(kasirFormInputShiftPanel);
        kasirFormInputShiftPanel.setLayout(kasirFormInputShiftPanelLayout);
        kasirFormInputShiftPanelLayout.setHorizontalGroup(
            kasirFormInputShiftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputShiftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kasirFormInputShiftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kasirFormInputShiftPanelLayout.createSequentialGroup()
                        .addComponent(kasirFormInputShiftLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(kasirFormInputShiftField)))
        );
        kasirFormInputShiftPanelLayout.setVerticalGroup(
            kasirFormInputShiftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputShiftPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(kasirFormInputShiftLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kasirFormInputShiftField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        kasirFormInputLoketLabel.setText("Nomor Loket");

        kasirFormInputLoketScrollPanelTextArea.setColumns(20);
        kasirFormInputLoketScrollPanelTextArea.setRows(5);
        kasirFormInputLoketScrollPanel.setViewportView(kasirFormInputLoketScrollPanelTextArea);

        javax.swing.GroupLayout kasirFormInputLoketPanelLayout = new javax.swing.GroupLayout(kasirFormInputLoketPanel);
        kasirFormInputLoketPanel.setLayout(kasirFormInputLoketPanelLayout);
        kasirFormInputLoketPanelLayout.setHorizontalGroup(
            kasirFormInputLoketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputLoketPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kasirFormInputLoketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kasirFormInputLoketScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kasirFormInputLoketLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kasirFormInputLoketPanelLayout.setVerticalGroup(
            kasirFormInputLoketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirFormInputLoketPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(kasirFormInputLoketLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kasirFormInputLoketScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kasirFormScrollPanel.setViewportView(kasirFormScrollPanelTextArea);

        kasirFormSimpanButton.setText("Simpan");
        kasirFormSimpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kasirFormSimpanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KasirFormPanelLayout = new javax.swing.GroupLayout(KasirFormPanel);
        KasirFormPanel.setLayout(KasirFormPanelLayout);
        KasirFormPanelLayout.setHorizontalGroup(
            KasirFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KasirFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(KasirFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KasirFormPanelLayout.createSequentialGroup()
                        .addGroup(KasirFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kasirFormScrollPanel)
                            .addGroup(KasirFormPanelLayout.createSequentialGroup()
                                .addComponent(kasirFormButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(KasirFormPanelLayout.createSequentialGroup()
                        .addGroup(KasirFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kasirFormInputShiftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kasirFormInputNamaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 254, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addComponent(kasirFormInputLoketPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kasirFormSimpanButton)
                        .addGap(34, 34, 34))))
        );
        KasirFormPanelLayout.setVerticalGroup(
            KasirFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KasirFormPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(kasirFormButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(KasirFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KasirFormPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(KasirFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(KasirFormPanelLayout.createSequentialGroup()
                                .addComponent(kasirFormInputNamaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kasirFormInputShiftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(kasirFormInputLoketPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kasirFormScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(KasirFormPanelLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(kasirFormSimpanButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout kasirLayout = new javax.swing.GroupLayout(kasir);
        kasir.setLayout(kasirLayout);
        kasirLayout.setHorizontalGroup(
            kasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kasirSearchPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(KasirFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        kasirLayout.setVerticalGroup(
            kasirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kasirLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kasirSearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KasirFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabbedPane.addTab("Kasir", kasir);

        PaketServis.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PaketServisFocusGained(evt);
            }
        });
        PaketServis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaketServisMouseClicked(evt);
            }
        });
        PaketServis.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                PaketServisComponentShown(evt);
            }
        });

        txtSearchPaketServis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchPaketServisActionPerformed(evt);
            }
        });
        txtSearchPaketServis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchPaketServisKeyPressed(evt);
            }
        });

        lblSearchPaketServis.setText("Pencarian Paket Servis");

        btnSearchPaketServis.setText("Cari");
        btnSearchPaketServis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchPaketServisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SearchPaketServisLayout = new javax.swing.GroupLayout(SearchPaketServis);
        SearchPaketServis.setLayout(SearchPaketServisLayout);
        SearchPaketServisLayout.setHorizontalGroup(
            SearchPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPaketServisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SearchPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchPaketServisLayout.createSequentialGroup()
                        .addComponent(txtSearchPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, 1153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchPaketServis))
                    .addComponent(lblSearchPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        SearchPaketServisLayout.setVerticalGroup(
            SearchPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPaketServisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSearchPaketServis, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SearchPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchPaketServis))
                .addGap(30, 30, 30))
        );

        btnEditPaketServis.setText("Barukan");
        btnEditPaketServis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPaketServisActionPerformed(evt);
            }
        });

        btnAddPaketServis.setText("Tambah");
        btnAddPaketServis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPaketServisActionPerformed(evt);
            }
        });

        btnHapusPaketServis.setText("Hapus");
        btnHapusPaketServis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusPaketServisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ButtonPaketServisLayout = new javax.swing.GroupLayout(ButtonPaketServis);
        ButtonPaketServis.setLayout(ButtonPaketServisLayout);
        ButtonPaketServisLayout.setHorizontalGroup(
            ButtonPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonPaketServisLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddPaketServis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditPaketServis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHapusPaketServis)
                .addContainerGap())
        );
        ButtonPaketServisLayout.setVerticalGroup(
            ButtonPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPaketServisLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(ButtonPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddPaketServis)
                    .addComponent(btnEditPaketServis)
                    .addComponent(btnHapusPaketServis))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        lblIdPaketServis.setText("ID Paket Servis");

        javax.swing.GroupLayout IdPaketServisLayout = new javax.swing.GroupLayout(IdPaketServis);
        IdPaketServis.setLayout(IdPaketServisLayout);
        IdPaketServisLayout.setHorizontalGroup(
            IdPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IdPaketServisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IdPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdPaketServis))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        IdPaketServisLayout.setVerticalGroup(
            IdPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IdPaketServisLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblIdPaketServis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        lblNamaPaketServis.setText("Nama Paket Servis");

        javax.swing.GroupLayout NamaPaketServisLayout = new javax.swing.GroupLayout(NamaPaketServis);
        NamaPaketServis.setLayout(NamaPaketServisLayout);
        NamaPaketServisLayout.setHorizontalGroup(
            NamaPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NamaPaketServisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NamaPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NamaPaketServisLayout.createSequentialGroup()
                        .addComponent(lblNamaPaketServis)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtNamaPaketServis)))
        );
        NamaPaketServisLayout.setVerticalGroup(
            NamaPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NamaPaketServisLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblNamaPaketServis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        txtDurasiPaketServis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDurasiPaketServisKeyTyped(evt);
            }
        });

        lblDurasiPaketServis.setText("Durasi Paket Servis");

        javax.swing.GroupLayout DurasiPaketServisLayout = new javax.swing.GroupLayout(DurasiPaketServis);
        DurasiPaketServis.setLayout(DurasiPaketServisLayout);
        DurasiPaketServisLayout.setHorizontalGroup(
            DurasiPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DurasiPaketServisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DurasiPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDurasiPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDurasiPaketServis))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DurasiPaketServisLayout.setVerticalGroup(
            DurasiPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DurasiPaketServisLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblDurasiPaketServis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDurasiPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        lblJenisPaketServis.setText("Jenis Paket Servis");

        btnJenisPaketServis.setText("Ringan");
        btnJenisPaketServis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJenisPaketServisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JenisPaketServisLayout = new javax.swing.GroupLayout(JenisPaketServis);
        JenisPaketServis.setLayout(JenisPaketServisLayout);
        JenisPaketServisLayout.setHorizontalGroup(
            JenisPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JenisPaketServisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JenisPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJenisPaketServis)
                    .addComponent(btnJenisPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JenisPaketServisLayout.setVerticalGroup(
            JenisPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JenisPaketServisLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblJenisPaketServis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnJenisPaketServis)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FormPaketServis1Layout = new javax.swing.GroupLayout(FormPaketServis1);
        FormPaketServis1.setLayout(FormPaketServis1Layout);
        FormPaketServis1Layout.setHorizontalGroup(
            FormPaketServis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormPaketServis1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FormPaketServis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FormPaketServis1Layout.createSequentialGroup()
                        .addGroup(FormPaketServis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NamaPaketServis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IdPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, 254, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addGroup(FormPaketServis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DurasiPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(JenisPaketServis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(49, 49, 49))
        );
        FormPaketServis1Layout.setVerticalGroup(
            FormPaketServis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormPaketServis1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ButtonPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(FormPaketServis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DurasiPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FormPaketServis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NamaPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JenisPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblSpecialPaketServis.setText("Fasilitas Paket");

        javax.swing.GroupLayout SpecialPaketServisLayout = new javax.swing.GroupLayout(SpecialPaketServis);
        SpecialPaketServis.setLayout(SpecialPaketServisLayout);
        SpecialPaketServisLayout.setHorizontalGroup(
            SpecialPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SpecialPaketServisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SpecialPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSpecialPaketServis)
                    .addGroup(SpecialPaketServisLayout.createSequentialGroup()
                        .addComponent(lblSpecialPaketServis)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        SpecialPaketServisLayout.setVerticalGroup(
            SpecialPaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SpecialPaketServisLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblSpecialPaketServis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSpecialPaketServis, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSavePaketServis.setText("Simpan");
        btnSavePaketServis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePaketServisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FormPaketServis2Layout = new javax.swing.GroupLayout(FormPaketServis2);
        FormPaketServis2.setLayout(FormPaketServis2Layout);
        FormPaketServis2Layout.setHorizontalGroup(
            FormPaketServis2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FormPaketServis2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FormPaketServis2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SpecialPaketServis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(FormPaketServis2Layout.createSequentialGroup()
                        .addGap(0, 534, Short.MAX_VALUE)
                        .addComponent(btnSavePaketServis)))
                .addGap(36, 36, 36))
        );
        FormPaketServis2Layout.setVerticalGroup(
            FormPaketServis2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormPaketServis2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(SpecialPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSavePaketServis)
                .addGap(37, 37, 37))
        );

        txaLengkapPaketServis.setColumns(20);
        txaLengkapPaketServis.setRows(5);
        FormPaketServis3.setViewportView(txaLengkapPaketServis);

        txaRinganPaketServis.setColumns(20);
        txaRinganPaketServis.setRows(5);
        FormPaketServis4.setViewportView(txaRinganPaketServis);

        javax.swing.GroupLayout PaketServisLayout = new javax.swing.GroupLayout(PaketServis);
        PaketServis.setLayout(PaketServisLayout);
        PaketServisLayout.setHorizontalGroup(
            PaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaketServisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchPaketServis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PaketServisLayout.createSequentialGroup()
                        .addGroup(PaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FormPaketServis1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FormPaketServis3, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FormPaketServis2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FormPaketServis4))))
                .addContainerGap())
        );
        PaketServisLayout.setVerticalGroup(
            PaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaketServisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchPaketServis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FormPaketServis1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FormPaketServis2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PaketServisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FormPaketServis3, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(FormPaketServis4))
                .addContainerGap())
        );

        mainTabbedPane.addTab("Paket Servis", PaketServis);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1268, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTabbedPane)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void kasirFormSimpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirFormSimpanButtonActionPerformed
        if (actionKasir == null) {
            return;
        }
        // TODO add your handling code here:

        try {
            Kasir temp = new Kasir(kasirFormInputNamaField.getText(),
                    kasirFormInputShiftField.getText(),
                    Integer.valueOf(kasirFormInputLoketScrollPanelTextArea.getText()));

            int dialog = JOptionPane.showConfirmDialog(rootPane, "Apakah Anda Yakin Ingin Melakukan " + actionKasir + "?");
            if (dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION) {
                return;
            }
            switch (actionKasir) {
                case "update": {
                    kasirC.updateDataKasir(temp, activeKasir.getId_kasir());
                    setComponentKasir(false);
                    showKasir();
                    break;
                }
                case "add": {
                    System.out.println(temp.toString());
                    kasirC.insertDataKasir(temp);
                    clearTextKasir();
                    setComponentKasir(false);
                    showKasir();
                    break;
                }
                case null:
                default: {
                    System.out.println("NO ACTION");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Input Valid Data!");
        }
//        actionKasir = null;
    }//GEN-LAST:event_kasirFormSimpanButtonActionPerformed

    private void kasirFormButtonHapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirFormButtonHapusButtonActionPerformed

        int dialog = JOptionPane.showConfirmDialog(rootPane, "Apakah Anda Yakin Ingin Melakukan DELETE Kasir ?");
        if (dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION) {
            return;
        }
        // TODO add your handling code here:
        int id_kasir = activeKasir.getId_kasir();

        kasirC.deleteDataKasir(id_kasir);
        setComponentKasir(false);
        clearTextKasir();
        showKasir();
    }//GEN-LAST:event_kasirFormButtonHapusButtonActionPerformed

    private void kasirFormButtonTambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirFormButtonTambahButtonActionPerformed
        actionKasir = "add";        // TODO add your handling code here:
        clearTextKasir();
        setComponentKasir(true);
        setKasirButton(true, false, false);
    }//GEN-LAST:event_kasirFormButtonTambahButtonActionPerformed

    private void kasirFormButtonBarukanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirFormButtonBarukanButtonActionPerformed
        actionKasir = "update";
// TODO add your handling code here:
        setComponentKasir(true);

    }//GEN-LAST:event_kasirFormButtonBarukanButtonActionPerformed

    private void kasirSearchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kasirSearchFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_kasirSearchFieldKeyPressed

    private void kasirSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kasirSearchFieldActionPerformed

    private void simpanCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanCustomerButtonActionPerformed
        // TODO add your handling code here:

        try {
            inputKosongCustomerException();
            noTelponException();

            int dialog = JOptionPane.showConfirmDialog(rootPane, "Apakah Anda Yakin Ingin Melakukan " + actionCustomer + "?");

            if (dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION) {
                return;
            }
            switch (actionCustomer) {
                case "add":
                    c = new Customer(namaCustomerField.getText(), nomorTeleponCustomerField.getText(), alamatCustomerTextArea.getText());
                    cc.insertDataCustomer(c);
                    clearTextCustomer();
                    setEditDeleteButtonCustomer(false);
                    setComponentsCustomer(false);
                    break;

                case "update":
                    c = new Customer(namaCustomerField.getText(), nomorTeleponCustomerField.getText(), alamatCustomerTextArea.getText());
                    cc.updateDataCustomer(c, idCustomer);
                    clearTextCustomer();
                    setEditDeleteButtonCustomer(false);
                    setComponentsCustomer(false);
                    break;

                default:
                    break;
            }

            showCustomer();
            actionCustomer = null;

        } catch (InputKosongException e) {
            System.out.println(e);
        } catch (NoTelponException e) {
            JOptionPane.showMessageDialog(rootPane, e.message());
        }
    }//GEN-LAST:event_simpanCustomerButtonActionPerformed

    private void hapusCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusCustomerButtonActionPerformed

        clearTextCustomer();
        setEditDeleteButtonCustomer(false);
        setComponentsCustomer(false);
        int opsi = JOptionPane.showConfirmDialog(rootPane, "Apakah Anda AYkin Ingin Hapus Data?", "Hapus Data", JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.NO_OPTION || opsi == JOptionPane.CLOSED_OPTION) {
            idCustomer = -1;
            return;
        }
        cc.deleteDataCustomer(idCustomer);
        idCustomer = -1;
        showCustomer();

        // TODO add your handling code here:
    }//GEN-LAST:event_hapusCustomerButtonActionPerformed

    private void tambahCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahCustomerButtonActionPerformed
        actionCustomer = "add";
        clearTextCustomer();
        setEditDeleteButtonCustomer(true);
        setComponentsCustomer(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahCustomerButtonActionPerformed

    private void barukanCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barukanCustomerButtonActionPerformed

        actionCustomer = "update";
        setComponentsCustomer(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_barukanCustomerButtonActionPerformed

    private void searchCustomerInputTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchCustomerInputTextFieldKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyChar() == '\n') {
            doSearchCustomer();
        }
    }//GEN-LAST:event_searchCustomerInputTextFieldKeyPressed

    private void searchCustomerInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCustomerInputTextFieldActionPerformed
        // TODO add your handling code here:
        doSearchCustomer();
    }//GEN-LAST:event_searchCustomerInputTextFieldActionPerformed

    private void simpanKendaraanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanKendaraanButtonActionPerformed
        if (actionKendaraan == null) {
            return;
        }
        try {
            inputKosongKendaraanException();
            InputSpecialAttributeKendaraanException();

            int dialog = JOptionPane.showConfirmDialog(rootPane, "Apakah Anda Yakin Ingin Melakukan " + actionKendaraan + "?");
            if (dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION) {
                return;
            }

            switch (actionKendaraan) {
                case "add":
                    if (mobilIsSelected()) {
                        mbl = new Mobil(specialAttributeInputField.getText(), namaKendaraanInputField.getText(),
                                jenisKendaraanInputButton.getText(), Float.parseFloat(hargaKendaraanInputField.getText()));
                        mblc.insertDataKendaraan(mbl);
                    } else {
                        mtr = new Motor(Integer.parseInt(specialAttributeInputField.getText()), namaKendaraanInputField.getText(),
                                jenisKendaraanInputButton.getText(), Float.parseFloat(hargaKendaraanInputField.getText()));
                        mtrc.insertDataKendaraan(mtr);
                    }
                    clearTextKendaraan();
                    setKendaraanEditDeleteButton(false);
                    setComponentsKendaraan(false);
                    showKendaraan();
                    break;

                case "update":
                    if (mobilIsSelected()) {
                        mbl = new Mobil(specialAttributeInputField.getText(), idKendaraanInputField.getText(), namaKendaraanInputField.getText(),
                                jenisKendaraanInputButton.getText(), Float.parseFloat(hargaKendaraanInputField.getText()));
                        mblc.updateDataKendaraan(mbl);
                    } else {
                        mtr = new Motor(Integer.parseInt(specialAttributeInputField.getText()), idKendaraanInputField.getText(), namaKendaraanInputField.getText(),
                                jenisKendaraanInputButton.getText(), Float.parseFloat(hargaKendaraanInputField.getText()));
                        mtrc.updateDataKendaraan(mtr);
                    }
                    clearTextKendaraan();
                    setKendaraanEditDeleteButton(false);
                    setComponentsKendaraan(false);
                    showKendaraan();
                    break;
                default:
                    break;
            }
            actionKendaraan = null;
        } catch (InputKosongException e) {
            JOptionPane.showMessageDialog(rootPane, e.message());
        } catch (InputSpecialAttributeException e) {
            JOptionPane.showMessageDialog(rootPane, e.message(jenisKendaraanInputButton.getText()));
        }
    }//GEN-LAST:event_simpanKendaraanButtonActionPerformed

    private void jenisKendaraanInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisKendaraanInputButtonActionPerformed
        switch (jenisKendaraanInputButton.getText()) {
            case "Mobil":
                jenisKendaraanInputButton.setText("Motor");
                break;
            case "Motor":
                jenisKendaraanInputButton.setText("Mobil");
                break;
        }
        setSpecialAttributeLabel();

        // TODO add your handling code here:
    }//GEN-LAST:event_jenisKendaraanInputButtonActionPerformed

    private void hargaKendaraanInputFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaKendaraanInputFieldKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if (!Character.isDigit(key) || key == '.') {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Input Harus Berupa Angka!", "Input Failure", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_hargaKendaraanInputFieldKeyTyped

    private void hapusKendaraanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusKendaraanButtonActionPerformed
        // TODO add your handling code here:

        int opsi = JOptionPane.showConfirmDialog(rootPane, "Apakah Anda Yakin Ingin Hapus Data?", "Hapus Data", JOptionPane.YES_NO_OPTION);

        if (opsi == JOptionPane.NO_OPTION || opsi == JOptionPane.CLOSED_OPTION) {
            return;
        }

        kc.deleteDataKendaraan(idKendaraanInputField.getText());
        clearTextKendaraan();
        setKendaraanEditDeleteButton(false);
        setComponentsKendaraan(false);
        showKendaraan();
    }//GEN-LAST:event_hapusKendaraanButtonActionPerformed

    private void tambahKendaraanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahKendaraanButtonActionPerformed
        actionKendaraan = "add";

        clearTextKendaraan();
        setKendaraanEditDeleteButton(false);
        setComponentsKendaraan(true);
        setKendaraanEditDeleteButton(false);

        idKendaraanInputField.setEnabled(false);
        idKendaraanInputField.setText(kc.generateId());
        jenisKendaraanInputButton.setText("Mobil");
        setSpecialAttributeLabel();
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahKendaraanButtonActionPerformed

    private void barukanKendaraanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barukanKendaraanButtonActionPerformed
        // TODO add your handling code here:

        actionKendaraan = "update";
        setComponentsKendaraan(true);
        idKendaraanInputField.setEnabled(false);
    }//GEN-LAST:event_barukanKendaraanButtonActionPerformed

    private void searchKendaraanInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchKendaraanInputButtonActionPerformed
        doSearchKendaraan();        // TODO add your handling code here:
    }//GEN-LAST:event_searchKendaraanInputButtonActionPerformed

    private void searchKendaraanInputFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKendaraanInputFieldKeyPressed

        if (evt.getKeyChar() == '\n') {
            doSearchKendaraan();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_searchKendaraanInputFieldKeyPressed

    private void searchKendaraanInputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchKendaraanInputFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKendaraanInputFieldActionPerformed

    private void kasirSearchLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirSearchLabelActionPerformed
        // TODO add your handling code here:
        doSearchKasir();
    }//GEN-LAST:event_kasirSearchLabelActionPerformed

    private void searchCustomerInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCustomerInputButtonActionPerformed

        // TODO add your handling code here:
        doSearchCustomer();
    }//GEN-LAST:event_searchCustomerInputButtonActionPerformed

    private void searchKendaraanInputField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchKendaraanInputField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKendaraanInputField1ActionPerformed

    private void searchKendaraanInputField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKendaraanInputField1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKendaraanInputField1KeyPressed

    private void searchKendaraanInputButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchKendaraanInputButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKendaraanInputButton1ActionPerformed

    private void barukanKendaraanButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barukanKendaraanButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barukanKendaraanButton1ActionPerformed

    private void tambahKendaraanButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahKendaraanButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahKendaraanButton1ActionPerformed

    private void hapusKendaraanButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusKendaraanButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hapusKendaraanButton1ActionPerformed

    private void hargaKendaraanInputField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaKendaraanInputField1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaKendaraanInputField1KeyTyped

    private void jenisKendaraanInputButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisKendaraanInputButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenisKendaraanInputButton1ActionPerformed

    private void simpanKendaraanButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanKendaraanButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_simpanKendaraanButton1ActionPerformed

    private void searchCustomerInputTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCustomerInputTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchCustomerInputTextField1ActionPerformed

    private void searchCustomerInputTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchCustomerInputTextField1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchCustomerInputTextField1KeyPressed

    private void searchCustomerInputButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCustomerInputButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchCustomerInputButton1ActionPerformed

    private void barukanCustomerButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barukanCustomerButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barukanCustomerButton1ActionPerformed

    private void tambahCustomerButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahCustomerButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahCustomerButton1ActionPerformed

    private void hapusCustomerButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusCustomerButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hapusCustomerButton1ActionPerformed

    private void simpanCustomerButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanCustomerButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_simpanCustomerButton1ActionPerformed

    private void kasirSearchField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirSearchField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kasirSearchField1ActionPerformed

    private void kasirSearchField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kasirSearchField1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_kasirSearchField1KeyPressed

    private void kasirSearchLabel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirSearchLabel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kasirSearchLabel1ActionPerformed

    private void kasirFormButtonBarukanButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirFormButtonBarukanButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kasirFormButtonBarukanButton1ActionPerformed

    private void kasirFormButtonTambahButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirFormButtonTambahButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kasirFormButtonTambahButton1ActionPerformed

    private void kasirFormButtonHapusButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirFormButtonHapusButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kasirFormButtonHapusButton1ActionPerformed

    private void kasirFormSimpanButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirFormSimpanButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kasirFormSimpanButton1ActionPerformed

    private void searchKendaraanInputField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchKendaraanInputField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKendaraanInputField2ActionPerformed

    private void searchKendaraanInputField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKendaraanInputField2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKendaraanInputField2KeyPressed

    private void searchKendaraanInputButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchKendaraanInputButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKendaraanInputButton2ActionPerformed

    private void barukanKendaraanButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barukanKendaraanButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barukanKendaraanButton2ActionPerformed

    private void tambahKendaraanButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahKendaraanButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahKendaraanButton2ActionPerformed

    private void hapusKendaraanButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusKendaraanButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hapusKendaraanButton2ActionPerformed

    private void hargaKendaraanInputField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaKendaraanInputField2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaKendaraanInputField2KeyTyped

    private void jenisKendaraanInputButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisKendaraanInputButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenisKendaraanInputButton2ActionPerformed

    private void simpanKendaraanButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanKendaraanButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_simpanKendaraanButton2ActionPerformed

    private void searchCustomerInputTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCustomerInputTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchCustomerInputTextField2ActionPerformed

    private void searchCustomerInputTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchCustomerInputTextField2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchCustomerInputTextField2KeyPressed

    private void searchCustomerInputButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCustomerInputButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchCustomerInputButton2ActionPerformed

    private void barukanCustomerButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barukanCustomerButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barukanCustomerButton2ActionPerformed

    private void tambahCustomerButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahCustomerButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahCustomerButton2ActionPerformed

    private void hapusCustomerButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusCustomerButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hapusCustomerButton2ActionPerformed

    private void simpanCustomerButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanCustomerButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_simpanCustomerButton2ActionPerformed

    private void kasirSearchField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirSearchField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kasirSearchField2ActionPerformed

    private void kasirSearchField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kasirSearchField2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_kasirSearchField2KeyPressed

    private void kasirSearchLabel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirSearchLabel2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kasirSearchLabel2ActionPerformed

    private void kasirFormButtonBarukanButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirFormButtonBarukanButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kasirFormButtonBarukanButton2ActionPerformed

    private void kasirFormButtonTambahButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirFormButtonTambahButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kasirFormButtonTambahButton2ActionPerformed

    private void kasirFormButtonHapusButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirFormButtonHapusButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kasirFormButtonHapusButton2ActionPerformed

    private void kasirFormSimpanButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kasirFormSimpanButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kasirFormSimpanButton2ActionPerformed

    private void txtSearchPaketServisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchPaketServisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchPaketServisActionPerformed

    private void txtSearchPaketServisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchPaketServisKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchPaketServisKeyPressed

    private void btnSearchPaketServisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchPaketServisActionPerformed
        // TODO add your handling code here:
        String search = txtSearchPaketServis.getText();

        ps = psC.search(search);
        if (ps == null) {
            JOptionPane.showMessageDialog(rootPane, "Data Tidak Ditemukan!");
            return;
        }

//        setComponentPaketServis(true);
        showPaketServisField(ps);
        setPaketServisButton(true, true, true);

    }//GEN-LAST:event_btnSearchPaketServisActionPerformed

    private void btnEditPaketServisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPaketServisActionPerformed
        // TODO add your handling code here:

        actionPaketServis = "edit";
        setComponentPaketServis(true);
    }//GEN-LAST:event_btnEditPaketServisActionPerformed

    private void btnAddPaketServisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPaketServisActionPerformed
        actionPaketServis = "add";
        setComponentPaketServis(true);
        ps = null;
        clearTextPaketServis();
        txtIdPaketServis.setText(psC.generateId());
    }//GEN-LAST:event_btnAddPaketServisActionPerformed

    private void btnHapusPaketServisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusPaketServisActionPerformed
        // TODO add your handling code here:

        //KONFIRMASI
        if (JOptionPane.showConfirmDialog(rootPane, "Apakah anda yakin ingin menghapus data?", "Simpan Perubahan", JOptionPane.OK_CANCEL_OPTION) != JOptionPane.OK_OPTION) {

            return;
        } else {

            psC.delete(txtIdPaketServis.getText());
        }
        clearTextPaketServis();
        showPaketServis();
        setComponentPaketServis(false);
        setPaketServisButton(true, false, false);
    }//GEN-LAST:event_btnHapusPaketServisActionPerformed

    private void txtDurasiPaketServisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDurasiPaketServisKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDurasiPaketServisKeyTyped

    private void setSpecialPaketServis() {
        switch (btnJenisPaketServis.getText()) {
            case "Ringan": {
                lblSpecialPaketServis.setText("Layanan Tambahan");
            }
            break;
            case "Lengkap": {
                lblSpecialPaketServis.setText("Fasilitas Paket");
            }
            break;
        }
    }

    private void btnJenisPaketServisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJenisPaketServisActionPerformed
        switch (btnJenisPaketServis.getText()) {
            case "Ringan": {
                btnJenisPaketServis.setText("Lengkap");
                System.out.println(btnJenisPaketServis.getText());
            }
            break;
            case "Lengkap": {
                btnJenisPaketServis.setText("Ringan");
                System.out.println(btnJenisPaketServis.getText());

            }
            break;
        }

        setSpecialPaketServis();
    }//GEN-LAST:event_btnJenisPaketServisActionPerformed

    private void btnSavePaketServisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePaketServisActionPerformed
        // TODO add your handling code here:
        //confirmation dialog
        String dialog = (actionPaketServis.equals("add")) ? "Apakah Anda Yakin ingin menambah data?" : "Apakah Anda Yakin ingin mengubah data?";
        if (JOptionPane.showConfirmDialog(rootPane, dialog, "Simpan Perubahan", JOptionPane.OK_CANCEL_OPTION) != JOptionPane.OK_OPTION) {

            return;
        }

        try {

            switch (actionPaketServis) {
                case "add":
                    if (btnJenisPaketServis.getText().equalsIgnoreCase("ringan")) {
                        PaketRingan x = new PaketRingan(txtIdPaketServis.getText(),
                                txtNamaPaketServis.getText(),
                                btnJenisPaketServis.getText(),
                                Integer.parseInt(txtDurasiPaketServis.getText()),
                                txtSpecialPaketServis.getText()
                        );
                        prC.insert(x);
                    } else if (btnJenisPaketServis.getText().equalsIgnoreCase("lengkap")) {
                        PaketLengkap x = new PaketLengkap(txtIdPaketServis.getText(),
                                txtNamaPaketServis.getText(),
                                btnJenisPaketServis.getText(),
                                Integer.parseInt(txtDurasiPaketServis.getText()),
                                txtSpecialPaketServis.getText()
                        );
                        System.out.println("ini insert paket lengkapp");
                        plC.insert(x);
                    }
                    break;
                case "edit":
                    if (btnJenisPaketServis.getText().equalsIgnoreCase("ringan")) {
                        PaketRingan x = new PaketRingan(txtIdPaketServis.getText(),
                                txtNamaPaketServis.getText(),
                                btnJenisPaketServis.getText(),
                                Integer.parseInt(txtDurasiPaketServis.getText()),
                                txtSpecialPaketServis.getText()
                        );
                        System.out.println("EDIT ENJADI RINGAN");
                        System.out.println(x);
                        prC.update(x);
                    } else if (btnJenisPaketServis.getText().equalsIgnoreCase("lengkap")) {
                        PaketLengkap x = new PaketLengkap(txtIdPaketServis.getText(),
                                txtNamaPaketServis.getText(),
                                btnJenisPaketServis.getText(),
                                Integer.parseInt(txtDurasiPaketServis.getText()),
                                txtSpecialPaketServis.getText()
                        );
                        System.out.println("EDIT ENJADI LENKAP");
                        System.out.println(x);
                        plC.update(x);
                    }

                    break;
            }
        } catch (InputKosongException e) {
            JOptionPane.showMessageDialog(rootPane, "Text field tidak boleh kosong");
            System.err.println(e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Durasi(menit) harus angka bulat!");
            System.err.println(e.getMessage());
        } finally {
            clearTextPaketServis();
            showPaketServis();
            setComponentPaketServis(false);
            setPaketServisButton(true, false, false);
        }
    }//GEN-LAST:event_btnSavePaketServisActionPerformed

    private void mainTabbedPaneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mainTabbedPaneFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_mainTabbedPaneFocusGained

    private void PaketServisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PaketServisFocusGained

        System.out.println("VIEW : PAKET SERVICE");
        showPaketServis();
        // TODO add your handling code here:
    }//GEN-LAST:event_PaketServisFocusGained

    private void PaketServisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaketServisMouseClicked
        // TODO add your handling code here:

        System.out.println("VIEW : PAKET SERVICE");
        showPaketServis();
    }//GEN-LAST:event_PaketServisMouseClicked

    private void PaketServisComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_PaketServisComponentShown

        System.out.println("VIEW : PAKET SERVICE");
        showPaketServis();        // TODO add your handling code here:
    }//GEN-LAST:event_PaketServisComponentShown

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonPaketServis;
    private javax.swing.JPanel DurasiPaketServis;
    private javax.swing.JPanel FormPaketServis1;
    private javax.swing.JPanel FormPaketServis2;
    private javax.swing.JScrollPane FormPaketServis3;
    private javax.swing.JScrollPane FormPaketServis4;
    private javax.swing.JPanel IdPaketServis;
    private javax.swing.JPanel JenisPaketServis;
    private javax.swing.JPanel KasirFormPanel;
    private javax.swing.JPanel KasirFormPanel1;
    private javax.swing.JPanel KasirFormPanel2;
    private javax.swing.JPanel KendaraanButtonPanel;
    private javax.swing.JPanel KendaraanButtonPanel1;
    private javax.swing.JPanel KendaraanButtonPanel2;
    private javax.swing.JPanel KendaraanFormPanel;
    private javax.swing.JPanel KendaraanFormPanel1;
    private javax.swing.JPanel KendaraanFormPanel2;
    private javax.swing.JPanel KendaraanFormPanel3;
    private javax.swing.JPanel KendaraanFormPanel4;
    private javax.swing.JPanel KendaraanFormPanel5;
    private javax.swing.JPanel NamaPaketServis;
    private javax.swing.JPanel PaketServis;
    private javax.swing.JPanel SearchPaketServis;
    private javax.swing.JPanel SpecialPaketServis;
    private javax.swing.JLabel alamatCustomerLabel;
    private javax.swing.JLabel alamatCustomerLabel1;
    private javax.swing.JLabel alamatCustomerLabel2;
    private javax.swing.JScrollPane alamatCustomerPane;
    private javax.swing.JScrollPane alamatCustomerPane1;
    private javax.swing.JScrollPane alamatCustomerPane2;
    private javax.swing.JPanel alamatCustomerPanel;
    private javax.swing.JPanel alamatCustomerPanel1;
    private javax.swing.JPanel alamatCustomerPanel2;
    private javax.swing.JTextArea alamatCustomerTextArea;
    private javax.swing.JTextArea alamatCustomerTextArea1;
    private javax.swing.JTextArea alamatCustomerTextArea2;
    private javax.swing.JButton barukanCustomerButton;
    private javax.swing.JButton barukanCustomerButton1;
    private javax.swing.JButton barukanCustomerButton2;
    private javax.swing.JButton barukanKendaraanButton;
    private javax.swing.JButton barukanKendaraanButton1;
    private javax.swing.JButton barukanKendaraanButton2;
    private javax.swing.JButton btnAddPaketServis;
    private javax.swing.JButton btnEditPaketServis;
    private javax.swing.JButton btnHapusPaketServis;
    private javax.swing.JButton btnJenisPaketServis;
    private javax.swing.JButton btnSavePaketServis;
    private javax.swing.JButton btnSearchPaketServis;
    private javax.swing.JPanel customer;
    private javax.swing.JPanel customer1;
    private javax.swing.JPanel customer2;
    private javax.swing.JPanel customerFormPanel;
    private javax.swing.JPanel customerFormPanel1;
    private javax.swing.JPanel customerFormPanel2;
    private javax.swing.JScrollPane customerScrollPane;
    private javax.swing.JScrollPane customerScrollPane1;
    private javax.swing.JScrollPane customerScrollPane2;
    private javax.swing.JTextPane customerTextArea;
    private javax.swing.JTextPane customerTextArea1;
    private javax.swing.JTextPane customerTextArea2;
    private javax.swing.JButton hapusCustomerButton;
    private javax.swing.JButton hapusCustomerButton1;
    private javax.swing.JButton hapusCustomerButton2;
    private javax.swing.JButton hapusKendaraanButton;
    private javax.swing.JButton hapusKendaraanButton1;
    private javax.swing.JButton hapusKendaraanButton2;
    private javax.swing.JTextField hargaKendaraanInputField;
    private javax.swing.JTextField hargaKendaraanInputField1;
    private javax.swing.JTextField hargaKendaraanInputField2;
    private javax.swing.JLabel hargaKendaraanInputLabel;
    private javax.swing.JLabel hargaKendaraanInputLabel1;
    private javax.swing.JLabel hargaKendaraanInputLabel2;
    private javax.swing.JPanel hargaKendaraanInputPanel;
    private javax.swing.JPanel hargaKendaraanInputPanel1;
    private javax.swing.JPanel hargaKendaraanInputPanel2;
    private javax.swing.JTextField idKendaraanInputField;
    private javax.swing.JTextField idKendaraanInputField1;
    private javax.swing.JTextField idKendaraanInputField2;
    private javax.swing.JLabel idKendaraanInputLabel;
    private javax.swing.JLabel idKendaraanInputLabel1;
    private javax.swing.JLabel idKendaraanInputLabel2;
    private javax.swing.JPanel idKendaraanInputPanel;
    private javax.swing.JPanel idKendaraanInputPanel1;
    private javax.swing.JPanel idKendaraanInputPanel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jenisKendaraanInputButton;
    private javax.swing.JButton jenisKendaraanInputButton1;
    private javax.swing.JButton jenisKendaraanInputButton2;
    private javax.swing.JLabel jenisKendaraanInputLabel;
    private javax.swing.JLabel jenisKendaraanInputLabel1;
    private javax.swing.JLabel jenisKendaraanInputLabel2;
    private javax.swing.JPanel jenisKendaraanInputPanel;
    private javax.swing.JPanel jenisKendaraanInputPanel1;
    private javax.swing.JPanel jenisKendaraanInputPanel2;
    private javax.swing.JPanel kasir;
    private javax.swing.JPanel kasir1;
    private javax.swing.JPanel kasir2;
    private javax.swing.JButton kasirFormButtonBarukanButton;
    private javax.swing.JButton kasirFormButtonBarukanButton1;
    private javax.swing.JButton kasirFormButtonBarukanButton2;
    private javax.swing.JButton kasirFormButtonHapusButton;
    private javax.swing.JButton kasirFormButtonHapusButton1;
    private javax.swing.JButton kasirFormButtonHapusButton2;
    private javax.swing.JPanel kasirFormButtonPanel;
    private javax.swing.JPanel kasirFormButtonPanel1;
    private javax.swing.JPanel kasirFormButtonPanel2;
    private javax.swing.JButton kasirFormButtonTambahButton;
    private javax.swing.JButton kasirFormButtonTambahButton1;
    private javax.swing.JButton kasirFormButtonTambahButton2;
    private javax.swing.JLabel kasirFormInputLoketLabel;
    private javax.swing.JLabel kasirFormInputLoketLabel1;
    private javax.swing.JLabel kasirFormInputLoketLabel2;
    private javax.swing.JPanel kasirFormInputLoketPanel;
    private javax.swing.JPanel kasirFormInputLoketPanel1;
    private javax.swing.JPanel kasirFormInputLoketPanel2;
    private javax.swing.JScrollPane kasirFormInputLoketScrollPanel;
    private javax.swing.JScrollPane kasirFormInputLoketScrollPanel1;
    private javax.swing.JScrollPane kasirFormInputLoketScrollPanel2;
    private javax.swing.JTextArea kasirFormInputLoketScrollPanelTextArea;
    private javax.swing.JTextArea kasirFormInputLoketScrollPanelTextArea1;
    private javax.swing.JTextArea kasirFormInputLoketScrollPanelTextArea2;
    private javax.swing.JTextField kasirFormInputNamaField;
    private javax.swing.JTextField kasirFormInputNamaField1;
    private javax.swing.JTextField kasirFormInputNamaField2;
    private javax.swing.JLabel kasirFormInputNamaLabel;
    private javax.swing.JLabel kasirFormInputNamaLabel1;
    private javax.swing.JLabel kasirFormInputNamaLabel2;
    private javax.swing.JPanel kasirFormInputNamaPanel;
    private javax.swing.JPanel kasirFormInputNamaPanel1;
    private javax.swing.JPanel kasirFormInputNamaPanel2;
    private javax.swing.JTextField kasirFormInputShiftField;
    private javax.swing.JTextField kasirFormInputShiftField1;
    private javax.swing.JTextField kasirFormInputShiftField2;
    private javax.swing.JLabel kasirFormInputShiftLabel;
    private javax.swing.JLabel kasirFormInputShiftLabel1;
    private javax.swing.JLabel kasirFormInputShiftLabel2;
    private javax.swing.JPanel kasirFormInputShiftPanel;
    private javax.swing.JPanel kasirFormInputShiftPanel1;
    private javax.swing.JPanel kasirFormInputShiftPanel2;
    private javax.swing.JScrollPane kasirFormScrollPanel;
    private javax.swing.JScrollPane kasirFormScrollPanel1;
    private javax.swing.JScrollPane kasirFormScrollPanel2;
    private javax.swing.JTextPane kasirFormScrollPanelTextArea;
    private javax.swing.JTextPane kasirFormScrollPanelTextArea1;
    private javax.swing.JTextPane kasirFormScrollPanelTextArea2;
    private javax.swing.JButton kasirFormSimpanButton;
    private javax.swing.JButton kasirFormSimpanButton1;
    private javax.swing.JButton kasirFormSimpanButton2;
    private javax.swing.JLabel kasirSearchButton;
    private javax.swing.JLabel kasirSearchButton1;
    private javax.swing.JLabel kasirSearchButton2;
    private javax.swing.JTextField kasirSearchField;
    private javax.swing.JTextField kasirSearchField1;
    private javax.swing.JTextField kasirSearchField2;
    private javax.swing.JButton kasirSearchLabel;
    private javax.swing.JButton kasirSearchLabel1;
    private javax.swing.JButton kasirSearchLabel2;
    private javax.swing.JPanel kasirSearchPanel;
    private javax.swing.JPanel kasirSearchPanel1;
    private javax.swing.JPanel kasirSearchPanel2;
    private javax.swing.JPanel kendaraan;
    private javax.swing.JPanel kendaraan1;
    private javax.swing.JPanel kendaraan2;
    private javax.swing.JLabel lblDurasiPaketServis;
    private javax.swing.JLabel lblIdPaketServis;
    private javax.swing.JLabel lblJenisPaketServis;
    private javax.swing.JLabel lblNamaPaketServis;
    private javax.swing.JLabel lblSearchPaketServis;
    private javax.swing.JLabel lblSpecialPaketServis;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JTabbedPane mainTabbedPane1;
    private javax.swing.JTabbedPane mainTabbedPane2;
    private javax.swing.JScrollPane mobilScrollPanel;
    private javax.swing.JScrollPane mobilScrollPanel1;
    private javax.swing.JScrollPane mobilScrollPanel2;
    private javax.swing.JTextArea mobilTextArea;
    private javax.swing.JTextArea mobilTextArea1;
    private javax.swing.JTextArea mobilTextArea2;
    private javax.swing.JScrollPane motorScrollPanel;
    private javax.swing.JScrollPane motorScrollPanel1;
    private javax.swing.JScrollPane motorScrollPanel2;
    private javax.swing.JTextArea motorTextArea;
    private javax.swing.JTextArea motorTextArea1;
    private javax.swing.JTextArea motorTextArea2;
    private javax.swing.JTextField namaCustomerField;
    private javax.swing.JTextField namaCustomerField1;
    private javax.swing.JTextField namaCustomerField2;
    private javax.swing.JLabel namaCustomerLabel;
    private javax.swing.JLabel namaCustomerLabel1;
    private javax.swing.JLabel namaCustomerLabel2;
    private javax.swing.JPanel namaCustomerPanel;
    private javax.swing.JPanel namaCustomerPanel1;
    private javax.swing.JPanel namaCustomerPanel2;
    private javax.swing.JTextField namaKendaraanInputField;
    private javax.swing.JTextField namaKendaraanInputField1;
    private javax.swing.JTextField namaKendaraanInputField2;
    private javax.swing.JLabel namaKendaraanInputLabel;
    private javax.swing.JLabel namaKendaraanInputLabel1;
    private javax.swing.JLabel namaKendaraanInputLabel2;
    private javax.swing.JPanel namaKendaraanInputPanel;
    private javax.swing.JPanel namaKendaraanInputPanel1;
    private javax.swing.JPanel namaKendaraanInputPanel2;
    private javax.swing.JTextField nomorTeleponCustomerField;
    private javax.swing.JTextField nomorTeleponCustomerField1;
    private javax.swing.JTextField nomorTeleponCustomerField2;
    private javax.swing.JLabel nomorTeleponCustomerLabel;
    private javax.swing.JLabel nomorTeleponCustomerLabel1;
    private javax.swing.JLabel nomorTeleponCustomerLabel2;
    private javax.swing.JPanel nomorTeleponCustomerPanel;
    private javax.swing.JPanel nomorTeleponCustomerPanel1;
    private javax.swing.JPanel nomorTeleponCustomerPanel2;
    private javax.swing.JButton searchCustomerInputButton;
    private javax.swing.JButton searchCustomerInputButton1;
    private javax.swing.JButton searchCustomerInputButton2;
    private javax.swing.JLabel searchCustomerInputLabel;
    private javax.swing.JLabel searchCustomerInputLabel1;
    private javax.swing.JLabel searchCustomerInputLabel2;
    private javax.swing.JPanel searchCustomerInputPanel;
    private javax.swing.JPanel searchCustomerInputPanel1;
    private javax.swing.JPanel searchCustomerInputPanel2;
    private javax.swing.JTextField searchCustomerInputTextField;
    private javax.swing.JTextField searchCustomerInputTextField1;
    private javax.swing.JTextField searchCustomerInputTextField2;
    private javax.swing.JButton searchKendaraanInputButton;
    private javax.swing.JButton searchKendaraanInputButton1;
    private javax.swing.JButton searchKendaraanInputButton2;
    private javax.swing.JTextField searchKendaraanInputField;
    private javax.swing.JTextField searchKendaraanInputField1;
    private javax.swing.JTextField searchKendaraanInputField2;
    private javax.swing.JLabel searchKendaraanInputLabel;
    private javax.swing.JLabel searchKendaraanInputLabel1;
    private javax.swing.JLabel searchKendaraanInputLabel2;
    private javax.swing.JPanel searchKendaraanInputPanel;
    private javax.swing.JPanel searchKendaraanInputPanel1;
    private javax.swing.JPanel searchKendaraanInputPanel2;
    private javax.swing.JButton simpanCustomerButton;
    private javax.swing.JButton simpanCustomerButton1;
    private javax.swing.JButton simpanCustomerButton2;
    private javax.swing.JButton simpanKendaraanButton;
    private javax.swing.JButton simpanKendaraanButton1;
    private javax.swing.JButton simpanKendaraanButton2;
    private javax.swing.JTextField specialAttributeInputField;
    private javax.swing.JTextField specialAttributeInputField1;
    private javax.swing.JTextField specialAttributeInputField2;
    private javax.swing.JLabel specialAttributeInputLabel;
    private javax.swing.JLabel specialAttributeInputLabel1;
    private javax.swing.JLabel specialAttributeInputLabel2;
    private javax.swing.JPanel specialAttributeInputPanel;
    private javax.swing.JPanel specialAttributeInputPanel1;
    private javax.swing.JPanel specialAttributeInputPanel2;
    private javax.swing.JButton tambahCustomerButton;
    private javax.swing.JButton tambahCustomerButton1;
    private javax.swing.JButton tambahCustomerButton2;
    private javax.swing.JButton tambahKendaraanButton;
    private javax.swing.JButton tambahKendaraanButton1;
    private javax.swing.JButton tambahKendaraanButton2;
    private javax.swing.JTextArea txaLengkapPaketServis;
    private javax.swing.JTextArea txaRinganPaketServis;
    private javax.swing.JTextField txtDurasiPaketServis;
    private javax.swing.JTextField txtIdPaketServis;
    private javax.swing.JTextField txtNamaPaketServis;
    private javax.swing.JTextField txtSearchPaketServis;
    private javax.swing.JTextField txtSpecialPaketServis;
    // End of variables declaration//GEN-END:variables
}
