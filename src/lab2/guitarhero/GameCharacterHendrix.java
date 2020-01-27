package lab2.guitarhero;

public class GameCharacterHendrix extends GameCharacter {
    boolean broken = false;

    public GameCharacterHendrix() {
        guitarBehavior = new Guitar_Telecaster();
        soloBehavior = new Solo_PutGuitarOnFire();
    }
}

