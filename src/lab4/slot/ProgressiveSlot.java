package lab4.slot;

public class ProgressiveSlot extends Slot {
	SlotComponentFactory componentFactory;
	
	public ProgressiveSlot(SlotComponentFactory componentFactory) {
		this.componentFactory= componentFactory;
	}
 
	void build() {
		cabinet = componentFactory.createCabinet();
		payment = componentFactory.createPayment();
		display = componentFactory.createDisplay();
		gpu = componentFactory.createGPU();
		os = componentFactory.createOS();
	}
}
