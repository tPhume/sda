public class OompaloompaBarfactory implements Factory {
    private int counter=0;

    private volatile static OompaloompaBarfactory uniqueInstance; // = new OompaloompaBarfactory();

    private OompaloompaBarfactory() {
    }

    public synchronized Bar create(int id) {
        Bar bar = new OompaloompaBar(counter++);
        System.out.println(id+ " creates new Oompaloompa bar created with id:" + counter);
        return bar;
    }

    public static synchronized OompaloompaBarfactory getInstance() {
        if (uniqueInstance==null) {
            synchronized (OompaloompaBarfactory.class){
                uniqueInstance= new OompaloompaBarfactory();
            }
        }
        return uniqueInstance;
    }
}
