package view;

import client.ClientConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MD5;
import model.Employee;

public class FrmEmployee extends javax.swing.JInternalFrame {

    MD5 md5 = new MD5();
    DefaultTableModel modelo = new DefaultTableModel();

    public FrmEmployee() throws Exception {
        initComponents();
        this.setSize(1056, 653);
        try {
            loadTableEmployee();
        } catch (Exception ex) {
            Logger.getLogger(FrmEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        load();
    }

    void load() {
        txtId.setVisible(false);
        txtUser.setEditable(false);
        txtPassword.setEditable(false);
        txtName.requestFocus();
    }

    public void mayuscula(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        String cadena = ("" + c).toUpperCase();
        c = cadena.charAt(0);
        evt.setKeyChar(c);

    }

    //Cargar Tabla
    public void loadTableEmployee() throws Exception {
        ClientConnection socket = new ClientConnection("127.0.0.1", 9000);
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Género");
        modelo.addColumn("Tipo de Documento");
        modelo.addColumn("N° Documento");
        modelo.addColumn("E-mail");
        modelo.addColumn("Login");
        modelo.addColumn("Password");
        modelo.addColumn("Tipo");
        modelo.addColumn("Estado");

        ArrayList<Object[]> data = new ArrayList<>();

        try {
            socket.createConnectionMsg();
            System.out.println("Conexión Establecida");
            data = socket.fillEmployee();

            for (int i = 0; i < data.size(); i++) {

                modelo.addRow(data.get(i));

            }
            tblEmployee.setModel(modelo);
            ocultarColumnas();
            socket.closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(FrmEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void ocultarColumnas() {
        tblEmployee.getColumnModel().getColumn(0).setMaxWidth(0);
        tblEmployee.getColumnModel().getColumn(0).setMinWidth(0);
        tblEmployee.getColumnModel().getColumn(0).setPreferredWidth(0);
        tblEmployee.getColumnModel().getColumn(7).setMaxWidth(0);
        tblEmployee.getColumnModel().getColumn(7).setMinWidth(0);
        tblEmployee.getColumnModel().getColumn(7).setPreferredWidth(0);
        tblEmployee.getColumnModel().getColumn(8).setMaxWidth(0);
        tblEmployee.getColumnModel().getColumn(8).setMinWidth(0);
        tblEmployee.getColumnModel().getColumn(8).setPreferredWidth(0);
        tblEmployee.getColumnModel().getColumn(9).setMaxWidth(0);
        tblEmployee.getColumnModel().getColumn(9).setMinWidth(0);
        tblEmployee.getColumnModel().getColumn(9).setPreferredWidth(0);
        tblEmployee.getColumnModel().getColumn(10).setMaxWidth(0);
        tblEmployee.getColumnModel().getColumn(10).setMinWidth(0);
        tblEmployee.getColumnModel().getColumn(10).setPreferredWidth(0);

    }

    void clear() {
        txtId.setText("");
        txtName.setText("");
        txtLastName.setText("");
        cbxGender.setSelectedItem("Masculino");
        cbxDocumentType.setSelectedItem("Cédula de Ciudadanía");
        txtDocumentNumber.setText("");
        txtEmail.setText("");
        txtUser.setText("");
        txtPassword.setText("");
        cbxEmployeeType.setSelectedItem("Administrador");
        cbxState.setSelectedItem("Activo");

    }

    void showEmployee(int numFila) {

        txtId.setText(String.valueOf(modelo.getValueAt(numFila, 0)));
        txtName.setText(String.valueOf(modelo.getValueAt(numFila, 1)));
        txtLastName.setText(String.valueOf(modelo.getValueAt(numFila, 2)));
        cbxGender.setSelectedItem(String.valueOf(modelo.getValueAt(numFila, 3)));
        cbxDocumentType.setSelectedItem(String.valueOf(modelo.getValueAt(numFila, 4)));
        txtDocumentNumber.setText(String.valueOf(modelo.getValueAt(numFila, 5)));
        txtEmail.setText(String.valueOf(modelo.getValueAt(numFila, 6)));
        txtUser.setText(String.valueOf(modelo.getValueAt(numFila, 7)));
        cbxEmployeeType.setSelectedItem(String.valueOf(modelo.getValueAt(numFila, 9)));
        cbxState.setSelectedItem(String.valueOf(modelo.getValueAt(numFila, 10)));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtDocumentNumber = new javax.swing.JTextField();
        cbxState = new javax.swing.JComboBox<String>();
        txtEmail = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbxDocumentType = new javax.swing.JComboBox<String>();
        cbxEmployeeType = new javax.swing.JComboBox<String>();
        btnClear = new javax.swing.JButton();
        btnUpDate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        cbxGender = new javax.swing.JComboBox<String>();
        jLabel11 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Empleado");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Empleado"));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 50, 60, 17);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 400, 80, 17);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Apellido:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 100, 70, 17);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Tipo de Documento:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 200, 150, 17);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Número de Documento:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 250, 170, 17);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Correo Electrónico:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 300, 130, 17);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Usuario:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 350, 60, 17);

        txtPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(txtPassword);
        txtPassword.setBounds(190, 390, 230, 30);

        txtName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtName);
        txtName.setBounds(190, 40, 230, 30);

        txtLastName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtLastName);
        txtLastName.setBounds(190, 90, 230, 30);

        txtDocumentNumber.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDocumentNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentNumberActionPerformed(evt);
            }
        });
        txtDocumentNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentNumberKeyTyped(evt);
            }
        });
        jPanel1.add(txtDocumentNumber);
        txtDocumentNumber.setBounds(190, 240, 230, 30);

        cbxState.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxState.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));
        cbxState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxStateActionPerformed(evt);
            }
        });
        jPanel1.add(cbxState);
        cbxState.setBounds(190, 490, 230, 30);

        txtEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail);
        txtEmail.setBounds(190, 290, 230, 30);

        txtUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(txtUser);
        txtUser.setBounds(190, 340, 230, 30);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Estado:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 500, 80, 17);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Tipo Empleado:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 450, 120, 17);

        cbxDocumentType.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxDocumentType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cédula de Ciudadanía", "Pasaporte", "Tarjeta de Identidad" }));
        cbxDocumentType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDocumentTypeActionPerformed(evt);
            }
        });
        jPanel1.add(cbxDocumentType);
        cbxDocumentType.setBounds(190, 190, 230, 30);

        cbxEmployeeType.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxEmployeeType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Cocinero", "Mesero", "Limpiador" }));
        cbxEmployeeType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEmployeeTypeActionPerformed(evt);
            }
        });
        jPanel1.add(cbxEmployeeType);
        cbxEmployeeType.setBounds(190, 440, 230, 30);

        btnClear.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/nuevo.GIF"))); // NOI18N
        btnClear.setText("Limpiar");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear);
        btnClear.setBounds(10, 550, 100, 30);

        btnUpDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnUpDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/actualizar.png"))); // NOI18N
        btnUpDate.setText("Actualizar");
        btnUpDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpDateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpDate);
        btnUpDate.setBounds(290, 550, 120, 30);

        btnSave.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/guardar.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);
        btnSave.setBounds(150, 550, 110, 30);

        cbxGender.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));
        cbxGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxGenderActionPerformed(evt);
            }
        });
        jPanel1.add(cbxGender);
        cbxGender.setBounds(190, 140, 230, 30);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Género:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(10, 150, 150, 17);
        jPanel1.add(txtId);
        txtId.setBounds(360, 10, 59, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 430, 600);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleados"));
        jPanel2.setLayout(null);

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployee);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 92, 560, 490);

        btnDelete.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/eliminar.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete);
        btnDelete.setBounds(470, 40, 110, 30);

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
        jPanel2.setBounds(440, 10, 590, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Employee employee = new Employee();
        ClientConnection socket = new ClientConnection("127.0.0.1", 9000);
        employee.setName(txtName.getText());
        employee.setLastName(txtLastName.getText());
        int select = cbxGender.getSelectedIndex();
        employee.setGender((String.valueOf(cbxGender.getItemAt(select))));
        int sel = cbxDocumentType.getSelectedIndex();
        employee.setDocumentType((String.valueOf(cbxDocumentType.getItemAt(sel))));
        employee.setDocumentNumber(txtDocumentNumber.getText());
        employee.setEmail(txtEmail.getText());
        int selct = cbxEmployeeType.getSelectedIndex();
        employee.setEmployeeType((String.valueOf(cbxEmployeeType.getItemAt(selct))));
        employee.setLogin(txtUser.getText());
        employee.setPassword(md5.MD5(txtPassword.getText()));
        int slct = cbxState.getSelectedIndex();
        employee.setState((String.valueOf(cbxState.getItemAt(slct))));

        try {

            socket.createConnectionMsg();
            boolean ans = socket.createEmployee(employee);
            if (ans == true) {
                JOptionPane.showMessageDialog(rootPane, "Registro Exitoso");

            } else {
                JOptionPane.showMessageDialog(rootPane, "No se ha Podido Registrar");
            }
            socket.closeConnection();

        } catch (Exception ex) {
            Logger.getLogger(FrmEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            loadTableEmployee();
        } catch (Exception ex) {
            Logger.getLogger(FrmClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtDocumentNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentNumberActionPerformed
        txtUser.setText(txtDocumentNumber.getText());
        txtPassword.setText(txtDocumentNumber.getText());
        txtEmail.requestFocus();
    }//GEN-LAST:event_txtDocumentNumberActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        txtLastName.requestFocus();
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        cbxGender.requestFocus();
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void cbxGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxGenderActionPerformed
        cbxDocumentType.requestFocus();
    }//GEN-LAST:event_cbxGenderActionPerformed

    private void cbxDocumentTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDocumentTypeActionPerformed
        txtDocumentNumber.requestFocus();
    }//GEN-LAST:event_cbxDocumentTypeActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        cbxEmployeeType.requestFocus();
    }//GEN-LAST:event_txtEmailActionPerformed

    private void cbxEmployeeTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEmployeeTypeActionPerformed
        cbxState.requestFocus();
    }//GEN-LAST:event_cbxEmployeeTypeActionPerformed

    private void cbxStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxStateActionPerformed
        btnSave.requestFocus();
    }//GEN-LAST:event_cbxStateActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        mayuscula(evt);
        if (txtSearch.getText().length() == 0) {
            try {
                loadTableEmployee();
            } catch (Exception ex) {
                Logger.getLogger(FrmEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            ClientConnection socket = new ClientConnection("127.0.0.1", 9000);
            modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int col) {
                    return false;
                }
            };

            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Género");
            modelo.addColumn("Tipo de Documento");
            modelo.addColumn("N° Documento");
            modelo.addColumn("E-mail");
            modelo.addColumn("Login");
            modelo.addColumn("Password");
            modelo.addColumn("Tipo");
            modelo.addColumn("Estado");

            ArrayList<Object[]> data = new ArrayList<>();

            try {
                socket.createConnectionMsg();
                System.out.println("Conexión Establecida");
                data = socket.fillEmployeeSearch(txtSearch.getText());

                for (int i = 0; i < data.size(); i++) {

                    modelo.addRow(data.get(i));

                }
                tblEmployee.setModel(modelo);
                ocultarColumnas();
                socket.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(FrmEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtSearchKeyTyped

    private void txtDocumentNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentNumberKeyTyped
        txtUser.setText(txtDocumentNumber.getText());
        txtPassword.setText(txtDocumentNumber.getText());
    }//GEN-LAST:event_txtDocumentNumberKeyTyped

    private void tblEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeeMouseClicked
        int numFila = tblEmployee.getSelectedRow();
        showEmployee(numFila);
    }//GEN-LAST:event_tblEmployeeMouseClicked

    private void btnUpDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpDateActionPerformed

        
        if (txtId.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un Empleado Primero");
        } else {
            
            Employee employee = new Employee();
            ClientConnection socket = new ClientConnection("127.0.0.1", 9000);
            employee.setIdPerson(Integer.parseInt(txtId.getText()));

            employee.setName(txtName.getText());
            employee.setLastName(txtLastName.getText());
            int select = cbxGender.getSelectedIndex();
            employee.setGender((String.valueOf(cbxGender.getItemAt(select))));
            int sel = cbxDocumentType.getSelectedIndex();
            employee.setDocumentType((String.valueOf(cbxDocumentType.getItemAt(sel))));
            employee.setDocumentNumber(txtDocumentNumber.getText());
            employee.setEmail(txtEmail.getText());
            int selct = cbxEmployeeType.getSelectedIndex();
            employee.setEmployeeType((String.valueOf(cbxEmployeeType.getItemAt(selct))));
            employee.setLogin(txtUser.getText());
            employee.setPassword(md5.MD5(txtPassword.getText()));
            int slct = cbxState.getSelectedIndex();
            employee.setState((String.valueOf(cbxState.getItemAt(slct))));

            try {

                socket.createConnectionMsg();
                boolean ans = socket.updateEmployee(employee);
                if (ans == true) {
                    JOptionPane.showMessageDialog(rootPane, "Actualización Exitoso");

                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se ha Podido Actualizar");
                }
                socket.closeConnection();

            } catch (Exception ex) {
                Logger.getLogger(FrmEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                loadTableEmployee();
            } catch (Exception ex) {
                Logger.getLogger(FrmClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUpDateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (txtId.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Seleccione el Empleado a Eliminar");
            tblEmployee.requestFocus();
            return;
        }
        int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de Eliminar este Empleado?", "Confirmar", 2);
        if (confirmacion == 0) {
            Employee employee = new Employee();
            ClientConnection socket = new ClientConnection("127.0.0.1", 9000);
            int idPerson = Integer.parseInt(txtId.getText());
            employee.setIdPerson(idPerson);
            try {
                socket.createConnectionMsg();
                System.out.println("Conexion establecinda");
                boolean data = socket.deleteEmployee(String.valueOf(idPerson));
                if (data == true) {
                    JOptionPane.showMessageDialog(rootPane, "Eliminado");

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Imposible Eliminar");
                }
                socket.closeConnection();
            } catch (Exception ex) {
                Logger.getLogger(FrmEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            try {
                loadTableEmployee();
            } catch (Exception ex) {
                Logger.getLogger(FrmEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
            clear();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpDate;
    private javax.swing.JComboBox<String> cbxDocumentType;
    private javax.swing.JComboBox<String> cbxEmployeeType;
    private javax.swing.JComboBox<String> cbxGender;
    private javax.swing.JComboBox<String> cbxState;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTextField txtDocumentNumber;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
