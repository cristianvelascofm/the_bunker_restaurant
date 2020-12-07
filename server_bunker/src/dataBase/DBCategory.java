package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DBCategory {

    private String sSQL = "";
    public Integer alerta = 0;
    public Integer totalRegistro;
    public Integer suma;
    static Statement sentencia;
    static ResultSet resultado;
    static ResultSetMetaData resultadoMeta;

    public ArrayList<String> category() throws Exception {

        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        ArrayList<String> datos = new ArrayList<>();

        sSQL = "SELECT catCategoryName FROM category";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            resultado = pst.executeQuery();
            resultadoMeta = resultado.getMetaData();

        } catch (Exception e) {
            System.out.println("No Correcto");
        }
        try {
            while (resultado.next()) {
                datos.add(resultado.getString("catCategoryName"));
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
