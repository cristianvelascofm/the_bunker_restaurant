package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import dataBase.Connect;

public class MD5 {

    Connect conexion = new Connect();

    public String MD5(String texto) {

        try {
            java.security.MessageDigest mD = java.security.MessageDigest.getInstance("MD5");

            byte[] array = mD.digest(texto.getBytes());
            StringBuilder sB = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                sB.append(Integer.toHexString((array[i] & 0xFF) | 0X100).substring(1, 3));

            }
            return sB.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println("Error al Encriptar: "+e);

        }
        return null;
    }
    
    
    public String admin(String admin){
        String cod = MD5(admin);
        return cod;
    }
     
    
    
    public  String getMotherboardSN() {
    String result = "";
    try {
      File file = File.createTempFile("realhowto",".vbs");
      file.deleteOnExit();
      //FileWriter fw = new java.io.FileWriter(file);
      FileWriter fw = new java.io.FileWriter(file);

      String vbs =
         "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
        + "Set colItems = objWMIService.ExecQuery _ \n"
        + "   (\"Select * from Win32_BaseBoard\") \n"
        + "For Each objItem in colItems \n"
        + "    Wscript.Echo objItem.SerialNumber \n"
        + "    exit for  ' do the first cpu only! \n"
        + "Next \n";

      fw.write(vbs);
      fw.close();
      Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
      BufferedReader input =
        new BufferedReader
          (new InputStreamReader(p.getInputStream()));
      String line;
      while ((line = input.readLine()) != null) {
         result += line;
      }
      input.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
    
    return result.trim();
  }
    
    
    
    
    
        
    }
