package lab4.slot;

public class NJSlotComponentFactory implements SlotComponentFactory {
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public Cabinet createCabinet() {
        if (type.equals("straight")) {
            return new CabinetSmall();
        } else if (type.equals("bonus")) {
            return new CabinetLarge();
        } else if (type.equals("progressive")) {
            return new CabinetSmall();
        } else {
            return null;
        }
    }

    public Payment createPayment() {
        if (type.equals("straight")) {
            return new PaymentCoins();
        } else if (type.equals("bonus")) {
            return new PaymentCoins();
        } else if (type.equals("progressive")) {
            return new PaymentBills();
        } else {
            return null;
        }
    }

    public Display createDisplay() {
        if (type.equals("straight")) {
            return new DisplayLCD();
        } else if (type.equals("bonus")) {
            return new DisplayReels();
        } else if (type.equals("progressive")) {
            return new DisplayCRT();
        } else {
            return null;
        }
    }

    public Gpu createGPU() {
        if (type.equals("straight")) {
            return new GpuARM();
        } else if (type.equals("bonus")) {
            return new GpuARM();
        } else if (type.equals("progressive")) {
            return new GpuX86();
        } else {
            return null;
        }
    }

    public Os createOS() {
        if (type.equals("straight")) {
            return new OsWindowsME();
        } else if (type.equals("bonus")) {
            return new OsWindowsME();
        } else if (type.equals("progressive")) {
            return new OsWindowsXP();
        } else {
            return null;
        }
    }
}
