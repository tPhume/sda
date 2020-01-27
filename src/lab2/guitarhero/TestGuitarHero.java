package lab2.guitarhero;

public class TestGuitarHero {

    public static void main(String[] args) {
        GameCharacter player1 = new GameCharacterSlash();

        System.out.println("---- Playing Guitar ----");
        player1.playGuitar();

        System.out.println("---- Playing Solo ----");
        player1.playSolo();

        System.out.println("---- Playing Guitar ----");
        player1.playGuitar();
    }
}

