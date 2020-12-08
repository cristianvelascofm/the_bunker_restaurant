package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Dish;

public class DBDish {

    private String sSQL = "";
    public Integer alerta = 0;
    public Integer totalRegistro;
    public Integer suma;
    static Statement sentencia;
    static ResultSet resultado;
    static ResultSetMetaData resultadoMeta;

    public boolean addDish(Dish d) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();

        sSQL = "INSERT INTO dish (disIdCategory,disDishName,disDishPrice,disPhoto)"
                + " VALUES (?,?,?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, d.getIdCategory());
            pst.setString(2, d.getDishName());
            pst.setDouble(3, d.getDishPrice());
            pst.setString(4, d.getPhoto());
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

    //Actualizar Plato
    public boolean updateDish(Dish d) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        sSQL = "UPDATE dish SET disIdCategory=?, disDishName=?, disDishPrice=?, disPhoto=? "
                + "WHERE disIdDish=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, d.getIdCategory());
            pst.setString(2, d.getDishName());
            pst.setDouble(3, d.getDishPrice());
            pst.setString(4, d.getPhoto());
            pst.setInt(5, d.getIdDish());

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
    
     public boolean deleteDish(Dish d) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        sSQL = "DELETE FROM dish WHERE disIdDish=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, d.getIdDish());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return false;
        } finally {
            try {
                cn.close();
                
            } catch (SQLException sqle) {
                throw new Exception("Error cerrar " + sqle.getMessage());
            }

        }
    }

    public ArrayList<Object[]> fillTableDish() throws Exception {

        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        totalRegistro = 0;
        ArrayList<Object[]> datos = new ArrayList<>();

        sSQL = "SELECT d.disIdDish, d.disIdCategory, c.catCategoryName, d.disDishName, d.disDishPrice, d.disPhoto "
                + "FROM dish d INNER JOIN category c ON d.disIdCategory = c.catIdCategory ORDER BY catCategoryName DESC";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            resultado = pst.executeQuery();
            resultadoMeta = resultado.getMetaData();

        } catch (Exception e) {
            System.out.println("No Correcto" + e);
        }
        try {
            while (resultado.next()) {
                Object[] filas = new Object[6];
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

    public ArrayList<Object[]> fillTableDishMenu(String category) throws Exception {

        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        totalRegistro = 0;
        ArrayList<Object[]> datos = new ArrayList<>();

        sSQL = "SELECT d.disIdDish, d.disIdCategory, c.catCategoryName, d.disDishName, d.disDishPrice, d.disPhoto "
                + "FROM dish d INNER JOIN category c ON d.disIdCategory = c.catIdCategory "
                + "WHERE c.catCategoryName= '" + category + "' "
                + "ORDER BY catCategoryName DESC";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            resultado = pst.executeQuery();
            resultadoMeta = resultado.getMetaData();

        } catch (Exception e) {
            System.out.println("No Correcto" + e);
        }
        try {
            while (resultado.next()) {
                Object[] filas = new Object[6];
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
