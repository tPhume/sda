package lab2.guitarhero;

public class GameCharacterYoung extends GameCharacter {
    public GameCharacterYoung() {
        guitarBehavior = new Guitar_GibsonSG();
        soloBehavior = new Solo_JumpOffStage();
    }
}
