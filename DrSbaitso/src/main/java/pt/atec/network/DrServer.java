package pt.atec.network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Userpl022pc19
 */
public class DrServer {
    
    private final int PORTO = 9983;
    
    PrintWriter out;
    BufferedReader in;
    
    OutputStream os;
    InputStream is;

    public DrServer() {

        try {
            ServerSocket ssoc = new ServerSocket(PORTO);
            
            Socket client = ssoc.accept();

            os = client.getOutputStream();
            is = client.getInputStream();
            
           /* byte b = (byte) 133;
            os.write(b);
            
            byte bin = (byte) is.read();*/
            
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
           
           for(int i = 0; i < arb.size()-1; i++){
               b[i] = arb.get(i);
           }
            
            /*System.out.println("Byte Recebido: " + bin);
            JOptionPane.showMessageDialog(null, "O número foi: " + bin);*/

            /*out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String inputLine, outputLine;

        try {
            out.println("bom dia");
            
            inputLine = in.readLine();

            System.out.println(inputLine);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
