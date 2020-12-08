package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Order;

public class DBOrder {

    private String sSQL = "";
    public Integer alerta = 0;
    public Integer totalRegistro;
    public Integer suma;
    static Statement sentencia;
    static ResultSet resultado;
    static ResultSetMetaData resultadoMeta;

    public int idOrder() throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();

        int datos = 0;
        sSQL = "SELECT COUNT(*) AS total FROM `orders`";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            resultado = pst.executeQuery();
            resultadoMeta = resultado.getMetaData();

        } catch (Exception e) {
            System.out.println("No Correcto" + e);
        }
        try {
            while (resultado.next()) {
                datos = Integer.parseInt(resultado.getString("total"));

            }
        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, e);

        } finally {
            try {
                cn.close();

            } catch (SQLException sqle) {
                throw new Exception("Error cerrar " + sqle.getMessage());
            }

        }

        return datos;

    }

    public int idOrderF() throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        int id = 0;
        sSQL = "SELECT ordIdOrder FROM orders ORDER BY ordIdOrder DESC LIMIT 1";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            resultado = pst.executeQuery();
            resultadoMeta = resultado.getMetaData();

        } catch (Exception e) {
            System.out.println("No Correcto!!"
                    + e);
        }
        try {
            while (resultado.next()) {
                id = resultado.getInt("order.ordIdOrder");

            }
        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, e);
            return -1;
        } finally {
            try {
                cn.close();

            } catch (SQLException sqle) {
                throw new Exception("Error cerrar " + sqle.getMessage());
            }

        }

        return id;

    }

    public boolean addOrder(Order o) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();

        sSQL = "INSERT INTO `orders` (ordIdPerson,ordDateOrder,ordIvaOrder,ordTotalOrder,ordStateOrder) "
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, o.getIdClient());
            pst.setDate(2, o.getDateOrder());
            pst.setDouble(3, o.getIvaOrder());
            pst.setDouble(4, o.getTotalOrder());
            pst.setString(5, o.getState());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage());
            return false;
        } finally {
            try {
                cn.close();

            } catch (SQLException sqle) {
                throw new Exception("Error cerrar " + sqle.getMessage());
            }

        }

    }

    public ArrayList<Object[]> fillTableOrder() throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        totalRegistro = 0;
        ArrayList<Object[]> datos = new ArrayList<>();
        sSQL = "SELECT orders.ordIdOrder, "
                + " orders.ordDateOrder, orders.ordStateOrder "
                + "FROM orders  "
                + " ORDER BY orders.ordDateOrder ASC";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            resultado = pst.executeQuery();
            resultadoMeta = resultado.getMetaData();

        } catch (Exception e) {
            System.out.println("No Correcto" + e);
        }
        try {
            while (resultado.next()) {
                Object[] filas = new Object[12];
                for (int i = 0; i < resultadoMeta.getColumnCount(); i++) {

                    filas[i] = resultado.getObject(i + 1);

                }
                totalRegistro = totalRegistro + 1;
                datos.add(filas);
            }
        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, e);
            return null;
        } finally {
            try {
                cn.close();

            } catch (SQLException sqle) {
                throw new Exception("Error cerrar " + sqle.getMessage());
            }

        }

        return datos;

    }

}
