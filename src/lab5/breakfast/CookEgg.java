package lab5.breakfast;

public abstract class CookEgg {
    final void prepareRecipie(int numOfEggs){
        crackEggs(numOfEggs);
        prepareEggs();
        cook();
        serve();
        if(customerWantsCondiments()){
            addCondiments();
        }
    }

    abstract void addCondiments();
    abstract void cook();
    abstract void prepareEggs();
    void crackEggs(int numOfEggs) {
        System.out.println("Cracking " + numOfEggs +  "eggs");
    }
    void serve() {
        System.out.println("Putting the eggs on the plate");
    }
    boolean customerWantsCondiments() {
        return true;
    }
}
