package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrmPrincipal extends javax.swing.JFrame {

    Toolkit t = Toolkit.getDefaultToolkit();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public FrmPrincipal() {
        initComponents();
        this.setExtendedState(FrmPrincipal.MAXIMIZED_BOTH);
        this.setTitle("THE BUNKER - CASUAL DINNING");
        desktop.setSize(screenSize.width, screenSize.height);
        pnlUser.setBackground(new Color(0, 0, 0, 32));

        // connector();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        pnlUser = new javax.swing.JPanel();
        txtType = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuMenu = new javax.swing.JMenu();
        menuOrder = new javax.swing.JMenu();
        pendingMenuItem = new javax.swing.JMenuItem();
        orderMenuItem = new javax.swing.JMenuItem();
        meuAdmin = new javax.swing.JMenu();
        employeeMenuItem = new javax.swing.JMenuItem();
        clientMenuItem = new javax.swing.JMenuItem();
        dishMenuItem = new javax.swing.JMenuItem();
        statisticMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/exit.png"))); // NOI18N
        desktop.add(jButton1);
        jButton1.setBounds(920, 560, 80, 40);

        pnlUser.setLayout(null);

        txtType.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pnlUser.add(txtType);
        txtType.setBounds(130, 120, 310, 40);

        txtId.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pnlUser.add(txtId);
        txtId.setBounds(130, 20, 310, 40);

        txtName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pnlUser.add(txtName);
        txtName.setBounds(130, 70, 310, 40);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo:");
        pnlUser.add(jLabel1);
        jLabel1.setBounds(10, 140, 90, 17);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Código:");
        pnlUser.add(jLabel3);
        jLabel3.setBounds(10, 40, 90, 17);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre:");
        pnlUser.add(jLabel4);
        jLabel4.setBounds(10, 90, 90, 17);

        desktop.add(pnlUser);
        pnlUser.setBounds(920, 600, 470, 170);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/THE Bunker.png"))); // NOI18N
        desktop.add(jLabel2);
        jLabel2.setBounds(-250, -180, 2780, 1090);

        getContentPane().add(desktop);
        desktop.setBounds(0, 0, 1510, 780);

        menuMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/menu.png"))); // NOI18N
        menuMenu.setMnemonic('h');
        menuMenu.setText("Menú");
        menuMenu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        menuMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMenuMouseClicked(evt);
            }
        });
        menuBar.add(menuMenu);

        menuOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/Pedidos_1.png"))); // NOI18N
        menuOrder.setMnemonic('h');
        menuOrder.setText("Pedidos");
        menuOrder.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        pendingMenuItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pendingMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/Alertas.png"))); // NOI18N
        pendingMenuItem.setMnemonic('c');
        pendingMenuItem.setText("Pedidos Pendientes");
        pendingMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendingMenuItemActionPerformed(evt);
            }
        });
        menuOrder.add(pendingMenuItem);

        orderMenuItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        orderMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/Pedidos_1.png"))); // NOI18N
        orderMenuItem.setMnemonic('c');
        orderMenuItem.setText("Todos los Pedidos");
        orderMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderMenuItemActionPerformed(evt);
            }
        });
        menuOrder.add(orderMenuItem);

        menuBar.add(menuOrder);

        meuAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/Reportes.png"))); // NOI18N
        meuAdmin.setMnemonic('h');
        meuAdmin.setText("Administración");
        meuAdmin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        employeeMenuItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        employeeMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/Nomina_.png"))); // NOI18N
        employeeMenuItem.setMnemonic('a');
        employeeMenuItem.setText("Gestionar Empleados");
        employeeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeMenuItemActionPerformed(evt);
            }
        });
        meuAdmin.add(employeeMenuItem);

        clientMenuItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        clientMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/Cliente.png"))); // NOI18N
        clientMenuItem.setMnemonic('a');
        clientMenuItem.setText("Gestionar Clientes");
        clientMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientMenuItemActionPerformed(evt);
            }
        });
        meuAdmin.add(clientMenuItem);

        dishMenuItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        dishMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/rest.png"))); // NOI18N
        dishMenuItem.setMnemonic('a');
        dishMenuItem.setText("Gestionar Platos");
        dishMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dishMenuItemActionPerformed(evt);
            }
        });
        meuAdmin.add(dishMenuItem);

        statisticMenuItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        statisticMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/Facturas.png"))); // NOI18N
        statisticMenuItem.setMnemonic('a');
        statisticMenuItem.setText("Estadísticas");
        statisticMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticMenuItemActionPerformed(evt);
            }
        });
        meuAdmin.add(statisticMenuItem);

        menuBar.add(meuAdmin);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeMenuItemActionPerformed
        FrmEmployee form = null;
        try {
            form = new FrmEmployee();
        } catch (Exception ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dimension size = form.getSize();

        int width = (screenSize.width - size.width) / 2;
        int height = (screenSize.height - size.height) / 3;
        form.setLocation(width, height);
        desktop.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_employeeMenuItemActionPerformed

    private void clientMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientMenuItemActionPerformed
        FrmClient form = null;
        try {
            form = new FrmClient();
        } catch (Exception ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dimension size = form.getSize();

        int width = (screenSize.width - size.width) / 2;
        int height = (screenSize.height - size.height) / 3;
        form.setLocation(width, height);
        desktop.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_clientMenuItemActionPerformed

    private void menuMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMenuMouseClicked
        FrmMenu form = new FrmMenu();
        Dimension size = form.getSize();

        int width = (screenSize.width - size.width) / 2;
        int height = (screenSize.height - size.height) / 3;
        form.setLocation(width, height);
        desktop.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_menuMenuMouseClicked

    private void dishMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dishMenuItemActionPerformed

        FrmDish form = null;
        try {
            form = new FrmDish();
        } catch (Exception ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dimension size = form.getSize();
        int width = (screenSize.width - size.width) / 2;
        int height = (screenSize.height - size.height) / 3;
        form.setLocation(width, height);
        desktop.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_dishMenuItemActionPerformed

    private void statisticMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticMenuItemActionPerformed
        FrmStatistic form = new FrmStatistic();
        Dimension size = form.getSize();

        int width = (screenSize.width - size.width) / 2;
        int height = (screenSize.height - size.height) / 3;
        form.setLocation(width, height);
        desktop.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_statisticMenuItemActionPerformed

    private void pendingMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendingMenuItemActionPerformed
        FrmOrderPending form = null;
        try {
            form = new FrmOrderPending();
        } catch (Exception ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dimension size = form.getSize();

        int width = (screenSize.width - size.width) / 2;
        int height = (screenSize.height - size.height) / 3;
        form.setLocation(width, height);
        desktop.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_pendingMenuItemActionPerformed

    private void orderMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderMenuItemActionPerformed
        FrmOrder form = null;
        try {
            form = new FrmOrder();
        } catch (Exception ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dimension size = form.getSize();

        int width = (screenSize.width - size.width) / 2;
        int height = (screenSize.height - size.height) / 3;
        form.setLocation(width, height);
        desktop.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_orderMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem clientMenuItem;
    public static javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuItem dishMenuItem;
    private javax.swing.JMenuItem employeeMenuItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenu menuMenu;
    public static javax.swing.JMenu menuOrder;
    public static javax.swing.JMenu meuAdmin;
    private javax.swing.JMenuItem orderMenuItem;
    private javax.swing.JMenuItem pendingMenuItem;
    private javax.swing.JPanel pnlUser;
    private javax.swing.JMenuItem statisticMenuItem;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtName;
    public static javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables

}
