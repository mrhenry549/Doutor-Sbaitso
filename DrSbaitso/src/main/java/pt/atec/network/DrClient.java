package pt.atec.network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Userpl022pc19
 */
public class DrClient {
    
    private final int PORTO = 9983;
    private final String IP = "192.168.0.54";
    
    PrintWriter out;
    BufferedReader in;
    
    OutputStream os;
    InputStream is;

    public DrClient() {

        try {

            Socket ssoc = new Socket(IP, PORTO);
            

            /*out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));*/
            
            os = ssoc.getOutputStream();
            is = ssoc.getInputStream();
            
            String st = "Esta turma é espetacular";
            byte[] bs = st.getBytes();
            
            
            
            os.write(bs);
            
            byte bin = 0;
            ArrayList<Byte> arb = new ArrayList<Byte>();
            
            while (bin >= 0){
                bin = (byte) is.read();
                arb.add(bin);
            }
            
           byte[] b = new byte[arb.size()];
           
           for(int i = 0; i < arb.size(); i++){
               b[i] = arb.get(i);
           }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String inputLine, outputLine;

        //String greet = mind.getGreating();

        try {
            out.println();
            
            inputLine = in.readLine();
            
            System.out.println(inputLine);
            
            System.out.println("Bajule o seu Servidor");
            String msg = (new Scanner(System.in)).nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
