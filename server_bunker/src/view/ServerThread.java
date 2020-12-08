package view;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import dataBase.DBClient;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Client;

public class ServerThread extends Thread {

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private ObjectOutputStream outObject;
    private ObjectInputStream inObject;
    private int idSession;

    private DBClient dBClient = new DBClient();

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

    public void disconectServer() {
        try {
            socket.close();
        } catch (IOException e) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void run() {
        String action = "";
        Gson jsonConverter = new Gson();

        try {
            action = in.readUTF();
            System.out.println("accion: " + action);

            if (action.equals("create_client")) {

                out.writeUTF("Creando Cliente...");
                System.out.println("Creando Cliente");
                action = in.readUTF();
                Client client = jsonConverter.fromJson(action, Client.class);
                if (dBClient.addClient(client)) {
                    out.writeUTF("OK");
                    System.out.println("Cliente Creando con Éxito");
                } else {
                    out.writeUTF("error");
                    System.out.println("Error al Crear Cliente");
                }

            } else if (action.equals("login")) {

                System.out.println("El cliente con idSesion " + this.idSession + " ha Iniciado");

            } else if (action.equals("fill_client")) {

                out.writeUTF("Cargando Clientes...");
                action = in.readUTF();
                System.out.println("Resp:!" + action);
                ArrayList<Object[]> data = new ArrayList<>();
                data = dBClient.fillTableClient();
                out.writeUTF(String.valueOf(data.size()));
                outObject = new ObjectOutputStream(socket.getOutputStream());
                for (int i = 0; i < data.size(); i++) {

                    outObject.writeObject(data.get(i));
                    //out.writeUTF(data.get(i).toString());

                }
            } else if (action.equals("fill_client_search")) {

                out.writeUTF("Cargando Clientes...");
                action = in.readUTF();
                System.out.println("Respuesta:!" + action);
                ArrayList<Object[]> data = new ArrayList<>();
                data = dBClient.fillTableSearchClient(String.valueOf(in.readUTF()));
                out.writeUTF(String.valueOf(data.size()));
                outObject = new ObjectOutputStream(socket.getOutputStream());
                for (int i = 0; i < data.size(); i++) {

                    outObject.writeObject(data.get(i));
                    //out.writeUTF(data.get(i).toString());

                }
            } else if (action.equals("update_client")) {

                out.writeUTF("Actualizando Cliente...");
                System.out.println("Actualizando Cliente...");
                action = in.readUTF();
                Client client = jsonConverter.fromJson(action, Client.class);

                if (dBClient.updateClient(client)) {
                    out.writeUTF("OK");
                    System.out.println("Cliente Actualizado con Éxito");
                } else {
                    out.writeUTF("error");
                    System.out.println("Error al Actualizar");
                }
            } else if (action.equals("delete_client")) {
                
                out.writeUTF("Eliminando Cliente...");
                System.out.println("Eliminando Cliente...");
                action = in.readUTF();
                if (dBClient.deleteClient(Integer.parseInt(action))) {
                    out.writeUTF("OK");
                    System.out.println("Cliente Eliminado con Éxito");
                } else {
                    out.writeUTF("error");
                    System.out.println("Error al Eliminar");
                }
            }
        } catch (IOException e) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconectServer();
    }

}
