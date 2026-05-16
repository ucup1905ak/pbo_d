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

    /**
     * Creates new form MainView
     */
    public mainPanel() {
        initComponents();
        showKendaraan();
        showCustomer();
        showKasir();
        setComponentsKendaraan(false);
        setComponentsCustomer(false);
        setComponentKasir(false);

        setKendaraanEditDeleteButton(false);
        setEditDeleteButtonCustomer(false);
        setKasirButton(true, false, false);

        clearTextKendaraan();
        clearTextCustomer();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(146, 127, 116));
        mainPanel.setPreferredSize(new java.awt.Dimension(1280, 720));

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

        searchKendaraanInputLabel.setText("Pencarian Customer");

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
                            .addComponent(idKendaraanInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addGroup(KendaraanFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hargaKendaraanInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
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
                            .addComponent(namaCustomerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
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
                .addContainerGap(32, Short.MAX_VALUE))
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
                            .addComponent(kasirFormInputNamaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
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

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
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
    private javax.swing.JPanel KasirFormPanel;
    private javax.swing.JPanel KendaraanButtonPanel;
    private javax.swing.JPanel KendaraanFormPanel;
    private javax.swing.JPanel KendaraanFormPanel2;
    private javax.swing.JLabel alamatCustomerLabel;
    private javax.swing.JScrollPane alamatCustomerPane;
    private javax.swing.JPanel alamatCustomerPanel;
    private javax.swing.JTextArea alamatCustomerTextArea;
    private javax.swing.JButton barukanCustomerButton;
    private javax.swing.JButton barukanKendaraanButton;
    private javax.swing.JPanel customer;
    private javax.swing.JPanel customerFormPanel;
    private javax.swing.JScrollPane customerScrollPane;
    private javax.swing.JTextPane customerTextArea;
    private javax.swing.JButton hapusCustomerButton;
    private javax.swing.JButton hapusKendaraanButton;
    private javax.swing.JTextField hargaKendaraanInputField;
    private javax.swing.JLabel hargaKendaraanInputLabel;
    private javax.swing.JPanel hargaKendaraanInputPanel;
    private javax.swing.JTextField idKendaraanInputField;
    private javax.swing.JLabel idKendaraanInputLabel;
    private javax.swing.JPanel idKendaraanInputPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jenisKendaraanInputButton;
    private javax.swing.JLabel jenisKendaraanInputLabel;
    private javax.swing.JPanel jenisKendaraanInputPanel;
    private javax.swing.JPanel kasir;
    private javax.swing.JButton kasirFormButtonBarukanButton;
    private javax.swing.JButton kasirFormButtonHapusButton;
    private javax.swing.JPanel kasirFormButtonPanel;
    private javax.swing.JButton kasirFormButtonTambahButton;
    private javax.swing.JLabel kasirFormInputLoketLabel;
    private javax.swing.JPanel kasirFormInputLoketPanel;
    private javax.swing.JScrollPane kasirFormInputLoketScrollPanel;
    private javax.swing.JTextArea kasirFormInputLoketScrollPanelTextArea;
    private javax.swing.JTextField kasirFormInputNamaField;
    private javax.swing.JLabel kasirFormInputNamaLabel;
    private javax.swing.JPanel kasirFormInputNamaPanel;
    private javax.swing.JTextField kasirFormInputShiftField;
    private javax.swing.JLabel kasirFormInputShiftLabel;
    private javax.swing.JPanel kasirFormInputShiftPanel;
    private javax.swing.JScrollPane kasirFormScrollPanel;
    private javax.swing.JTextPane kasirFormScrollPanelTextArea;
    private javax.swing.JButton kasirFormSimpanButton;
    private javax.swing.JLabel kasirSearchButton;
    private javax.swing.JTextField kasirSearchField;
    private javax.swing.JButton kasirSearchLabel;
    private javax.swing.JPanel kasirSearchPanel;
    private javax.swing.JPanel kendaraan;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JScrollPane mobilScrollPanel;
    private javax.swing.JTextArea mobilTextArea;
    private javax.swing.JScrollPane motorScrollPanel;
    private javax.swing.JTextArea motorTextArea;
    private javax.swing.JTextField namaCustomerField;
    private javax.swing.JLabel namaCustomerLabel;
    private javax.swing.JPanel namaCustomerPanel;
    private javax.swing.JTextField namaKendaraanInputField;
    private javax.swing.JLabel namaKendaraanInputLabel;
    private javax.swing.JPanel namaKendaraanInputPanel;
    private javax.swing.JTextField nomorTeleponCustomerField;
    private javax.swing.JLabel nomorTeleponCustomerLabel;
    private javax.swing.JPanel nomorTeleponCustomerPanel;
    private javax.swing.JButton searchCustomerInputButton;
    private javax.swing.JLabel searchCustomerInputLabel;
    private javax.swing.JPanel searchCustomerInputPanel;
    private javax.swing.JTextField searchCustomerInputTextField;
    private javax.swing.JButton searchKendaraanInputButton;
    private javax.swing.JTextField searchKendaraanInputField;
    private javax.swing.JLabel searchKendaraanInputLabel;
    private javax.swing.JPanel searchKendaraanInputPanel;
    private javax.swing.JButton simpanCustomerButton;
    private javax.swing.JButton simpanKendaraanButton;
    private javax.swing.JTextField specialAttributeInputField;
    private javax.swing.JLabel specialAttributeInputLabel;
    private javax.swing.JPanel specialAttributeInputPanel;
    private javax.swing.JButton tambahCustomerButton;
    private javax.swing.JButton tambahKendaraanButton;
    // End of variables declaration//GEN-END:variables
}
