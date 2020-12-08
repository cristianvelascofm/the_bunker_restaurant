package view;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import dataBase.DBClient;
import dataBase.DBEmployee;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Client;
import model.Employee;

public class ServerThread extends Thread {

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private ObjectOutputStream outObject;
    private ObjectInputStream inObject;
    private int idSession;

    private DBClient dBClient = new DBClient();
    private DBEmployee dBEmployee = new DBEmployee();

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

                out.writeUTF("Creando ...");
                System.out.println("Creando ...");
                action = in.readUTF();
                Client client = jsonConverter.fromJson(action, Client.class);
                if (dBClient.addClient(client)) {
                    out.writeUTF("OK");
                    System.out.println("Creado con Éxito");
                } else {
                    out.writeUTF("error");
                    System.out.println("Error al Crear");
                }

            } else if (action.equals("update_client")) {

                out.writeUTF("Actualizando ...");
                System.out.println("Actualizando ...");
                action = in.readUTF();
                Client client = jsonConverter.fromJson(action, Client.class);

                if (dBClient.updateClient(client)) {
                    out.writeUTF("OK");
                    System.out.println("Actualizado con Éxito");
                } else {
                    out.writeUTF("error");
                    System.out.println("Error al Actualizar");
                }
            } else if (action.equals("delete_client")) {

                out.writeUTF("Eliminando ...");
                System.out.println("Eliminando ...");
                action = in.readUTF();
                if (dBClient.deleteClient(Integer.parseInt(action))) {
                    out.writeUTF("OK");
                    System.out.println("Eliminado con Éxito");
                } else {
                    out.writeUTF("error");
                    System.out.println("Error al Eliminar");
                }
            } else if (action.equals("fill_client")) {

                out.writeUTF("Cargando ...");
                action = in.readUTF();
                System.out.println("Resp:!" + action);
                ArrayList<Object[]> data = new ArrayList<>();
                data = dBClient.fillTableClient();
                out.writeUTF(String.valueOf(data.size()));
                outObject = new ObjectOutputStream(socket.getOutputStream());
                for (int i = 0; i < data.size(); i++) {

                    outObject.writeObject(data.get(i));

                }
            } else if (action.equals("fill_client_search")) {

                out.writeUTF("Cargando ...");
                action = in.readUTF();
                System.out.println("Respuesta:!" + action);
                ArrayList<Object[]> data = new ArrayList<>();
                data = dBClient.fillTableSearchClient(String.valueOf(in.readUTF()));
                out.writeUTF(String.valueOf(data.size()));
                outObject = new ObjectOutputStream(socket.getOutputStream());
                for (int i = 0; i < data.size(); i++) {

                    outObject.writeObject(data.get(i));

                }
            } else if (action.equals("create_employee")) {
                
                out.writeUTF("Creando ...");
                System.out.println("Creando ...");
                action = in.readUTF();
                Employee employee = jsonConverter.fromJson(action, Employee.class);
                if (dBEmployee.addEmployee(employee)) {
                    out.writeUTF("OK");
                    System.out.println("Creado con Éxito");
                } else {
                    out.writeUTF("error");
                    System.out.println("Error al Crear");
                }

            } else if (action.equals("update_employee")) {

                out.writeUTF("Actualizando ...");
                System.out.println("Actualizando ...");
                action = in.readUTF();
                Employee employee = jsonConverter.fromJson(action, Employee.class);

                if (dBEmployee.updateEmployee(employee)) {
                    out.writeUTF("OK");
                    System.out.println("Actualizado con Éxito");
                } else {
                    out.writeUTF("error");
                    System.out.println("Error al Actualizar");
                }
            } else if (action.equals("delete_employee")) {

                out.writeUTF("Eliminando ...");
                System.out.println("Eliminando ...");
                action = in.readUTF();
                if (dBEmployee.deleteEmployee(Integer.parseInt(action))) {
                    out.writeUTF("OK");
                    System.out.println("Eliminado con Éxito");
                } else {
                    out.writeUTF("error");
                    System.out.println("Error al Eliminar");
                }
            } else if (action.equals("fill_employee")) {

                out.writeUTF("Cargando ...");
                action = in.readUTF();
                System.out.println("Resp:!" + action);
                ArrayList<Object[]> data = new ArrayList<>();
                data = dBEmployee.fillTableEmployee();
                out.writeUTF(String.valueOf(data.size()));
                outObject = new ObjectOutputStream(socket.getOutputStream());
                for (int i = 0; i < data.size(); i++) {

                    outObject.writeObject(data.get(i));
                    

                }
            } else if (action.equals("fill_employee_search")) {

                out.writeUTF("Cargando ...");
                action = in.readUTF();
                System.out.println("Respuesta:!" + action);
                ArrayList<Object[]> data = new ArrayList<>();
                data = dBEmployee.fillTableSearchEmployee(String.valueOf(in.readUTF()));
                out.writeUTF(String.valueOf(data.size()));
                outObject = new ObjectOutputStream(socket.getOutputStream());
                for (int i = 0; i < data.size(); i++) {

                    outObject.writeObject(data.get(i));

                }
            } else if (action.equals("login")) {

                System.out.println("El cliente con idSesion " + this.idSession + " ha Iniciado");

            }
        } catch (IOException e) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconectServer();
    }

}
