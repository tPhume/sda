package lab4.slot;

public class NVSlotComponentFactory implements SlotComponentFactory {
	private String type;

	public void setType(String type) {
		this.type = type;
	}

	public Cabinet createCabinet() {
		if (type.equals("straight")) {
			return new CabinetLarge();
		} else if (type.equals("bonus")) {
			return new CabinetSmall();
		} else if (type.equals("progressive")) {
			return new CabinetMedium();
		} else {
			return null;
		}
	}

	@Override
	public Payment createPayment() {
		if (type.equals("straight")) {
			return new PaymentTicketinticketout();
		} else if (type.equals("bonus")) {
			return new PaymentTicketinticketout();
		} else if (type.equals("progressive")) {
			return new PaymentTicketinticketout();
		} else {
			return null;
		}
	}

	public Display createDisplay() {
		if (type.equals("straight")) {
			return new DisplayReels();
		} else if (type.equals("bonus")) {
			return new DisplayCRT();
		} else if (type.equals("progressive")) {
			return new DisplayLCD();
		} else {
			return null;
		}
	}

	@Override
	public Gpu createGPU() {
		if (type.equals("straight")) {
			return new GpuARM();
		} else if (type.equals("bonus")) {
			return new GpuX86();
		} else if (type.equals("progressive")) {
			return new GpuX77();
		} else {
			return null;
		}
	}

	@Override
	public Os createOS() {
		if (type.equals("straight")) {
			return new OsLinux();
		} else if (type.equals("bonus")) {
			return new OsLinux();
		} else if (type.equals("progressive")) {
			return new OsAndroid();
		} else {
			return null;
		}
	}
}
