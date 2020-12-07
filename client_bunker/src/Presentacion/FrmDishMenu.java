package Presentacion;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logicaBD.DBDish;
import static Presentacion.FrmPrincipal.desktop;

public class FrmDishMenu extends javax.swing.JInternalFrame {

    public FrmDishMenu() throws Exception {
        initComponents();
        this.setSize(1142, 504);
        

    }
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    DefaultTableModel model = new DefaultTableModel();

    public static ArrayList<Object[]> orderList = new ArrayList<>();

    public static DefaultTableModel modelPayment = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };

    public void loadDish(String category) throws Exception {
        DBDish dBDish = new DBDish();
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        model.addColumn("ID");
        model.addColumn("ID Category");
        model.addColumn("Categoría");
        model.addColumn("Nombre Plato");
        model.addColumn("Precio Venta");
        model.addColumn("Photo");

        ArrayList<Object[]> data = new ArrayList<>();
        data = dBDish.fillTableDishMenu(category);

        for (int i = 0; i < data.size(); i++) {

            model.addRow(data.get(i));

        }

        tblDish.setModel(model);

        ocultarColumnas();

    }

    public void ocultarColumnas() {
        tblDish.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDish.getColumnModel().getColumn(0).setMinWidth(0);
        tblDish.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblDish.getColumnModel().getColumn(1).setMaxWidth(0);
        tblDish.getColumnModel().getColumn(1).setMinWidth(0);
        tblDish.getColumnModel().getColumn(1).setPreferredWidth(0);
        tblDish.getColumnModel().getColumn(5).setMaxWidth(0);
        tblDish.getColumnModel().getColumn(5).setMinWidth(0);
        tblDish.getColumnModel().getColumn(5).setPreferredWidth(0);
    }

    public void addOrder(int numRow) {

        double dishPryce = Double.parseDouble(String.valueOf(model.getValueAt(numRow, 4)));
        double totalPryce = dishPryce * Integer.parseInt(txtQuantity.getText());
        Object[] obj = new Object[4];
        obj[0] = String.valueOf(model.getValueAt(numRow, 0));
        obj[1] = String.valueOf(model.getValueAt(numRow, 3));
        obj[2] = txtQuantity.getText();
        obj[3] = totalPryce;
        
        if (Integer.parseInt(txtQuantity.getText()) >= 1) {
            if (orderList.add(obj)) {
                JOptionPane.showMessageDialog(rootPane, "Agregado a la Orden");
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se ha Agregado");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Por Favor, Verifique la Cantidad");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDish = new javax.swing.JTable();
        btnMenu = new javax.swing.JButton();
        lblCategory = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        btnOrder = new javax.swing.JButton();
        btnAddOrder = new javax.swing.JButton();
        lblIcon = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Menú");
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Platos"));
        jPanel2.setLayout(null);

        tblDish.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        tblDish.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Categoriía", "Nombre", "Descripción", "Precio"
            }
        ));
        tblDish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDishMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDishMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDish);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 150, 1060, 190);

        btnMenu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/menu.png"))); // NOI18N
        btnMenu.setText("Menú");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel2.add(btnMenu);
        btnMenu.setBounds(30, 390, 130, 41);

        lblCategory.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblCategory.setText("CATEGORIA");
        jPanel2.add(lblCategory);
        lblCategory.setBounds(140, 40, 630, 50);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cantidad:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(620, 400, 90, 20);

        txtQuantity.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtQuantity.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtQuantity.setText("1");
        txtQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtQuantity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtQuantityMouseClicked(evt);
            }
        });
        jPanel2.add(txtQuantity);
        txtQuantity.setBounds(710, 390, 140, 40);

        lblDescription.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDescription.setText("Lo Mejor de la Cocina a tu Servicio.");
        jPanel2.add(lblDescription);
        lblDescription.setBounds(140, 90, 930, 30);

        btnOrder.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/rest.png"))); // NOI18N
        btnOrder.setText("Ir al Pedido");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });
        jPanel2.add(btnOrder);
        btnOrder.setBounds(860, 20, 210, 40);

        btnAddOrder.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAddOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/Facturas.png"))); // NOI18N
        btnAddOrder.setText("Agregar al Pedido");
        btnAddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrderActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddOrder);
        btnAddOrder.setBounds(860, 390, 210, 40);

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/postres.png"))); // NOI18N
        jPanel2.add(lblIcon);
        lblIcon.setBounds(10, 20, 120, 120);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 10, 1090, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        this.dispose();
        FrmPayment form = null;
        try {
            form = new FrmPayment();
        } catch (Exception ex) {
            Logger.getLogger(FrmDishMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dimension size = form.getSize();

        int width = (screenSize.width - size.width) / 2;
        int height = (screenSize.height - size.height) / 3;
        form.setLocation(width, height);
        desktop.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        this.dispose();
        FrmMenu form = new FrmMenu();
        Dimension size = form.getSize();

        int width = (screenSize.width - size.width) / 2;
        int height = (screenSize.height - size.height) / 3;
        form.setLocation(width, height);
        desktop.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void tblDishMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDishMouseClicked

    }//GEN-LAST:event_tblDishMouseClicked

    private void btnAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrderActionPerformed
        int numRow = tblDish.getSelectedRow();
        addOrder(numRow);
        
    }//GEN-LAST:event_btnAddOrderActionPerformed

    private void tblDishMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDishMousePressed
        if (evt.getClickCount() == 2) {

            int row = tblDish.getSelectedRow();
            String dir = String.valueOf(model.getValueAt(row, 5));
            ImageIcon icon = new ImageIcon(dir);
            FrmPhotoVisor form = new FrmPhotoVisor();
            Icon image = new ImageIcon(icon.getImage().getScaledInstance(form.lblPhoto.getWidth(), form.lblPhoto.getHeight(), Image.SCALE_DEFAULT)); //Redimensionamos la Imagen al Tamaño del Label que la Contiene
            form.lblPhoto.setIcon(image);
            form.lblPhoto.repaint();
            form.lblDishName.setText(String.valueOf(model.getValueAt(row, 3)));

            Dimension size = form.getSize();
            int width = (screenSize.width - size.width) / 2;
            int height = (screenSize.height - size.height) / 3;
            form.setLocation(width, height);
            desktop.add(form);
            form.toFront();
            form.setVisible(true);

        }
    }//GEN-LAST:event_tblDishMousePressed

    private void txtQuantityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQuantityMouseClicked
        txtQuantity.selectAll();
    }//GEN-LAST:event_txtQuantityMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddOrder;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblCategory;
    public static javax.swing.JLabel lblDescription;
    public static javax.swing.JLabel lblIcon;
    private javax.swing.JTable tblDish;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
