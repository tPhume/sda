package lab4.slot;

public class SlotMachineApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SlotFactory njFactory = new NJSlotFactory();
		SlotFactory nvFactory = new NVSlotFactory();

		Slot slot1 = njFactory.orderSlot("bonus");
		System.out.println("Taj Mahal ordered a " + slot1 + "\n");

		Slot slot2 = njFactory.orderSlot("progressive");
		System.out.println("Peppermill ordered a " + slot2 + "\n");

		Slot slot3 = nvFactory.orderSlot("straight");
		System.out.println("BostonBoy ordered a " + slot3 + "\n");
	}
}
