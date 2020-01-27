package lab2.guitarhero;

import java.util.Scanner;

public abstract class GameCharacter {
    GuitarBehavior guitarBehavior;
    SoloBehavior soloBehavior;

    public GameCharacter() {
    }

    public void playGuitar() {
        guitarBehavior.play();
    }

    public void playSolo() {
        boolean goodCondition = soloBehavior.solo();
        if (!goodCondition) {
            change();
        }
    }

    public void setGuitar(GuitarBehavior g) {
        this.guitarBehavior = g;
    }

    public void setSolo(SoloBehavior s) {
        this.soloBehavior = s;
    }

    public void change() {
        System.out.println("Choose new guitar:\n[0] GibsonLesPaul\n[1] GibsonSG\n[2] Telecaster");

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        switch (s) {
            case "0":
                this.guitarBehavior = new Guitar_GibsonLesPaul();
                break;
            case "1":
                this.guitarBehavior = new Guitar_GibsonSG();
                break;
            case "2":
                this.guitarBehavior = new Guitar_Telecaster();
                break;
        }
    }
}