package panelView;

import control.*;
import Exception.InputKosongException;

import java.util.List;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import javax.swing.table.TableModel;

import model.*;

public class TransaksiMainPanel extends javax.swing.JPanel {

    private PembelianKendaraanControl pembelianController;
    private CustomerControlE customerController;
    private KendaraanControlE kendaraanController;

    //TUGAS
    private KasirControlE kasirController;
    private PaketServisControlE paketServisController;

    private PembelianKendaraan pk = null;
    String action = null;
    int selectedId = 0;

    List<CustomerE> listCustomer;
    List<KendaraanE> listKendaraan;
    List<PaketServisE> listPaketServis;
    List<KasirE> listKasir;
    private Component rootPane;

    //Dropdwn Kendaraan
    public void setKendaraanToDropdown() {
        listKendaraan = kendaraanController.showlistKendaraan();
        System.out.println(listKendaraan.size());

        for (KendaraanE k : listKendaraan) {
            namaKendaraanDropdown.addItem(k.toString());
        }
    }

    //Dropdown Customer
    public void setCustomerToDropdown() {
        listCustomer = customerController.showListCustomer();
        for (CustomerE c : listCustomer) {
            namaCustomerDropdown.addItem(c.toString());
        }
    }

    private void setKasirToDropdown() {
        listKasir = kasirController.showListKasir();
        for (KasirE k : listKasir) {
            namaKasirDropdown.addItem(k.toString());
        }
    }

    private void setPaketServisToDropdown() {
        listPaketServis = paketServisController.showListPaketServis();
        for (PaketServisE i : listPaketServis) {
            namaPaketServisDropdown.addItem(i.toString());
        }

    }

    //Radio Btn
    public void setRadioButtonValue() {
        bcaRadio.setActionCommand("BCA");
        briRadio.setActionCommand("BRI");
        mayRadio.setActionCommand("May Bank");
        bpdRadio.setActionCommand("BPD DIY");
        tunaiRadio.setActionCommand("Tunai");
    }

    //Show Table
    public void showTableBySearch(String target) {
        tablePembelian.setModel(pembelianController.showTable(target));
    }

    //Exception
    public void inputKosongPembelianException() throws InputKosongException {
        if (namaCustomerDropdown.getSelectedIndex() == -1 || namaKendaraanDropdown.getSelectedIndex() == -1
                || jumlahPembelianInput.getText().isEmpty()
                || (!kursiCheckbox.isSelected() && !sistemNavigasiCheckbox.isSelected())
                || metodePembayaranGroup.getSelection().getActionCommand() == null) {
            throw new InputKosongException();
        }
    }

    // RESET
    public void clearText() {
        namaCustomerDropdown.setSelectedIndex(-1);
        namaKendaraanDropdown.setSelectedIndex(-1);
        namaKasirDropdown.setSelectedIndex(-1);
        namaPaketServisDropdown.setSelectedIndex(-1);

        kursiCheckbox.setSelected(false);
        sistemNavigasiCheckbox.setSelected(false);

        metodePembayaranGroup.clearSelection();

        searchTransaksiInputTextField.setText("");
        jumlahPembelianInput.setText("");
    }

    public void setEditDeleteBtn(boolean value) {
        barukanTransaksiButton.setEnabled(value);
        hapusTransaksiButton.setEnabled(value);
    }

    public void setComponent(boolean value) {
        namaCustomerDropdown.setEnabled(value);
        namaKendaraanDropdown.setEnabled(value);
        jumlahPembelianInput.setEnabled(value);
        namaKasirDropdown.setEnabled(value);
        namaPaketServisDropdown.setEnabled(value);
//        tanggalTransaksiInput.setEnabled(value);
        tanggalTransaksiDate.setEnabled(value);
        kursiCheckbox.setEnabled(value);
        sistemNavigasiCheckbox.setEnabled(value);

        simpanTransaksiButton.setEnabled(value);
        batalTransaksiButton.setEnabled(value);
    }

    public void setRadioComponent(boolean value) {
        bcaRadio.setEnabled(value);
        briRadio.setEnabled(value);
        mayRadio.setEnabled(value);
        bpdRadio.setEnabled(value);
        tunaiRadio.setEnabled(value);
    }

    public TransaksiMainPanel() {
        initComponents();
        setOpaque(false);

        pembelianController = new PembelianKendaraanControl();
        customerController = new CustomerControlE();
        kendaraanController = new KendaraanControlE();
        kasirController = new KasirControlE();
        paketServisController = new PaketServisControlE();

        setCustomerToDropdown();
        setKendaraanToDropdown();
        setKasirToDropdown();
        setPaketServisToDropdown();
        setRadioButtonValue();

        showTableBySearch("");

        clearText();
        setComponent(false);
        setRadioComponent(false);
        setEditDeleteBtn(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        metodePembayaranGroup = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        searchTransaksiInputPanel = new javax.swing.JPanel();
        searchTransaksiInputLabel = new javax.swing.JLabel();
        searchTransaksiInputTextField = new javax.swing.JTextField();
        searchTransaksiInputButton = new javax.swing.JButton();
        pembelianScrollPane = new javax.swing.JScrollPane();
        tablePembelian = new javax.swing.JTable();
        transaksiFormPanel = new javax.swing.JPanel();
        transaksiButtonPanel = new javax.swing.JPanel();
        barukanTransaksiButton = new javax.swing.JButton();
        hapusTransaksiButton = new javax.swing.JButton();
        tambahTransaksiButton = new javax.swing.JButton();
        metodePembayaranPanel = new javax.swing.JPanel();
        metodePembayaranLabel = new javax.swing.JLabel();
        bcaRadio = new javax.swing.JRadioButton();
        briRadio = new javax.swing.JRadioButton();
        mayRadio = new javax.swing.JRadioButton();
        bpdRadio = new javax.swing.JRadioButton();
        tunaiRadio = new javax.swing.JRadioButton();
        simpanTransaksiButton = new javax.swing.JButton();
        batalTransaksiButton = new javax.swing.JButton();
        checkBoxPanel = new javax.swing.JPanel();
        atributLabel = new javax.swing.JLabel();
        kursiCheckbox = new javax.swing.JCheckBox();
        sistemNavigasiCheckbox = new javax.swing.JCheckBox();
        Form1 = new javax.swing.JPanel();
        namaCustomerPanel = new javax.swing.JPanel();
        namaCustomerDropdown = new javax.swing.JComboBox<>();
        namaCustomerLabel = new javax.swing.JLabel();
        namaKendaraanPanel = new javax.swing.JPanel();
        namaKendaraanDropdown = new javax.swing.JComboBox<>();
        namaKendaraanLabel = new javax.swing.JLabel();
        jumlahPembelianPanel = new javax.swing.JPanel();
        jumlahPembelianLabel = new javax.swing.JLabel();
        jumlahPembelianInput = new javax.swing.JTextField();
        Form2 = new javax.swing.JPanel();
        namaKasirPanel = new javax.swing.JPanel();
        namaKasirDropdown = new javax.swing.JComboBox<>();
        namaKasirLabel = new javax.swing.JLabel();
        namaPaketServisPanel = new javax.swing.JPanel();
        namaPaketServisDropdown = new javax.swing.JComboBox<>();
        namaPaketServisLabel = new javax.swing.JLabel();
        tanggalTransaksiPanel = new javax.swing.JPanel();
        tanggalTransaksiLabel = new javax.swing.JLabel();
        tanggalTransaksiDate = new com.toedter.calendar.JDateChooser();

        setPreferredSize(new java.awt.Dimension(950, 696));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setMaximumSize(new java.awt.Dimension(700, 32767));
        mainPanel.setPreferredSize(new java.awt.Dimension(700, 518));

        searchTransaksiInputPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchTransaksiInputPanel.setPreferredSize(new java.awt.Dimension(687, 65));

        searchTransaksiInputLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        searchTransaksiInputLabel.setText("Pencarian Transaksi");

        searchTransaksiInputTextField.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        searchTransaksiInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTransaksiInputTextFieldActionPerformed(evt);
            }
        });
        searchTransaksiInputTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTransaksiInputTextFieldKeyPressed(evt);
            }
        });

        searchTransaksiInputButton.setBackground(new java.awt.Color(27, 26, 85));
        searchTransaksiInputButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        searchTransaksiInputButton.setForeground(new java.awt.Color(255, 255, 255));
        searchTransaksiInputButton.setText("Cari");
        searchTransaksiInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTransaksiInputButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchTransaksiInputPanelLayout = new javax.swing.GroupLayout(searchTransaksiInputPanel);
        searchTransaksiInputPanel.setLayout(searchTransaksiInputPanelLayout);
        searchTransaksiInputPanelLayout.setHorizontalGroup(
            searchTransaksiInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchTransaksiInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchTransaksiInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchTransaksiInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(searchTransaksiInputPanelLayout.createSequentialGroup()
                        .addComponent(searchTransaksiInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchTransaksiInputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 251, Short.MAX_VALUE)))
                .addContainerGap())
        );
        searchTransaksiInputPanelLayout.setVerticalGroup(
            searchTransaksiInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchTransaksiInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchTransaksiInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchTransaksiInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchTransaksiInputTextField)
                    .addComponent(searchTransaksiInputButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tablePembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablePembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePembelianMouseClicked(evt);
            }
        });
        pembelianScrollPane.setViewportView(tablePembelian);

        transaksiFormPanel.setBackground(java.awt.Color.white);
        transaksiFormPanel.setMaximumSize(new java.awt.Dimension(700, 700));
        transaksiFormPanel.setPreferredSize(new java.awt.Dimension(700, 642));

        transaksiButtonPanel.setBackground(new java.awt.Color(255, 255, 255));

        barukanTransaksiButton.setBackground(new java.awt.Color(255, 189, 3));
        barukanTransaksiButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        barukanTransaksiButton.setForeground(new java.awt.Color(255, 255, 255));
        barukanTransaksiButton.setText("Barukan");
        barukanTransaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barukanTransaksiButtonActionPerformed(evt);
            }
        });

        hapusTransaksiButton.setBackground(new java.awt.Color(237, 8, 0));
        hapusTransaksiButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        hapusTransaksiButton.setForeground(new java.awt.Color(255, 255, 255));
        hapusTransaksiButton.setText("Hapus");
        hapusTransaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusTransaksiButtonActionPerformed(evt);
            }
        });

        tambahTransaksiButton.setBackground(new java.awt.Color(51, 178, 73));
        tambahTransaksiButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        tambahTransaksiButton.setForeground(new java.awt.Color(255, 255, 255));
        tambahTransaksiButton.setText("Tambah");
        tambahTransaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahTransaksiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout transaksiButtonPanelLayout = new javax.swing.GroupLayout(transaksiButtonPanel);
        transaksiButtonPanel.setLayout(transaksiButtonPanelLayout);
        transaksiButtonPanelLayout.setHorizontalGroup(
            transaksiButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tambahTransaksiButton)
                .addGap(18, 18, 18)
                .addComponent(barukanTransaksiButton)
                .addGap(18, 18, 18)
                .addComponent(hapusTransaksiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        transaksiButtonPanelLayout.setVerticalGroup(
            transaksiButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(transaksiButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barukanTransaksiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahTransaksiButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hapusTransaksiButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        metodePembayaranPanel.setBackground(new java.awt.Color(255, 255, 255));
        metodePembayaranPanel.setForeground(new java.awt.Color(255, 255, 255));

        metodePembayaranLabel.setForeground(java.awt.Color.black);
        metodePembayaranLabel.setText("Metode Pembayaran");

        metodePembayaranGroup.add(bcaRadio);
        bcaRadio.setForeground(java.awt.Color.black);
        bcaRadio.setText("BCA");
        bcaRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcaRadioActionPerformed(evt);
            }
        });

        metodePembayaranGroup.add(briRadio);
        briRadio.setForeground(java.awt.Color.black);
        briRadio.setText("BRI");

        metodePembayaranGroup.add(mayRadio);
        mayRadio.setForeground(java.awt.Color.black);
        mayRadio.setText("May Bank");

        metodePembayaranGroup.add(bpdRadio);
        bpdRadio.setForeground(java.awt.Color.black);
        bpdRadio.setText("BPD DIV");
        bpdRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpdRadioActionPerformed(evt);
            }
        });

        metodePembayaranGroup.add(tunaiRadio);
        tunaiRadio.setForeground(java.awt.Color.black);
        tunaiRadio.setText("Tunai");

        simpanTransaksiButton.setBackground(new java.awt.Color(51, 178, 73));
        simpanTransaksiButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        simpanTransaksiButton.setForeground(new java.awt.Color(255, 255, 255));
        simpanTransaksiButton.setText("Simpan");
        simpanTransaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanTransaksiButtonActionPerformed(evt);
            }
        });

        batalTransaksiButton.setBackground(new java.awt.Color(237, 8, 0));
        batalTransaksiButton.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        batalTransaksiButton.setForeground(new java.awt.Color(255, 255, 255));
        batalTransaksiButton.setText("Batalkan");
        batalTransaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalTransaksiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout metodePembayaranPanelLayout = new javax.swing.GroupLayout(metodePembayaranPanel);
        metodePembayaranPanel.setLayout(metodePembayaranPanelLayout);
        metodePembayaranPanelLayout.setHorizontalGroup(
            metodePembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(metodePembayaranPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(metodePembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(metodePembayaranLabel)
                    .addComponent(bcaRadio)
                    .addComponent(briRadio)
                    .addComponent(mayRadio)
                    .addComponent(bpdRadio)
                    .addComponent(tunaiRadio)
                    .addGroup(metodePembayaranPanelLayout.createSequentialGroup()
                        .addComponent(simpanTransaksiButton)
                        .addGap(20, 20, 20)
                        .addComponent(batalTransaksiButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        metodePembayaranPanelLayout.setVerticalGroup(
            metodePembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(metodePembayaranPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(metodePembayaranLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bcaRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(briRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mayRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bpdRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tunaiRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(metodePembayaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batalTransaksiButton)
                    .addComponent(simpanTransaksiButton))
                .addGap(24, 24, 24))
        );

        checkBoxPanel.setBackground(new java.awt.Color(255, 255, 255));
        checkBoxPanel.setForeground(java.awt.Color.black);

        atributLabel.setForeground(java.awt.Color.black);
        atributLabel.setText("Atribut Tambahan Kendaraan");

        kursiCheckbox.setForeground(java.awt.Color.black);
        kursiCheckbox.setText("Kursi Kulit");

        sistemNavigasiCheckbox.setForeground(java.awt.Color.black);
        sistemNavigasiCheckbox.setText("Sistem Navigasi GPS");

        javax.swing.GroupLayout checkBoxPanelLayout = new javax.swing.GroupLayout(checkBoxPanel);
        checkBoxPanel.setLayout(checkBoxPanelLayout);
        checkBoxPanelLayout.setHorizontalGroup(
            checkBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkBoxPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(checkBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(atributLabel)
                    .addComponent(sistemNavigasiCheckbox)
                    .addComponent(kursiCheckbox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        checkBoxPanelLayout.setVerticalGroup(
            checkBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkBoxPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(atributLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kursiCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sistemNavigasiCheckbox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        namaCustomerPanel.setBackground(new java.awt.Color(255, 255, 255));
        namaCustomerPanel.setForeground(new java.awt.Color(255, 255, 255));
        namaCustomerPanel.setToolTipText("");

        namaCustomerDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaCustomerDropdownActionPerformed(evt);
            }
        });

        namaCustomerLabel.setForeground(new java.awt.Color(0, 0, 0));
        namaCustomerLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        namaCustomerLabel.setText("Nama Customer");

        javax.swing.GroupLayout namaCustomerPanelLayout = new javax.swing.GroupLayout(namaCustomerPanel);
        namaCustomerPanel.setLayout(namaCustomerPanelLayout);
        namaCustomerPanelLayout.setHorizontalGroup(
            namaCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaCustomerDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(namaCustomerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                .addContainerGap())
        );
        namaCustomerPanelLayout.setVerticalGroup(
            namaCustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaCustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namaCustomerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaCustomerDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        namaKendaraanPanel.setBackground(new java.awt.Color(255, 255, 255));
        namaKendaraanPanel.setForeground(new java.awt.Color(255, 255, 255));
        namaKendaraanPanel.setToolTipText("");

        namaKendaraanLabel.setForeground(new java.awt.Color(0, 0, 0));
        namaKendaraanLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        namaKendaraanLabel.setText("Nama Kendaraan");

        javax.swing.GroupLayout namaKendaraanPanelLayout = new javax.swing.GroupLayout(namaKendaraanPanel);
        namaKendaraanPanel.setLayout(namaKendaraanPanelLayout);
        namaKendaraanPanelLayout.setHorizontalGroup(
            namaKendaraanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaKendaraanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaKendaraanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaKendaraanDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(namaKendaraanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                .addContainerGap())
        );
        namaKendaraanPanelLayout.setVerticalGroup(
            namaKendaraanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaKendaraanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namaKendaraanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaKendaraanDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jumlahPembelianPanel.setBackground(new java.awt.Color(255, 255, 255));
        jumlahPembelianPanel.setForeground(new java.awt.Color(255, 255, 255));
        jumlahPembelianPanel.setToolTipText("");

        jumlahPembelianLabel.setForeground(new java.awt.Color(0, 0, 0));
        jumlahPembelianLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jumlahPembelianLabel.setText("Jumlah Pembelian");

        javax.swing.GroupLayout jumlahPembelianPanelLayout = new javax.swing.GroupLayout(jumlahPembelianPanel);
        jumlahPembelianPanel.setLayout(jumlahPembelianPanelLayout);
        jumlahPembelianPanelLayout.setHorizontalGroup(
            jumlahPembelianPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jumlahPembelianPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jumlahPembelianPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jumlahPembelianInput)
                    .addComponent(jumlahPembelianLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jumlahPembelianPanelLayout.setVerticalGroup(
            jumlahPembelianPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jumlahPembelianPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jumlahPembelianLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jumlahPembelianInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Form1Layout = new javax.swing.GroupLayout(Form1);
        Form1.setLayout(Form1Layout);
        Form1Layout.setHorizontalGroup(
            Form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Form1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jumlahPembelianPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(Form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Form1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(Form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(namaCustomerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(namaKendaraanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        Form1Layout.setVerticalGroup(
            Form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Form1Layout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addComponent(jumlahPembelianPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(Form1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Form1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(namaCustomerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(namaKendaraanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(79, Short.MAX_VALUE)))
        );

        namaKasirPanel.setBackground(new java.awt.Color(255, 255, 255));
        namaKasirPanel.setForeground(new java.awt.Color(255, 255, 255));
        namaKasirPanel.setToolTipText("");

        namaKasirDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaKasirDropdownActionPerformed(evt);
            }
        });

        namaKasirLabel.setForeground(new java.awt.Color(0, 0, 0));
        namaKasirLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        namaKasirLabel.setText("Nama Kasir");

        javax.swing.GroupLayout namaKasirPanelLayout = new javax.swing.GroupLayout(namaKasirPanel);
        namaKasirPanel.setLayout(namaKasirPanelLayout);
        namaKasirPanelLayout.setHorizontalGroup(
            namaKasirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaKasirPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaKasirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaKasirDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(namaKasirLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                .addContainerGap())
        );
        namaKasirPanelLayout.setVerticalGroup(
            namaKasirPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaKasirPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namaKasirLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaKasirDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        namaPaketServisPanel.setBackground(new java.awt.Color(255, 255, 255));
        namaPaketServisPanel.setForeground(new java.awt.Color(255, 255, 255));
        namaPaketServisPanel.setToolTipText("");

        namaPaketServisLabel.setForeground(new java.awt.Color(0, 0, 0));
        namaPaketServisLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        namaPaketServisLabel.setText("Nama Paket Servis");

        javax.swing.GroupLayout namaPaketServisPanelLayout = new javax.swing.GroupLayout(namaPaketServisPanel);
        namaPaketServisPanel.setLayout(namaPaketServisPanelLayout);
        namaPaketServisPanelLayout.setHorizontalGroup(
            namaPaketServisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaPaketServisPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(namaPaketServisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaPaketServisDropdown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(namaPaketServisLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                .addContainerGap())
        );
        namaPaketServisPanelLayout.setVerticalGroup(
            namaPaketServisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namaPaketServisPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namaPaketServisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaPaketServisDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tanggalTransaksiPanel.setBackground(new java.awt.Color(255, 255, 255));
        tanggalTransaksiPanel.setForeground(new java.awt.Color(255, 255, 255));
        tanggalTransaksiPanel.setToolTipText("");

        tanggalTransaksiLabel.setForeground(new java.awt.Color(0, 0, 0));
        tanggalTransaksiLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tanggalTransaksiLabel.setText("Tanggal Transaksi");

        tanggalTransaksiDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggalTransaksiDatePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout tanggalTransaksiPanelLayout = new javax.swing.GroupLayout(tanggalTransaksiPanel);
        tanggalTransaksiPanel.setLayout(tanggalTransaksiPanelLayout);
        tanggalTransaksiPanelLayout.setHorizontalGroup(
            tanggalTransaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tanggalTransaksiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tanggalTransaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tanggalTransaksiDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tanggalTransaksiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                .addContainerGap())
        );
        tanggalTransaksiPanelLayout.setVerticalGroup(
            tanggalTransaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tanggalTransaksiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tanggalTransaksiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tanggalTransaksiDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Form2Layout = new javax.swing.GroupLayout(Form2);
        Form2.setLayout(Form2Layout);
        Form2Layout.setHorizontalGroup(
            Form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Form2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tanggalTransaksiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(Form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Form2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(Form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(namaKasirPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(namaPaketServisPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        Form2Layout.setVerticalGroup(
            Form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Form2Layout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addComponent(tanggalTransaksiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(Form2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Form2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(namaKasirPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(namaPaketServisPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(79, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout transaksiFormPanelLayout = new javax.swing.GroupLayout(transaksiFormPanel);
        transaksiFormPanel.setLayout(transaksiFormPanelLayout);
        transaksiFormPanelLayout.setHorizontalGroup(
            transaksiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(transaksiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(transaksiButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(transaksiFormPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Form1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Form2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(checkBoxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(metodePembayaranPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        transaksiFormPanelLayout.setVerticalGroup(
            transaksiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiFormPanelLayout.createSequentialGroup()
                .addComponent(transaksiButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(transaksiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Form1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Form2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(transaksiFormPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(transaksiFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkBoxPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(metodePembayaranPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchTransaksiInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                    .addComponent(pembelianScrollPane)
                    .addComponent(transaksiFormPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchTransaksiInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transaksiFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pembelianScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchTransaksiInputTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTransaksiInputTextFieldKeyPressed

    }//GEN-LAST:event_searchTransaksiInputTextFieldKeyPressed


    private void searchTransaksiInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTransaksiInputButtonActionPerformed

        showTableBySearch(searchTransaksiInputTextField.getText());

        clearText();
        setComponent(false);
        setEditDeleteBtn(false);
        setRadioComponent(false);
        metodePembayaranGroup.clearSelection();

        tambahTransaksiButton.setEnabled(true);

    }//GEN-LAST:event_searchTransaksiInputButtonActionPerformed

    private void barukanTransaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barukanTransaksiButtonActionPerformed

        action = "baharui";
        setComponent(true);
        namaCustomerDropdown.setEnabled(false);
        setEditDeleteBtn(true);
        setRadioComponent(false);

    }//GEN-LAST:event_barukanTransaksiButtonActionPerformed

    private void hapusTransaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusTransaksiButtonActionPerformed

        action = "hapus";
        if (JOptionPane.showConfirmDialog(rootPane, "Yakin ingin melakukan " + action + "?")
                == JOptionPane.CLOSED_OPTION) {
            return;
        }

        pembelianController.deletePembelianKendaraan(selectedId);

        clearText();
        setComponent(false);
        setRadioComponent(false);
        metodePembayaranGroup.clearSelection();
        tambahTransaksiButton.setEnabled(true);

        showTableBySearch("");    }//GEN-LAST:event_hapusTransaksiButtonActionPerformed

    private void tambahTransaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahTransaksiButtonActionPerformed
        action = "tambah";
        selectedId = -1;

        clearText();
        setComponent(true);
        setRadioComponent(true);
        setEditDeleteBtn(false);
        LocalDate today = LocalDate.now();
        String formatted = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        tanggalTransaksiInput.setText(formatted);
        tanggalTransaksiDate.setDate(new Date());


    }//GEN-LAST:event_tambahTransaksiButtonActionPerformed

    private void batalTransaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalTransaksiButtonActionPerformed

        clearText();
        setEditDeleteBtn(false);
        setComponent(false);
        setRadioComponent(false);
        tambahTransaksiButton.setEnabled(true);

    }//GEN-LAST:event_batalTransaksiButtonActionPerformed

    private void searchTransaksiInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTransaksiInputTextFieldActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_searchTransaksiInputTextFieldActionPerformed

    private void bcaRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcaRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bcaRadioActionPerformed

    private void bpdRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpdRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bpdRadioActionPerformed

    private void simpanTransaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanTransaksiButtonActionPerformed
        try {
            inputKosongPembelianException();

            String atribut = "";
            String metodePembayaran = "";

            int selectedIndexCustomer = namaCustomerDropdown.getSelectedIndex();
            CustomerE selectedCustomer = listCustomer.get(selectedIndexCustomer);

            int selectedIndexKendaraan = namaKendaraanDropdown.getSelectedIndex();
            KendaraanE selectedKendaraan = listKendaraan.get(selectedIndexKendaraan);

            int selectedIndexKasir = namaKasirDropdown.getSelectedIndex();
            KasirE selectedKasir = listKasir.get(selectedIndexKasir);

            int selectedIndexPaketServis = namaPaketServisDropdown.getSelectedIndex();
            PaketServisE selecteedPaketServis = listPaketServis.get(selectedIndexPaketServis);

            String formated = new SimpleDateFormat("yyyy-MM-dd").format(tanggalTransaksiDate.getDate());
            LocalDate date = LocalDate.parse(formated, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            double totalHarga = Integer.parseInt(jumlahPembelianInput.getText()) * selectedKendaraan.getHarga();
            if (kursiCheckbox.isSelected() && sistemNavigasiCheckbox.isSelected()) {
                atribut = "Paket Lengkap";
            } else if (kursiCheckbox.isSelected()) {
                atribut = "Tambahan kursi kulit";
            } else {
                atribut = "Tambahan sistem navigasi";
            }

            metodePembayaran = metodePembayaranGroup.getSelection().getActionCommand();
            if (JOptionPane.showConfirmDialog(rootPane, "Total pembayaran yang perlu Anda bayarkan adalah : Rp. " + totalHarga) == JOptionPane.CLOSED_OPTION) {
                return;
            }

            PembelianKendaraan pk = new PembelianKendaraan(
                    Integer.parseInt(jumlahPembelianInput.getText()),
                    atribut,
                    metodePembayaran,
                    selectedCustomer,
                    selectedKendaraan,
                    selectedKasir,
                    selecteedPaketServis,
                    date
            );
            if (action.equals("tambah")) {
                pembelianController.insertDataPembelianKendaraan(pk);
            } else {
                pembelianController.updatePembelianKendaraan(pk, selectedId);
            }

            clearText();
            setComponent(false);
            setRadioComponent(false);
            metodePembayaranGroup.clearSelection();
            tambahTransaksiButton.setEnabled(true);
            showTableBySearch("");
        } catch (InputKosongException e) {
            JOptionPane.showMessageDialog(rootPane, e.message());

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(rootPane, "Input tanggal dengan format yyyy-MM-dd");
        }


    }//GEN-LAST:event_simpanTransaksiButtonActionPerformed

    private void namaCustomerDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaCustomerDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaCustomerDropdownActionPerformed

    private void tablePembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePembelianMouseClicked
        //SEMANGATT

        int indexCustomer = -1, indexKendaraan = -1, indexKasir = -1, indexPaketServis = -1;
        action = "baharui";

        batalTransaksiButton.setEnabled(true);
        simpanTransaksiButton.setEnabled(true);
        setEditDeleteBtn(true);

        setComponent(false);
        setRadioComponent(false);
        metodePembayaranGroup.clearSelection();

        int clickedRow = tablePembelian.getSelectedRow();
        TableModel tableModel = tablePembelian.getModel();

        selectedId = Integer.parseInt(tableModel.getValueAt(clickedRow, 0).toString());
        jumlahPembelianInput.setText(tableModel.getValueAt(clickedRow, 5).toString());
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tableModel.getValueAt(clickedRow, 8).toString());
            tanggalTransaksiDate.setDate(date);
        } catch (Exception e) {
        }
        String metodePembayaran = tableModel.getValueAt(clickedRow, 7).toString();
        String atribut = tableModel.getValueAt(clickedRow, 6).toString();

        switch (metodePembayaran) {
            case "BCA":
                bcaRadio.setSelected(true);
                break;
            case "BRI":
                briRadio.setSelected(true);
                break;
            case "May Bank":
                mayRadio.setSelected(true);
                break;
            case "BPD DIY":
                bpdRadio.setSelected(true);
                break;
            case "Tunai":
                tunaiRadio.setSelected(true);
                break;
        }

        kursiCheckbox.setSelected(false);
        sistemNavigasiCheckbox.setSelected(false);
        System.out.println("ATRIBUT : " + atribut);
        switch (atribut) {

            case "Paket Lengkap":
                kursiCheckbox.setSelected(true);
                sistemNavigasiCheckbox.setSelected(true);
                break;
            case "Tambahan sistem navigasi":
                sistemNavigasiCheckbox.setSelected(true);
                break;
            case "Tambahan kursi kulit":
                kursiCheckbox.setSelected(true);
                break;
        }

        for (CustomerE customer : listCustomer) {
//                System.out.println(tableModel.getValueAt(clickedRow,1).toString());
            if (customer.getNama().equals(tableModel.getValueAt(clickedRow, 1).toString())) {
                indexCustomer = listCustomer.indexOf(customer);
            }
        }

        for (KendaraanE kendaraan : listKendaraan) {
            if (kendaraan.getNama().equals(tableModel.getValueAt(clickedRow, 2).toString())) {
                indexKendaraan = listKendaraan.indexOf(kendaraan);
            }
        }
        for (KasirE kasir : listKasir) {
            if (kasir.getNama_kasir().equals(tableModel.getValueAt(clickedRow, 3))) {
                indexKasir = listKasir.indexOf(kasir);
            }

        }
        for (PaketServisE paket : listPaketServis) {
            if (paket.getNama().equals(tableModel.getValueAt(clickedRow, 4))) {
                indexPaketServis = listPaketServis.indexOf(paket);
            }

        }
        namaCustomerDropdown.setSelectedIndex(indexCustomer);
        namaKendaraanDropdown.setSelectedIndex(indexKendaraan);
        namaKasirDropdown.setSelectedIndex(indexKasir);
        namaPaketServisDropdown.setSelectedIndex(indexPaketServis);
        batalTransaksiButton.setEnabled(true);

    }//GEN-LAST:event_tablePembelianMouseClicked

    private void namaKasirDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaKasirDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaKasirDropdownActionPerformed

    private void tanggalTransaksiDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggalTransaksiDatePropertyChange

    }//GEN-LAST:event_tanggalTransaksiDatePropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Form1;
    private javax.swing.JPanel Form2;
    private javax.swing.JLabel atributLabel;
    private javax.swing.JButton barukanTransaksiButton;
    private javax.swing.JButton batalTransaksiButton;
    private javax.swing.JRadioButton bcaRadio;
    private javax.swing.JRadioButton bpdRadio;
    private javax.swing.JRadioButton briRadio;
    private javax.swing.JPanel checkBoxPanel;
    private javax.swing.JButton hapusTransaksiButton;
    private javax.swing.JTextField jumlahPembelianInput;
    private javax.swing.JLabel jumlahPembelianLabel;
    private javax.swing.JPanel jumlahPembelianPanel;
    private javax.swing.JCheckBox kursiCheckbox;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton mayRadio;
    private javax.swing.ButtonGroup metodePembayaranGroup;
    private javax.swing.JLabel metodePembayaranLabel;
    private javax.swing.JPanel metodePembayaranPanel;
    private javax.swing.JComboBox<String> namaCustomerDropdown;
    private javax.swing.JLabel namaCustomerLabel;
    private javax.swing.JPanel namaCustomerPanel;
    private javax.swing.JComboBox<String> namaKasirDropdown;
    private javax.swing.JLabel namaKasirLabel;
    private javax.swing.JPanel namaKasirPanel;
    private javax.swing.JComboBox<String> namaKendaraanDropdown;
    private javax.swing.JLabel namaKendaraanLabel;
    private javax.swing.JPanel namaKendaraanPanel;
    private javax.swing.JComboBox<String> namaPaketServisDropdown;
    private javax.swing.JLabel namaPaketServisLabel;
    private javax.swing.JPanel namaPaketServisPanel;
    private javax.swing.JScrollPane pembelianScrollPane;
    private javax.swing.JButton searchTransaksiInputButton;
    private javax.swing.JLabel searchTransaksiInputLabel;
    private javax.swing.JPanel searchTransaksiInputPanel;
    private javax.swing.JTextField searchTransaksiInputTextField;
    private javax.swing.JButton simpanTransaksiButton;
    private javax.swing.JCheckBox sistemNavigasiCheckbox;
    private javax.swing.JTable tablePembelian;
    private javax.swing.JButton tambahTransaksiButton;
    private com.toedter.calendar.JDateChooser tanggalTransaksiDate;
    private javax.swing.JLabel tanggalTransaksiLabel;
    private javax.swing.JPanel tanggalTransaksiPanel;
    private javax.swing.JPanel transaksiButtonPanel;
    private javax.swing.JPanel transaksiFormPanel;
    private javax.swing.JRadioButton tunaiRadio;
    // End of variables declaration//GEN-END:variables
}
