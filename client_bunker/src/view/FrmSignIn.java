package view;

import client.ClientConnection;
import model.Client;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logicaBD.DBClient;
import model.MD5;

public class FrmSignIn extends javax.swing.JFrame {

    MD5 md5 = new MD5();
    DBClient dBClient = new DBClient();

    public FrmSignIn() {
        initComponents();
        this.setSize(465, 545);
        this.setLocationRelativeTo(null);
    }

    void clear() {

        txtName.setText("");
        txtLastName.setText("");
        cbxGender.setSelectedItem("Masculino");
        cbxDocumentType.setSelectedItem("Cédula de Ciudadanía");
        txtDocumentNumber.setText("");
        txtEmail.setText("");
        txtUser.setText("");
        txtPassword.setText("");

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
        txtEmail = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        cbxDocumentType = new javax.swing.JComboBox<String>();
        btnUpDate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        cbxGender = new javax.swing.JComboBox<String>();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrarse");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro"));
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
        jPanel1.add(txtDocumentNumber);
        txtDocumentNumber.setBounds(190, 240, 230, 30);

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

        cbxDocumentType.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxDocumentType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cédula de Ciudadanía", "Pasaporte", "Tarjeta de Identidad" }));
        cbxDocumentType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDocumentTypeActionPerformed(evt);
            }
        });
        jPanel1.add(cbxDocumentType);
        cbxDocumentType.setBounds(190, 190, 230, 30);

        btnUpDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnUpDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/cancelar.png"))); // NOI18N
        btnUpDate.setText("Cancelar");
        btnUpDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpDateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpDate);
        btnUpDate.setBounds(10, 440, 150, 40);

        btnSave.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/Cliente.png"))); // NOI18N
        btnSave.setText("Registrarse");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);
        btnSave.setBounds(260, 440, 150, 40);

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

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 430, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        txtLastName.requestFocus();
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        cbxGender.requestFocus();
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void txtDocumentNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentNumberActionPerformed
        txtUser.setText(txtDocumentNumber.getText());
        txtPassword.setText(txtDocumentNumber.getText());
        txtEmail.requestFocus();
    }//GEN-LAST:event_txtDocumentNumberActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed

    }//GEN-LAST:event_txtEmailActionPerformed

    private void cbxDocumentTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDocumentTypeActionPerformed
        txtDocumentNumber.requestFocus();
    }//GEN-LAST:event_cbxDocumentTypeActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Client client = new Client();
        ClientConnection socket = new ClientConnection("127.0.0.1", 9000);

        client.setName(txtName.getText());
        client.setLastName(txtLastName.getText());
        int select = cbxGender.getSelectedIndex();
        client.setGender((String.valueOf(cbxGender.getItemAt(select))));
        int sel = cbxDocumentType.getSelectedIndex();
        client.setDocumentType((String.valueOf(cbxDocumentType.getItemAt(sel))));
        client.setDocumentNumber(txtDocumentNumber.getText());
        client.setEmail(txtEmail.getText());

        client.setLogin(txtUser.getText());
        client.setPassword(md5.MD5(txtPassword.getText()));

        try {

            socket.createConnectionMsg();
            boolean ans = socket.createClient(client);
            if (ans == true) {
                JOptionPane.showMessageDialog(rootPane, "Registro Exitoso");

            } else {
                JOptionPane.showMessageDialog(rootPane, "No se ha Podido Registrar");
            }
            socket.closeConnection();

        } catch (Exception ex) {
            Logger.getLogger(FrmEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.dispose();
        FrmLogin form = new FrmLogin();
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbxGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxGenderActionPerformed
        cbxDocumentType.requestFocus();
    }//GEN-LAST:event_cbxGenderActionPerformed

    private void btnUpDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpDateActionPerformed
        this.dispose();
        FrmLogin form = new FrmLogin();
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnUpDateActionPerformed

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
            java.util.logging.Logger.getLogger(FrmSignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSignIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpDate;
    private javax.swing.JComboBox<String> cbxDocumentType;
    private javax.swing.JComboBox<String> cbxGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDocumentNumber;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
