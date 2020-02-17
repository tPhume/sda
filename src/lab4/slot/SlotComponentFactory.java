package lab4.slot;

public interface SlotComponentFactory {
	public Cabinet createCabinet();
	public Payment createPayment();
    public Display createDisplay();
	public Gpu createGPU();
	public Os createOS();
}
