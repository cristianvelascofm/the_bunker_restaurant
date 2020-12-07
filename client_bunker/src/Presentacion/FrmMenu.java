package Presentacion;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static Presentacion.FrmPrincipal.desktop;

public class FrmMenu extends javax.swing.JInternalFrame {

    public FrmMenu() {
        initComponents();
        this.setSize(500, 595);

    }
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    void openMenuDish(String category) throws Exception {
        this.dispose();
        FrmDishMenu form = new FrmDishMenu();
        Dimension size = form.getSize();

        int width = (screenSize.width - size.width) / 2;
        int height = (screenSize.height - size.height) / 3;
        form.setLocation(width, height);
        desktop.add(form);
        form.toFront();
        if (category == "S") {
            form.lblCategory.setText("Comidas Especiales");
            form.lblDescription.setText("Lo Mejor de la Culinaria en su Plato. Ingredientes Frescos.");
            ImageIcon imgIcon = new ImageIcon(getClass().getResource("../files/Comidas_Especiales.png"));
            form.lblIcon.setIcon(imgIcon);
            form.loadDish("Comidas Especiales");
        } else if (category == "F") {
            form.lblCategory.setText("Comidas Rápidas");
            form.lblDescription.setText("Solo Deleites. Ingredientes Frescos.");
            ImageIcon imgIcon = new ImageIcon(getClass().getResource("../files/comidas_rapidas.png"));
            form.lblIcon.setIcon(imgIcon);
            form.loadDish("Comidas Rápidas");
        } else if (category == "Ds") {
            form.lblCategory.setText("Postres");
            form.lblDescription.setText("Un Plato Dulce a su Paladar. Ingredientes Frescos.");
            ImageIcon imgIcon = new ImageIcon(getClass().getResource("../files/postres.png"));
            form.lblIcon.setIcon(imgIcon);
            form.loadDish("Postres");
        } else if (category == "Dr") {
            form.lblCategory.setText("Bebidas");
            form.lblDescription.setText("Bebidas Naturales, Nacionales e Importadas. Ingredientes Frescos.");
            ImageIcon imgIcon = new ImageIcon(getClass().getResource("../files/bebidas.png"));
            form.lblIcon.setIcon(imgIcon);
            form.loadDish("Bebidas");
        }
        form.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnDrink = new javax.swing.JButton();
        btnFastFood = new javax.swing.JButton();
        btnSpecial = new javax.swing.JButton();
        btnDessert = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnOrder = new javax.swing.JButton();

        setClosable(true);
        setTitle("Menú");
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Menú"));
        jPanel2.setLayout(null);

        btnDrink.setBackground(new java.awt.Color(255, 255, 255));
        btnDrink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/bebidas.PNG"))); // NOI18N
        btnDrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrinkActionPerformed(evt);
            }
        });
        jPanel2.add(btnDrink);
        btnDrink.setBounds(260, 240, 180, 160);

        btnFastFood.setBackground(new java.awt.Color(255, 255, 255));
        btnFastFood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/comidas_rapidas.png"))); // NOI18N
        btnFastFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFastFoodActionPerformed(evt);
            }
        });
        jPanel2.add(btnFastFood);
        btnFastFood.setBounds(260, 40, 180, 160);

        btnSpecial.setBackground(new java.awt.Color(255, 255, 255));
        btnSpecial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/Comidas_Especiales.png"))); // NOI18N
        btnSpecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpecialActionPerformed(evt);
            }
        });
        jPanel2.add(btnSpecial);
        btnSpecial.setBounds(40, 40, 180, 160);

        btnDessert.setBackground(new java.awt.Color(255, 255, 255));
        btnDessert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/postres.png"))); // NOI18N
        btnDessert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDessertActionPerformed(evt);
            }
        });
        jPanel2.add(btnDessert);
        btnDessert.setBounds(40, 240, 180, 160);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel1.setText("Bebidas");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(320, 410, 60, 17);

        jLabel2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel2.setText("Comidas Especiales");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(60, 210, 140, 17);

        jLabel3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel3.setText("Comidas Rápidas");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(290, 210, 120, 17);

        jLabel4.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel4.setText("Postres");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(100, 410, 60, 17);

        btnOrder.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/cuenta.png"))); // NOI18N
        btnOrder.setText("Ir al Pedido");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });
        jPanel2.add(btnOrder);
        btnOrder.setBounds(40, 460, 400, 60);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 10, 470, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        FrmPayment form = null;
        try {
            form = new FrmPayment();
        } catch (Exception ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dimension size = form.getSize();

        int width = (screenSize.width - size.width) / 2;
        int height = (screenSize.height - size.height) / 3;
        form.setLocation(width, height);
        desktop.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnSpecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpecialActionPerformed
        try {
            openMenuDish("S");
        } catch (Exception ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSpecialActionPerformed

    private void btnFastFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFastFoodActionPerformed
        try {
            openMenuDish("F");
        } catch (Exception ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFastFoodActionPerformed

    private void btnDessertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDessertActionPerformed
        try {
            openMenuDish("Ds");
        } catch (Exception ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDessertActionPerformed

    private void btnDrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrinkActionPerformed
        try {
            openMenuDish("Dr");
        } catch (Exception ex) {
            Logger.getLogger(FrmMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDrinkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDessert;
    private javax.swing.JButton btnDrink;
    private javax.swing.JButton btnFastFood;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnSpecial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
