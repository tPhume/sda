import java.io.*;

public class Omelette extends CookEgg {
	public void prepareEggs() {
		System.out.println("Stirring the eggs");
	}
	public void cook() {
		System.out.println("Flipping the omelette while cooking");
	}
	void addCondiments() { System.out.println("Adding Salt and pepper into Omelette"); }

	public boolean customerWantsCondiments() {
		String answer = getUserInput();
		if (answer.toLowerCase().startsWith("y")) { return true;}
		else {return false;	}
	}
	private String getUserInput() {
		String answer = null;
		System.out.print("Would you like salt and pepper with your omelette (y/n)? ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer = in.readLine();
		} catch (IOException ioe) {
			System.err.println("IO error trying to read your answer");
		}
		if (answer == null) {
			return "no";
		}
		return answer;
	}
}
