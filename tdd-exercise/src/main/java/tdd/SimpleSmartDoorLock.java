package tdd;

public class SimpleSmartDoorLock implements SmartDoorLock {
    private final int NO_PIN = -1;
    private final int MAX_ATTEMPTS = 3;

    private int pin;        // forse sarebbe meglio utilizzare il tipo String per le 4 cifre
    private boolean open;   // forse andrebbe considerato anche lo stato open/close per le operazioni lock e unlock
    private boolean locked;
    private boolean blocked;
    private int failedAttempts;

    public SimpleSmartDoorLock() {
        initState();
    }

    private void initState() {
        this.pin = NO_PIN;
        //this.open = false;
        this.locked = false;
        this.blocked = false;
        this.failedAttempts = 0;
    }

    // gestire eventualmente
    private boolean checkFourDigitPin(String fourDigitPin) {
        return (fourDigitPin.length() == 4);
    }

    private void convertPin(String fourDigitPin) {
        try {
            this.pin = Integer.parseInt(fourDigitPin);
        } catch (Exception e) {
            // do something
        }
    }

    public boolean checkPinFormat(int pin) {
        return (0 <= pin && pin <= 9999);
    }

    private boolean isCorrectPin(int pin) {
        return this.pin == pin;
    }

    public boolean isNoPin() {
        return this.pin == this.NO_PIN;
    }
/*
    public boolean isOpen() {
        return this.open;
    }

    public void open() {
        if (!isOpen() && !isLocked()) {
            this.open = true;
        }
    }

    public void close() {
        this.open = false;
    }
*/
    @Override
    public void setPin(int pin) {
        if (!isLocked() && !isBlocked() && checkPinFormat(pin)) {
            this.pin = pin;
        }
    }

    @Override
    public void unlock(int pin) {
        boolean _locked = isLocked();
        boolean _blocked = isBlocked();
        boolean _checked = checkPinFormat(pin);


        if (isLocked() && !isBlocked() && checkPinFormat(pin)) {
            if (isCorrectPin(pin)) {
                this.initState();
            } else {
                this.failedAttempts++;
                if (this.failedAttempts > this.MAX_ATTEMPTS) {
                    this.blocked = true;
                }
            }
        }
    }

    @Override
    public void lock() { // forse sarebbe meglio prevedere il pin come parametro
        if (!this.isNoPin()) {
            this.locked = true;
        } else {
            //System.out.println("Exception: Missing Pin!");
            throw new IllegalStateException("Missing Pin!");
        }
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isBlocked() {
        return this.blocked;
    }

    @Override
    public int getMaxAttempts() {
        return this.MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {
        this.initState();
    }
}
