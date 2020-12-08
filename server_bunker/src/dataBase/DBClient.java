package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Client;

public class DBClient {

    private String sSQL = "";
    private String sSQL2 = "";
    public Integer alerta = 0;
    public Integer totalRegistro;
    public Integer suma;
    static Statement sentencia;
    static ResultSet resultado;
    static ResultSetMetaData resultadoMeta;

    // Cargar los Datoss del Cliente
    public ArrayList<Object[]> fillTableClient() throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        totalRegistro = 0;
        ArrayList<Object[]> datos = new ArrayList<>();

        sSQL = "SELECT p.perIdPerson, p.perName, p.perLastName, p.perGender, p.perDocumentType,p.perDocumentNumber, "
                + "p.perEmail, p.perLogin, p.perPassword "
                + "FROM person p INNER JOIN client c ON p.perIdPerson = c.cliIdClient ORDER BY perName DESC";
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

    // Agregar Cliente
    public boolean addClient(Client e) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();

        sSQL = "INSERT INTO person ( perName, perLastName, perGender, perDocumentType, perDocumentNumber, perEmail, perLogin, perPassword)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        sSQL2 = "INSERT INTO client (cliIdClient, cliNote)"
                + "VALUES ((SELECT perIdPerson FROM person ORDER BY perIdPerson DESC LIMIT 1), ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, e.getName());
            pst.setString(2, e.getLastName());
            pst.setString(3, e.getGender());
            pst.setString(4, e.getDocumentType());
            pst.setString(5, e.getDocumentNumber());
            pst.setString(6, e.getEmail());
            pst.setString(7, e.getLogin());
            pst.setString(8, e.getPassword());

            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst2.setString(1, e.getNote());

            int n = pst.executeUpdate();
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
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

    
    //Actualizar Cliente
    public boolean updateClient(Client e) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        sSQL = "UPDATE person SET perName=?, perLastName=?, perGender=?, perDocumentType=?, perDocumentNumber=?,"
                + " perEmail=?, perLogin=?, perPassword=? "
                + "WHERE perIdPerson=?";
        sSQL2 = "UPDATE client SET cliNote=? "
                + " WHERE cliIdClient=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            pst.setString(1, e.getName());
            pst.setString(2, e.getLastName());
            pst.setString(3, e.getGender());
            pst.setString(4, e.getDocumentType());
            pst.setString(5, e.getDocumentNumber());
            pst.setString(6, e.getEmail());
            pst.setString(7, e.getLogin());
            pst.setString(8, e.getPassword());
            pst.setInt(9, e.getIdPerson());
            
            pst2.setString(1, e.getNote());
            pst2.setInt(2, e.getIdPerson());

            int n = pst.executeUpdate();
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
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
    
    
    
        //Eliminar Cliente
    public boolean deleteClient(int idPerson) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        sSQL = "DELETE FROM client WHERE cliIdClient=?";
        sSQL2 = "DELETE FROM person WHERE perIdPerson=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setInt(1, idPerson);
            pst2.setInt(1, idPerson);

            int n = pst.executeUpdate();
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
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
    
    
    
    
      //Buscar CLiente por Numero de Documento (Cargar la Tabla)
    public ArrayList<Object[]> fillTableSearchClient(String documentNumber) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();

        totalRegistro = 0;
        ArrayList<Object[]> datos = new ArrayList<>();
        
        
        sSQL = "SELECT p.perIdPerson, p.perName, p.perLastName, p.perGender, p.perDocumentType,p.perDocumentNumber, "
                + "p.perEmail, p.perLogin, p.perPassword "
                + "FROM person p INNER JOIN client c ON p.perIdPerson = c.cliIdClient "
                + "WHERE p.perDocumentNumber like '%" + documentNumber + "%'"
                + "ORDER BY perName DESC";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            resultado = pst.executeQuery();
            resultadoMeta = resultado.getMetaData();
            
        } catch (Exception e) {
            System.out.println("No Correcto");
        }
        try {
            while (resultado.next()) {
                Object[] filas = new Object[14];
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
    
    
    public String clientGender(int id) throws Exception{
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        String res = "";

        sSQL = "SELECT perGender FROM person INNER JOIN client ON perIdPerson= cliIdClient WHERE perIdPerson='" + id + "'"
                + " LIMIT 1";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            resultado = pst.executeQuery();
            resultadoMeta = resultado.getMetaData();
            
        } catch (Exception e) {
            System.out.println("No Correcto!!"
                    + "");
        }
        try {
            while (resultado.next()) {
                res = resultado.getString("person.perGender");

            }
        } catch (Exception e) {

            JOptionPane.showConfirmDialog(null, e);
            return "";
        } finally {
            try {
                cn.close();
                
            } catch (SQLException sqle) {
                throw new Exception("Error cerrar Cliente " + sqle.getMessage());
            }

        }

        return res;

    }
    
    
    
    
    

}
