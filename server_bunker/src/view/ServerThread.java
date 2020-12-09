package view;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import dataBase.DBCategory;
import dataBase.DBCharge;
import dataBase.DBClient;
import dataBase.DBDish;
import dataBase.DBEmployee;
import dataBase.DBOrder;
import dataBase.DBSession;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Charge;
import model.Client;
import model.Dish;
import model.Employee;
import model.Order;

public class ServerThread extends Thread {

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private ObjectOutputStream outObject;
    private ObjectInputStream inObject;
    private int idSession;

    private DBClient dBClient = new DBClient();
    private DBEmployee dBEmployee = new DBEmployee();
    private DBSession dBSession = new DBSession();
    private DBDish dBDish = new DBDish();
    private DBCategory dBCategory = new DBCategory();
    private DBOrder dBOrder = new DBOrder();
    private DBCharge dBCharge = new DBCharge();

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
            } else if (action.equals("password")) {

                out.writeUTF("Cargando ...");
                action = in.readUTF();
                System.out.println("Identificacion:!" + action);
                String data = "";
                data = dBSession.passwordLogin(action);
                out.writeUTF(data);

            } else if (action.equals("code")) {

                out.writeUTF("Cargando ...");
                action = in.readUTF();
                System.out.println("Identificacion:!" + action);
                String data = "";
                data = dBSession.code(action);
                out.writeUTF(data);

            } else if (action.equals("type")) {

                out.writeUTF("Cargando ...");
                action = in.readUTF();
                System.out.println("Identificacion:!" + action);
                String data = "";
                data = dBSession.type(action);
                out.writeUTF(data);

            } else if (action.equals("name")) {

                out.writeUTF("Cargando ...");
                action = in.readUTF();
                System.out.println("Identificacion:!" + action);
                String data = "";
                data = dBSession.name(action);
                out.writeUTF(data);

            } else if (action.equals("last_name")) {

                out.writeUTF("Cargando ...");
                action = in.readUTF();
                System.out.println("Identificacion:!" + action);
                String data = "";
                data = dBSession.lastName(action);
                out.writeUTF(data);

            } else if (action.equals("state")) {

                out.writeUTF("Cargando ...");
                action = in.readUTF();
                System.out.println("Identificacion:!" + action);
                String data = "";
                data = dBSession.state(action);
                out.writeUTF(data);

            } else if (action.equals("fill_category")) {

                out.writeUTF("Cargando ...");
                action = in.readUTF();
                System.out.println("Resp:!" + action);
                ArrayList<String> data = new ArrayList<>();
                data = dBCategory.category();
                out.writeUTF(String.valueOf(data.size()));
                outObject = new ObjectOutputStream(socket.getOutputStream());
                for (int i = 0; i < data.size(); i++) {

                    outObject.writeObject(data.get(i));

                }
            } else if (action.equals("fill_dish")) {

                out.writeUTF("Cargando ...");
                action = in.readUTF();
                System.out.println("Resp:!" + action);
                ArrayList<Object[]> data = new ArrayList<>();
                data = dBDish.fillTableDish();
                out.writeUTF(String.valueOf(data.size()));
                outObject = new ObjectOutputStream(socket.getOutputStream());
                for (int i = 0; i < data.size(); i++) {

                    outObject.writeObject(data.get(i));

                }
            } else if (action.equals("fill_dish_search")) {

                out.writeUTF("Cargando ...");
                action = in.readUTF();
                System.out.println("Respuesta:!" + action);
                ArrayList<Object[]> data = new ArrayList<>();
                data = dBDish.fillTableDishSearch(String.valueOf(in.readUTF()));
                out.writeUTF(String.valueOf(data.size()));
                outObject = new ObjectOutputStream(socket.getOutputStream());
                for (int i = 0; i < data.size(); i++) {

                    outObject.writeObject(data.get(i));

                }
            } else if (action.equals("fill_dish_menu")) {

                out.writeUTF("Cargando ...");
                action = in.readUTF();
                System.out.println("Respuesta:!" + action);
                ArrayList<Object[]> data = new ArrayList<>();
                data = dBDish.fillTableDishMenu(String.valueOf(in.readUTF()));
                out.writeUTF(String.valueOf(data.size()));
                outObject = new ObjectOutputStream(socket.getOutputStream());
                for (int i = 0; i < data.size(); i++) {

                    outObject.writeObject(data.get(i));

                }
            } else if (action.equals("create_dish")) {

                out.writeUTF("Creando ...");
                System.out.println("Creando ...");
                action = in.readUTF();
                Dish dish = jsonConverter.fromJson(action, Dish.class);
                if (dBDish.addDish(dish)) {
                    out.writeUTF("OK");
                    System.out.println("Creado con Éxito");
                } else {
                    out.writeUTF("error");
                    System.out.println("Error al Crear");
                }

            } else if (action.equals("update_dish")) {

                out.writeUTF("Actualizando ...");
                System.out.println("Actualizando ...");
                action = in.readUTF();
                Dish dish = jsonConverter.fromJson(action, Dish.class);
                if (dBDish.updateDish(dish)) {
                    out.writeUTF("OK");
                    System.out.println("Creado con Éxito");
                } else {
                    out.writeUTF("error");
                    System.out.println("Error al Crear");
                }

            } else if (action.equals("delete_dish")) {

                out.writeUTF("Eliminando ...");
                System.out.println("Eliminando ...");
                action = in.readUTF();
                if (dBDish.deleteDish(Integer.parseInt(action))) {
                    out.writeUTF("OK");
                    System.out.println("Eliminado con Éxito");
                } else {
                    out.writeUTF("error");
                    System.out.println("Error al Eliminar");
                }
            } else if (action.equals("order_number")) {

                out.writeUTF("Cargando ...");
                int data = -1;
                data = dBOrder.idOrder();
                out.writeUTF(String.valueOf(data));

            } else if (action.equals("create_order")) {

                out.writeUTF("Creando ...");
                System.out.println("Creando ...");
                action = in.readUTF();
                Order order = jsonConverter.fromJson(action, Order.class);
                if (dBOrder.addOrder(order)) {
                    out.writeUTF("OK");
                    System.out.println("Creado con Éxito");
                } else {
                    out.writeUTF("error");
                    System.out.println("Error al Crear");
                }

            } else if (action.equals("create_charge")) {

                out.writeUTF("Creando ...");
                System.out.println("Creando ...");
                action = in.readUTF();
                Charge charge = jsonConverter.fromJson(action, Charge.class);
                if (dBCharge.addCharge(charge)) {
                    out.writeUTF("OK");
                    System.out.println("Creado con Éxito");
                } else {
                    out.writeUTF("error");
                    System.out.println("Error al Crear");
                }

            } else if (action.equals("client_gender")) {

                out.writeUTF("Cargando ...");
                action = in.readUTF();
                System.out.println("Identificacion:!" + action);
                String data = "";
                data = dBClient.clientGender(Integer.parseInt(action));
                out.writeUTF(data);

            } else if (action.equals("order_hold")) {

                out.writeUTF("Cargando ...");
                action = in.readUTF();
                System.out.println("Resp:!" + action);
                ArrayList<Object[]> data = new ArrayList<>();
                data = dBOrder.fillTableOrder();
                out.writeUTF(String.valueOf(data.size()));
                outObject = new ObjectOutputStream(socket.getOutputStream());
                for (int i = 0; i < data.size(); i++) {

                    outObject.writeObject(data.get(i));

                }
            } else if (action.equals("server_state")) {

                out.writeUTF("OK");

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
