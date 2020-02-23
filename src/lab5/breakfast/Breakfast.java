package lab5.breakfast;

public abstract class Breakfast {
    abstract void crackEggs(int numEggs);

    abstract void prepareEggs();

    abstract void cooking();

    abstract void serve();

    boolean withSaltAndPepper() {
        return false;
    }

    public final void makeBreakfast(int numEggs) {
        crackEggs(numEggs);
        prepareEggs();

        if (withSaltAndPepper()) {
            System.out.println("Adding salt and pepper");
        } else {
            System.out.println("Not adding salt and pepper");
        }

        cooking();
        serve();

        System.out.println();
    }
}
