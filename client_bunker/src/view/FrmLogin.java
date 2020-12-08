package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import logicaBD.Connect;
import logicaBD.DBSession;
import logicaNegocio.Employee;
import logicaNegocio.MD5;
import logicaNegocio.Session;

public final class FrmLogin extends javax.swing.JFrame {

    public FrmLogin() {
        initComponents();
        this.setSize(487, 607);
        this.setLocationRelativeTo(null);
        connection();
        //this.setUndecorated(true);
    }
    // public static Connector cn = new Connector();
    MD5 md5 = new MD5();
    //DBEmployee dBEmployee = new DBEmployee();
    DBSession dBSession = new DBSession();
    Session session = new Session();
    Connect connect = new Connect();

    void connection() {
        if (connect.conectar() == null) {
            JOptionPane.showMessageDialog(rootPane, "NO CONECTADO");
            FrmLogin.this.dispose();
            System.exit(0);
        }
    }

    void entrar() {
        try {

            if (txtDocumentNumber.getText().length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Ingrese el Número de Documento");
                txtDocumentNumber.requestFocus();
                return;
            }
            if (pswPassword.getText().length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Ingrese una Contraseña");
                pswPassword.requestFocus();
                return;
            }
            //DBSession dBSession = new DBSession();
            Employee employee = new Employee();
            employee.setLogin(txtDocumentNumber.getText());
            String login = txtDocumentNumber.getText();
            employee.setPassword(md5.MD5(pswPassword.getText()));

            if (md5.MD5(pswPassword.getText()).equals(dBSession.passwordLogin(txtDocumentNumber.getText()))) {

                String code = dBSession.code(login);
                String type = dBSession.type(code);
                String name = dBSession.name(login);
                String lastName = dBSession.lastName(login);
                String state = dBSession.state(code);
                System.out.println("State " + state);
                if ("Activo".equals(state)) {
                    this.dispose();

                    FrmPrincipal form = new FrmPrincipal();
                    form.toFront();
                    form.setVisible(true);

                    FrmPrincipal.txtName.setText(name + " " + lastName);

                    FrmPrincipal.txtId.setText(code);

                    if (!type.equals("Administrador")) {

                        if (type.equals("Cocinero")) {

                            FrmPrincipal.meuAdmin.setEnabled(false);

                            FrmPrincipal.txtType.setText(type);
                            //cn.loginChef();
                            iniciarSesion(Integer.parseInt(code));
                            connector();

                        } else {

                        }

                    } else {
                        FrmPrincipal.txtType.setText(type);
                        iniciarSesion(Integer.parseInt(code));
                        connector();

                    }

                } else if ("Inactivo".equals(state)) {
                    JOptionPane.showMessageDialog(rootPane, "Inactivo", "Acceso al Sistema", JOptionPane.ERROR_MESSAGE);

                } else if ("".equals(state)) {
                    this.dispose();
                    FrmPrincipal form = new FrmPrincipal();

                    FrmPrincipal.txtName.setText(name + " " + lastName);

                    FrmPrincipal.txtId.setText(code);
                    FrmPrincipal.menuOrder.setVisible(false);
                    FrmPrincipal.meuAdmin.setVisible(false);
                    FrmPrincipal.txtType.setText("Cliente");
                    connector();
                    form.toFront();
                    form.setVisible(true);
                }

            } else {
                System.out.println("Acceso Denegado");
                JOptionPane.showMessageDialog(rootPane, "Acceso Denegado", "Acceso al Sistema", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {

        }
    }

    void iniciarSesion(int idPerson) throws Exception {

        session.setIdPerson(idPerson);
        dBSession.logIn(session);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDocumentNumber = new javax.swing.JTextField();
        pswPassword = new javax.swing.JPasswordField();
        btnClose = new javax.swing.JButton();
        lblSignIn = new javax.swing.JLabel();
        btnLogIn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);
        getContentPane().add(txtDocumentNumber);
        txtDocumentNumber.setBounds(210, 320, 230, 30);
        getContentPane().add(pswPassword);
        pswPassword.setBounds(210, 380, 230, 30);

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/cancelar.png"))); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose);
        btnClose.setBounds(10, 10, 30, 25);

        lblSignIn.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblSignIn.setForeground(new java.awt.Color(102, 102, 255));
        lblSignIn.setText("Registrarse");
        lblSignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSignInMouseClicked(evt);
            }
        });
        getContentPane().add(lblSignIn);
        lblSignIn.setBounds(210, 530, 90, 20);

        btnLogIn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLogIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/Home.png"))); // NOI18N
        btnLogIn.setText("INGRESAR");
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogIn);
        btnLogIn.setBounds(160, 460, 180, 40);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 390, 80, 17);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Número de Documento:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 330, 160, 17);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/THE Bunker.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-700, -320, 1380, 930);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignInMouseClicked
        this.dispose();
        FrmSignIn form = new FrmSignIn();
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_lblSignInMouseClicked

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        entrar();
    }//GEN-LAST:event_btnLogInActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    public void connector() {
        ArrayList<Thread> clients = new ArrayList<>();
        for (int i = 0; i < 1; i++) { // Un cliente a la vez
            clients.add(new Connector(i));
        }
        for (Thread thread : clients) {
            thread.start();
        }
    }

  

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnLogIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblSignIn;
    private javax.swing.JPasswordField pswPassword;
    private javax.swing.JTextField txtDocumentNumber;
    // End of variables declaration//GEN-END:variables
}
