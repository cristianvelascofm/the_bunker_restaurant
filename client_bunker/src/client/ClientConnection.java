package client;

import model.Client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import com.google.gson.Gson;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Employee;

public class ClientConnection {

    private final String ipServer;
    private final int portServer;
    private DataInputStream inMsg;// leer del canal la respuesta
    private DataOutputStream outMsg;// escribir en el canal de envío
    private Socket socket;

    private ObjectOutputStream outObject;
    private ObjectInputStream inObject;

    public ClientConnection(String ipServer, int portServer) {
        this.ipServer = ipServer;
        this.portServer = portServer;
    }

    public void createConnectionMsg() throws IOException {

        socket = new Socket(ipServer, portServer);
        inMsg = new DataInputStream(socket.getInputStream());
        outMsg = new DataOutputStream(socket.getOutputStream());

    }

    public void createConnectionObject() throws IOException {

        socket = new Socket(ipServer, portServer);
        inObject = new ObjectInputStream(socket.getInputStream());
        outObject = new ObjectOutputStream(socket.getOutputStream());
    }

    public void closeConnection() throws IOException {
        socket.close();
    }

    public float sendData(float numero1, float numero2, String operacion) {

        float ans = 0;

        try {
            outMsg.writeUTF(operacion);
            outMsg.writeFloat(numero1);
            outMsg.writeFloat(numero2);
            ans = inMsg.readFloat();
        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
        }

        return ans;
    }

    public boolean createClient(Client client) {
        Gson jsonConverter = new Gson();
        String ans = "";

        String JSON = jsonConverter.toJson(client);

        try {
            outMsg.writeUTF("create_client");
            ans = inMsg.readUTF();
            System.out.println("Respuesta: " + ans);
            outMsg.writeUTF(JSON);
            System.out.println("Mensaje a enviar: " + JSON);
            ans = inMsg.readUTF();

            if (ans.equals("OK")) {
                System.out.println("Ans; " + ans);
                return true;
            } else {
                return false;
            }

        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
            return false;
        }
    }

    public boolean updateClient(Client client) {
        Gson jsonConverter = new Gson();
        String ans = "";

        String JSON = jsonConverter.toJson(client);

        try {
            outMsg.writeUTF("update_client");
            ans = inMsg.readUTF();
            System.out.println("Respuesta: " + ans);
            outMsg.writeUTF(JSON);
            System.out.println("Mensaje a enviar: " + JSON);
            ans = inMsg.readUTF();
            if (ans.equals("OK")) {
                System.out.println("Ans; " + ans);
                return true;
            } else {
                return false;
            }
        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
            return false;
        }

    }

    public ArrayList<Object[]> fillClient() throws IOException, ClassNotFoundException {
        String ans = "";
        try {
            outMsg.writeUTF("fill_client");
            ans = inMsg.readUTF();
            System.out.println("Respuesta: " + ans);
            outMsg.writeUTF("ok...");

            ArrayList<Object[]> data = new ArrayList<>();
            int numdata = Integer.parseInt(inMsg.readUTF());
            System.out.println("Numero de datos: " + numdata);
            inObject = new ObjectInputStream(socket.getInputStream());
            for (int i = 0; i < numdata; i++) {

                data.add((Object[]) inObject.readObject());

            }
            System.out.println("Datos Cliente: " + data.toString());
            return data;

        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
            return null;

        }

    }

    public ArrayList<Object[]> fillClientSearch(String search) throws IOException, ClassNotFoundException {
        String ans = "";
        try {
            outMsg.writeUTF("fill_client_search");
            ans = inMsg.readUTF();
            System.out.println("Respuesta: " + ans);
            outMsg.writeUTF("ok...");
            outMsg.writeUTF(search);

            ArrayList<Object[]> data = new ArrayList<>();
            int numdata = Integer.parseInt(inMsg.readUTF());
            System.out.println("Numero de datos: " + numdata);
            inObject = new ObjectInputStream(socket.getInputStream());
            for (int i = 0; i < numdata; i++) {

                data.add((Object[]) inObject.readObject());

            }
            System.out.println("Datos Cliente: " + data.toString());
            return data;

        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
            return null;

        }

    }

    public boolean deleteClient(String id) {
        String ans = "";
        try {
            outMsg.writeUTF("delete_client");
            ans = inMsg.readUTF();
            System.out.println("Respuesta: " + ans);
            outMsg.writeUTF(id);
            if (inMsg.readUTF().equals("OK")) {
                return true;
            } else {
                return false;
            }

        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
            return false;

        }

    }

    public boolean createEmployee(Employee employee) {
        Gson jsonConverter = new Gson();
        String ans = "";

        String JSON = jsonConverter.toJson(employee);

        try {
            outMsg.writeUTF("create_employee");
            ans = inMsg.readUTF();
            System.out.println("Respuesta: " + ans);
            outMsg.writeUTF(JSON);
            System.out.println("Mensaje a enviar: " + JSON);
            ans = inMsg.readUTF();

            if (ans.equals("OK")) {
                System.out.println("Ans; " + ans);
                return true;
            } else {
                return false;
            }

        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
            return false;
        }
    }

    public boolean updateEmployee(Employee employee) {
        Gson jsonConverter = new Gson();
        String ans = "";

        String JSON = jsonConverter.toJson(employee);

        try {
            outMsg.writeUTF("update_employee");
            ans = inMsg.readUTF();
            System.out.println("Respuesta: " + ans);
            outMsg.writeUTF(JSON);
            System.out.println("Mensaje a enviar: " + JSON);
            ans = inMsg.readUTF();
            if (ans.equals("OK")) {
                System.out.println("Ans; " + ans);
                return true;
            } else {
                return false;
            }
        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
            return false;
        }

    }

    public ArrayList<Object[]> fillEmployee() throws IOException, ClassNotFoundException {
        String ans = "";
        try {
            outMsg.writeUTF("fill_employee");
            ans = inMsg.readUTF();
            System.out.println("Respuesta: " + ans);
            outMsg.writeUTF("ok...");

            ArrayList<Object[]> data = new ArrayList<>();
            int numdata = Integer.parseInt(inMsg.readUTF());
            System.out.println("Numero de datos: " + numdata);
            inObject = new ObjectInputStream(socket.getInputStream());
            for (int i = 0; i < numdata; i++) {

                data.add((Object[]) inObject.readObject());

            }
            return data;

        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
            return null;

        }

    }

    public ArrayList<Object[]> fillEmployeeSearch(String search) throws IOException, ClassNotFoundException {
        String ans = "";
        try {
            outMsg.writeUTF("fill_employee_search");
            ans = inMsg.readUTF();
            System.out.println("Respuesta: " + ans);
            outMsg.writeUTF("ok...");
            outMsg.writeUTF(search);

            ArrayList<Object[]> data = new ArrayList<>();
            int numdata = Integer.parseInt(inMsg.readUTF());
            System.out.println("Numero de datos: " + numdata);
            inObject = new ObjectInputStream(socket.getInputStream());
            for (int i = 0; i < numdata; i++) {

                data.add((Object[]) inObject.readObject());

            }
            System.out.println("Datos Cliente: " + data.toString());
            return data;

        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
            return null;

        }

    }

    public boolean deleteEmployee(String id) {
        String ans = "";
        try {
            outMsg.writeUTF("delete_employee");
            ans = inMsg.readUTF();
            System.out.println("Respuesta: " + ans);
            outMsg.writeUTF(id);
            if (inMsg.readUTF().equals("OK")) {
                return true;
            } else {
                return false;
            }

        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
            return false;

        }

    }

    public String passwordLogin(String id) {
        String ans = "";
        try {
            outMsg.writeUTF("password");
            ans = inMsg.readUTF();
            System.out.println("Respuesta: " + ans);
            outMsg.writeUTF(id);
            String pass = inMsg.readUTF();
            System.out.println("Contraseña: "+ pass );
            return pass;

        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
            return "";

        }

    }
    
    public String code(String id) {
        String ans = "";
        try {
            outMsg.writeUTF("code");
            ans = inMsg.readUTF();
            System.out.println("Respuesta: " + ans);
            outMsg.writeUTF(id);
            String pass = inMsg.readUTF();
            System.out.println("Código: "+ pass );
            return pass;

        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
            return "";

        }

    }
    
    public String type(String id) {
        String ans = "";
        try {
            outMsg.writeUTF("type");
            ans = inMsg.readUTF();
            System.out.println("Respuesta: " + ans);
            outMsg.writeUTF(id);
            String pass = inMsg.readUTF();
            System.out.println("Tipo: "+ pass );
            return pass;

        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
            return "";

        }

    }
    
    public String name(String id) {
        String ans = "";
        try {
            outMsg.writeUTF("name");
            ans = inMsg.readUTF();
            System.out.println("Respuesta: " + ans);
            outMsg.writeUTF(id);
            String pass = inMsg.readUTF();
            System.out.println("Nombre: "+ pass );
            return pass;

        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
            return "";

        }

    }
    
    public String lastName(String id) {
        String ans = "";
        try {
            outMsg.writeUTF("last_name");
            ans = inMsg.readUTF();
            System.out.println("Respuesta: " + ans);
            outMsg.writeUTF(id);
            String pass = inMsg.readUTF();
            System.out.println("Apellido: "+ pass );
            return pass;

        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
            return "";

        }

    }
    public String state(String id) {
        String ans = "";
        try {
            outMsg.writeUTF("state");
            ans = inMsg.readUTF();
            System.out.println("Respuesta: " + ans);
            outMsg.writeUTF(id);
            String pass = inMsg.readUTF();
            System.out.println("Estado: "+ pass );
            return pass;

        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
            return "";

        }

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
