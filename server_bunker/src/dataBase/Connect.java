package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Connect {

    public String db = "thebunkerdb";
    public String url = "jdbc:mysql://localhost/" + db;
    public String user = "root";
    public String pass = "";

    public Connect() {
    }

    public Connection conectar() {
        Connection link = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);

        }
        return link;
    }

}
