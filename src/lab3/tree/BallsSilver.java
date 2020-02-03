package lab3.tree;

public class BallsSilver extends TreeDecorator {
    public BallsSilver(Tree tree) {
        this.tree = tree;
    }

    public String getDescription() {
        return tree.getDescription() + ", Balls Silver";
    }

    public double cost() {
        return 3 + tree.cost();
    }
}
