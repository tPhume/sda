
public class EatBreakfast {
	public static void main(String[] args) {
		ScrambledEggs scrambled = new ScrambledEggs();
		scrambled.prepareRecipie(2);
		System.out.println();
		
		Omelette omelette = new Omelette();
		omelette.prepareRecipie(3);
		System.out.println();
		
		SunnySide sunny = new SunnySide();
		sunny.prepareRecipie(1);
	}
}
