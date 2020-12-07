package logic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import com.google.gson.Gson;

public class ClientConnection {

    private final String ipServer;
    private final int portServer;
    private DataInputStream inMsg;// leer del canal la respuesta
    private DataOutputStream outMsg;// escribir en el canal de envío
    private Socket socket;

    public ClientConnection(String ipServer, int portServer) {
        this.ipServer = ipServer;
        this.portServer = portServer;
    }

    public void createConnection() throws IOException {

        socket = new Socket(ipServer, portServer);
        inMsg = new DataInputStream(socket.getInputStream());
        outMsg = new DataOutputStream(socket.getOutputStream());
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
    
    
    
    public boolean createClient(Client client){
        Gson objConvertidor= new Gson();
        String ans ="";
        
        String JSON = objConvertidor.toJson(client);
        
        System.out.println("Mensaje a enviar: "+JSON);
        try {
            outMsg.writeUTF(JSON);
            ans = inMsg.readUTF();
            return true;
        } catch (IOException ex) {
            System.out.println("Error al realizar la conexión");
            return false;
        }

        

        /*ClsPersona objConvertido= objConvertidor.fromJson(JSON, ClsPersona.class);
        
        System.out.println("nombres: " + objConvertido.getNombres());
        System.out.println("apellidos: " + objConvertido.getApellidos());        */

    }

}
