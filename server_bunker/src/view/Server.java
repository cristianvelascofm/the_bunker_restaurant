package view;

import dataBase.Connect;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    public static void main(String[] args) {
        Connect conexion = new Connect();
        ServerSocket ss;
        System.out.println("Incicializando Servidor...");
        if (conexion.conectar() == null) {
            
            System.out.println("Error al conectar SQL");
            System.exit(0);
            
        }

        try {
            ss = new ServerSocket(9000);
            System.out.println("\t[OK]");

            int idSession = 0;
            while (true) {
                Socket socket;
                socket = ss.accept();
                System.out.println("Nueva Conexion Entrante: " + socket);
                ((ServerThread) new ServerThread(socket, idSession)).start();
                idSession++;
            }
        } catch (IOException e) {

            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
