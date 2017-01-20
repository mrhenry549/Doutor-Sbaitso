package pt.atec.network;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class DrClient {

    private final int PORTO = 9983;
    private final String IP = "192.168.250.250";

    public DrClient() {
        try {

            Socket sock = new Socket(IP, PORTO);

            DataInputStream din = new DataInputStream(sock.getInputStream());
            DataOutputStream dout = new DataOutputStream(sock.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String msgin = "", msgout = "";

            while (!msgin.equals("fim")) {
                msgout = br.readLine();
                dout.writeUTF(msgout);
                msgin = din.readUTF();
                System.out.println(msgin);
            }
            sock.close();

        } catch (Exception e) {

        }
    }

}
