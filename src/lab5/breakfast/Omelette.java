package lab5.breakfast;

import java.util.Scanner;

public class Omelette extends Breakfast {
    public void crackEggs(int numOfEggs) {
        System.out.println("Cracking " + numOfEggs + "eggs");
    }

    public void prepareEggs() {
        System.out.println("Stirring the eggs");
    }

    public void cooking() {
        System.out.println("Flipping the omelette while cooking");
    }

    public void serve() {
        System.out.println("Putting the eggs on the plate");
    }

    @Override
    boolean withSaltAndPepper() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("[Would you like some salt and pepper to go with your omelette?]: ");
        String answer = scanner.nextLine();

        return answer.equals("yes");
    }
}
