package lab5.breakfast;

import java.util.Scanner;

public class ScrambledEggs extends Breakfast {
    public void crackEggs(int num) {
        System.out.println("Cracking " + num + " eggs");
    }

    public void prepareEggs() {
        System.out.println("Stirring and adding milk to the eggs");
    }

    public void cooking() {
        System.out.println("Scrambling the eggs.");
    }

    public void serve() {
        System.out.println("Placing the eggs on the plate.");
    }

    @Override
    boolean withSaltAndPepper() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("[Would you like some salt and pepper to go with your scrambled eggs?]: ");
        String answer = scanner.nextLine();

        return answer.equals("yes");
    }
}
