package Presentacion;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class Connector extends Thread{

    
    Socket sk;
    DataInputStream in;
    DataOutputStream out;
    int id;
    
    
    public Connector(int id){
        this.id = id;
    }
    
    
    @Override
    public void run(){
        try {
            sk= new Socket("127.0.0.1",9000);
            in = new DataInputStream(sk.getInputStream());
            out = new DataOutputStream(sk.getOutputStream());
            System.out.println(id + " envía saludo");
            out.writeUTF("Login");
            //out.writeUTF("hola");
            String respuesta="";
            respuesta = in.readUTF();
            System.out.println(id + " Servidor devuelve saludo: " + respuesta);
            in.close();
            out.close();
            sk.close();
        } catch (IOException e) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    
    
    
   /* Socket cliente;
    int puerto = 9000;
    String ip = "127.0.0.1";
    BufferedReader entrada, teclado;
    PrintStream salida;
    DataInputStream in;
    DataOutputStream out;

    public boolean incio() {
        boolean flag = false;
        try {

            //Creamos el Socket que conecta al Servidor
            cliente = new Socket(ip, puerto);

            String type = FrmPrincipal.txtType.getText();
            String id = FrmPrincipal.txtId.getText();

            in = new DataInputStream(cliente.getInputStream());
            out = new DataOutputStream(cliente.getOutputStream());

            //Enviamos el Mensaje al Servidor
            out.writeUTF("Pedido de: " + type + " " + id);
            //out.writeUTF("¡Nuevo Pedido!");

            //Recibimos el Mensaje en el Servidor
            String msg = in.readUTF();

            System.out.println(msg);
            
            if("Cocinero".equals(type)){
                System.out.println("Tengo el Pedido");
                flag = true;
            }
            
            
            //Cerramos el Socker Abierto
            cliente.close();
            
            return flag;

        } catch (IOException e) {
        }
        return false;

    }
    
    
    public void loginChef(){
        try {

            //Creamos el Socket que conecta al Servidor
            cliente = new Socket(ip, puerto);

            String type = FrmPrincipal.txtType.getText();
            String id = FrmPrincipal.txtId.getText();

            in = new DataInputStream(cliente.getInputStream());
            out = new DataOutputStream(cliente.getOutputStream());

            //Enviamos el Mensaje al Servidor
            out.writeUTF("Conectado: " + type + " " + id);
            //out.writeUTF("¡Nuevo Pedido!");

            //Recibimos el Mensaje en el Servidor
            String msg = in.readUTF();

            System.out.println(msg);
            
            //Cerramos el Socker Abierto
            cliente.close();
            
            

        } catch (IOException e) {
        }
    }

    public void logInServer() {

        try {

            String type = FrmPrincipal.txtType.getText();
            String id = FrmPrincipal.txtId.getText();
            //Creamos el Socket que conecta al Servidor
            cliente = new Socket(ip, puerto);

            in = new DataInputStream(cliente.getInputStream());
            out = new DataOutputStream(cliente.getOutputStream());

            //Enviamos el Mensaje al Servidor
            out.writeUTF("Conectado: " + type + " " + id);

            //Recibimos el Mensaje en el Servidor
            String msg = in.readUTF();

            System.out.println(msg);
            //Cerramos el Socker Abierto
            cliente.close();

        } catch (IOException e) {
        }
    }*/

}
