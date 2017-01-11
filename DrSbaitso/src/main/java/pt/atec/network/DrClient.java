package pt.atec.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import pt.atec.drsbaitso.Inteligence;

public class DrClient {

    private final int PORTO = 9983;
    private final String IP = "192.168.250.132";
    
    PrintWriter out;
    BufferedReader in;
    Inteligence mind;

    public DrClient() {
        mind = new Inteligence();

        try {

            Socket socket = new Socket(IP, PORTO);

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
