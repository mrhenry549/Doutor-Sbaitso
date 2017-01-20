package pt.atec.network;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class DrServer {
    
    private final int PORTO = 9983;
    
    ServerSocket ssoc;
    Socket sock;
    
    DataInputStream din;
    DataOutputStream dout;
    
    BufferedReader br;
    
    String msgin="", msgout="";

    public DrServer() {

        try{
            ssoc = new ServerSocket(PORTO);
            sock = ssoc.accept();
            
            din = new DataInputStream(sock.getInputStream());
            dout = new DataOutputStream(sock.getOutputStream());
            
            br = new BufferedReader(new InputStreamReader(System.in));
            
            while(!msgin.equals("fim")){
                msgin = din.readUTF();
                System.out.println(msgin);
                msgout = br.readLine();
                dout.writeUTF(msgout);
                dout.flush();
            }
            
            sock.close();
            
        }catch(Exception e){
            
        }
        
    }
    
}
