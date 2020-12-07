package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
//import java.sql.Statement;
import javax.swing.JOptionPane;
import logic.Session;

public class DBSession {

    private String sSQL = "";
    public Integer alerta = 0;
    public Integer totalRegistro;
    public Integer suma;
    //static Statement sentencia;
    static ResultSet resultado;
    static ResultSetMetaData resultadoMeta;

    public boolean logIn(Session s) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();

        sSQL = "INSERT INTO session (sesIdPersona, sesDateLogin)"
                + "VALUES (?,CURDATE())";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, s.getIdPerson());

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

    public String passwordLogin(String login) throws Exception {
        
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        String psw = "";
        sSQL = "SELECT perPassword FROM person WHERE perLogin='" + login + "'"
                + " LIMIT 1";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            resultado = pst.executeQuery();
            resultadoMeta = resultado.getMetaData();

        } catch (Exception e) {
            System.out.println("No Correcto!! "
                    + "");
        }
        try {
            while (resultado.next()) {
                psw = resultado.getString("person.perPassword");

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

        return psw;

    }

  public String code(String login) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        String psw = "";
        sSQL = "SELECT perIdPerson FROM person WHERE perLogin ='" + login + "' LIMIT 1";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            resultado = pst.executeQuery();
            resultadoMeta = resultado.getMetaData();

        } catch (Exception e) {
            System.out.println("No Correcto!! COD"
                    + "");
        }
        try {
            while (resultado.next()) {
                psw = resultado.getString("person.perIdPerson");

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

        return psw;

    }

    public String type(String id) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        String psw = "";
        sSQL = "SELECT empEmployeeType FROM employee WHERE empIdEmployee='" + id + "' LIMIT 1";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            resultado = pst.executeQuery();
            resultadoMeta = resultado.getMetaData();

        } catch (Exception e) {
            System.out.println("No Correcto!! COD"
                    + "");
        }
        try {
            while (resultado.next()) {
                psw = resultado.getString("employee.empEmployeeType");

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

        return psw;

    }
    
    
    public String name(String login) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        String psw = "";
        sSQL = "SELECT perName FROM person WHERE perLogin ='" + login + "' LIMIT 1";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            resultado = pst.executeQuery();
            resultadoMeta = resultado.getMetaData();

        } catch (Exception e) {
            System.out.println("No Correcto!! COD"
                    + "");
        }
        try {
            while (resultado.next()) {
                psw = resultado.getString("person.perName");

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

        return psw;

    }
    
    public String lastName(String login) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        String psw = "";
        sSQL = "SELECT perLastName FROM person WHERE perLogin ='" + login + "' LIMIT 1";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            resultado = pst.executeQuery();
            resultadoMeta = resultado.getMetaData();

        } catch (Exception e) {
            System.out.println("No Correcto!! COD"
                    + "");
        }
        try {
            while (resultado.next()) {
                psw = resultado.getString("person.perLastName");

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

        return psw;

    }
    
    
    public String state(String id) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        String psw = "";
        sSQL = "SELECT empState FROM employee WHERE empIdEmployee ='" + id + "' LIMIT 1";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            resultado = pst.executeQuery();
            resultadoMeta = resultado.getMetaData();

        } catch (Exception e) {
            System.out.println("No Correcto!! COD"
                    + "");
        }
        try {
            while (resultado.next()) {
                psw = resultado.getString("employee.empState");

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

        return psw;

    }

}
