package lab2.guitarhero;

public class Solo_SmashGuitar implements SoloBehavior {
    @Override
    public boolean solo() {
        System.out.println("smash guitar");
        return false;
    }
}
