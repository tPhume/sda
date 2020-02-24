import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SunnySide extends CookEgg {

	protected void prepareEggs() { System.out.println("Never stir sunny side up!"); }
	protected void cook() { System.out.println("Cooking the eggs sunny side up."); }
	protected void addCondiments() { System.out.println("Adding Salt and pepper into SunnySide"); }

	public boolean customerWantsCondiments() {
		String answer = getUserInput();
		if (answer.toLowerCase().startsWith("y")) { return true;}
		else {return false;	}
	}
	private String getUserInput() {
		String answer = null;
		System.out.print("Would you like salt and pepper with your SunnySide (y/n)? ");
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
