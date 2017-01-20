package pt.atec.network;

import java.io.*;
import java.net.*;

public class DrServer {

    private final int PORTO = 9983;

    public DrServer() {

        try {
            ServerSocket ssoc = new ServerSocket(PORTO);
            Socket sock = ssoc.accept();

            DataInputStream din = new DataInputStream(sock.getInputStream());
            DataOutputStream dout = new DataOutputStream(sock.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
            String msgin = "", msgout = "";

            while (!msgin.equals("fim")) {
                msgin = din.readUTF();
                System.out.println(msgin);
                //msgout = br.readLine();
                dout.writeUTF(msgout);
                dout.flush();
            }

            sock.close();

        } catch (Exception e) {

        }

    }

}
