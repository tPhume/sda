package lab5.breakfast;

public class EatBreakfast {
    public static void main(String[] args) {
        Omelette omelette = new Omelette();
        ScrambledEggs scramble = new ScrambledEggs();
        SunnySide sunny = new SunnySide();

        omelette.makeBreakfast(5);
        scramble.makeBreakfast(1);
        sunny.makeBreakfast(20);
    }

}
