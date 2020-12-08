package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logicaBD.DBCharge;
import logicaBD.DBOrder;
import logicaNegocio.Charge;
import logicaNegocio.Order;
import static view.FrmPrincipal.desktop;

public class FrmPayment extends javax.swing.JInternalFrame {

    public FrmPayment() throws Exception {
        initComponents();
        this.setSize(1135, 559);
        load();
        loadOrder();
        dateGenerator();
        orderNumberGenerator();
        //tblOrder.setModel(FrmDishMenu.modelPayment);
        //ocultarColumnasOrder();

    }
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    DefaultTableModel modelPayment = new DefaultTableModel();
    DBOrder dBOrder = new DBOrder();
    DBCharge dBCharge = new DBCharge();
    int numberOrder = 0;
    private double total= 0.0;
    private double iva = 0.35; //iva del 3.5% del Total del Pedido

    Order order = new Order();
    Charge charge = new Charge();

    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    
    
    public void loadOrder() {

        modelPayment = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        modelPayment.addColumn("Id Dish");
        modelPayment.addColumn("Nombre del Plato");
        modelPayment.addColumn("Cantidad");
        modelPayment.addColumn("Precio Total");

        ArrayList<Object[]> datos = new ArrayList<>();
        datos = FrmDishMenu.orderList;
        if (datos != null) {
            for (int i = 0; i < datos.size(); i++) {

                modelPayment.addRow(datos.get(i));

            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No hay Nada Agregado en la Orden");
        }

        tblOrder.setModel(modelPayment);
        ocultarColumnasOrder();
        txtTotal.setText(String.valueOf(calcTotalPay()));
        txtOutIva.setText(String.valueOf(total));

    }

    void load() {
        dtchOrderDate.setEnabled(false);
        lblIva.setText("Iva del " + iva + "% Incluido");

    }

    public void dateGenerator() {
        Calendar date = new GregorianCalendar();
        int año = date.get(Calendar.YEAR);
        int mes = date.get(Calendar.MONTH);
        int dia = date.get(Calendar.DAY_OF_MONTH);
        dtchOrderDate.setCalendar(date);

    }

    public void orderNumberGenerator() throws Exception {
        int number = dBOrder.idOrder();
        numberOrder = number + 1;
        lblOrderNumber.setText("N: " + numberOrder);
    }

    public  double calcTotalPay() {

        for (int i = 0; i <= tblOrder.getRowCount() - 1; i++) {

            total = (Double.parseDouble(modelPayment.getValueAt(i, 3).toString())) + total;

        }
        
        return (total * iva) + total; //Valor Total a Pagar con Iva Incluido

    }

    void ocultarColumnasOrder() {

        tblOrder.getColumnModel().getColumn(0).setMaxWidth(0);
        tblOrder.getColumnModel().getColumn(0).setMinWidth(0);
        tblOrder.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    public void loadOrderDefault() {

        modelPayment = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        modelPayment.addColumn("Id Dish");
        modelPayment.addColumn("Nombre del Plato");
        modelPayment.addColumn("Cantidad");
        modelPayment.addColumn("Precio Total");

        tblOrder.setModel(modelPayment);
        ocultarColumnasOrder();

    }

    void createOrder() throws Exception {

        //order.setIdClient(Integer.parseInt(FrmPrincipal.txtId.getText()));
        order.setIdClient(1);
        Calendar cal;
        int d, m, a;

        cal = dtchOrderDate.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        order.setDateOrder(new Date(a, m, d));

        order.setIvaOrder(iva);// establecemos el Iva total del pedido
        order.setTotalOrder(Double.parseDouble(txtTotal.getText()));
        order.setState("PENDIENTE");
        dBOrder.addOrder(order);
    }

    void createCharge() throws Exception {

        for (int i = 0; i <= tblOrder.getRowCount() - 1; i++) {
            charge.setIdOrder(numberOrder);
            charge.setIdDish(Integer.parseInt(modelPayment.getValueAt(i, 0).toString()));
            charge.setQuantityDish(Integer.parseInt(modelPayment.getValueAt(i, 2).toString()));
            charge.setSalePriceDish(Double.parseDouble(modelPayment.getValueAt(i, 3).toString()));

            if (dBCharge.addCharge(charge)) {
                JOptionPane.showMessageDialog(rootPane, "Orden Agregada");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Imposible Agregar, Por Favor Revise");
            }

        }
        
        //FrmDishMenu.orderList = null;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        btnCancel = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        lblOrderNumber = new javax.swing.JLabel();
        btnPay = new javax.swing.JButton();
        lblIva = new javax.swing.JLabel();
        btnDeleteDish = new javax.swing.JButton();
        dtchOrderDate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtOutIva = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setTitle("Pedido");
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedido"));
        jPanel2.setLayout(null);

        tblOrder.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblOrder);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 120, 1050, 210);

        btnCancel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/cancelar.png"))); // NOI18N
        btnCancel.setText("Cancelar Pedido");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancel);
        btnCancel.setBounds(600, 450, 200, 40);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel10.setText("Tu Pedido");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 30, 210, 50);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("$");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(680, 390, 20, 40);

        txtTotal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(204, 0, 0));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(txtTotal);
        txtTotal.setBounds(700, 390, 360, 40);

        lblOrderNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblOrderNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOrderNumber.setText("N:");
        jPanel2.add(lblOrderNumber);
        lblOrderNumber.setBounds(770, 70, 80, 40);

        btnPay.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/Nomina.png"))); // NOI18N
        btnPay.setText("Confirmar Pedido");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });
        jPanel2.add(btnPay);
        btnPay.setBounds(850, 450, 210, 40);

        lblIva.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblIva.setForeground(new java.awt.Color(255, 51, 51));
        lblIva.setText("Iva del 0.0% Incluido");
        jPanel2.add(lblIva);
        lblIva.setBounds(940, 430, 120, 15);

        btnDeleteDish.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDeleteDish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/files/eliminar.png"))); // NOI18N
        btnDeleteDish.setText("Eliminar Plato de la Orden");
        btnDeleteDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDishActionPerformed(evt);
            }
        });
        jPanel2.add(btnDeleteDish);
        btnDeleteDish.setBounds(10, 340, 250, 40);

        dtchOrderDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel2.add(dtchOrderDate);
        dtchOrderDate.setBounds(860, 70, 200, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Gracias por Elegirnos.");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 80, 400, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 255));
        jLabel5.setText("Total sin Iva:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(560, 350, 110, 30);

        txtOutIva.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtOutIva.setForeground(new java.awt.Color(51, 51, 255));
        txtOutIva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtOutIva.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(txtOutIva);
        txtOutIva.setBounds(700, 340, 360, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("$");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(680, 340, 20, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("TOTAL:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(600, 400, 70, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 10, 1090, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        loadOrderDefault();
        this.dispose();
        FrmDishMenu.orderList = null;
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDishActionPerformed
        int numRow = tblOrder.getSelectedRow();
        modelPayment.removeRow(numRow);
        txtTotal.setText(String.valueOf(calcTotalPay()));
    }//GEN-LAST:event_btnDeleteDishActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        try {
            createOrder();
        } catch (Exception ex) {
            Logger.getLogger(FrmPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            createCharge();
        } catch (Exception ex) {
            Logger.getLogger(FrmPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
        
        
        FrmPaymentSummary form = null;
        try {
            form = new FrmPaymentSummary();
        } catch (Exception ex) {
            Logger.getLogger(FrmPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dimension size = form.getSize();

        int width = (screenSize.width - size.width) / 2;
        int height = (screenSize.height - size.height) / 3;
        form.setLocation(width, height);
        desktop.add(form);
        form.toFront();
        form.setVisible(true);
        
    }//GEN-LAST:event_btnPayActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeleteDish;
    private javax.swing.JButton btnPay;
    private com.toedter.calendar.JDateChooser dtchOrderDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblOrderNumber;
    public static javax.swing.JTable tblOrder;
    private javax.swing.JTextField txtOutIva;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
