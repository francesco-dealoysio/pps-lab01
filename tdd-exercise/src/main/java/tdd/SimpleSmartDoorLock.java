package tdd;

public class SimpleSmartDoorLock implements SmartDoorLock {
    private final int NO_PIN = -1;
    private final int MAX_ATTEMPTS = 3;

    private int pin;        // forse si potrebbe utilizzare il tipo String per le 4 cifre
    private boolean locked;
    private boolean blocked;
    private int failedAttempts;

    public SimpleSmartDoorLock() {
        initState();
    }

    private void initState() {
        this.pin = NO_PIN;
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
    public void lock() {
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

    public String toString() {
        String message = "";
        String line = "-".repeat(40);
        String strPin = ("0000" + pin).substring(("0000" + pin).length() - 4);

        message += line + "\n";
        message += "Pin................: " + (pin == -1 ? "-" : strPin) + "\n";
        message += "Locked.............: " + locked + "\n";
        message += "Blocked............: " + blocked + "\n";
        message += "Max unlock attempts: " + MAX_ATTEMPTS + "\n";
        message += "Failed attempts....: " + failedAttempts + "\n";
        message += line;

        return message;
    }

    public static void main(String[] args) {
        int value;
        SimpleSmartDoorLock simpleSmartDoorLock;

        System.out.println("\n - SmartDoorLock created!");
        simpleSmartDoorLock = new SimpleSmartDoorLock();
        System.out.println("" + simpleSmartDoorLock);

        value = 123;
        System.out.println("Executed setPin("+value+")");
        simpleSmartDoorLock.setPin(123);

        System.out.println("Executed lock()");
        simpleSmartDoorLock.lock();
        System.out.println("" + simpleSmartDoorLock);

        value = 123;
        System.out.println("Executed unlock("+value+")");
        simpleSmartDoorLock.unlock(value);
        System.out.println("" + simpleSmartDoorLock);

        value = 256;
        System.out.println("Executed setPin("+value+")");
        simpleSmartDoorLock.setPin(256);

        System.out.println("Executed lock()");
        simpleSmartDoorLock.lock();
        System.out.println("" + simpleSmartDoorLock);

        value = 200;
        System.out.println("Executed unlock("+value+")");
        simpleSmartDoorLock.unlock(value);

        value = 123;
        System.out.println("Executed unlock("+value+")");
        simpleSmartDoorLock.unlock(value);

        value = 257;
        System.out.println("Executed unlock("+value+")");
        simpleSmartDoorLock.unlock(value);

        value = 246;
        System.out.println("Executed unlock("+value+")");
        simpleSmartDoorLock.unlock(value);

        value = 258;
        System.out.println("Executed unlock("+value+")");
        simpleSmartDoorLock.unlock(value);

        System.out.println("" + simpleSmartDoorLock);
    }


}
