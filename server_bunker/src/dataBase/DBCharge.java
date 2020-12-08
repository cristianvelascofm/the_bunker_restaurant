package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Charge;


public class DBCharge {

    private String sSQL = "";
    public Integer alerta = 0;
    public Integer totalRegistro;
    public Integer suma;
    static Statement sentencia;
    static ResultSet resultado;
    static ResultSetMetaData resultadoMeta;

  
    public boolean addCharge(Charge c) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();

        sSQL = "INSERT INTO charge (chaIdOrder,chaIdDish,chaQuantityDish,chaSalePriceDish)"
                + "VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, c.getIdOrder());
            pst.setInt(2, c.getIdDish());
            pst.setInt(3, c.getQuantityDish());
            pst.setDouble(4, c.getSalePriceDish());
            
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

}
