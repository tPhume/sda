package lab3.slot;

public class TestSlots {
	public static void main(String[] args) {
		SlotStore NVStore = new NVSlotStore();
		SlotStore NJStore = new NJSlotStore();
		SlotStore WAStore = new WASlotStore();


		System.out.println("-----------ORDERING FROM NVSTORE-----------");
		Slot slot = NVStore.orderSlot(slottype.straight);
		System.out.println("Beckham ordered a "+ slot.getName());

		slot = NVStore.orderSlot(slottype.bonus);
		System.out.println("Boyega ordered a "+ slot.getName());

		slot = NVStore.orderSlot(slottype.progressive);
		System.out.println("Scott ordered a "+ slot.getName());

		System.out.println("\n\n-----------ORDERING FROM NJSTORE-----------");
		slot = NJStore.orderSlot(slottype.straight);
		System.out.println("Taj Mahal ordered a "+ slot.getName());

		slot = NJStore.orderSlot(slottype.bonus);
		System.out.println("Borgata ordered a "+ slot.getName());

		slot = NJStore.orderSlot(slottype.progressive);
		System.out.println("John ordered a "+ slot.getName());

		System.out.println("\n\n-----------ORDERING FROM WASTORE-----------");
		slot = WAStore.orderSlot(slottype.straight);
		System.out.println("Andrew ordered a "+ slot.getName());

		slot = WAStore.orderSlot(slottype.bonus);
		System.out.println("Bill ordered a "+ slot.getName());

		slot = WAStore.orderSlot(slottype.progressive);
		System.out.println("Proton ordered a "+ slot.getName());
	}

}
