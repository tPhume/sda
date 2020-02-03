package lab3.slot;

public class NJSlotProgressive extends Slot {
	public NJSlotProgressive() {
		name="NJ Progressive";
		software = "Windows XP";
		components.add("Small");
		components.add("bills");
		components.add("CRT");
		components.add("X86");
	}
	
	void ship() {
		System.out.println("having uncle vinnie drop it off");
	}
}
