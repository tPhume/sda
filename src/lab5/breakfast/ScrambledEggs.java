package lab5.breakfast;

import java.io.*;
public class ScrambledEggs extends CookEgg {
	protected void prepareEggs() { System.out.println("Stirring and adding milk to the eggs"); }
	protected void cook()  { System.out.println("Scrambling the eggs."); }
	protected void addCondiments() { System.out.println("Adding Salt and pepper into ScrambledEggs"); }

	public boolean customerWantsCondiments() {
		String answer = getUserInput();
		if (answer.toLowerCase().startsWith("y")) { return true;}
		else {return false;	}
	}
	private String getUserInput() {
		String answer = null;
		System.out.print("Would you like salt and pepper with your ScrambledEggs (y/n)? ");
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
