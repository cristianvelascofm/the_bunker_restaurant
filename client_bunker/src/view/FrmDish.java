package view;

import java.awt.Image;
import java.io.File;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logicaBD.DBCategory;
import logicaBD.DBDish;
import logicaNegocio.Dish;

public class FrmDish extends javax.swing.JInternalFrame {

    public FrmDish() throws Exception {
        initComponents();
        this.setSize(1135, 452);
        txtIdDish.setVisible(false);
        loadCategory();
        loadDish();
    }

    DBDish dBDish = new DBDish();
    DBCategory dBCategory = new DBCategory();

    DecimalFormat format = new DecimalFormat("###,###.##");
    private String dir = "";
    DefaultTableModel model = new DefaultTableModel();

    public void loadCategory() throws Exception {

        cbxCategory.removeAllItems();
        ArrayList<String> category = new ArrayList<>();
        category = dBCategory.category();
        for (int i = 0; i < category.size(); i++) {
            cbxCategory.addItem(category.get(i));
        }

    }

    void loadDish() throws Exception {
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

        data = dBDish.fillTableDish();
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

    void showDish(int numFila) {

        txtIdDish.setText(String.valueOf(model.getValueAt(numFila, 0)));
        cbxCategory.setSelectedItem(String.valueOf(model.getValueAt(numFila, 2)));
        txtDishName.setText(String.valueOf(model.getValueAt(numFila, 3)));
        txtPriceDish.setText(String.valueOf(model.getValueAt(numFila, 4)));
        String directoyTemp = String.valueOf(model.getValueAt(numFila, 5));

        if (directoyTemp != null) {
            ImageIcon icon = new ImageIcon(directoyTemp);
            Icon image = new ImageIcon(icon.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_DEFAULT)); //Redimensionamos la Imagen al Tamaño del Label que la Contiene
            this.lblPhoto.setIcon(image);
            this.repaint();
        }

    }

    void clear() throws Exception {
        loadCategory();
        txtIdDish.setText("");
        txtDishName.setText("");
        txtPriceDish.setText("");
        lblPhoto.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnPhoto = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        txtPriceDish = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDishName = new javax.swing.JTextField();
        cbxCategory = new javax.swing.JComboBox<String>();
        jPanel3 = new javax.swing.JPanel();
        lblPhoto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        txtIdDish = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDish = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Plato");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Plato"));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Categoría:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 40, 70, 17);

        btnPhoto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnPhoto.setText("Seleccionar Foto:");
        btnPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhotoActionPerformed(evt);
            }
        });
        jPanel1.add(btnPhoto);
        btnPhoto.setBounds(10, 180, 150, 30);

        btnUpdate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/actualizar.png"))); // NOI18N
        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);
        btnUpdate.setBounds(350, 350, 120, 30);

        btnSave.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/guardar.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);
        btnSave.setBounds(180, 350, 105, 30);

        txtPriceDish.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(txtPriceDish);
        txtPriceDish.setBounds(170, 130, 310, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Nombre del Plato:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 90, 170, 17);

        txtDishName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(txtDishName);
        txtDishName.setBounds(170, 80, 310, 30);

        cbxCategory.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(cbxCategory);
        cbxCategory.setBounds(170, 30, 310, 30);

        jPanel3.setLayout(null);
        jPanel3.add(lblPhoto);
        lblPhoto.setBounds(0, 0, 310, 160);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(170, 180, 310, 160);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Precio:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 140, 50, 17);

        btnClear.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/nuevo.GIF"))); // NOI18N
        btnClear.setText("Limpiar");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear);
        btnClear.setBounds(10, 350, 100, 30);
        jPanel1.add(txtIdDish);
        txtIdDish.setBounds(70, 10, 30, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 490, 400);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Platos"));
        jPanel2.setLayout(null);

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
        });
        jScrollPane1.setViewportView(tblDish);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 92, 580, 280);

        btnDelete.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/eliminar.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete);
        btnDelete.setBounds(490, 40, 110, 30);

        txtSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });
        jPanel2.add(txtSearch);
        txtSearch.setBounds(80, 40, 380, 30);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Buscar:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 50, 60, 17);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(500, 10, 610, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        Dish dish = new Dish();
        int sel = cbxCategory.getSelectedIndex();
        String category = String.valueOf(cbxCategory.getItemAt(sel));
        if ("Comidas Especiales".equals(category)) {
            dish.setIdCategory(1);
        } else if ("Comidas Rápidas".equals(category)) {
            dish.setIdCategory(2);
        } else if ("Postres".equals(category)) {
            dish.setIdCategory(3);
        } else if ("Bebidas".equals(category)) {
            dish.setIdCategory(4);
        }
        dish.setDishName(txtDishName.getText());
        double price = 0.0;
        try {
            price = format.parse(txtPriceDish.getText()).doubleValue();
        } catch (ParseException ex) {
            Logger.getLogger(FrmDish.class.getName()).log(Level.SEVERE, null, ex);
        }
        dish.setDishPrice(price);
        dish.setPhoto(dir);

        try {
            if (dBDish.addDish(dish) == true) {
                JOptionPane.showMessageDialog(rootPane, "Plato Agregado");
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se ha Poddido Agregar");

            }
        } catch (Exception ex) {
            Logger.getLogger(FrmDish.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            loadDish();
        } catch (Exception ex) {
            Logger.getLogger(FrmDish.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhotoActionPerformed
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(this);
        File archive = file.getSelectedFile();
        if (archive != null) {
            dir = archive.getPath();
            ImageIcon icon = new ImageIcon(dir);
            Icon image = new ImageIcon(icon.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_DEFAULT)); //Redimensionamos la Imagen al Tamaño del Label que la Contiene
            this.lblPhoto.setIcon(image);
            this.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "Por Favor Selecciones una Imagen");
        }
    }//GEN-LAST:event_btnPhotoActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblDishMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDishMouseClicked
        int numFila = tblDish.getSelectedRow();
        showDish(numFila);
    }//GEN-LAST:event_tblDishMouseClicked

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        if (txtSearch.getText().length() == 0) {
            try {
                loadDish();
            } catch (Exception ex) {
                Logger.getLogger(FrmEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

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

            ArrayList<Object[]> datos = new ArrayList<>();

            try {
                datos = dBDish.fillTableDishMenu(txtSearch.getText());
            } catch (Exception ex) {
                Logger.getLogger(FrmDish.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < datos.size(); i++) {

                model.addRow(datos.get(i));

            }
            tblDish.setModel(model);
            ocultarColumnas();
        }
    }//GEN-LAST:event_txtSearchKeyTyped

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (txtIdDish.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Seleccione un Plato a Eliminar");
            tblDish.requestFocus();
            return;
        }
        int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de Eliminar este Plato?", "Confirmar", 2);
        if (confirmacion == 0) {
            Dish dish = new Dish();
            dish.setIdDish(Integer.parseInt(txtIdDish.getText()));
            try {
                dBDish.deleteDish(dish);
            } catch (Exception ex) {
                Logger.getLogger(FrmDish.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(rootPane, "El Plato se ha Eliminado");
            try {
                loadDish();
            } catch (Exception ex) {
                Logger.getLogger(FrmDish.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                clear();
            } catch (Exception ex) {
                Logger.getLogger(FrmDish.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Dish dish = new Dish();
        if (txtIdDish.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un Plato Primero");
        } else {
            dish.setIdDish(Integer.parseInt(txtIdDish.getText()));
        }

        int sel = cbxCategory.getSelectedIndex();
        String category = String.valueOf(cbxCategory.getItemAt(sel));
        if ("Comidas Especiales".equals(category)) {
            dish.setIdCategory(1);
        } else if ("Comidas Rápidas".equals(category)) {
            dish.setIdCategory(2);
        } else if ("Postres".equals(category)) {
            dish.setIdCategory(3);
        } else if ("Bebidas".equals(category)) {
            dish.setIdCategory(4);
        }
        dish.setDishName(txtDishName.getText());
        double price = 0.0;
        try {
            price = format.parse(txtPriceDish.getText()).doubleValue();
        } catch (ParseException ex) {
            Logger.getLogger(FrmDish.class.getName()).log(Level.SEVERE, null, ex);
        }
        dish.setDishPrice(price);
        dish.setPhoto(dir);

        try {
            if (dBDish.updateDish(dish) == true) {
                JOptionPane.showMessageDialog(rootPane, "Plato Actualizado");
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se ha Poddido Actualizar");

            }
        } catch (Exception ex) {
            Logger.getLogger(FrmDish.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            loadDish();
        } catch (Exception ex) {
            Logger.getLogger(FrmDish.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPhoto;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JTable tblDish;
    private javax.swing.JTextField txtDishName;
    private javax.swing.JTextField txtIdDish;
    private javax.swing.JTextField txtPriceDish;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
