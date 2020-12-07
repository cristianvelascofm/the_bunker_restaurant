package presentation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerThread extends Thread {

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private int idSession;

    public ServerThread(Socket socket, int id) {
        this.socket = socket;
        this.idSession = id;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void desconectar() {
        try {
            socket.close();
        } catch (IOException e) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void run() {
        String accion = "";
        try {
            accion = in.readUTF();
            System.out.println("accion: "+accion);
            if (accion.equals("Nuevo Pedido")) {
                System.out.println("El cliente con idSesion " + this.idSession + " ha Realizado un Pedido");
                
                
                out.writeUTF("\nEsperando Respuesta...");
            }else if(accion.equals("Login")){
                System.out.println("El cliente con idSesion " + this.idSession + " ha Iniciado");
                
            }
        } catch (IOException e) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, e);
        }
        desconectar();
    }

}