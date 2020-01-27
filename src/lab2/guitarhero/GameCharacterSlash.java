package lab2.guitarhero;

public class GameCharacterSlash extends GameCharacter {

    public GameCharacterSlash() {
        guitarBehavior = new Guitar_GibsonLesPaul();
        soloBehavior = new Solo_SmashGuitar();
    }
}