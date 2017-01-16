package pt.atec.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import pt.atec.drsbaitso.Inteligence;

public class DrServer {

    private final int PORTO = 9983;
    
    PrintWriter out;
    BufferedReader in;
    Inteligence mind;
    String inputLine, outputLine, msg;
    int num = 1;

    public DrServer() {
        mind = new Inteligence();
        
        String greet = mind.getGreeting();

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
            while(num != 0){
                inputLine = in.readLine();

                System.out.println(inputLine);

                msg = (new Scanner(System.in)).nextLine();

                out.println(msg);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
