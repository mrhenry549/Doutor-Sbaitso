package pt.atec.drsbaitso;

//import java.util.ArrayList;
import java.util.Random;

public class Inteligence {

    String[] frasesG, frasesCT;

    public Inteligence() {
        frasesG = new String[]{"Hello", "My name is Sbaitso", "I'm here to help you"};
        frasesCT = new String[]{"Did you know stuff", "Great!", "Ohhh... did he?", "Actually I'm just a Computer"};
    }

    public String getGreeting() {
        return frasesG[new Random().nextInt(frasesG.length - 1)];
    }

    public String getCheapTalk() {
        return frasesCT[new Random().nextInt(frasesCT.length - 1)];
    }

    public String sayAbout(String other) {
        return getCheapTalk() + "! Do you think " + other + "? OK... Please continue";
    }
}
