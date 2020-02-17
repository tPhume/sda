package lab4.slot;

public class WASlotComponentFactory implements SlotComponentFactory {
    private String type;

    public WASlotComponentFactory(String type) {
        this.type = type;
    }

    public Cabinet createCabinet() {
        if (type.equals("straight")) {
            return new CabinetLarge();
        } else if (type.equals("bonus")) {
            return new CabinetMedium();
        } else if (type.equals("progressive")) {
            return new CabinetLarge();
        } else {
            return null;
        }
    }

    @Override
    public Payment createPayment() {
        if (type.equals("straight")) {
            return new PaymentBills();
        } else if (type.equals("bonus")) {
            return new PaymentTicketinticketout();
        } else if (type.equals("progressive")) {
            return new PaymentCoins();
        } else {
            return null;
        }
    }

    public Display createDisplay() {
        if (type.equals("straight")) {
            return new DisplayReels();
        } else if (type.equals("bonus")) {
            return new DisplayVGA();
        } else if (type.equals("progressive")) {
            return new DisplayReels();
        } else {
            return null;
        }
    }

    @Override
    public Gpu createGPU() {
        if (type.equals("straight")) {
            return new GpuARM();
        } else if (type.equals("bonus")) {
            return new GpuARM();
        } else if (type.equals("progressive")) {
            return new GpuARM();
        } else {
            return null;
        }
    }

    @Override
    public Os createOS() {
        if (type.equals("straight")) {
            return new OsLinux();
        } else if (type.equals("bonus")) {
            return new OsSymbian();
        } else if (type.equals("progressive")) {
            return new OsAndroid();
        } else {
            return null;
        }
    }
}
