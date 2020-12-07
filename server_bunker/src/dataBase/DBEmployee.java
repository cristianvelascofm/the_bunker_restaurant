package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logic.Employee;

public class DBEmployee {

    private String sSQL = "";
    private String sSQL2 = "";
    public Integer alerta = 0;
    public Integer totalRegistro;
    public Integer suma;
    static Statement sentencia;
    static ResultSet resultado;
    static ResultSetMetaData resultadoMeta;

    // Cargar los Datoss del Empleado
    public ArrayList<Object[]> fillTableEmployee() throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        totalRegistro = 0;
        ArrayList<Object[]> datos = new ArrayList<>();

        sSQL = "SELECT p.perIdPerson, p.perName, p.perLastName, p.perGender, p.perDocumentType,p.perDocumentNumber, "
                + "p.perEmail, p.perLogin, p.perPassword, e.empEmployeeType, e.empState "
                + "FROM person p INNER JOIN employee e ON p.perIdPerson = e.empIdEmployee ORDER BY perName DESC";
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

    // Agregar Empleado
    public boolean addEmployee(Employee e) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();

        sSQL = "INSERT INTO person ( perName, perLastName, perGender, perDocumentType, perDocumentNumber, perEmail, perLogin, perPassword)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        sSQL2 = "INSERT INTO employee (empIdEmployee, empEmployeeType, empState)"
                + "VALUES ((SELECT perIdPerson FROM person ORDER BY perIdPerson DESC LIMIT 1),?,?)";

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

            pst2.setString(1, e.getEmployeeType());
            pst2.setString(2, e.getState());

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

    
    //Actualizar Empleado
    public boolean updateEmployee(Employee e) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
       
        sSQL = "UPDATE person SET perName=?, perLastName=?, perGender=?, perDocumentType=?, perDocumentNumber=?,"
                + " perEmail=?, perLogin=?, perPassword=? "
                + "WHERE perIdPerson=?";
        sSQL2 = "UPDATE employee SET empEmployeeType=?, empState=?"
                + " WHERE empIdEmployee=?";

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

            pst2.setString(1, e.getEmployeeType());
            pst2.setString(2, e.getState());
            pst2.setInt(3, e.getIdPerson());
            
            int n = pst.executeUpdate();
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    
                    return false;
                }
            } else {
                System.out.println("asdasdasdsadasdasd!FDSDSD");
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
    
    
    
        //Eliminar Empleado
    public boolean deleteEmployee(Employee e) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();
        sSQL = "DELETE FROM employee WHERE empIdEmployee=?";
        sSQL2 = "DELETE FROM person WHERE perIdPerson=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setInt(1, e.getIdPerson());
            pst2.setInt(1, e.getIdPerson());

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
    
    
    
    
      //Buscar Empleado por Numero de Documento (Cargar la Tabla)
    public ArrayList<Object[]> fillTableSearchEmployee(String documentNumber) throws Exception {
        Connect mysql = new Connect();
        Connection cn = mysql.conectar();

        totalRegistro = 0;
        ArrayList<Object[]> datos = new ArrayList<>();
        
        
        sSQL = "SELECT p.perIdPerson, p.perName, p.perLastName, p.perGender, p.perDocumentType,p.perDocumentNumber, "
                + "p.perEmail, p.perLogin, p.perPassword, e.empEmployeeType, e.empState "
                + "FROM person p INNER JOIN employee e ON p.perIdPerson = e.empIdEmployee "
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
    
    
   
    

}
