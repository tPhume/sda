package lab3.tree;

public class Test_tree {
    public static void main(String[] args) {
		Tree mytree = new Fraser();
		mytree = new Star(mytree);
		mytree = new Ruffles(mytree);
		mytree = new Star(mytree);
		mytree = new BallsRed(mytree);
		mytree = new Leds(mytree);
		printtree(mytree);
	}

	public static void printtree(Tree mytree) {
		System.out.println(mytree.getDescription() + " costs: " + mytree.cost());
	}
}
