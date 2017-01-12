package pt.atec.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import pt.atec.drsbaitso.Inteligence;

public class DrServer {

    private final int PORTO = 9975;
    
    PrintWriter out;
    BufferedReader in;
    Inteligence mind;
    String inputLine, outputLine;
    
    String greet = mind.getGreeting();

    public DrServer() {
        mind = new Inteligence();

        try {
            ServerSocket ssoc = new ServerSocket(PORTO);

            Socket client = ssoc.accept();

            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            out.println("bom dia");
            
            inputLine = in.readLine();

            System.out.println(inputLine);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
