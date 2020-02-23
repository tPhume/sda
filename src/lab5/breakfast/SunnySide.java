package lab5.breakfast;

import java.util.Scanner;

public class SunnySide extends Breakfast {
    public void crackEggs(int n) {
        System.out.println("Cracking " + n + " eggs.");
    }

    public void prepareEggs() {
        System.out.println("Never stir sunny side up!");
    }

    public void cooking() {
        System.out.println("Cooking the eggs sunny side up.");
    }

    public void serve() {
        System.out.println("Placing the eggs on a plate");
    }

    @Override
    boolean withSaltAndPepper() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("[Would you like some salt and pepper to go with your sunny side?]: ");
        String answer = scanner.nextLine();

        return answer.equals("yes");
    }
}
