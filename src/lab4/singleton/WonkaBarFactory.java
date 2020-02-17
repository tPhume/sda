package lab4.singleton;

public class WonkaBarFactory implements Factory {
	private int counter=0;
	
	private volatile static WonkaBarFactory uniqueInstance; // = new WonkaBarFactory();
	
	private WonkaBarFactory() {
	}
	
	public synchronized Bar create(int id) {
		Bar bar = new WonkaBar(counter++);
		System.out.println(id+ " creates new Wonka bar created with id:" + counter);
		return bar;
	}
	
	
	public static synchronized WonkaBarFactory getInstance() {
		if (uniqueInstance==null) {
			synchronized (WonkaBarFactory.class){
				uniqueInstance= new WonkaBarFactory();
			}
		}
		return uniqueInstance;
   }
}
