package pt.atec.network;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Userpl022pc19
 */
public class DrClient {
    
    private final int PORTO = 9983;
    private final String IP = "192.168.0.54";
    
    Socket s;
    
    DataInputStream din;
    DataOutputStream dout;
    
    BufferedReader br;
    
    String msgin="", msgout="";

    public DrClient() {
        try{
            
            s = new Socket(IP,PORTO);
            
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            
            while(!msgin.equals("fim")){
                msgin = din.readUTF();
                System.out.println(msgin);
                msgout = br.readLine();
                dout.writeUTF(msgout);
                dout.flush();
            }
            s.close();
            
        }catch(Exception e){
            
        }
    }
    
}
