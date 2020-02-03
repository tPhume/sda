package lab3.tree;

public class BallsRed extends TreeDecorator {
    public BallsRed(Tree tree) {
        this.tree = tree;
    }

    public String getDescription() {
        return tree.getDescription() + ", Balls Red";
    }

    public double cost() {
        return 1 + tree.cost();
    }
}
