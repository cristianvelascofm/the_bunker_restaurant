package view;


import java.util.ArrayList;
import logicaBD.DBClient;
import logicaBD.DBOrder;

public class FrmPaymentSummary extends javax.swing.JInternalFrame {

    public FrmPaymentSummary() throws Exception {
        initComponents();
        this.setSize(666, 658);
        load();
    }
    DBOrder dBOrder = new DBOrder();
    DBClient dBClient = new DBClient();
    private int orderNumber = 0;
    int table = -1;

    void load() throws Exception {

        orderNumber = dBOrder.idOrder();
        lblOrder.setText("Pedido No: " + orderNumber);
        txtName.setText(FrmPrincipal.txtName.getText());
        txtGender.setText(dBClient.clientGender(Integer.parseInt(FrmPrincipal.txtId.getText())));
        txtTable.setText(String.valueOf(tableGenerator()));
    }

    int tableGenerator() {

        table = (int) Math.floor(Math.random() * (1 - 10 + 1) + 10);//Numero aleatorio entre 1 y 10 mesas
        return table;

    }
  public void con(String type, int id) {
        ArrayList<Thread> clients = new ArrayList<>();
        
        clients.add(new Cona(type, id));
        
        /*
        
        for (int i = 0; i < 1; i++) { // Un cliente a la vez
            clients.add(new Connector(i));
        }*/
        for (Thread thread : clients) {
            thread.start();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSummary = new javax.swing.JTable();
        lblOrder = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTable = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtGender = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();

        setTitle("Pago");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumen del Pedido"));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        tblSummary.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblSummary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tipo de Comida", "Plato", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tblSummary);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 590, 240);

        lblOrder.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblOrder.setText("Pedido No: ###");
        jPanel2.add(lblOrder);
        lblOrder.setBounds(240, 10, 160, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 30, 610, 320);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Mesa No:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 510, 160, 30);

        txtTable.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(txtTable);
        txtTable.setBounds(180, 500, 440, 40);

        txtName.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(txtName);
        txtName.setBounds(180, 400, 440, 40);

        txtGender.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(txtGender);
        txtGender.setBounds(180, 450, 440, 40);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Datos del Cliente:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(220, 360, 160, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Nombres:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 410, 160, 30);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Género:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 460, 160, 30);

        btnOK.setBackground(new java.awt.Color(255, 153, 153));
        btnOK.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnOK.setForeground(new java.awt.Color(255, 0, 0));
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        jPanel1.add(btnOK);
        btnOK.setBounds(450, 560, 170, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 11, 630, 610);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        this.dispose();
        con(FrmPrincipal.txtType.getText(), Integer.parseInt(FrmPrincipal.txtId.getText()));
      //  FrmLogin.cn.incio();
    }//GEN-LAST:event_btnOKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JTable tblSummary;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTable;
    // End of variables declaration//GEN-END:variables
}
