package lab3.tree;

public class BallsBlue extends TreeDecorator {
    public BallsBlue(Tree tree) {
        this.tree = tree;
    }

    public String getDescription() {
        return tree.getDescription() + ", Balls Blue";
    }

    public double cost() {
        return 2 + tree.cost();
    }
}