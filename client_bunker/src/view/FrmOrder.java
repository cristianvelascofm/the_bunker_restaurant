package view;

import client.ClientConnection;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmOrder extends javax.swing.JInternalFrame {

    public FrmOrder() throws Exception {
        initComponents();
        this.setSize(647, 470);
        loadOrder();
    }
    
    
    
    
    DefaultTableModel model = new DefaultTableModel();

    void loadOrder() throws Exception {
        ClientConnection socket = new ClientConnection("127.0.0.1", 9000);
        
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        model.addColumn("Orden");
        model.addColumn("Fecha");
        model.addColumn("Estado");

        ArrayList<Object[]> data = new ArrayList<>();
        try {
            socket.createConnectionMsg();
            data =socket.order();
            socket.closeConnection();
        } catch (Exception e) {
        }
        
        for (int i = 0; i < data.size(); i++) {

            model.addRow(data.get(i));

        }
        tblOrder.setModel(model);

        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();

        setClosable(true);
        setTitle("Pedidos");
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedidos"));
        jPanel2.setLayout(null);

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Categoriía", "Nombre", "Descripción", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tblOrder);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 30, 580, 380);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 10, 610, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrder;
    // End of variables declaration//GEN-END:variables
}
